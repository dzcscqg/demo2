package com.example.demo.service;

import com.example.demo.entity.Rj;
import com.example.demo.mapper.RjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RjService {
    @Autowired
    private RjMapper rjMapper;

    public int updateAll(int rid,int[] jid){
        int i=1;
        List<Rj> rjList=selectByRid(rid);
        /*增加*/

        /*删除*/
        Rj temp=new Rj();
        //增加
    int j,y;
        for( j=0;j<jid.length;j++){
            boolean flag=true;
            for( y=0;y<rjList.size();y++){
                if(jid[j]==rjList.get(y).getjId()){
                    flag=false;
                }
            }
            if(flag==true){
                temp.setrId(rid);
                temp.setjId(jid[j]);
                i=insert(temp);
                if(i==0){break;}
            }
        }

        //删除
        Iterator<Rj> it=rjList.iterator();
        while (it.hasNext()){
            Rj rj2=it.next();
            boolean flag2=true;
            for(j=0;j<jid.length;j++){
                if(rj2.getjId()==jid[j]){
                    flag2=false;
                }
            }
            if(flag2==true){
               i=del(rj2.getRjId());
               if(i==0){break;}
            }
        }

        /*执行*/



    return i;
    }
    public int del(int id){
        return rjMapper.deleteByPrimaryKey(id);
    }
    public int insert(Rj rj){
        return rjMapper.insertSelective(rj);
    }
    public List<Rj> selectByRid(int rid){
        return rjMapper.selectByRid(rid);
    }
}
