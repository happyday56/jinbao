package com.perfect.jinbao.controller;


import com.alibaba.fastjson.JSON;
import com.lemoncenter.service.base.exception.LemonException;
import com.lemoncenter.service.model.LemonGoods;
import com.perfect.jinbao.service.SdkService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IndexControllerTest extends BasetTest {
    Log log = LogFactory.getLog(IndexControllerTest.class);

    @Autowired
    private SdkService sdkService;

    @Test
    public void index() throws LemonException {
       LemonGoods lemonGoods = sdkService.findGoodsDetails(5809877073L);
       log.info(JSON.toJSONString(lemonGoods));
    }
}