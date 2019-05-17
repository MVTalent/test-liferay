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
 * Provides a wrapper for {@link KindLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KindLocalService
 * @generated
 */
@ProviderType
public class KindLocalServiceWrapper implements KindLocalService,
	ServiceWrapper<KindLocalService> {
	public KindLocalServiceWrapper(KindLocalService kindLocalService) {
		_kindLocalService = kindLocalService;
	}

	/**
	* Adds the kind to the database. Also notifies the appropriate model listeners.
	*
	* @param kind the kind
	* @return the kind that was added
	*/
	@Override
	public ru.rostec.model.Kind addKind(ru.rostec.model.Kind kind) {
		return _kindLocalService.addKind(kind);
	}

	/**
	* Creates a new kind with the primary key. Does not add the kind to the database.
	*
	* @param id the primary key for the new kind
	* @return the new kind
	*/
	@Override
	public ru.rostec.model.Kind createKind(long id) {
		return _kindLocalService.createKind(id);
	}

	/**
	* Deletes the kind from the database. Also notifies the appropriate model listeners.
	*
	* @param kind the kind
	* @return the kind that was removed
	*/
	@Override
	public ru.rostec.model.Kind deleteKind(ru.rostec.model.Kind kind) {
		return _kindLocalService.deleteKind(kind);
	}

	/**
	* Deletes the kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the kind
	* @return the kind that was removed
	* @throws PortalException if a kind with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.Kind deleteKind(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kindLocalService.deleteKind(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kindLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kindLocalService.dynamicQuery();
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
		return _kindLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kindLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kindLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _kindLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kindLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ru.rostec.model.Kind fetchKind(long id) {
		return _kindLocalService.fetchKind(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _kindLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _kindLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the kind with the primary key.
	*
	* @param id the primary key of the kind
	* @return the kind
	* @throws PortalException if a kind with the primary key could not be found
	*/
	@Override
	public ru.rostec.model.Kind getKind(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kindLocalService.getKind(id);
	}

	/**
	* Returns a range of all the kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.rostec.model.impl.KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kinds
	* @param end the upper bound of the range of kinds (not inclusive)
	* @return the range of kinds
	*/
	@Override
	public java.util.List<ru.rostec.model.Kind> getKinds(int start, int end) {
		return _kindLocalService.getKinds(start, end);
	}

	/**
	* Returns the number of kinds.
	*
	* @return the number of kinds
	*/
	@Override
	public int getKindsCount() {
		return _kindLocalService.getKindsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _kindLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kindLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the kind in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kind the kind
	* @return the kind that was updated
	*/
	@Override
	public ru.rostec.model.Kind updateKind(ru.rostec.model.Kind kind) {
		return _kindLocalService.updateKind(kind);
	}

	@Override
	public KindLocalService getWrappedService() {
		return _kindLocalService;
	}

	@Override
	public void setWrappedService(KindLocalService kindLocalService) {
		_kindLocalService = kindLocalService;
	}

	private KindLocalService _kindLocalService;
}