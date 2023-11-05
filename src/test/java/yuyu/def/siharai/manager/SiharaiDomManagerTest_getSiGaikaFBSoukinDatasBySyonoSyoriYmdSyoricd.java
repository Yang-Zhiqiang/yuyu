package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd{

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118",BizDate.valueOf(20161126), "CD01");

        Assert.assertEquals(0,siGaikaFBSoukinDataLst.size());

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData1 = new JT_SiGaikaFBSoukinData("10");
        siGaikaFBSoukinData1.setSyoricd("CD02");
        siGaikaFBSoukinData1.setSyoriYmd(BizDate.valueOf(20161126));
        siGaikaFBSoukinData1.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData1);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData2 = new JT_SiGaikaFBSoukinData("11");
        siGaikaFBSoukinData2.setSyoricd("CD01");
        siGaikaFBSoukinData2.setSyoriYmd(BizDate.valueOf(20161126));
        siGaikaFBSoukinData2.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData2);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData3 = new JT_SiGaikaFBSoukinData("12");
        siGaikaFBSoukinData3.setSyoricd("CD02");
        siGaikaFBSoukinData3.setSyoriYmd(BizDate.valueOf(20161127));
        siGaikaFBSoukinData3.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData3);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData4 = new JT_SiGaikaFBSoukinData("13");
        siGaikaFBSoukinData4.setSyoricd("CD02");
        siGaikaFBSoukinData4.setSyoriYmd(BizDate.valueOf(20161126));
        siGaikaFBSoukinData4.setSyono("11807111129");

        siharaiDomManager.insert(siGaikaFBSoukinData4);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData5 = new JT_SiGaikaFBSoukinData("14");
        siGaikaFBSoukinData5.setSyoricd("CD03");
        siGaikaFBSoukinData5.setSyoriYmd(BizDate.valueOf(20161106));
        siGaikaFBSoukinData5.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData5);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData6 = new JT_SiGaikaFBSoukinData("15");
        siGaikaFBSoukinData6.setSyoricd("CD03");
        siGaikaFBSoukinData6.setSyoriYmd(BizDate.valueOf(20161106));
        siGaikaFBSoukinData6.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData6);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData7 = new JT_SiGaikaFBSoukinData("16");
        siGaikaFBSoukinData7.setSyoricd("CD03");
        siGaikaFBSoukinData7.setSyoriYmd(BizDate.valueOf(20161106));
        siGaikaFBSoukinData7.setSyono("11807111118");

        siharaiDomManager.insert(siGaikaFBSoukinData7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiGaikaFBSoukinData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111163",BizDate.valueOf(20161126), "CD01");

        Assert.assertEquals(0,siGaikaFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118",BizDate.valueOf(20161126), "CD01");

        Assert.assertEquals(1,siGaikaFBSoukinDataLst.size());
        Assert.assertEquals("10", siGaikaFBSoukinDataLst.get(0).getFbsoukindatasikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        Map<String,String> siGaikaFBSoukinDataMap = new HashMap<String,String>();
        siGaikaFBSoukinDataMap.put($("14"), "1");
        siGaikaFBSoukinDataMap.put($("15"), "1");
        siGaikaFBSoukinDataMap.put($("16"), "1");

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118",BizDate.valueOf(20161106), "CD01");

        Assert.assertEquals(3,siGaikaFBSoukinDataLst.size());

        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(0).getFbsoukindatasikibetukey()));
        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(1).getFbsoukindatasikibetukey()));
        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(2).getFbsoukindatasikibetukey()));

        assertTrue(siGaikaFBSoukinDataMap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("",BizDate.valueOf(20161106), "CD01");

        Assert.assertEquals(0,siGaikaFBSoukinDataLst.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        Map<String,String> siGaikaFBSoukinDataMap = new HashMap<String,String>();
        siGaikaFBSoukinDataMap.put($("14"), "1");
        siGaikaFBSoukinDataMap.put($("15"), "1");
        siGaikaFBSoukinDataMap.put($("16"), "1");

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager.
            getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118", BizDate.valueOf(20161106), "");

        Assert.assertEquals(3, siGaikaFBSoukinDataLst.size());

        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(0).getFbsoukindatasikibetukey()));
        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(1).getFbsoukindatasikibetukey()));
        siGaikaFBSoukinDataMap.remove($(siGaikaFBSoukinDataLst.get(2).getFbsoukindatasikibetukey()));

        assertTrue(siGaikaFBSoukinDataMap.isEmpty());

    }
}
