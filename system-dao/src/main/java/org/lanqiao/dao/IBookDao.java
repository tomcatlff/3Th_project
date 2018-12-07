package org.lanqiao.dao;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condation;

import java.sql.SQLException;
import java.util.List;

public interface IBookDao {
    //查询所有的书
    public List<Book> getAll() throws SQLException;
    //添加书
    public void insetBook(Book book) throws SQLException;
    //修改书的信息
    public void updateBook(Book book) throws SQLException;
    //删除书的信息
    public void deleteBook(int bid) throws SQLException;
    //根据主键查询图书
    public Book selectBookByNo(int bid) throws SQLException;
    //查询记录条数
    public Long getBookTotalNum() throws SQLException;
    //获取分页数据
    public List<Book> findPageList(int startIndex,int pageSize) throws SQLException;
    //条件查询
    public List<Book> findPageByCondation(Condation con) throws SQLException;
}
