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

import java.util.Date;
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
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
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

	/**
	* Returns the company ID of this process.
	*
	* @return the company ID of this process
	*/
	@Override
	public long getCompanyId() {
		return _process.getCompanyId();
	}

	/**
	* Returns the create date of this process.
	*
	* @return the create date of this process
	*/
	@Override
	public Date getCreateDate() {
		return _process.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _process.getExpandoBridge();
	}

	/**
	* Returns the group ID of this process.
	*
	* @return the group ID of this process
	*/
	@Override
	public long getGroupId() {
		return _process.getGroupId();
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
	* Returns the modified date of this process.
	*
	* @return the modified date of this process
	*/
	@Override
	public Date getModifiedDate() {
		return _process.getModifiedDate();
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
	* Returns the status of this process.
	*
	* @return the status of this process
	*/
	@Override
	public int getStatus() {
		return _process.getStatus();
	}

	/**
	* Returns the status by user ID of this process.
	*
	* @return the status by user ID of this process
	*/
	@Override
	public long getStatusByUserId() {
		return _process.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this process.
	*
	* @return the status by user name of this process
	*/
	@Override
	public String getStatusByUserName() {
		return _process.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this process.
	*
	* @return the status by user uuid of this process
	*/
	@Override
	public String getStatusByUserUuid() {
		return _process.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this process.
	*
	* @return the status date of this process
	*/
	@Override
	public Date getStatusDate() {
		return _process.getStatusDate();
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

	/**
	* Returns the user ID of this process.
	*
	* @return the user ID of this process
	*/
	@Override
	public long getUserId() {
		return _process.getUserId();
	}

	/**
	* Returns the user name of this process.
	*
	* @return the user name of this process
	*/
	@Override
	public String getUserName() {
		return _process.getUserName();
	}

	/**
	* Returns the user uuid of this process.
	*
	* @return the user uuid of this process
	*/
	@Override
	public String getUserUuid() {
		return _process.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _process.hashCode();
	}

	/**
	* Returns <code>true</code> if this process is approved.
	*
	* @return <code>true</code> if this process is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _process.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _process.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this process is denied.
	*
	* @return <code>true</code> if this process is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _process.isDenied();
	}

	/**
	* Returns <code>true</code> if this process is a draft.
	*
	* @return <code>true</code> if this process is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _process.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _process.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this process is expired.
	*
	* @return <code>true</code> if this process is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _process.isExpired();
	}

	/**
	* Returns <code>true</code> if this process is inactive.
	*
	* @return <code>true</code> if this process is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _process.isInactive();
	}

	/**
	* Returns <code>true</code> if this process is incomplete.
	*
	* @return <code>true</code> if this process is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _process.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _process.isNew();
	}

	/**
	* Returns <code>true</code> if this process is pending.
	*
	* @return <code>true</code> if this process is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _process.isPending();
	}

	/**
	* Returns <code>true</code> if this process is scheduled.
	*
	* @return <code>true</code> if this process is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _process.isScheduled();
	}

	@Override
	public void persist() {
		_process.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_process.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this process.
	*
	* @param companyId the company ID of this process
	*/
	@Override
	public void setCompanyId(long companyId) {
		_process.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this process.
	*
	* @param createDate the create date of this process
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_process.setCreateDate(createDate);
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
	* Sets the group ID of this process.
	*
	* @param groupId the group ID of this process
	*/
	@Override
	public void setGroupId(long groupId) {
		_process.setGroupId(groupId);
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
	* Sets the modified date of this process.
	*
	* @param modifiedDate the modified date of this process
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_process.setModifiedDate(modifiedDate);
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
	* Sets the status of this process.
	*
	* @param status the status of this process
	*/
	@Override
	public void setStatus(int status) {
		_process.setStatus(status);
	}

	/**
	* Sets the status by user ID of this process.
	*
	* @param statusByUserId the status by user ID of this process
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_process.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this process.
	*
	* @param statusByUserName the status by user name of this process
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_process.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this process.
	*
	* @param statusByUserUuid the status by user uuid of this process
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_process.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this process.
	*
	* @param statusDate the status date of this process
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_process.setStatusDate(statusDate);
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

	/**
	* Sets the user ID of this process.
	*
	* @param userId the user ID of this process
	*/
	@Override
	public void setUserId(long userId) {
		_process.setUserId(userId);
	}

	/**
	* Sets the user name of this process.
	*
	* @param userName the user name of this process
	*/
	@Override
	public void setUserName(String userName) {
		_process.setUserName(userName);
	}

	/**
	* Sets the user uuid of this process.
	*
	* @param userUuid the user uuid of this process
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_process.setUserUuid(userUuid);
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