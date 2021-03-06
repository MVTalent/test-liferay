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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Process service. Represents a row in the &quot;ZSKP_Process&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.rostec.model.impl.ProcessModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.rostec.model.impl.ProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @see ru.rostec.model.impl.ProcessImpl
 * @see ru.rostec.model.impl.ProcessModelImpl
 * @generated
 */
@ProviderType
public interface ProcessModel extends BaseModel<Process>, GroupedModel,
	ShardedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a process model instance should use the {@link Process} interface instead.
	 */

	/**
	 * Returns the primary key of this process.
	 *
	 * @return the primary key of this process
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this process.
	 *
	 * @param primaryKey the primary key of this process
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this process.
	 *
	 * @return the ID of this process
	 */
	public long getId();

	/**
	 * Sets the ID of this process.
	 *
	 * @param id the ID of this process
	 */
	public void setId(long id);

	/**
	 * Returns the name of this process.
	 *
	 * @return the name of this process
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this process.
	 *
	 * @param name the name of this process
	 */
	public void setName(String name);

	/**
	 * Returns the type of this process.
	 *
	 * @return the type of this process
	 */
	public long getType();

	/**
	 * Sets the type of this process.
	 *
	 * @param type the type of this process
	 */
	public void setType(long type);

	/**
	 * Returns the kind of this process.
	 *
	 * @return the kind of this process
	 */
	public long getKind();

	/**
	 * Sets the kind of this process.
	 *
	 * @param kind the kind of this process
	 */
	public void setKind(long kind);

	/**
	 * Returns the group ID of this process.
	 *
	 * @return the group ID of this process
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this process.
	 *
	 * @param groupId the group ID of this process
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this process.
	 *
	 * @return the company ID of this process
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this process.
	 *
	 * @param companyId the company ID of this process
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this process.
	 *
	 * @return the user ID of this process
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this process.
	 *
	 * @param userId the user ID of this process
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this process.
	 *
	 * @return the user uuid of this process
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this process.
	 *
	 * @param userUuid the user uuid of this process
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this process.
	 *
	 * @return the user name of this process
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this process.
	 *
	 * @param userName the user name of this process
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this process.
	 *
	 * @return the create date of this process
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this process.
	 *
	 * @param createDate the create date of this process
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this process.
	 *
	 * @return the modified date of this process
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this process.
	 *
	 * @param modifiedDate the modified date of this process
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this process.
	 *
	 * @return the status of this process
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this process.
	 *
	 * @param status the status of this process
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this process.
	 *
	 * @return the status by user ID of this process
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this process.
	 *
	 * @param statusByUserId the status by user ID of this process
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this process.
	 *
	 * @return the status by user uuid of this process
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this process.
	 *
	 * @param statusByUserUuid the status by user uuid of this process
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this process.
	 *
	 * @return the status by user name of this process
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this process.
	 *
	 * @param statusByUserName the status by user name of this process
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this process.
	 *
	 * @return the status date of this process
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this process.
	 *
	 * @param statusDate the status date of this process
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this process is approved.
	 *
	 * @return <code>true</code> if this process is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this process is denied.
	 *
	 * @return <code>true</code> if this process is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this process is a draft.
	 *
	 * @return <code>true</code> if this process is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this process is expired.
	 *
	 * @return <code>true</code> if this process is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this process is inactive.
	 *
	 * @return <code>true</code> if this process is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this process is incomplete.
	 *
	 * @return <code>true</code> if this process is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this process is pending.
	 *
	 * @return <code>true</code> if this process is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this process is scheduled.
	 *
	 * @return <code>true</code> if this process is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Process process);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Process> toCacheModel();

	@Override
	public Process toEscapedModel();

	@Override
	public Process toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}