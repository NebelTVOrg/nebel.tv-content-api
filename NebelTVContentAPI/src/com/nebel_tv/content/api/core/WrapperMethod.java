/**
 * Copyright (C) 2014 Nebel TV (http://nebel.tv)
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nebel_tv.content.api.core;

import com.nebel_tv.content.api.IWrapperMethod;
import com.nebel_tv.content.wrapper.IWrapper;
import com.nebel_tv.content.wrapper.Wrapper;
import com.nebel_tv.content.wrapper.WrapperTypes;

public abstract class WrapperMethod implements IWrapperMethod {

	/**
	 *
	 */
	protected final IWrapper wrapper = Wrapper.getWrapper(WrapperTypes.LIVE);

	/**
	 *
	 * @return IWrapper interface name
	 */
	public static String getName() {
		return "";
	}
}
