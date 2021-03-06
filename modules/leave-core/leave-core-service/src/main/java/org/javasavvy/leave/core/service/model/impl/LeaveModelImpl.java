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

package org.javasavvy.leave.core.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.model.LeaveModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Leave service. Represents a row in the &quot;js_Leave&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LeaveModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LeaveImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveImpl
 * @see Leave
 * @see LeaveModel
 * @generated
 */
@ProviderType
public class LeaveModelImpl extends BaseModelImpl<Leave> implements LeaveModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a leave model instance should use the {@link Leave} interface instead.
	 */
	public static final String TABLE_NAME = "js_Leave";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "leaveId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "leaveName", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("leaveId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("leaveName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table js_Leave (uuid_ VARCHAR(75) null,leaveId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,leaveName VARCHAR(75) null,startDate DATE null,endDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table js_Leave";
	public static final String ORDER_BY_JPQL = " ORDER BY leave.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY js_Leave.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.javasavvy.leave.core.service.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.javasavvy.leave.core.service.model.Leave"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.javasavvy.leave.core.service.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.javasavvy.leave.core.service.model.Leave"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.javasavvy.leave.core.service.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.javasavvy.leave.core.service.model.Leave"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long STATUS_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.javasavvy.leave.core.service.service.util.ServiceProps.get(
				"lock.expiration.time.org.javasavvy.leave.core.service.model.Leave"));

	public LeaveModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _leaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Leave.class;
	}

	@Override
	public String getModelClassName() {
		return Leave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Leave, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Leave, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Leave, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((Leave)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Leave, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Leave, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Leave)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Leave, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Leave, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Leave, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<Leave, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<Leave, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<Leave, Object>>();
		Map<String, BiConsumer<Leave, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<Leave, ?>>();


		attributeGetterFunctions.put(
			"uuid",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object uuid) {
					leave.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"leaveId",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getLeaveId();
				}

			});
		attributeSetterBiConsumers.put(
			"leaveId",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object leaveId) {
					leave.setLeaveId((Long)leaveId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object groupId) {
					leave.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object companyId) {
					leave.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object userId) {
					leave.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object userName) {
					leave.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object createDate) {
					leave.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object modifiedDate) {
					leave.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"leaveName",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getLeaveName();
				}

			});
		attributeSetterBiConsumers.put(
			"leaveName",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object leaveName) {
					leave.setLeaveName((String)leaveName);
				}

			});
		attributeGetterFunctions.put(
			"startDate",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getStartDate();
				}

			});
		attributeSetterBiConsumers.put(
			"startDate",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object startDate) {
					leave.setStartDate((Date)startDate);
				}

			});
		attributeGetterFunctions.put(
			"endDate",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getEndDate();
				}

			});
		attributeSetterBiConsumers.put(
			"endDate",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object endDate) {
					leave.setEndDate((Date)endDate);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object status) {
					leave.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object statusByUserId) {
					leave.setStatusByUserId((Long)statusByUserId);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object statusByUserName) {
					leave.setStatusByUserName((String)statusByUserName);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<Leave, Object>() {

				@Override
				public Object apply(Leave leave) {
					return leave.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<Leave, Object>() {

				@Override
				public void accept(Leave leave, Object statusDate) {
					leave.setStatusDate((Date)statusDate);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getLeaveId() {
		return _leaveId;
	}

	@Override
	public void setLeaveId(long leaveId) {
		_leaveId = leaveId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getLeaveName() {
		if (_leaveName == null) {
			return "";
		}
		else {
			return _leaveName;
		}
	}

	@Override
	public void setLeaveName(String leaveName) {
		_leaveName = leaveName;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Leave.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Leave.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Leave toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Leave)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LeaveImpl leaveImpl = new LeaveImpl();

		leaveImpl.setUuid(getUuid());
		leaveImpl.setLeaveId(getLeaveId());
		leaveImpl.setGroupId(getGroupId());
		leaveImpl.setCompanyId(getCompanyId());
		leaveImpl.setUserId(getUserId());
		leaveImpl.setUserName(getUserName());
		leaveImpl.setCreateDate(getCreateDate());
		leaveImpl.setModifiedDate(getModifiedDate());
		leaveImpl.setLeaveName(getLeaveName());
		leaveImpl.setStartDate(getStartDate());
		leaveImpl.setEndDate(getEndDate());
		leaveImpl.setStatus(getStatus());
		leaveImpl.setStatusByUserId(getStatusByUserId());
		leaveImpl.setStatusByUserName(getStatusByUserName());
		leaveImpl.setStatusDate(getStatusDate());

		leaveImpl.resetOriginalValues();

		return leaveImpl;
	}

	@Override
	public int compareTo(Leave leave) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), leave.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Leave)) {
			return false;
		}

		Leave leave = (Leave)obj;

		long primaryKey = leave.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LeaveModelImpl leaveModelImpl = this;

		leaveModelImpl._originalUuid = leaveModelImpl._uuid;

		leaveModelImpl._originalGroupId = leaveModelImpl._groupId;

		leaveModelImpl._setOriginalGroupId = false;

		leaveModelImpl._originalCompanyId = leaveModelImpl._companyId;

		leaveModelImpl._setOriginalCompanyId = false;

		leaveModelImpl._originalUserId = leaveModelImpl._userId;

		leaveModelImpl._setOriginalUserId = false;

		leaveModelImpl._setModifiedDate = false;

		leaveModelImpl._originalStatus = leaveModelImpl._status;

		leaveModelImpl._setOriginalStatus = false;

		leaveModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Leave> toCacheModel() {
		LeaveCacheModel leaveCacheModel = new LeaveCacheModel();

		leaveCacheModel.uuid = getUuid();

		String uuid = leaveCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			leaveCacheModel.uuid = null;
		}

		leaveCacheModel.leaveId = getLeaveId();

		leaveCacheModel.groupId = getGroupId();

		leaveCacheModel.companyId = getCompanyId();

		leaveCacheModel.userId = getUserId();

		leaveCacheModel.userName = getUserName();

		String userName = leaveCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			leaveCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			leaveCacheModel.createDate = createDate.getTime();
		}
		else {
			leaveCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			leaveCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			leaveCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		leaveCacheModel.leaveName = getLeaveName();

		String leaveName = leaveCacheModel.leaveName;

		if ((leaveName != null) && (leaveName.length() == 0)) {
			leaveCacheModel.leaveName = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			leaveCacheModel.startDate = startDate.getTime();
		}
		else {
			leaveCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			leaveCacheModel.endDate = endDate.getTime();
		}
		else {
			leaveCacheModel.endDate = Long.MIN_VALUE;
		}

		leaveCacheModel.status = getStatus();

		leaveCacheModel.statusByUserId = getStatusByUserId();

		leaveCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = leaveCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			leaveCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			leaveCacheModel.statusDate = statusDate.getTime();
		}
		else {
			leaveCacheModel.statusDate = Long.MIN_VALUE;
		}

		return leaveCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Leave, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<Leave, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Leave, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Leave)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Leave, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Leave, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<Leave, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Leave)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Leave.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Leave.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _leaveId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _leaveName;
	private Date _startDate;
	private Date _endDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Leave _escapedModel;
}