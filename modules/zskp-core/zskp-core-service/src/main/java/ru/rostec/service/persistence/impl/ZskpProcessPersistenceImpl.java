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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import ru.rostec.exception.NoSuchZskpProcessException;

import ru.rostec.model.ZskpProcess;
import ru.rostec.model.impl.ZskpProcessImpl;
import ru.rostec.model.impl.ZskpProcessModelImpl;

import ru.rostec.service.persistence.ZskpProcessPersistence;

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
 * The persistence implementation for the zskp process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessPersistence
 * @see ru.rostec.service.persistence.ZskpProcessUtil
 * @generated
 */
@ProviderType
public class ZskpProcessPersistenceImpl extends BasePersistenceImpl<ZskpProcess>
	implements ZskpProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ZskpProcessUtil} to access the zskp process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ZskpProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the zskp processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching zskp processes
	 */
	@Override
	public List<ZskpProcess> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ZskpProcess> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ZskpProcess> findByUuid(String uuid, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ZskpProcess> findByUuid(String uuid, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ZskpProcess> list = null;

		if (retrieveFromCache) {
			list = (List<ZskpProcess>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ZskpProcess zskpProcess : list) {
					if (!uuid.equals(zskpProcess.getUuid())) {
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

			query.append(_SQL_SELECT_ZSKPPROCESS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ZskpProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first zskp process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching zskp process
	 * @throws NoSuchZskpProcessException if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess findByUuid_First(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		ZskpProcess zskpProcess = fetchByUuid_First(uuid, orderByComparator);

		if (zskpProcess != null) {
			return zskpProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchZskpProcessException(msg.toString());
	}

	/**
	 * Returns the first zskp process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess fetchByUuid_First(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator) {
		List<ZskpProcess> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last zskp process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching zskp process
	 * @throws NoSuchZskpProcessException if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess findByUuid_Last(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		ZskpProcess zskpProcess = fetchByUuid_Last(uuid, orderByComparator);

		if (zskpProcess != null) {
			return zskpProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchZskpProcessException(msg.toString());
	}

	/**
	 * Returns the last zskp process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess fetchByUuid_Last(String uuid,
		OrderByComparator<ZskpProcess> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ZskpProcess> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ZskpProcess[] findByUuid_PrevAndNext(long processId, String uuid,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		uuid = Objects.toString(uuid, "");

		ZskpProcess zskpProcess = findByPrimaryKey(processId);

		Session session = null;

		try {
			session = openSession();

			ZskpProcess[] array = new ZskpProcessImpl[3];

			array[0] = getByUuid_PrevAndNext(session, zskpProcess, uuid,
					orderByComparator, true);

			array[1] = zskpProcess;

			array[2] = getByUuid_PrevAndNext(session, zskpProcess, uuid,
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

	protected ZskpProcess getByUuid_PrevAndNext(Session session,
		ZskpProcess zskpProcess, String uuid,
		OrderByComparator<ZskpProcess> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ZSKPPROCESS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(ZskpProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
					zskpProcess)) {
				qPos.add(orderByConditionValue);
			}
		}

		List<ZskpProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the zskp processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ZskpProcess zskpProcess : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(zskpProcess);
		}
	}

	/**
	 * Returns the number of zskp processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching zskp processes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ZSKPPROCESS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "zskpProcess.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(zskpProcess.uuid IS NULL OR zskpProcess.uuid = '')";
	private FinderPath _finderPathWithPaginationFindByname;
	private FinderPath _finderPathWithoutPaginationFindByname;
	private FinderPath _finderPathCountByname;

	/**
	 * Returns all the zskp processes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching zskp processes
	 */
	@Override
	public List<ZskpProcess> findByname(String name) {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ZskpProcess> findByname(String name, int start, int end) {
		return findByname(name, start, end, null);
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
	@Override
	public List<ZskpProcess> findByname(String name, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return findByname(name, start, end, orderByComparator, true);
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
	@Override
	public List<ZskpProcess> findByname(String name, int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ZskpProcess> list = null;

		if (retrieveFromCache) {
			list = (List<ZskpProcess>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ZskpProcess zskpProcess : list) {
					if (!name.equals(zskpProcess.getName())) {
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

			query.append(_SQL_SELECT_ZSKPPROCESS_WHERE);

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
				query.append(ZskpProcessModelImpl.ORDER_BY_JPQL);
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
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first zskp process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching zskp process
	 * @throws NoSuchZskpProcessException if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess findByname_First(String name,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		ZskpProcess zskpProcess = fetchByname_First(name, orderByComparator);

		if (zskpProcess != null) {
			return zskpProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchZskpProcessException(msg.toString());
	}

	/**
	 * Returns the first zskp process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching zskp process, or <code>null</code> if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess fetchByname_First(String name,
		OrderByComparator<ZskpProcess> orderByComparator) {
		List<ZskpProcess> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last zskp process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching zskp process
	 * @throws NoSuchZskpProcessException if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess findByname_Last(String name,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		ZskpProcess zskpProcess = fetchByname_Last(name, orderByComparator);

		if (zskpProcess != null) {
			return zskpProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchZskpProcessException(msg.toString());
	}

	/**
	 * Returns the last zskp process in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching zskp process, or <code>null</code> if a matching zskp process could not be found
	 */
	@Override
	public ZskpProcess fetchByname_Last(String name,
		OrderByComparator<ZskpProcess> orderByComparator) {
		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<ZskpProcess> list = findByname(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ZskpProcess[] findByname_PrevAndNext(long processId, String name,
		OrderByComparator<ZskpProcess> orderByComparator)
		throws NoSuchZskpProcessException {
		name = Objects.toString(name, "");

		ZskpProcess zskpProcess = findByPrimaryKey(processId);

		Session session = null;

		try {
			session = openSession();

			ZskpProcess[] array = new ZskpProcessImpl[3];

			array[0] = getByname_PrevAndNext(session, zskpProcess, name,
					orderByComparator, true);

			array[1] = zskpProcess;

			array[2] = getByname_PrevAndNext(session, zskpProcess, name,
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

	protected ZskpProcess getByname_PrevAndNext(Session session,
		ZskpProcess zskpProcess, String name,
		OrderByComparator<ZskpProcess> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ZSKPPROCESS_WHERE);

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
			query.append(ZskpProcessModelImpl.ORDER_BY_JPQL);
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
					zskpProcess)) {
				qPos.add(orderByConditionValue);
			}
		}

		List<ZskpProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the zskp processes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByname(String name) {
		for (ZskpProcess zskpProcess : findByname(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(zskpProcess);
		}
	}

	/**
	 * Returns the number of zskp processes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching zskp processes
	 */
	@Override
	public int countByname(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByname;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ZSKPPROCESS_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "zskpProcess.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(zskpProcess.name IS NULL OR zskpProcess.name = '')";

	public ZskpProcessPersistenceImpl() {
		setModelClass(ZskpProcess.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
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
	 * Caches the zskp process in the entity cache if it is enabled.
	 *
	 * @param zskpProcess the zskp process
	 */
	@Override
	public void cacheResult(ZskpProcess zskpProcess) {
		entityCache.putResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
			ZskpProcessImpl.class, zskpProcess.getPrimaryKey(), zskpProcess);

		zskpProcess.resetOriginalValues();
	}

	/**
	 * Caches the zskp processes in the entity cache if it is enabled.
	 *
	 * @param zskpProcesses the zskp processes
	 */
	@Override
	public void cacheResult(List<ZskpProcess> zskpProcesses) {
		for (ZskpProcess zskpProcess : zskpProcesses) {
			if (entityCache.getResult(
						ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
						ZskpProcessImpl.class, zskpProcess.getPrimaryKey()) == null) {
				cacheResult(zskpProcess);
			}
			else {
				zskpProcess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all zskp processes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ZskpProcessImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the zskp process.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ZskpProcess zskpProcess) {
		entityCache.removeResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
			ZskpProcessImpl.class, zskpProcess.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ZskpProcess> zskpProcesses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ZskpProcess zskpProcess : zskpProcesses) {
			entityCache.removeResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessImpl.class, zskpProcess.getPrimaryKey());
		}
	}

	/**
	 * Creates a new zskp process with the primary key. Does not add the zskp process to the database.
	 *
	 * @param processId the primary key for the new zskp process
	 * @return the new zskp process
	 */
	@Override
	public ZskpProcess create(long processId) {
		ZskpProcess zskpProcess = new ZskpProcessImpl();

		zskpProcess.setNew(true);
		zskpProcess.setPrimaryKey(processId);

		String uuid = PortalUUIDUtil.generate();

		zskpProcess.setUuid(uuid);

		return zskpProcess;
	}

	/**
	 * Removes the zskp process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processId the primary key of the zskp process
	 * @return the zskp process that was removed
	 * @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess remove(long processId) throws NoSuchZskpProcessException {
		return remove((Serializable)processId);
	}

	/**
	 * Removes the zskp process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the zskp process
	 * @return the zskp process that was removed
	 * @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess remove(Serializable primaryKey)
		throws NoSuchZskpProcessException {
		Session session = null;

		try {
			session = openSession();

			ZskpProcess zskpProcess = (ZskpProcess)session.get(ZskpProcessImpl.class,
					primaryKey);

			if (zskpProcess == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchZskpProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(zskpProcess);
		}
		catch (NoSuchZskpProcessException nsee) {
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
	protected ZskpProcess removeImpl(ZskpProcess zskpProcess) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(zskpProcess)) {
				zskpProcess = (ZskpProcess)session.get(ZskpProcessImpl.class,
						zskpProcess.getPrimaryKeyObj());
			}

			if (zskpProcess != null) {
				session.delete(zskpProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (zskpProcess != null) {
			clearCache(zskpProcess);
		}

		return zskpProcess;
	}

	@Override
	public ZskpProcess updateImpl(ZskpProcess zskpProcess) {
		boolean isNew = zskpProcess.isNew();

		if (!(zskpProcess instanceof ZskpProcessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(zskpProcess.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(zskpProcess);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in zskpProcess proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ZskpProcess implementation " +
				zskpProcess.getClass());
		}

		ZskpProcessModelImpl zskpProcessModelImpl = (ZskpProcessModelImpl)zskpProcess;

		if (Validator.isNull(zskpProcess.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			zskpProcess.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (zskpProcess.isNew()) {
				session.save(zskpProcess);

				zskpProcess.setNew(false);
			}
			else {
				zskpProcess = (ZskpProcess)session.merge(zskpProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ZskpProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { zskpProcessModelImpl.getUuid() };

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
				args);

			args = new Object[] { zskpProcessModelImpl.getName() };

			finderCache.removeResult(_finderPathCountByname, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindByname,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(_finderPathWithoutPaginationFindAll,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((zskpProcessModelImpl.getColumnBitmask() &
					_finderPathWithoutPaginationFindByUuid.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						zskpProcessModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
					args);

				args = new Object[] { zskpProcessModelImpl.getUuid() };

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
					args);
			}

			if ((zskpProcessModelImpl.getColumnBitmask() &
					_finderPathWithoutPaginationFindByname.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						zskpProcessModelImpl.getOriginalName()
					};

				finderCache.removeResult(_finderPathCountByname, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByname,
					args);

				args = new Object[] { zskpProcessModelImpl.getName() };

				finderCache.removeResult(_finderPathCountByname, args);
				finderCache.removeResult(_finderPathWithoutPaginationFindByname,
					args);
			}
		}

		entityCache.putResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
			ZskpProcessImpl.class, zskpProcess.getPrimaryKey(), zskpProcess,
			false);

		zskpProcess.resetOriginalValues();

		return zskpProcess;
	}

	/**
	 * Returns the zskp process with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the zskp process
	 * @return the zskp process
	 * @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchZskpProcessException {
		ZskpProcess zskpProcess = fetchByPrimaryKey(primaryKey);

		if (zskpProcess == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchZskpProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return zskpProcess;
	}

	/**
	 * Returns the zskp process with the primary key or throws a {@link NoSuchZskpProcessException} if it could not be found.
	 *
	 * @param processId the primary key of the zskp process
	 * @return the zskp process
	 * @throws NoSuchZskpProcessException if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess findByPrimaryKey(long processId)
		throws NoSuchZskpProcessException {
		return findByPrimaryKey((Serializable)processId);
	}

	/**
	 * Returns the zskp process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the zskp process
	 * @return the zskp process, or <code>null</code> if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ZskpProcess zskpProcess = (ZskpProcess)serializable;

		if (zskpProcess == null) {
			Session session = null;

			try {
				session = openSession();

				zskpProcess = (ZskpProcess)session.get(ZskpProcessImpl.class,
						primaryKey);

				if (zskpProcess != null) {
					cacheResult(zskpProcess);
				}
				else {
					entityCache.putResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
						ZskpProcessImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
					ZskpProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return zskpProcess;
	}

	/**
	 * Returns the zskp process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processId the primary key of the zskp process
	 * @return the zskp process, or <code>null</code> if a zskp process with the primary key could not be found
	 */
	@Override
	public ZskpProcess fetchByPrimaryKey(long processId) {
		return fetchByPrimaryKey((Serializable)processId);
	}

	@Override
	public Map<Serializable, ZskpProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ZskpProcess> map = new HashMap<Serializable, ZskpProcess>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ZskpProcess zskpProcess = fetchByPrimaryKey(primaryKey);

			if (zskpProcess != null) {
				map.put(primaryKey, zskpProcess);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
					ZskpProcessImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ZskpProcess)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ZSKPPROCESS_WHERE_PKS_IN);

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

			for (ZskpProcess zskpProcess : (List<ZskpProcess>)q.list()) {
				map.put(zskpProcess.getPrimaryKeyObj(), zskpProcess);

				cacheResult(zskpProcess);

				uncachedPrimaryKeys.remove(zskpProcess.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
					ZskpProcessImpl.class, primaryKey, nullModel);
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
	 * Returns all the zskp processes.
	 *
	 * @return the zskp processes
	 */
	@Override
	public List<ZskpProcess> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ZskpProcess> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ZskpProcess> findAll(int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ZskpProcess> findAll(int start, int end,
		OrderByComparator<ZskpProcess> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ZskpProcess> list = null;

		if (retrieveFromCache) {
			list = (List<ZskpProcess>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ZSKPPROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ZSKPPROCESS;

				if (pagination) {
					sql = sql.concat(ZskpProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ZskpProcess>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the zskp processes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ZskpProcess zskpProcess : findAll()) {
			remove(zskpProcess);
		}
	}

	/**
	 * Returns the number of zskp processes.
	 *
	 * @return the number of zskp processes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(_finderPathCountAll,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ZSKPPROCESS);

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
		return ZskpProcessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the zskp process persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
				new String[0]);

		_finderPathCountAll = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
				new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByUuid",
				new String[] {
					String.class.getName(),
					
				Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
				new String[] { String.class.getName() },
				ZskpProcessModelImpl.UUID_COLUMN_BITMASK |
				ZskpProcessModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
				new String[] { String.class.getName() });

		_finderPathWithPaginationFindByname = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByname",
				new String[] {
					String.class.getName(),
					
				Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByname = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED,
				ZskpProcessImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
				new String[] { String.class.getName() },
				ZskpProcessModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByname = new FinderPath(ZskpProcessModelImpl.ENTITY_CACHE_ENABLED,
				ZskpProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
				new String[] { String.class.getName() });
	}

	public void destroy() {
		entityCache.removeCache(ZskpProcessImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ZSKPPROCESS = "SELECT zskpProcess FROM ZskpProcess zskpProcess";
	private static final String _SQL_SELECT_ZSKPPROCESS_WHERE_PKS_IN = "SELECT zskpProcess FROM ZskpProcess zskpProcess WHERE processId IN (";
	private static final String _SQL_SELECT_ZSKPPROCESS_WHERE = "SELECT zskpProcess FROM ZskpProcess zskpProcess WHERE ";
	private static final String _SQL_COUNT_ZSKPPROCESS = "SELECT COUNT(zskpProcess) FROM ZskpProcess zskpProcess";
	private static final String _SQL_COUNT_ZSKPPROCESS_WHERE = "SELECT COUNT(zskpProcess) FROM ZskpProcess zskpProcess WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "zskpProcess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ZskpProcess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ZskpProcess exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ZskpProcessPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
}