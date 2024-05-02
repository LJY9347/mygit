package com.itwill.myhome.model;

public class MyHome {
	public static final class Entity{		
       public static final String TBL_MyHOME = "MYHOME";

		public static final String COL_ID = "ID";
		public static final String COL_ADDRESS = "ADDRESS";
		public static final String COL_WAY = "WAY";
		public static final String COL_FEET = "FEET";
		public static final String COL_ROOM_COUNT = "ROOM_COUNT";
		public static final String COL_CONTENT = "CONTENT";	
		public static final String COL_OPTION1 = "OPTION1";
		public static final String COL_OPTION2 = "OPTION2";
		public static final String COL_OPTION3 = "OPTION3";
		public static final String COL_OPTION4 = "OPTION4";
		public static final String COL_OPTION5 = "OPTION5";
		
	}
	
	private int id;
	private String address;
	private String way;
	private String feet;
	private String room_count;
	private String content;
	private boolean option1;
	private boolean option2;
	private boolean option3;
	private boolean option4;
	private boolean option5;
	
	public MyHome() {}

	public MyHome(int id, String address, String way, String feet, String room_count, String content, boolean option1,
			boolean option2, boolean option3, boolean option4, boolean option5) {
		this.id = id;
		this.address = address;
		this.way = way;
		this.feet = feet;
		this.room_count = room_count;
		this.content = content;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
	}



	public boolean isOption1() {
		return option1;
	}

	public void setOption1(boolean option1) {
		this.option1 = option1;
	}

	public boolean isOption2() {
		return option2;
	}

	public void setOption2(boolean option2) {
		this.option2 = option2;
	}

	public boolean isOption3() {
		return option3;
	}

	public void setOption3(boolean option3) {
		this.option3 = option3;
	}

	public boolean isOption4() {
		return option4;
	}

	public void setOption4(boolean option4) {
		this.option4 = option4;
	}

	public boolean isOption5() {
		return option5;
	}

	public void setOption5(boolean option5) {
		this.option5 = option5;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getFeet() {
		return feet;
	}

	public void setFeet(String feet) {
		this.feet = feet;
	}

	public String getRoom_count() {
		return room_count;
	}

	public void setRoom_count(String room_count) {
		this.room_count = room_count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MyHome [id=" + id + ", address=" + address + ", way=" + way + ", feet=" + feet + ", room_count="
				+ room_count + ", content=" + content + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", option5=" + option5 + "]";
	}

	
	
}
