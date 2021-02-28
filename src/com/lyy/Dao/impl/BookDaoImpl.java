package com.lyy.Dao.impl;

import com.lyy.Dao.BasicDao;
import com.lyy.Dao.BookDao;
import com.lyy.domain.Book;

import java.util.List;

/**
 * @description:
 * @author: Moon
 */

public class BookDaoImpl extends BasicDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) \n" +
                "values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ?,`author` = ?,`price` = ?,`sales` = ?,`stock` = ?,`img_path` = ? where `id` = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where id = ?";
        return (Book) queryOne(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBook() {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book";
        return queryMult(sql, Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) scalar(sql, Book.class);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ?,?";
        return queryMult(sql, Book.class, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) scalar(sql, Book.class, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where price between ? and ? order by price limit ?,?";
        return queryMult(sql, Book.class, min, max, begin, pageSize);
    }
}
