/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.javasavvy.leave.core.service.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil;
import org.javasavvy.leave.core.service.service.base.LeaveLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.javasavvy.leave.core.service.service.LeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveLocalServiceBaseImpl
 * @see org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil
 */
public class LeaveLocalServiceImpl extends LeaveLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil} to access the leave local service.
     */
    public Leave addLeave(ServiceContext serviceContext, String leaveName, Date startDate, Date leaveEndDate) {

        long leaveId = CounterLocalServiceUtil.increment(Leave.class.getName());
        Leave leave = null;
        try {
            User user = UserLocalServiceUtil.getUser(20139);
            leave = LeaveLocalServiceUtil.createLeave(leaveId);
            leave.setUserId(serviceContext.getUserId());
            leave.setCreateDate(new Date());
            leave.setLeaveName(leaveName);
            leave.setStartDate(startDate);
            leave.setEndDate(leaveEndDate);
            leave.setUserName(user.getFullName());
            leave.setCompanyId(serviceContext.getCompanyId());
            leave.setGroupId(serviceContext.getScopeGroupId());

            leave.setStatus(WorkflowConstants.STATUS_DRAFT);
            leave.setStatusByUserId(user.getUserId());
            leave.setStatusDate(new Date());
            leave.setStatusByUserName(user.getFullName());
            leave.setStatusByUserUuid(user.getUserUuid());
            leave = LeaveLocalServiceUtil.addLeave(leave);

            /*AssetEntry assetEntry = assetEntryLocalService.updateEntry(user.getUserId(), serviceContext.getScopeGroupId(), new Date(),
                    new Date(), Leave.class.getName(), leave.getLeaveId(), leave.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
                    null, null, ContentTypes.TEXT_HTML, leave.getLeaveName(), null, null, null, null, 0, 0, null);*/

            AssetEntryLocalServiceUtil.updateEntry(user.getUserId(), serviceContext.getScopeGroupId(), Leave.class.getName(), leave.getLeaveId(),
                    serviceContext.getAssetCategoryIds(),  serviceContext.getAssetTagNames());

            //Indexer<Leave> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Leave.class);
            //indexer.reindex(leave);

            WorkflowHandlerRegistryUtil.startWorkflowInstance(leave.getCompanyId(), leave.getGroupId(), leave.getUserId(), Leave.class.getName(),
                    leave.getPrimaryKey(), leave, serviceContext);
        } catch (PortalException e) {
            e.printStackTrace();
        }
        return leave;
    }

    public Leave updateStatus(long userId, long leaveId, int status, ServiceContext serviceContext) {

        Leave leave = leavePersistence.fetchByPrimaryKey(leaveId);
        leave.setStatus(status);
        leave.setStatusByUserId(userId);
        leave.setStatusDate(new Date());
        User user = null;
        try {
            user = userLocalService.getUser(userId);
            leave.setStatusByUserName(user.getFullName());
            leave.setStatusByUserUuid(user.getUserUuid());
        } catch (PortalException e) {
            e.printStackTrace();
        }
        leave = leavePersistence.update(leave);
        try {
            if (status == WorkflowConstants.STATUS_APPROVED) {
                // update the asset status to visibile
                assetEntryLocalService.updateVisible(Leave.class.getName(), leaveId, true);
            } else {
                // set leave entity status to false
                assetEntryLocalService.updateVisible(Leave.class.getName(), leaveId, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leave;
    }

    public List<Leave> getLeaveByStatus(long groupId, int status) {
        return leavePersistence.findBystatus(groupId, status);
    }

    public List<Leave> getLeaveByStatus(long groupId, int status, int start, int end) {
        return leavePersistence.findBystatus(groupId, status, start, end);
    }

}
