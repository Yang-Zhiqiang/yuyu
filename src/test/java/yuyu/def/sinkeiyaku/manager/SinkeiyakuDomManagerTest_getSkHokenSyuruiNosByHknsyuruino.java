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

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHokenSyuruiNosByHknsyuruino() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHknsyuruino {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo.BLNK);

        Assert.assertEquals(0,skHokenSyuruiNoLst.size());

        HM_SkHokenSyuruiNo skHokenSyuruiNo1 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.BLNK, 111);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo1);

        HM_SkHokenSyuruiNo skHokenSyuruiNo2 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 111);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo2);

        HM_SkHokenSyuruiNo skHokenSyuruiNo3 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, 114);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo3);

        HM_SkHokenSyuruiNo skHokenSyuruiNo4 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, 112);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo4);

        HM_SkHokenSyuruiNo skHokenSyuruiNo5 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, 113);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND);

        Assert.assertEquals(0,skHokenSyuruiNoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo.BLNK);

        Assert.assertEquals(1,skHokenSyuruiNoLst.size());

        Assert.assertEquals(C_HknsyuruiNo.BLNK, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        Assert.assertEquals(111, skHokenSyuruiNoLst.get(0).getHknsyuruinosd().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,112), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,113), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,114), "1");

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT);

        for(HM_SkHokenSyuruiNo skHokenSyuruiNo:skHokenSyuruiNoLst){
            datamap.remove($(
                skHokenSyuruiNo.getHknsyuruino(),
                skHokenSyuruiNo.getHknsyuruinosd().intValue()));
        }

        Assert.assertEquals(3,skHokenSyuruiNoLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}

