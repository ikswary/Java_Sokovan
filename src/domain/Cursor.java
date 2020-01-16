package domain;

public enum Cursor {
	UP(38),
	DOWN(40),
	LEFT(37),
	RIGHT(38),
	BACK_SPACE(8),
	WRONG_INPUT(0);

	private Integer cursorInteger;

	Cursor(Integer cursorInt) {
		this.cursorInteger = cursorInt;
	}

    public Integer getCursorInteger() {
        return cursorInteger;
    }
}
