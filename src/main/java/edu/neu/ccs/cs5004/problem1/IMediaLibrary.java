package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * Overall interface for a media library.
 */
public interface IMediaLibrary {

  List<AbstractMedia> getAllMediaByDirector(Director director);

  void addNewMedia(AbstractMedia media, List<Actor> actors, List<Director> directors)
      throws MediaAlreadyExistsException;

  Integer trackStreamRequests(String alias);

  void addToStreamRequests(String alias);

  AbstractMedia getMostStreamed();

}
