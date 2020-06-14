package com.telagene.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * This interface is responsible to define the contract required to implement a StorageService.
 * A class that implements this interface serve will act as a bridge between the REST api and the
 * underlying file system for storage and retrieval of files.
 * <p>
 * First, the class must be initialized using the {@link #init()} method to create the storage directories.
 * Then, the {@link #store(MultipartFile)} method will process the received file for storage on the local file system.
 */
public interface StorageService {

   /**
    * StorageService initialization. Used to create storage directories.
    */
   void init();

   /**
    * Stores a received {@link MultipartFile} in a local directory.
    *
    * @param file Received file.
    */
   void store(MultipartFile file);

   /**
    * List all the files in the root directory.
    *
    * @return {@link Stream} of files paths.
    */
   Stream<Path> loadAll();

   /**
    * Returns the {@link Path} associated with a supplied file as string.
    *
    * @param filename String url of the file.
    * @return {@link Path} associated with a supplied file
    */
   Path load(String filename);

   /**
    * Returns the {@link Resource} associated with a supplied file as string.
    *
    * @param filename String url of the file.
    * @return {@link Resource} associated with a supplied file
    */
   Resource loadAsResource(String filename);

   /**
    * Delete all files recursively in the root directory as defined in the {@link StorageProperties} location.
    */
   void deleteAll();

}
