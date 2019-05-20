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

package ru.rostec.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import ru.rostec.model.Process;

/**
 * Provides a wrapper for {@link ProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessLocalService
 * @generated
 */
@ProviderType
public class ProcessLocalServiceWrapper implements ProcessLocalService,
	ServiceWrapper<ProcessLocalService> {
	public ProcessLocalServiceWrapper(ProcessLocalService processLocalService) {
		_processLocalService = processLocalService;
	}

	/**
	* Adds the process to the database. Also notifies the appropriate model listeners.
	*
	* @param process the process
	* @return the process that was added
	*/
	@Override
	public ru.rostec.model.Process addProcess(ru.rostec.model.Process process) {
		return _processLocalService.addProcess(process);
	}

	/**
	* Creates a new process with the primary key. Does not add the process to the database.
	*
	* @param id the primary key for the new process
	* @return the new process
	*/
	@Override
	public ru.rostec.model.Process createProcess(long id) {
		return _processLocalService.createProcess(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _processLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the process
	* @return the process that was removed
	* @throws PortalException if a process with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.Process deleteProcess(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _processLocalService.deleteProcess(id);
	}

	/**
	* Deletes the process from the database. Also notifies the appropriate model listeners.
	*
	* @param process the process
	* @return the process that was removed
	*/
	@Override
	public ru.rostec.model.Process deleteProcess(
		ru.rostec.model.Process process) {
		return _processLocalService.deleteProcess(process);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _processLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _processLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _processLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _processLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _processLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ru.rostec.model.Process fetchProcess(long id) {
		return _processLocalService.fetchProcess(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _processLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _processLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _processLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _processLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the process with the primary key.
	*
	* @param id the primary key of the process
	* @return the process
	* @throws PortalException if a process with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.Process getProcess(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _processLocalService.getProcess(id);
	}

	/**
	* Returns a range of all the processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @return the range of processes
	*/
	@Override
	public java.util.List<ru.rostec.model.Process> getProcesses(int start,
		int end) {
		return _processLocalService.getProcesses(start, end);
	}

	/**
	* Returns the number of processes.
	*
	* @return the number of processes
	*/
	@Override
	public int getProcessesCount() {
		return _processLocalService.getProcessesCount();
	}

	/**
	* Updates the process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param process the process
	* @return the process that was updated
	*/
	@Override
	public ru.rostec.model.Process updateProcess(
		ru.rostec.model.Process process) {
		return _processLocalService.updateProcess(process);
	}

	@Override
	public Process updateStatus(long userId, long processId, int status, ServiceContext serviceContext) {
		return _processLocalService.updateStatus(userId, processId, status, serviceContext);
	}

	@Override
	public ProcessLocalService getWrappedService() {
		return _processLocalService;
	}

	@Override
	public void setWrappedService(ProcessLocalService processLocalService) {
		_processLocalService = processLocalService;
	}

	private ProcessLocalService _processLocalService;
}