package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金支払備金集計表作成<br />
 * 保険金給付金備金管理テーブルエンティティリスト（大量）取得　決算基準日且つ備金例外区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RCA0";
    static String P_FILTER_ID = "Si001";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160302), C_BknrigiKbn.ADD)) {

            Assert.assertFalse(exDBRes_JT_SiBikinkanri.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("SK001", "11807111118", BizDate.valueOf(20160302), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri1.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.BLNK);
        siBikinkanri1.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("SK002", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY03");
        siBikinkanri2.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri2.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("SK003", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY02");
        siBikinkanri3.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri3.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("SK004", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.SIBOUKARIUKETUKE, BizDate.valueOf(20160303), "KY01");
        siBikinkanri4.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri4.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("SK005", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160303), "KY01");
        siBikinkanri5.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri5.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("SK006", "11807111129", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri6.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.IRYOUHOKEN);
        siBikinkanri6.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri6.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("SK007", "11807111141", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri7.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINNENKIN);
        siBikinkanri7.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri7.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("SK008", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri8.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri8.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        siBikinkanri8.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri8);

        JT_SiBikinkanri siBikinkanri9 = new JT_SiBikinkanri("SK009", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri9.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri9.setKbnkeirisegcd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siBikinkanri9.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri9);

        JT_SiBikinkanri siBikinkanri10 = new JT_SiBikinkanri("SK010", "11807111118", BizDate.valueOf(20160303), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri10.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri10.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri10.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri10);

        JT_SiBikinkanri siBikinkanri11 = new JT_SiBikinkanri("SK011", "11807111118", BizDate.valueOf(20160304), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri11.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.KOJINHOKEN);
        siBikinkanri11.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri11.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri11);

        JT_SiBikinkanri siBikinkanri12 = new JT_SiBikinkanri("SK012", "11807111118", BizDate.valueOf(20160302), C_BkncdKbn.GENGK, BizDate.valueOf(20160303), "KY01");
        siBikinkanri12.setSyouhnsyuruikbn(C_SyouhnsyuruiKbn.BLNK);
        siBikinkanri12.setKbnkeirisegcd(C_Segcd.BLNK);
        siBikinkanri12.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri12);
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160307), C_BknrigiKbn.ADD)) {

            Assert.assertFalse(exDBRes_JT_SiBikinkanri.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160302), C_BknrigiKbn.ADD)) {

            int iCount = 0;
            Iterator<JT_SiBikinkanri> iter = exDBRes_JT_SiBikinkanri.iterator();
            JT_SiBikinkanri jT_SiBikinkanri = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SiBikinkanri = iter.next();

                Assert.assertEquals("SK001", jT_SiBikinkanri.getSkno());
                Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160302), jT_SiBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                Assert.assertEquals(C_SyouhnsyuruiKbn.BLNK, jT_SiBikinkanri.getSyouhnsyuruikbn());
                Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160303), C_BknrigiKbn.ADD)) {

            int iCount = 0;
            Iterator<JT_SiBikinkanri> iter = exDBRes_JT_SiBikinkanri.iterator();
            JT_SiBikinkanri jT_SiBikinkanri = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SiBikinkanri = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("SK010", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("SK009", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("SK008", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("SK007", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111141", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINNENKIN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("SK006", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111129", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.IRYOUHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("SK005", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("SK004", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUKARIUKETUKE, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY01", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("SK003", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY02", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("SK002", jT_SiBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", jT_SiBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, jT_SiBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160303), jT_SiBikinkanri.getBknkktymd());
                    Assert.assertEquals("KY03", jT_SiBikinkanri.getKyuuhucd());
                    Assert.assertEquals(C_SyouhnsyuruiKbn.KOJINHOKEN, jT_SiBikinkanri.getSyouhnsyuruikbn());
                    Assert.assertEquals(C_Segcd.BLNK, jT_SiBikinkanri.getKbnkeirisegcd());

                    continue;
                }

            }

            Assert.assertEquals(9, iCount);
        }
    }
    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SkipKey> skipKeyList = bizDomManager.getAllSkipKey();
        if(skipKeyList.size() > 0){
            bizDomManager.delete(skipKeyList);
        }
        List<BM_RecoveryFilter> recoveryFilterList = bizDomManager.getAllRecoveryFilter();
        if(recoveryFilterList.size() > 0){
            bizDomManager.delete(recoveryFilterList);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160303), C_BknrigiKbn.ADD)) {

            int iCount = 0;
            Iterator<JT_SiBikinkanri> iter = exDBRes_JT_SiBikinkanri.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(9, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("請求基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("syono");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("skno");

        siharaiDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("JT_SiBikinkanri");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1("11807111129");
        bT_SkipKey1.setRecoveryfilterkey2("SK006");

        siharaiDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160303), C_BknrigiKbn.ADD)) {

            int iCount = 0;
            for (JT_SiBikinkanri jT_SiBikinkanri : exDBRes_JT_SiBikinkanri) {

                boolean result1 =
                    (!jT_SiBikinkanri.getSkno().equals("SK006")) &&
                    (!jT_SiBikinkanri.getSyono().equals("11807111129"));

                assertTrue(result1);

                iCount++;
            }

            Assert.assertEquals(8, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("JT_SiBikinkanri");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1("11807111141");
        bT_SkipKey2.setRecoveryfilterkey2("SK007");

        siharaiDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<JT_SiBikinkanri> exDBRes_JT_SiBikinkanri =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160303), C_BknrigiKbn.ADD)) {

            int iCount = 0;
            for (JT_SiBikinkanri jT_SiBikinkanri : exDBRes_JT_SiBikinkanri) {

                boolean result1 =
                    (!jT_SiBikinkanri.getSkno().equals("SK006")) &&
                    (!jT_SiBikinkanri.getSyono().equals("11807111129"));

                boolean result2 =
                    (!jT_SiBikinkanri.getSkno().equals("SK007")) &&
                    (!jT_SiBikinkanri.getSyono().equals("11807111141"));

                assertTrue(result1 && result2);

                iCount++;
            }

            Assert.assertEquals(7, iCount);
        }
    }


    @Transactional
    public static void deleteTestSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getAllSiBikinkanri();
        if(siBikinkanriList.size() > 0){
            siharaiDomManager.delete(siBikinkanriList);
        }
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SkipKey> skipKeyList = bizDomManager.getAllSkipKey();
        if(skipKeyList.size() > 0){
            bizDomManager.delete(skipKeyList);
        }
        List<BM_RecoveryFilter> recoveryFilterList = bizDomManager.getAllRecoveryFilter();
        if(recoveryFilterList.size() > 0){
            bizDomManager.delete(recoveryFilterList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
