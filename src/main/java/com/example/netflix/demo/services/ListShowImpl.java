package com.example.netflix.demo.services;

import com.example.netflix.demo.dao.DAOReadShows;
import com.example.netflix.demo.models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListShowImpl implements ListShow {

    private DAOReadShows daoReadShows;

    @Override
    public List<Show> getShowsBasedCondition(String country, String count, String startDate, String endDate, String listed_in) {
        return this.daoReadShows.getShowsBasedCondition(country, count, startDate, endDate, listed_in);
    }
}
