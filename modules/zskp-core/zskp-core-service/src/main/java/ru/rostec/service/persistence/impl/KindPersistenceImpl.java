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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import ru.rostec.exception.NoSuchKindException;

import ru.rostec.model.Kind;
import ru.rostec.model.impl.KindImpl;
import ru.rostec.model.impl.KindModelImpl;

import ru.rostec.service.persistence.KindPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the kind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KindPersistence
 * @see ru.rostec.service.persistence.KindUtil
 * @generated
 */
@ProviderType
public class KindPersistenceImpl extends BasePersistenceImpl<Kind>
	implements KindPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KindUtil} to access the kind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KindImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public KindPersistenceImpl() {
		setModelClass(Kind.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");
			dbColumnNames.put("code", "code_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the kind in the entity cache if it is enabled.
	 *
	 * @param kind the kind
	 */
	@Override
	public void cacheResult(Kind kind) {
		entityCache.putResult(KindModelImpl.ENTITY_CACHE_ENABLED,
			KindImpl.class, kind.getPrimaryKey(), kind);

		kind.resetOriginalValues();
	}

	/**
	 * Caches the kinds in the entity cache if it is enabled.
	 *
	 * @param kinds the kinds
	 */
	@Override
	public void cacheResult(List<Kind> kinds) {
		for (Kind kind : kinds) {
			if (entityCache.getResult(KindModelImpl.ENTITY_CACHE_ENABLED,
						KindImpl.class, kind.getPrimaryKey()) == null) {
				cacheResult(kind);
			}
			else {
				kind.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kinds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KindImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kind.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Kind kind) {
		entityCache.removeResult(KindModelImpl.ENTITY_CACHE_ENABLED,
			KindImpl.class, kind.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Kind> kinds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Kind kind : kinds) {
			entityCache.removeResult(KindModelImpl.ENTITY_CACHE_ENABLED,
				KindImpl.class, kind.getPrimaryKey());
		}
	}

	/**
	 * Creates a new kind with the primary key. Does not add the kind to the database.
	 *
	 * @param id the primary key for the new kind
	 * @return the new kind
	 */
	@Override
	public Kind create(long id) {
		Kind kind = new KindImpl();

		kind.setNew(true);
		kind.setPrimaryKey(id);

		return kind;
	}

	/**
	 * Removes the kind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the kind
	 * @return the kind that was removed
	 * @throws NoSuchKindException if a kind with the primary key could not be found
	 */
	@Override
	public Kind remove(long id) throws NoSuchKindException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the kind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kind
	 * @return the kind that was removed
	 * @throws NoSuchKindException if a kind with the primary key could not be found
	 */
	@Override
	public Kind remove(Serializable primaryKey) throws NoSuchKindException {
		Session session = null;

		try {
			session = openSession();

			Kind kind = (Kind)session.get(KindImpl.class, primaryKey);

			if (kind == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kind);
		}
		catch (NoSuchKindException nsee) {
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
	protected Kind removeImpl(Kind kind) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kind)) {
				kind = (Kind)session.get(KindImpl.class, kind.getPrimaryKeyObj());
			}

			if (kind != null) {
				session.delete(kind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kind != null) {
			clearCache(kind);
		}

		return kind;
	}

	@Override
	public Kind updateImpl(Kind kind) {
		boolean isNew = kind.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kind.isNew()) {
				session.save(kind);

				kind.setNew(false);
			}
			else {
				kind = (Kind)session.merge(kind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(_finderPathWithoutPaginationFindAll,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(KindModelImpl.ENTITY_CACHE_ENABLED,
			KindImpl.class, kind.getPrimaryKey(), kind, false);

		kind.resetOriginalValues();

		return kind;
	}

	/**
	 * Returns the kind with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kind
	 * @return the kind
	 * @throws NoSuchKindException if a kind with the primary key could not be found
	 */
	@Override
	public Kind findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKindException {
		Kind kind = fetchByPrimaryKey(primaryKey);

		if (kind == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kind;
	}

	/**
	 * Returns the kind with the primary key or throws a {@link NoSuchKindException} if it could not be found.
	 *
	 * @param id the primary key of the kind
	 * @return the kind
	 * @throws NoSuchKindException if a kind with the primary key could not be found
	 */
	@Override
	public Kind findByPrimaryKey(long id) throws NoSuchKindException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the kind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kind
	 * @return the kind, or <code>null</code> if a kind with the primary key could not be found
	 */
	@Override
	public Kind fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(KindModelImpl.ENTITY_CACHE_ENABLED,
				KindImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Kind kind = (Kind)serializable;

		if (kind == null) {
			Session session = null;

			try {
				session = openSession();

				kind = (Kind)session.get(KindImpl.class, primaryKey);

				if (kind != null) {
					cacheResult(kind);
				}
				else {
					entityCache.putResult(KindModelImpl.ENTITY_CACHE_ENABLED,
						KindImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(KindModelImpl.ENTITY_CACHE_ENABLED,
					KindImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kind;
	}

	/**
	 * Returns the kind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the kind
	 * @return the kind, or <code>null</code> if a kind with the primary key could not be found
	 */
	@Override
	public Kind fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Kind> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Kind> map = new HashMap<Serializable, Kind>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Kind kind = fetchByPrimaryKey(primaryKey);

			if (kind != null) {
				map.put(primaryKey, kind);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(KindModelImpl.ENTITY_CACHE_ENABLED,
					KindImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Kind)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_KIND_WHERE_PKS_IN);

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

			for (Kind kind : (List<Kind>)q.list()) {
				map.put(kind.getPrimaryKeyObj(), kind);

				cacheResult(kind);

				uncachedPrimaryKeys.remove(kind.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(KindModelImpl.ENTITY_CACHE_ENABLED,
					KindImpl.class, primaryKey, nullModel);
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
	 * Returns all the kinds.
	 *
	 * @return the kinds
	 */
	@Override
	public List<Kind> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Kind> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Kind> findAll(int start, int end,
		OrderByComparator<Kind> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Kind> findAll(int start, int end,
		OrderByComparator<Kind> orderByComparator, boolean retrieveFromCache) {
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

		List<Kind> list = null;

		if (retrieveFromCache) {
			list = (List<Kind>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KIND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KIND;

				if (pagination) {
					sql = sql.concat(KindModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Kind>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Kind>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the kinds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Kind kind : findAll()) {
			remove(kind);
		}
	}

	/**
	 * Returns the number of kinds.
	 *
	 * @return the number of kinds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(_finderPathCountAll,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KIND);

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
		return KindModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kind persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(KindModelImpl.ENTITY_CACHE_ENABLED,
				KindModelImpl.FINDER_CACHE_ENABLED, KindImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(KindModelImpl.ENTITY_CACHE_ENABLED,
				KindModelImpl.FINDER_CACHE_ENABLED, KindImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
				new String[0]);

		_finderPathCountAll = new FinderPath(KindModelImpl.ENTITY_CACHE_ENABLED,
				KindModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
				new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(KindImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_KIND = "SELECT kind FROM Kind kind";
	private static final String _SQL_SELECT_KIND_WHERE_PKS_IN = "SELECT kind FROM Kind kind WHERE id_ IN (";
	private static final String _SQL_COUNT_KIND = "SELECT COUNT(kind) FROM Kind kind";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kind.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kind exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(KindPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "code"
			});
}