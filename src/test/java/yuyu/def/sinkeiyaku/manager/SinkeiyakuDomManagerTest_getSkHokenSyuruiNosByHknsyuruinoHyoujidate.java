package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

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
 * getSkHokenSyuruiNosByHknsyuruinoHyoujidate() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHknsyuruinoHyoujidate {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, BizDate.valueOf(20160215));

        Assert.assertEquals(0,skHokenSyuruiNoLst.size());

        HM_SkHokenSyuruiNo skHokenSyuruiNo1 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 111);
        skHokenSyuruiNo1.setHyoujifromymd(BizDate.valueOf(20160215));
        skHokenSyuruiNo1.setHyoujitoymd(BizDate.valueOf(20160216));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo1);

        HM_SkHokenSyuruiNo skHokenSyuruiNo2 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("442"), 111);
        skHokenSyuruiNo2.setHyoujifromymd(BizDate.valueOf(20160215));
        skHokenSyuruiNo2.setHyoujitoymd(BizDate.valueOf(20160216));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo2);

        HM_SkHokenSyuruiNo skHokenSyuruiNo3 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 112);
        skHokenSyuruiNo3.setHyoujifromymd(BizDate.valueOf(20160216));
        skHokenSyuruiNo3.setHyoujitoymd(BizDate.valueOf(20160217));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo3);

        HM_SkHokenSyuruiNo skHokenSyuruiNo4 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 113);
        skHokenSyuruiNo4.setHyoujifromymd(BizDate.valueOf(20160213));
        skHokenSyuruiNo4.setHyoujitoymd(BizDate.valueOf(20160214));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo4);

        HM_SkHokenSyuruiNo skHokenSyuruiNo5 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("443"), 114);
        skHokenSyuruiNo5.setHyoujifromymd(BizDate.valueOf(20160315));
        skHokenSyuruiNo5.setHyoujitoymd(BizDate.valueOf(20160316));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo5);

        HM_SkHokenSyuruiNo skHokenSyuruiNo6 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("443"), 115);
        skHokenSyuruiNo6.setHyoujifromymd(BizDate.valueOf(20160314));
        skHokenSyuruiNo6.setHyoujitoymd(BizDate.valueOf(20160315));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo6);

        HM_SkHokenSyuruiNo skHokenSyuruiNo7 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("443"), 116);
        skHokenSyuruiNo7.setHyoujifromymd(BizDate.valueOf(20160314));
        skHokenSyuruiNo7.setHyoujitoymd(BizDate.valueOf(20160316));

        sinkeiyakuDomManager.insert(skHokenSyuruiNo7);
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
        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo.BLNK, BizDate.valueOf(20160215));

        Assert.assertEquals(0,skHokenSyuruiNoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, BizDate.valueOf(20160215));

        Assert.assertEquals(1,skHokenSyuruiNoLst.size());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        Assert.assertEquals(111, skHokenSyuruiNoLst.get(0).getHknsyuruinosd().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND,114), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND,115), "1");
        datamap.put($(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND,116), "1");

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, BizDate.valueOf(20160315));

        for(HM_SkHokenSyuruiNo skHokenSyuruiNo:skHokenSyuruiNoLst){
            datamap.remove($(
                skHokenSyuruiNo.getHknsyuruino(),
                skHokenSyuruiNo.getHknsyuruinosd().intValue()));
        }

        Assert.assertEquals(3,skHokenSyuruiNoLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}

