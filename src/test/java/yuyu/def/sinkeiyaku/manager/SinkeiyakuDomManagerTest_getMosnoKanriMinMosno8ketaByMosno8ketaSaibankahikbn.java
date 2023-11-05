package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.testinfr.TestOrder;

/**
 * 申込番号管理テーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class SinkeiyakuDomManagerTest_getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;


    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosno8keta = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn("10000010", "10000020", C_KahiKbn.KA);
        Assert.assertEquals(mosno8keta, null);

        HT_MosnoKanri mosnoKanri1 = new  HT_MosnoKanri();
        mosnoKanri1.setMosno8keta("10000010");
        mosnoKanri1.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri1.setSaibanymd(BizDate.valueOf(20150610));
        sinkeiyakuDomManager.insert(mosnoKanri1);

        HT_MosnoKanri mosnoKanri2 = new  HT_MosnoKanri();
        mosnoKanri2.setMosno8keta("10000015");
        mosnoKanri2.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri2.setSaibanymd(BizDate.valueOf(20150615));
        sinkeiyakuDomManager.insert(mosnoKanri2);

        HT_MosnoKanri mosnoKanri3 = new  HT_MosnoKanri();
        mosnoKanri3.setMosno8keta("10000020");
        mosnoKanri3.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri3.setSaibanymd(BizDate.valueOf(20150620));
        sinkeiyakuDomManager.insert(mosnoKanri3);

        HT_MosnoKanri mosnoKanri4 = new  HT_MosnoKanri();
        mosnoKanri4.setMosno8keta("10000009");
        mosnoKanri4.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri4.setSaibanymd(BizDate.valueOf(20150609));
        sinkeiyakuDomManager.insert(mosnoKanri4);

        HT_MosnoKanri mosnoKanri5 = new  HT_MosnoKanri();
        mosnoKanri5.setMosno8keta("10000021");
        mosnoKanri5.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri5.setSaibanymd(BizDate.valueOf(20150621));
        sinkeiyakuDomManager.insert(mosnoKanri5);

        HT_MosnoKanri mosnoKanri6 = new  HT_MosnoKanri();
        mosnoKanri6.setMosno8keta("10000011");
        mosnoKanri6.setSaibankahikbn(C_KahiKbn.HUKA);
        mosnoKanri6.setSaibanymd(BizDate.valueOf(20150611));
        sinkeiyakuDomManager.insert(mosnoKanri6);

        HT_MosnoKanri mosnoKanri7 = new  HT_MosnoKanri();
        mosnoKanri7.setMosno8keta("10000012");
        mosnoKanri7.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri7.setSaibanymd(BizDate.valueOf(20150609));
        sinkeiyakuDomManager.insert(mosnoKanri7);

        HT_MosnoKanri mosnoKanri8 = new  HT_MosnoKanri();
        mosnoKanri8.setMosno8keta("10000013");
        mosnoKanri8.setSaibankahikbn(C_KahiKbn.KA);
        mosnoKanri8.setSaibanymd(BizDate.valueOf(20150613));
        sinkeiyakuDomManager.insert(mosnoKanri8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        String mosno8keta = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn("10000015", "10000020", C_KahiKbn.HUKA);
        Assert.assertEquals(mosno8keta, null);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        String mosno8keta = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn("10000010", "10000020", C_KahiKbn.KA);
        Assert.assertEquals(mosno8keta, "10000012");
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void blank1() {

        String mosno8keta = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn("", "10000020", C_KahiKbn.KA);
        Assert.assertEquals(mosno8keta, "10000009");

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void blank2() {

        String mosno8keta = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn("10000015", "", C_KahiKbn.KA);
        Assert.assertEquals(mosno8keta, null);

    }

}
