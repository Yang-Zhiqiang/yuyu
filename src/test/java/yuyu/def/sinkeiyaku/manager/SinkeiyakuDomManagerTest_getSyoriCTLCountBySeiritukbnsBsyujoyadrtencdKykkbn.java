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
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 処理コントロールテーブルの件数取得　成立区分成立不成立以外かつ募集時親代理店コード指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_BSYUJOYADRTENCD_01 = "1111111";
    static String P_BSYUJOYADRTENCD_02 = "3333333";
    static String P_KEIYAKUSYANM_01 = "アイウ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(P_BSYUJOYADRTENCD_01, P_KEIYAKUSYANM_01);

        Assert.assertEquals(0L, counts);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon1.setHhknnmkn("アイ");
        mosKihon1.setKyknmkn("アイウ");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(2);
        mosDairiten1.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon2.setHhknnmkn("アイ");
        mosKihon2.setKyknmkn("アイウ");

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);
        mosDairiten2.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon3.setHhknnmkn("アイウ");
        mosKihon3.setKyknmkn("アイ");

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);
        mosDairiten3.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon4.setHhknnmkn("アイウ");
        mosKihon4.setKyknmkn("アイ");

        HT_MosDairiten mosDairiten4 = syoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);
        mosDairiten4.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setKykkbn(C_KykKbn.KEIHI_BETU);
        mosKihon5.setHhknnmkn("アイ");
        mosKihon5.setKyknmkn("アイウ");

        HT_MosDairiten mosDairiten5 = syoriCTL5.createMosDairiten();
        mosDairiten5.setRenno(1);
        mosDairiten5.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setKykkbn(C_KykKbn.BLNK);
        mosKihon6.setHhknnmkn("アイウ");
        mosKihon6.setKyknmkn("アイウ");

        HT_MosDairiten mosDairiten6 = syoriCTL6.createMosDairiten();
        mosDairiten6.setRenno(1);
        mosDairiten6.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon7.setHhknnmkn("アイウ");
        mosKihon7.setKyknmkn("アイ");

        HT_MosDairiten mosDairiten7 = syoriCTL7.createMosDairiten();
        mosDairiten7.setRenno(1);
        mosDairiten7.setBsyujoyadrtencd("2222222");

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon8 = syoriCTL8.createMosKihon();
        mosKihon8.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon8.setHhknnmkn("アイ");
        mosKihon8.setKyknmkn("アイウ");

        HT_MosDairiten mosDairiten8 = syoriCTL8.createMosDairiten();
        mosDairiten8.setRenno(1);
        mosDairiten8.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("791112303");
        syoriCTL9.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon9 = syoriCTL9.createMosKihon();
        mosKihon9.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        mosKihon9.setHhknnmkn("アイウ");
        mosKihon9.setKyknmkn("アイ");

        HT_MosDairiten mosDairiten9 = syoriCTL9.createMosDairiten();
        mosDairiten9.setRenno(1);
        mosDairiten9.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL9);

        HT_SyoriCTL syoriCTL10 = new HT_SyoriCTL("791112311");
        syoriCTL10.setSeiritukbn(C_SeirituKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL10);
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

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(P_BSYUJOYADRTENCD_02, P_KEIYAKUSYANM_01);

        Assert.assertEquals(0L, counts);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(P_BSYUJOYADRTENCD_01, P_KEIYAKUSYANM_01);

        Assert.assertEquals(2L, counts);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn("", P_KEIYAKUSYANM_01);

        Assert.assertEquals(0L, counts);
    }

    @Test
    @TestOrder(40)
    public void blankCondition2() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(P_BSYUJOYADRTENCD_01, "");

        Assert.assertEquals(0L, counts);
    }
}
