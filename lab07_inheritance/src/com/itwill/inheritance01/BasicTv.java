package com.itwill.inheritance01;

// extenjd Object는 생략 가능.
public class BasicTv {
	// 상수 정의:
	public static final int MIN_CHANNEL = 0;
	public static final int MAX_CHANNER = 2;
	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 2;

	// 필드
	private boolean powerOn; // 전원 상태(true-> ON, false-.OFF)
	protected int channel; // 현재 채널 번호 // 같은 패키지에 있거나 상속받았을때 사용가능한 protected
	private int volume; // 음량

	// 생성자 - 우클릭 소스 컨스트럭터
	public BasicTv() {
	}

	public BasicTv(boolean powerOn, int channel, int volume) {
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}

	// 메서드 - 우클릭 소스 게터 세터

	public boolean isPowerOn() {
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * TV가 켜져 있으면 끄고, TV가 꺼져 있으면 켬. powerOn의 값이 true이면 false 변경, powerOn의 값이 false이면
	 * true로 변경.
	 * 
	 * @return 변경된 powerOn의 값.
	 */

	public boolean powerOnOff() {
		if (powerOn) {
			powerOn = false;
			System.out.println("TV OFF");
		} else {
			powerOn = true;
			System.out.println("TV ON");
		}
		return powerOn;
	}

	public int channelUp() {
		if (powerOn) {
			if (channel < MAX_CHANNER) {
				channel++;
			} else {
				channel = MIN_CHANNEL;
			}
			System.out.println("CH: " + channel);
		}

		return channel;
	}

	/**
	 * channelUp 현재 채널의 값을 1증가. 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의
	 * 최솟값(MIN_CHANNEL)으로 변경.
	 * 
	 * @return 바뀐 현재 채널 값.
	 */
	public int channelDown() {
		if (powerOn) {
			if (channel > MIN_CHANNEL) {
				channel--;
			} else {
				channel = MAX_CHANNER;
			}
			System.out.println("CH: " + channel);
		}
		return channel;
	}

	/**
	 * channelDown 현재 채널의 값을 1감소. 만약 현재 채널 값이 채널의 최솟값(MAX_CHANNEL)인 경우, 채널의
	 * 최댓값(MIN_CHANNEL)으로 변경.
	 * 
	 * @return 바뀐 현재 채널 값.
	 */

	/**
	 * volumeUp 현재 음량의 값을 1증가. 만약 현재 음량 값이 음량의 최댓값(MAX_VOLUME)인 경우, 음량을 변경하지 않음.
	 * 
	 * @return 바뀐 현재 음량 값.
	 */
	public int volumeUp() {
		if (powerOn) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			System.out.println("VOL: " + volume);
		}
		return volume;
	}

	/**
	 * volumeDown 현재 음량의 값을 1감소. 만약 현재 음량 값이 음량의 최솟값(MIN_VOLUME)인 경우, 음량을 변경하지 않음.
	 * 
	 * @return 바뀐 현재 음량 값.
	 */
	public int volumeDown() {
		if (powerOn) {
			if (volume > MIN_VOLUME) {
				volume--;
			}
			System.out.println("VOL: " + volume);
		}
		return volume;
	}
}
