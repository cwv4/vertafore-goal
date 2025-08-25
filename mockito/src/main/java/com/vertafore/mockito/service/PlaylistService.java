package com.vertafore.mockito.service;

import com.vertafore.mockito.model.Playlist;
import com.vertafore.mockito.model.Song;

import java.util.List;

public class PlaylistService {

    public void addSongsToPlaylist(Playlist playlist, List<Song> songs) {
        for (Song song : songs) {
            playlist.addSong(song);
        }
    }
}
