package com.vertafore.mockito.service;

import com.vertafore.mockito.model.Playlist;
import com.vertafore.mockito.model.Song;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlaylistServiceTest {

    PlaylistService playlistService = new PlaylistService();

    @Test
    void usingAnswerWithArgCaptorTest() {
        Playlist playlist = mock(Playlist.class);
        Song mySong = new Song("My Song", "Some Artist", 300, "My Album");

        ArgumentCaptor<Song> songListCaptor = ArgumentCaptor.forClass(Song.class);
        doAnswer(invocationOnMock -> songListCaptor.getValue()).when(playlist).getSongs();

        playlistService.addSongsToPlaylist(playlist, List.of(mySong));

        verify(playlist).addSong(songListCaptor.capture());

        Song captured = songListCaptor.getValue();
        assertEquals("My Song", captured.getTitle());
        assertEquals(300, captured.getDuration());
    }
}
