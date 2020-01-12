package com.da.service;

import com.da.NotFoundException;
import com.da.dao.TyprRepository;
import com.da.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements  TypeService {
    @Autowired
    private TyprRepository typrRepository;
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typrRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(long id) {
        return typrRepository.findOne(id);
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typrRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typrRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typrRepository.findAll();
    }

    @Override
    public List<Type> listType(Integer size) {
        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typrRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t=typrRepository.findOne(id);
        if(t==null){
            throw  new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return typrRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(long id) {
        typrRepository.delete(id);
    }
}
