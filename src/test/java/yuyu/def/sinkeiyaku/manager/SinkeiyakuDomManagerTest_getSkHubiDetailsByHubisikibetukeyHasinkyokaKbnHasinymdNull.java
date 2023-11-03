package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 不備帳票ＰＤＦ作成<br />
 * 新契約不備詳細テーブルエンティティリスト取得（不備識別キー）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_HUBISIKIBETUKEY_01 = "HK0001";
    static String P_HUBISIKIBETUKEY_02 = "HK0002";
    static String P_HUBISIKIBETUKEY_03 = "HK0003";
    static Integer P_RENNO3KETA_01 = new Integer(1);
    static Integer P_RENNO3KETA_02 = new Integer(2);
    static Integer P_RENNO3KETA_03 = new Integer(3);

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(P_HUBISIKIBETUKEY_02);

        Assert.assertEquals(0, skHubiDetailList.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey(P_HUBISIKIBETUKEY_01);

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(P_RENNO3KETA_01);
        skHubiDetail1.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(P_RENNO3KETA_02);
        skHubiDetail2.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(P_RENNO3KETA_03);
        skHubiDetail3.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey(P_HUBISIKIBETUKEY_02);

        HT_SkHubiDetail skHubiDetail4 = skHubi2.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(P_RENNO3KETA_01);
        skHubiDetail4.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail5 = skHubi2.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(P_RENNO3KETA_02);
        skHubiDetail5.setHasinymd(BizDate.valueOf(20160317));
        skHubiDetail5.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail skHubiDetail6 = skHubi2.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(P_RENNO3KETA_03);
        skHubiDetail6.setHasinkyokakbn(C_HasinkyokaKbn.HORYUU);

        sinkeiyakuDomManager.insert(syoriCTL2);
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

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(P_HUBISIKIBETUKEY_03);

        Assert.assertEquals(0, skHubiDetailList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(P_HUBISIKIBETUKEY_02);

        Assert.assertEquals(1, skHubiDetailList.size());

        Assert.assertEquals(P_MOSNO_02, skHubiDetailList.get(0).getMosno());
        Assert.assertEquals(P_HUBISIKIBETUKEY_02, skHubiDetailList.get(0).getHubisikibetukey());
        Assert.assertEquals(P_RENNO3KETA_01, skHubiDetailList.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_MOSNO_01,P_HUBISIKIBETUKEY_01,P_RENNO3KETA_01), "1");
        datamap.put($(P_MOSNO_01,P_HUBISIKIBETUKEY_01,P_RENNO3KETA_02), "1");
        datamap.put($(P_MOSNO_01,P_HUBISIKIBETUKEY_01,P_RENNO3KETA_03), "1");

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(P_HUBISIKIBETUKEY_01);

        for(HT_SkHubiDetail skHubiDetail:skHubiDetailList){
            datamap.remove($(
                skHubiDetail.getMosno(),
                skHubiDetail.getHubisikibetukey(),
                skHubiDetail.getRenno3keta()));
        }

        Assert.assertEquals(3, skHubiDetailList.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SkHubiDetail> skHubiDetailList = sinkeiyakuDomManager.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull("");

        assertEquals(0, skHubiDetailList.size());
    }
}
