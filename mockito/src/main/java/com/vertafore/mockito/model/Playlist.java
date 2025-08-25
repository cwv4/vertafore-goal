package com.vertafore.mockito.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private String name;
    private List<Song> songs;
    private int currentIndex;

    public Playlist() {
        this.songs = new ArrayList<>();
        this.currentIndex = -1;
    }

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.currentIndex = -1;
    }

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = new ArrayList<>(songs); // defensive copy
        this.currentIndex = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs); // return copy for immutability
    }

    public void setSongs(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
        this.currentIndex = -1;
    }

    // Add song
    public void addSong(Song song) {
        songs.add(song);
    }

    // Remove song
    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    // Shuffle playlist
    public void shuffle() {
        Collections.shuffle(songs);
        currentIndex = -1;
    }

    // Get next song in sequence
    public Song nextSong() {
        if (songs.isEmpty()) {
            return null;
        }
        currentIndex = (currentIndex + 1) % songs.size();
        return songs.get(currentIndex);
    }

    // toString
    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist playlist)) return false;
        return Objects.equals(name, playlist.name) &&
                Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, songs);
    }
}
