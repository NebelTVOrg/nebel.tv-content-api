/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nebeltv.ivawrapper.xmlparser.nodes;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 *
 * @author dst
 */
public class Properties {

	@XStreamAlias("m:properties")
	private String title;
	@XStreamAlias("d:Publishedid")
	private String publishedId;
	@XStreamAlias("d:ItemDescription")
	private String description;
	@XStreamAlias("d:PosterUrl")
	private String posterUrl;
	@XStreamAlias("d:DisplayTitle")
	private String displayTitle;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return reflectionToString(this, SHORT_PREFIX_STYLE);
	}

	/**
	 * @return the publishedId
	 */
	public String getPublishedId() {
		return publishedId;
	}

	/**
	 * @param publishedId the publishedId to set
	 */
	public void setPublishedId(String publishedId) {
		this.publishedId = publishedId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the posterUrl
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * @param posterUrl the posterUrl to set
	 */
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	/**
	 * @return the displayTitle
	 */
	public String getDisplayTitle() {
		return displayTitle;
	}

	/**
	 * @param displayTitle the displayTitle to set
	 */
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}
}