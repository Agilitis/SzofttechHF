import java.util.LinkedList;

public class Map {
    private LinkedList<Gate> gates;
    private LinkedList<Truck> trucks;
    private LinkedList<Switch> switches;
    private LinkedList<Belt> belts;
    static Map instance = null;

    private Map(){
        gates = new LinkedList<>();
        trucks = new LinkedList<>();
        switches = new LinkedList<>();
        belts = new LinkedList<>();

        for(int i= 0; i<8; i++){
            Belt belt = new Belt(10);
            belts.add(belt);
        }
        trucks.add(new Truck("blue", false,10));
        trucks.add(new Truck("green", false,10));
        trucks.add(new Truck("blue", false,10));
        trucks.add(new Truck("blue", true,10));
        trucks.add(new Truck("blue", true,10));

        switches.add(new Switch());
        switches.add(new Switch());


        belts.get(0).setJoint(new Joint(switches.get(0)));
        belts.get(1).setJoint(new Joint(switches.get(1)));
        belts.get(2).setJoint(new Joint(switches.get(1)));
        belts.get(3).setJoint(new Joint(switches.get(0)));
        belts.get(4).setJoint(new Joint(switches.get(0)));
        belts.get(5).setJoint(new Joint(trucks.get(4)));
        belts.get(6).setJoint(new Joint(trucks.get(3)));

        trucks.get(0).setJoint(new Joint(belts.get(0)));
        trucks.get(1).setJoint(new Joint(belts.get(1)));
        trucks.get(2).setJoint(new Joint(belts.get(2)));


        switches.get(0).addJoint(new Joint(belts.get(6)));
        switches.get(0).addJoint(new Joint(belts.get(5)));
        switches.get(1).addJoint(new Joint(belts.get(4)));
    }

    static Map getInstance(){
        if(instance == null){
            instance = new Map();
        }
        return instance;
    }
}
