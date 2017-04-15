package model;

public class RankModel {
	private int stt;
	private String name;
	private int value;

	public RankModel(int stt, String name, int value) {
		this.stt = stt;
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return stt +":"+ name +":"+ value;
	}

}
