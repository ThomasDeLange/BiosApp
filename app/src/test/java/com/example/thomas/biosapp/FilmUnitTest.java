package com.example.thomas.biosapp;

import com.example.thomas.biosapp.Domain.Film;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FilmUnitTest {
    @Test
    public void filmGetAndSet_newFilm_noExeption() throws Exception {

        Film film = new Film("Finding nemo", "123", "A film about a fish", "12");

        assertTrue("Check name",film.getName().equals("Finding nemo"));
        assertTrue("Check posterUrl",film.getPosterUrl().equals("123"));
        assertTrue("Check description",film.getDescription().equals("A film about a fish"));
        assertTrue("Check id",film.getId().equals("12"));

    }
    @Test
    public void filmEquals_twoFilms_noExeption() throws Exception {
        Film film1 = new Film("Finding nemo", "123", "A film about a fish", "12");
        Film film2 = new Film("Finding nemo", "123", "A film about a fish", "12");

        assertTrue(film1.equals(film2));

    }


}
