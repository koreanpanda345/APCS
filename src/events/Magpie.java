package events;
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie {
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } else if (statement.indexOf("hello") >= 0 || statement.indexOf("hi") >= 0) {
            response = "Hello";
        } else if (statement.indexOf("how are you") >= 0) {
            response = HowAreYou();
        }else if(statement.indexOf("good") >= 0 || statement.indexOf("i am good") >=0){
            response = "That's good";
        }else if(statement.indexOf("bad")>= 0){
            response = "Why?";
        }else if(statement.indexOf("why?") >= 0){
            response = "My mother died";
        } else if (statement.indexOf("i am sorry") >= 0) {
            response = "Its ok";
        }else if(statement.indexOf("help") >= 0 || statement.indexOf("save") >= 0){
            response = "I can't help you with that.";
        }else if(statement.indexOf("where are you from")>= 0){
            response = "I am from a computer.";
        }else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        }

        return response;
    }

    private String HowAreYou() {
        final int Num_response = 3;
        double h = Math.random();
        int isresponse = (int) (h * Num_response);
        String response = "";
        if (isresponse == 0) {
            response = "Great, and you?";
        }else if(isresponse == 1) {
            response = "Pretty bad, you?";
        }else if(isresponse == 2) {
            response = "I am ok, you?";
        }
        return response;
        }
    }