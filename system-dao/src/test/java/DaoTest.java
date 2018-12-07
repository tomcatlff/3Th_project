import org.junit.Test;
import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.IManageDao;
import org.lanqiao.dao.ISortDao;
import org.lanqiao.dao.lmpl.BookDaoImpl;
import org.lanqiao.dao.lmpl.ManagerDaoImpl;
import org.lanqiao.dao.lmpl.SortImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.BookSort;
import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public class DaoTest {
    @Test
    public void findAllTest() throws SQLException {
        IBookDao dao = new BookDaoImpl();
        List<Book> bookList = dao.getAll();
        for(Book book:bookList){
            System.out.println(book.getBid());
        }
    }
    @Test
    public void findAll() throws SQLException {
        IManageDao dao = new ManagerDaoImpl();
        List<Manager> managerList = dao.getAll();
        for(Manager manager:managerList){
            System.out.println(manager);
        }
    }
    @Test
    public void find() throws SQLException {
        ISortDao dao = new SortImpl();
        List<BookSort> sortList = dao.sortList();
        for(BookSort sort:sortList){
            System.out.println(sort);
        }
    }
}
