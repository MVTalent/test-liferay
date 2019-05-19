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

package org.javasavvy.process.core.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.javasavvy.process.core.service.model.Process;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

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

		if (processId == processCacheModel.processId) {
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
		StringBundler sb = new StringBundler(19);

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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Process toEntityModel() {
		ProcessImpl processImpl = new ProcessImpl();

		if (uuid == null) {
			processImpl.setUuid("");
		}
		else {
			processImpl.setUuid(uuid);
		}

		processImpl.setProcessId(processId);

		if (name == null) {
			processImpl.setName("");
		}
		else {
			processImpl.setName(name);
		}

		processImpl.setType(type);
		processImpl.setKind(kind);
		processImpl.setStatus(status);
		processImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			processImpl.setStatusByUserName("");
		}
		else {
			processImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			processImpl.setStatusDate(null);
		}
		else {
			processImpl.setStatusDate(new Date(statusDate));
		}

		processImpl.resetOriginalValues();

		return processImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		processId = objectInput.readLong();
		name = objectInput.readUTF();

		type = objectInput.readLong();

		kind = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long processId;
	public String name;
	public long type;
	public long kind;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}