package com.da.service;

import com.da.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);
    Type getType(long id);
    Type getTypeByName(String name);
    Page<Type> listType(Pageable pageable);
    List<Type> listType();
    List<Type> listType(Integer size);
    Type updateType(Long id,Type type);
    void  deleteType(long id);

}
