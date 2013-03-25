package com.derpicons.gshelf;

public class Tag {

	private String TagName;
	private String TagType;

	public Tag(String tN, String tT) {
		TagName = tN;
		TagType = tT;
	}
	public Tag() {
	}
	
	public boolean isMatch(Game x) {
		if (TagType == "title") {

		} else if (TagType == "platform") {

		} else {

		}// TagType == developer
		return false;
	}

	public String getTagName() {
		return TagName;
	}

	public void setTagName(String tagName) {
		TagName = tagName;
	}

	public String getTagType() {
		return TagType;
	}

	public void setTagType(String tagType) {
		TagType = tagType;
	}
}
