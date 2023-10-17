package yuyu.batch.biz.kaikei.bzhurikaedentblsks;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.kaikei.bzhurikaedentblsks.BzHurikaeDenTblSksDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 振替伝票テーブル作成処理<br />
 * deleteHuriDenpyousBySyoriYmd()メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzHurikaeDenTblSksDaoTest_deleteHuriDenpyousBySyoriYmd {

    @Inject
    private BzHurikaeDenTblSksDao bzHurikaeDenTblSksDao;
    @Inject
    private BizDomManager bizDomManager;

    public static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160306");
    public static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160307");
    public static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160308");
    public static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160309");
    public static BizDate P_SYORIYMD_05 = BizDate.valueOf("20160401");
    public static String P_DENRENNO_01 = "100";
    public static Integer P_EDANO_01 = new Integer(1);

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BzHurikaeDenTblSksDao bzHurikaeDenTblSksDao = SWAKInjector.getInstance(BzHurikaeDenTblSksDao.class);

        assertEquals(0, bzHurikaeDenTblSksDao.deleteHuriDenpyousBySyoriYmd(P_SYORIYMD_03));
        assertEquals(0, bizDomManager.getAllHuriDenpyou().size());

        BT_HuriDenpyou huriDenpyou1 = new BT_HuriDenpyou(C_DensysKbn.BLNK, P_DENRENNO_01, P_EDANO_01);
        huriDenpyou1.setSyoriYmd(P_SYORIYMD_01);
        bizDomManager.insert(huriDenpyou1);

        BT_HuriDenpyou huriDenpyou2 = new BT_HuriDenpyou(C_DensysKbn.SKEI, P_DENRENNO_01, P_EDANO_01);
        huriDenpyou2.setSyoriYmd(P_SYORIYMD_02);
        bizDomManager.insert(huriDenpyou2);

        BT_HuriDenpyou huriDenpyou3 = new BT_HuriDenpyou(C_DensysKbn.HOZEN, P_DENRENNO_01, P_EDANO_01);
        huriDenpyou3.setSyoriYmd(P_SYORIYMD_03);
        bizDomManager.insert(huriDenpyou3);

        BT_HuriDenpyou huriDenpyou4 = new BT_HuriDenpyou(C_DensysKbn.HKSIHARAI, P_DENRENNO_01, P_EDANO_01);
        huriDenpyou4.setSyoriYmd(P_SYORIYMD_04);
        bizDomManager.insert(huriDenpyou4);

        BT_HuriDenpyou huriDenpyou5 = new BT_HuriDenpyou(C_DensysKbn.AGKANRI, P_DENRENNO_01, P_EDANO_01);
        huriDenpyou5.setSyoriYmd(P_SYORIYMD_05);
        bizDomManager.insert(huriDenpyou5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHuriDenpyou());
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        assertEquals(5, bizDomManager.getAllHuriDenpyou().size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(2, bzHurikaeDenTblSksDao.deleteHuriDenpyousBySyoriYmd(P_SYORIYMD_03));
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        assertEquals(3, bizDomManager.getAllHuriDenpyou().size());
    }
}