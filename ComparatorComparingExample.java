package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ComparatorComparingExample {
	public static void main(String[] args) {
		List<Player> footballTeam = new ArrayList<>();
	    Player player1 = new Player(59, "John", 20);
	    Player player2 = new Player(67, "Roger", 22);
	    Player player3 = new Player(45, "Steven", 24);
	    Player player4 = new Player(69, "Alpha", 22);
	    Player player5 = new Player(68, "Alpha", 22);
	    
	    footballTeam.add(player1);
	    footballTeam.add(player2);
	    footballTeam.add(player3);
	    footballTeam.add(player4);
	    footballTeam.add(player5);
	    
	    
	    
	    List<Player> sorted1 = footballTeam.stream()
	    		.sorted(Comparator
	    						.comparing(Player::getAge, (a1, a2) -> a2.compareTo(a1))
	    						.thenComparing(Player::getName,(n1,n2)->n2.compareTo(n1))
	    						.thenComparing(Player::getRanking,(r1,r2)->r1.compareTo(r2))
	    					).collect(Collectors.toList());
	    
	    System.out.println(sorted1.toString());System.out.println();
	    
	    List<Player> sorted2 = footballTeam.stream()
	    		.sorted(Comparator
	    						.comparing(Player::getAge, Comparator.nullsFirst(Comparator.reverseOrder()))
	    						.thenComparing(Player::getName,Comparator.nullsFirst(Comparator.reverseOrder()))
	    						.thenComparing(Player::getRanking, Comparator.nullsFirst(Comparator.naturalOrder()))
	    					).collect(Collectors.toList());
		
		System.out.println(sorted2.toString());System.out.println();
		
		List<Player> sorted3 = footballTeam.stream().sorted(new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).collect(Collectors.toUnmodifiableList());
		System.out.println(sorted3.toString());System.out.println();
		
		
		List<Player> sorted4 = footballTeam.stream().sorted((Player o1, Player o2) -> {
				return o1.getName().compareTo(o2.getName());
		}).collect(Collectors.toUnmodifiableList());
		System.out.println(sorted4.toString());System.out.println();
	}
}

class Player {
    private int ranking;
    private String name;
    private int age;
    
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int ranking, String name, int age) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
	}
    
  
}
