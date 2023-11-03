package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 処理コントロールテーブルの件数取得　成立区分成立不成立以外のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLCountBySeiritukbnsKykkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_HHKNNMKN_01 = "ブンシュウ";
    static String P_HHKNNMKN_02 = "ショブンシュウ";
    static String P_KYKNMKN_01= "ブンシュウ";
    static String P_KYKNMKN_02 = "ショブンシュウ";
    static String P_KEIYAKUSYANM_01 = "ショブンシュウ";
    static String P_KEIYAKUSYANM_02 = "シュウ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsKykkbn(P_KEIYAKUSYANM_01);

        Assert.assertEquals(0L, counts);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon1.setHhknnmkn(P_HHKNNMKN_01);
        mosKihon1.setKyknmkn(P_KYKNMKN_02);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon2.setHhknnmkn(P_HHKNNMKN_02);
        mosKihon2.setKyknmkn(P_KYKNMKN_01);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon3.setHhknnmkn(P_HHKNNMKN_02);
        mosKihon3.setKyknmkn(P_KYKNMKN_01);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon4.setHhknnmkn(P_HHKNNMKN_02);
        mosKihon4.setKyknmkn(P_KYKNMKN_01);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon5.setHhknnmkn(P_HHKNNMKN_01);
        mosKihon5.setKyknmkn(P_KYKNMKN_01);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon6.setHhknnmkn(P_HHKNNMKN_01);
        mosKihon6.setKyknmkn(P_KYKNMKN_01);

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setKykkbn(C_KykKbn.BLNK);
        mosKihon7.setHhknnmkn(P_HHKNNMKN_02);
        mosKihon7.setKyknmkn(P_KYKNMKN_02);

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setSeiritukbn(C_SeirituKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL8);
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

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsKykkbn(P_KEIYAKUSYANM_02);

        Assert.assertEquals(0L, counts);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsKykkbn(P_KEIYAKUSYANM_01);

        Assert.assertEquals(2L, counts);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsKykkbn("");

        Assert.assertEquals(0L, counts);
    }
}
