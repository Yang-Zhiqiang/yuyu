package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 項目訂正履歴テーブルエンティティから、<br />
 * 申込番号を指定して、<br />
 * 項目訂正履歴テーブル（DISTINCT　処理時間）の件数を取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKmTsRirekiDistinctSyoriTimeCountByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112295";
    static String P_SYORITIME_01 = "20160418";
    static String P_SYORITIME_02 = "20160419";
    static String P_SYORITIME_03 = "20160420";
    static String P_SYORITIME_04 = "20160421";
    static Integer P_RENNO3KETA_01 = 111;
    static Integer P_RENNO3KETA_02 = 222;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(P_MOSNO_01);
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_KmTsRireki kmTsRireki1 = syoriCTL1.createKmTsRireki();
        kmTsRireki1.setSyoriTime(P_SYORITIME_01);
        kmTsRireki1.setRenno3keta(P_RENNO3KETA_01);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_KmTsRireki kmTsRireki2 = syoriCTL2.createKmTsRireki();
        kmTsRireki2.setSyoriTime(P_SYORITIME_02);
        kmTsRireki2.setRenno3keta(P_RENNO3KETA_01);

        HT_KmTsRireki kmTsRireki3 = syoriCTL2.createKmTsRireki();
        kmTsRireki3.setSyoriTime(P_SYORITIME_02);
        kmTsRireki3.setRenno3keta(P_RENNO3KETA_02);

        HT_KmTsRireki kmTsRireki4 = syoriCTL2.createKmTsRireki();
        kmTsRireki4.setSyoriTime(P_SYORITIME_03);
        kmTsRireki4.setRenno3keta(P_RENNO3KETA_02);

        HT_KmTsRireki kmTsRireki5 = syoriCTL2.createKmTsRireki();
        kmTsRireki5.setSyoriTime(P_SYORITIME_04);
        kmTsRireki5.setRenno3keta(P_RENNO3KETA_02);

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

        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(P_MOSNO_03);

        Assert.assertEquals(new Long(0), count);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(P_MOSNO_01);

        Assert.assertEquals(new Long(1), count);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno(P_MOSNO_02);

        Assert.assertEquals(new Long(3), count);
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getKmTsRirekiDistinctSyoriTimeCountByMosno("");

        Assert.assertEquals(new Long(0), count);
    }
}
