package yuyu.batch.biz.kaikei.bzsinkeiyakuhurikaedentblsks;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzkaikei.bzsinkeiyakuhurikaedentblsks.BzSinkeiyakuHurikaeDenTblSksDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 新契約振替伝票テーブル作成処理<br />
 * deleteSinkeiyakuHurikaeDensBySyoriYmd() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSinkeiyakuHurikaeDenTblSksDaoTest_deleteSinkeiyakuHurikaeDensBySyoriYmd {

    @Inject
    private BzSinkeiyakuHurikaeDenTblSksDao bzSinkeiyakuHurikaeDenTblSksDao;
    @Inject
    private BizDomManager bizDomManager;

    public static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160306");
    public static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160307");
    public static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160308");
    public static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160309");
    public static BizDate P_SYORIYMD_05 = BizDate.valueOf("20160401");
    public static String P_DENRENNO_01 = "100";
    public static Integer P_EDANO_01 = new Integer(1);
    public static Integer P_EDANO_02 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BzSinkeiyakuHurikaeDenTblSksDao bzSinkeiyakuHurikaeDenTblSksDao = SWAKInjector.getInstance(BzSinkeiyakuHurikaeDenTblSksDao.class);

        assertEquals(0, bzSinkeiyakuHurikaeDenTblSksDao.deleteSinkeiyakuHurikaeDensBySyoriYmd(P_SYORIYMD_03));
        assertEquals(0, bizDomManager.getAllSinkeiyakuHurikaeDen().size());

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen1 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.BLNK, P_DENRENNO_01, P_EDANO_01);
        sinkeiyakuHurikaeDen1.setSyoriYmd(P_SYORIYMD_01);
        bizDomManager.insert(sinkeiyakuHurikaeDen1);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen2 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.BLNK, P_DENRENNO_01, P_EDANO_02);
        sinkeiyakuHurikaeDen2.setSyoriYmd(P_SYORIYMD_02);
        bizDomManager.insert(sinkeiyakuHurikaeDen2);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen3 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.HOZEN, P_DENRENNO_01, P_EDANO_01);
        sinkeiyakuHurikaeDen3.setSyoriYmd(P_SYORIYMD_03);
        bizDomManager.insert(sinkeiyakuHurikaeDen3);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen4 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.NENKIN, P_DENRENNO_01, P_EDANO_01);
        sinkeiyakuHurikaeDen4.setSyoriYmd(P_SYORIYMD_04);
        bizDomManager.insert(sinkeiyakuHurikaeDen4);

        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen5 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.NENKIN, P_DENRENNO_01, P_EDANO_02);
        sinkeiyakuHurikaeDen5.setSyoriYmd(P_SYORIYMD_05);
        bizDomManager.insert(sinkeiyakuHurikaeDen5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSinkeiyakuHurikaeDen());
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        assertEquals(5, bizDomManager.getAllSinkeiyakuHurikaeDen().size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(2, bzSinkeiyakuHurikaeDenTblSksDao.deleteSinkeiyakuHurikaeDensBySyoriYmd(P_SYORIYMD_03));
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        assertEquals(3, bizDomManager.getAllSinkeiyakuHurikaeDen().size());
    }
}