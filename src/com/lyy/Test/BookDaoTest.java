package com.lyy.Test;

import com.alibaba.druid.sql.dialect.odps.visitor.OdpsOutputVisitor;
import com.lyy.Dao.BookDao;
import com.lyy.Dao.impl.BookDaoImpl;
import com.lyy.domain.Book;
import com.lyy.domain.Page;
import org.junit.Test;

import java.math.BigDecimal;


public class BookDaoTest {
    BookDao bd = new BookDaoImpl();

    @Test
    public void addBook() {

        bd.addBook(new Book(null, "Head for JS", "张三", new BigDecimal(300), 2000, 660, null));
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bd.queryForPageTotalCountByPrice(0,100));
    }

    @Test
    public void queryForPageItemsByPrice(){
        System.out.println(bd.queryForPageItemsByPrice(0,100,0, 8));
    }
}