import java.util.LinkedList;

public class Switch extends FieldElement {
    private int switchSelector=0;
    private LinkedList<Joint> joints;


    public int getSwitchSelector() {
        return switchSelector;
    }

    public void setSwitchSelector(int switchSelector) {
        this.switchSelector = switchSelector;
    }

    public LinkedList<Joint> getJoints() {
        return joints;
    }

    public void addJoint(Joint joint) {
        joints.add(joint);
    }



    Switch(){
        joints = new LinkedList<>();
    }

    @Override
    void handlePackage(Pack p) {
        joints.get(switchSelector).getForwardTo().handlePackage(p);
    }
}
