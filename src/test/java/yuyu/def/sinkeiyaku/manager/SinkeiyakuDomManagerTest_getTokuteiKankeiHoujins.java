package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 特定関係法人名突合マスタ反映<br />
 * 特定関係法人マスタエンティティリスト(大量)取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getTokuteiKankeiHoujins {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_TKHJNKINYUUCD_01 = "TK01";
    static String P_TKHJNKINYUUCD_02 = "TK02";
    static String P_TKHJNKINYUUCD_03 = "TK03";
    static BizNumber P_MEISAINO_01 = BizNumber.valueOf(1);
    static BizNumber P_MEISAINO_02 = BizNumber.valueOf(2);
    static BizNumber P_MEISAINO_03 = BizNumber.valueOf(3);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HM_TokuteiKankeiHoujin> beans = sinkeiyakuDomManager.getTokuteiKankeiHoujins()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin1 = new HM_TokuteiKankeiHoujin(P_TKHJNKINYUUCD_03, P_MEISAINO_01);

        sinkeiyakuDomManager.insert(hM_TokuteiKankeiHoujin1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllTokuteiKankeiHoujin());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal10() {

        try (ExDBResults<HM_TokuteiKankeiHoujin> beans = sinkeiyakuDomManager.getTokuteiKankeiHoujins()) {

            int iCount = 0;

            for (HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin : beans) {
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_03, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_01, hM_TokuteiKankeiHoujin.getMeisaino());
                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin2 = new HM_TokuteiKankeiHoujin(P_TKHJNKINYUUCD_02, P_MEISAINO_01);

        sinkeiyakuDomManager.insert(hM_TokuteiKankeiHoujin2);

        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin3 = new HM_TokuteiKankeiHoujin(P_TKHJNKINYUUCD_01, P_MEISAINO_03);

        sinkeiyakuDomManager.insert(hM_TokuteiKankeiHoujin3);

        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin4 = new HM_TokuteiKankeiHoujin(P_TKHJNKINYUUCD_01, P_MEISAINO_02);

        sinkeiyakuDomManager.insert(hM_TokuteiKankeiHoujin4);

        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin5 = new HM_TokuteiKankeiHoujin(P_TKHJNKINYUUCD_01, P_MEISAINO_01);

        sinkeiyakuDomManager.insert(hM_TokuteiKankeiHoujin5);

    }

    @Test
    @TestOrder(21)
    public void normal21() {

        try (ExDBResults<HM_TokuteiKankeiHoujin> beans = sinkeiyakuDomManager.getTokuteiKankeiHoujins()) {

            int iCount = 0;

            for (HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin : beans) {
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_01, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_01, hM_TokuteiKankeiHoujin.getMeisaino());
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_01, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_02, hM_TokuteiKankeiHoujin.getMeisaino());
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_01, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_03, hM_TokuteiKankeiHoujin.getMeisaino());
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_02, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_01, hM_TokuteiKankeiHoujin.getMeisaino());
                }

                if (5 == iCount) {

                    Assert.assertEquals(P_TKHJNKINYUUCD_03, hM_TokuteiKankeiHoujin.getTkhjnkinyuucd());
                    Assert.assertEquals(P_MEISAINO_01, hM_TokuteiKankeiHoujin.getMeisaino());
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }
}
