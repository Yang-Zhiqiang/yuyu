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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 業務共通<br />
 * 外貨ＦＢ送金リスト作成<br />
 * 外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日、外貨業務コード）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri {

    @Inject
    BizDomManager bizDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGEE";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_GkFBSoukinData> exDBResults = bizDomManager
            .getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_01,
                BizDate.valueOf(20160406), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.BLNK)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        BT_GkFBSoukinData gkFBSoukinData1 = new BT_GkFBSoukinData("fb28");
        gkFBSoukinData1.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinData1.setSyoricd("sy01");
        gkFBSoukinData1.setSyorisosikicd("sys01");
        gkFBSoukinData1.setSyoriYmd(BizDate.valueOf(20160406));
        gkFBSoukinData1.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData1.setKeirisyono("10013022023");
        gkFBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData1.setBankcd("1001");
        gkFBSoukinData1.setSitencd("101");
        gkFBSoukinData1.setKouzano("10000000001");
        gkFBSoukinData1.setKzmeiginmei("AAAA");
        gkFBSoukinData1.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData1);

        BT_GkFBSoukinData gkFBSoukinData2 = new BT_GkFBSoukinData("fb27");
        gkFBSoukinData2.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinData2.setSyoricd("sy01");
        gkFBSoukinData2.setSyorisosikicd("sys01");
        gkFBSoukinData2.setSyoriYmd(BizDate.valueOf(20160407));
        gkFBSoukinData2.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData2.setKeirisyono("10013022023");
        gkFBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData2.setBankcd("1001");
        gkFBSoukinData2.setSitencd("101");
        gkFBSoukinData2.setKouzano("10000000001");
        gkFBSoukinData2.setKzmeiginmei("AAAA");
        gkFBSoukinData2.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData2);

        BT_GkFBSoukinData gkFBSoukinData3 = new BT_GkFBSoukinData("fb26");
        gkFBSoukinData3.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinData3.setSyoricd("sy01");
        gkFBSoukinData3.setSyorisosikicd("sys06");
        gkFBSoukinData3.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData3.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData3.setKeirisyono("10013022023");
        gkFBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData3.setBankcd("1001");
        gkFBSoukinData3.setSitencd("101");
        gkFBSoukinData3.setKouzano("10000000001");
        gkFBSoukinData3.setKzmeiginmei("AAAA");
        gkFBSoukinData3.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData3);

        BT_GkFBSoukinData gkFBSoukinData4 = new BT_GkFBSoukinData("fb25");
        gkFBSoukinData4.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinData4.setSyoricd("sy02");
        gkFBSoukinData4.setSyorisosikicd("sys01");
        gkFBSoukinData4.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData4.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData4.setKeirisyono("10013022023");
        gkFBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData4.setBankcd("1001");
        gkFBSoukinData4.setSitencd("101");
        gkFBSoukinData4.setKouzano("10000000001");
        gkFBSoukinData4.setKzmeiginmei("AAAA");
        gkFBSoukinData4.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData4);

        BT_GkFBSoukinData gkFBSoukinData5 = new BT_GkFBSoukinData("fb24");
        gkFBSoukinData5.setGkgyoumucd(C_Gkgyoumucd.valueOf("51602"));
        gkFBSoukinData5.setSyoricd("sy01");
        gkFBSoukinData5.setSyorisosikicd("sys01");
        gkFBSoukinData5.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData5.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData5.setKeirisyono("10013022023");
        gkFBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData5.setBankcd("1001");
        gkFBSoukinData5.setSitencd("101");
        gkFBSoukinData5.setKouzano("10000000001");
        gkFBSoukinData5.setKzmeiginmei("AAAA");
        gkFBSoukinData5.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData5);

        BT_GkFBSoukinData gkFBSoukinData6 = new BT_GkFBSoukinData("fb23");
        gkFBSoukinData6.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData6.setSyoricd("sy01");
        gkFBSoukinData6.setSyorisosikicd("sys05");
        gkFBSoukinData6.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData6.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData6.setKeirisyono("10013022021");
        gkFBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData6.setBankcd("1001");
        gkFBSoukinData6.setSitencd("101");
        gkFBSoukinData6.setKouzano("10000000001");
        gkFBSoukinData6.setKzmeiginmei("AAAA");
        gkFBSoukinData6.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData6);

        BT_GkFBSoukinData gkFBSoukinData7 = new BT_GkFBSoukinData("fb22");
        gkFBSoukinData7.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData7.setSyoricd("sy01");
        gkFBSoukinData7.setSyorisosikicd("sys04");
        gkFBSoukinData7.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData7.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData7.setKeirisyono("10013022021");
        gkFBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData7.setBankcd("1001");
        gkFBSoukinData7.setSitencd("101");
        gkFBSoukinData7.setKouzano("10000000001");
        gkFBSoukinData7.setKzmeiginmei("AAAA");
        gkFBSoukinData7.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData7);

        BT_GkFBSoukinData gkFBSoukinData8 = new BT_GkFBSoukinData("fb21");
        gkFBSoukinData8.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData8.setSyoricd("sy01");
        gkFBSoukinData8.setSyorisosikicd("sys03");
        gkFBSoukinData8.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData8.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData8.setKeirisyono("10013022021");
        gkFBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData8.setBankcd("1001");
        gkFBSoukinData8.setSitencd("101");
        gkFBSoukinData8.setKouzano("10000000001");
        gkFBSoukinData8.setKzmeiginmei("AAAA");
        gkFBSoukinData8.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData8);

        BT_GkFBSoukinData gkFBSoukinData9 = new BT_GkFBSoukinData("fb20");
        gkFBSoukinData9.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData9.setSyoricd("sy01");
        gkFBSoukinData9.setSyorisosikicd("sys02");
        gkFBSoukinData9.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData9.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData9.setKeirisyono("10013022021");
        gkFBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData9.setBankcd("1001");
        gkFBSoukinData9.setSitencd("101");
        gkFBSoukinData9.setKouzano("10000000001");
        gkFBSoukinData9.setKzmeiginmei("AAAA");
        gkFBSoukinData9.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData9);

        BT_GkFBSoukinData gkFBSoukinData10 = new BT_GkFBSoukinData("fb19");
        gkFBSoukinData10.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData10.setSyoricd("sy01");
        gkFBSoukinData10.setSyorisosikicd("sys01");
        gkFBSoukinData10.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData10.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData10.setKeirisyono("10013022021");
        gkFBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData10.setBankcd("1001");
        gkFBSoukinData10.setSitencd("101");
        gkFBSoukinData10.setKouzano("10000000001");
        gkFBSoukinData10.setKzmeiginmei("AAAA");
        gkFBSoukinData10.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData10);

        BT_GkFBSoukinData gkFBSoukinData11 = new BT_GkFBSoukinData("fb18");
        gkFBSoukinData11.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData11.setSyoricd("sy01");
        gkFBSoukinData11.setSyorisosikicd("sys01");
        gkFBSoukinData11.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData11.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData11.setKeirisyono("10013022021");
        gkFBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData11.setBankcd("1001");
        gkFBSoukinData11.setSitencd("101");
        gkFBSoukinData11.setKouzano("10000000001");
        gkFBSoukinData11.setKzmeiginmei("AAAA");
        gkFBSoukinData11.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData11);

        BT_GkFBSoukinData gkFBSoukinData12 = new BT_GkFBSoukinData("fb17");
        gkFBSoukinData12.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData12.setSyoricd("sy01");
        gkFBSoukinData12.setSyorisosikicd("sys01");
        gkFBSoukinData12.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData12.setDenymd(BizDate.valueOf(20160406));
        gkFBSoukinData12.setKeirisyono("10013022021");
        gkFBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData12.setBankcd("1001");
        gkFBSoukinData12.setSitencd("101");
        gkFBSoukinData12.setKouzano("10000000001");
        gkFBSoukinData12.setKzmeiginmei("AAAA");
        gkFBSoukinData12.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData12);

        BT_GkFBSoukinData gkFBSoukinData13 = new BT_GkFBSoukinData("fb16");
        gkFBSoukinData13.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData13.setSyoricd("sy01");
        gkFBSoukinData13.setSyorisosikicd("sys01");
        gkFBSoukinData13.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData13.setDenymd(BizDate.valueOf(20160405));
        gkFBSoukinData13.setKeirisyono("10013022021");
        gkFBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData13.setBankcd("1001");
        gkFBSoukinData13.setSitencd("101");
        gkFBSoukinData13.setKouzano("10000000001");
        gkFBSoukinData13.setKzmeiginmei("AAAA");
        gkFBSoukinData13.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData13);

        BT_GkFBSoukinData gkFBSoukinData14 = new BT_GkFBSoukinData("fb15");
        gkFBSoukinData14.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinData14.setSyoricd("sy01");
        gkFBSoukinData14.setSyorisosikicd("sys01");
        gkFBSoukinData14.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData14.setDenymd(BizDate.valueOf(20160405));
        gkFBSoukinData14.setKeirisyono("10013022021");
        gkFBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData14.setBankcd("1001");
        gkFBSoukinData14.setSitencd("101");
        gkFBSoukinData14.setKouzano("10000000001");
        gkFBSoukinData14.setKzmeiginmei("AAAA");
        gkFBSoukinData14.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData14);

        BT_GkFBSoukinData gkFBSoukinData15 = new BT_GkFBSoukinData("fb14");
        gkFBSoukinData15.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData15.setSyoricd("sy01");
        gkFBSoukinData15.setSyorisosikicd("sys01");
        gkFBSoukinData15.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData15.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData15.setKeirisyono("10013022021");
        gkFBSoukinData15.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData15.setBankcd("1001");
        gkFBSoukinData15.setSitencd("101");
        gkFBSoukinData15.setKouzano("10000000001");
        gkFBSoukinData15.setKzmeiginmei("AAAA");
        gkFBSoukinData15.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData15);

        BT_GkFBSoukinData gkFBSoukinData16 = new BT_GkFBSoukinData("fb13");
        gkFBSoukinData16.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData16.setSyoricd("sy01");
        gkFBSoukinData16.setSyorisosikicd("sys01");
        gkFBSoukinData16.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData16.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData16.setKeirisyono("10013022021");
        gkFBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData16.setBankcd("1001");
        gkFBSoukinData16.setSitencd("101");
        gkFBSoukinData16.setKouzano("10000000001");
        gkFBSoukinData16.setKzmeiginmei("AAAA");
        gkFBSoukinData16.setShrtuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(gkFBSoukinData16);

        BT_GkFBSoukinData gkFBSoukinData17 = new BT_GkFBSoukinData("fb12");
        gkFBSoukinData17.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData17.setSyoricd("sy01");
        gkFBSoukinData17.setSyorisosikicd("sys01");
        gkFBSoukinData17.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData17.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData17.setKeirisyono("10013022021");
        gkFBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData17.setBankcd("1001");
        gkFBSoukinData17.setSitencd("101");
        gkFBSoukinData17.setKouzano("10000000001");
        gkFBSoukinData17.setKzmeiginmei("AAAA");
        gkFBSoukinData17.setShrtuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(gkFBSoukinData17);

        BT_GkFBSoukinData gkFBSoukinData18 = new BT_GkFBSoukinData("fb11");
        gkFBSoukinData18.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData18.setSyoricd("sy01");
        gkFBSoukinData18.setSyorisosikicd("sys01");
        gkFBSoukinData18.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData18.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData18.setKeirisyono("10013022021");
        gkFBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData18.setBankcd("1003");
        gkFBSoukinData18.setSitencd("101");
        gkFBSoukinData18.setKouzano("10000000001");
        gkFBSoukinData18.setKzmeiginmei("AAAA");
        gkFBSoukinData18.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData18);

        BT_GkFBSoukinData gkFBSoukinData19 = new BT_GkFBSoukinData("fb10");
        gkFBSoukinData19.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData19.setSyoricd("sy01");
        gkFBSoukinData19.setSyorisosikicd("sys01");
        gkFBSoukinData19.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData19.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData19.setKeirisyono("10013022021");
        gkFBSoukinData19.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData19.setBankcd("1002");
        gkFBSoukinData19.setSitencd("101");
        gkFBSoukinData19.setKouzano("10000000001");
        gkFBSoukinData19.setKzmeiginmei("AAAA");
        gkFBSoukinData19.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData19);

        BT_GkFBSoukinData gkFBSoukinData20 = new BT_GkFBSoukinData("fb09");
        gkFBSoukinData20.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData20.setSyoricd("sy01");
        gkFBSoukinData20.setSyorisosikicd("sys01");
        gkFBSoukinData20.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData20.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData20.setKeirisyono("10013022021");
        gkFBSoukinData20.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData20.setBankcd("1001");
        gkFBSoukinData20.setSitencd("103");
        gkFBSoukinData20.setKouzano("10000000001");
        gkFBSoukinData20.setKzmeiginmei("AAAA");
        gkFBSoukinData20.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData20);

        BT_GkFBSoukinData gkFBSoukinData21 = new BT_GkFBSoukinData("fb08");
        gkFBSoukinData21.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData21.setSyoricd("sy01");
        gkFBSoukinData21.setSyorisosikicd("sys01");
        gkFBSoukinData21.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData21.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData21.setKeirisyono("10013022021");
        gkFBSoukinData21.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData21.setBankcd("1001");
        gkFBSoukinData21.setSitencd("102");
        gkFBSoukinData21.setKouzano("10000000001");
        gkFBSoukinData21.setKzmeiginmei("AAAA");
        gkFBSoukinData21.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData21);

        BT_GkFBSoukinData gkFBSoukinData22 = new BT_GkFBSoukinData("fb07");
        gkFBSoukinData22.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData22.setSyoricd("sy01");
        gkFBSoukinData22.setSyorisosikicd("sys01");
        gkFBSoukinData22.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData22.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData22.setKeirisyono("10013022021");
        gkFBSoukinData22.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData22.setBankcd("1001");
        gkFBSoukinData22.setSitencd("101");
        gkFBSoukinData22.setKouzano("10000000003");
        gkFBSoukinData22.setKzmeiginmei("AAAA");
        gkFBSoukinData22.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData22);

        BT_GkFBSoukinData gkFBSoukinData23 = new BT_GkFBSoukinData("fb06");
        gkFBSoukinData23.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData23.setSyoricd("sy01");
        gkFBSoukinData23.setSyorisosikicd("sys01");
        gkFBSoukinData23.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData23.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData23.setKeirisyono("10013022021");
        gkFBSoukinData23.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData23.setBankcd("1001");
        gkFBSoukinData23.setSitencd("101");
        gkFBSoukinData23.setKouzano("10000000002");
        gkFBSoukinData23.setKzmeiginmei("AAAA");
        gkFBSoukinData23.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData23);

        BT_GkFBSoukinData gkFBSoukinData24 = new BT_GkFBSoukinData("fb05");
        gkFBSoukinData24.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData24.setSyoricd("sy01");
        gkFBSoukinData24.setSyorisosikicd("sys01");
        gkFBSoukinData24.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData24.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData24.setKeirisyono("10013022021");
        gkFBSoukinData24.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData24.setBankcd("1001");
        gkFBSoukinData24.setSitencd("101");
        gkFBSoukinData24.setKouzano("10000000001");
        gkFBSoukinData24.setKzmeiginmei("CCCC");
        gkFBSoukinData24.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData24);

        BT_GkFBSoukinData gkFBSoukinData25 = new BT_GkFBSoukinData("fb04");
        gkFBSoukinData25.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData25.setSyoricd("sy01");
        gkFBSoukinData25.setSyorisosikicd("sys01");
        gkFBSoukinData25.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData25.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData25.setKeirisyono("10013022021");
        gkFBSoukinData25.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData25.setBankcd("1001");
        gkFBSoukinData25.setSitencd("101");
        gkFBSoukinData25.setKouzano("10000000001");
        gkFBSoukinData25.setKzmeiginmei("BBBB");
        gkFBSoukinData25.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData25);

        BT_GkFBSoukinData gkFBSoukinData26 = new BT_GkFBSoukinData("fb03");
        gkFBSoukinData26.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData26.setSyoricd("sy01");
        gkFBSoukinData26.setSyorisosikicd("sys01");
        gkFBSoukinData26.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData26.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData26.setKeirisyono("10013022023");
        gkFBSoukinData26.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData26.setBankcd("1001");
        gkFBSoukinData26.setSitencd("101");
        gkFBSoukinData26.setKouzano("10000000001");
        gkFBSoukinData26.setKzmeiginmei("AAAA");
        gkFBSoukinData26.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData26);

        BT_GkFBSoukinData gkFBSoukinData27 = new BT_GkFBSoukinData("fb02");
        gkFBSoukinData27.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData27.setSyoricd("sy01");
        gkFBSoukinData27.setSyorisosikicd("sys01");
        gkFBSoukinData27.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData27.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData27.setKeirisyono("10013022022");
        gkFBSoukinData27.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData27.setBankcd("1001");
        gkFBSoukinData27.setSitencd("101");
        gkFBSoukinData27.setKouzano("10000000001");
        gkFBSoukinData27.setKzmeiginmei("AAAA");
        gkFBSoukinData27.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData27);

        BT_GkFBSoukinData gkFBSoukinData28 = new BT_GkFBSoukinData("fb01");
        gkFBSoukinData28.setGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        gkFBSoukinData28.setSyoricd("sy01");
        gkFBSoukinData28.setSyorisosikicd("sys01");
        gkFBSoukinData28.setSyoriYmd(BizDate.valueOf(20160408));
        gkFBSoukinData28.setDenymd(BizDate.valueOf(20160404));
        gkFBSoukinData28.setKeirisyono("10013022021");
        gkFBSoukinData28.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData28.setBankcd("1001");
        gkFBSoukinData28.setSitencd("101");
        gkFBSoukinData28.setKouzano("10000000001");
        gkFBSoukinData28.setKzmeiginmei("AAAA");
        gkFBSoukinData28.setShrtuukasyu(C_Tuukasyu.AUD);

        bizDomManager.insert(gkFBSoukinData28);

        BM_FBSoukinListKanri fBSoukinListKanri1 = new BM_FBSoukinListKanri("sy01", "sys05");
        fBSoukinListKanri1.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinListKanri1.setGkfbmeisaisyoruicd(C_SyoruiCdKbn.WF_QRSEAL);

        bizDomManager.insert(fBSoukinListKanri1);

        BM_FBSoukinListKanri fBSoukinListKanri2 = new BM_FBSoukinListKanri("sy01", "sys04");
        fBSoukinListKanri2.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinListKanri2.setGkfbmeisaisyoruicd(C_SyoruiCdKbn.WF_HYOUSI);

        bizDomManager.insert(fBSoukinListKanri2);

        BM_FBSoukinListKanri fBSoukinListKanri3 = new BM_FBSoukinListKanri("sy01", "sys03");
        fBSoukinListKanri3.setTantositucd(C_Tantositucd.DIRECTSVKIKAKU);
        fBSoukinListKanri3.setGkfbmeisaisyoruicd(C_SyoruiCdKbn.BLNK);

        bizDomManager.insert(fBSoukinListKanri3);

        BM_FBSoukinListKanri fBSoukinListKanri4 = new BM_FBSoukinListKanri("sy01", "sys02");
        fBSoukinListKanri4.setTantositucd(C_Tantositucd.SIHARAIGYOUMU);
        fBSoukinListKanri4.setGkfbmeisaisyoruicd(C_SyoruiCdKbn.BLNK);

        bizDomManager.insert(fBSoukinListKanri4);

        BM_FBSoukinListKanri fBSoukinListKanri5 = new BM_FBSoukinListKanri("sy01", "sys01");
        fBSoukinListKanri5.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinListKanri5.setGkfbmeisaisyoruicd(C_SyoruiCdKbn.BLNK);

        bizDomManager.insert(fBSoukinListKanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGkFBSoukinData());
        bizDomManager.delete(bizDomManager.getAllFBSoukinListKanri());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults = bizDomManager
            .getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_01,
                BizDate.valueOf(20160406), C_Gkgyoumucd.NENKINJIDOU3EIDO)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults = bizDomManager
            .getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_01,
                BizDate.valueOf(20160406), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.BLNK)) {

            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            BT_GkFBSoukinData gkFBSoukinData = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                gkFBSoukinData=iter.next();

                Assert.assertEquals("fb28", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                Assert.assertEquals(BizDate.valueOf(20160406), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(BizDate.valueOf(20160406), gkFBSoukinData.getDenymd());
                Assert.assertEquals(C_Gkgyoumucd.SKFUSEIRITUPHENKIN, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(C_Tuukasyu.USD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("10013022023", gkFBSoukinData.getKeirisyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_01,
                BizDate.valueOf(20160408), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            BT_GkFBSoukinData gkFBSoukinData = null;
            while (iter.hasNext()) {

                iCount++;
                gkFBSoukinData = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("fb01", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("fb02", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022022", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("fb03", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022023", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("fb04", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("BBBB", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("fb05", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("CCCC", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("fb06", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("fb07", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000003", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("fb08", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("fb09", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("103", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("fb10", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals("fb11", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1003", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals("fb12", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.EUR, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals("fb13", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.USD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals("fb14", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (15 == iCount) {

                    Assert.assertEquals("fb15", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160405), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.SKFUSEIRITUPHENKIN, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals("fb16", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160405), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (17 == iCount) {

                    Assert.assertEquals("fb17", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160406), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (18 == iCount) {

                    Assert.assertEquals("fb18", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (19 == iCount) {

                    Assert.assertEquals("fb19", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys01", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (20 == iCount) {

                    Assert.assertEquals("fb20", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys02", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (21 == iCount) {

                    Assert.assertEquals("fb21", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys03", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (22 == iCount) {

                    Assert.assertEquals("fb22", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys04", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }

                if (23 == iCount) {

                    Assert.assertEquals("fb23", gkFBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("sy01", gkFBSoukinData.getSyoricd());
                    Assert.assertEquals("sys05", gkFBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160408), gkFBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals(BizDate.valueOf(20160404), gkFBSoukinData.getDenymd());
                    Assert.assertEquals(C_Gkgyoumucd.KHSISIHARAI, gkFBSoukinData.getGkgyoumucd());
                    Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                    Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                    Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                    Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                    Assert.assertEquals("AAAA", gkFBSoukinData.getKzmeiginmei());
                    Assert.assertEquals("10013022021", gkFBSoukinData.getKeirisyono());

                    continue;
                }
            }

            Assert.assertEquals(23, iCount);
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
    public void testSkippedFilter11() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_02,
                BizDate.valueOf(20160408), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(23, iCount);
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
        key1.setRecoveryfilterkey1("fb16");
        key1.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_02,
                BizDate.valueOf(20160408), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            int iCount = 0;
            for(BT_GkFBSoukinData gkFBSoukinData : exDBResults) {

                Assert.assertNotEquals("fb16", gkFBSoukinData.getFbsoukindatasikibetukey());

                iCount++;
            }

            Assert.assertEquals(22, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey key2 = new BT_SkipKey("A03");
        key2.setKakutyoujobcd(P_JOB_CD_02);
        key2.setRecoveryfilterid("Bz107");
        key2.setRecoveryfilterkey1("fb15");
        key2.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key2);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3() {

        try (ExDBResults<BT_GkFBSoukinData> exDBResults =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(P_JOB_CD_02,
                BizDate.valueOf(20160408), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, C_Gkgyoumucd.KHSISIHARAI,
                C_Gkgyoumucd.NENKINJIDOU2EIGO)) {

            int iCount = 0;
            for(BT_GkFBSoukinData bT_GkFBSoukinData : exDBResults) {

                Assert.assertNotEquals("fb16", bT_GkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertNotEquals("fb15", bT_GkFBSoukinData.getFbsoukindatasikibetukey());

                iCount++;
            }

            Assert.assertEquals(21, iCount);
        }
    }
}
