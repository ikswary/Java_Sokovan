package domain;

public class Player {
	private Integer[] axis;
	private Integer numberOfMove;

	public Player() {
		this.axis = new Integer[2];
		this.numberOfMove = 0;
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

	public void movedOnce() {
		this.numberOfMove++;
	}

	public void movedBackward() {
		this.numberOfMove--;
	}

	public Integer getNumberOfMove() {
		return this.numberOfMove;
	}
}
