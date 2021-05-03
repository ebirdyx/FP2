package seminar2.Practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void patternClass() {
        Pattern pattern = Pattern.compile(".xx.");
        Matcher matcher = pattern.matcher("sxx1");       //sx1x -false

        System.out.println("String matches the given Regex - " + matcher.matches());
    }

    public static void regexCharacters() {
        // [abc]  a,b or c simple class
        // [^abc]  any class except a,b or c  (negation)
        // [a-zA-Z] A through Z || a through z inclusive `(range)
        // [a-d[m-p]]  a through d || m thru p (union)
        // [a-z&&[def]]  d,e or f (intersection)
        // [a-z&&[^bc]]  a-z without b,c
        // [a-z&&[^m-p]] a-z without m-p

        System.out.println(Pattern.matches("[xyz]", "wbcd")); // false not x or y or z
        System.out.println(Pattern.matches("[xyz]", "wbcd")); // false not x or y or z
    }

    public static void regexQuantifiers() {
        // x?  x occurs once ot not at all
        // x+      more than once
        // x*     zero or more times
        // x{n}   n times only
        // x{n,}  n times or more times only
        // x{y,z} at least y times but less than z times

        System.out.println("? quantifier...");
        System.out.println(Pattern.matches("[ayz]?", "a"));
        System.out.println(Pattern.matches("[ayz]?", "aaa"));

        System.out.println("+ quantifier...");
        System.out.println(Pattern.matches("[ayz]+", "aaa"));
        System.out.println(Pattern.matches("[ayz]+", "aammta"));

        System.out.println("* quantifier...");
        System.out.println(Pattern.matches("[ayz]*", "ayyyza"));
    }

    public static void main(String[] args) {


    }
}
