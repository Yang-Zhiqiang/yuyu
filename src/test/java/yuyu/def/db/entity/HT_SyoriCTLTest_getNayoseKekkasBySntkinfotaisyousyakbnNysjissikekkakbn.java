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

import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 成立情報作成<br />
 * 名寄せ結果テーブルエンティティリスト取得　選択情報対象者区分契約者のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        List<HT_NayoseKekka> entityLst = hT_SyoriCTL1.getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn();

        Assert.assertEquals(0, entityLst.size());

        HT_NayoseKekka hT_NayoseKekka11 = hT_SyoriCTL1.createNayoseKekka();
        hT_NayoseKekka11.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka11.setEdano(new Integer(11));
        hT_NayoseKekka11.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_NayoseKekka hT_NayoseKekka21 = hT_SyoriCTL2.createNayoseKekka();
        hT_NayoseKekka21.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka21.setEdano(new Integer(11));
        hT_NayoseKekka21.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

        HT_NayoseKekka hT_NayoseKekka22 = hT_SyoriCTL2.createNayoseKekka();
        hT_NayoseKekka22.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka22.setEdano(new Integer(12));
        hT_NayoseKekka22.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

        HT_NayoseKekka hT_NayoseKekka23 = hT_SyoriCTL2.createNayoseKekka();
        hT_NayoseKekka23.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka23.setEdano(new Integer(13));
        hT_NayoseKekka23.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

        HT_NayoseKekka hT_NayoseKekka24 = hT_SyoriCTL2.createNayoseKekka();
        hT_NayoseKekka24.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_NayoseKekka24.setEdano(new Integer(14));
        hT_NayoseKekka24.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);

        HT_NayoseKekka hT_NayoseKekka25 = hT_SyoriCTL2.createNayoseKekka();
        hT_NayoseKekka25.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_NayoseKekka25.setEdano(new Integer(15));
        hT_NayoseKekka25.setNysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUNONE);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(P_MOSNO_03);

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);
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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_03);

        List<HT_NayoseKekka> entityLst = hT_SyoriCTL.getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn();

        Assert.assertEquals(0, entityLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_01);

        List<HT_NayoseKekka> entityLst = hT_SyoriCTL.getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn();

        Assert.assertEquals(1, entityLst.size());

        Assert.assertEquals(P_MOSNO_01, entityLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, entityLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(new Integer(11), entityLst.get(0).getEdano());
        Assert.assertEquals(C_NayoseJissiKekkaKbn.DOUITUARI, entityLst.get(0).getNysjissikekkakbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_02);

        List<HT_NayoseKekka> entityLst = hT_SyoriCTL.getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn();

        Assert.assertEquals(3, entityLst.size());

        Assert.assertEquals(P_MOSNO_02, entityLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, entityLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(new Integer(11), entityLst.get(0).getEdano());
        Assert.assertEquals(C_NayoseJissiKekkaKbn.DOUITUARI, entityLst.get(0).getNysjissikekkakbn());

        Assert.assertEquals(P_MOSNO_02, entityLst.get(1).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, entityLst.get(1).getSntkinfotaisyousyakbn());
        Assert.assertEquals(new Integer(12), entityLst.get(1).getEdano());
        Assert.assertEquals(C_NayoseJissiKekkaKbn.DOUITUARI, entityLst.get(1).getNysjissikekkakbn());

        Assert.assertEquals(P_MOSNO_02, entityLst.get(2).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, entityLst.get(2).getSntkinfotaisyousyakbn());
        Assert.assertEquals(new Integer(13), entityLst.get(2).getEdano());
        Assert.assertEquals(C_NayoseJissiKekkaKbn.DOUITUARI, entityLst.get(2).getNysjissikekkakbn());
    }
}
