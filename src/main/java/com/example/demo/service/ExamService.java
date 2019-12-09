package com.example.demo.service;

import com.example.demo.entity.Exam;
import com.example.demo.entity.Permis;
import com.example.demo.mapper.ExamMapper;
import com.example.demo.mapper.PermisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private PermisMapper permisMapper;
    public List<Exam> selectAll(){
        return examMapper.selectAll();
    }
    @Cacheable(value = "exam",key = "#root.methodName")
    public List<Exam> selectAllWhereState(){
        return examMapper.selectAllWhereState();
    }

    public List<Exam> selectAllByStateAndAccount(int id){
        List<Exam> examList=examMapper.selectAllWhereState();
        List<Permis> permisList=permisMapper.selectByCid(id);
        if(permisList==null){
            return examList;
        }else {
            Iterator<Exam> it=examList.iterator();
         //   System.out.println(permisList.toString());
            while (it.hasNext()){
                Exam exam=(Exam) it.next();
                for(int i=0;i<permisList.size();i++){
                    if(exam.getEId().equals(permisList.get(i).geteId())&&permisList.get(i).getpState()>0){
                        it.remove();
                    }
                }
            }
        }
        return examList;
    }
}
