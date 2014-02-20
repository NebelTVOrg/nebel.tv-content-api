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
package com.nebel_tv.content.wrapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class WrapperTest {

	/**
	 *
	 */
	public WrapperTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getWrapper method (Live), of class Wrapper.
	 */
	@Test
	public void testGetWrapperLive() {
		IWrapper result = Wrapper.getWrapper(WrapperTypes.LIVE);
		assertTrue(result instanceof LiveWrapper);
	}

	/**
	 * Test of getWrapper method (Test), of class Wrapper.
	 */
	@Test
	public void testGetWrapperTest() {
		IWrapper result = Wrapper.getWrapper(WrapperTypes.TEST);
		assertTrue(result instanceof TestWrapper);
	}
}
