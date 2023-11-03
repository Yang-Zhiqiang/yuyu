package yuyu.def.direct.manager;

import static org.junit.Assert.*;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * ＤＳ顧客契約テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisByKakutyoujobcd {

    @Inject
    DirectDomManager directDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGUO";
    static String P_FILTER_ID = "Ds001";
    public static String P_DSKOKNO_01 = "KN001";
    public static String P_DSKOKNO_02 = "KN002";
    public static String P_DSKOKNO_03 = "KN003";
    public static String P_DSKOKNO_04 = "KN004";
    public static String P_DSKOKNO_05 = "KN005";
    public static String P_SYONO_01 = "11807000010";
    public static String P_SYONO_02 = "11807000021";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanriExDBUpdatableResults =
                directDomManager.getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_01)) {

            Assert.assertFalse(mT_DsKokyakuKanriExDBUpdatableResults.iterator().hasNext());
        }

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri(P_DSKOKNO_02);

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri(P_DSKOKNO_01);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono(P_SYONO_01);
        dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.MUKOU);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono(P_SYONO_02);
        dsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(dsKokyakuKanri3);

        IT_KykKihon kykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("1001");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(1);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1002");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(1);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(kykKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_01)) {

            Assert.assertFalse(mT_DsKokyakuKanris.iterator().hasNext());
        }

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri(P_DSKOKNO_03);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono(P_SYONO_01);
        dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(dsKokyakuKanri1);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_01)) {

            int iCount = 0;
            Iterator<MT_DsKokyakuKanri> iter = mT_DsKokyakuKanris.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                iCount++;

                Assert.assertEquals(P_DSKOKNO_03, mT_DsKokyakuKanri.getDskokno());
            }

            Assert.assertEquals(1, iCount);
        }

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri(P_DSKOKNO_05);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono(P_SYONO_01);
        dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri(P_DSKOKNO_04);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono(P_SYONO_01);
        dsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(dsKokyakuKanri2);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_01)) {

            int iCount = 0;
            Iterator<MT_DsKokyakuKanri> iter = mT_DsKokyakuKanris.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                iCount++;

                if(1 == iCount){

                    Assert.assertEquals(P_DSKOKNO_03, mT_DsKokyakuKanri.getDskokno());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_DSKOKNO_04, mT_DsKokyakuKanri.getDskokno());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_DSKOKNO_05, mT_DsKokyakuKanri.getDskokno());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
        }
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter1(){

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_02)){

            Iterator<MT_DsKokyakuKanri> iter = mT_DsKokyakuKanris.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("ＤＳ顧客番号フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("dskokno");
        directDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("MT_DsKokyakuKanri");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_DSKOKNO_03);
        directDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter2(){

        try(ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_02)){

            int iCount = 0;
            for (MT_DsKokyakuKanri mT_DsKokyakuKanri : mT_DsKokyakuKanris) {

                assertNotEquals(mT_DsKokyakuKanri.getDskokno(), P_DSKOKNO_03);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("MT_DsKokyakuKanri");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_DSKOKNO_04);
        directDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){


        try(ExDBUpdatableResults<MT_DsKokyakuKanri> mT_DsKokyakuKanris = directDomManager
                .getDsKokyakuKanrisByKakutyoujobcd(P_JOB_CD_02)){

            int iCount = 0;
            for (MT_DsKokyakuKanri mT_DsKokyakuKanri : mT_DsKokyakuKanris) {

                assertNotEquals(mT_DsKokyakuKanri.getDskokno(), P_DSKOKNO_03);
                assertNotEquals(mT_DsKokyakuKanri.getDskokno(), P_DSKOKNO_04);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
