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
 * This class is a wrapper for {@link ZskpProcess}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcess
 * @generated
 */
@ProviderType
public class ZskpProcessWrapper implements ZskpProcess,
	ModelWrapper<ZskpProcess> {
	public ZskpProcessWrapper(ZskpProcess zskpProcess) {
		_zskpProcess = zskpProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return ZskpProcess.class;
	}

	@Override
	public String getModelClassName() {
		return ZskpProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("processId", getProcessId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("kind", getKind());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long processId = (Long)attributes.get("processId");

		if (processId != null) {
			setProcessId(processId);
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
		return new ZskpProcessWrapper((ZskpProcess)_zskpProcess.clone());
	}

	@Override
	public int compareTo(ZskpProcess zskpProcess) {
		return _zskpProcess.compareTo(zskpProcess);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _zskpProcess.getExpandoBridge();
	}

	/**
	* Returns the kind of this zskp process.
	*
	* @return the kind of this zskp process
	*/
	@Override
	public long getKind() {
		return _zskpProcess.getKind();
	}

	/**
	* Returns the name of this zskp process.
	*
	* @return the name of this zskp process
	*/
	@Override
	public String getName() {
		return _zskpProcess.getName();
	}

	/**
	* Returns the primary key of this zskp process.
	*
	* @return the primary key of this zskp process
	*/
	@Override
	public long getPrimaryKey() {
		return _zskpProcess.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _zskpProcess.getPrimaryKeyObj();
	}

	/**
	* Returns the process ID of this zskp process.
	*
	* @return the process ID of this zskp process
	*/
	@Override
	public long getProcessId() {
		return _zskpProcess.getProcessId();
	}

	/**
	* Returns the type of this zskp process.
	*
	* @return the type of this zskp process
	*/
	@Override
	public long getType() {
		return _zskpProcess.getType();
	}

	/**
	* Returns the uuid of this zskp process.
	*
	* @return the uuid of this zskp process
	*/
	@Override
	public String getUuid() {
		return _zskpProcess.getUuid();
	}

	@Override
	public int hashCode() {
		return _zskpProcess.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _zskpProcess.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _zskpProcess.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _zskpProcess.isNew();
	}

	@Override
	public void persist() {
		_zskpProcess.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_zskpProcess.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_zskpProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_zskpProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_zskpProcess.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the kind of this zskp process.
	*
	* @param kind the kind of this zskp process
	*/
	@Override
	public void setKind(long kind) {
		_zskpProcess.setKind(kind);
	}

	/**
	* Sets the name of this zskp process.
	*
	* @param name the name of this zskp process
	*/
	@Override
	public void setName(String name) {
		_zskpProcess.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_zskpProcess.setNew(n);
	}

	/**
	* Sets the primary key of this zskp process.
	*
	* @param primaryKey the primary key of this zskp process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_zskpProcess.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_zskpProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the process ID of this zskp process.
	*
	* @param processId the process ID of this zskp process
	*/
	@Override
	public void setProcessId(long processId) {
		_zskpProcess.setProcessId(processId);
	}

	/**
	* Sets the type of this zskp process.
	*
	* @param type the type of this zskp process
	*/
	@Override
	public void setType(long type) {
		_zskpProcess.setType(type);
	}

	/**
	* Sets the uuid of this zskp process.
	*
	* @param uuid the uuid of this zskp process
	*/
	@Override
	public void setUuid(String uuid) {
		_zskpProcess.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ZskpProcess> toCacheModel() {
		return _zskpProcess.toCacheModel();
	}

	@Override
	public ZskpProcess toEscapedModel() {
		return new ZskpProcessWrapper(_zskpProcess.toEscapedModel());
	}

	@Override
	public String toString() {
		return _zskpProcess.toString();
	}

	@Override
	public ZskpProcess toUnescapedModel() {
		return new ZskpProcessWrapper(_zskpProcess.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _zskpProcess.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ZskpProcessWrapper)) {
			return false;
		}

		ZskpProcessWrapper zskpProcessWrapper = (ZskpProcessWrapper)obj;

		if (Objects.equals(_zskpProcess, zskpProcessWrapper._zskpProcess)) {
			return true;
		}

		return false;
	}

	@Override
	public ZskpProcess getWrappedModel() {
		return _zskpProcess;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _zskpProcess.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _zskpProcess.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_zskpProcess.resetOriginalValues();
	}

	private final ZskpProcess _zskpProcess;
}