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

package ru.rostec.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import ru.rostec.model.Kind;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the kind service. This utility wraps {@link ru.rostec.service.persistence.impl.KindPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KindPersistence
 * @see ru.rostec.service.persistence.impl.KindPersistenceImpl
 * @generated
 */
@ProviderType
public class KindUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Kind kind) {
		getPersistence().clearCache(kind);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Kind> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Kind> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Kind> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Kind> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Kind> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Kind update(Kind kind) {
		return getPersistence().update(kind);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Kind update(Kind kind, ServiceContext serviceContext) {
		return getPersistence().update(kind, serviceContext);
	}

	/**
	* Caches the kind in the entity cache if it is enabled.
	*
	* @param kind the kind
	*/
	public static void cacheResult(Kind kind) {
		getPersistence().cacheResult(kind);
	}

	/**
	* Caches the kinds in the entity cache if it is enabled.
	*
	* @param kinds the kinds
	*/
	public static void cacheResult(List<Kind> kinds) {
		getPersistence().cacheResult(kinds);
	}

	/**
	* Creates a new kind with the primary key. Does not add the kind to the database.
	*
	* @param id the primary key for the new kind
	* @return the new kind
	*/
	public static Kind create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the kind
	* @return the kind that was removed
	* @throws NoSuchKindException if a kind with the primary key could not be found
	*/
	public static Kind remove(long id)
		throws ru.rostec.exception.NoSuchKindException {
		return getPersistence().remove(id);
	}

	public static Kind updateImpl(Kind kind) {
		return getPersistence().updateImpl(kind);
	}

	/**
	* Returns the kind with the primary key or throws a {@link NoSuchKindException} if it could not be found.
	*
	* @param id the primary key of the kind
	* @return the kind
	* @throws NoSuchKindException if a kind with the primary key could not be found
	*/
	public static Kind findByPrimaryKey(long id)
		throws ru.rostec.exception.NoSuchKindException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the kind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the kind
	* @return the kind, or <code>null</code> if a kind with the primary key could not be found
	*/
	public static Kind fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the kinds.
	*
	* @return the kinds
	*/
	public static List<Kind> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kinds
	* @param end the upper bound of the range of kinds (not inclusive)
	* @return the range of kinds
	*/
	public static List<Kind> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kinds
	* @param end the upper bound of the range of kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kinds
	*/
	public static List<Kind> findAll(int start, int end,
		OrderByComparator<Kind> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kinds
	* @param end the upper bound of the range of kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of kinds
	*/
	public static List<Kind> findAll(int start, int end,
		OrderByComparator<Kind> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the kinds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kinds.
	*
	* @return the number of kinds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static KindPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KindPersistence, KindPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KindPersistence.class);

		ServiceTracker<KindPersistence, KindPersistence> serviceTracker = new ServiceTracker<KindPersistence, KindPersistence>(bundle.getBundleContext(),
				KindPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}