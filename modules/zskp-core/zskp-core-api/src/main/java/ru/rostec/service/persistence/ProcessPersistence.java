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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import ru.rostec.exception.NoSuchProcessException;

import ru.rostec.model.Process;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.persistence.impl.ProcessPersistenceImpl
 * @see ProcessUtil
 * @generated
 */
@ProviderType
public interface ProcessPersistence extends BasePersistence<Process> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessUtil} to access the process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Process> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	* Returns all the processes where name = &#63;.
	*
	* @param name the name
	* @return the matching processes
	*/
	public java.util.List<Process> findByname(String name);

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
	public java.util.List<Process> findByname(String name, int start, int end);

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
	public java.util.List<Process> findByname(String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator);

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
	public java.util.List<Process> findByname(String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process
	* @throws NoSuchProcessException if a matching process could not be found
	*/
	public Process findByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException;

	/**
	* Returns the first process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process, or <code>null</code> if a matching process could not be found
	*/
	public Process fetchByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator);

	/**
	* Returns the last process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process
	* @throws NoSuchProcessException if a matching process could not be found
	*/
	public Process findByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException;

	/**
	* Returns the last process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process, or <code>null</code> if a matching process could not be found
	*/
	public Process fetchByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator);

	/**
	* Returns the processes before and after the current process in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current process
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public Process[] findByname_PrevAndNext(long id, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException;

	/**
	* Removes all the processes where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByname(String name);

	/**
	* Returns the number of processes where name = &#63;.
	*
	* @param name the name
	* @return the number of matching processes
	*/
	public int countByname(String name);

	/**
	* Caches the process in the entity cache if it is enabled.
	*
	* @param process the process
	*/
	public void cacheResult(Process process);

	/**
	* Caches the processes in the entity cache if it is enabled.
	*
	* @param processes the processes
	*/
	public void cacheResult(java.util.List<Process> processes);

	/**
	* Creates a new process with the primary key. Does not add the process to the database.
	*
	* @param id the primary key for the new process
	* @return the new process
	*/
	public Process create(long id);

	/**
	* Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the process
	* @return the process that was removed
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public Process remove(long id) throws NoSuchProcessException;

	public Process updateImpl(Process process);

	/**
	* Returns the process with the primary key or throws a {@link NoSuchProcessException} if it could not be found.
	*
	* @param id the primary key of the process
	* @return the process
	* @throws NoSuchProcessException if a process with the primary key could not be found
	*/
	public Process findByPrimaryKey(long id) throws NoSuchProcessException;

	/**
	* Returns the process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the process
	* @return the process, or <code>null</code> if a process with the primary key could not be found
	*/
	public Process fetchByPrimaryKey(long id);

	/**
	* Returns all the processes.
	*
	* @return the processes
	*/
	public java.util.List<Process> findAll();

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
	public java.util.List<Process> findAll(int start, int end);

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
	public java.util.List<Process> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator);

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
	public java.util.List<Process> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Process> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the processes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of processes.
	*
	* @return the number of processes
	*/
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();
}