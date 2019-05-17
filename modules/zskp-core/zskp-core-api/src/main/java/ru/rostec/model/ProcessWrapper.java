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
 * This class is a wrapper for {@link Process}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @generated
 */
@ProviderType
public class ProcessWrapper implements Process, ModelWrapper<Process> {
	public ProcessWrapper(Process process) {
		_process = process;
	}

	@Override
	public Class<?> getModelClass() {
		return Process.class;
	}

	@Override
	public String getModelClassName() {
		return Process.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("kind", getKind());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long kind = (Long)attributes.get("kind");

		if (kind != null) {
			setKind(kind);
		}
	}

	@Override
	public Object clone() {
		return new ProcessWrapper((Process)_process.clone());
	}

	@Override
	public int compareTo(Process process) {
		return _process.compareTo(process);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _process.getExpandoBridge();
	}

	/**
	* Returns the ID of this process.
	*
	* @return the ID of this process
	*/
	@Override
	public long getId() {
		return _process.getId();
	}

	/**
	* Returns the kind of this process.
	*
	* @return the kind of this process
	*/
	@Override
	public long getKind() {
		return _process.getKind();
	}

	/**
	* Returns the name of this process.
	*
	* @return the name of this process
	*/
	@Override
	public String getName() {
		return _process.getName();
	}

	/**
	* Returns the primary key of this process.
	*
	* @return the primary key of this process
	*/
	@Override
	public long getPrimaryKey() {
		return _process.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _process.getPrimaryKeyObj();
	}

	/**
	* Returns the type of this process.
	*
	* @return the type of this process
	*/
	@Override
	public long getType() {
		return _process.getType();
	}

	@Override
	public int hashCode() {
		return _process.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _process.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _process.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _process.isNew();
	}

	@Override
	public void persist() {
		_process.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_process.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_process.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_process.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_process.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this process.
	*
	* @param id the ID of this process
	*/
	@Override
	public void setId(long id) {
		_process.setId(id);
	}

	/**
	* Sets the kind of this process.
	*
	* @param kind the kind of this process
	*/
	@Override
	public void setKind(long kind) {
		_process.setKind(kind);
	}

	/**
	* Sets the name of this process.
	*
	* @param name the name of this process
	*/
	@Override
	public void setName(String name) {
		_process.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_process.setNew(n);
	}

	/**
	* Sets the primary key of this process.
	*
	* @param primaryKey the primary key of this process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_process.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_process.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this process.
	*
	* @param type the type of this process
	*/
	@Override
	public void setType(long type) {
		_process.setType(type);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Process> toCacheModel() {
		return _process.toCacheModel();
	}

	@Override
	public Process toEscapedModel() {
		return new ProcessWrapper(_process.toEscapedModel());
	}

	@Override
	public String toString() {
		return _process.toString();
	}

	@Override
	public Process toUnescapedModel() {
		return new ProcessWrapper(_process.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _process.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessWrapper)) {
			return false;
		}

		ProcessWrapper processWrapper = (ProcessWrapper)obj;

		if (Objects.equals(_process, processWrapper._process)) {
			return true;
		}

		return false;
	}

	@Override
	public Process getWrappedModel() {
		return _process;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _process.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _process.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_process.resetOriginalValues();
	}

	private final Process _process;
}