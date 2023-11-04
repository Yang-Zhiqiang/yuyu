package yuyu.def.db.entity;

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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 新契約不備テーブルエンティティリストを取得のテストクラス。<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getSkHubisByHasinymdNotNullKaisyouymdNull {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_1 = "791112220";
    static String P_MOSNO_2 = "791112238";
    static String P_MOSNO_3 = "791112246";
    static String P_HUBISIKIBETUKEY_1 = "HBKEY00001";
    static String P_HUBISIKIBETUKEY_2 = "HBKEY00002";
    static String P_HUBISIKIBETUKEY_3 = "HBKEY00003";
    static Integer P_RENNO3KETA_1 = new Integer(0);
    static Integer P_RENNO3KETA_2 = new Integer(1);
    static Integer P_RENNO3KETA_3 = new Integer(2);
    static BizDate P_HASINYMD_1 = BizDate.valueOf("20160101");
    static BizDate P_KAISYOUYMD_1 = BizDate.valueOf("20160102");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_1);

        HT_SkHubi hT_SkHubi11 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi11.setHubisikibetukey(P_HUBISIKIBETUKEY_1);

        HT_SkHubiDetail hT_SkHubiDetail111 = hT_SkHubi11.createSkHubiDetail();
        hT_SkHubiDetail111.setRenno3keta(P_RENNO3KETA_1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_2);

        List<HT_SkHubi> hT_SkHubiLst = hT_SyoriCTL2.getSkHubisByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(0, hT_SkHubiLst.size());

        HT_SkHubi hT_SkHubi21 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi21.setHubisikibetukey(P_HUBISIKIBETUKEY_1);

        HT_SkHubiDetail hT_SkHubiDetail211 = hT_SkHubi21.createSkHubiDetail();
        hT_SkHubiDetail211.setRenno3keta(P_RENNO3KETA_1);
        hT_SkHubiDetail211.setHasinymd(P_HASINYMD_1);

        HT_SkHubiDetail hT_SkHubiDetail212 = hT_SkHubi21.createSkHubiDetail();
        hT_SkHubiDetail212.setRenno3keta(P_RENNO3KETA_2);
        hT_SkHubiDetail212.setHasinymd(P_HASINYMD_1);
        hT_SkHubiDetail212.setKaisyouymd(P_KAISYOUYMD_1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(P_MOSNO_3);

        HT_SkHubi hT_SkHubi31 = hT_SyoriCTL3.createSkHubi();
        hT_SkHubi31.setHubisikibetukey(P_HUBISIKIBETUKEY_1);

        HT_SkHubiDetail hT_SkHubiDetail311 = hT_SkHubi31.createSkHubiDetail();
        hT_SkHubiDetail311.setRenno3keta(P_RENNO3KETA_1);
        hT_SkHubiDetail311.setHasinymd(P_HASINYMD_1);

        HT_SkHubi hT_SkHubi32 = hT_SyoriCTL3.createSkHubi();
        hT_SkHubi32.setHubisikibetukey(P_HUBISIKIBETUKEY_2);

        HT_SkHubiDetail hT_SkHubiDetail321 = hT_SkHubi32.createSkHubiDetail();
        hT_SkHubiDetail321.setRenno3keta(P_RENNO3KETA_2);
        hT_SkHubiDetail321.setHasinymd(P_HASINYMD_1);

        HT_SkHubi hT_SkHubi33 = hT_SyoriCTL3.createSkHubi();
        hT_SkHubi33.setHubisikibetukey(P_HUBISIKIBETUKEY_3);

        HT_SkHubiDetail hT_SkHubiDetail331 = hT_SkHubi33.createSkHubiDetail();
        hT_SkHubiDetail331.setRenno3keta(P_RENNO3KETA_3);
        hT_SkHubiDetail331.setHasinymd(P_HASINYMD_1);

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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);

        List<HT_SkHubi> hT_SkHubiLst = hT_SyoriCTL.getSkHubisByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(0, hT_SkHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_2);

        List<HT_SkHubi> hT_SkHubiLst = hT_SyoriCTL.getSkHubisByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(1, hT_SkHubiLst.size());

        Assert.assertEquals(P_MOSNO_2, hT_SkHubiLst.get(0).getMosno());
        Assert.assertEquals(P_HUBISIKIBETUKEY_1, hT_SkHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_1, hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getHasinymd());
        Assert.assertNull(hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getKaisyouymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_3);

        List<HT_SkHubi> hT_SkHubiLst = hT_SyoriCTL.getSkHubisByHasinymdNotNullKaisyouymdNull();

        Assert.assertEquals(3, hT_SkHubiLst.size());

        Assert.assertEquals(P_MOSNO_3, hT_SkHubiLst.get(0).getMosno());
        Assert.assertEquals(P_HUBISIKIBETUKEY_1, hT_SkHubiLst.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_1, hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getHasinymd());
        Assert.assertNull(hT_SkHubiLst.get(0).getSkHubiDetails().get(0).getKaisyouymd());

        Assert.assertEquals(P_MOSNO_3, hT_SkHubiLst.get(1).getMosno());
        Assert.assertEquals(P_HUBISIKIBETUKEY_2, hT_SkHubiLst.get(1).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_2, hT_SkHubiLst.get(1).getSkHubiDetails().get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, hT_SkHubiLst.get(1).getSkHubiDetails().get(0).getHasinymd());
        Assert.assertNull(hT_SkHubiLst.get(1).getSkHubiDetails().get(0).getKaisyouymd());

        Assert.assertEquals(P_MOSNO_3, hT_SkHubiLst.get(2).getMosno());
        Assert.assertEquals(P_HUBISIKIBETUKEY_3, hT_SkHubiLst.get(2).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_3, hT_SkHubiLst.get(2).getSkHubiDetails().get(0).getRenno3keta());
        Assert.assertEquals(P_HASINYMD_1, hT_SkHubiLst.get(2).getSkHubiDetails().get(0).getHasinymd());
        Assert.assertNull(hT_SkHubiLst.get(2).getSkHubiDetails().get(0).getKaisyouymd());
    }
}
