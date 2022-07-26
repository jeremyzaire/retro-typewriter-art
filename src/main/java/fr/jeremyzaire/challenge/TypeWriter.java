package fr.jeremyzaire.challenge;

import java.util.Arrays;
import java.util.List;

/**
 * Class used to print ascii art.
 */
public class TypeWriter {

    public void draw(String recipes) {
        for (String code: splitRecipes(recipes.strip())) {
            print(code);
        }
    }

    /**
     * Get abbreviations from ascii code.
     * @param code The ascii code.
     * @return The expected abbreviaton.
     */
    public String getAbbreviation(String code) {
        if (code != null) {
            return switch(code) {
                case "sp" -> code.replace("sp", " ");
                case "bS" -> code.replace("bS", "\\");
                case "sQ" -> code.replace("sQ", "'");
                case "nl" -> code.replace("nl", "\n");
                default -> "";
            };
        }

        return "";
    }

    /**
     * Used to split recipes in little code ascii.
     * @param recipes The original recipes.
     * @return A list of code ascii.
     */
    public List<String> splitRecipes(String recipes) {
        return List.of(recipes.split("\\s"));
    }

    /**
     * Used to print code ascii with occurence.
     * For exemple : 123 means 333333333333
     * @param code The ascii code.
     */
    public void print(String code) {
        int factor = 1;
        String str;

        List<String> abbreviations = Arrays.asList("sp", "bS", "sQ", "nl");
        if(abbreviations.stream().anyMatch(code::contains)) {
            str = getAbbreviation(code.substring(code.length()-2));
            if(code.length() > 2) {
                factor = Integer.parseInt(code.substring(0, code.length()-2));
            }
        } else {
            str = String.valueOf(code.charAt(code.length()-1));
            factor = Integer.parseInt(code.substring(0, code.length()-1));
        }

        for(int i=0; i<factor; i++) {
            System.out.print(str);
        }
    }
}
