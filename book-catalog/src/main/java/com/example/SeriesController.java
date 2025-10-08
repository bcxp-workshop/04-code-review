package com.example;

import java.util.List;
import spark.Spark;

public class SeriesController {
    public SeriesRepository repo;

    public SeriesController(SeriesRepository r) {
        this.repo = r;
    }

    public void setupRoutes() {
        Spark.get("/series", (req, res) -> {
            List<Series> seriesList = this.repo.getAllSeries();
            res.type("application/json");
            return Utils.seriesListToJson(seriesList);
        });
        Spark.get("/series/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Series s = this.repo.getSeriesById(id);
            if (s == null) {
                res.status(404);
                return "{\"error\":\"Not found\"}";
            } else {
                res.type("application/json");
                return Utils.seriesToJson(s);
            }
        });
    }
}