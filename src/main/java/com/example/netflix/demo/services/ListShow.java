package com.example.netflix.demo.services;

import com.example.netflix.demo.models.Show;

import java.util.List;

public interface ListShow {
    List<Show> getShowsBasedCondition(String country, String count, String startDate, String endDate, String listed_in);
}
