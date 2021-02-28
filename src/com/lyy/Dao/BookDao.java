package com.lyy.Dao;

import com.lyy.domain.Book;

import java.util.List;

/**
 * @author a1314
 */
public interface BookDao {
    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 删除图书
     *
     * @return
     */
    public int deleteBook(Integer id);

    /**
     * 更新图书信息
     *
     * @return
     */
    public int updateBook(Book book);

    /**
     * 通过id查询图书
     *
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);


    /**
     * 查询图书
     *
     * @return
     */
    public List<Book> queryBook();

    /**
     * 查询总记录数
     *
     * @return
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询当前页面数据
     *
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 通过价格查询总记录数
     *
     * @param min
     * @param max
     * @return
     */
    public Integer queryForPageTotalCountByPrice(int min, int max);

    /**
     * 通过价格查询数据
     *
     * @param min
     * @param max
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
