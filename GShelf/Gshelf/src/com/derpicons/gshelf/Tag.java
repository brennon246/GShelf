package com.derpicons.gshelf;

public class Tag {

	private String TagName;
	private String TagType;

	public Tag(String tN, String tT) {
		tT.toLowerCase();
		tN.toLowerCase();
		TagName = tN;
		TagType = tT;
	}

	public Tag() {
	}

	public boolean isMatch(Game x) {
		if (TagType == "title") {
			String gT = x.getTitle().toLowerCase();
			if (gT.equals(TagName)) {
				return true;
			}
		} else if (TagType == "platform") {
			String gP = x.getPlatform().toLowerCase();
			if (gP.equals(TagName)) {
				return true;
			}
		} else {
			String gD = x.getDeveloper().toLowerCase();
			if (gD.equals(TagName)) {
				return true;
			}
		}// TagType == developer
		return false;
	}

	public boolean isPartialMatch(Game x) {
		if (TagType == "title") {
			String gT = x.getTitle().toLowerCase();
			if (gT.contains(TagName)) {
				return true;
			}
		} else if (TagType == "platform") {
			String gP = x.getPlatform().toLowerCase();
			if (gP.contains(TagName)) {
				return true;
			}
		} else {
			String gD = x.getDeveloper().toLowerCase();
			if (gD.contains(TagName)) {
				return true;
			}
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
