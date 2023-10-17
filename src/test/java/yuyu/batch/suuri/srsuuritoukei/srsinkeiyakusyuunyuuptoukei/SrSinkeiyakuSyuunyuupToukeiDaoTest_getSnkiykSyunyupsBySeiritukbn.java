package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約収入Ｐ統計情報作成<br />
 * 新契約収入Ｐ統計情報ビューエンティティリスト（大量）取得(成立区分)のテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getSnkiykSyunyupsBySeiritukbn {

    @Inject
    private SrSinkeiyakuSyuunyuupToukeiDao srSinkeiyakuSyuunyuupToukeiDao;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        SrSinkeiyakuSyuunyuupToukeiDao srSinkeiyakuSyuunyuupToukeiDao =
            SWAKInjector.getInstance(SrSinkeiyakuSyuunyuupToukeiDao.class);

        try (ExDBResults<SV_SnkiykSyunyup>  sV_SnkiykSyunyupDbResults =
            srSinkeiyakuSyuunyuupToukeiDao.getSnkiykSyunyupsBySeiritukbn(C_SeirituKbn.SEIRITU)) {

            Assert.assertFalse(sV_SnkiykSyunyupDbResults.iterator().hasNext());
        }

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("791112261");
        hT_SyoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        hT_SyoriCTL1.createMosKihon();
        HT_MosDairiten mosDairiten1 = hT_SyoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("791112352");
        hT_SyoriCTL2.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
        hT_SyoriCTL2.createMosKihon();
        HT_MosDairiten mosDairiten2 = hT_SyoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("791112253");
        hT_SyoriCTL3.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
        hT_SyoriCTL3.createMosKihon();
        HT_MosDairiten mosDairiten3 = hT_SyoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        HT_SyoriCTL hT_SyoriCTL4 = new HT_SyoriCTL("791112394");
        hT_SyoriCTL4.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
        hT_SyoriCTL4.createMosKihon();
        HT_MosDairiten mosDairiten4 = hT_SyoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL4);

        HT_SyoriCTL hT_SyoriCTL5 = new HT_SyoriCTL("791112295");
        hT_SyoriCTL5.setSeiritukbn(C_SeirituKbn.BLNK);
        hT_SyoriCTL5.createMosKihon();
        HT_MosDairiten mosDairiten5 = hT_SyoriCTL5.createMosDairiten();
        mosDairiten5.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL5);
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

        try (ExDBResults<SV_SnkiykSyunyup> sV_SnkiykSyunyupExDBResults =
            srSinkeiyakuSyuunyuupToukeiDao.getSnkiykSyunyupsBySeiritukbn(C_SeirituKbn.ITIPMATI)) {

            Assert.assertFalse(sV_SnkiykSyunyupExDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<SV_SnkiykSyunyup> sV_SnkiykSyunyupExDBResults =
            srSinkeiyakuSyuunyuupToukeiDao.getSnkiykSyunyupsBySeiritukbn(C_SeirituKbn.SEIRITU)) {

            int iCount = 0;
            Iterator<SV_SnkiykSyunyup> iter = sV_SnkiykSyunyupExDBResults.iterator();
            SV_SnkiykSyunyup sV_SnkiykSyunyup = null;
            while (iter.hasNext()) {

                sV_SnkiykSyunyup = iter.next();
                iCount++;

                Assert.assertEquals("791112261", sV_SnkiykSyunyup.getMosno());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, sV_SnkiykSyunyup.getSeiritukbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put($("791112352", C_SeirituKbn.HUSEIRITU),"1");
        resultMap.put($("791112253", C_SeirituKbn.HUSEIRITU),"1");
        resultMap.put($("791112394", C_SeirituKbn.HUSEIRITU),"1");

        try (ExDBResults<SV_SnkiykSyunyup> sV_SnkiykSyunyupExDBResults =
            srSinkeiyakuSyuunyuupToukeiDao.getSnkiykSyunyupsBySeiritukbn(C_SeirituKbn.HUSEIRITU)) {

            int iCount = 0;
            Iterator<SV_SnkiykSyunyup> iter = sV_SnkiykSyunyupExDBResults.iterator();
            SV_SnkiykSyunyup sV_SnkiykSyunyup = null;
            while (iter.hasNext()) {

                sV_SnkiykSyunyup = iter.next();
                iCount ++ ;
                resultMap.remove($(sV_SnkiykSyunyup.getMosno(),sV_SnkiykSyunyup.getSeiritukbn()));
            }
            assertEquals(3, iCount);
            assertTrue(resultMap.isEmpty());
        }
    }
}
