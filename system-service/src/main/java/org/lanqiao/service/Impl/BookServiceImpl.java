package org.lanqiao.service.Impl;

import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.lmpl.BookDaoImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condation;
import org.lanqiao.service.IBookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDao dao;
    public BookServiceImpl(){
        dao = new BookDaoImpl();
    }
    public List<Book> findAll() {
        List<Book> bookList = null;
        try {
            bookList=dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void addBook(Book book) {
        try {
            dao.insetBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(int bid) {
        try {
            dao.deleteBook(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyBook(Book book) {
        try {
            dao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book findBookByNo(int bid) throws SQLException {

            return dao.selectBookByNo(bid);
    }

    public List<Book> findPage(int startIndex, int pageSize) throws SQLException {
        return dao.findPageList(startIndex,pageSize);
    }

    public int getTotalNum() throws SQLException {
       Long num = dao.getBookTotalNum();
       int number=Integer.parseInt(num.toString());
        return number ;
    }

    public List<Book> serchBook(Condation condation) throws SQLException {
        return dao.findPageByCondation(condation);
    }
}
