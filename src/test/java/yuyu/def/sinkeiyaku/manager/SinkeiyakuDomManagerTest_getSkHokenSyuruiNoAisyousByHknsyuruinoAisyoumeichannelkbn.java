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

import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, C_AisyoumeiChannelKbn.MADOHAN);

        Assert.assertEquals(0,skHokenSyuruiNoAisyouLst.size());

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou1 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
            101, 201, "", C_AisyoumeiChannelKbn.MADOHAN);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou1);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou2 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.BLNK,
            101, 201, "", C_AisyoumeiChannelKbn.MADOHAN);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou2);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou3 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
            101, 201, "", C_AisyoumeiChannelKbn.BLNK);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou3);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou4 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,
            102, 202, "", C_AisyoumeiChannelKbn.SMBC);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou4);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou5 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,
            103, 203, "", C_AisyoumeiChannelKbn.SMBC);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou5);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou6 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,
            104, 204, "", C_AisyoumeiChannelKbn.SMBC);

        sinkeiyakuDomManager.insert(skHokenSyuruiNoAisyou6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNoAisyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo.BLNK, C_AisyoumeiChannelKbn.BLNK);

        assertEquals(0, skHokenSyuruiNoAisyouLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, C_AisyoumeiChannelKbn.MADOHAN);

        assertEquals(1, skHokenSyuruiNoAisyouLst.size());
        assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, skHokenSyuruiNoAisyouLst.get(0).getHknsyuruino());
        assertEquals(101,skHokenSyuruiNoAisyouLst.get(0).getHknsyuruinosdfrom().intValue());
        assertEquals(201,skHokenSyuruiNoAisyouLst.get(0).getHknsyuruinosdto().intValue());
        assertEquals(C_AisyoumeiChannelKbn.MADOHAN, skHokenSyuruiNoAisyouLst.get(0).getAisyoumeichannelkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,102,202,C_AisyoumeiChannelKbn.SMBC), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,103,203,C_AisyoumeiChannelKbn.SMBC), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT,104,204,C_AisyoumeiChannelKbn.SMBC), "1");

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, C_AisyoumeiChannelKbn.SMBC);

        for(HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou:skHokenSyuruiNoAisyouLst){
            datamap.remove($(
                skHokenSyuruiNoAisyou.getHknsyuruino(),
                skHokenSyuruiNoAisyou.getHknsyuruinosdfrom().intValue(),
                skHokenSyuruiNoAisyou.getHknsyuruinosdto().intValue(),
                skHokenSyuruiNoAisyou.getAisyoumeichannelkbn()
                ));
        }

        assertEquals(3, skHokenSyuruiNoAisyouLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
