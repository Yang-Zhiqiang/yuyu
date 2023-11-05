package yuyu.def.db.entity;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 受取人種類区分（一致）を指定して、<br />
 * 受取人ベリファイテーブルエンティティリストを取得します。<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getUketorininVrfsByUktsyukbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_001 = "791112220";
    static Integer P_UKTSYURENNO_001 = new Integer(12);
    static Integer P_UKTSYURENNO_002 = new Integer(13);
    static Integer P_UKTSYURENNO_003 = new Integer(14);
    static Integer P_UKTSYURENNO_004 = new Integer(15);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_001);

        HT_UketorininVrf hT_UketorininVrf_01 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf_01.setUktsyukbn(C_UktsyuKbn.SBUKT);
        hT_UketorininVrf_01.setUktsyurenno(P_UKTSYURENNO_001);

        HT_UketorininVrf hT_UketorininVrf_02 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf_02.setUktsyukbn(C_UktsyuKbn.NKUKT);
        hT_UketorininVrf_02.setUktsyurenno(P_UKTSYURENNO_002);

        HT_UketorininVrf hT_UketorininVrf_03 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf_03.setUktsyukbn(C_UktsyuKbn.NKUKT);
        hT_UketorininVrf_03.setUktsyurenno(P_UKTSYURENNO_003);

        HT_UketorininVrf hT_UketorininVrf_04 = hT_SyoriCTL.createUketorininVrf();
        hT_UketorininVrf_04.setUktsyukbn(C_UktsyuKbn.NKUKT);
        hT_UketorininVrf_04.setUktsyurenno(P_UKTSYURENNO_004);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);
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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_UketorininVrf> hT_UketorininVrfLst = hT_SyoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.BLNK);

        Assert.assertEquals(0, hT_UketorininVrfLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_UketorininVrf> hT_UketorininVrfLst = hT_SyoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.SBUKT);

        Iterator<HT_UketorininVrf> iter = hT_UketorininVrfLst.iterator();
        HT_UketorininVrf hT_UketorininVrf = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            hT_UketorininVrf = iter.next();

            Assert.assertEquals(P_MOSNO_001, hT_UketorininVrf.getMosno());
            Assert.assertEquals(C_UktsyuKbn.SBUKT, hT_UketorininVrf.getUktsyukbn());
            Assert.assertEquals(P_UKTSYURENNO_001, hT_UketorininVrf.getUktsyurenno());
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_UketorininVrf> hT_UketorininVrfLst = hT_SyoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.NKUKT);

        Iterator<HT_UketorininVrf> iter = hT_UketorininVrfLst.iterator();
        HT_UketorininVrf hT_UketorininVrf = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            hT_UketorininVrf = iter.next();
            if (1 == iCount) {

                Assert.assertEquals(P_MOSNO_001, hT_UketorininVrf.getMosno());
                Assert.assertEquals(C_UktsyuKbn.NKUKT, hT_UketorininVrf.getUktsyukbn());
                Assert.assertEquals(P_UKTSYURENNO_002, hT_UketorininVrf.getUktsyurenno());

                continue;
            }
            if (2 == iCount) {

                Assert.assertEquals(P_MOSNO_001, hT_UketorininVrf.getMosno());
                Assert.assertEquals(C_UktsyuKbn.NKUKT, hT_UketorininVrf.getUktsyukbn());
                Assert.assertEquals(P_UKTSYURENNO_003, hT_UketorininVrf.getUktsyurenno());

                continue;
            }
            if (3 == iCount) {

                Assert.assertEquals(P_MOSNO_001, hT_UketorininVrf.getMosno());
                Assert.assertEquals(C_UktsyuKbn.NKUKT, hT_UketorininVrf.getUktsyukbn());
                Assert.assertEquals(P_UKTSYURENNO_004, hT_UketorininVrf.getUktsyurenno());

                continue;
            }
        }

        Assert.assertEquals(3, iCount);
    }
}
