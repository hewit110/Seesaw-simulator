/**
 * Created by kevin on 3/26/2017.
 */
public class person {
    public String name;
    public Double velocity;
    double height;
    boolean rising = false;

    public person(String initName, double initVelocity, double initHeight,boolean initRising ){
        name = initName;
        velocity = initVelocity;
        height = initHeight;
        rising = initRising;
    }
}
