package yuyu.def.biz.manager;

import static org.junit.Assert.*;

import java.util.Iterator;

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

import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd {

    @Inject
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";

    private final static C_Gkgyoumucd[] dSyukouteikanriid1 = {C_Gkgyoumucd.NENKINJIDOU2EIGO, C_Gkgyoumucd.NENKINJIDOU3EIDO};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215), dSyukouteikanriid1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BM_FBSoukinListKanri fBSoukinListKanri1 = new BM_FBSoukinListKanri("1001","1000001");
        fBSoukinListKanri1.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        bizDomManager.insert(fBSoukinListKanri1);

        BM_FBSoukinListKanri fBSoukinListKanri2 = new BM_FBSoukinListKanri("1002","1000002");
        fBSoukinListKanri2.setTantositucd(C_Tantositucd.DIRECTSVKIKAKU);
        bizDomManager.insert(fBSoukinListKanri2);

        BM_FBSoukinListKanri fBSoukinListKanri3 = new BM_FBSoukinListKanri("1003","1000003");
        fBSoukinListKanri3.setTantositucd(C_Tantositucd.SIHARAIGYOUMU);
        bizDomManager.insert(fBSoukinListKanri3);

        BT_GkFBSoukinData gkFBSoukinData1 = new BT_GkFBSoukinData("201520161001");
        gkFBSoukinData1.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData1.setTantositucd(C_Tantositucd.BLNK0);
        gkFBSoukinData1.setSyoriYmd(BizDate.valueOf(20160215));
        gkFBSoukinData1.setKeirisyono("11807111118");
        gkFBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        gkFBSoukinData1.setBankcd("1001");
        gkFBSoukinData1.setSitencd("101");
        gkFBSoukinData1.setKouzano("10000000001");
        gkFBSoukinData1.setKzmeiginmei("biz");
        gkFBSoukinData1.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData1.setSyoricd("1001");
        gkFBSoukinData1.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData1);

        BT_GkFBSoukinData gkFBSoukinData2 = new BT_GkFBSoukinData("201520161002");
        gkFBSoukinData2.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData2.setTantositucd(C_Tantositucd.BLNK0);
        gkFBSoukinData2.setSyoriYmd(BizDate.valueOf(20160214));
        gkFBSoukinData2.setKeirisyono("11807111118");
        gkFBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        gkFBSoukinData2.setBankcd("1001");
        gkFBSoukinData2.setSitencd("101");
        gkFBSoukinData2.setKouzano("10000000001");
        gkFBSoukinData2.setKzmeiginmei("biz");
        gkFBSoukinData2.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData2.setSyoricd("1001");
        gkFBSoukinData2.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData2);

        BT_GkFBSoukinData gkFBSoukinData3 = new BT_GkFBSoukinData("201520161003");
        gkFBSoukinData3.setGkgyoumucd(C_Gkgyoumucd.BLNK);
        gkFBSoukinData3.setTantositucd(C_Tantositucd.BLNK0);
        gkFBSoukinData3.setSyoriYmd(BizDate.valueOf(20160215));
        gkFBSoukinData3.setKeirisyono("11807111118");
        gkFBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        gkFBSoukinData3.setBankcd("1001");
        gkFBSoukinData3.setSitencd("101");
        gkFBSoukinData3.setKouzano("10000000001");
        gkFBSoukinData3.setKzmeiginmei("biz");
        gkFBSoukinData3.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData3.setSyoricd("1001");
        gkFBSoukinData3.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData3);

        BT_GkFBSoukinData gkFBSoukinData4 = new BT_GkFBSoukinData("201520161004");
        gkFBSoukinData4.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData4.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData4.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData4.setKeirisyono("11807111129");
        gkFBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData4.setBankcd("1002");
        gkFBSoukinData4.setSitencd("102");
        gkFBSoukinData4.setKouzano("10000000002");
        gkFBSoukinData4.setKzmeiginmei("hozen");
        gkFBSoukinData4.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData4.setSyoricd("1003");
        gkFBSoukinData4.setSyorisosikicd("1000003");

        bizDomManager.insert(gkFBSoukinData4);

        BT_GkFBSoukinData gkFBSoukinData5 = new BT_GkFBSoukinData("201520161005");
        gkFBSoukinData5.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData5.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData5.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData5.setKeirisyono("11807111129");
        gkFBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData5.setBankcd("1002");
        gkFBSoukinData5.setSitencd("102");
        gkFBSoukinData5.setKouzano("10000000002");
        gkFBSoukinData5.setKzmeiginmei("hozen");
        gkFBSoukinData5.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData5.setSyoricd("1001");
        gkFBSoukinData5.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData5);

        BT_GkFBSoukinData gkFBSoukinData6 = new BT_GkFBSoukinData("201520161006");
        gkFBSoukinData6.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData6.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData6.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData6.setKeirisyono("11807111129");
        gkFBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        gkFBSoukinData6.setBankcd("1002");
        gkFBSoukinData6.setSitencd("102");
        gkFBSoukinData6.setKouzano("10000000002");
        gkFBSoukinData6.setKzmeiginmei("hozen");
        gkFBSoukinData6.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData6.setSyoricd("1002");
        gkFBSoukinData6.setSyorisosikicd("1000002");

        bizDomManager.insert(gkFBSoukinData6);

        BT_GkFBSoukinData gkFBSoukinData7 = new BT_GkFBSoukinData("201520161007");
        gkFBSoukinData7.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData7.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData7.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData7.setKeirisyono("11807111129");
        gkFBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData7.setBankcd("1002");
        gkFBSoukinData7.setSitencd("102");
        gkFBSoukinData7.setKouzano("10000000002");
        gkFBSoukinData7.setKzmeiginmei("hozen");
        gkFBSoukinData7.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData7.setSyoricd("1001");
        gkFBSoukinData7.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData7);

        BT_GkFBSoukinData gkFBSoukinData8 = new BT_GkFBSoukinData("201520161008");
        gkFBSoukinData8.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData8.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData8.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData8.setKeirisyono("11807111129");
        gkFBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinData8.setBankcd("1004");
        gkFBSoukinData8.setSitencd("102");
        gkFBSoukinData8.setKouzano("10000000002");
        gkFBSoukinData8.setKzmeiginmei("hozen");
        gkFBSoukinData8.setShrtuukasyu(C_Tuukasyu.AUD);
        gkFBSoukinData8.setSyoricd("1001");
        gkFBSoukinData8.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData8);

        BT_GkFBSoukinData gkFBSoukinData9 = new BT_GkFBSoukinData("201520161009");
        gkFBSoukinData9.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData9.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData9.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData9.setKeirisyono("11807111129");
        gkFBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData9.setBankcd("1002");
        gkFBSoukinData9.setSitencd("102");
        gkFBSoukinData9.setKouzano("10000000002");
        gkFBSoukinData9.setKzmeiginmei("hozen");
        gkFBSoukinData9.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData9.setSyoricd("1001");
        gkFBSoukinData9.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData9);

        BT_GkFBSoukinData gkFBSoukinData10 = new BT_GkFBSoukinData("201520161010");
        gkFBSoukinData10.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData10.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData10.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData10.setKeirisyono("11807111129");
        gkFBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData10.setBankcd("1002");
        gkFBSoukinData10.setSitencd("104");
        gkFBSoukinData10.setKouzano("10000000002");
        gkFBSoukinData10.setKzmeiginmei("hozen");
        gkFBSoukinData10.setShrtuukasyu(C_Tuukasyu.EUR);
        gkFBSoukinData10.setSyoricd("1001");
        gkFBSoukinData10.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData10);

        BT_GkFBSoukinData gkFBSoukinData11 = new BT_GkFBSoukinData("201520161011");
        gkFBSoukinData11.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        gkFBSoukinData11.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData11.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData11.setKeirisyono("11807111129");
        gkFBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData11.setBankcd("1004");
        gkFBSoukinData11.setSitencd("102");
        gkFBSoukinData11.setKouzano("10000000002");
        gkFBSoukinData11.setKzmeiginmei("hozen");
        gkFBSoukinData11.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData11.setSyoricd("1001");
        gkFBSoukinData11.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData11);

        BT_GkFBSoukinData gkFBSoukinData12 = new BT_GkFBSoukinData("201520161012");
        gkFBSoukinData12.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData12.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData12.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData12.setKeirisyono("11807111129");
        gkFBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData12.setBankcd("1003");
        gkFBSoukinData12.setSitencd("102");
        gkFBSoukinData12.setKouzano("10000000004");
        gkFBSoukinData12.setKzmeiginmei("hozen");
        gkFBSoukinData12.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData12.setSyoricd("1001");
        gkFBSoukinData12.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData12);

        BT_GkFBSoukinData gkFBSoukinData13 = new BT_GkFBSoukinData("201520161013");
        gkFBSoukinData13.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData13.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData13.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData13.setKeirisyono("11807111129");
        gkFBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData13.setBankcd("1004");
        gkFBSoukinData13.setSitencd("104");
        gkFBSoukinData13.setKouzano("10000000002");
        gkFBSoukinData13.setKzmeiginmei("hozen");
        gkFBSoukinData13.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData13.setSyoricd("1001");
        gkFBSoukinData13.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData13);

        BT_GkFBSoukinData gkFBSoukinData14 = new BT_GkFBSoukinData("201520161014");
        gkFBSoukinData14.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData14.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData14.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData14.setKeirisyono("11807111129");
        gkFBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData14.setBankcd("1004");
        gkFBSoukinData14.setSitencd("103");
        gkFBSoukinData14.setKouzano("10000000002");
        gkFBSoukinData14.setKzmeiginmei("siharai");
        gkFBSoukinData14.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData14.setSyoricd("1001");
        gkFBSoukinData14.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData14);

        BT_GkFBSoukinData gkFBSoukinData15 = new BT_GkFBSoukinData("201520161015");
        gkFBSoukinData15.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData15.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData15.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData15.setKeirisyono("11807111129");
        gkFBSoukinData15.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData15.setBankcd("1004");
        gkFBSoukinData15.setSitencd("104");
        gkFBSoukinData15.setKouzano("10000000004");
        gkFBSoukinData15.setKzmeiginmei("hozen");
        gkFBSoukinData15.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData15.setSyoricd("1001");
        gkFBSoukinData15.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData15);

        BT_GkFBSoukinData gkFBSoukinData16 = new BT_GkFBSoukinData("201520161016");
        gkFBSoukinData16.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData16.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData16.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData16.setKeirisyono("11807111141");
        gkFBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData16.setBankcd("1004");
        gkFBSoukinData16.setSitencd("104");
        gkFBSoukinData16.setKouzano("10000000003");
        gkFBSoukinData16.setKzmeiginmei("hozen");
        gkFBSoukinData16.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData16.setSyoricd("1001");
        gkFBSoukinData16.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData16);

        BT_GkFBSoukinData gkFBSoukinData17 = new BT_GkFBSoukinData("201520161017");
        gkFBSoukinData17.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData17.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData17.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData17.setKeirisyono("11807111129");
        gkFBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData17.setBankcd("1004");
        gkFBSoukinData17.setSitencd("104");
        gkFBSoukinData17.setKouzano("10000000004");
        gkFBSoukinData17.setKzmeiginmei("siharai");
        gkFBSoukinData17.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData17.setSyoricd("1001");
        gkFBSoukinData17.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData17);

        BT_GkFBSoukinData gkFBSoukinData18 = new BT_GkFBSoukinData("201520161018");
        gkFBSoukinData18.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData18.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData18.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData18.setKeirisyono("11807111129");
        gkFBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData18.setBankcd("1004");
        gkFBSoukinData18.setSitencd("104");
        gkFBSoukinData18.setKouzano("10000000004");
        gkFBSoukinData18.setKzmeiginmei("nenkin");
        gkFBSoukinData18.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData18.setSyoricd("1001");
        gkFBSoukinData18.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData18);

        BT_GkFBSoukinData gkFBSoukinData19 = new BT_GkFBSoukinData("201520161019");
        gkFBSoukinData19.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData19.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData19.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData19.setKeirisyono("11807111141");
        gkFBSoukinData19.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData19.setBankcd("1004");
        gkFBSoukinData19.setSitencd("104");
        gkFBSoukinData19.setKouzano("10000000004");
        gkFBSoukinData19.setKzmeiginmei("siharai");
        gkFBSoukinData19.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData19.setSyoricd("1001");
        gkFBSoukinData19.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData19);

        BT_GkFBSoukinData gkFBSoukinData20 = new BT_GkFBSoukinData("201520161020");
        gkFBSoukinData20.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData20.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData20.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData20.setKeirisyono("11807111130");
        gkFBSoukinData20.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData20.setBankcd("1004");
        gkFBSoukinData20.setSitencd("104");
        gkFBSoukinData20.setKouzano("10000000004");
        gkFBSoukinData20.setKzmeiginmei("siharai");
        gkFBSoukinData20.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData20.setSyoricd("1001");
        gkFBSoukinData20.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData20);

        BT_GkFBSoukinData gkFBSoukinData21 = new BT_GkFBSoukinData("201520161021");
        gkFBSoukinData21.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData21.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData21.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData21.setKeirisyono("11807111130");
        gkFBSoukinData21.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData21.setBankcd("1004");
        gkFBSoukinData21.setSitencd("104");
        gkFBSoukinData21.setKouzano("10000000004");
        gkFBSoukinData21.setKzmeiginmei("siharai");
        gkFBSoukinData21.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData21.setSyoricd("1001");
        gkFBSoukinData21.setSyorisosikicd("1000002");

        bizDomManager.insert(gkFBSoukinData21);

        BT_GkFBSoukinData gkFBSoukinData22 = new BT_GkFBSoukinData("201520161022");
        gkFBSoukinData22.setGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        gkFBSoukinData22.setTantositucd(C_Tantositucd.HOZENSIHARAISV);
        gkFBSoukinData22.setSyoriYmd(BizDate.valueOf(20160220));
        gkFBSoukinData22.setKeirisyono("11807111130");
        gkFBSoukinData22.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        gkFBSoukinData22.setBankcd("1004");
        gkFBSoukinData22.setSitencd("104");
        gkFBSoukinData22.setKouzano("10000000004");
        gkFBSoukinData22.setKzmeiginmei("siharai");
        gkFBSoukinData22.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinData22.setSyoricd("1002");
        gkFBSoukinData22.setSyorisosikicd("1000001");

        bizDomManager.insert(gkFBSoukinData22);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGkFBSoukinData());
        bizDomManager.delete(bizDomManager.getAllFBSoukinListKanri());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160228), dSyukouteikanriid1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {


        ExDBUpdatableResults<BT_GkFBSoukinData> beans = bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(P_KAKUTYOUJOBCD_01,
            BizDate.valueOf(20160215), dSyukouteikanriid1);

        int iCount = 0;
        for (BT_GkFBSoukinData gkFBSoukinData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("201520161001", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160215), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.BLNK0, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.BLNK, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1001", gkFBSoukinData.getBankcd());
                Assert.assertEquals("101", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000001", gkFBSoukinData.getKouzano());
                Assert.assertEquals("biz", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111118", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
        }

        Assert.assertEquals(1, iCount);
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBUpdatableResults<BT_GkFBSoukinData> beans = bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(P_KAKUTYOUJOBCD_01,
            BizDate.valueOf(20160220), dSyukouteikanriid1);

        int iCount = 0;
        for (BT_GkFBSoukinData gkFBSoukinData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("201520161004", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1003", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000003", gkFBSoukinData.getSyorisosikicd());
            }

            if (2 == iCount) {
                Assert.assertEquals("201520161006", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1002", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000002", gkFBSoukinData.getSyorisosikicd());
            }

            if (3 == iCount) {
                Assert.assertEquals("201520161005", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (4 == iCount) {
                Assert.assertEquals("201520161008", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (5 == iCount) {
                Assert.assertEquals("201520161007", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.AUD, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
            if (6 == iCount) {
                Assert.assertEquals("201520161010", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.EUR, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (7 == iCount) {
                Assert.assertEquals("201520161009", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1002", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (8 == iCount) {
                Assert.assertEquals("201520161012", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1003", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (9 == iCount) {
                Assert.assertEquals("201520161011", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU2EIGO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("102", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (10 == iCount) {
                Assert.assertEquals("201520161014", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("103", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("siharai", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (11 == iCount) {
                Assert.assertEquals("201520161013", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000002", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (12 == iCount) {
                Assert.assertEquals("201520161016", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000003", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111141", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (13 == iCount) {
                Assert.assertEquals("201520161015", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("hozen", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
            if (14 == iCount) {
                Assert.assertEquals("201520161018", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("nenkin", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
            if (15 == iCount) {
                Assert.assertEquals("201520161017", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("siharai", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111129", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }

            if (16 == iCount) {
                Assert.assertEquals("201520161020", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("siharai", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111130", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
            if (17 == iCount) {
                Assert.assertEquals("201520161019", gkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(C_Gkgyoumucd.NENKINJIDOU3EIDO, gkFBSoukinData.getGkgyoumucd());
                Assert.assertEquals(BizDate.valueOf(20160220), gkFBSoukinData.getSyoriYmd());
                Assert.assertEquals(C_Tantositucd.HOZENSIHARAISV, gkFBSoukinData.getTantositucd());
                Assert.assertEquals(C_ShrhousiteiKbn.FB_3EIGYOUBI, gkFBSoukinData.getShrhousiteikbn());
                Assert.assertEquals(C_Tuukasyu.JPY, gkFBSoukinData.getShrtuukasyu());
                Assert.assertEquals("1004", gkFBSoukinData.getBankcd());
                Assert.assertEquals("104", gkFBSoukinData.getSitencd());
                Assert.assertEquals("10000000004", gkFBSoukinData.getKouzano());
                Assert.assertEquals("siharai", gkFBSoukinData.getKzmeiginmei());
                Assert.assertEquals("11807111141", gkFBSoukinData.getKeirisyono());
                Assert.assertEquals("1001", gkFBSoukinData.getSyoricd());
                Assert.assertEquals("1000001", gkFBSoukinData.getSyorisosikicd());
            }
        }
        Assert.assertEquals(17, iCount);
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

        try(ExDBUpdatableResults<BT_GkFBSoukinData> beans = bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd("RGEE",
            BizDate.valueOf(20160220), dSyukouteikanriid1);){

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                iCount++;
            }
            Assert.assertEquals(17, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RGEE");
        skipKey1.setTableid("BT_GkFBSoukinData");
        skipKey1.setRecoveryfilterid("Bz107");
        skipKey1.setRecoveryfilterkey1("201520161004");

        bizDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz107");
        recoveryFilter1.setRecoveryfilternm("FB送金データフィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");

        bizDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20(){

        try(ExDBUpdatableResults<BT_GkFBSoukinData> beans = bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd("RGEE",
            BizDate.valueOf(20160220), dSyukouteikanriid1);){

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "201520161004");
                iCount++;
            }
            Assert.assertEquals(16, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey skipKey2 = new BT_SkipKey("A03");
        skipKey2.setKakutyoujobcd("RGEE");
        skipKey2.setTableid("BT_GkFBSoukinData");
        skipKey2.setRecoveryfilterid("Bz107");
        skipKey2.setRecoveryfilterkey1("201520161006");

        bizDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try(ExDBUpdatableResults<BT_GkFBSoukinData> beans = bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd("RGEE",
            BizDate.valueOf(20160220), dSyukouteikanriid1);){

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "201520161004");
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "201520161006");
                iCount++;
            }
            Assert.assertEquals(15, iCount);
        }
    }
}


