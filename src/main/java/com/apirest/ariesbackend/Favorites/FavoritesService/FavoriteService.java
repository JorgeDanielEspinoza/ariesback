package com.apirest.ariesbackend.Favorites.FavoritesService;

import java.util.List;

import com.apirest.ariesbackend.Favorites.Favorites.Favorite;

public interface FavoriteService {
     Favorite save (Favorite favorites);
     List<Favorite> findByIdUser (Integer idUser);
     List<Favorite> findAll();
     void deleteById (Integer id);
     /* void deleteByIdBook(Integer idBook); */
}

