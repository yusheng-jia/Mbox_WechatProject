package com.szty.wx.service.impl;

import com.szty.wx.baseTest.SpringTestCase;
import com.szty.wx.service.WeiXinBaseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* WeiXinBaseServiceImpl Tester. 
* 
* @author <jia>
* @since <pre>03/06/2017</pre> 
* @version 1.0 
*/ 
public class WeiXinBaseServiceImplTest extends SpringTestCase {

    @Autowired
    private WeiXinBaseService weiXinBaseService;

    /**
    *
    * Method: getWeiXinToken()
    *
    */
    @Test
    public void testGetWeiXinToken() throws Exception {
        System.out.println(weiXinBaseService.getWeiXinToken());
    }
}


