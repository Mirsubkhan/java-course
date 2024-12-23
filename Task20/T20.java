package Task20;

import java.util.Random;

public class T20 {
	public static void main(String[] args) {
		Gold gold = new Gold(10);
		Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        Thread thread1 = new Thread(new Miner(player1, gold));
        Thread thread2 = new Thread(new Miner(player2, gold));
        
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game is Over!");
	}
}

class Gold {
	int supply;
	
	public Gold(int supply) {
		this.supply = supply;
	}
	
	public synchronized int mineGold(int amount) {
		if(supply <= 0) return 0;
		
		int mined = Math.min(amount, supply);
		supply -= mined;
		
		return supply;
	}
	
	public synchronized int getSupply() {
		return supply;
	}
}

class Player{
	String name;
	int mined;
	
	public Player(String name) {
		this.name = name;
		mined = 0;
	}
	
	public void mine(int amount) {
        mined += amount;
        System.out.println(name + " has collected " + amount + " amount of gold. Total amount of mined gold -> " + mined);
    }

    public String getName() {
        return name;
    }

	
	public int getMinedAmount() {
		return mined;
	}
}

class Miner implements Runnable{
	private Player player;
    private Gold gold;
    private Random random;

    public Miner(Player player, Gold gold) {
        this.player = player;
        this.gold = gold;
        this.random = new Random();
    }
    
    @Override
    public void run() {
    	while(true) {
    		int amountToMine = random.nextInt(5) + 1;
            int mined = gold.mineGold(amountToMine);
            
            if (mined == 0) {
                break;
            }
            
            player.mine(mined);

            System.out.println("The amount of gold left -> " + gold.getSupply());

            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }
}

