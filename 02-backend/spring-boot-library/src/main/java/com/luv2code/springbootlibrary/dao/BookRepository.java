package com.luv2code.springbootlibrary.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springbootlibrary.entity.Book;


//@RepositoryRestResource(collectionResourceRel="", path="books/title")
public interface BookRepository extends JpaRepository<Book,Long> {
	Page<Book> findByTitleContaining(@Param("title") String title, Pageable pageable);
	
	Page<Book> findByCategory(@Param("category") String category, Pageable pageable);

	@Query("select o from Book o where id in :book_ids")
	List<Book> findBooksByBookIds(@Param("book_ids") List<Long> bookId);
	//since our function returns List<Book> and springboot will not know what to do with it
	//Hence we need to explicitly write a query to be able to tell spring what to do when the given function is invoked
	
}
