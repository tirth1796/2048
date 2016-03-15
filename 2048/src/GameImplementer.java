import java.util.Scanner;

public class GameImplementer {
	public static void main(String[] args) {
		Matrix m = new Matrix(4);
		Scanner s = new Scanner(System.in);
		for (;;) {
			String nextMove=s.nextLine();
			if (nextMove.equals("up")) {
				m.up();
			} else if (nextMove.equals("down")) {
				m.down();
			} else if (nextMove.equals("right")) {
				m.right();
			} else if (nextMove.equals("left")) {
				m.left();
			}
		}
	}

}
