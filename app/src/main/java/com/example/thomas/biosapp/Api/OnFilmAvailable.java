package com.example.thomas.biosapp.Api;

import com.example.thomas.biosapp.Domain.Film;

/**
 * Created by steph on 21-3-2018.
 */

public interface OnFilmAvailable {
    void onFilmAvailable(Film film);
    void onFilmsLoaded();
}
