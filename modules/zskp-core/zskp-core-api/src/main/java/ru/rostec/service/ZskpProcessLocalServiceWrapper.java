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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ZskpProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessLocalService
 * @generated
 */
@ProviderType
public class ZskpProcessLocalServiceWrapper implements ZskpProcessLocalService,
	ServiceWrapper<ZskpProcessLocalService> {
	public ZskpProcessLocalServiceWrapper(
		ZskpProcessLocalService zskpProcessLocalService) {
		_zskpProcessLocalService = zskpProcessLocalService;
	}

	/**
	* Adds the zskp process to the database. Also notifies the appropriate model listeners.
	*
	* @param zskpProcess the zskp process
	* @return the zskp process that was added
	*/
	@Override
	public ru.rostec.model.ZskpProcess addZskpProcess(
		ru.rostec.model.ZskpProcess zskpProcess) {
		return _zskpProcessLocalService.addZskpProcess(zskpProcess);
	}

	/**
	* Creates a new zskp process with the primary key. Does not add the zskp process to the database.
	*
	* @param processId the primary key for the new zskp process
	* @return the new zskp process
	*/
	@Override
	public ru.rostec.model.ZskpProcess createZskpProcess(long processId) {
		return _zskpProcessLocalService.createZskpProcess(processId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zskpProcessLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the zskp process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process that was removed
	* @throws PortalException if a zskp process with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.ZskpProcess deleteZskpProcess(long processId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zskpProcessLocalService.deleteZskpProcess(processId);
	}

	/**
	* Deletes the zskp process from the database. Also notifies the appropriate model listeners.
	*
	* @param zskpProcess the zskp process
	* @return the zskp process that was removed
	*/
	@Override
	public ru.rostec.model.ZskpProcess deleteZskpProcess(
		ru.rostec.model.ZskpProcess zskpProcess) {
		return _zskpProcessLocalService.deleteZskpProcess(zskpProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _zskpProcessLocalService.dynamicQuery();
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
		return _zskpProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zskpProcessLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zskpProcessLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _zskpProcessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _zskpProcessLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ru.rostec.model.ZskpProcess fetchZskpProcess(long processId) {
		return _zskpProcessLocalService.fetchZskpProcess(processId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _zskpProcessLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _zskpProcessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _zskpProcessLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zskpProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the zskp process with the primary key.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process
	* @throws PortalException if a zskp process with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.ZskpProcess getZskpProcess(long processId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zskpProcessLocalService.getZskpProcess(processId);
	}

	/**
	* Returns a range of all the zskp processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @return the range of zskp processes
	*/
	@Override
	public java.util.List<ru.rostec.model.ZskpProcess> getZskpProcesses(
		int start, int end) {
		return _zskpProcessLocalService.getZskpProcesses(start, end);
	}

	/**
	* Returns the number of zskp processes.
	*
	* @return the number of zskp processes
	*/
	@Override
	public int getZskpProcessesCount() {
		return _zskpProcessLocalService.getZskpProcessesCount();
	}

	/**
	* Updates the zskp process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zskpProcess the zskp process
	* @return the zskp process that was updated
	*/
	@Override
	public ru.rostec.model.ZskpProcess updateZskpProcess(
		ru.rostec.model.ZskpProcess zskpProcess) {
		return _zskpProcessLocalService.updateZskpProcess(zskpProcess);
	}

	@Override
	public ZskpProcessLocalService getWrappedService() {
		return _zskpProcessLocalService;
	}

	@Override
	public void setWrappedService(
		ZskpProcessLocalService zskpProcessLocalService) {
		_zskpProcessLocalService = zskpProcessLocalService;
	}

	private ZskpProcessLocalService _zskpProcessLocalService;
}