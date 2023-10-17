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

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 全額返金区分を指定して、<br />
 * 入金テーブルエンティティリストを取得します。<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinsByZenhnknkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_1 = "791112220";
    static String P_MOSNO_2 = "791112238";
    static Integer P_RENNO_1 = new Integer(12);
    static Integer P_RENNO_2 = new Integer(13);
    static Integer P_RENNO_3 = new Integer(14);
    static Integer P_RENNO_4 = new Integer(15);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_1);

        HT_Nyuukin hT_Nyuukin_1 = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin_1.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        hT_Nyuukin_1.setRenno(P_RENNO_1);

        HT_Nyuukin hT_Nyuukin_2 = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin_2.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        hT_Nyuukin_2.setRenno(P_RENNO_2);

        HT_Nyuukin hT_Nyuukin_3 = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin_3.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        hT_Nyuukin_3.setRenno(P_RENNO_3);

        HT_Nyuukin hT_Nyuukin_4 = hT_SyoriCTL.createNyuukin();
        hT_Nyuukin_4.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        hT_Nyuukin_4.setRenno(P_RENNO_4);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_2);

        HT_Nyuukin hT_Nyuukin_5 = hT_SyoriCTL2.createNyuukin();
        hT_Nyuukin_5.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        hT_Nyuukin_5.setRenno(P_RENNO_2);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_2);

        List<HT_Nyuukin> hT_NyuukinLst = hT_SyoriCTL.getNyuukinsByZenhnknkbn(C_ZenhnknKbn.BLNK);

        Assert.assertEquals(0, hT_NyuukinLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);

        List<HT_Nyuukin> hT_NyuukinLst = hT_SyoriCTL.getNyuukinsByZenhnknkbn(C_ZenhnknKbn.BLNK);

        Iterator<HT_Nyuukin> iter = hT_NyuukinLst.iterator();
        HT_Nyuukin hT_Nyuukin = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            hT_Nyuukin = iter.next();
            Assert.assertEquals(P_MOSNO_1, hT_Nyuukin.getMosno());
            Assert.assertEquals(C_ZenhnknKbn.BLNK, hT_Nyuukin.getZenhnknkbn());
            Assert.assertEquals(P_RENNO_1, hT_Nyuukin.getRenno());
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_1);

        List<HT_Nyuukin> hT_NyuukinLst = hT_SyoriCTL.getNyuukinsByZenhnknkbn(C_ZenhnknKbn.SUMI);

        Iterator<HT_Nyuukin> iter = hT_NyuukinLst.iterator();
        HT_Nyuukin hT_Nyuukin = null;
        int iCount = 0;
        while (iter.hasNext()) {

            iCount++;
            hT_Nyuukin = iter.next();
            if (1 == iCount) {

                Assert.assertEquals(P_MOSNO_1, hT_Nyuukin.getMosno());
                Assert.assertEquals(C_ZenhnknKbn.SUMI, hT_Nyuukin.getZenhnknkbn());
                Assert.assertEquals(P_RENNO_2, hT_Nyuukin.getRenno());

                continue;
            }
            if (2 == iCount) {

                Assert.assertEquals(P_MOSNO_1, hT_Nyuukin.getMosno());
                Assert.assertEquals(C_ZenhnknKbn.SUMI, hT_Nyuukin.getZenhnknkbn());
                Assert.assertEquals(P_RENNO_3, hT_Nyuukin.getRenno());

                continue;
            }
            if (3 == iCount) {

                Assert.assertEquals(P_MOSNO_1, hT_Nyuukin.getMosno());
                Assert.assertEquals(C_ZenhnknKbn.SUMI, hT_Nyuukin.getZenhnknkbn());
                Assert.assertEquals(P_RENNO_4, hT_Nyuukin.getRenno());

                continue;
            }
        }

        Assert.assertEquals(3, iCount);
    }
}
