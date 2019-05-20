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

package ru.rostec.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import ru.rostec.exception.NoSuchProcessException;

import ru.rostec.model.Process;
import ru.rostec.model.impl.ProcessImpl;
import ru.rostec.model.impl.ProcessModelImpl;

import ru.rostec.service.persistence.ProcessPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistence
 * @see ru.rostec.service.persistence.ProcessUtil
 * @generated
 */
@ProviderType
public class ProcessPersistenceImpl extends BasePersistenceImpl<Process>
	implements ProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProcessUtil} to access the process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByname;
	private FinderPath _finderPathWithoutPaginationFindByname;
	private FinderPath _finderPathCountByname;

	/**
	 * Returns all the processes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching processes
	 */
	@Override
	public List<Process> findByname(String name) {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Process> findByname(String name, int start, int end) {
		return findByname(name, start, end, null);
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
	@Override
	public List<Process> findByname(String name, int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return findByname(name, start, end, orderByComparator, true);
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
	@Override
	public List<Process> findByname(String name, int start, int end,
		OrderByComparator<Process> orderByComparator, boolean retrieveFromCache) {
		name = Objects.toString(name, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByname;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = _finderPathWithPaginationFindByname;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Process> list = null;

		if (retrieveFromCache) {
			list = (List<Process>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Process process : list) {
					if (!name.equals(process.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROCESS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process
	 * @throws NoSuchProcessException if a matching process could not be found
	 */
	@Override
	public Process findByname_First(String name,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		Process process = fetchByname_First(name, orderByComparator);

		if (process != null) {
			return process;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchProcessException(msg.toString());
	}

	/**
	 * Returns the first process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process, or <code>null</code> if a matching process could not be found
	 */
	@Override
	public Process fetchByname_First(String name,
		OrderByComparator<Process> orderByComparator) {
		List<Process> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process
	 * @throws NoSuchProcessException if a matching process could not be found
	 */
	@Override
	public Process findByname_Last(String name,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		Process process = fetchByname_Last(name, orderByComparator);

		if (process != null) {
			return process;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchProcessException(msg.toString());
	}

	/**
	 * Returns the last process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process, or <code>null</code> if a matching process could not be found
	 */
	@Override
	public Process fetchByname_Last(String name,
		OrderByComparator<Process> orderByComparator) {
		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<Process> list = findByname(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Process[] findByname_PrevAndNext(long id, String name,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		name = Objects.toString(name, "");

		Process process = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Process[] array = new ProcessImpl[3];

			array[0] = getByname_PrevAndNext(session, process, name,
					orderByComparator, true);

			array[1] = process;

			array[2] = getByname_PrevAndNext(session, process, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Process getByname_PrevAndNext(Session session, Process process,
		String name, OrderByComparator<Process> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESS_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
					process)) {
				qPos.add(orderByConditionValue);
			}
		}

		List<Process> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByname(String name) {
		for (Process process : findByname(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(process);
		}
	}

	/**
	 * Returns the number of processes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching processes
	 */
	@Override
	public int countByname(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByname;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCESS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "process.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(process.name IS NULL OR process.name = '')";
	private FinderPath _finderPathWithPaginationFindBystatus;
	private FinderPath _finderPathWithoutPaginationFindBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns all the processes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching processes
	 */
	@Override
	public List<Process> findBystatus(int status) {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of processes
	 * @param end the upper bound of the range of processes (not inclusive)
	 * @return the range of matching processes
	 */
	@Override
	public List<Process> findBystatus(int status, int start, int end) {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the processes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of processes
	 * @param end the upper bound of the range of processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processes
	 */
	@Override
	public List<Process> findBystatus(int status, int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return findBystatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of processes
	 * @param end the upper bound of the range of processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching processes
	 */
	@Override
	public List<Process> findBystatus(int status, int start, int end,
		OrderByComparator<Process> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBystatus;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = _finderPathWithPaginationFindBystatus;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Process> list = null;

		if (retrieveFromCache) {
			list = (List<Process>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Process process : list) {
					if ((status != process.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROCESS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process
	 * @throws NoSuchProcessException if a matching process could not be found
	 */
	@Override
	public Process findBystatus_First(int status,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		Process process = fetchBystatus_First(status, orderByComparator);

		if (process != null) {
			return process;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchProcessException(msg.toString());
	}

	/**
	 * Returns the first process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process, or <code>null</code> if a matching process could not be found
	 */
	@Override
	public Process fetchBystatus_First(int status,
		OrderByComparator<Process> orderByComparator) {
		List<Process> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process
	 * @throws NoSuchProcessException if a matching process could not be found
	 */
	@Override
	public Process findBystatus_Last(int status,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		Process process = fetchBystatus_Last(status, orderByComparator);

		if (process != null) {
			return process;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchProcessException(msg.toString());
	}

	/**
	 * Returns the last process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process, or <code>null</code> if a matching process could not be found
	 */
	@Override
	public Process fetchBystatus_Last(int status,
		OrderByComparator<Process> orderByComparator) {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<Process> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the processes before and after the current process in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current process
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process
	 * @throws NoSuchProcessException if a process with the primary key could not be found
	 */
	@Override
	public Process[] findBystatus_PrevAndNext(long id, int status,
		OrderByComparator<Process> orderByComparator)
		throws NoSuchProcessException {
		Process process = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Process[] array = new ProcessImpl[3];

			array[0] = getBystatus_PrevAndNext(session, process, status,
					orderByComparator, true);

			array[1] = process;

			array[2] = getBystatus_PrevAndNext(session, process, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Process getBystatus_PrevAndNext(Session session, Process process,
		int status, OrderByComparator<Process> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESS_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
					process)) {
				qPos.add(orderByConditionValue);
			}
		}

		List<Process> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatus(int status) {
		for (Process process : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(process);
		}
	}

	/**
	 * Returns the number of processes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching processes
	 */
	@Override
	public int countBystatus(int status) {
		FinderPath finderPath = _finderPathCountBystatus;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCESS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "process.status = ?";

	public ProcessPersistenceImpl() {
		setModelClass(Process.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");
			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the process in the entity cache if it is enabled.
	 *
	 * @param process the process
	 */
	@Override
	public void cacheResult(Process process) {
		entityCache.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
			ProcessImpl.class, process.getPrimaryKey(), process);

		process.resetOriginalValues();
	}

	/**
	 * Caches the processes in the entity cache if it is enabled.
	 *
	 * @param processes the processes
	 */
	@Override
	public void cacheResult(List<Process> processes) {
		for (Process process : processes) {
			if (entityCache.getResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
						ProcessImpl.class, process.getPrimaryKey()) == null) {
				cacheResult(process);
			}
			else {
				process.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all processes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcessImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the process.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Process process) {
		entityCache.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
			ProcessImpl.class, process.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Process> processes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Process process : processes) {
			entityCache.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessImpl.class, process.getPrimaryKey());
		}
	}

	/**
	 * Creates a new process with the primary key. Does not add the process to the database.
	 *
	 * @param id the primary key for the new process
	 * @return the new process
	 */
	@Override
	public Process create(long id) {
		Process process = new ProcessImpl();

		process.setNew(true);
		process.setPrimaryKey(id);

		return process;
	}

	/**
	 * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the process
	 * @return the process that was removed
	 * @throws NoSuchProcessException if a process with the primary key could not be found
	 */
	@Override
	public Process remove(long id) throws NoSuchProcessException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the process
	 * @return the process that was removed
	 * @throws NoSuchProcessException if a process with the primary key could not be found
	 */
	@Override
	public Process remove(Serializable primaryKey)
		throws NoSuchProcessException {
		Session session = null;

		try {
			session = openSession();

			Process process = (Process)session.get(ProcessImpl.class, primaryKey);

			if (process == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(process);
		}
		catch (NoSuchProcessException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Process removeImpl(Process process) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(process)) {
				process = (Process)session.get(ProcessImpl.class,
						process.getPrimaryKeyObj());
			}

			if (process != null) {
				session.delete(process);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (process != null) {
			clearCache(process);
		}

		return process;
	}

	@Override
	public Process updateImpl(Process process) {
		boolean isNew = process.isNew();

		if (!(process instanceof ProcessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(process.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(process);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in process proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Process implementation " +
				process.getClass());
		}

		ProcessModelImpl processModelImpl = (ProcessModelImpl)process;

		Session session = null;

		try {
			session = openSession();

			if (process.isNew()) {
				session.save(process);

				process.setNew(false);
			}
			else {
				process = (Process)session.merge(process);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { processModelImpl.getName() };

			finderCache.removeResult(_finderPathCountByname, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindByname,
				args);

			args = new Object[] { processModelImpl.getStatus() };

			finderCache.removeResult(_finderPathCountBystatus, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindBystatus,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(_finderPathWithoutPaginationFindAll,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((processModelImpl.getColumnBitmask() &
					_finderPathWithoutPaginationFindByname.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { processModelImpl.getOriginalName() };

				finderCache.removeResult(_finderPathCountByname, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByname,
					args);

				args = new Object[] { processModelImpl.getName() };

				finderCache.removeResult(_finderPathCountByname, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByname,
					args);
			}

			if ((processModelImpl.getColumnBitmask() &
					_finderPathWithoutPaginationFindBystatus.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(_finderPathCountBystatus, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindBystatus,
					args);

				args = new Object[] { processModelImpl.getStatus() };

				finderCache.removeResult(_finderPathCountBystatus, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindBystatus,
					args);
			}
		}

		entityCache.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
			ProcessImpl.class, process.getPrimaryKey(), process, false);

		process.resetOriginalValues();

		return process;
	}

	/**
	 * Returns the process with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the process
	 * @return the process
	 * @throws NoSuchProcessException if a process with the primary key could not be found
	 */
	@Override
	public Process findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcessException {
		Process process = fetchByPrimaryKey(primaryKey);

		if (process == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return process;
	}

	/**
	 * Returns the process with the primary key or throws a {@link NoSuchProcessException} if it could not be found.
	 *
	 * @param id the primary key of the process
	 * @return the process
	 * @throws NoSuchProcessException if a process with the primary key could not be found
	 */
	@Override
	public Process findByPrimaryKey(long id) throws NoSuchProcessException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the process
	 * @return the process, or <code>null</code> if a process with the primary key could not be found
	 */
	@Override
	public Process fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Process process = (Process)serializable;

		if (process == null) {
			Session session = null;

			try {
				session = openSession();

				process = (Process)session.get(ProcessImpl.class, primaryKey);

				if (process != null) {
					cacheResult(process);
				}
				else {
					entityCache.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
						ProcessImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
					ProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return process;
	}

	/**
	 * Returns the process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the process
	 * @return the process, or <code>null</code> if a process with the primary key could not be found
	 */
	@Override
	public Process fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Process> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Process> map = new HashMap<Serializable, Process>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Process process = fetchByPrimaryKey(primaryKey);

			if (process != null) {
				map.put(primaryKey, process);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
					ProcessImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Process)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROCESS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Process process : (List<Process>)q.list()) {
				map.put(process.getPrimaryKeyObj(), process);

				cacheResult(process);

				uncachedPrimaryKeys.remove(process.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
					ProcessImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the processes.
	 *
	 * @return the processes
	 */
	@Override
	public List<Process> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Process> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Process> findAll(int start, int end,
		OrderByComparator<Process> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Process> findAll(int start, int end,
		OrderByComparator<Process> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Process> list = null;

		if (retrieveFromCache) {
			list = (List<Process>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESS;

				if (pagination) {
					sql = sql.concat(ProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Process>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the processes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Process process : findAll()) {
			remove(process);
		}
	}

	/**
	 * Returns the number of processes.
	 *
	 * @return the number of processes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(_finderPathCountAll,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROCESS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(_finderPathCountAll, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the process persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
				new String[0]);

		_finderPathCountAll = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
				new String[0]);

		_finderPathWithPaginationFindByname = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
				new String[] {
					String.class.getName(),
					
				Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByname = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
				new String[] { String.class.getName() },
				ProcessModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByname = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
				new String[] { String.class.getName() });

		_finderPathWithPaginationFindBystatus = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
				new String[] {
					Integer.class.getName(),
					
				Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindBystatus = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
				new String[] { Integer.class.getName() },
				ProcessModelImpl.STATUS_COLUMN_BITMASK |
				ProcessModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountBystatus = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
				ProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
				new String[] { Integer.class.getName() });
	}

	public void destroy() {
		entityCache.removeCache(ProcessImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROCESS = "SELECT process FROM Process process";
	private static final String _SQL_SELECT_PROCESS_WHERE_PKS_IN = "SELECT process FROM Process process WHERE id_ IN (";
	private static final String _SQL_SELECT_PROCESS_WHERE = "SELECT process FROM Process process WHERE ";
	private static final String _SQL_COUNT_PROCESS = "SELECT COUNT(process) FROM Process process";
	private static final String _SQL_COUNT_PROCESS_WHERE = "SELECT COUNT(process) FROM Process process WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "process.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Process exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Process exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProcessPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
}