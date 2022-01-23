package com.example.netflix.demo.dao;

import com.example.netflix.demo.models.Show;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DAOReadShows {

    public static List<Show> getAllShows() {
        String file = "D:\\WORK SPACE\\JAVA\\Project\\demo\\src\\main\\java\\netflix_titles.csv";
        List<Show> showList =new ArrayList<>();
        String line;
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while( (line = br.readLine()) != null) {

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
            cast = attributes[4].equalsIgnoreCase("") ? null : attributes[4].replaceAll("^\"|\"$", "").split(", ");
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
            listed_in = attributes[10].equalsIgnoreCase("") ? null : attributes[10].replaceAll("^\"|\"$", "").split(", ");
        }
        catch(Exception e){listed_in = null;}
        try{
            description = attributes[11].equalsIgnoreCase("") ? null : attributes[11].replaceAll("^\"|\"$", "");
        }
        catch(Exception e){description = null;}

        return new Show(showId, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);
    }
}
