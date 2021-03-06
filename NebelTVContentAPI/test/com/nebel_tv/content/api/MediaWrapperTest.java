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
package com.nebel_tv.content.api;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.io.IOUtils;

/**
 *
 */
public class MediaWrapperTest {

	private final ContentWrapper instance = new ContentWrapper();

	/**
	 *
	 */
	public MediaWrapperTest() {
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
	 * Test of getMediaData (<code>getMedias</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetMediaDataGetMedias() {
		final String url = "http://nebel.tv/IvaWrapperWeb/getMedias?skip=100&n=9&category=0";

		WrapperResponse result = instance.getMediaData(url);
		assertTrue(result.responseType == WrapperResponse.ResponseType.Content);
		assertTrue(result.responseResult == WrapperResponse.ResponseResult.Ok);

		try {
			JSONArray jsonGetMedias = new JSONArray(result.responseData);
			assertFalse(jsonGetMedias.length() == 0);

			for (int i = 0; i < jsonGetMedias.length(); i++) {
				JSONObject jsonItem = jsonGetMedias.getJSONObject(i);
				testJsonMediaItem(jsonItem);
			}
		} catch (JSONException e) {
			fail("JSON parsing failed" + e.getMessage());
		}
	}

	/**
	 * Test (compare) of getMediaData (<code>getMedias</code>) results returned
	 * by Web Service and Wrapper Library.
	 */
	@Test
	public void testGetMediasCompare() {
		final String url = "http://127.0.0.1:8080/IvaWrapperWeb/getMedias?skip=100&n=9&category=0";

		try {
			WrapperResponse response = instance.getMediaData(url);

			String result = IOUtils.toString(new URL(fixURL(url)));
			assertTrue(response.responseData.equals(result));
		} catch (IOException e) {
			fail("Web service request failed " + e.getMessage());
		}
	}

	/**
	 * Test of getMediaData (<code>getMediaItem</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetMediaDataGetMediaItem() {
		final String url = "http://54.201.170.111:8080/IvaWrapperWeb/getMediaItem?id=2";

		WrapperResponse result = instance.getMediaData(url);
		assertTrue(result.responseType == WrapperResponse.ResponseType.Content);
		assertTrue(result.responseResult == WrapperResponse.ResponseResult.Ok);

		try {
			JSONObject jsonItem = new JSONObject(result.responseData);
			testJsonMediaItem(jsonItem);
		} catch (JSONException e) {
			fail("JSON parsing failed" + e.getMessage());
		}
	}

	/**
	 * Test (compare) of getMediaData (<code>getMediaItem</code>) results
	 * returned by Web Service and Wrapper Library.
	 */
	@Test
	public void testGetMediaItemCompare() {
		final String url = "http://127.0.0.1:8080/IvaWrapperWeb/getMediaItem?id=2";
		try {
			WrapperResponse response = instance.getMediaData(url);

			String result = IOUtils.toString(new URL(fixURL(url)));
			assertTrue(response.responseData.equals(result));
		} catch (IOException e) {
			fail("Web service request failed " + e.getMessage());
		}
	}

	/**
	 * Test of getMediaData (<code>getMedias</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetMediaDataGetVideoAssets() {
		final String url = "http://54.201.170.111:8080/IvaWrapperWeb/getVideoAssets?id=7";

		WrapperResponse result = instance.getMediaData(url);
		assertTrue(result.responseType == WrapperResponse.ResponseType.VideoAssets);
		assertTrue(result.responseResult == WrapperResponse.ResponseResult.Ok);

		try {
			JSONArray jsonVideoAssets = new JSONArray(result.responseData);
			assertFalse(jsonVideoAssets.length() == 0);

			for (int i = 0; i < jsonVideoAssets.length(); i++) {
				JSONObject jsonAsset = jsonVideoAssets.getJSONObject(i);
				testJsonVideoAsset(jsonAsset);
			}
		} catch (JSONException e) {
			fail("JSON parsing failed" + e.getMessage());
		}
	}

	/**
	 * Test of getMediaData (<code>getMedias</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetMediaDataGetVideoAssetsAsEntities() {
		final String url = "http://54.201.170.111:8080/IvaWrapperWeb/getVideoAssets?id=7";

		WrapperResponse result = instance.getMediaData(url);
		assertTrue(result.responseType == WrapperResponse.ResponseType.VideoAssets);
		assertTrue(result.responseResult == WrapperResponse.ResponseResult.Ok);

		VideoAssetsWrapper va = new VideoAssetsWrapper(result.responseData);
		String[] urls = va.getVideoURLs();

		assertTrue(urls != null);
		assertTrue(urls.length != 0);
	}

	/**
	 * Test of getUrlLastSegment (<code>getMedias</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetUrlLastSegmentGetMedias() {
		String urlGetMedias = "http://54.201.170.111:8080/IvaWrapperWeb/getMedias?skip=100&n=3&category=0";
		String result = ContentWrapper.getUrlLastSegment(urlGetMedias);
		assertEquals(result, "getMedias");

		urlGetMedias = "http://nebel.tv/IvaWrapperWeb/getMedias?skip=100&n=3&category=0";
		result = ContentWrapper.getUrlLastSegment(urlGetMedias);
		assertEquals(result, "getMedias");
	}

	/**
	 * Test of getUrlLastSegment (<code>getMediaItem</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetUrlLastSegmentGetMediaItem() {
		String urlGetMediaItem = "http://54.201.170.111:8080/IvaWrapperWeb/getMediaItem?id=2";
		String result = ContentWrapper.getUrlLastSegment(urlGetMediaItem);
		assertEquals(result, "getMediaItem");

		urlGetMediaItem = "http://nebel.tv/IvaWrapperWeb/getMediaItem?id=2";
		result = ContentWrapper.getUrlLastSegment(urlGetMediaItem);
		assertEquals(result, "getMediaItem");
	}

	/**
	 * Test of getUrlLastSegment (<code>getVideoAssets</code>) method, of class
	 * MediaWrapper.
	 */
	@Test
	public void testGetUrlLastSegmentGetVideoAssets() {
		String urlGetVideoAssets = "http://54.201.170.111:8080/IvaWrapperWeb/getVideoAssets?id=0";
		String result = ContentWrapper.getUrlLastSegment(urlGetVideoAssets);
		assertEquals(result, "getVideoAssets");

		urlGetVideoAssets = "http://nebel.tv/IvaWrapperWeb/getVideoAssets?id=0";
		result = ContentWrapper.getUrlLastSegment(urlGetVideoAssets);
		assertEquals(result, "getVideoAssets");
	}

	/**
	 * Test of JSON presentation of the media item The following keys are
	 * mandatory <code>media_id, title, author, date</code>
	 */
	private void testJsonMediaItem(JSONObject item) {
		assertNotNull(item);

		assertTrue(item.has("Publishedid"));
		assertTrue(item.has("DisplayTitle"));
		assertTrue(item.has("Poster"));
		assertTrue(item.has("Description"));
		assertTrue(item.has("Director"));
	}

	/**
	 * Test of JSON presentation of the video asset The following keys are
	 * mandatory <code>rate, url</code>
	 *
	 * @param asset JSON object instance of the video asset
	 */
	private void testJsonVideoAsset(JSONObject asset) {
		assertNotNull(asset);

		assertTrue(asset.has("rate"));
		assertTrue(asset.has("URL"));
		assertTrue(asset.has("FileType"));
	}

	/**
	 * @param url
	 * @return
	 */
	public static String fixURL(String url) {
		StringBuilder fixedURL = new StringBuilder();
		String[] urlParts = url.split("\\?");
		fixedURL.append(urlParts[0]).append("?");

		if (urlParts.length > 1) {
			String[] pairs = urlParts[1].split("&");
			for (String pair : pairs) {
				String[] nameValuePair = pair.split("=");
				fixedURL.append("&")
						.append(nameValuePair[0])
						.append("=")
						.append(URLEncoder.encode(nameValuePair[1]));
			}
		}
		return fixedURL.toString();
	}
}
