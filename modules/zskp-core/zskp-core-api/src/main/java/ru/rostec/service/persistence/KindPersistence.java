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

import ru.rostec.exception.NoSuchKindException;

import ru.rostec.model.Kind;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the kind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.persistence.impl.KindPersistenceImpl
 * @see KindUtil
 * @generated
 */
@ProviderType
public interface KindPersistence extends BasePersistence<Kind> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KindUtil} to access the kind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Kind> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	* Caches the kind in the entity cache if it is enabled.
	*
	* @param kind the kind
	*/
	public void cacheResult(Kind kind);

	/**
	* Caches the kinds in the entity cache if it is enabled.
	*
	* @param kinds the kinds
	*/
	public void cacheResult(java.util.List<Kind> kinds);

	/**
	* Creates a new kind with the primary key. Does not add the kind to the database.
	*
	* @param id the primary key for the new kind
	* @return the new kind
	*/
	public Kind create(long id);

	/**
	* Removes the kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the kind
	* @return the kind that was removed
	* @throws NoSuchKindException if a kind with the primary key could not be found
	*/
	public Kind remove(long id) throws NoSuchKindException;

	public Kind updateImpl(Kind kind);

	/**
	* Returns the kind with the primary key or throws a {@link NoSuchKindException} if it could not be found.
	*
	* @param id the primary key of the kind
	* @return the kind
	* @throws NoSuchKindException if a kind with the primary key could not be found
	*/
	public Kind findByPrimaryKey(long id) throws NoSuchKindException;

	/**
	* Returns the kind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the kind
	* @return the kind, or <code>null</code> if a kind with the primary key could not be found
	*/
	public Kind fetchByPrimaryKey(long id);

	/**
	* Returns all the kinds.
	*
	* @return the kinds
	*/
	public java.util.List<Kind> findAll();

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
	public java.util.List<Kind> findAll(int start, int end);

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
	public java.util.List<Kind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Kind> orderByComparator);

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
	public java.util.List<Kind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Kind> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the kinds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of kinds.
	*
	* @return the number of kinds
	*/
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();
}