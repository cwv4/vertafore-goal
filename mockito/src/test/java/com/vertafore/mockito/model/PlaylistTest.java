package com.vertafore.mockito.model;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PlaylistTest {

    @Test
    void usingMocksTest() {
        Playlist playlist = mock(Playlist.class);
        when(playlist.getName()).thenReturn("name");
        assertEquals("name", playlist.getName());
    }

    @Test
    void usingArgumentCaptorTest() {
        Playlist playlist = mock(Playlist.class);
        Song mySong = new Song("My Song", "Some Artist", 300, "My Album");

        playlist.addSong(mySong);

        ArgumentCaptor<Song> songCaptor = ArgumentCaptor.forClass(Song.class);
        verify(playlist).addSong(songCaptor.capture());

        Song captured = songCaptor.getValue();
        assertEquals("My Song", captured.getTitle());
        assertEquals(300, captured.getDuration());
    }

    @Test
    void usingAnswersTest() {
        Playlist playlist = mock(Playlist.class);
        doAnswer(invocation -> "name").when(playlist).getName();
        assertEquals("name", playlist.getName());
    }
}
