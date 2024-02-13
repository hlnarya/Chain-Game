
public class Element {
	private int height;
	private int width;
	private char element;
	private int chained;
	public Element(int height, int width, char element, int chained) {
		this.element=element;
		this.height = height;
		this.width = width;
		this.chained = chained;
	}
	public Element() {
		this.element='x';
		this.height = -1;
		this.width = -1;
		this.chained = -1;
	}
	public Element(int height, int width, char element) {
		this.element=element;
		this.height = height;
		this.width = width;
		this.chained = 0;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public char getElement() {
		return element;
	}
	public void setElement(char element) {
		this.element = element;
	}
	public int getChained() {
		return chained;
	}
	public void setChained(int chained) {
		this.chained = chained;
	}
}
