package com.qpinfo.auth.service.impl;

import com.qpinfo.auth.dao.SysRoleMapper;
import com.qpinfo.auth.pojo.SysRole;
import com.qpinfo.auth.pojo.SysRoleExample;
import com.qpinfo.auth.service.SysRoleService;
import com.qpinfo.utils.Detect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @date 2018/2/28 下午6:32
 * @studio 默云工作室
 * @company 默云网络科技有限公司
 * @project qpinfo-parent
 * @package com.qpinfo.auth.service.impl
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    private Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    SysRoleMapper baseDao;

    @Override
    public int insert(SysRole model) {
        return baseDao.insert(model);
    }

    @Override
    public int save(SysRole model) {
        Integer id = model.getId();
        logger.info(" start save SysRole params [{}] ，id is empty 【{}】",model, Detect.notEmpty(id));
        if(Detect.isPositive(id)){
            logger.info(" ==========  id is not empty excute update =========");
            return baseDao.updateByPrimaryKeySelective(model);
        }
        logger.info(" ==========  id is  empty excute insert =========");
        return baseDao.insertSelective(model);
    }

    @Override
    public int delete(SysRoleExample example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public List<SysRole> list(SysRoleExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public List<SysRole> queryPage(SysRoleExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public SysRole query(SysRoleExample example) {
        List<SysRole> data = baseDao.selectByExample(example);
        if(data!=null && data.size()>0){
            return data.get(0);
        }
        return null;
    }
}
