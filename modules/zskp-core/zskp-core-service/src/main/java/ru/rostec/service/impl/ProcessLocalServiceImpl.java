/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.rostec.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import ru.rostec.model.Process;
import ru.rostec.service.base.ProcessLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.rostec.service.ProcessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessLocalServiceBaseImpl
 * @see ru.rostec.service.ProcessLocalServiceUtil
 */
public class ProcessLocalServiceImpl extends ProcessLocalServiceBaseImpl {

	public Process addProcess(ServiceContext serviceContext, String processName, long processKind, long processType, long userId) {
		long processId = counterLocalService.increment(Process.class.getName());
		Process process = null;
		try {
			User user = userLocalService.getUser(userId);
			process = processLocalService.createProcess(processId);
			process.setName(processName);
			process.setKind(processKind);
			process.setType(processType);
			process.setUserName(user.getFullName());
			process.setCompanyId(serviceContext.getCompanyId());
			process.setGroupId(serviceContext.getScopeGroupId());
			process.setUserId(user.getUserId());

			process.setStatus(WorkflowConstants.STATUS_DRAFT);
			process.setStatusByUserId(user.getUserId());
			process.setStatusDate(new Date());
			process.setStatusByUserName(user.getFullName());
			process.setStatusByUserUuid(user.getUserUuid());
			process = processLocalService.addProcess(process);

			//AssetEntry assetEntry = assetEntryLocalService.updateEntry(user.getUserId(), Process.class.getName(), process.getId(),  new Date(),  null, true, false);

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(user.getUserId(), serviceContext.getScopeGroupId(), new Date(),
					new Date(), Process.class.getName(),process.getId(), null, 0, null, null, true, false, new Date(), null,
					new Date(), null, ContentTypes.TEXT_HTML, process.getName(), process.getName(), null, null, null, 0, 0, null);

			Indexer<Process> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Process.class);
			indexer.reindex(process);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(process.getCompanyId(), process.getGroupId(), process.getUserId(), Process.class.getName(),
					process.getPrimaryKey(), process, serviceContext);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return process;
	}

	@Override
	public Process updateStatus(long userId, long processId, int status, ServiceContext serviceContext) {
		Process process = processPersistence.fetchByPrimaryKey(processId);
		process.setStatus(status);
		process.setStatusByUserId(userId);
		process.setStatusDate(new Date());
		User user = null;
		try {
			user = userLocalService.getUser(userId);
			process.setStatusByUserName(user.getFullName());
			process.setStatusByUserUuid(user.getUserUuid());
		} catch (PortalException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		process = processPersistence.update(process);
		try {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				// update the asset status to visibile
				assetEntryLocalService.updateEntry(Process.class.getName(), processId, new Date(),null, true, true);
			} else {
				// set process entity status to false
				assetEntryLocalService.updateVisible(Process.class.getName(), processId, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return process;
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link ru.rostec.service.ProcessLocalServiceUtil} to access the process local service.
	 */
}
