package org.lanqiao.service;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condation;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    public List<Book>  findAll();
    public void addBook(Book book);
    public void removeBook(int bid);
    public void modifyBook(Book book);
    public Book findBookByNo(int bid) throws SQLException;
    public List<Book> findPage(int startIndex,int pageSize) throws SQLException;
    public int getTotalNum() throws SQLException;
    public List<Book> serchBook(Condation condation) throws SQLException;
}
