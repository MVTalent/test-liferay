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

import ru.rostec.model.ZskpProcess;

import ru.rostec.service.ZskpProcessLocalServiceUtil;

/**
 * The extended model base implementation for the ZskpProcess service. Represents a row in the &quot;ZSKP_ZskpProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ZskpProcessImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessImpl
 * @see ZskpProcess
 * @generated
 */
@ProviderType
public abstract class ZskpProcessBaseImpl extends ZskpProcessModelImpl
	implements ZskpProcess {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a zskp process model instance should use the {@link ZskpProcess} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ZskpProcessLocalServiceUtil.addZskpProcess(this);
		}
		else {
			ZskpProcessLocalServiceUtil.updateZskpProcess(this);
		}
	}
}