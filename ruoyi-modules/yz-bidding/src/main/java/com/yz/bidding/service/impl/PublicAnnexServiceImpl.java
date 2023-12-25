package com.yz.bidding.service.impl;

import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.mapper.PublicAnnexMapper;
import com.yz.bidding.service.IPublicAnnexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PublicAnnexServiceImpl implements IPublicAnnexService {
    @Resource
    private PublicAnnexMapper annexMapper;

    @Override
    public List<Map<String, Object>> findAnnexByTenderProjectsId(String pid) {
        return annexMapper.findAnnexByTenderProjectsId(pid);
    }

    @Override
    public PublicAnnex selectPublicAnnexByAnnexId(Long annexId) {
        return annexMapper.selectPublicAnnexByAnnexId(annexId);
    }

    @Override
    public List<PublicAnnex> selectPublicAnnexList(PublicAnnex publicAnnex) {
        return annexMapper.selectPublicAnnexList(publicAnnex);
    }

    @Override
    public int insertPublicAnnex(PublicAnnex publicAnnex) {
        return annexMapper.insertPublicAnnex(publicAnnex);
    }

    @Override
    public int updatePublicAnnex(PublicAnnex publicAnnex) {
        return annexMapper.updatePublicAnnex(publicAnnex);
    }

    @Override
    public int deletePublicAnnexByAnnexIds(Long[] annexIds) {
        return annexMapper.deletePublicAnnexByAnnexIds(annexIds);
    }

    @Override
    public int deletePublicAnnexByAnnexId(Long annexId) {
        return annexMapper.deletePublicAnnexByAnnexId(annexId);
    }

    @Override
    public List<PublicAnnex> findAnnexByOrder(Long oid) {
        return annexMapper.findAnnexByOrder(oid);
    }
}
