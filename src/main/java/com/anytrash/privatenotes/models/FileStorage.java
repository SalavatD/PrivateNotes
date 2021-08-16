package com.anytrash.privatenotes.models;

import com.anytrash.privatenotes.models.objects.File;

import java.util.HashMap;

import static com.anytrash.privatenotes.models.Util.getRandomString;

public class FileStorage {
    private static volatile FileStorage instance;

    private final HashMap<String, File> idToFile;

    private static final int ID_LENGTH = 32;

    private FileStorage() {
        idToFile = new HashMap<>();
    }

    public static FileStorage getInstance() {
        FileStorage result = instance;
        if (result != null) {
            return result;
        }
        synchronized(FileStorage.class) {
            if (instance == null) {
                instance = new FileStorage();
            }
            return instance;
        }
    }

    public boolean fileExsist(String id) {
        return idToFile.get(id) != null;
    }

    public String putFile(File file) {
        String id = getRandomString(ID_LENGTH);
        idToFile.put(id, file);
        return id;
    }

    public File popFile(String id) {
        File file = idToFile.get(id);
        idToFile.remove(id);
        return file;
    }
}
