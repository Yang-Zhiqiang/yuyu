package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 処理コントロールテーブルの件数取得　募集時親代理店コード指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_BSYUJOYADRTENCD_01 = "1111111";
    static String P_BSYUJOYADRTENCD_02 = "3333333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(P_BSYUJOYADRTENCD_01);

        Assert.assertEquals(0L, counts);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(2);
        mosDairiten1.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);
        mosDairiten2.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);
        mosDairiten3.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosDairiten mosDairiten4 = syoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);
        mosDairiten4.setBsyujoyadrtencd("2222222");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosDairiten mosDairiten5 = syoriCTL5.createMosDairiten();
        mosDairiten5.setRenno(1);
        mosDairiten5.setBsyujoyadrtencd("1111111");

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL6);
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

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(P_BSYUJOYADRTENCD_02);

        Assert.assertEquals(0L, counts);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(P_BSYUJOYADRTENCD_01);

        Assert.assertEquals(1L, counts);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        long counts = sinkeiyakuDomManager.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd("");

        Assert.assertEquals(0L, counts);
    }
}
