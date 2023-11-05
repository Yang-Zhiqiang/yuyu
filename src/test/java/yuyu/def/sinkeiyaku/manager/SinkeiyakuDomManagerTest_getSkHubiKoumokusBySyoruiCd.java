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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiKoumokusBySyoruiCd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiKoumokusBySyoruiCd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHubiKoumoku> skHubiKoumoku = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn.BLNK);

        Assert.assertEquals(0, skHubiKoumoku.size());

        HM_SkHubiKoumoku skHubiKoumoku1 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.BLNK, "1");
        skHubiKoumoku1.setHyoujikahikbn(C_KahiKbn.KA);

        sinkeiyakuDomManager.insert(skHubiKoumoku1);

        HM_SkHubiKoumoku skHubiKoumoku2 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_HYOUSI, "2");
        skHubiKoumoku2.setHyoujikahikbn(C_KahiKbn.KA);

        sinkeiyakuDomManager.insert(skHubiKoumoku2);

        HM_SkHubiKoumoku skHubiKoumoku3 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_HYOUSI, "3");
        skHubiKoumoku3.setHyoujikahikbn(C_KahiKbn.KA);

        sinkeiyakuDomManager.insert(skHubiKoumoku3);

        HM_SkHubiKoumoku skHubiKoumoku4 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_HYOUSI, "4");
        skHubiKoumoku4.setHyoujikahikbn(C_KahiKbn.KA);

        sinkeiyakuDomManager.insert(skHubiKoumoku4);

        HM_SkHubiKoumoku skHubiKoumoku5 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_HYOUSI, "5");
        skHubiKoumoku5.setHyoujikahikbn(C_KahiKbn.HUKA);

        sinkeiyakuDomManager.insert(skHubiKoumoku5);

        HM_SkHubiKoumoku skHubiKoumoku6 = new HM_SkHubiKoumoku(C_SyoruiCdKbn.WF_QRSEAL, "6");
        skHubiKoumoku6.setHyoujikahikbn(C_KahiKbn.KA);

        sinkeiyakuDomManager.insert(skHubiKoumoku6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHubiKoumoku());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_SkHubiKoumoku> skHubiKoumoku = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);

        assertEquals(0, skHubiKoumoku.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_SkHubiKoumoku> skHubiKoumoku = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn.BLNK);

        assertEquals(1, skHubiKoumoku.size());

        assertEquals(C_SyoruiCdKbn.BLNK, skHubiKoumoku.get(0).getSyoruiCd());
        assertEquals("1", skHubiKoumoku.get(0).getSkhubikoumokucd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_SyoruiCdKbn.WF_HYOUSI,"2"), "1");
        datamap.put($(C_SyoruiCdKbn.WF_HYOUSI,"3"), "1");
        datamap.put($(C_SyoruiCdKbn.WF_HYOUSI,"4"), "1");

        List<HM_SkHubiKoumoku> skHubiKoumokuLst = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        for(HM_SkHubiKoumoku skHubiKoumoku:skHubiKoumokuLst){
            datamap.remove($(
                skHubiKoumoku.getSyoruiCd(),
                skHubiKoumoku.getSkhubikoumokucd()));
        }

        assertEquals(3, skHubiKoumokuLst.size());
        Assert.assertTrue(datamap.isEmpty());;
    }
}
