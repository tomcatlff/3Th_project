package org.lanqiao.dao.lmpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IBookDao;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condation;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    public List<Book> getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bid,bsortno,bimg,bname,author,publishing,pubtime,price,info,bcount from bookinfo";
        return qr.query(sql,new BeanListHandler<Book>(Book.class));
    }

    public void insetBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "insert into bookinfo (bsortno,bimg,bname,author,publishing,pubtime,price,info,bcount) values (?,?,?,?,?,?,?,?,?)";
        qr.update(sql,book.getBsortno(),book.getBimg(),book.getBaname(),book.getAuthor(),book.getPublishing(),book.getPubtime(),book.getPrice(),book.getInfo(),book.getBcount());
    }

    public void updateBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "update bookinfo set bsortno=?,bimg=?,bname=?,author=?,publishing=?,pubtime=?,price=?,info=?,bcount=? where bid=?";
        qr.update(sql,book.getBsortno(),book.getBimg(),book.getBaname(),book.getAuthor(),book.getPublishing(),book.getPubtime(),book.getPrice(),book.getInfo(),book.getBcount(),book.getBid());

    }

    public void deleteBook(int bid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from bookinfo where bid=?";
        qr.update(sql,bid);
    }

    public Book selectBookByNo(int bid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bid,bsortno,bimg,bname,author,publishing,pubtime,price,info,bcount from bookinfo where bid=?";
        return qr.query(sql,new BeanHandler<Book>(Book.class),bid);
    }

    public Long getBookTotalNum() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql="select count(*) from bookinfo";
        return (Long) qr.query(sql,new ScalarHandler(1));

    }

    public List<Book> findPageList(int startIndex, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bid,bsortno,bimg,bname,author,publishing,pubtime,price,info,bcount from bookinfo limit ?,?";
        return qr.query(sql,new BeanListHandler<Book>(Book.class),startIndex,pageSize);
    }

    public List<Book> findPageByCondation(Condation con) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        StringBuffer sqlBuff = new StringBuffer("select bsortno,bimg,bname,author,publishing,pubtime,price,info,bcount from bookinfo where 1=1");
        List<Object> paramList = new ArrayList<Object>();
        if(con.getSerBname()!=null){
            sqlBuff.append(" and bname like ? ");
            paramList.add(con.getSerBname());
        }else if(con.getSerBsort()!=null){
            sqlBuff.append(" and bsortno = ?");
            paramList.add(con.getSerBsort());
        }
        return qr.query(sqlBuff.toString(),new BeanListHandler<Book>(Book.class),paramList.toArray());
    }
}
