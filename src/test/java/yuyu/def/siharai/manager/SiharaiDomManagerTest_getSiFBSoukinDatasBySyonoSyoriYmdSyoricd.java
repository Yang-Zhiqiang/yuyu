package yuyu.def.siharai.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiFBSoukinDatasBySyonoSyoriYmdSyoricd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiFBSoukinDatasBySyonoSyoriYmdSyoricd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(0,siFBSoukinDataiLst.size());

        JT_SiFBSoukinData siFBSoukinData1 = new JT_SiFBSoukinData("10000000001");
        siFBSoukinData1.setSyoricd("20");
        siFBSoukinData1.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData1.setSyono("11807111118");

        siharaiDomManager.insert(siFBSoukinData1);

        JT_SiFBSoukinData siFBSoukinData2 = new JT_SiFBSoukinData("10000000002");
        siFBSoukinData2.setSyoricd("20");
        siFBSoukinData2.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData2.setSyono("11807111129");

        siharaiDomManager.insert(siFBSoukinData2);

        JT_SiFBSoukinData siFBSoukinData3 = new JT_SiFBSoukinData("10000000003");
        siFBSoukinData3.setSyoricd("20");
        siFBSoukinData3.setSyoriYmd(BizDate.valueOf(20161101));
        siFBSoukinData3.setSyono("11807111118");

        siharaiDomManager.insert(siFBSoukinData3);

        JT_SiFBSoukinData siFBSoukinData4 = new JT_SiFBSoukinData("10000000004");
        siFBSoukinData4.setSyoricd("21");
        siFBSoukinData4.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData4.setSyono("11807111118");

        siharaiDomManager.insert(siFBSoukinData4);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiFBSoukinData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111406", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(0,siFBSoukinDataiLst.size());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20(){

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111118", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(1,siFBSoukinDataiLst.size());
        Assert.assertEquals("10000000001",siFBSoukinDataiLst.get(0).getFbsoukindatasikibetukey());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30(){
        siharaiDomManager.delete(siharaiDomManager.getAllSiFBSoukinData());

        JT_SiFBSoukinData siFBSoukinData1 = new JT_SiFBSoukinData("10000000011");
        siFBSoukinData1.setSyoricd("11");
        siFBSoukinData1.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData1.setSyono("11807111130");

        siharaiDomManager.insert(siFBSoukinData1);

        JT_SiFBSoukinData siFBSoukinData2 = new JT_SiFBSoukinData("10000000012");
        siFBSoukinData2.setSyoricd("12");
        siFBSoukinData2.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData2.setSyono("11807111130");

        siharaiDomManager.insert(siFBSoukinData2);

        JT_SiFBSoukinData siFBSoukinData3 = new JT_SiFBSoukinData("10000000013");
        siFBSoukinData3.setSyoricd("13");
        siFBSoukinData3.setSyoriYmd(BizDate.valueOf(20161111));
        siFBSoukinData3.setSyono("11807111130");

        siharaiDomManager.insert(siFBSoukinData3);

    }

    @Test
    @TestOrder(31)
    public void normal31(){

        Map<String,String> siFBSoukinDataMap = new HashMap<String,String>();
        siFBSoukinDataMap.put($("10000000011"), "1");
        siFBSoukinDataMap.put($("10000000012"), "1");
        siFBSoukinDataMap.put($("10000000013"), "1");

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111130", BizDate.valueOf(20161111), "10");

        Assert.assertEquals(3, siFBSoukinDataiLst.size());

        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(0).getFbsoukindatasikibetukey()));
        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(1).getFbsoukindatasikibetukey()));
        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(2).getFbsoukindatasikibetukey()));

        assertTrue(siFBSoukinDataMap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("", BizDate.valueOf(20161111), "10");
        Assert.assertEquals(0, siFBSoukinDataiLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Map<String,String> siFBSoukinDataMap = new HashMap<String,String>();
        siFBSoukinDataMap.put($("10000000011"), "1");
        siFBSoukinDataMap.put($("10000000012"), "1");
        siFBSoukinDataMap.put($("10000000013"), "1");

        List<JT_SiFBSoukinData> siFBSoukinDataiLst = siharaiDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd("11807111130", BizDate.valueOf(20161111), "");

        Assert.assertEquals(3, siFBSoukinDataiLst.size());

        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(0).getFbsoukindatasikibetukey()));
        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(1).getFbsoukindatasikibetukey()));
        siFBSoukinDataMap.remove($(siFBSoukinDataiLst.get(2).getFbsoukindatasikibetukey()));

        assertTrue(siFBSoukinDataMap.isEmpty());

    }
}
