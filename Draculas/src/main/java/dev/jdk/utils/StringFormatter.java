package dev.jdk.utils;

import java.util.ArrayList;
import java.util.List;

public class StringFormatter
{
    public static List<String> formatKeywords(String keywords)
    {
        List<String> formattedKeywordList = new ArrayList<>();
        String[] words=keywords.split("\\s");
        String capitalizedWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterFirst=w.substring(1);
            capitalizedWord=first.toUpperCase()+afterFirst;
            formattedKeywordList.add(capitalizedWord);
        }return formattedKeywordList;
    }
}
