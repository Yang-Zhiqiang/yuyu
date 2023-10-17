package yuyu.def.hozen.manager;

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

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 募集代理店保有契約Ｆ作成<br />
 * 契約代理店情報Beanリスト（大量）取得(拡張ジョブコード、主契約特約区分)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBOF";
    static String P_FILTER_ID = "Kh001";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111141";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111129";
    static String P_SYONO_05 = "11807111152";
    static String P_SYONO_06 = "11807111163";
    static String P_SYOUHNCD_01 = "SY01";
    static String P_SYOUHNCD_02 = "SY02";
    static String P_SYOUHNCD_03 = "SY03";
    static String P_SYOUHNCD_04 = "SY04";
    static Integer P_SYOUHNSDNO_01 = new Integer(10);
    static Integer P_SYOUHNSDNO_02 = new Integer(20);
    static Integer P_SYOUHNSDNO_03 = new Integer(30);
    static Integer P_SYOUHNSDNO_04 = new Integer(40);
    static Integer P_KYKSYOUHNRENNO_01 = new Integer(11);
    static Integer P_KYKSYOUHNRENNO_02 = new Integer(22);
    static Integer P_KYKSYOUHNRENNO_03 = new Integer(33);
    static Integer P_KYKSYOUHNRENNO_04 = new Integer(44);
    static Integer P_DRTENRENNO_01 = new Integer(1);
    static Integer P_DRTENRENNO_02 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_01, C_SyutkKbn.SYU)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KykDairiten iT_KykDairiten1 = iT_KykKihon1.createKykDairiten();
        iT_KykDairiten1.setDrtenrenno(P_DRTENRENNO_01);

        IT_KykSyouhn iT_KykSyouhn1 = iT_KykKihon1.createKykSyouhn();
        iT_KykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn1.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn1.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhn1.setSyouhnsdno(P_SYOUHNSDNO_01);

        iT_KykKihon1.createKykSonotaTkyk();

        iT_KykKihon1.createKykSya();

        iT_KykKihon1.createHhknSya();

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_KykDairiten iT_KykDairiten2 = iT_KykKihon2.createKykDairiten();
        iT_KykDairiten2.setDrtenrenno(P_DRTENRENNO_01);

        IT_KykSyouhn iT_KykSyouhn2 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn2.setSyouhncd(P_SYOUHNCD_02);
        iT_KykSyouhn2.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhn2.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        iT_KykKihon2.createKykSonotaTkyk();

        iT_KykKihon2.createKykSya();

        iT_KykKihon2.createHhknSya();

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_KykDairiten iT_KykDairiten3 = iT_KykKihon3.createKykDairiten();
        iT_KykDairiten3.setDrtenrenno(P_DRTENRENNO_01);

        IT_KykSyouhn iT_KykSyouhn3 = iT_KykKihon3.createKykSyouhn();
        iT_KykSyouhn3.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn3.setSyouhncd(P_SYOUHNCD_03);
        iT_KykSyouhn3.setSyouhnsdno(P_SYOUHNSDNO_03);
        iT_KykSyouhn3.setKyksyouhnrenno(P_KYKSYOUHNRENNO_03);

        iT_KykKihon3.createKykSonotaTkyk();

        iT_KykKihon3.createKykSya();

        iT_KykKihon3.createHhknSya();

        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);

        IT_KykDairiten iT_KykDairiten4 = iT_KykKihon4.createKykDairiten();
        iT_KykDairiten4.setDrtenrenno(P_DRTENRENNO_01);

        IT_KykDairiten iT_KykDairiten5 = iT_KykKihon4.createKykDairiten();
        iT_KykDairiten5.setDrtenrenno(P_DRTENRENNO_02);

        IT_KykSyouhn iT_KykSyouhn4 = iT_KykKihon4.createKykSyouhn();
        iT_KykSyouhn4.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn4.setSyouhncd(P_SYOUHNCD_04);
        iT_KykSyouhn4.setSyouhnsdno(P_SYOUHNSDNO_04);
        iT_KykSyouhn4.setKyksyouhnrenno(P_KYKSYOUHNRENNO_04);

        iT_KykKihon4.createKykSonotaTkyk();

        iT_KykKihon4.createKykSya();

        iT_KykKihon4.createHhknSya();

        hozenDomManager.insert(iT_KykKihon4);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon(P_SYONO_05);

        hozenDomManager.insert(iT_KykKihon5);

        IT_KykKihon iT_KykKihon6 = new IT_KykKihon(P_SYONO_06);

        IT_KykDairiten iT_KykDairiten6 = iT_KykKihon6.createKykDairiten();
        iT_KykDairiten6.setDrtenrenno(P_DRTENRENNO_01);

        hozenDomManager.insert(iT_KykKihon6);
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

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_01, C_SyutkKbn.NONE)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_01, C_SyutkKbn.SYU)){

            int iCount = 0;
            Iterator<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> iter = exDBResBean.iterator();
            KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                Assert.assertEquals(P_SYONO_01, bean.getIT_KykDairiten().getSyono());
                Assert.assertEquals(P_DRTENRENNO_01, bean.getIT_KykDairiten().getDrtenrenno());

                Assert.assertEquals(P_SYONO_01, bean.getIT_KykKihon().getSyono());

                Assert.assertEquals(P_SYONO_01, bean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, bean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals(P_SYOUHNCD_01, bean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(P_SYOUHNSDNO_01, bean.getIT_KykSyouhn().getSyouhnsdno());
                Assert.assertEquals(P_KYKSYOUHNRENNO_01, bean.getIT_KykSyouhn().getKyksyouhnrenno());

                Assert.assertEquals(P_SYONO_01, bean.getIT_KykSonotaTkyk().getSyono());

                Assert.assertEquals(P_SYONO_01, bean.getIT_KykSya().getSyono());

                Assert.assertEquals(P_SYONO_01, bean.getIT_HhknSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_01, C_SyutkKbn.TK)){

            int iCount = 0;
            Iterator<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> iter = exDBResBean.iterator();
            KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SYONO_04, bean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(P_DRTENRENNO_01, bean.getIT_KykDairiten().getDrtenrenno());

                    Assert.assertEquals(P_SYONO_04, bean.getIT_KykKihon().getSyono());

                    Assert.assertEquals(P_SYONO_04, bean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, bean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals(P_SYOUHNCD_04, bean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(P_SYOUHNSDNO_04, bean.getIT_KykSyouhn().getSyouhnsdno());
                    Assert.assertEquals(P_KYKSYOUHNRENNO_04, bean.getIT_KykSyouhn().getKyksyouhnrenno());

                    Assert.assertEquals(P_SYONO_04, bean.getIT_KykSonotaTkyk().getSyono());

                    Assert.assertEquals(P_SYONO_04, bean.getIT_KykSya().getSyono());

                    Assert.assertEquals(P_SYONO_04, bean.getIT_HhknSya().getSyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SYONO_03, bean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(P_DRTENRENNO_01, bean.getIT_KykDairiten().getDrtenrenno());

                    Assert.assertEquals(P_SYONO_03, bean.getIT_KykKihon().getSyono());

                    Assert.assertEquals(P_SYONO_03, bean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, bean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals(P_SYOUHNCD_03, bean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(P_SYOUHNSDNO_03, bean.getIT_KykSyouhn().getSyouhnsdno());
                    Assert.assertEquals(P_KYKSYOUHNRENNO_03, bean.getIT_KykSyouhn().getKyksyouhnrenno());

                    Assert.assertEquals(P_SYONO_03, bean.getIT_KykSonotaTkyk().getSyono());

                    Assert.assertEquals(P_SYONO_03, bean.getIT_KykSya().getSyono());

                    Assert.assertEquals(P_SYONO_03, bean.getIT_HhknSya().getSyono());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SYONO_02, bean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(P_DRTENRENNO_01, bean.getIT_KykDairiten().getDrtenrenno());

                    Assert.assertEquals(P_SYONO_02, bean.getIT_KykKihon().getSyono());

                    Assert.assertEquals(P_SYONO_02, bean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.TK, bean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals(P_SYOUHNCD_02, bean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(P_SYOUHNSDNO_02, bean.getIT_KykSyouhn().getSyouhnsdno());
                    Assert.assertEquals(P_KYKSYOUHNRENNO_02, bean.getIT_KykSyouhn().getKyksyouhnrenno());

                    Assert.assertEquals(P_SYONO_02, bean.getIT_KykSonotaTkyk().getSyono());

                    Assert.assertEquals(P_SYONO_02, bean.getIT_KykSya().getSyono());

                    Assert.assertEquals(P_SYONO_02, bean.getIT_HhknSya().getSyono());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
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
    public void testSkippedFilter40(){

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.
            getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_02,  C_SyutkKbn.TK)){

            Iterator<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> iter = exDBResBean.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
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
        bT_SkipKey1.setTableid("IT_KykKihon");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_04));
        bT_SkipKey1.setRecoveryfilterkey2(P_SYONO_04);
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.
            getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_02,  C_SyutkKbn.TK)){

            int iCount = 0;
            for (KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean kDIbean : exDBResBean) {

                Assert.assertNotEquals(kDIbean.getIT_KykKihon().getSyono(), P_SYONO_04);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("IT_KykKihon");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_03));
        bT_SkipKey2.setRecoveryfilterkey2(P_SYONO_03);
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResBean = hozenDomManager.
            getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(P_JOB_CD_02,  C_SyutkKbn.TK)){

            int iCount = 0;
            for (KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean kDIbean : exDBResBean) {

                Assert.assertNotEquals(kDIbean.getIT_KykKihon().getSyono(), P_SYONO_04);
                Assert.assertNotEquals(kDIbean.getIT_KykKihon().getSyono(), P_SYONO_03);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
