package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * ＦＡＴＣＡ定期調査要<br />
 * ＦＡＴＣＡ定期調査要契約情報Bean大量取得（拡張ジョブコード、処理年）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBI6";
    static String P_FILTER_ID = "Kh001";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static BizDateY P_SYORIYEAR_01 = BizDateY.valueOf("2015");
    static BizDateY P_SYORIYEAR_02 = BizDateY.valueOf("2016");
    static BizDateY P_SYORIYEAR_03 = BizDateY.valueOf("2018");
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20150325");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20151001");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20151212");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160101");
    static BizDate P_SYORIYMD_05 = BizDate.valueOf("20170325");
    static BizDate P_KOURYOKUENDYMD_01 = BizDate.valueOf("20160324");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_01, P_SYORIYEAR_02)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_FatcaInfo iT_FatcaInfo11 = iT_KykKihon1.createFatcaInfo();
        iT_FatcaInfo11.setRenno(11);
        iT_FatcaInfo11.setSyoriYmd(P_SYORIYMD_01);
        iT_FatcaInfo11.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_KykSyouhn iT_KykSyouhn11 = iT_KykKihon1.createKykSyouhn();
        iT_KykSyouhn11.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn11.setSyouhncd("SH01");
        iT_KykSyouhn11.setSyouhnsdno(11);
        iT_KykSyouhn11.setKyksyouhnrenno(1);

        iT_KykKihon1.createKykSya();

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_FatcaInfo iT_FatcaInfo21 = iT_KykKihon2.createFatcaInfo();
        iT_FatcaInfo21.setRenno(11);
        iT_FatcaInfo21.setSyoriYmd(P_SYORIYMD_05);
        iT_FatcaInfo21.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_FatcaInfo iT_FatcaInfo22 = iT_KykKihon2.createFatcaInfo();
        iT_FatcaInfo22.setRenno(12);
        iT_FatcaInfo22.setSyoriYmd(P_SYORIYMD_01);
        iT_FatcaInfo22.setFatcakekkbn(C_FatcakekKbn.KAKUNINTYUU);

        IT_FatcaInfo iT_FatcaInfo23 = iT_KykKihon2.createFatcaInfo();
        iT_FatcaInfo23.setRenno(13);
        iT_FatcaInfo23.setSyoriYmd(P_SYORIYMD_01);
        iT_FatcaInfo23.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
        iT_FatcaInfo23.setKouryokuendymd(P_KOURYOKUENDYMD_01);

        IT_FatcaInfo iT_FatcaInfo24 = iT_KykKihon2.createFatcaInfo();
        iT_FatcaInfo24.setRenno(14);
        iT_FatcaInfo24.setSyoriYmd(P_SYORIYMD_01);
        iT_FatcaInfo24.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_KykSyouhn iT_KykSyouhn21 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn21.setSyouhncd("SH01");
        iT_KykSyouhn21.setSyouhnsdno(11);
        iT_KykSyouhn21.setKyksyouhnrenno(1);

        IT_KykSyouhn iT_KykSyouhn22 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn22.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn22.setSyouhncd("SH01");
        iT_KykSyouhn22.setSyouhnsdno(12);
        iT_KykSyouhn22.setKyksyouhnrenno(2);

        iT_KykKihon2.createKykSya();

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_FatcaInfo iT_FatcaInfo31 = iT_KykKihon3.createFatcaInfo();
        iT_FatcaInfo31.setRenno(11);
        iT_FatcaInfo31.setSyoriYmd(P_SYORIYMD_02);
        iT_FatcaInfo31.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_KykSyouhn iT_KykSyouhn31 = iT_KykKihon3.createKykSyouhn();
        iT_KykSyouhn31.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn31.setSyouhncd("SH01");
        iT_KykSyouhn31.setSyouhnsdno(11);
        iT_KykSyouhn31.setKyksyouhnrenno(1);

        iT_KykKihon3.createKykSya();

        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);

        IT_FatcaInfo iT_FatcaInfo41 = iT_KykKihon4.createFatcaInfo();
        iT_FatcaInfo41.setRenno(11);
        iT_FatcaInfo41.setSyoriYmd(P_SYORIYMD_03);
        iT_FatcaInfo41.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_FatcaInfo iT_FatcaInfo42 = iT_KykKihon4.createFatcaInfo();
        iT_FatcaInfo42.setRenno(12);
        iT_FatcaInfo42.setSyoriYmd(P_SYORIYMD_04);
        iT_FatcaInfo42.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_KykSyouhn iT_KykSyouhn41 = iT_KykKihon4.createKykSyouhn();
        iT_KykSyouhn41.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn41.setSyouhncd("SH01");
        iT_KykSyouhn41.setSyouhnsdno(11);
        iT_KykSyouhn41.setKyksyouhnrenno(1);

        iT_KykKihon4.createKykSya();

        hozenDomManager.insert(iT_KykKihon4);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon(P_SYONO_05);

        hozenDomManager.insert(iT_KykKihon5);
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

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_01, P_SYORIYEAR_03)){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_01, P_SYORIYEAR_02)){

            int iCount = 0;
            for (FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean fKSKbean : exDBResBean) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_SYONO_04, fKSKbean.getIT_FatcaInfo().getSyono());
                    Assert.assertEquals(Integer.valueOf(12), fKSKbean.getIT_FatcaInfo().getRenno());
                    Assert.assertEquals(P_SYORIYMD_04, fKSKbean.getIT_FatcaInfo().getSyoriYmd());
                    Assert.assertEquals(C_FatcakekKbn.TAISYOUGAIYOU, fKSKbean.getIT_FatcaInfo().getFatcakekkbn());
                    Assert.assertNull(fKSKbean.getIT_FatcaInfo().getKouryokuendymd());

                    Assert.assertEquals(P_SYONO_04, fKSKbean.getIT_KykKihon().getSyono());

                    Assert.assertEquals(P_SYONO_04, fKSKbean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals("SH01", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(Integer.valueOf(11), fKSKbean.getIT_KykSyouhn().getSyouhnsdno());
                    Assert.assertEquals(Integer.valueOf(1), fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno());

                    Assert.assertEquals(P_SYONO_04, fKSKbean.getIT_KykSya().getSyono());
                }

                Assert.assertEquals(1, iCount);
            }
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111129","14","20150325","4","11807111129","11807111129","1","SH01","11","1","11807111129"), "1");
        datamap.put($("11807111130","11","20151001","4","11807111130","11807111130","1","SH01","11","1","11807111130"), "2");
        datamap.put($("11807111141","11","20151212","4","11807111141","11807111141","1","SH01","11","1","11807111141"), "3");

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_01, P_SYORIYEAR_01)){

            for (FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean fKSKbean : exDBResBean) {

                datamap.remove($(
                    fKSKbean.getIT_FatcaInfo().getSyono(),
                    fKSKbean.getIT_FatcaInfo().getRenno(),
                    fKSKbean.getIT_FatcaInfo().getSyoriYmd(),
                    fKSKbean.getIT_FatcaInfo().getFatcakekkbn(),
                    fKSKbean.getIT_KykKihon().getSyono(),
                    fKSKbean.getIT_KykSyouhn().getSyono(),
                    fKSKbean.getIT_KykSyouhn().getSyutkkbn(),
                    fKSKbean.getIT_KykSyouhn().getSyouhncd(),
                    fKSKbean.getIT_KykSyouhn().getSyouhnsdno(),
                    fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno(),
                    fKSKbean.getIT_KykSya().getSyono()));
            }

            Assert.assertTrue(datamap.isEmpty());
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

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_02, P_SYORIYEAR_01)){

            Iterator<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> iter = exDBResBean.iterator();
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
        bT_SkipKey1.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02));
        bT_SkipKey1.setRecoveryfilterkey2(P_SYONO_02);
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_02, P_SYORIYEAR_01)){

            int iCount = 0;
            for (FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean fKSKbean : exDBResBean) {

                assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), P_SYONO_02);

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

        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResBean = hozenDomManager.
            getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(P_JOB_CD_02, P_SYORIYEAR_01)){

            int iCount = 0;
            for (FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean fKSKbean : exDBResBean) {

                assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), P_SYONO_02);
                assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), P_SYONO_03);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}