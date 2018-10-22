import java.util.LinkedList;

public class Timer extends Thread implements Steppable {
    private LinkedList<Steppable> steppables;
    private static Timer instance = null;

    private Timer() {
        steppables = new LinkedList<>();
    }

    public void run() {
        tick();
    }

    static Timer getInstance() {
        if (instance == null) {
            instance = new Timer();
        }
        return instance;
    }

    public void tick() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            step();
        }
    }

    @Override
    public void step() {
        for (Steppable s : steppables) {
            s.step();
        }
    }

    void addSteppable(Steppable steppable) {
        steppables.add(steppable);
    }

    void removeSteppable(Steppable steppable) {
        steppables.remove(steppable);
    }


}
