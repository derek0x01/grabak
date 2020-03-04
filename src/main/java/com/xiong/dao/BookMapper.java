package com.xiong.dao;


import com.xiong.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookMapper {
    int addBook(Books books);

    int deleteBookByID(@Param("bookID") int id);

    int updateBook(Books books);

    Books queryBookByID(@Param("bookID") int id);

    List<Books> queryAllBooks();

}
