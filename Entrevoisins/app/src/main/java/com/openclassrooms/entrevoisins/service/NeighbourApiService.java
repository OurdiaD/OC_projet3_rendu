package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get my favorites Neighbours
     * @return {@link List}
     */
    List<Neighbour> getFavs();

    /**
     * Deletes a neighbour
     * @param neighbour neighbour selected
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour new neighbour
     */
    void createNeighbour(Neighbour neighbour);


    /**
     * Edit a neighbour
     * @param neighbour neighbour selected
     */
    void editNeighbour(Neighbour neighbour);
}
