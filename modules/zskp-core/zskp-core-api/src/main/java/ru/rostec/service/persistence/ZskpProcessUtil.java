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

import ru.rostec.model.ZskpProcess;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the zskp process service. This utility wraps {@link ru.rostec.service.persistence.impl.ZskpProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessPersistence
 * @see ru.rostec.service.persistence.impl.ZskpProcessPersistenceImpl
 * @generated
 */
@ProviderType
public class ZskpProcessUtil {
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
	public static void clearCache(ZskpProcess zskpProcess) {
		getPersistence().clearCache(zskpProcess);
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
	public static Map<Serializable, ZskpProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ZskpProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ZskpProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ZskpProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ZskpProcess update(ZskpProcess zskpProcess) {
		return getPersistence().update(zskpProcess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ZskpProcess update(ZskpProcess zskpProcess,
		ServiceContext serviceContext) {
		return getPersistence().update(zskpProcess, serviceContext);
	}

	/**
	* Returns all the zskp processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching zskp processes
	*/
	public static List<ZskpProcess> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the zskp processes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @return the range of matching zskp processes
	*/
	public static List<ZskpProcess> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the zskp processes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching zskp processes
	*/
	public static List<ZskpProcess> findByUuid(String uuid, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the zskp processes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching zskp processes
	*/
	public static List<ZskpProcess> findByUuid(String uuid, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public static ZskpProcess findByUuid_First(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public static ZskpProcess fetchByUuid_First(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public static ZskpProcess findByUuid_Last(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public static ZskpProcess fetchByUuid_Last(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the zskp processes before and after the current zskp process in the ordered set where uuid = &#63;.
	*
	* @param processId the primary key of the current zskp process
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public static ZskpProcess[] findByUuid_PrevAndNext(long processId,
		String uuid, OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence()
				   .findByUuid_PrevAndNext(processId, uuid, orderByComparator);
	}

	/**
	* Removes all the zskp processes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of zskp processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching zskp processes
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the zskp processes where name = &#63;.
	*
	* @param name the name
	* @return the matching zskp processes
	*/
	public static List<ZskpProcess> findByname(String name) {
		return getPersistence().findByname(name);
	}

	/**
	* Returns a range of all the zskp processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @return the range of matching zskp processes
	*/
	public static List<ZskpProcess> findByname(String name, int start, int end) {
		return getPersistence().findByname(name, start, end);
	}

	/**
	* Returns an ordered range of all the zskp processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching zskp processes
	*/
	public static List<ZskpProcess> findByname(String name, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the zskp processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching zskp processes
	*/
	public static List<ZskpProcess> findByname(String name, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByname(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public static ZskpProcess findByname_First(String name,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

	/**
	* Returns the first zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public static ZskpProcess fetchByname_First(String name,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().fetchByname_First(name, orderByComparator);
	}

	/**
	* Returns the last zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public static ZskpProcess findByname_Last(String name,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

	/**
	* Returns the last zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public static ZskpProcess fetchByname_Last(String name,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().fetchByname_Last(name, orderByComparator);
	}

	/**
	* Returns the zskp processes before and after the current zskp process in the ordered set where name = &#63;.
	*
	* @param processId the primary key of the current zskp process
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public static ZskpProcess[] findByname_PrevAndNext(long processId,
		String name, OrderByComparator<ZskpProcess> orderByComparator)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence()
				   .findByname_PrevAndNext(processId, name, orderByComparator);
	}

	/**
	* Removes all the zskp processes where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByname(String name) {
		getPersistence().removeByname(name);
	}

	/**
	* Returns the number of zskp processes where name = &#63;.
	*
	* @param name the name
	* @return the number of matching zskp processes
	*/
	public static int countByname(String name) {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the zskp process in the entity cache if it is enabled.
	*
	* @param zskpProcess the zskp process
	*/
	public static void cacheResult(ZskpProcess zskpProcess) {
		getPersistence().cacheResult(zskpProcess);
	}

	/**
	* Caches the zskp processes in the entity cache if it is enabled.
	*
	* @param zskpProcesses the zskp processes
	*/
	public static void cacheResult(List<ZskpProcess> zskpProcesses) {
		getPersistence().cacheResult(zskpProcesses);
	}

	/**
	* Creates a new zskp process with the primary key. Does not add the zskp process to the database.
	*
	* @param processId the primary key for the new zskp process
	* @return the new zskp process
	*/
	public static ZskpProcess create(long processId) {
		return getPersistence().create(processId);
	}

	/**
	* Removes the zskp process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process that was removed
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public static ZskpProcess remove(long processId)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().remove(processId);
	}

	public static ZskpProcess updateImpl(ZskpProcess zskpProcess) {
		return getPersistence().updateImpl(zskpProcess);
	}

	/**
	* Returns the zskp process with the primary key or throws a {@link NoSuchZskpProcessException} if it could not be found.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public static ZskpProcess findByPrimaryKey(long processId)
		throws ru.rostec.exception.NoSuchZskpProcessException {
		return getPersistence().findByPrimaryKey(processId);
	}

	/**
	* Returns the zskp process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process, or <code>null</code> if a zskp process with the primary key could not be found
	*/
	public static ZskpProcess fetchByPrimaryKey(long processId) {
		return getPersistence().fetchByPrimaryKey(processId);
	}

	/**
	* Returns all the zskp processes.
	*
	* @return the zskp processes
	*/
	public static List<ZskpProcess> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the zskp processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @return the range of zskp processes
	*/
	public static List<ZskpProcess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the zskp processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zskp processes
	*/
	public static List<ZskpProcess> findAll(int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the zskp processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ZskpProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zskp processes
	* @param end the upper bound of the range of zskp processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of zskp processes
	*/
	public static List<ZskpProcess> findAll(int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the zskp processes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of zskp processes.
	*
	* @return the number of zskp processes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ZskpProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ZskpProcessPersistence, ZskpProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ZskpProcessPersistence.class);

		ServiceTracker<ZskpProcessPersistence, ZskpProcessPersistence> serviceTracker =
			new ServiceTracker<ZskpProcessPersistence, ZskpProcessPersistence>(bundle.getBundleContext(),
				ZskpProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}