package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import static org.junit.Assert.*;

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

import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 保険契約異動情報ファイル抽出<br />
 * 契約保全手続履歴情報Beanリスト（大量）取得(拡張ジョブコード、処理年月日)<br />
 */
@RunWith(OrderedRunner.class)
public class KhHokenKykIdouFileTyusyutuDaoTest_getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn {

    @Inject
    private HozenDomManager hozenDomManager;
    @Inject
    private BizDomManager bizDomManager;
    @Inject
    KhHokenKykIdouFileTyusyutuDao khHokenKykIdouFileTyusyutuDao;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBP0";
    static String P_FILTER_ID = "Kh001";
    static BizDate P_SYORI_YMD_1 = BizDate.valueOf("20160420");
    static BizDate P_SYORI_YMD_2 = BizDate.valueOf("20160419");
    static BizDate P_SYORI_YMD_3 = BizDate.valueOf("20160418");
    static String P_SYONO_01 = "11807111130";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111118";

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        KhHokenKykIdouFileTyusyutuDao khHokenKykIdouFileTyusyutuDao = SWAKInjector.getInstance(KhHokenKykIdouFileTyusyutuDao.class);

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_01, P_SYORI_YMD_1)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        IT_KykKihon kykKihon = new IT_KykKihon("04", "11807111141");

        hozenDomManager.insert(kykKihon);

        IT_KykKihon kykKihon1 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("00000005");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki11.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki11.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("00000014");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki6.setSyorikbn(C_SyoriKbn.SIBOU);
        khTtdkRireki6.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("00000015");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki7.setSyorikbn(C_SyoriKbn.SBMUKOU);
        khTtdkRireki7.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("00000016");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki8.setSyorikbn(C_SyoriKbn.SBKYUUHUSHR);
        khTtdkRireki8.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("00000017");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki9.setSyorikbn(C_SyoriKbn.KOUDOSYOUGAI);
        khTtdkRireki9.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("00000018");
        khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki12.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkRireki12.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki20 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki20.setHenkousikibetukey("00000001");
        khTtdkRireki20.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki20.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki20.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        IT_KhTtdkRireki khTtdkRireki21 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki21.setHenkousikibetukey("00000002");
        khTtdkRireki21.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki21.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki21.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KAIYAKU);

        IT_KhTtdkRireki khTtdkRireki22 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki22.setHenkousikibetukey("00000003");
        khTtdkRireki22.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki22.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki22.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("11111111");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160420));
        khTtdkRireki1.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki1.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("22222222");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160421));
        khTtdkRireki2.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki2.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("33333333");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160420));
        khTtdkRireki3.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki3.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_YUUKOUSEL);

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("44444444");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160420));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.SIBOU);
        khTtdkRireki4.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("55555555");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160420));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki5.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("00000004");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki10.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki10.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("00000007");
        khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki13.setSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkRireki13.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki14 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki14.setHenkousikibetukey("00000008");
        khTtdkRireki14.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki14.setSyorikbn(C_SyoriKbn.MUKOU);
        khTtdkRireki14.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki15 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki15.setHenkousikibetukey("00000009");
        khTtdkRireki15.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki15.setSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkRireki15.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki16 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki16.setHenkousikibetukey("00000010");
        khTtdkRireki16.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki16.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkRireki16.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki17 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki17.setHenkousikibetukey("00000011");
        khTtdkRireki17.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki17.setSyorikbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        khTtdkRireki17.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki18 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki18.setHenkousikibetukey("00000012");
        khTtdkRireki18.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki18.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkRireki18.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        IT_KhTtdkRireki khTtdkRireki19 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki19.setHenkousikibetukey("00000013");
        khTtdkRireki19.setSyoriYmd(BizDate.valueOf(20160418));
        khTtdkRireki19.setSyorikbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        khTtdkRireki19.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        hozenDomManager.insert(kykKihon3);

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

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_01, P_SYORI_YMD_2)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_01, P_SYORI_YMD_1)) {

            int iCount = 0;
            for (KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean entityBean : exDBResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("11111111", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_01, P_SYORI_YMD_3)) {

            int iCount = 0;
            for (KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean entityBean : exDBResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000003", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_GENGAKU, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (2 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000002", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (3 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000001", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (4 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000013", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (5 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000012", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (6 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000011", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (7 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000010", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (8 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000009", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (9 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000008", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (10 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000007", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (11 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000018", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (12 == iCount) {

                    Assert.assertEquals("03", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_01, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("03", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_01, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000005", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (13 == iCount) {

                    Assert.assertEquals("01", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("01", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_03, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000004", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (14 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000017", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (15 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000016", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (16 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000015", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }

                if (17 == iCount) {

                    Assert.assertEquals("02", entityBean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KykKihon().getSyono());
                    Assert.assertEquals("02", entityBean.getIT_KhTtdkRireki().getKbnkey());
                    Assert.assertEquals(P_SYONO_02, entityBean.getIT_KhTtdkRireki().getSyono());
                    Assert.assertEquals("00000014", entityBean.getIT_KhTtdkRireki().getHenkousikibetukey());
                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entityBean.getIT_KhTtdkRireki().getGyoumuKousinKinou());
                }
            }

            Assert.assertEquals(17, iCount);
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
    public void testSkippedFilter11(){

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_02, P_SYORI_YMD_3)) {

            Iterator<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> iter = exDBResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(17, iCount);
        }
    }

    @Test
    @TestOrder(41)
    @Transactional
    public void testSkippedFilter12(){

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        bizDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBP0");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("03");
        skipKey1.setRecoveryfilterkey2("11807111130");

        bizDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_02, P_SYORI_YMD_3)) {

            int iCount = 0;
            for (KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean entityBean : exDBResults) {

                boolean result1 =
                    (entityBean.getIT_KykKihon().getKbnkey().equals("03")) &&
                    (entityBean.getIT_KykKihon().getSyono().equals(P_SYONO_01));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(16, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBP0");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("02");
        skipKey2.setRecoveryfilterkey2("11807111129");

        bizDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = khHokenKykIdouFileTyusyutuDao
            .getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(P_JOB_CD_02, P_SYORI_YMD_3)) {

            int iCount = 0;
            for (KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean entityBean : exDBResults) {

                boolean result1 =
                    (entityBean.getIT_KykKihon().getKbnkey().equals("03")) &&
                    (entityBean.getIT_KykKihon().getSyono().equals(P_SYONO_01));
                boolean result2 =
                    (entityBean.getIT_KykKihon().getKbnkey().equals("02")) &&
                    (entityBean.getIT_KykKihon().getSyono().equals(P_SYONO_02));
                assertFalse(result1);
                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(8, iCount);
        }
    }
}