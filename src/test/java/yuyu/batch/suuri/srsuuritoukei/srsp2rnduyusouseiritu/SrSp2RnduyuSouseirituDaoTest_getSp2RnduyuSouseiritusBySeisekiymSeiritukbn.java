package yuyu.batch.suuri.srsuuritoukei.srsp2rnduyusouseiritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約収入Ｐ統計情報作成<br />
 * 新契約収入Ｐ統計情報ビューエンティティリスト（大量）取得(成立区分)のテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class SrSp2RnduyuSouseirituDaoTest_getSp2RnduyuSouseiritusBySeisekiymSeiritukbn {

    @Inject
    private SrSp2RnduyuSouseirituDao srSp2RnduyuSouseirituDao;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        SrSp2RnduyuSouseirituDao srSp2RnduyuSouseirituDao =
            SWAKInjector.getInstance(SrSp2RnduyuSouseirituDao.class);

        try (ExDBResults<SV_Sp2RnduyuSouseiritu> sV_Sp2RnduyuSouseirituDbResults =
            srSp2RnduyuSouseirituDao.getSp2RnduyuSouseiritusBySeisekiymSeiritukbn(BizDateYM.valueOf(201608),C_SeirituKbn.SEIRITU)) {

            Assert.assertFalse(sV_Sp2RnduyuSouseirituDbResults.iterator().hasNext());
        }


        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSeisekiym(BizDateYM.valueOf(201608));

        HT_KykKak kykKak1 = syoriCTL1.createKykKak();
        kykKak1.setRenno(1);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.valueOf("0"));

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setSeisekiym(BizDateYM.valueOf(201608));

        HT_KykKak kykKak2 = syoriCTL2.createKykKak();
        kykKak2.setRenno(2);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setSeisekiym(BizDateYM.valueOf(201609));

        HT_KykKak kykKak3 = syoriCTL3.createKykKak();
        kykKak3.setRenno(3);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.valueOf("2"));

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setSeisekiym(BizDateYM.valueOf(201607));

        HT_KykKak kykKak4 = syoriCTL4.createKykKak();
        kykKak4.setRenno(4);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.valueOf("2"));

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setSeisekiym(BizDateYM.valueOf(201607));

        HT_KykKak kykKak5 = syoriCTL5.createKykKak();
        kykKak5.setRenno(5);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.valueOf("2"));

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setSeisekiym(BizDateYM.valueOf(201607));

        HT_KykKak kykKak6 = syoriCTL6.createKykKak();
        kykKak6.setRenno(6);

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

        try (ExDBResults<SV_Sp2RnduyuSouseiritu> sV_Sp2RnduyuSouseirituDbResults =
            srSp2RnduyuSouseirituDao.getSp2RnduyuSouseiritusBySeisekiymSeiritukbn(BizDateYM.valueOf(201610),C_SeirituKbn.NONE)) {

            Assert.assertFalse(sV_Sp2RnduyuSouseirituDbResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<SV_Sp2RnduyuSouseiritu> sV_Sp2RnduyuSouseirituDbResults =
            srSp2RnduyuSouseirituDao.getSp2RnduyuSouseiritusBySeisekiymSeiritukbn(BizDateYM.valueOf(201608),C_SeirituKbn.SEIRITU)) {

            int iCount = 0;
            Iterator<SV_Sp2RnduyuSouseiritu> iter = sV_Sp2RnduyuSouseirituDbResults.iterator();
            SV_Sp2RnduyuSouseiritu sV_Sp2RnduyuSouseiritu = null;
            while (iter.hasNext()) {

                sV_Sp2RnduyuSouseiritu = iter.next();
                iCount++;

                Assert.assertEquals("791112220", sV_Sp2RnduyuSouseiritu.getMosno());
                Assert.assertEquals(C_SeirituKbn.SEIRITU, sV_Sp2RnduyuSouseiritu.getSeiritukbn());
                Assert.assertEquals(BizDateYM.valueOf(201608), sV_Sp2RnduyuSouseiritu.getSeisekiym());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        Map<String,String> sV_Sp2RnduyuSouseirituMap = new HashMap<String,String>();
        sV_Sp2RnduyuSouseirituMap.put($("791112253", C_SeirituKbn.ITIPMATI, BizDateYM.valueOf(201607)),"1");
        sV_Sp2RnduyuSouseirituMap.put($("791112261", C_SeirituKbn.ITIPMATI, BizDateYM.valueOf(201607)),"1");
        sV_Sp2RnduyuSouseirituMap.put($("791112279", C_SeirituKbn.ITIPMATI, BizDateYM.valueOf(201607)),"1");

        try (ExDBResults<SV_Sp2RnduyuSouseiritu> sV_Sp2RnduyuSouseirituDbResults =
            srSp2RnduyuSouseirituDao.getSp2RnduyuSouseiritusBySeisekiymSeiritukbn(BizDateYM.valueOf(201607),C_SeirituKbn.ITIPMATI)) {

            int iCount = 0;
            Iterator<SV_Sp2RnduyuSouseiritu> iter = sV_Sp2RnduyuSouseirituDbResults.iterator();

            SV_Sp2RnduyuSouseiritu sV_Sp2RnduyuSouseiritu = null;
            while (iter.hasNext()) {

                sV_Sp2RnduyuSouseiritu = iter.next();
                iCount++;
                sV_Sp2RnduyuSouseirituMap.remove($(sV_Sp2RnduyuSouseiritu.getMosno(),sV_Sp2RnduyuSouseiritu.getSeiritukbn(),sV_Sp2RnduyuSouseiritu.getSeisekiym()));
            }
            Assert.assertEquals(3, iCount);
            sV_Sp2RnduyuSouseirituMap.isEmpty();
        }
    }
}
