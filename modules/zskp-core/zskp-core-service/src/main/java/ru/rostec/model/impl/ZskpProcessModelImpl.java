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

package ru.rostec.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import ru.rostec.model.ZskpProcess;
import ru.rostec.model.ZskpProcessModel;
import ru.rostec.model.ZskpProcessSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ZskpProcess service. Represents a row in the &quot;ZSKP_ZskpProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ZskpProcessModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ZskpProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessImpl
 * @see ZskpProcess
 * @see ZskpProcessModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ZskpProcessModelImpl extends BaseModelImpl<ZskpProcess>
	implements ZskpProcessModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a zskp process model instance should use the {@link ZskpProcess} interface instead.
	 */
	public static final String TABLE_NAME = "ZSKP_ZskpProcess";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "processId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "type_", Types.BIGINT },
			{ "kind", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("processId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kind", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table ZSKP_ZskpProcess (uuid_ VARCHAR(75) null,processId LONG not null primary key,name VARCHAR(75) null,type_ LONG,kind LONG)";
	public static final String TABLE_SQL_DROP = "drop table ZSKP_ZskpProcess";
	public static final String ORDER_BY_JPQL = " ORDER BY zskpProcess.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ZSKP_ZskpProcess.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(ru.rostec.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.ru.rostec.model.ZskpProcess"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(ru.rostec.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.ru.rostec.model.ZskpProcess"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(ru.rostec.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.ru.rostec.model.ZskpProcess"),
			true);
	public static final long NAME_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ZskpProcess toModel(ZskpProcessSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ZskpProcess model = new ZskpProcessImpl();

		model.setUuid(soapModel.getUuid());
		model.setProcessId(soapModel.getProcessId());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());
		model.setKind(soapModel.getKind());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ZskpProcess> toModels(ZskpProcessSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ZskpProcess> models = new ArrayList<ZskpProcess>(soapModels.length);

		for (ZskpProcessSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(ru.rostec.service.util.ServiceProps.get(
				"lock.expiration.time.ru.rostec.model.ZskpProcess"));

	public ZskpProcessModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _processId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Map<String, Function<ZskpProcess, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ZskpProcess, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ZskpProcess, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((ZskpProcess)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ZskpProcess, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ZskpProcess, Object> attributeSetterBiConsumer = attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((ZskpProcess)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<ZskpProcess, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ZskpProcess, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ZskpProcess, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<ZskpProcess, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<ZskpProcess, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<ZskpProcess, Object>>();
		Map<String, BiConsumer<ZskpProcess, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<ZskpProcess, ?>>();


		attributeGetterFunctions.put(
			"uuid",
			new Function<ZskpProcess, Object>() {

				@Override
				public Object apply(ZskpProcess zskpProcess) {
					return zskpProcess.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<ZskpProcess, Object>() {

				@Override
				public void accept(ZskpProcess zskpProcess, Object uuid) {
					zskpProcess.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"processId",
			new Function<ZskpProcess, Object>() {

				@Override
				public Object apply(ZskpProcess zskpProcess) {
					return zskpProcess.getProcessId();
				}

			});
		attributeSetterBiConsumers.put(
			"processId",
			new BiConsumer<ZskpProcess, Object>() {

				@Override
				public void accept(ZskpProcess zskpProcess, Object processId) {
					zskpProcess.setProcessId((Long)processId);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<ZskpProcess, Object>() {

				@Override
				public Object apply(ZskpProcess zskpProcess) {
					return zskpProcess.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<ZskpProcess, Object>() {

				@Override
				public void accept(ZskpProcess zskpProcess, Object name) {
					zskpProcess.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"type",
			new Function<ZskpProcess, Object>() {

				@Override
				public Object apply(ZskpProcess zskpProcess) {
					return zskpProcess.getType();
				}

			});
		attributeSetterBiConsumers.put(
			"type",
			new BiConsumer<ZskpProcess, Object>() {

				@Override
				public void accept(ZskpProcess zskpProcess, Object type) {
					zskpProcess.setType((Long)type);
				}

			});
		attributeGetterFunctions.put(
			"kind",
			new Function<ZskpProcess, Object>() {

				@Override
				public Object apply(ZskpProcess zskpProcess) {
					return zskpProcess.getKind();
				}

			});
		attributeSetterBiConsumers.put(
			"kind",
			new BiConsumer<ZskpProcess, Object>() {

				@Override
				public void accept(ZskpProcess zskpProcess, Object kind) {
					zskpProcess.setKind((Long)kind);
				}

			});


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getProcessId() {
		return _processId;
	}

	@Override
	public void setProcessId(long processId) {
		_processId = processId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public long getType() {
		return _type;
	}

	@Override
	public void setType(long type) {
		_type = type;
	}

	@JSON
	@Override
	public long getKind() {
		return _kind;
	}

	@Override
	public void setKind(long kind) {
		_kind = kind;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ZskpProcess.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ZskpProcess toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ZskpProcess)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ZskpProcessImpl zskpProcessImpl = new ZskpProcessImpl();

		zskpProcessImpl.setUuid(getUuid());
		zskpProcessImpl.setProcessId(getProcessId());
		zskpProcessImpl.setName(getName());
		zskpProcessImpl.setType(getType());
		zskpProcessImpl.setKind(getKind());

		zskpProcessImpl.resetOriginalValues();

		return zskpProcessImpl;
	}

	@Override
	public int compareTo(ZskpProcess zskpProcess) {
		int value = 0;

		value = getName().compareTo(zskpProcess.getName());

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

		if (!(obj instanceof ZskpProcess)) {
			return false;
		}

		ZskpProcess zskpProcess = (ZskpProcess)obj;

		long primaryKey = zskpProcess.getPrimaryKey();

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
		ZskpProcessModelImpl zskpProcessModelImpl = this;

		zskpProcessModelImpl._originalUuid = zskpProcessModelImpl._uuid;

		zskpProcessModelImpl._originalName = zskpProcessModelImpl._name;

		zskpProcessModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ZskpProcess> toCacheModel() {
		ZskpProcessCacheModel zskpProcessCacheModel = new ZskpProcessCacheModel();

		zskpProcessCacheModel.uuid = getUuid();

		String uuid = zskpProcessCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			zskpProcessCacheModel.uuid = null;
		}

		zskpProcessCacheModel.processId = getProcessId();

		zskpProcessCacheModel.name = getName();

		String name = zskpProcessCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			zskpProcessCacheModel.name = null;
		}

		zskpProcessCacheModel.type = getType();

		zskpProcessCacheModel.kind = getKind();

		return zskpProcessCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ZskpProcess, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<ZskpProcess, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ZskpProcess, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ZskpProcess)this));
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
		Map<String, Function<ZskpProcess, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ZskpProcess, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<ZskpProcess, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ZskpProcess)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ZskpProcess.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ZskpProcess.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _processId;
	private String _name;
	private String _originalName;
	private long _type;
	private long _kind;
	private long _columnBitmask;
	private ZskpProcess _escapedModel;
}