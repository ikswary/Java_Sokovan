package domain;

public class Player {
	private Integer[] axis = new Integer[2];

	public Player() {
	}

	public Integer getAxisX() {
		return axis[0];
	}

	public Integer getAxisY() {
		return axis[1];
	}

	public void setAxis(Integer[] axis) {
		this.axis = axis;
	}

	public Integer[] cloneAxis() {
		return axis.clone();
	}
}
