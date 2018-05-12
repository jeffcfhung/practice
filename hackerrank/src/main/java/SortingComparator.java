import java.util.*;

class Checker implements Comparator<Player> {
	@Override
	public int compare(Player o1, Player o2) {
		if (o1.score > o2.score) {
			return -1;
		}
		else if (o1.score < o2.score) {
			return 1;
		}
		else {
			return o1.name.compareTo(o2.name);
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class SortingComparator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Player[] players = new Player[n];
		Checker checker = new Checker();
		for (int i=0; i<n; i++) {
			players[i] = new Player(in.next(), in.nextInt());
		}

		Arrays.sort(players, checker);
		for (int i=0; i<players.length; i++) {
			System.out.printf("%s %s\n", players[i].name, players[i].score);
		}
	}
}
