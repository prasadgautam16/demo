package com.example.netflix.demo.dao;

import com.example.netflix.demo.models.Show;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVReader {

    public static void main(String[] args) {
        String path = "C:\\Users\\hp\\IdeaProjects\\OTT\\src\\com\\company\\data\\netflix_titles.csv";
        System.out.println("Enter a Number to show number of record : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long start = System.currentTimeMillis();
        System.out.println("Enter a Number is : " + n);
        List<Show> showList = getShowDetails(n, path);


//        List<Show> showMovieType = showList.stream()
//                .filter(s -> s.getType().equalsIgnoreCase("TV Show"))
//                .toList();
//        for(Show show:showMovieType){
//            System.out.println(show.toString());
//        }




//        List<Show> showListedIn = showList.stream()
//                .filter(s -> Arrays.stream(s.getListed_in()).anyMatch("Dramas"::equalsIgnoreCase))
//                .toList();
//        for(Show show:showListedIn){
//            System.out.println(show.toString());
//        }



//        List<Show> showTypeAndCountry = showList.stream()
//                .filter(s -> {
//                    String country = s.getCountry();
//                    String type = s.getType();
//                    if (null != type && null != country) {
//                        return type.equalsIgnoreCase("TV Show") && country.equalsIgnoreCase("India");
//                    }
//                    return false;
//                })
//                .toList();
//        for(Show show:showTypeAndCountry){
//            System.out.println(show.toString());
//        }


        System.out.println("Enter a from date in YYYY-MM-DD : ");
        String from = sc.next();
        System.out.println("Enter a to date in YYYY-MM-DD : ");
        String to = sc.next();
        List<Show> showBasedOnDate = showList.stream()
                .filter(s -> {
                    LocalDate fromDate = LocalDate.parse(from);
                    LocalDate toDate =  LocalDate.parse(to);
                    LocalDate showDate = s.getDate_added();
                    if (null != showDate) {
                        return (fromDate.isBefore(showDate) && toDate.isAfter(showDate));
                    }
                    return false;
                })
                .toList();
        for(Show show:showBasedOnDate){
            System.out.println(show.toString());
        }


        // time end
        long end = System.currentTimeMillis();
        System.out.println("Function took : " + (end - start) + "ms");
    }





    private static List<Show> getShowDetails(int n, String file) {
        List<Show> showList =new ArrayList<>();
        String line;
        int i = 0;
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            while( n >= i && (line = br.readLine()) != null) {

                String [] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (i > 0) {
                    Show show = getOneShow(attributes);
                    showList.add(show);
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return showList;
    }

    private static Show getOneShow(String[] attributes) {
        String showId , type, title, director, country, release_year, rating, duration, description;
        LocalDate date_added;
        String [] listed_in, cast;
        try{
            showId = attributes[0].equalsIgnoreCase("") ? null : attributes[0];
        }
        catch(Exception e){showId = null;}
        try{
            type = attributes[1].equalsIgnoreCase("") ? null : attributes[1];
        }
        catch(Exception e){type = null;}
        try{
            title = attributes[2].equalsIgnoreCase("") ? null : attributes[2];
        }
        catch(Exception e){title = null;}
        try{
            director = attributes[3].equalsIgnoreCase("") ? null : attributes[3];
        }
        catch(Exception e){director = null;}
        try{
            cast = attributes[4].equalsIgnoreCase("") ? null : attributes[4].split(", ");
        }
        catch(Exception e){cast = null;}
        try{
            country = attributes[5].equalsIgnoreCase("") ? null : attributes[5];
        }
        catch(Exception e){country = null;}
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            date_added = attributes[6].equalsIgnoreCase("") ? null : LocalDate.parse(attributes[6].replaceAll("^\"|\"$", ""), formatter);
        }
        catch(Exception e){ date_added=null; }
        try{
            release_year = attributes[7].equalsIgnoreCase("") ? null : attributes[7];
        }
        catch(Exception e){release_year = null;}
        try{
            rating = attributes[8].equalsIgnoreCase("") ? null : attributes[8];
        }
        catch(Exception e){rating = null;}
        try{
            duration = attributes[9].equalsIgnoreCase("") ? null : attributes[9];
        }
        catch(Exception e){duration = null;}
        try{
            listed_in = attributes[10].equalsIgnoreCase("") ? null : attributes[10].split(", ");
        }
        catch(Exception e){listed_in = null;}
        try{
            description = attributes[11].equalsIgnoreCase("") ? null : attributes[11];
        }
        catch(Exception e){description = null;}

        return new Show(showId, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);
     }

    //    private static Show getOneShow(String[] attributes) {
//        String showId, type, title, director, cast, country, release_year, rating, duration, listed_in, description = null;
//        LocalDate date_added;
//
//        showId = validateString(attributes[0]);
//        type = validateString(attributes[1]);
//        title = validateString(attributes[2]);
//        director = validateString(attributes[3]);
//        cast = validateString(attributes[4]);
//        country = validateString(attributes[5]);
//        date_added = validateDate(attributes[6]);
//        release_year = validateString(attributes[7]);
//        rating = validateString(attributes[8]);
//        duration = validateString(attributes[9]);
//        listed_in = validateString(attributes[10]);
//        description = validateString(attributes[11]);
//
//        Show show = new Show(showId, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);
//        return show;
//
//    }

//    private static String validateString(String attribute) {
//        String value = null;
//        try{
//            value = attribute.equalsIgnoreCase("") ? null : attribute;
//        }
//        catch(Exception e){return null;}
//
//        return value;
//    }

//    private static LocalDate validateDate(String attribute) {
//        LocalDate value;
//        try{
//            value = attribute.equalsIgnoreCase("") ? null : LocalDate.parse(attribute);
//        }
//        catch(Exception e){return null;}
//
//        return value;
//    }
}