package yuyu.def.biz.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_SougouKobetuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 振替伝票テーブル情報付加処理<br />
 * 振替伝票作成用テーブルエンティティリスト(大量)取得(拡張ジョブコード、処理年月日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate {

    @Inject
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGBI";
    static String P_DENRENNO_001 = "11807111221";
    static String P_DENRENNO_002 = "11807111222";
    static String P_DENRENNO_011 = "11807111231";
    static Integer P_EDANO_01 = new Integer(0);
    static String P_SYONO_001 = "11807111392";
    static String P_SYONO_002 = "11807111118";
    static BizDate P_DENYMD_01 = BizDate.valueOf("20160309");
    static BizDate P_DENYMD_02 = BizDate.valueOf("20160310");
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160310");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160322");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("19940103");

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)) {

            Assert.assertFalse(bT_HuriDenpyouResults.iterator().hasNext());

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        }
        catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHuriDenpyou());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1(){


        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(bT_HuriDenpyouResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {


        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)) {

            int iCount = 0;
            Iterator<BT_HuriDenpyou> iter = bT_HuriDenpyouResults.iterator();
            BT_HuriDenpyou bT_HuriDenpyou = null;
            while (iter.hasNext()) {

                bT_HuriDenpyou = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                Assert.assertEquals(P_DENRENNO_011, bT_HuriDenpyou.getDenrenno());
                Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                Assert.assertEquals(P_SYORIYMD_02, bT_HuriDenpyou.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {


        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<BT_HuriDenpyou> iter = bT_HuriDenpyouResults.iterator();
            BT_HuriDenpyou bT_HuriDenpyou = null;
            while (iter.hasNext()) {

                bT_HuriDenpyou = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111233", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.GYOUMUIGAI, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111277", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("001", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111230", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.IMUSATEI, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111229", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180505), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }
                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111228", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.ENKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111227", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.AUD, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111226", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1001", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111225", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKINYOKU, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111174", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.KZHURIKAE_SIS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111224", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5001", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111223", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100001", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111222", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.BLNK, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals(C_DensysKbn.AGKANRI, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111221", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(601), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, bT_HuriDenpyou.getDensyskbn());
                    Assert.assertEquals("11807111118", bT_HuriDenpyou.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_HuriDenpyou.getEdano());
                    Assert.assertEquals(P_SYORIYMD_01, bT_HuriDenpyou.getSyoriYmd());
                    Assert.assertEquals(C_HuridensksKbn.HOZENYAKAN, bT_HuriDenpyou.getHuridenskskbn());
                    Assert.assertEquals("002", bT_HuriDenpyou.getHuridenatesakicd());
                    Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, bT_HuriDenpyou.getTantocd());
                    Assert.assertEquals(BizDate.valueOf(20180506), bT_HuriDenpyou.getDenymd());
                    Assert.assertEquals(C_HuriDenpyouKykTuukaKbn.GAIKA, bT_HuriDenpyou.getHuridenpyoukyktuukakbn());
                    Assert.assertEquals(C_Tuukasyu.JPY, bT_HuriDenpyou.getTuukasyu());
                    Assert.assertEquals("1002", bT_HuriDenpyou.getDengyoumucd());
                    Assert.assertEquals(C_DenshrhouKbn.FBSOUKIN, bT_HuriDenpyou.getDenshrhoukbn());
                    Assert.assertEquals(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, bT_HuriDenpyou.getDensyorisyousaikbn());
                    Assert.assertEquals("5002", bT_HuriDenpyou.getSyoricd());
                    Assert.assertEquals("11807100002", bT_HuriDenpyou.getKeirisyono());
                    Assert.assertEquals(C_SougouKobetuKbn.KOBETUDENPYOU, bT_HuriDenpyou.getSougoukobetukbn());
                    Assert.assertEquals(new Integer(602), bT_HuriDenpyou.getFurikaedenpyouitirenno());


                    continue;
                }
            }

            Assert.assertEquals(14, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    @Transactional
    public void testSkippedFilter11(){

        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_02, P_SYORIYMD_01)) {

            Iterator<BT_HuriDenpyou> iter = bT_HuriDenpyouResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(14, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12(){

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20(){

        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_02, P_SYORIYMD_01)) {

            int iCount = 0;
            for (BT_HuriDenpyou entity : bT_HuriDenpyouResults) {

                assertNotEquals(entity.getDensyskbn(), C_DensysKbn.NENKIN);
                assertNotEquals(entity.getDenrenno(), P_DENRENNO_002);

                iCount++;
            }

            Assert.assertEquals(13, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try (ExDBUpdatableResults<BT_HuriDenpyou> bT_HuriDenpyouResults =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(P_KAKUTYOUJOBCD_02, P_SYORIYMD_01)) {

            int iCount = 0;
            for (BT_HuriDenpyou entity : bT_HuriDenpyouResults) {

                assertNotEquals(entity.getDensyskbn(), C_DensysKbn.NENKIN);
                assertNotEquals(entity.getDenrenno(), P_DENRENNO_002);
                assertNotEquals(entity.getDensyskbn(), C_DensysKbn.AGKANRI);
                assertNotEquals(entity.getDenrenno(), P_DENRENNO_001);

                iCount++;
            }

            Assert.assertEquals(12, iCount);
        }
    }
}
