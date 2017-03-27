/**
 * Created by kevin on 3/26/2017.
 */
public class Seesaw {

    public Seesaw()
    {

    }

    //takes in both participants as arguments for the purpose of differing velocity
    public double simulate(person personA, person personB)
    {
        //if either person is withing pushing distance from the ground, set them to "rising"
        //"Rising" dictates which velocity value to use when calculating their height
        //If person A is rising, they will be rising at the rate of person B's velocity
        if (personA.height <= 1.0) {
            personA.rising = true;
            personB.rising = false;
            personA.height += personA.velocity;

        //if they are not about to push off the ground, perform the appropriate calculation for their direction
        } else {
            if (personA.rising) {
                personA.height += personA.velocity;
            } else {
                personA.height -= personB.velocity;
            }

        }
        return personA.height;
    }
}
