package com.lyy.Service;

import com.lyy.domain.Book;
import com.lyy.domain.Page;

import java.util.List;


public interface BookService {

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 通过id删除图书
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 通过id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询图书
     * @return
     */
    public List<Book> queryBook();

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> page(int pageNo,int pageSize);

    /**
     * 搜索分页
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
