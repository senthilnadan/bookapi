package org.sidsri.plugins.bookstoreapi.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorService extends CrudRepository<Author, Integer> {
}
