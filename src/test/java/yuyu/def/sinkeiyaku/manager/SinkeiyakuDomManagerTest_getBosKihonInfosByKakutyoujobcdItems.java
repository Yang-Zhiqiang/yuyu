package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.sinkeiyaku.result.bean.BosKihonInfosByKakutyoujobcdItemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 募集基本情報Beanリスト（大量）取得　申込受付区分などのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBosKihonInfosByKakutyoujobcdItems {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    private static String P_JOB_CD_01 = "RBGG";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.MOSKIT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_BosKihon hT_BosKihon1 = new HT_BosKihon("MNO00000011");
        hT_BosKihon1.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon1.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon1.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon2 = new HT_BosKihon("MNO00000003");
        hT_BosKihon2.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon2.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon2.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon3 = new HT_BosKihon("MNO00000021");
        hT_BosKihon3.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon3.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon3.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon4 = new HT_BosKihon("MNO00000012");
        hT_BosKihon4.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon4.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.TOUROKUZUMI);
        hT_BosKihon4.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon5 = new HT_BosKihon("MNO00000001");
        hT_BosKihon5.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon5.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon5.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon6 = new HT_BosKihon("MNO00000100");
        hT_BosKihon6.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        hT_BosKihon6.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon6.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon7 = new HT_BosKihon("MNO00000005");
        hT_BosKihon7.setMosuketukekbn(C_MosUketukeKbn.PAPERLESS);
        hT_BosKihon7.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon7.setPplessdatasousinumukbn(C_UmuKbn.NONE);

        HT_BosKihon hT_BosKihon8 = new HT_BosKihon("MNO00000002");
        hT_BosKihon8.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
        hT_BosKihon8.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
        hT_BosKihon8.setPplessdatasousinumukbn(C_UmuKbn.ARI);


        sinkeiyakuDomManager.insert(hT_BosKihon1);
        sinkeiyakuDomManager.insert(hT_BosKihon2);
        sinkeiyakuDomManager.insert(hT_BosKihon3);
        sinkeiyakuDomManager.insert(hT_BosKihon4);
        sinkeiyakuDomManager.insert(hT_BosKihon5);
        sinkeiyakuDomManager.insert(hT_BosKihon6);
        sinkeiyakuDomManager.insert(hT_BosKihon8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.MOSKIT, C_MosTourokuJyoukyouKbn.TOUROKUZUMI, C_UmuKbn.NONE);) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.MOSKIT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            int iCount = 0;
            Iterator<BosKihonInfosByKakutyoujobcdItemsBean> iter = beans.iterator();
            BosKihonInfosByKakutyoujobcdItemsBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                Assert.assertEquals("MNO00000100", bean.getMosno());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.DIRECT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            int iCount = 0;
            Iterator<BosKihonInfosByKakutyoujobcdItemsBean> iter = beans.iterator();
            BosKihonInfosByKakutyoujobcdItemsBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("MNO00000001", bean.getMosno());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("MNO00000003", bean.getMosno());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("MNO00000011", bean.getMosno());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("MNO00000021", bean.getMosno());

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
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {


        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.DIRECT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            Iterator<BosKihonInfosByKakutyoujobcdItemsBean> iter = beans.iterator();
            int iCount = 0;
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

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk001");
        filter.setRecoveryfilternm("申込番号フィルタ");
        filter.setRecoveryfilterkeykmid1("mosno");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setKakutyoujobcd(P_JOB_CD_01);
        key3.setRecoveryfilterid("Sk001");
        key3.setRecoveryfilterkey1("MNO00000003");
        key3.setTableid("HT_BosKihon");
        sinkeiyakuDomManager.insert(key3);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){


        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.DIRECT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            int iCount = 0;

            for (BosKihonInfosByKakutyoujobcdItemsBean bean : beans) {

                assertNotEquals(bean.getMosno(), "MNO00000003");

                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid("Sk001");
        key1.setKakutyoujobcd(P_JOB_CD_01);
        key1.setRecoveryfilterkey1("MNO00000021");
        key1.setTableid("HT_BosKihon");
        sinkeiyakuDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> beans = sinkeiyakuDomManager
            .getBosKihonInfosByKakutyoujobcdItems(P_JOB_CD_01, C_MosUketukeKbn.DIRECT, C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.NONE);) {

            int iCount = 0;

            for (BosKihonInfosByKakutyoujobcdItemsBean bean : beans) {

                assertNotEquals(bean.getMosno(), "MNO00000003");
                assertNotEquals(bean.getMosno(), "MNO00000021");

                iCount++;
            }
            assertEquals(2, iCount);
        }
    }
}