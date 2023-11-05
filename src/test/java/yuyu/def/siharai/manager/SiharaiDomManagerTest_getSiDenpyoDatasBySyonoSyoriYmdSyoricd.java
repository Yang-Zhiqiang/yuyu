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

import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiDenpyoDatasBySyonoSyoriYmdSyoricd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiDenpyoDatasBySyonoSyoriYmdSyoricd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("11807111118", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(0,siDenpyoDataiLst.size());

        JT_SiDenpyoData siDenpyoData1 = new JT_SiDenpyoData("1000000001", 11);
        siDenpyoData1.setSyono("11807111118");
        siDenpyoData1.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData1.setSyoricd("20");

        siharaiDomManager.insert(siDenpyoData1);

        JT_SiDenpyoData siDenpyoData2 = new JT_SiDenpyoData("1000000002", 12);
        siDenpyoData2.setSyono("11807111129");
        siDenpyoData2.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData2.setSyoricd("20");

        siharaiDomManager.insert(siDenpyoData2);

        JT_SiDenpyoData siDenpyoData3 = new JT_SiDenpyoData("1000000003", 13);
        siDenpyoData3.setSyono("11807111118");
        siDenpyoData3.setSyoriYmd(BizDate.valueOf(20161101));
        siDenpyoData3.setSyoricd("20");

        siharaiDomManager.insert(siDenpyoData3);

        JT_SiDenpyoData siDenpyoData4 = new JT_SiDenpyoData("1000000004", 14);
        siDenpyoData4.setSyono("11807111118");
        siDenpyoData4.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData4.setSyoricd("21");

        siharaiDomManager.insert(siDenpyoData4);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("11807111406", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(0,siDenpyoDataiLst.size());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1(){

        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("11807111118", BizDate.valueOf(20161111), "21");

        Assert.assertEquals(1, siDenpyoDataiLst.size());
        Assert.assertEquals("1000000001",siDenpyoDataiLst.get(0).getDenrenno());
        Assert.assertEquals(Integer.valueOf(11),siDenpyoDataiLst.get(0).getEdano());

        siharaiDomManager.delete(siharaiDomManager.getAllSiDenpyoData());

        JT_SiDenpyoData siDenpyoData1 = new JT_SiDenpyoData("1000000005", 15);
        siDenpyoData1.setSyono("11807111130");
        siDenpyoData1.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData1.setSyoricd("11");

        siharaiDomManager.insert(siDenpyoData1);

        JT_SiDenpyoData siDenpyoData2 = new JT_SiDenpyoData("1000000006", 16);
        siDenpyoData2.setSyono("11807111130");
        siDenpyoData2.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData2.setSyoricd("12");

        siharaiDomManager.insert(siDenpyoData2);

        JT_SiDenpyoData siDenpyoData3 = new JT_SiDenpyoData("1000000007", 17);
        siDenpyoData3.setSyono("11807111130");
        siDenpyoData3.setSyoriYmd(BizDate.valueOf(20161111));
        siDenpyoData3.setSyoricd("13");

        siharaiDomManager.insert(siDenpyoData3);
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        Map<String,String> siDenpyoDataMap = new HashMap<String,String>();
        siDenpyoDataMap.put($("1000000005", 15), "1");
        siDenpyoDataMap.put($("1000000006", 16), "1");
        siDenpyoDataMap.put($("1000000007", 17), "1");


        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("11807111130", BizDate.valueOf(20161111), "10");

        Assert.assertEquals(3, siDenpyoDataiLst.size());

        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(0).getDenrenno(), siDenpyoDataiLst.get(0).getEdano()));
        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(1).getDenrenno(), siDenpyoDataiLst.get(1).getEdano()));
        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(2).getDenrenno(), siDenpyoDataiLst.get(2).getEdano()));

        assertTrue(siDenpyoDataMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("", BizDate.valueOf(20161111), "10");
        Assert.assertEquals(0, siDenpyoDataiLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Map<String,String> siDenpyoDataMap = new HashMap<String,String>();
        siDenpyoDataMap.put($("1000000005", 15), "1");
        siDenpyoDataMap.put($("1000000006", 16), "1");
        siDenpyoDataMap.put($("1000000007", 17), "1");

        List<JT_SiDenpyoData> siDenpyoDataiLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd("11807111130", BizDate.valueOf(20161111), "");

        Assert.assertEquals(3, siDenpyoDataiLst.size());

        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(0).getDenrenno(), siDenpyoDataiLst.get(0).getEdano()));
        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(1).getDenrenno(), siDenpyoDataiLst.get(1).getEdano()));
        siDenpyoDataMap.remove($(siDenpyoDataiLst.get(2).getDenrenno(), siDenpyoDataiLst.get(2).getEdano()));

        assertTrue(siDenpyoDataMap.isEmpty());
    }
}
