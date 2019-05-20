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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ru.rostec.service.http.ProcessServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.http.ProcessServiceSoap
 * @generated
 */
@ProviderType
public class ProcessSoap implements Serializable {
	public static ProcessSoap toSoapModel(Process model) {
		ProcessSoap soapModel = new ProcessSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setKind(model.getKind());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static ProcessSoap[] toSoapModels(Process[] models) {
		ProcessSoap[] soapModels = new ProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProcessSoap[][] toSoapModels(Process[][] models) {
		ProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProcessSoap[] toSoapModels(List<Process> models) {
		List<ProcessSoap> soapModels = new ArrayList<ProcessSoap>(models.size());

		for (Process model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProcessSoap[soapModels.size()]);
	}

	public ProcessSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _id;
	private String _name;
	private long _type;
	private long _kind;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}