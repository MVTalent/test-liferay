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

package ru.rostec.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Kind}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Kind
 * @generated
 */
@ProviderType
public class KindWrapper implements Kind, ModelWrapper<Kind> {
	public KindWrapper(Kind kind) {
		_kind = kind;
	}

	@Override
	public Class<?> getModelClass() {
		return Kind.class;
	}

	@Override
	public String getModelClassName() {
		return Kind.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Object clone() {
		return new KindWrapper((Kind)_kind.clone());
	}

	@Override
	public int compareTo(Kind kind) {
		return _kind.compareTo(kind);
	}

	/**
	* Returns the code of this kind.
	*
	* @return the code of this kind
	*/
	@Override
	public String getCode() {
		return _kind.getCode();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _kind.getExpandoBridge();
	}

	/**
	* Returns the ID of this kind.
	*
	* @return the ID of this kind
	*/
	@Override
	public long getId() {
		return _kind.getId();
	}

	/**
	* Returns the name of this kind.
	*
	* @return the name of this kind
	*/
	@Override
	public String getName() {
		return _kind.getName();
	}

	/**
	* Returns the primary key of this kind.
	*
	* @return the primary key of this kind
	*/
	@Override
	public long getPrimaryKey() {
		return _kind.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kind.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _kind.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _kind.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _kind.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _kind.isNew();
	}

	@Override
	public void persist() {
		_kind.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kind.setCachedModel(cachedModel);
	}

	/**
	* Sets the code of this kind.
	*
	* @param code the code of this kind
	*/
	@Override
	public void setCode(String code) {
		_kind.setCode(code);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_kind.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_kind.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_kind.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this kind.
	*
	* @param id the ID of this kind
	*/
	@Override
	public void setId(long id) {
		_kind.setId(id);
	}

	/**
	* Sets the name of this kind.
	*
	* @param name the name of this kind
	*/
	@Override
	public void setName(String name) {
		_kind.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_kind.setNew(n);
	}

	/**
	* Sets the primary key of this kind.
	*
	* @param primaryKey the primary key of this kind
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kind.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_kind.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Kind> toCacheModel() {
		return _kind.toCacheModel();
	}

	@Override
	public Kind toEscapedModel() {
		return new KindWrapper(_kind.toEscapedModel());
	}

	@Override
	public String toString() {
		return _kind.toString();
	}

	@Override
	public Kind toUnescapedModel() {
		return new KindWrapper(_kind.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _kind.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KindWrapper)) {
			return false;
		}

		KindWrapper kindWrapper = (KindWrapper)obj;

		if (Objects.equals(_kind, kindWrapper._kind)) {
			return true;
		}

		return false;
	}

	@Override
	public Kind getWrappedModel() {
		return _kind;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _kind.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _kind.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_kind.resetOriginalValues();
	}

	private final Kind _kind;
}