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

import ru.rostec.model.Process;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the process service. This utility wraps {@link ru.rostec.service.persistence.impl.ProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistence
 * @see ru.rostec.service.persistence.impl.ProcessPersistenceImpl
 * @generated
 */
@ProviderType
public class ProcessUtil {
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
	public static void clearCache(Process process) {
		getPersistence().clearCache(process);
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
	public static Map<Serializable, Process> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Process> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Process> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Process> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Process update(Process process) {
		return getPersistence().update(process);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Process update(Process process, ServiceContext serviceContext) {
		return getPersistence().update(process, serviceContext);
	}

	/**
	* Returns all the processes where name = &#63;.
	*
	* @param name the name
	* @return the matching processes
	*/
	public static List<Process> findByname(String name) {
		return getPersistence().findByname(name);
	}

	/**
	* Returns a range of all the processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @return the range of matching processes
	*/
	public static List<Process> findByname(String name, int start, int end) {
		return getPersistence().findByname(name, start, end);
	}

	/**
	* Returns an ordered range of all the processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching processes
	*/
	public static List<Process> findByname(String name, int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the processes where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching processes
	*/
	public static List<Process> findByname(String name, int start, int end,
		OrderByComparator<Process> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByname(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process
	* @throws NoSuchProcessException if a matching process could not be found
	*/
	public static Process findByname_First(String name,
		OrderByComparator<Process> orderByComparator)
		throws ru.rostec.exception.NoSuchProcessException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

	/**
	* Returns the first process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process, or <code>null</code> if a matching process could not be found
	*/
	public static Process fetchByname_First(String name,
		OrderByComparator<Process> orderByComparator) {
		return getPersistence().fetchByname_First(name, orderByComparator);
	}

	/**
	* Returns the last process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process
	* @throws NoSuchProcessException if a matching process could not be found
	*/
	public static Process findByname_Last(String name,
		OrderByComparator<Process> orderByComparator)
		throws ru.rostec.exception.NoSuchProcessException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

	/**
	* Returns the last process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process, or <code>null</code> if a matching process could not be found
	*/
	public static Process fetchByname_Last(String name,
		OrderByComparator<Process> orderByComparator) {
		return getPersistence().fetchByname_Last(name, orderByComparator);
	}

	/**
	* Returns the processes before and after the current process in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current process
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public static Process[] findByname_PrevAndNext(long id, String name,
		OrderByComparator<Process> orderByComparator)
		throws ru.rostec.exception.NoSuchProcessException {
		return getPersistence()
				   .findByname_PrevAndNext(id, name, orderByComparator);
	}

	/**
	* Removes all the processes where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByname(String name) {
		getPersistence().removeByname(name);
	}

	/**
	* Returns the number of processes where name = &#63;.
	*
	* @param name the name
	* @return the number of matching processes
	*/
	public static int countByname(String name) {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the process in the entity cache if it is enabled.
	*
	* @param process the process
	*/
	public static void cacheResult(Process process) {
		getPersistence().cacheResult(process);
	}

	/**
	* Caches the processes in the entity cache if it is enabled.
	*
	* @param processes the processes
	*/
	public static void cacheResult(List<Process> processes) {
		getPersistence().cacheResult(processes);
	}

	/**
	* Creates a new process with the primary key. Does not add the process to the database.
	*
	* @param id the primary key for the new process
	* @return the new process
	*/
	public static Process create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the process
	* @return the process that was removed
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public static Process remove(long id)
		throws ru.rostec.exception.NoSuchProcessException {
		return getPersistence().remove(id);
	}

	public static Process updateImpl(Process process) {
		return getPersistence().updateImpl(process);
	}

	/**
	* Returns the process with the primary key or throws a {@link NoSuchProcessException} if it could not be found.
	*
	* @param id the primary key of the process
	* @return the process
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public static Process findByPrimaryKey(long id)
		throws ru.rostec.exception.NoSuchProcessException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the process
	* @return the process, or <code>null</code> if a process with the primary key could not be found
	*/
	public static Process fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the processes.
	*
	* @return the processes
	*/
	public static List<Process> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @return the range of processes
	*/
	public static List<Process> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of processes
	*/
	public static List<Process> findAll(int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of processes
	* @param end the upper bound of the range of processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of processes
	*/
	public static List<Process> findAll(int start, int end,
		OrderByComparator<Process> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the processes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of processes.
	*
	* @return the number of processes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProcessPersistence, ProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProcessPersistence.class);

		ServiceTracker<ProcessPersistence, ProcessPersistence> serviceTracker = new ServiceTracker<ProcessPersistence, ProcessPersistence>(bundle.getBundleContext(),
				ProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}