public class Gate extends FieldElement {
    static int UNIQUE_ID = 0;
    int uid = ++UNIQUE_ID;
    public int getUniqueId() {
        return uid;
    }

   Gate(){
    }

    @Override
    void handlePackage(Pack p) {

    }
}
