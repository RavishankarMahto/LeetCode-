import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        anagram("ABC", "");
    }     
        public static void anagram(String s, String news)
        {
            if(s.length()==0)
            {
                System.out.println(news);
            }
            for(int i = 0; i<s.length(); i++)
            {
                anagram(s.substring(0,i)+s.substring(i+1),news+s.charAt(i));
            }
        }
    }
}