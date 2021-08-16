package com.anytrash.privatenotes.models;

import com.anytrash.privatenotes.models.objects.Note;

import java.util.HashMap;

import static com.anytrash.privatenotes.models.Util.getRandomString;

public class NoteStorage {
    private static volatile NoteStorage instance;

    private final HashMap<String, Note> idToNote;

    private static final int ID_LENGTH = 32;

    private NoteStorage() {
        idToNote = new HashMap<>();
    }

    public static NoteStorage getInstance() {
        NoteStorage result = instance;
        if (result != null) {
            return result;
        }
        synchronized(NoteStorage.class) {
            if (instance == null) {
                instance = new NoteStorage();
            }
            return instance;
        }
    }

    public boolean noteExsist(String id) {
        return idToNote.get(id) != null;
    }

    public String putNote(Note note) {
        String id = getRandomString(ID_LENGTH);
        idToNote.put(id, note);
        return id;
    }

    public Note popNote(String id) {
        Note note = idToNote.get(id);
        idToNote.remove(id);
        return note;
    }
}
