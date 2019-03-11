package com.perfect.jinbao.service;


import com.lemoncenter.service.base.exception.LemonException;
import com.lemoncenter.service.condition.BaseSearchCondition;
import com.lemoncenter.service.condition.DdkGoodsSearchCondition;
import com.lemoncenter.service.condition.UrlGenerateSearchCondition;
import com.lemoncenter.service.ienum.LemonChannelType;
import com.lemoncenter.service.model.LemonCategory;
import com.lemoncenter.service.model.LemonGoods;
import com.lemoncenter.service.model.LemonOrder;
import com.lemoncenter.service.model.LemonTheme;
import com.lemoncenter.service.model.ddk.DdkUrlGenerateModel;

import java.util.List;

public interface SdkService {


    String createDpwd();

    String createPid(String name) throws LemonException;

    DdkUrlGenerateModel createUrl(UrlGenerateSearchCondition condition) throws LemonException;

    List<LemonCategory> findCategoryList(Long parentId);

    List<LemonGoods> findGoodsByThemeId(Long themeId) throws LemonException;

    LemonGoods findGoodsDetails(Long goodId) throws LemonException;

    List<LemonGoods> findGoodsList(DdkGoodsSearchCondition baseSearchCondition) throws LemonException;

    List<LemonOrder> findDdkOrderByTime(BaseSearchCondition baseSearchCondition) throws LemonException;

    List<LemonGoods> findRecommendGoodsList(int offset, int limit, LemonChannelType channelType);

    List<LemonTheme> findThemes(Integer page, Integer pageSize) throws LemonException;

    List<LemonGoods> filterNoCoupon(List<LemonGoods> lemonGoodsList);
}
