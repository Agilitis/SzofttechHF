public class Joint {
    private static int UNIQUE_ID = 0;
    private int uid = ++UNIQUE_ID;
    public int getUniqueId() {
        return uid;
    }
    private FieldElement forwardTo;

    Joint(FieldElement element){
        forwardTo = element;
    }

    public FieldElement getForwardTo() {
        System.out.println("Forwarding to: " + forwardTo.toString());
        return forwardTo;
    }
}
