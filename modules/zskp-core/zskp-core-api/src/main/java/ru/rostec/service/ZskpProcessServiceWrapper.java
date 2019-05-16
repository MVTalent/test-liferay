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

package ru.rostec.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ZskpProcessService}.
 *
 * @author Brian Wing Shun Chan
 * @see ZskpProcessService
 * @generated
 */
@ProviderType
public class ZskpProcessServiceWrapper implements ZskpProcessService,
	ServiceWrapper<ZskpProcessService> {
	public ZskpProcessServiceWrapper(ZskpProcessService zskpProcessService) {
		_zskpProcessService = zskpProcessService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _zskpProcessService.getOSGiServiceIdentifier();
	}

	@Override
	public ZskpProcessService getWrappedService() {
		return _zskpProcessService;
	}

	@Override
	public void setWrappedService(ZskpProcessService zskpProcessService) {
		_zskpProcessService = zskpProcessService;
	}

	private ZskpProcessService _zskpProcessService;
}