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
 * This class is used by SOAP remote services, specifically {@link ru.rostec.service.http.KindServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.http.KindServiceSoap
 * @generated
 */
@ProviderType
public class KindSoap implements Serializable {
	public static KindSoap toSoapModel(Kind model) {
		KindSoap soapModel = new KindSoap();

		soapModel.setId(model.getId());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static KindSoap[] toSoapModels(Kind[] models) {
		KindSoap[] soapModels = new KindSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KindSoap[][] toSoapModels(Kind[][] models) {
		KindSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KindSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KindSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KindSoap[] toSoapModels(List<Kind> models) {
		List<KindSoap> soapModels = new ArrayList<KindSoap>(models.size());

		for (Kind model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KindSoap[soapModels.size()]);
	}

	public KindSoap() {
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _id;
	private String _code;
	private String _name;
}