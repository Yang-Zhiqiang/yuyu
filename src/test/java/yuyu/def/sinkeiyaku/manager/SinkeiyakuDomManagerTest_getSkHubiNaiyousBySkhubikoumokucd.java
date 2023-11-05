package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiNaiyousBySkhubikoumokucd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiNaiyousBySkhubikoumokucd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHubiNaiyou> stringLst = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd("01");

        Assert.assertEquals(0,stringLst.size());

        HM_SkHubiNaiyou skHubiNaiyou1 = new HM_SkHubiNaiyou("01", "1");
        skHubiNaiyou1.setHyoujikahikbn(C_KahiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(skHubiNaiyou1);

        HM_SkHubiNaiyou skHubiNaiyou2 = new HM_SkHubiNaiyou("01", "2");
        skHubiNaiyou2.setHyoujikahikbn(C_KahiKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(skHubiNaiyou2);

        HM_SkHubiNaiyou skHubiNaiyou3 = new HM_SkHubiNaiyou("02", "1");
        skHubiNaiyou3.setHyoujikahikbn(C_KahiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(skHubiNaiyou3);

        HM_SkHubiNaiyou skHubiNaiyou4 = new HM_SkHubiNaiyou("03", "4");
        skHubiNaiyou4.setHyoujikahikbn(C_KahiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(skHubiNaiyou4);

        HM_SkHubiNaiyou skHubiNaiyou5 = new HM_SkHubiNaiyou("03", "5");
        skHubiNaiyou5.setHyoujikahikbn(C_KahiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(skHubiNaiyou5);

        HM_SkHubiNaiyou skHubiNaiyou6 = new HM_SkHubiNaiyou("03", "6");
        skHubiNaiyou6.setHyoujikahikbn(C_KahiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(skHubiNaiyou6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HM_SkHubiNaiyou> stringLst = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd("05");

        Assert.assertEquals(0, stringLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HM_SkHubiNaiyou> stringLst = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd("01");

        Assert.assertEquals(1, stringLst.size());

        Assert.assertEquals("01", stringLst.get(0).getSkhubikoumokucd());
        Assert.assertEquals("1", stringLst.get(0).getSkhubinaiyoucd());


    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("03","4"), "1");
        datamap.put($("03","5"), "1");
        datamap.put($("03","6"), "1");

        List<HM_SkHubiNaiyou> stringLst = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd("03");

        for(HM_SkHubiNaiyou skHubiNaiyou:stringLst){
            datamap.remove($(
                skHubiNaiyou.getSkhubikoumokucd(),
                skHubiNaiyou.getSkhubinaiyoucd()));
        }

        Assert.assertEquals(3, stringLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HM_SkHubiNaiyou> stringLst = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd("");

        assertEquals(0, stringLst.size());

    }
}
