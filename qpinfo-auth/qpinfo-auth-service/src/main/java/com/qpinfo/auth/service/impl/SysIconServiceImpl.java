package com.qpinfo.auth.service.impl;

import com.qpinfo.auth.dao.SysIconMapper;
import com.qpinfo.auth.pojo.SysIcon;
import com.qpinfo.auth.pojo.SysIconExample;
import com.qpinfo.auth.service.SysIconService;
import com.qpinfo.utils.Detect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/20 下午2:20
 * @Company 青朴信息技术服务有限公司
 */
@Service
public class SysIconServiceImpl implements SysIconService {
    Logger logger = LoggerFactory.getLogger(SysIconServiceImpl.class);
    @Autowired
    SysIconMapper baseDao;
    @Override
    public int insert(SysIcon model) {
        return 0;
    }

    @Override
    public int save(SysIcon model) {
        Integer id = model.getId();
        logger.info(" start save params [{}] ，id is empty 【{}】",model,Detect.notEmpty(id));
        if(Detect.isPositive(id)){
            logger.info(" ==========  id is not empty excute update =========");
           return baseDao.updateByPrimaryKeySelective(model);
        }
        logger.info(" ==========  id is  empty excute insert =========");
        return baseDao.insertSelective(model);
    }

    @Override
    public int delete(SysIconExample example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public List<SysIcon> list(SysIconExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public List<SysIcon> queryPage(SysIconExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public SysIcon query(SysIconExample example) {
        List<SysIcon> data = baseDao.selectByExample(example);
        if(data!=null && data.size()>0){
            return data.get(0);
        }
        return null;
    }
}
