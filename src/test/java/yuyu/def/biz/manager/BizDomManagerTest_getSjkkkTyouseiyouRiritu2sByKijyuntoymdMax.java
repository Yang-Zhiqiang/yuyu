package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax {

    @Inject
    private BizDomManager bizDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();
        Assert.assertEquals(0,sjkkkTyouseiyouRiritu.size());

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu2("ﾕｲ","005","000",BizDate.valueOf(20170301),BizDate.valueOf(20170309));
        sjkkkTyouseiyouRiritu1.setTuukasyu(C_Tuukasyu.JPY);

        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu2("ﾕｳ","010","000",BizDate.valueOf(20170301),BizDate.valueOf(20170310));
        sjkkkTyouseiyouRiritu2.setTuukasyu(C_Tuukasyu.JPY);

        bizDomManager.insert(sjkkkTyouseiyouRiritu2);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu2());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1(){

        List<BM_SjkkkTyouseiyouRiritu2> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();

        Assert.assertEquals(1,BM_SjkkkTyouseiyouRiritu.size());

        assertEquals("ﾕｳ", BM_SjkkkTyouseiyouRiritu.get(0).getSyouhncd());
        assertEquals("010", BM_SjkkkTyouseiyouRiritu.get(0).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(0).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170301), BM_SjkkkTyouseiyouRiritu.get(0).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170310), BM_SjkkkTyouseiyouRiritu.get(0).getKijyuntoymd());
        assertEquals(C_Tuukasyu.JPY, BM_SjkkkTyouseiyouRiritu.get(0).getTuukasyu());

        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu2());

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu2("ﾕｱ","050","000",BizDate.valueOf(20170316),BizDate.valueOf(20170330));
        sjkkkTyouseiyouRiritu1.setTuukasyu(C_Tuukasyu.JPY);
        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu2("ﾕｱ","050","000",BizDate.valueOf(20170316),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu2.setTuukasyu(C_Tuukasyu.JPY);
        bizDomManager.insert(sjkkkTyouseiyouRiritu2);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu3 = new BM_SjkkkTyouseiyouRiritu2("ﾕｲ","050","000",BizDate.valueOf(20170317),BizDate.valueOf(20170329));
        sjkkkTyouseiyouRiritu3.setTuukasyu(C_Tuukasyu.USD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu3);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu4 = new BM_SjkkkTyouseiyouRiritu2("ﾕｲ","050","000",BizDate.valueOf(20170317),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu4.setTuukasyu(C_Tuukasyu.USD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu4);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu5 = new BM_SjkkkTyouseiyouRiritu2("ﾕｳ","050","000",BizDate.valueOf(20170318),BizDate.valueOf(20170328));
        sjkkkTyouseiyouRiritu5.setTuukasyu(C_Tuukasyu.AUD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu5);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu6 = new BM_SjkkkTyouseiyouRiritu2("ﾕｳ","050","000",BizDate.valueOf(20170318),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu6.setTuukasyu(C_Tuukasyu.AUD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu6);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu7 = new BM_SjkkkTyouseiyouRiritu2("ﾕｴ","010","000",BizDate.valueOf(20170319),BizDate.valueOf(20170327));
        sjkkkTyouseiyouRiritu7.setTuukasyu(C_Tuukasyu.JPY);
        bizDomManager.insert(sjkkkTyouseiyouRiritu7);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu8 = new BM_SjkkkTyouseiyouRiritu2("ﾕｴ","010","000",BizDate.valueOf(20170319),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu8.setTuukasyu(C_Tuukasyu.JPY);
        bizDomManager.insert(sjkkkTyouseiyouRiritu8);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu9 = new BM_SjkkkTyouseiyouRiritu2("ﾕｵ","010","000",BizDate.valueOf(20170320),BizDate.valueOf(20170326));
        sjkkkTyouseiyouRiritu9.setTuukasyu(C_Tuukasyu.USD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu9);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu10 = new BM_SjkkkTyouseiyouRiritu2("ﾕｵ","010","000",BizDate.valueOf(20170320),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu10.setTuukasyu(C_Tuukasyu.USD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu10);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu11 = new BM_SjkkkTyouseiyouRiritu2("ﾕｶ","010","000",BizDate.valueOf(20170321),BizDate.valueOf(20170325));
        sjkkkTyouseiyouRiritu11.setTuukasyu(C_Tuukasyu.AUD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu11);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu12 = new BM_SjkkkTyouseiyouRiritu2("ﾕｶ","010","000",BizDate.valueOf(20170321),BizDate.valueOf(20170331));
        sjkkkTyouseiyouRiritu12.setTuukasyu(C_Tuukasyu.AUD);
        bizDomManager.insert(sjkkkTyouseiyouRiritu12);

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SjkkkTyouseiyouRiritu2> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();

        Assert.assertEquals(6,BM_SjkkkTyouseiyouRiritu.size());

        assertEquals("ﾕｱ", BM_SjkkkTyouseiyouRiritu.get(0).getSyouhncd());
        assertEquals("050", BM_SjkkkTyouseiyouRiritu.get(0).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(0).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170316), BM_SjkkkTyouseiyouRiritu.get(0).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(0).getKijyuntoymd());
        assertEquals(C_Tuukasyu.JPY, BM_SjkkkTyouseiyouRiritu.get(0).getTuukasyu());

        assertEquals("ﾕｲ", BM_SjkkkTyouseiyouRiritu.get(1).getSyouhncd());
        assertEquals("050", BM_SjkkkTyouseiyouRiritu.get(1).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(1).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170317), BM_SjkkkTyouseiyouRiritu.get(1).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(1).getKijyuntoymd());
        assertEquals(C_Tuukasyu.USD, BM_SjkkkTyouseiyouRiritu.get(1).getTuukasyu());

        assertEquals("ﾕｳ", BM_SjkkkTyouseiyouRiritu.get(2).getSyouhncd());
        assertEquals("050", BM_SjkkkTyouseiyouRiritu.get(2).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(2).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170318), BM_SjkkkTyouseiyouRiritu.get(2).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(2).getKijyuntoymd());
        assertEquals(C_Tuukasyu.AUD, BM_SjkkkTyouseiyouRiritu.get(2).getTuukasyu());

        assertEquals("ﾕｴ", BM_SjkkkTyouseiyouRiritu.get(3).getSyouhncd());
        assertEquals("010", BM_SjkkkTyouseiyouRiritu.get(3).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(3).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170319), BM_SjkkkTyouseiyouRiritu.get(3).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(3).getKijyuntoymd());
        assertEquals(C_Tuukasyu.JPY, BM_SjkkkTyouseiyouRiritu.get(3).getTuukasyu());

        assertEquals("ﾕｵ", BM_SjkkkTyouseiyouRiritu.get(4).getSyouhncd());
        assertEquals("010", BM_SjkkkTyouseiyouRiritu.get(4).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(4).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170320), BM_SjkkkTyouseiyouRiritu.get(4).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(4).getKijyuntoymd());
        assertEquals(C_Tuukasyu.USD, BM_SjkkkTyouseiyouRiritu.get(4).getTuukasyu());

        assertEquals("ﾕｶ", BM_SjkkkTyouseiyouRiritu.get(5).getSyouhncd());
        assertEquals("010", BM_SjkkkTyouseiyouRiritu.get(5).getSjkkktyouseiriritutkybr1());
        assertEquals("000", BM_SjkkkTyouseiyouRiritu.get(5).getSjkkktyouseiriritutkybr2());
        assertEquals(BizDate.valueOf(20170321), BM_SjkkkTyouseiyouRiritu.get(5).getKijyunfromymd());
        assertEquals(BizDate.valueOf(20170331), BM_SjkkkTyouseiyouRiritu.get(5).getKijyuntoymd());
        assertEquals(C_Tuukasyu.AUD, BM_SjkkkTyouseiyouRiritu.get(5).getTuukasyu());

    }
}
