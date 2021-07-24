package org.sidsri.plugins.bookstoreapi.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookService extends CrudRepository<Book, Integer> {
}
