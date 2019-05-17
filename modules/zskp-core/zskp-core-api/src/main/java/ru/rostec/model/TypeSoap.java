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
 * This class is used by SOAP remote services, specifically {@link ru.rostec.service.http.TypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see ru.rostec.service.http.TypeServiceSoap
 * @generated
 */
@ProviderType
public class TypeSoap implements Serializable {
	public static TypeSoap toSoapModel(Type model) {
		TypeSoap soapModel = new TypeSoap();

		soapModel.setId(model.getId());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static TypeSoap[] toSoapModels(Type[] models) {
		TypeSoap[] soapModels = new TypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeSoap[][] toSoapModels(Type[][] models) {
		TypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeSoap[] toSoapModels(List<Type> models) {
		List<TypeSoap> soapModels = new ArrayList<TypeSoap>(models.size());

		for (Type model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeSoap[soapModels.size()]);
	}

	public TypeSoap() {
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