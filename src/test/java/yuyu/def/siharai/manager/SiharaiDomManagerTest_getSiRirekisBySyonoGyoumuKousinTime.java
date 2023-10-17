package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiRirekisBySyonoGyoumuKousinTime() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiRirekisBySyonoGyoumuKousinTime {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("1001", "20160202");
        Assert.assertEquals(0,siRirekiLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("111","1001");

        JT_SkKihon skKihon2 = new JT_SkKihon("111","1002");

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("A001");
        siRireki1.setGyoumuKousinTime("20160202");

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("A001");
        siRireki2.setGyoumuKousinTime("20160202");

        JT_SiRireki siRireki3 = skKihon2.createSiRireki();
        siRireki3.setShrsikibetukey("A002");
        siRireki3.setGyoumuKousinTime("20160202");

        JT_SiRireki siRireki4 = skKihon2.createSiRireki();
        siRireki4.setShrsikibetukey("A003");
        siRireki4.setGyoumuKousinTime("20160203");

        JT_SiRireki siRireki5 = skKihon2.createSiRireki();
        siRireki5.setShrsikibetukey("A004");
        siRireki5.setGyoumuKousinTime("20160201");

        siharaiDomManager.insert(skKihon1);
        siharaiDomManager.insert(skKihon2);

    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("1001", "20160204");

        Assert.assertEquals(0,siRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("1001", "20160202");

        Assert.assertEquals(1,siRirekiLst.size());
        Assert.assertEquals("111", siRirekiLst.get(0).getSkno());
        Assert.assertEquals("1001", siRirekiLst.get(0).getSyono());
        Assert.assertEquals("A001", siRirekiLst.get(0).getShrsikibetukey());
        Assert.assertEquals("20160202", siRirekiLst.get(0).getGyoumuKousinTime());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("111","1002","A001","20160202"), "1");
        datamap.put($("111","1002","A002","20160202"), "2");
        datamap.put($("111","1002","A003","20160203"), "2");

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("1002", "20160202");

        for(JT_SiRireki siRireki:siRirekiLst){
            datamap.remove($(
                siRireki.getSkno(),
                siRireki.getSyono(),
                siRireki.getShrsikibetukey(),
                siRireki.getGyoumuKousinTime()));
        }

        Assert.assertEquals(3,siRirekiLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiRireki> byoumeiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("", "20160202");

        Assert.assertEquals(0,byoumeiLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<JT_SiRireki> byoumeiLst1 = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime("2001", "");

        Assert.assertEquals(0,byoumeiLst1.size());
    }
}
