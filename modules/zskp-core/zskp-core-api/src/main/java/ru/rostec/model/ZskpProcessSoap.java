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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ru.rostec.service.http.ZskpProcessServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.http.ZskpProcessServiceSoap
 * @generated
 */
@ProviderType
public class ZskpProcessSoap implements Serializable {
	public static ZskpProcessSoap toSoapModel(ZskpProcess model) {
		ZskpProcessSoap soapModel = new ZskpProcessSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProcessId(model.getProcessId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setKind(model.getKind());

		return soapModel;
	}

	public static ZskpProcessSoap[] toSoapModels(ZskpProcess[] models) {
		ZskpProcessSoap[] soapModels = new ZskpProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ZskpProcessSoap[][] toSoapModels(ZskpProcess[][] models) {
		ZskpProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ZskpProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ZskpProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ZskpProcessSoap[] toSoapModels(List<ZskpProcess> models) {
		List<ZskpProcessSoap> soapModels = new ArrayList<ZskpProcessSoap>(models.size());

		for (ZskpProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ZskpProcessSoap[soapModels.size()]);
	}

	public ZskpProcessSoap() {
	}

	public long getPrimaryKey() {
		return _processId;
	}

	public void setPrimaryKey(long pk) {
		setProcessId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProcessId() {
		return _processId;
	}

	public void setProcessId(long processId) {
		_processId = processId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public long getKind() {
		return _kind;
	}

	public void setKind(long kind) {
		_kind = kind;
	}

	private String _uuid;
	private long _processId;
	private String _name;
	private long _type;
	private long _kind;
}