package yuyu.def.sinkeiyaku.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約不備帳票作成<br />
 * 不備情報Beanリスト(大量)取得(拡張ジョブコード)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RBA0";
    static String P_FILTER_ID = "Sk001";
    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";
    static Integer P_RENNO3KETA_01 = new Integer(111);
    static Integer P_RENNO3KETA_02 = new Integer(222);
    static Integer P_RENNO3KETA_03 = new Integer(333);
    static String P_HUBISIKIBETUKEY_01 = "HBKEY111";
    static String P_HUBISIKIBETUKEY_02 = "HBKEY222";
    static String P_HUBISIKIBETUKEY_03 = "HBKEY333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try(ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean = sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_01)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_02);

        HT_SkHubi hT_SkHubi11 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi11.setHubisikibetukey(P_HUBISIKIBETUKEY_01);

        HT_SkHubiDetail hT_SkHubiDetail111 = hT_SkHubi11.createSkHubiDetail();
        hT_SkHubiDetail111.setRenno3keta(P_RENNO3KETA_02);
        hT_SkHubiDetail111.setHasinymd(BizDate.valueOf(20160303));
        hT_SkHubiDetail111.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail hT_SkHubiDetail112 = hT_SkHubi11.createSkHubiDetail();
        hT_SkHubiDetail112.setRenno3keta(P_RENNO3KETA_03);
        hT_SkHubiDetail112.setHasinkyokakbn(C_HasinkyokaKbn.HORYUU);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult10() {

        try(ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean = sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_01)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void noResult20() {
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_02);

        HT_SkHubi hT_SkHubi11 = hT_SyoriCTL1.getSkHubiByHubisikibetukey(P_HUBISIKIBETUKEY_01);

        HT_SkHubiDetail hT_SkHubiDetail113 = hT_SkHubi11.createSkHubiDetail();
        hT_SkHubiDetail113.setRenno3keta(P_RENNO3KETA_01);
        hT_SkHubiDetail113.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.update(hT_SyoriCTL1);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_01)){

            int iCount = 0;
            Iterator<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> iter = exDBResBean.iterator();
            HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                Assert.assertEquals(P_HUBISIKIBETUKEY_01, bean.getHubisikibetukey());
                Assert.assertEquals(P_MOSNO_02, bean.getMosno());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void noResult30() {
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_02);

        HT_SkHubi hT_SkHubi12 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi12.setHubisikibetukey(P_HUBISIKIBETUKEY_02);

        sinkeiyakuDomManager.update(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_01);

        HT_SkHubi hT_SkHubi21 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi21.setHubisikibetukey(P_HUBISIKIBETUKEY_03);

        HT_SkHubi hT_SkHubi22 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi22.setHubisikibetukey(P_HUBISIKIBETUKEY_02);

        HT_SkHubiDetail hT_SkHubiDetail221 = hT_SkHubi22.createSkHubiDetail();
        hT_SkHubiDetail221.setRenno3keta(P_RENNO3KETA_01);
        hT_SkHubiDetail221.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubi hT_SkHubi23 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi23.setHubisikibetukey(P_HUBISIKIBETUKEY_01);

        HT_SkHubiDetail hT_SkHubiDetail231 = hT_SkHubi23.createSkHubiDetail();
        hT_SkHubiDetail231.setRenno3keta(P_RENNO3KETA_01);
        hT_SkHubiDetail231.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        HT_SkHubiDetail hT_SkHubiDetail232 = hT_SkHubi23.createSkHubiDetail();
        hT_SkHubiDetail232.setRenno3keta(P_RENNO3KETA_02);
        hT_SkHubiDetail232.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(P_MOSNO_03);

        HT_SkHubi hT_SkHubi31 = hT_SyoriCTL3.createSkHubi();
        hT_SkHubi31.setHubisikibetukey(P_HUBISIKIBETUKEY_01);

        HT_SkHubiDetail hT_SkHubiDetail311 = hT_SkHubi31.createSkHubiDetail();
        hT_SkHubiDetail311.setRenno3keta(P_RENNO3KETA_01);
        hT_SkHubiDetail311.setHasinkyokakbn(C_HasinkyokaKbn.KY);

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);
    }

    @Test
    @TestOrder(31)
    public void normal31() {

        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_01)){

            int iCount = 0;
            Iterator<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> iter = exDBResBean.iterator();
            HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_HUBISIKIBETUKEY_01, bean.getHubisikibetukey());
                    Assert.assertEquals(P_MOSNO_01, bean.getMosno());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_HUBISIKIBETUKEY_02, bean.getHubisikibetukey());
                    Assert.assertEquals(P_MOSNO_01, bean.getMosno());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_HUBISIKIBETUKEY_01, bean.getHubisikibetukey());
                    Assert.assertEquals(P_MOSNO_02, bean.getMosno());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_HUBISIKIBETUKEY_01, bean.getHubisikibetukey());
                    Assert.assertEquals(P_MOSNO_03, bean.getMosno());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_02)){

            int iCount = 0;
            Iterator<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> iter = exDBResBean.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("申込番号フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("mosno");

        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HT_SkHubiDetail");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_MOSNO_03);

        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_02)){

            int iCount = 0;
            for (HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean HubKbean : exDBResBean) {

                Assert.assertNotEquals(HubKbean.getMosno(), P_MOSNO_03);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("HT_SkHubiDetail");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_MOSNO_02);

        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBResBean =
            sinkeiyakuDomManager.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(P_KAKUTYOUJOBCD_02)){

            int iCount = 0;
            for (HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean HubKbean : exDBResBean) {

                Assert.assertNotEquals(HubKbean.getMosno(), P_MOSNO_03);
                Assert.assertNotEquals(HubKbean.getMosno(), P_MOSNO_02);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
