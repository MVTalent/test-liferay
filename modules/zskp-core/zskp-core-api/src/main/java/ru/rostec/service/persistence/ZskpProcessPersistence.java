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

import ru.rostec.exception.NoSuchZskpProcessException;

import ru.rostec.model.ZskpProcess;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the zskp process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.persistence.impl.ZskpProcessPersistenceImpl
 * @see ZskpProcessUtil
 * @generated
 */
@ProviderType
public interface ZskpProcessPersistence extends BasePersistence<ZskpProcess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ZskpProcessUtil} to access the zskp process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ZskpProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	* Returns all the zskp processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching zskp processes
	*/
	public java.util.List<ZskpProcess> findByUuid(String uuid);

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
	public java.util.List<ZskpProcess> findByUuid(String uuid, int start,
		int end);

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
	public java.util.List<ZskpProcess> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

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
	public java.util.List<ZskpProcess> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public ZskpProcess findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Returns the first zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public ZskpProcess fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

	/**
	* Returns the last zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public ZskpProcess findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Returns the last zskp process in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public ZskpProcess fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

	/**
	* Returns the zskp processes before and after the current zskp process in the ordered set where uuid = &#63;.
	*
	* @param processId the primary key of the current zskp process
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public ZskpProcess[] findByUuid_PrevAndNext(long processId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Removes all the zskp processes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of zskp processes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching zskp processes
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the zskp processes where name = &#63;.
	*
	* @param name the name
	* @return the matching zskp processes
	*/
	public java.util.List<ZskpProcess> findByname(String name);

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
	public java.util.List<ZskpProcess> findByname(String name, int start,
		int end);

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
	public java.util.List<ZskpProcess> findByname(String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

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
	public java.util.List<ZskpProcess> findByname(String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public ZskpProcess findByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Returns the first zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public ZskpProcess fetchByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

	/**
	* Returns the last zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process
	* @throws NoSuchZskpProcessException if a matching zskp process could not be found
	*/
	public ZskpProcess findByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Returns the last zskp process in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	*/
	public ZskpProcess fetchByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

	/**
	* Returns the zskp processes before and after the current zskp process in the ordered set where name = &#63;.
	*
	* @param processId the primary key of the current zskp process
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public ZskpProcess[] findByname_PrevAndNext(long processId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException;

	/**
	* Removes all the zskp processes where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByname(String name);

	/**
	* Returns the number of zskp processes where name = &#63;.
	*
	* @param name the name
	* @return the number of matching zskp processes
	*/
	public int countByname(String name);

	/**
	* Caches the zskp process in the entity cache if it is enabled.
	*
	* @param zskpProcess the zskp process
	*/
	public void cacheResult(ZskpProcess zskpProcess);

	/**
	* Caches the zskp processes in the entity cache if it is enabled.
	*
	* @param zskpProcesses the zskp processes
	*/
	public void cacheResult(java.util.List<ZskpProcess> zskpProcesses);

	/**
	* Creates a new zskp process with the primary key. Does not add the zskp process to the database.
	*
	* @param processId the primary key for the new zskp process
	* @return the new zskp process
	*/
	public ZskpProcess create(long processId);

	/**
	* Removes the zskp process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process that was removed
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public ZskpProcess remove(long processId) throws NoSuchZskpProcessException;

	public ZskpProcess updateImpl(ZskpProcess zskpProcess);

	/**
	* Returns the zskp process with the primary key or throws a {@link NoSuchZskpProcessException} if it could not be found.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process
	* @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	*/
	public ZskpProcess findByPrimaryKey(long processId)
		throws NoSuchZskpProcessException;

	/**
	* Returns the zskp process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processId the primary key of the zskp process
	* @return the zskp process, or <code>null</code> if a zskp process with the primary key could not be found
	*/
	public ZskpProcess fetchByPrimaryKey(long processId);

	/**
	* Returns all the zskp processes.
	*
	* @return the zskp processes
	*/
	public java.util.List<ZskpProcess> findAll();

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
	public java.util.List<ZskpProcess> findAll(int start, int end);

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
	public java.util.List<ZskpProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator);

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
	public java.util.List<ZskpProcess> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the zskp processes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of zskp processes.
	*
	* @return the number of zskp processes
	*/
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();
}