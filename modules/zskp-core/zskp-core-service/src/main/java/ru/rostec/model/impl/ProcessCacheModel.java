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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import ru.rostec.model.Process;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Process in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @generated
 */
@ProviderType
public class ProcessCacheModel implements CacheModel<Process>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessCacheModel)) {
			return false;
		}

		ProcessCacheModel processCacheModel = (ProcessCacheModel)obj;

		if (id == processCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", kind=");
		sb.append(kind);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Process toEntityModel() {
		ProcessImpl processImpl = new ProcessImpl();

		processImpl.setId(id);

		if (name == null) {
			processImpl.setName("");
		}
		else {
			processImpl.setName(name);
		}

		processImpl.setType(type);
		processImpl.setKind(kind);

		processImpl.resetOriginalValues();

		return processImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();

		type = objectInput.readLong();

		kind = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(type);

		objectOutput.writeLong(kind);
	}

	public long id;
	public String name;
	public long type;
	public long kind;
}