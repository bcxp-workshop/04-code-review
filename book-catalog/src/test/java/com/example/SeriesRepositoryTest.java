package com.example;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeriesRepositoryTest {
    private static SeriesRepository repo;

    @BeforeClass
    public static void setup() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb2;DB_CLOSE_DELAY=-1", "sa", "");
        RunScript.execute(conn, new FileReader("src/test/resources/data.sql"));
        repo = new SeriesRepository(conn);
    }

    @Test
    public void testGetAllSeries() {
        List<Series> seriesList = repo.getAllSeries();
        Assert.assertTrue(seriesList.size() >= 2);
        boolean found = false;

        for(Series s : seriesList) {
            if (s.name.equals("Scheibenwelt")) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test
    public void testGetSeriesById() {
        Series s = repo.getSeriesById(1);
        Assert.assertNotNull(s);
        Assert.assertEquals("Scheibenwelt", s.name);
        Assert.assertTrue(s.books.size() >= 2);
    }
}