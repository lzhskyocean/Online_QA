package com.lzh.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lizhenhao
 */
@Data
@NoArgsConstructor
public class PageInfo<T> {

    //1.当前页
    private Integer page;

    //2.每页的条数
    private Integer size;

    //3.数据的总条数(查)
    private Integer count;

    //4.数据总页数(算)
    private Integer pages;

    //5.起始索引(算)
    private Integer offset;

    //6.具体数据(查)
    private List<T> list;

    //构造方法进行初始化
    public PageInfo(Integer page, Integer size, Integer count) {
        this.page = page < 1 ? 1 : page;
        this.size = size < 1 ? 5 : size;
        this.count = count;
        this.pages = (int)Math.ceil(this.count*1.0/this.size);
        this.offset = (this.page-1)*this.size;
    }

}
