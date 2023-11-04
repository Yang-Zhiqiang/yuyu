package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 名寄せ結果テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNayoseKekkasBySntkinfotaisyousyakbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL1.getNayoseKekkasBySntkinfotaisyousyakbn();
        Assert.assertEquals(0, nayoseKekkaLst.size());

        HT_NayoseKekka nayoseKekka1 = syoriCTL1.createNayoseKekka();
        nayoseKekka1.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka1.setEdano(11);

        HT_NayoseKekka nayoseKekka2 = syoriCTL1.createNayoseKekka();
        nayoseKekka2.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        nayoseKekka2.setEdano(11);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112246");

        HT_NayoseKekka nayoseKekka3 = syoriCTL2.createNayoseKekka();
        nayoseKekka3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka3.setEdano(22);

        HT_NayoseKekka nayoseKekka4 = syoriCTL2.createNayoseKekka();
        nayoseKekka4.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka4.setEdano(23);

        HT_NayoseKekka nayoseKekka5 = syoriCTL2.createNayoseKekka();
        nayoseKekka5.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        nayoseKekka5.setEdano(24);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112253");

        sinkeiyakuDomManager.insert(syoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112253");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL1.getNayoseKekkasBySntkinfotaisyousyakbn();
        Assert.assertEquals(0, nayoseKekkaLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL1.getNayoseKekkasBySntkinfotaisyousyakbn();
        Assert.assertEquals(1, nayoseKekkaLst.size());

        Assert.assertEquals("791112220", nayoseKekkaLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(11, nayoseKekkaLst.get(0).getEdano().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL1.getNayoseKekkasBySntkinfotaisyousyakbn();
        Assert.assertEquals(3, nayoseKekkaLst.size());

        Assert.assertEquals("791112246", nayoseKekkaLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(22, nayoseKekkaLst.get(0).getEdano().intValue());

        Assert.assertEquals("791112246", nayoseKekkaLst.get(1).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn());
        Assert.assertEquals(23, nayoseKekkaLst.get(1).getEdano().intValue());

        Assert.assertEquals("791112246", nayoseKekkaLst.get(2).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn());
        Assert.assertEquals(24, nayoseKekkaLst.get(2).getEdano().intValue());

    }
}
