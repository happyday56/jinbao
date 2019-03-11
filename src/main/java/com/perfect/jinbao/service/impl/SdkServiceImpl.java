package com.perfect.jinbao.service.impl;


import com.lemoncenter.service.api.DdkService;
import com.lemoncenter.service.base.exception.LemonException;
import com.lemoncenter.service.condition.*;
import com.lemoncenter.service.ienum.LemonChannelType;
import com.lemoncenter.service.model.*;
import com.lemoncenter.service.model.ddk.DdkUrlGenerateModel;
import com.perfect.jinbao.service.SdkService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SdkServiceImpl implements SdkService {

    private static final Log log = LogFactory.getLog(SdkServiceImpl.class);

    private DdkService ddkService;

    /**
     * 实例化多多客接口
     */
    @PostConstruct
    @SuppressWarnings("Duplicates")
    private void Init() {
        BaseConfigModel configModel = new BaseConfigModel();

        configModel.setAppKey("3ce78749d0d74b3b8f03e814b408d704");
        configModel.setAppSecret("724f696a32ca6caef193948356aab82093b16812");
        configModel.setDefaultPid("8428632_55423539");
        ddkService = new DdkService(configModel);


    }

    @Override
    public String createDpwd() {
        return ddkService.createDpwd();
    }

    /**
     * 创建推广位PID
     *
     * @param name
     * @return
     * @throws LemonException
     */
    @Override
    public String createPid(String name) throws LemonException {
        return ddkService.createPid(name);
    }

    /**
     * 多多进宝推广链接生成
     *
     * @param condition
     * @return
     * @throws LemonException
     */
    @Override
    public DdkUrlGenerateModel createUrl(UrlGenerateSearchCondition condition) throws LemonException {
        return ddkService.createUrl(condition);
    }

    /**
     * 获取类目ID
     *
     * @param parentId
     * @return
     */
    @Override
    public List<LemonCategory> findCategoryList(Long parentId) {
        return ddkService.findCategoryList(parentId);
    }

    /**
     * 根据主题ID获取商品信息
     *
     * @param themeId
     * @return
     * @throws LemonException
     */
    @Override
    public List<LemonGoods> findGoodsByThemeId(Long themeId) throws LemonException {
        return ddkService.findGoodsByThemeId(themeId);
    }

    @Override
    public LemonGoods findGoodsDetails(Long goodId) throws LemonException {
        return ddkService.findGoodsDetails(goodId);
    }

    /**
     * 获取商品列表
     *
     * @param baseSearchCondition
     * @return
     * @throws LemonException
     */
    @Override
    public List<LemonGoods> findGoodsList(DdkGoodsSearchCondition baseSearchCondition) throws LemonException {
        return ddkService.findGoodsList(baseSearchCondition);
    }

    /**
     * 最后更新时间段增量同步推广订单信息 按照时间段获取授权多多客下面所有多多客的推广订单信息
     *
     * @param baseSearchCondition
     * @return
     * @throws LemonException
     */
    @Override
    public List<LemonOrder> findDdkOrderByTime(BaseSearchCondition baseSearchCondition) throws LemonException {
        return ddkService.findOrderByTime(baseSearchCondition);
    }


    /**
     * 获取推荐商品，存在无优惠券的商品
     *
     * @param offset
     * @param limit
     * @param channelType
     * @return
     */
    @Override
    public List<LemonGoods> findRecommendGoodsList(int offset, int limit, LemonChannelType channelType) {
        return ddkService.findRecommendGoodsList(offset, limit, channelType);
    }

    /**
     * 获取主题列表
     *
     * @param page
     * @param pageSize
     * @return
     * @throws LemonException
     */
    @Override
    public List<LemonTheme> findThemes(Integer page, Integer pageSize) throws LemonException {
        return ddkService.findThemes(page, pageSize);
    }


    /**
     * 过滤没有卷的
     *
     * @param lemonGoodsList
     * @return
     */
    @Override
    public List<LemonGoods> filterNoCoupon(List<LemonGoods> lemonGoodsList) {
        List<LemonGoods> list = new ArrayList<>();
        if (lemonGoodsList != null && lemonGoodsList.size() > 0) {
            lemonGoodsList.forEach(item -> {
                if (item.isHasCoupon()) {
                    list.add(item);
                }
            });
        }
        return list;
    }

}
