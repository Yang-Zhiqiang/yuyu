package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiDetailsByMosnoKaisyouymdNull() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailsByMosnoKaisyouymdNull {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<C_SyoruiCdKbn> stringLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull("791112220");

        Assert.assertEquals(0,stringLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("2015201602151001");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(112);
        skHubiDetail2.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(113);
        skHubiDetail3.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        HT_SkHubiDetail skHubiDetail6 = skHubi1.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(114);
        skHubiDetail6.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        skHubiDetail6.setKaisyouymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("2015201602151001");

        HT_SkHubiDetail skHubiDetail4 = skHubi2.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(111);
        skHubiDetail4.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_SkHubi skHubi3 = syoriCTL3.createSkHubi();
        skHubi3.setHubisikibetukey("2015201602151001");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");

        HT_SkHubi skHubi4 = syoriCTL4.createSkHubi();
        skHubi4.setHubisikibetukey("2015201602151001");

        HT_SkHubiDetail skHubiDetail5 = skHubi4.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(111);
        skHubiDetail5.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        HT_SkHubi skHubi5 = syoriCTL4.createSkHubi();
        skHubi5.setHubisikibetukey("2015201602151002");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");

        HT_SkHubi skHubi6 = syoriCTL5.createSkHubi();
        skHubi6.setHubisikibetukey("2015201602151001");

        HT_SkHubiDetail skHubiDetail7 = skHubi6.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(111);
        skHubiDetail7.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        HT_SkHubiDetail skHubiDetail8 = skHubi6.createSkHubiDetail();
        skHubiDetail8.setRenno3keta(112);
        skHubiDetail8.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);

        HT_SkHubiDetail skHubiDetail9 = skHubi6.createSkHubiDetail();
        skHubiDetail9.setRenno3keta(113);
        skHubiDetail9.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        sinkeiyakuDomManager.insert(syoriCTL5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<C_SyoruiCdKbn> stringLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull("791112246");

        Assert.assertEquals(0, stringLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<C_SyoruiCdKbn> stringLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull("791112220");

        Assert.assertEquals(1, stringLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, stringLst.get(0));

    }

    @Test
    @TestOrder(40)
    public void normal2(){

        List<C_SyoruiCdKbn> stringLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull("791112261");

        Assert.assertEquals(3, stringLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_HOKEN_SKS, stringLst.get(0));

        Assert.assertEquals(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, stringLst.get(1));

        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_DAIHYOU, stringLst.get(2));

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<C_SyoruiCdKbn> stringLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull("");

        assertEquals(0, stringLst.size());

    }
}
