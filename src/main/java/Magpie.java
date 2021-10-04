import java.util.Locale;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String trimmed = statement.trim();
        String response;
        statement = statement.toLowerCase();
        if (findWord(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement, "dog") >= 0 || findWord(statement, "cat") >= 0){
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement, "mr.") >= 0 || findWord(statement, "mrs.") >= 0 ||findWord(statement, "ms.") >= 0
                || findWord(statement, "mister") >= 0 || findWord(statement, "miss's") >= 0){
            response = "He sounds like a good teacher";
        }
        else if (findWord(statement, "car") >= 0)
        {
            response = "I love cars too! What do you drive?";
        }
        else if (findWord(statement, "sport") >= 0)
        {
            response = "What is your favorite sport?";
        }
        else if (findWord(statement, "basketball") >= 0)
        {
            response = "Who's your favorite basketball player?";
        }
        else if ((trimmed.length() == 0)){
            response = "Say something please.";
    }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "That's absolutely intriguing!";
        }
        else if (whichResponse == 5)
        {
            response = "That's pretty cool.";
        }
        else if (whichResponse == 6)
        {
            response = "I like that answer!";
        }
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        word = word.toLowerCase();
        String all_lower = str.toLowerCase();
        int index = all_lower.indexOf(word);
        int max_num = all_lower.length() - word.length();
        if (index == max_num) {
            if (all_lower.charAt(index - 1) == ' ') {
                return index;
            }
            else {
                return -1;
            }
        } else {
            char after_word = all_lower.charAt(index + word.length());
            if (index > 0 && index < max_num) {
                if (after_word == ' ' && all_lower.charAt(index - 1) == ' ') {
                    return index;
                }
            } else if (index == 0) {
                if (after_word == ' ') {
                    return index;
                }
            }
            else {
                return -1;
            }

        }
        return -1;
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String x;
        statement = statement.toLowerCase();
        int index = statement.indexOf("I want") + 6;
        if (index >= 0)
        {
            x = "Would you really be happy if you had" + statement.substring(6) + "?";
        }
        else
        {
            x = statement;
        }
        return x;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String new_string;
        statement = statement.toLowerCase();
        if ((findWord(statement,"i") > -1) && (findWord(statement,"you") > -1 ))
        {
            new_string = "Why do you" + statement.substring(1, statement.length()-3) + "me?";

        }
        else {
            new_string = statement;
        }
        return new_string;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String x;
        statement = statement.toLowerCase();
        int index = statement.indexOf("I want") + 6;
        if (index >= 0)
        {
            x = "What would it mean" + statement.substring(6) + "?";
        }
        else
        {
            x = statement;
        }
        return x;

    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String new_string;
        statement = statement.toLowerCase();
        if ((findWord(statement,"you") > -1) && (findWord(statement,"me") > -1 ))
        {
            new_string = "What makes you think that I" + statement.substring(6, statement.length()-3) + " you?";

        }
        else {
            new_string = statement;
        }
        return new_string;
    }

// input = "I purchased a car"
    public String transformcarstatement(String statement)
    {
        String new_string;
        statement = statement.toLowerCase();
        if ((findWord(statement, "car") > -1 ) && (findWord(statement, "purchased ") > -1 ))
        {
            new_string = "What made you" + statement.substring(2, statement.length()-5) + "that auto?";
        }
        else
        {
            new_string = statement;
        }
        return new_string;
    }




}