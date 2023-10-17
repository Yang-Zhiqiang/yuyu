package yuyu.batch.hozen.khinterf.khdairitenkykidoudtldbsks.dba;

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
 * 代理店契約異動明細ＤＢ作成<br />
 * 契約保全手続履歴テーブルエンティティリスト（大量）取得(拡張ジョブコード、処理年月日FROM、処理年月日TO)<br />
 */
@RunWith(OrderedRunner.class)
public class KhDairitenKykIdouDtlDBSksDaoTest_getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn {

    @Inject
    private HozenDomManager hozenDomManager;
    @Inject
    private BizDomManager bizDomManager;
    @Inject
    private KhDairitenKykIdouDtlDBSksDao khDairitenKykIdouDtlDBSksDao;


    @BeforeClass
    @Transactional
    public static void TestDataInsert() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        KhDairitenKykIdouDtlDBSksDao khDairitenKykIdouDtlDBSksDao = SWAKInjector.getInstance(KhDairitenKykIdouDtlDBSksDao.class);


        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160301), BizDate.valueOf(20160301))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("HK000000001");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki3.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki3.setGyoumuKousinKinou("khjyuusyohenkou");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("HK000000002");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160314));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki4.setGyoumuKousinKinou("khmeigihenkou");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("HK000000003");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160313));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki5.setGyoumuKousinKinou("khkaiyaku");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("HK000000004");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160313));
        khTtdkRireki6.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki6.setGyoumuKousinKinou("khgengaku");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("HK000000005");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160313));
        khTtdkRireki7.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki7.setGyoumuKousinKinou("khsiteidairitokuyakuhuka");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("HK000000006");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160313));
        khTtdkRireki8.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki8.setGyoumuKousinKinou("khsiteidairitokuyakuhuka");

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("HK000000007");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160313));
        khTtdkRireki9.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki9.setGyoumuKousinKinou("khsiteidairitokuyakuhuka");

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("HK000000008");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki10.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki10.setGyoumuKousinKinou("khkaigomaebaraitkhenkou");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("HK000000009");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki11.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki11.setGyoumuKousinKinou("khseinengappiseiteisei");

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("HK000000010");
        khTtdkRireki12.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki12.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki12.setGyoumuKousinKinou("khkeiyakutorikesi");

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("HK000000011");
        khTtdkRireki13.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki13.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkRireki13.setGyoumuKousinKinou("khkeiyakutorikesi");

        IT_KhTtdkRireki khTtdkRireki14 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki14.setHenkousikibetukey("HK000000012");
        khTtdkRireki14.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki14.setSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkRireki14.setGyoumuKousinKinou("khkeiyakutorikesi");

        IT_KhTtdkRireki khTtdkRireki15 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki15.setHenkousikibetukey("HK000000013");
        khTtdkRireki15.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki15.setSyorikbn(C_SyoriKbn.MUKOU);
        khTtdkRireki15.setGyoumuKousinKinou("khkeiyakutorikesi");

        IT_KhTtdkRireki khTtdkRireki16 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki16.setHenkousikibetukey("HK000000014");
        khTtdkRireki16.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki16.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki16.setGyoumuKousinKinou("khsyoukensaihakkou");

        IT_KhTtdkRireki khTtdkRireki17 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki17.setHenkousikibetukey("HK000000015");
        khTtdkRireki17.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki17.setSyorikbn(C_SyoriKbn.SIBOU);
        khTtdkRireki17.setGyoumuKousinKinou("khsiharaikekkatorikomi");

        IT_KhTtdkRireki khTtdkRireki18 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki18.setHenkousikibetukey("HK000000016");
        khTtdkRireki18.setSyoriYmd(BizDate.valueOf(20160315));
        khTtdkRireki18.setSyorikbn(C_SyoriKbn.KOUDOSYOUGAI);
        khTtdkRireki18.setGyoumuKousinKinou("khsiharaikekkatorikomi");

        IT_KhTtdkRireki khTtdkRireki19 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki19.setHenkousikibetukey("HK000000017");
        khTtdkRireki19.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki19.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki19.setGyoumuKousinKinou("khmeigihenkou");

        IT_KhTtdkRireki khTtdkRireki20 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki20.setHenkousikibetukey("HK000000018");
        khTtdkRireki20.setSyoriYmd(BizDate.valueOf(20160229));
        khTtdkRireki20.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki20.setGyoumuKousinKinou("khmeigihenkou");

        IT_KhTtdkRireki khTtdkRireki21 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki21.setHenkousikibetukey("HK000000019");
        khTtdkRireki21.setSyoriYmd(BizDate.valueOf(20160302));
        khTtdkRireki21.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki21.setGyoumuKousinKinou("khmeigihenkou");

        IT_KhTtdkRireki khTtdkRireki22 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki22.setHenkousikibetukey("HK000000020");
        khTtdkRireki22.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki22.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki22.setGyoumuKousinKinou("khnyuukin");

        IT_KhTtdkRireki khTtdkRireki23 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki23.setHenkousikibetukey("HK000000021");
        khTtdkRireki23.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki23.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki23.setGyoumuKousinKinou("khkeiyakutorikesi");

        IT_KhTtdkRireki khTtdkRireki24 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki24.setHenkousikibetukey("HK000000022");
        khTtdkRireki24.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki24.setSyorikbn(C_SyoriKbn.CLGOFF);
        khTtdkRireki24.setGyoumuKousinKinou("khonlinenyuukin");

        IT_KhTtdkRireki khTtdkRireki25 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki25.setHenkousikibetukey("HK000000023");
        khTtdkRireki25.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki25.setSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkRireki25.setGyoumuKousinKinou("khonlinenyuukin");

        IT_KhTtdkRireki khTtdkRireki26 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki26.setHenkousikibetukey("HK000000024");
        khTtdkRireki26.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki26.setSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkRireki26.setGyoumuKousinKinou("khonlinenyuukin");

        IT_KhTtdkRireki khTtdkRireki27 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki27.setHenkousikibetukey("HK000000025");
        khTtdkRireki27.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki27.setSyorikbn(C_SyoriKbn.MUKOU);
        khTtdkRireki27.setGyoumuKousinKinou("khonlinenyuukin");

        IT_KhTtdkRireki khTtdkRireki28 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki28.setHenkousikibetukey("HK000000026");
        khTtdkRireki28.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki28.setSyorikbn(C_SyoriKbn.KAIYAKU_SAIKENSYA);
        khTtdkRireki28.setGyoumuKousinKinou("khsyoukensaihakkou");

        IT_KhTtdkRireki khTtdkRireki29 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki29.setHenkousikibetukey("HK000000027");
        khTtdkRireki29.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki29.setSyorikbn(C_SyoriKbn.BLNK);
        khTtdkRireki29.setGyoumuKousinKinou("khnyuukintorikesi");

        IT_KhTtdkRireki khTtdkRireki30 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki30.setHenkousikibetukey("HK000000028");
        khTtdkRireki30.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki30.setSyorikbn(C_SyoriKbn.KAIYAKU_KEIYAKUSYASIBOU);
        khTtdkRireki30.setGyoumuKousinKinou("khsiharaikekkatorikomi");

        IT_KhTtdkRireki khTtdkRireki31 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki31.setHenkousikibetukey("HK000000029");
        khTtdkRireki31.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki31.setSyorikbn(C_SyoriKbn.SIBOU);
        khTtdkRireki31.setGyoumuKousinKinou("khkariuketeisei");

        IT_KhTtdkRireki khTtdkRireki32 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki32.setHenkousikibetukey("HK000000030");
        khTtdkRireki32.setSyoriYmd(BizDate.valueOf(20160301));
        khTtdkRireki32.setSyorikbn(C_SyoriKbn.KOUDOSYOUGAI);
        khTtdkRireki32.setGyoumuKousinKinou("khkariuketeisei");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("HK000000001");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160328));
        khTtdkRireki2.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki2.setGyoumuKousinKinou("khjyuusyohenkou");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("HK000000001");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160329));
        khTtdkRireki1.setSyorikbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
        khTtdkRireki1.setGyoumuKousinKinou("khjyuusyohenkou");

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
    @Transactional
    public void noResult1() {

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160226), BizDate.valueOf(20160227))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160301), BizDate.valueOf(20160301))) {

            int iCount = 0;
            for (IT_KhTtdkRireki entity : exDBResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000017", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160301"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU, entity.getGyoumuKousinKinou());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160303), BizDate.valueOf(20160329))) {

            int iCount = 0;
            for (IT_KhTtdkRireki entity : exDBResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000004", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160313"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_GENGAKU, entity.getGyoumuKousinKinou());


                }

                if (2 == iCount) {


                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000003", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160313"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KAIYAKU, entity.getGyoumuKousinKinou());
                }

                if (3 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000007", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160313"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA, entity.getGyoumuKousinKinou());
                }

                if (4 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000006", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160313"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA, entity.getGyoumuKousinKinou());
                }


                if (5 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000005", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160313"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA, entity.getGyoumuKousinKinou());
                }

                if (6 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000002", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160314"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU, entity.getGyoumuKousinKinou());
                }

                if (7 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000001", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU, entity.getGyoumuKousinKinou());
                }

                if (8 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000008", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU, entity.getGyoumuKousinKinou());
                }

                if (9 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000013", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.MUKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI, entity.getGyoumuKousinKinou());
                }

                if (10 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000012", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.KAIJO, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI, entity.getGyoumuKousinKinou());
                }

                if (11 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000011", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.KYKTORIKESI, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI, entity.getGyoumuKousinKinou());
                }

                if (12 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000010", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.CLGOFF, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI, entity.getGyoumuKousinKinou());
                }

                if (13 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000009", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI, entity.getGyoumuKousinKinou());
                }

                if (14 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000016", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.KOUDOSYOUGAI, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entity.getGyoumuKousinKinou());

                }

                if (15 == iCount) {


                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000015", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SIBOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI, entity.getGyoumuKousinKinou());
                }

                if (16 == iCount) {

                    Assert.assertEquals("11807111118", entity.getSyono());
                    Assert.assertEquals("HK000000014", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160315"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.BLNK, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU, entity.getGyoumuKousinKinou());
                }

                if (17 == iCount) {

                    Assert.assertEquals("11807111129", entity.getSyono());
                    Assert.assertEquals("HK000000001", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160328"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU, entity.getGyoumuKousinKinou());
                }

                if (18 == iCount) {

                    Assert.assertEquals("11807111130", entity.getSyono());
                    Assert.assertEquals("HK000000001", entity.getHenkousikibetukey());
                    Assert.assertEquals(BizDate.valueOf("20160329"), entity.getSyoriYmd());
                    Assert.assertEquals(C_SyoriKbn.SKSYOUKENSAIHAKKOU, entity.getSyorikbn());

                    Assert.assertEquals(IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU, entity.getGyoumuKousinKinou());
                }

            }

            Assert.assertEquals(18, iCount);
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

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160303), BizDate.valueOf(20160329))) {

            Iterator<IT_KhTtdkRireki> iter = exDBResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(18, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12(){
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        bizDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBOE");
        skipKey1.setTableid("IT_KhTtdkRireki");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("03");
        skipKey1.setRecoveryfilterkey2("11807111130");

        bizDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160303), BizDate.valueOf(20160329))) {

            int iCount = 0;
            for (IT_KhTtdkRireki entity : exDBResults) {

                assertNotEquals(entity.getSyono(), "11807111130");

                iCount++;
            }

            Assert.assertEquals(17, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBOE");
        skipKey2.setTableid("IT_KhTtdkRireki");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("02");
        skipKey2.setRecoveryfilterkey2("11807111129");

        bizDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try (ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao
            .getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn("RBOE", BizDate.valueOf(20160303), BizDate.valueOf(20160329))) {

            int iCount = 0;
            for (IT_KhTtdkRireki entity : exDBResults) {

                assertNotEquals(entity.getSyono(), "11807111130");
                assertNotEquals(entity.getSyono(), "11807111129");

                iCount++;
            }

            Assert.assertEquals(16, iCount);
        }
    }
}