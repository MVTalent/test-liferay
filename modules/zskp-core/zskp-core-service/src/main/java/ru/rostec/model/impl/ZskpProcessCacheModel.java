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

import ru.rostec.model.ZskpProcess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ZskpProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcess
 * @generated
 */
@ProviderType
public class ZskpProcessCacheModel implements CacheModel<ZskpProcess>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ZskpProcessCacheModel)) {
			return false;
		}

		ZskpProcessCacheModel zskpProcessCacheModel = (ZskpProcessCacheModel)obj;

		if (processId == zskpProcessCacheModel.processId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, processId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", processId=");
		sb.append(processId);
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
	public ZskpProcess toEntityModel() {
		ZskpProcessImpl zskpProcessImpl = new ZskpProcessImpl();

		if (uuid == null) {
			zskpProcessImpl.setUuid("");
		}
		else {
			zskpProcessImpl.setUuid(uuid);
		}

		zskpProcessImpl.setProcessId(processId);

		if (name == null) {
			zskpProcessImpl.setName("");
		}
		else {
			zskpProcessImpl.setName(name);
		}

		zskpProcessImpl.setType(type);
		zskpProcessImpl.setKind(kind);

		zskpProcessImpl.resetOriginalValues();

		return zskpProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		processId = objectInput.readLong();
		name = objectInput.readUTF();

		type = objectInput.readLong();

		kind = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(processId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(type);

		objectOutput.writeLong(kind);
	}

	public String uuid;
	public long processId;
	public String name;
	public long type;
	public long kind;
}