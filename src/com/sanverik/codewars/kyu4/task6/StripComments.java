package com.sanverik.codewars.kyu4.task6;

/**
 * Task: "Strip Comments"
 *
 * @author Andrii Kobyliuk
 * @see <a href="https://www.codewars.com/kata/51c8e37cee245da6b40000bd">CodeWars</a>
 */
public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        StringBuilder sb = new StringBuilder();

        String[] lines = text.split("\n");

        for (String line : lines) {
            int m = line.length();
            for (String comment : commentSymbols) {
                if (line.contains(comment)) {
                    m = Math.min(line.indexOf(comment), m);
                }
            }
            sb.append(removeTrailingSpaces(line.substring(0, m))).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static String removeTrailingSpaces(String param)
    {
        if (param == null)
            return null;
        int len = param.length();
        for (; len > 0; len--) {
            if (!Character.isWhitespace(param.charAt(len - 1)))
                break;
        }
        return param.substring(0, len);
    }

    public static void main(String[] args) {

        System.out.println(StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));
        System.out.println(StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));

    }
}
