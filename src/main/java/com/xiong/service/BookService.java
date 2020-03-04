package com.xiong.service;

import com.xiong.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    int addBook(Books books);

    int deleteBookByID(int id);

    int updateBook(Books books);

    Books queryBookByID(int id);

    List<Books> queryAllBooks();
}
