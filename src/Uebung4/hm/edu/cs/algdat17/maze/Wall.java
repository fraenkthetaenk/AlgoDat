package Uebung4.hm.edu.cs.algdat17.maze;

/**
 * Repräsentation einer Wand. Eine Wand ist immer gekennzeichnet durch ein Feld
 * zu dem es gehört und einer Richtung, in der es dieses Feld begrenzt.
 * Achtung: Theoretisch kann so jede Wand auf zwei Arten beschrieben werden. Der 
 * Einfachheit halber wird das nicht überprüft. 
 * 
 * @author katz.bastian
 *
 */
public class Wall {
	int x;
	int y;
	Direction direction;

	public int getColumn() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getRow() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Wall(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/* Generated code */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		if (direction != other.direction)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
