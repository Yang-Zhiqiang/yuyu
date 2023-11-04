package yuyu.def.hozen.manager;

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

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.result.bean.SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 新契約保険証券Ｆ作成<br />
 * 新契約保険証券情報（大量）取得　新規再発行区分複数かつ証券再発行区分が新契約証券再作成のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBT0";
    static String P_FILTER_ID = "Kh001";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static String P_SYONO_06 = "11807111163";
    static String P_SYONO_07 = "11807111174";
    static BizDate P_TYOUHYOUYMD_01 = BizDate.valueOf(20610303);
    static BizDate P_TYOUHYOUYMD_02 = BizDate.valueOf(20160313);
    static BizDate P_TYOUHYOUYMD_03 = BizDate.valueOf(20160323);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_01, P_TYOUHYOUYMD_01)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_02);

        IT_HokenSyouken iT_HokenSyouken11 = iT_KykKihon1.createHokenSyouken();
        iT_HokenSyouken11.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken11.setSinsaihkkbn(C_SinsaihkKbn.SAI);
        iT_HokenSyouken11.setSyoukensaihkkbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);

        IT_Suiihyou iT_Suiihyou12 = iT_KykKihon1.createSuiihyou();
        iT_Suiihyou12.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou12.setKeikanensuu(new Integer(3));

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_01);

        IT_HokenSyouken iT_HokenSyouken21 = iT_KykKihon2.createHokenSyouken();
        iT_HokenSyouken21.setTyouhyouymd(P_TYOUHYOUYMD_01);
        iT_HokenSyouken21.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken iT_HokenSyouken22 = iT_KykKihon2.createHokenSyouken();
        iT_HokenSyouken22.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken22.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken iT_HokenSyouken23 = iT_KykKihon2.createHokenSyouken();
        iT_HokenSyouken23.setTyouhyouymd(P_TYOUHYOUYMD_03);
        iT_HokenSyouken23.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_Suiihyou iT_Suiihyou24 = iT_KykKihon2.createSuiihyou();
        iT_Suiihyou24.setTyouhyouymd(P_TYOUHYOUYMD_01);
        iT_Suiihyou24.setKeikanensuu(new Integer(13));

        IT_Suiihyou iT_Suiihyou25 = iT_KykKihon2.createSuiihyou();
        iT_Suiihyou25.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou25.setKeikanensuu(new Integer(13));

        IT_Suiihyou iT_Suiihyou26 = iT_KykKihon2.createSuiihyou();
        iT_Suiihyou26.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou26.setKeikanensuu(new Integer(12));

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_HokenSyouken iT_HokenSyouken31 = iT_KykKihon3.createHokenSyouken();
        iT_HokenSyouken31.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken31.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken iT_HokenSyouken32 = iT_KykKihon3.createHokenSyouken();
        iT_HokenSyouken32.setTyouhyouymd(P_TYOUHYOUYMD_03);
        iT_HokenSyouken32.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_Suiihyou iT_Suiihyou33 = iT_KykKihon3.createSuiihyou();
        iT_Suiihyou33.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou33.setKeikanensuu(new Integer(13));

        IT_Suiihyou iT_Suiihyou34 = iT_KykKihon3.createSuiihyou();
        iT_Suiihyou34.setTyouhyouymd(P_TYOUHYOUYMD_03);
        iT_Suiihyou34.setKeikanensuu(new Integer(13));

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);

        IT_HokenSyouken iT_HokenSyouken41 = iT_KykKihon4.createHokenSyouken();
        iT_HokenSyouken41.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken41.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon(P_SYONO_05);

        IT_HokenSyouken iT_HokenSyouken51 = iT_KykKihon5.createHokenSyouken();
        iT_HokenSyouken51.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken51.setSinsaihkkbn(C_SinsaihkKbn.BLNK);

        IT_Suiihyou iT_Suiihyou52 = iT_KykKihon5.createSuiihyou();
        iT_Suiihyou52.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou52.setKeikanensuu(new Integer(13));

        IT_KykKihon iT_KykKihon6 = new IT_KykKihon(P_SYONO_06);

        IT_HokenSyouken iT_HokenSyouken61 = iT_KykKihon6.createHokenSyouken();
        iT_HokenSyouken61.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken61.setSinsaihkkbn(C_SinsaihkKbn.BLNK);
        iT_HokenSyouken61.setSyoukensaihkkbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);

        IT_Suiihyou iT_Suiihyou62 = iT_KykKihon6.createSuiihyou();
        iT_Suiihyou62.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou62.setKeikanensuu(new Integer(13));

        IT_KykKihon iT_KykKihon7 = new IT_KykKihon(P_SYONO_07);

        IT_HokenSyouken iT_HokenSyouken71 = iT_KykKihon7.createHokenSyouken();
        iT_HokenSyouken71.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_HokenSyouken71.setSinsaihkkbn(C_SinsaihkKbn.SAI);
        iT_HokenSyouken71.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        IT_Suiihyou iT_Suiihyou72 = iT_KykKihon7.createSuiihyou();
        iT_Suiihyou72.setTyouhyouymd(P_TYOUHYOUYMD_02);
        iT_Suiihyou72.setKeikanensuu(new Integer(13));

        hozenDomManager.insert(iT_KykKihon1);
        hozenDomManager.insert(iT_KykKihon2);
        hozenDomManager.insert(iT_KykKihon3);
        hozenDomManager.insert(iT_KykKihon4);
        hozenDomManager.insert(iT_KykKihon5);
        hozenDomManager.insert(iT_KykKihon6);
        hozenDomManager.insert(iT_KykKihon7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_01, BizDate.valueOf(20150303))){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_01, P_TYOUHYOUYMD_01)){

            Iterator<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> iter = exDBResBean.iterator();
            SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean bean = null;
            int iCount = 0;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_SYONO_01, bean.getIT_HokenSyouken().getSyono());
                    Assert.assertEquals(P_TYOUHYOUYMD_01, bean.getIT_HokenSyouken().getTyouhyouymd());
                    Assert.assertEquals(C_SinsaihkKbn.SIN, bean.getIT_HokenSyouken().getSinsaihkkbn());
                    Assert.assertEquals(null, bean.getIT_HokenSyouken().getSyoukensaihkkbn());

                    Assert.assertEquals(new Integer(13), bean.getKeikanensuu());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_01, P_TYOUHYOUYMD_02)){

            Iterator<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> iter = exDBResBean.iterator();
            SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean bean = null;
            int iCount = 0;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_SYONO_01, bean.getIT_HokenSyouken().getSyono());
                    Assert.assertEquals(P_TYOUHYOUYMD_02, bean.getIT_HokenSyouken().getTyouhyouymd());
                    Assert.assertEquals(C_SinsaihkKbn.SIN, bean.getIT_HokenSyouken().getSinsaihkkbn());
                    Assert.assertEquals(null, bean.getIT_HokenSyouken().getSyoukensaihkkbn());

                    Assert.assertEquals(new Integer(12), bean.getKeikanensuu());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SYONO_01, bean.getIT_HokenSyouken().getSyono());
                    Assert.assertEquals(P_TYOUHYOUYMD_02, bean.getIT_HokenSyouken().getTyouhyouymd());
                    Assert.assertEquals(C_SinsaihkKbn.SIN, bean.getIT_HokenSyouken().getSinsaihkkbn());
                    Assert.assertEquals(null, bean.getIT_HokenSyouken().getSyoukensaihkkbn());

                    Assert.assertEquals(new Integer(13), bean.getKeikanensuu());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SYONO_02, bean.getIT_HokenSyouken().getSyono());
                    Assert.assertEquals(P_TYOUHYOUYMD_02, bean.getIT_HokenSyouken().getTyouhyouymd());
                    Assert.assertEquals(C_SinsaihkKbn.SAI, bean.getIT_HokenSyouken().getSinsaihkkbn());
                    Assert.assertEquals(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, bean.getIT_HokenSyouken().getSyoukensaihkkbn());

                    Assert.assertEquals(new Integer(3), bean.getKeikanensuu());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_SYONO_03, bean.getIT_HokenSyouken().getSyono());
                    Assert.assertEquals(P_TYOUHYOUYMD_02, bean.getIT_HokenSyouken().getTyouhyouymd());
                    Assert.assertEquals(C_SinsaihkKbn.SIN, bean.getIT_HokenSyouken().getSinsaihkkbn());
                    Assert.assertEquals(null, bean.getIT_HokenSyouken().getSyoukensaihkkbn());

                    Assert.assertEquals(new Integer(13), bean.getKeikanensuu());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }
    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_02, P_TYOUHYOUYMD_02)){

            Iterator<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> iter = exDBResBean.iterator();
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
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("契約基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("kbnkey");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("IT_HokenSyouken");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02));
        bT_SkipKey1.setRecoveryfilterkey2(P_SYONO_02);
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_02, P_TYOUHYOUYMD_02)){

            int iCount = 0;
            for (SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean bean : exDBResBean) {

                Assert.assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02), bean.getIT_HokenSyouken().getKbnkey());
                Assert.assertNotEquals(P_SYONO_02, bean.getIT_HokenSyouken().getSyono());

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
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("IT_HokenSyouken");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_03));
        bT_SkipKey2.setRecoveryfilterkey2(P_SYONO_03);
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResBean = hozenDomManager.
            getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(P_JOB_CD_02, P_TYOUHYOUYMD_02)){

            int iCount = 0;
            for (SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean bean : exDBResBean) {

                Assert.assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02), bean.getIT_HokenSyouken().getKbnkey());
                Assert.assertNotEquals(P_SYONO_02, bean.getIT_HokenSyouken().getSyono());
                Assert.assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_03), bean.getIT_HokenSyouken().getKbnkey());
                Assert.assertNotEquals(P_SYONO_03, bean.getIT_HokenSyouken().getSyono());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}