public abstract class  FieldElement {
    Joint joint;
    abstract void handlePackage(Pack p);
    FieldElement(){

    };

    void setJoint(Joint joint){
        this.joint = joint;
    }
}
