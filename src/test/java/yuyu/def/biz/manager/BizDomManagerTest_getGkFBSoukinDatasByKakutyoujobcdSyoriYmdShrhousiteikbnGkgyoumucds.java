package yuyu.def.biz.manager;

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

import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 外貨ＦＢ送金ファイル作成<br />
 * 外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日、支払方法指定区分、Ｄレート確定年月日、外貨業務コード）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds {

    @Inject
    BizDomManager bizDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGEE";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_01,
                BizDate.valueOf(20160401), C_ShrhousiteiKbn.FB_2EIGYOUBI, BizDate.valueOf(20160512), C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        BT_GkFBSoukinData gkFBSoukinData1 = new BT_GkFBSoukinData("1118120710");
        gkFBSoukinData1.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData1.setSyoriYmd(BizDate.valueOf(20160401));
        gkFBSoukinData1.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData1.setKeirisyono("11807111118");
        gkFBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData1.setBankcd("1001");
        gkFBSoukinData1.setSitencd("101");
        gkFBSoukinData1.setKouzano("10000000001");
        gkFBSoukinData1.setKzmeiginmei("biz");
        gkFBSoukinData1.setShrtuukasyu(C_Tuukasyu.valueOf("AUD"));

        bizDomManager.insert(gkFBSoukinData1);

        BT_GkFBSoukinData gkFBSoukinData2 = new BT_GkFBSoukinData("1118120711");
        gkFBSoukinData2.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData2.setSyoriYmd(BizDate.valueOf(20160410));
        gkFBSoukinData2.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData2.setKeirisyono("11807111141");
        gkFBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData2.setBankcd("1002");
        gkFBSoukinData2.setSitencd("102");
        gkFBSoukinData2.setKouzano("10000000002");
        gkFBSoukinData2.setKzmeiginmei("hozen");
        gkFBSoukinData2.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData2);

        BT_GkFBSoukinData gkFBSoukinData3 = new BT_GkFBSoukinData("1118120712");
        gkFBSoukinData3.setGkgyoumucd(C_Gkgyoumucd.BLNK);
        gkFBSoukinData3.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData3.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData3.setKeirisyono("11807111141");
        gkFBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData3.setBankcd("1002");
        gkFBSoukinData3.setSitencd("102");
        gkFBSoukinData3.setKouzano("10000000002");
        gkFBSoukinData3.setKzmeiginmei("hozen");
        gkFBSoukinData3.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData3);

        BT_GkFBSoukinData gkFBSoukinData4 = new BT_GkFBSoukinData("1118120713");
        gkFBSoukinData4.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData4.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData4.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData4.setKeirisyono("11807111141");
        gkFBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData4.setBankcd("1002");
        gkFBSoukinData4.setSitencd("102");
        gkFBSoukinData4.setKouzano("10000000002");
        gkFBSoukinData4.setKzmeiginmei("hozen");
        gkFBSoukinData4.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData4);

        BT_GkFBSoukinData gkFBSoukinData5 = new BT_GkFBSoukinData("1118120714");
        gkFBSoukinData5.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData5.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData5.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData5.setKeirisyono("11807111141");
        gkFBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData5.setBankcd("1002");
        gkFBSoukinData5.setSitencd("102");
        gkFBSoukinData5.setKouzano("10000000002");
        gkFBSoukinData5.setKzmeiginmei("hozen");
        gkFBSoukinData5.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData5);

        BT_GkFBSoukinData gkFBSoukinData6 = new BT_GkFBSoukinData("1118120715");
        gkFBSoukinData6.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData6.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData6.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData6.setKeirisyono("11807111130");
        gkFBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData6.setBankcd("1002");
        gkFBSoukinData6.setSitencd("102");
        gkFBSoukinData6.setKouzano("10000000002");
        gkFBSoukinData6.setKzmeiginmei("hozen");
        gkFBSoukinData6.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData6);

        BT_GkFBSoukinData gkFBSoukinData7 = new BT_GkFBSoukinData("1118120716");
        gkFBSoukinData7.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData7.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData7.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData7.setKeirisyono("11807111129");
        gkFBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData7.setBankcd("1002");
        gkFBSoukinData7.setSitencd("102");
        gkFBSoukinData7.setKouzano("10000000002");
        gkFBSoukinData7.setKzmeiginmei("siharai");
        gkFBSoukinData7.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData7);

        BT_GkFBSoukinData gkFBSoukinData8 = new BT_GkFBSoukinData("1118120717");
        gkFBSoukinData8.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData8.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData8.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData8.setKeirisyono("11807111129");
        gkFBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData8.setBankcd("1002");
        gkFBSoukinData8.setSitencd("102");
        gkFBSoukinData8.setKouzano("10000000002");
        gkFBSoukinData8.setKzmeiginmei("nenkin");
        gkFBSoukinData8.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData8);

        BT_GkFBSoukinData gkFBSoukinData9 = new BT_GkFBSoukinData("1118120718");
        gkFBSoukinData9.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData9.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData9.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData9.setKeirisyono("11807111129");
        gkFBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData9.setBankcd("1002");
        gkFBSoukinData9.setSitencd("102");
        gkFBSoukinData9.setKouzano("10000000004");
        gkFBSoukinData9.setKzmeiginmei("hozen");
        gkFBSoukinData9.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData9);

        BT_GkFBSoukinData gkFBSoukinData10 = new BT_GkFBSoukinData("1118120719");
        gkFBSoukinData10.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData10.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData10.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData10.setKeirisyono("11807111129");
        gkFBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData10.setBankcd("1002");
        gkFBSoukinData10.setSitencd("102");
        gkFBSoukinData10.setKouzano("10000000003");
        gkFBSoukinData10.setKzmeiginmei("hozen");
        gkFBSoukinData10.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData10);

        BT_GkFBSoukinData gkFBSoukinData11 = new BT_GkFBSoukinData("1118120720");
        gkFBSoukinData11.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData11.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData11.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData11.setKeirisyono("11807111129");
        gkFBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData11.setBankcd("1002");
        gkFBSoukinData11.setSitencd("104");
        gkFBSoukinData11.setKouzano("10000000002");
        gkFBSoukinData11.setKzmeiginmei("hozen");
        gkFBSoukinData11.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData11);

        BT_GkFBSoukinData gkFBSoukinData12 = new BT_GkFBSoukinData("1118120721");
        gkFBSoukinData12.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData12.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData12.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData12.setKeirisyono("11807111129");
        gkFBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData12.setBankcd("1002");
        gkFBSoukinData12.setSitencd("103");
        gkFBSoukinData12.setKouzano("10000000002");
        gkFBSoukinData12.setKzmeiginmei("hozen");
        gkFBSoukinData12.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData12);

        BT_GkFBSoukinData gkFBSoukinData13 = new BT_GkFBSoukinData("1118120722");
        gkFBSoukinData13.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData13.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData13.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData13.setKeirisyono("11807111129");
        gkFBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData13.setBankcd("1004");
        gkFBSoukinData13.setSitencd("102");
        gkFBSoukinData13.setKouzano("10000000002");
        gkFBSoukinData13.setKzmeiginmei("hozen");
        gkFBSoukinData13.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData13);

        BT_GkFBSoukinData gkFBSoukinData14 = new BT_GkFBSoukinData("1118120723");
        gkFBSoukinData14.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData14.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData14.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData14.setKeirisyono("11807111129");
        gkFBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData14.setBankcd("1003");
        gkFBSoukinData14.setSitencd("102");
        gkFBSoukinData14.setKouzano("10000000002");
        gkFBSoukinData14.setKzmeiginmei("hozen");
        gkFBSoukinData14.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData14);

        BT_GkFBSoukinData gkFBSoukinData15 = new BT_GkFBSoukinData("1118120724");
        gkFBSoukinData15.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData15.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData15.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData15.setKeirisyono("11807111129");
        gkFBSoukinData15.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData15.setBankcd("1002");
        gkFBSoukinData15.setSitencd("102");
        gkFBSoukinData15.setKouzano("10000000002");
        gkFBSoukinData15.setKzmeiginmei("hozen");
        gkFBSoukinData15.setShrtuukasyu(C_Tuukasyu.JPY);

        bizDomManager.insert(gkFBSoukinData15);

        BT_GkFBSoukinData gkFBSoukinData16 = new BT_GkFBSoukinData("1118120725");
        gkFBSoukinData16.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData16.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData16.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData16.setKeirisyono("11807111129");
        gkFBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData16.setBankcd("1002");
        gkFBSoukinData16.setSitencd("102");
        gkFBSoukinData16.setKouzano("10000000002");
        gkFBSoukinData16.setKzmeiginmei("hozen");
        gkFBSoukinData16.setShrtuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(gkFBSoukinData16);

        BT_GkFBSoukinData gkFBSoukinData17 = new BT_GkFBSoukinData("1118120726");
        gkFBSoukinData17.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData17.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData17.setDenymd(BizDate.valueOf(20160721));
        gkFBSoukinData17.setKeirisyono("11807111129");
        gkFBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData17.setBankcd("1002");
        gkFBSoukinData17.setSitencd("102");
        gkFBSoukinData17.setKouzano("10000000002");
        gkFBSoukinData17.setKzmeiginmei("hozen");
        gkFBSoukinData17.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData17);

        BT_GkFBSoukinData gkFBSoukinData18 = new BT_GkFBSoukinData("1118120727");
        gkFBSoukinData18.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData18.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData18.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData18.setKeirisyono("11807111129");
        gkFBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData18.setBankcd("1002");
        gkFBSoukinData18.setSitencd("102");
        gkFBSoukinData18.setKouzano("10000000002");
        gkFBSoukinData18.setKzmeiginmei("hozen");
        gkFBSoukinData18.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData18);

        BT_GkFBSoukinData gkFBSoukinData19 = new BT_GkFBSoukinData("1118120728");
        gkFBSoukinData19.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData19.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData19.setDenymd(BizDate.valueOf(20160720));
        gkFBSoukinData19.setKeirisyono("11807111129");
        gkFBSoukinData19.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData19.setBankcd("1002");
        gkFBSoukinData19.setSitencd("102");
        gkFBSoukinData19.setKouzano("10000000002");
        gkFBSoukinData19.setKzmeiginmei("hozen");
        gkFBSoukinData19.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData19);

        BT_GkFBSoukinData gkFBSoukinData20 = new BT_GkFBSoukinData("1118120729");
        gkFBSoukinData20.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData20.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData20.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData20.setKeirisyono("11807111129");
        gkFBSoukinData20.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData20.setBankcd("1002");
        gkFBSoukinData20.setSitencd("102");
        gkFBSoukinData20.setKouzano("10000000002");
        gkFBSoukinData20.setKzmeiginmei("hozen");
        gkFBSoukinData20.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData20);

        BT_GkFBSoukinData gkFBSoukinData21 = new BT_GkFBSoukinData("1118120730");
        gkFBSoukinData21.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData21.setSyoriYmd(BizDate.valueOf(20160414));
        gkFBSoukinData21.setDenymd(BizDate.valueOf(20160719));
        gkFBSoukinData21.setKeirisyono("11807111129");
        gkFBSoukinData21.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData21.setBankcd("1002");
        gkFBSoukinData21.setSitencd("102");
        gkFBSoukinData21.setKouzano("10000000002");
        gkFBSoukinData21.setKzmeiginmei("hozen");
        gkFBSoukinData21.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData21);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGkFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_01,
                BizDate.valueOf(20150401), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_01,
                BizDate.valueOf(20160401), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            BT_GkFBSoukinData gkFBSoukinData = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                gkFBSoukinData=iter.next();

                if (1 == iCount) {
                    Assert.assertEquals("1118120710", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160401), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals("11807111118", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("biz", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_01,
                BizDate.valueOf(20160414), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO, C_Gkgyoumucd.NENKINJIDOU3EIDO)) {

            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            BT_GkFBSoukinData gkFBSoukinData = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                gkFBSoukinData=iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("1118120730", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("1118120715", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111130", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("1118120714", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111141", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("1118120717", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("nenkin", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("1118120716", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("siharai", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("1118120719", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000003", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("1118120718", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("1118120721", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("103", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("1118120720", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("1118120723", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals("1118120722", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals("1118120725", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.EUR, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals("1118120724", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals("1118120729", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (15 == iCount) {

                    Assert.assertEquals("1118120727", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160719), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals("1118120728", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160720), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
                }

                if (17 == iCount) {

                    Assert.assertEquals("1118120726", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(BizDate.valueOf(20160414), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(BizDate.valueOf(20160721), gkFBSoukinData.getDenymd());
                    Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());

                    continue;
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
    @Transactional
    public void testSkippedFilter11() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_02,
                BizDate.valueOf(20160414), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO, C_Gkgyoumucd.NENKINJIDOU3EIDO)) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(17, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz107");
        filter.setRecoveryfilternm("ＦＢ送金データフィルタ");
        filter.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");
        bizDomManager.insert(filter);

        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Bz107");
        key1.setRecoveryfilterkey1("1118120714");
        key1.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_02,
                BizDate.valueOf(20160414), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO, C_Gkgyoumucd.NENKINJIDOU3EIDO)) {

            int iCount = 0;
            for(BT_GkFBSoukinData gkFBSoukinData : exDBResults) {

                Assert.assertNotEquals(gkFBSoukinData.getFbsoukindatasikibetukey(), "1118120714");

                iCount++;
            }

            Assert.assertEquals(16, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey key2 = new BT_SkipKey("A03");
        key2.setKakutyoujobcd(P_JOB_CD_02);
        key2.setRecoveryfilterid("Bz107");
        key2.setRecoveryfilterkey1("1118120715");
        key2.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key2);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(P_JOB_CD_02,
                BizDate.valueOf(20160414), C_ShrhousiteiKbn.FB_2EIGYOUBI, null, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO, C_Gkgyoumucd.NENKINJIDOU3EIDO)) {

            int iCount = 0;
            for(BT_GkFBSoukinData bT_GkFBSoukinData : exDBResults) {

                Assert.assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "1118120714");
                Assert.assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "1118120715");

                iCount++;
            }

            Assert.assertEquals(15, iCount);
        }
    }
}
