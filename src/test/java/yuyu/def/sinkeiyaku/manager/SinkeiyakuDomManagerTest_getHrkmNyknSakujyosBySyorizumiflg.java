package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHrkmNyknSakujyosBySyorizumiflg() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknSakujyosBySyorizumiflg {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosBySyorizumiflg(
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0,hrkmNyknSakujyoLst.size());

        if (hrkmNyknSakujyoLst.size() == 0) {
            HT_HrkmNyknSakujyo hrkmNyknSakujyo = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo.setHrkmdeldataskbtkey("100000000");
            hrkmNyknSakujyo.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo2 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo2.setHrkmdeldataskbtkey("200000000");
            hrkmNyknSakujyo2.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo2);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo3 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo3.setHrkmdeldataskbtkey("300000000");
            hrkmNyknSakujyo3.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo3);

            HT_HrkmNyknSakujyo hrkmNyknSakujyo4 = new HT_HrkmNyknSakujyo();
            hrkmNyknSakujyo4.setHrkmdeldataskbtkey("400000000");
            hrkmNyknSakujyo4.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            sinkeiyakuDomManager.insert(hrkmNyknSakujyo4);

        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknSakujyo());
    }

    @Test
    @TestOrder(40)
    public void noResult1(){

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosBySyorizumiflg(
            C_Syorizumiflg.MISYORI);

        Assert.assertEquals(0, hrkmNyknSakujyoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosBySyorizumiflg(
            C_Syorizumiflg.MISYORI);
        Assert.assertEquals(1, hrkmNyknSakujyoLst.size());

        Assert.assertEquals(C_Syorizumiflg.MISYORI, hrkmNyknSakujyoLst.get(0).getSyorizumiflg());
        Assert.assertEquals("100000000", hrkmNyknSakujyoLst.get(0).getHrkmdeldataskbtkey());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_Syorizumiflg.SYORIZUMI,"200000000"), "1");
        datamap.put($(C_Syorizumiflg.SYORIZUMI,"300000000"), "1");
        datamap.put($(C_Syorizumiflg.SYORIZUMI,"400000000"), "1");

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst = sinkeiyakuDomManager.getHrkmNyknSakujyosBySyorizumiflg(
            C_Syorizumiflg.SYORIZUMI);

        for(HT_HrkmNyknSakujyo hrkmNyknSakujyo:hrkmNyknSakujyoLst){
            datamap.remove($(
                hrkmNyknSakujyo.getSyorizumiflg(),
                hrkmNyknSakujyo.getHrkmdeldataskbtkey()));
        }


        Assert.assertEquals(3, hrkmNyknSakujyoLst.size());

        Assert.assertTrue(datamap.isEmpty());

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknSakujyo());
        HT_HrkmNyknSakujyo hrkmNyknSakujyo2 = new HT_HrkmNyknSakujyo();
        hrkmNyknSakujyo2.setHrkmdeldataskbtkey("200000000");
        hrkmNyknSakujyo2.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
        sinkeiyakuDomManager.insert(hrkmNyknSakujyo2);
    }
}
