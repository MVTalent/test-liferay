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
 * This class is a wrapper for {@link Type}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Type
 * @generated
 */
@ProviderType
public class TypeWrapper implements Type, ModelWrapper<Type> {
	public TypeWrapper(Type type) {
		_type = type;
	}

	@Override
	public Class<?> getModelClass() {
		return Type.class;
	}

	@Override
	public String getModelClassName() {
		return Type.class.getName();
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
		return new TypeWrapper((Type)_type.clone());
	}

	@Override
	public int compareTo(Type type) {
		return _type.compareTo(type);
	}

	/**
	* Returns the code of this type.
	*
	* @return the code of this type
	*/
	@Override
	public String getCode() {
		return _type.getCode();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _type.getExpandoBridge();
	}

	/**
	* Returns the ID of this type.
	*
	* @return the ID of this type
	*/
	@Override
	public long getId() {
		return _type.getId();
	}

	/**
	* Returns the name of this type.
	*
	* @return the name of this type
	*/
	@Override
	public String getName() {
		return _type.getName();
	}

	/**
	* Returns the primary key of this type.
	*
	* @return the primary key of this type
	*/
	@Override
	public long getPrimaryKey() {
		return _type.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _type.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _type.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _type.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _type.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _type.isNew();
	}

	@Override
	public void persist() {
		_type.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_type.setCachedModel(cachedModel);
	}

	/**
	* Sets the code of this type.
	*
	* @param code the code of this type
	*/
	@Override
	public void setCode(String code) {
		_type.setCode(code);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_type.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_type.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_type.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this type.
	*
	* @param id the ID of this type
	*/
	@Override
	public void setId(long id) {
		_type.setId(id);
	}

	/**
	* Sets the name of this type.
	*
	* @param name the name of this type
	*/
	@Override
	public void setName(String name) {
		_type.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_type.setNew(n);
	}

	/**
	* Sets the primary key of this type.
	*
	* @param primaryKey the primary key of this type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_type.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_type.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Type> toCacheModel() {
		return _type.toCacheModel();
	}

	@Override
	public Type toEscapedModel() {
		return new TypeWrapper(_type.toEscapedModel());
	}

	@Override
	public String toString() {
		return _type.toString();
	}

	@Override
	public Type toUnescapedModel() {
		return new TypeWrapper(_type.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _type.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeWrapper)) {
			return false;
		}

		TypeWrapper typeWrapper = (TypeWrapper)obj;

		if (Objects.equals(_type, typeWrapper._type)) {
			return true;
		}

		return false;
	}

	@Override
	public Type getWrappedModel() {
		return _type;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _type.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _type.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_type.resetOriginalValues();
	}

	private final Type _type;
}