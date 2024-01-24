package com.project.bookjuck.book;

import com.project.bookjuck.ResultVo;
import com.project.bookjuck.book.model.BookDto;
import com.project.bookjuck.book.model.bookinfo.BookSubInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int insBookApi(BookDto dto);
    List<BookDto> sel(BookDto dto);
    ResultVo configSel(BookDto dto);

    List<BookDto> sel2(BookDto dto);

}
