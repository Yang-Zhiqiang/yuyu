package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;
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

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金データテーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd {

    @Inject
    BizDomManager bizDomManager;

    private static String P_JOB_CD_02 = "RGDE";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd("JCD01", BizDate.valueOf(20160215), C_Gyoumucd.BLNK)) {

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


        BT_FBSoukinData fBSoukinData1 = new BT_FBSoukinData("FB001");
        fBSoukinData1.setSyoricd("1001");
        fBSoukinData1.setSyorisosikicd("1000001");
        fBSoukinData1.setSyoriYmd(BizDate.valueOf("20160215"));
        fBSoukinData1.setGyoumucd(C_Gyoumucd.BLNK);
        fBSoukinData1.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData1.setBankcd("1001");
        fBSoukinData1.setSitencd("101");
        fBSoukinData1.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData1.setKouzano("101");
        fBSoukinData1.setKzmeiginmkn("あああ");
        fBSoukinData1.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData1);

        BT_FBSoukinData fBSoukinData2 = new BT_FBSoukinData("FB002");
        fBSoukinData2.setSyoricd("1001");
        fBSoukinData2.setSyorisosikicd("1000001");
        fBSoukinData2.setSyoriYmd(BizDate.valueOf("20160216"));
        fBSoukinData2.setGyoumucd(C_Gyoumucd.BLNK);
        fBSoukinData2.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData2.setBankcd("1001");
        fBSoukinData2.setSitencd("101");
        fBSoukinData2.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData2.setKouzano("101");
        fBSoukinData2.setKzmeiginmkn("あああ");
        fBSoukinData2.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData2);

        BT_FBSoukinData fBSoukinData3 = new BT_FBSoukinData("FB003");
        fBSoukinData3.setSyoricd("1001");
        fBSoukinData3.setSyorisosikicd("1000001");
        fBSoukinData3.setSyoriYmd(BizDate.valueOf("20160215"));
        fBSoukinData3.setGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        fBSoukinData3.setTantositucd(C_Tantositucd.BLNK0);
        fBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData3.setBankcd("1001");
        fBSoukinData3.setSitencd("101");
        fBSoukinData3.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData3.setKouzano("101");
        fBSoukinData3.setKzmeiginmkn("あああ");
        fBSoukinData3.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData3);

        BT_FBSoukinData fBSoukinData4 = new BT_FBSoukinData("FB004");
        fBSoukinData4.setSyoricd("1001");
        fBSoukinData4.setSyorisosikicd("1000001");
        fBSoukinData4.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData4.setGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        fBSoukinData4.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData4.setBankcd("1001");
        fBSoukinData4.setSitencd("101");
        fBSoukinData4.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData4.setKouzano("101");
        fBSoukinData4.setKzmeiginmkn("あああ");
        fBSoukinData4.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData4);

        BT_FBSoukinData fBSoukinData5 = new BT_FBSoukinData("FB005");
        fBSoukinData5.setSyoricd("1002");
        fBSoukinData5.setSyorisosikicd("1000002");
        fBSoukinData5.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData5.setGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        fBSoukinData5.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData5.setBankcd("1001");
        fBSoukinData5.setSitencd("101");
        fBSoukinData5.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData5.setKouzano("101");
        fBSoukinData5.setKzmeiginmkn("あああ");
        fBSoukinData5.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData5);

        BT_FBSoukinData fBSoukinData6 = new BT_FBSoukinData("FB006");
        fBSoukinData6.setSyoricd("1003");
        fBSoukinData6.setSyorisosikicd("1000003");
        fBSoukinData6.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData6.setGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        fBSoukinData6.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData6.setBankcd("1001");
        fBSoukinData6.setSitencd("101");
        fBSoukinData6.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData6.setKouzano("101");
        fBSoukinData6.setKzmeiginmkn("あああ");
        fBSoukinData6.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData6);

        BT_FBSoukinData fBSoukinData7 = new BT_FBSoukinData("FB007");
        fBSoukinData7.setSyoricd("1001");
        fBSoukinData7.setSyorisosikicd("1000001");
        fBSoukinData7.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData7.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData7.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData7.setBankcd("1001");
        fBSoukinData7.setSitencd("101");
        fBSoukinData7.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData7.setKouzano("101");
        fBSoukinData7.setKzmeiginmkn("あああ");
        fBSoukinData7.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData7);

        BT_FBSoukinData fBSoukinData8 = new BT_FBSoukinData("FB008");
        fBSoukinData8.setSyoricd("1001");
        fBSoukinData8.setSyorisosikicd("1000001");
        fBSoukinData8.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData8.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData8.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        fBSoukinData8.setBankcd("1001");
        fBSoukinData8.setSitencd("101");
        fBSoukinData8.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData8.setKouzano("101");
        fBSoukinData8.setKzmeiginmkn("あああ");
        fBSoukinData8.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData8);

        BT_FBSoukinData fBSoukinData9 = new BT_FBSoukinData("FB009");
        fBSoukinData9.setSyoricd("1001");
        fBSoukinData9.setSyorisosikicd("1000001");
        fBSoukinData9.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData9.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData9.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        fBSoukinData9.setBankcd("1001");
        fBSoukinData9.setSitencd("101");
        fBSoukinData9.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData9.setKouzano("101");
        fBSoukinData9.setKzmeiginmkn("あああ");
        fBSoukinData9.setKeirisyono("11807111211");

        bizDomManager.insert(fBSoukinData9);

        BT_FBSoukinData fBSoukinData10 = new BT_FBSoukinData("FB010");
        fBSoukinData10.setSyoricd("1001");
        fBSoukinData10.setSyorisosikicd("1000001");
        fBSoukinData10.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData10.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData10.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData10.setBankcd("1003");
        fBSoukinData10.setSitencd("101");
        fBSoukinData10.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData10.setKouzano("101");
        fBSoukinData10.setKzmeiginmkn("あああ");
        fBSoukinData10.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData10);

        BT_FBSoukinData fBSoukinData11 = new BT_FBSoukinData("FB011");
        fBSoukinData11.setSyoricd("1001");
        fBSoukinData11.setSyorisosikicd("1000001");
        fBSoukinData11.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData11.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData11.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData11.setBankcd("1002");
        fBSoukinData11.setSitencd("101");
        fBSoukinData11.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData11.setKouzano("101");
        fBSoukinData11.setKzmeiginmkn("あああ");
        fBSoukinData11.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData11);

        BT_FBSoukinData fBSoukinData12 = new BT_FBSoukinData("FB012");
        fBSoukinData12.setSyoricd("1001");
        fBSoukinData12.setSyorisosikicd("1000001");
        fBSoukinData12.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData12.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData12.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData12.setBankcd("1001");
        fBSoukinData12.setSitencd("101");
        fBSoukinData12.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData12.setKouzano("101");
        fBSoukinData12.setKzmeiginmkn("あああ");
        fBSoukinData12.setKeirisyono("11807111211");

        bizDomManager.insert(fBSoukinData12);

        BT_FBSoukinData fBSoukinData13 = new BT_FBSoukinData("FB013");
        fBSoukinData13.setSyoricd("1001");
        fBSoukinData13.setSyorisosikicd("1000001");
        fBSoukinData13.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData13.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData13.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData13.setBankcd("1003");
        fBSoukinData13.setSitencd("103");
        fBSoukinData13.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData13.setKouzano("101");
        fBSoukinData13.setKzmeiginmkn("あああ");
        fBSoukinData13.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData13);

        BT_FBSoukinData fBSoukinData14 = new BT_FBSoukinData("FB014");
        fBSoukinData14.setSyoricd("1001");
        fBSoukinData14.setSyorisosikicd("1000001");
        fBSoukinData14.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData14.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData14.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData14.setBankcd("1003");
        fBSoukinData14.setSitencd("102");
        fBSoukinData14.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData14.setKouzano("101");
        fBSoukinData14.setKzmeiginmkn("あああ");
        fBSoukinData14.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData14);

        BT_FBSoukinData fBSoukinData16 = new BT_FBSoukinData("FB016");
        fBSoukinData16.setSyoricd("1001");
        fBSoukinData16.setSyorisosikicd("1000001");
        fBSoukinData16.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData16.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData16.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData16.setBankcd("1003");
        fBSoukinData16.setSitencd("103");
        fBSoukinData16.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData16.setKouzano("101");
        fBSoukinData16.setKzmeiginmkn("あああ");
        fBSoukinData16.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData16);

        BT_FBSoukinData fBSoukinData17 = new BT_FBSoukinData("FB017");
        fBSoukinData17.setSyoricd("1001");
        fBSoukinData17.setSyorisosikicd("1000001");
        fBSoukinData17.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData17.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData17.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData17.setBankcd("1003");
        fBSoukinData17.setSitencd("103");
        fBSoukinData17.setYokinkbn(C_YokinKbn.HUTUU);
        fBSoukinData17.setKouzano("101");
        fBSoukinData17.setKzmeiginmkn("あああ");
        fBSoukinData17.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData17);

        BT_FBSoukinData fBSoukinData18 = new BT_FBSoukinData("FB018");
        fBSoukinData18.setSyoricd("1001");
        fBSoukinData18.setSyorisosikicd("1000001");
        fBSoukinData18.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData18.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData18.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData18.setBankcd("1003");
        fBSoukinData18.setSitencd("103");
        fBSoukinData18.setYokinkbn(C_YokinKbn.BLNK);
        fBSoukinData18.setKouzano("101");
        fBSoukinData18.setKzmeiginmkn("あああ");
        fBSoukinData18.setKeirisyono("11807111211");

        bizDomManager.insert(fBSoukinData18);

        BT_FBSoukinData fBSoukinData19 = new BT_FBSoukinData("FB019");
        fBSoukinData19.setSyoricd("1001");
        fBSoukinData19.setSyorisosikicd("1000001");
        fBSoukinData19.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData19.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData19.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData19.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData19.setBankcd("1003");
        fBSoukinData19.setSitencd("103");
        fBSoukinData19.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData19.setKouzano("103");
        fBSoukinData19.setKzmeiginmkn("あああ");
        fBSoukinData19.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData19);

        BT_FBSoukinData fBSoukinData20 = new BT_FBSoukinData("FB020");
        fBSoukinData20.setSyoricd("1001");
        fBSoukinData20.setSyorisosikicd("1000001");
        fBSoukinData20.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData20.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData20.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData20.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData20.setBankcd("1003");
        fBSoukinData20.setSitencd("103");
        fBSoukinData20.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData20.setKouzano("102");
        fBSoukinData20.setKzmeiginmkn("あああ");
        fBSoukinData20.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData20);

        BT_FBSoukinData fBSoukinData21 = new BT_FBSoukinData("FB021");
        fBSoukinData21.setSyoricd("1001");
        fBSoukinData21.setSyorisosikicd("1000001");
        fBSoukinData21.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData21.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData21.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData21.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData21.setBankcd("1003");
        fBSoukinData21.setSitencd("103");
        fBSoukinData21.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData21.setKouzano("101");
        fBSoukinData21.setKzmeiginmkn("あああ");
        fBSoukinData21.setKeirisyono("11807111211");

        bizDomManager.insert(fBSoukinData21);

        BT_FBSoukinData fBSoukinData22 = new BT_FBSoukinData("FB022");
        fBSoukinData22.setSyoricd("1001");
        fBSoukinData22.setSyorisosikicd("1000001");
        fBSoukinData22.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData22.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData22.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData22.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData22.setBankcd("1003");
        fBSoukinData22.setSitencd("103");
        fBSoukinData22.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData22.setKouzano("103");
        fBSoukinData22.setKzmeiginmkn("ううう");
        fBSoukinData22.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData22);

        BT_FBSoukinData fBSoukinData23 = new BT_FBSoukinData("FB023");
        fBSoukinData23.setSyoricd("1001");
        fBSoukinData23.setSyorisosikicd("1000001");
        fBSoukinData23.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData23.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData23.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData23.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData23.setBankcd("1003");
        fBSoukinData23.setSitencd("103");
        fBSoukinData23.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData23.setKouzano("103");
        fBSoukinData23.setKzmeiginmkn("いいい");
        fBSoukinData23.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData23);

        BT_FBSoukinData fBSoukinData25 = new BT_FBSoukinData("FB025");
        fBSoukinData25.setSyoricd("1001");
        fBSoukinData25.setSyorisosikicd("1000001");
        fBSoukinData25.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData25.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData25.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData25.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData25.setBankcd("1003");
        fBSoukinData25.setSitencd("103");
        fBSoukinData25.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData25.setKouzano("103");
        fBSoukinData25.setKzmeiginmkn("ううう");
        fBSoukinData25.setKeirisyono("11807111222");

        bizDomManager.insert(fBSoukinData25);

        BT_FBSoukinData fBSoukinData26 = new BT_FBSoukinData("FB026");
        fBSoukinData26.setSyoricd("1001");
        fBSoukinData26.setSyorisosikicd("1000001");
        fBSoukinData26.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData26.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData26.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData26.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData26.setBankcd("1003");
        fBSoukinData26.setSitencd("103");
        fBSoukinData26.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData26.setKouzano("103");
        fBSoukinData26.setKzmeiginmkn("ううう");
        fBSoukinData26.setKeirisyono("11807111211");

        bizDomManager.insert(fBSoukinData26);

        BT_FBSoukinData fBSoukinData27 = new BT_FBSoukinData("FB027");
        fBSoukinData27.setSyoricd("1001");
        fBSoukinData27.setSyorisosikicd("1000001");
        fBSoukinData27.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData27.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData27.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData27.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData27.setBankcd("1003");
        fBSoukinData27.setSitencd("103");
        fBSoukinData27.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData27.setKouzano("103");
        fBSoukinData27.setKzmeiginmkn("ううう");
        fBSoukinData27.setKeirisyono("11807111233");

        bizDomManager.insert(fBSoukinData27);

        BT_FBSoukinData fBSoukinData28 = new BT_FBSoukinData("FB028");
        fBSoukinData28.setSyoricd("1003");
        fBSoukinData28.setSyorisosikicd("1000001");
        fBSoukinData28.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData28.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData28.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData28.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData28.setBankcd("1003");
        fBSoukinData28.setSitencd("103");
        fBSoukinData28.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData28.setKouzano("103");
        fBSoukinData28.setKzmeiginmkn("ううう");
        fBSoukinData28.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData28);

        BT_FBSoukinData fBSoukinData29 = new BT_FBSoukinData("FB029");
        fBSoukinData29.setSyoricd("1001");
        fBSoukinData29.setSyorisosikicd("1000003");
        fBSoukinData29.setSyoriYmd(BizDate.valueOf("20160220"));
        fBSoukinData29.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData29.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
        fBSoukinData29.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinData29.setBankcd("1003");
        fBSoukinData29.setSitencd("103");
        fBSoukinData29.setYokinkbn(C_YokinKbn.TOUZA);
        fBSoukinData29.setKouzano("103");
        fBSoukinData29.setKzmeiginmkn("ううう");
        fBSoukinData29.setKeirisyono("11807111200");

        bizDomManager.insert(fBSoukinData29);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllFBSoukinData());
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

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd("JCD01", BizDate.valueOf(20160210), C_Gyoumucd.BLNK))  {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd("JCD01", BizDate.valueOf(20160215), C_Gyoumucd.BLNK)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {

                fBSoukinData = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160215), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.BLNK, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.BLNK0, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.BLNK, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());
                    Assert.assertEquals("FB001", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd("JCD01", BizDate.valueOf(20160220), C_Gyoumucd.KHSISIHARAI2EIGO, C_Gyoumucd.KHSISIHARAIYOKUEI, C_Gyoumucd.SKFUSEIRITUPHENKIN)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {

                fBSoukinData = iter.next();
                iCount++;
                Map<String,String> map = new HashMap<String,String>();
                map.put($("FB006","1003","1000003",BizDate.valueOf(20160220),C_Gyoumucd.KHSISIHARAI2EIGO,C_Tantositucd.DAIRITENKEIYAKU,C_ShrhousiteiKbn.BLNK,"1001","101",C_YokinKbn.BLNK,"101","あああ","11807111200"), "1");
                map.put($("FB005","1002","1000002",BizDate.valueOf(20160220),C_Gyoumucd.KHSISIHARAI2EIGO,C_Tantositucd.DAIRITENKEIYAKU,C_ShrhousiteiKbn.BLNK,"1001","101",C_YokinKbn.BLNK,"101","あああ","11807111200"), "1");
                map.put($("FB004","1001","1000001",BizDate.valueOf(20160220),C_Gyoumucd.KHSISIHARAI2EIGO,C_Tantositucd.DAIRITENKEIYAKU,C_ShrhousiteiKbn.BLNK,"1001","101",C_YokinKbn.BLNK,"101","あああ","11807111200"), "1");



                if (1 == iCount) {
                    assertTrue(map.containsKey($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono())));

                    map.remove($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono()));

                    continue;
                }

                if (2 == iCount) {
                    assertTrue(map.containsKey($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono())));

                    map.remove($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono()));

                    continue;
                }

                if (3 == iCount) {
                    assertTrue(map.containsKey($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono())));

                    map.remove($(fBSoukinData.getFbsoukindatasikibetukey(),fBSoukinData.getSyoricd(), fBSoukinData.getSyorisosikicd()
                        , fBSoukinData.getSyoriYmd(), fBSoukinData.getGyoumucd(), fBSoukinData.getTantositucd(), fBSoukinData.getShrhousiteikbn()
                        , fBSoukinData.getBankcd(), fBSoukinData.getSitencd(), fBSoukinData.getYokinkbn(), fBSoukinData.getKouzano(),
                        fBSoukinData.getKzmeiginmkn(), fBSoukinData.getKeirisyono()));

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("FB009", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.BLNK, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111211", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("FB008", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_YOKUJITU, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("FB007", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("FB012", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1001", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111211", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("FB011", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1002", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("FB010", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("101", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("FB014", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("102", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals("FB013", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.SKFUSEIRITUPHENKIN, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals("FB018", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.BLNK, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111211", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals("FB017", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.HUTUU, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals("FB016", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (15 == iCount) {

                    Assert.assertEquals("FB021", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("101", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111211", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals("FB020", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("102", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (17 == iCount) {

                    Assert.assertEquals("FB019", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("あああ", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (18 == iCount) {

                    Assert.assertEquals("FB023", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("いいい", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (19 == iCount) {

                    Assert.assertEquals("FB022", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("ううう", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111200", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (20 == iCount) {

                    Assert.assertEquals("FB026", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("ううう", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111211", fBSoukinData.getKeirisyono());

                    continue;

                }

                if (21 == iCount) {

                    Assert.assertEquals("FB025", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("ううう", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111222", fBSoukinData.getKeirisyono());

                    continue;
                }

                if (22 == iCount) {

                    Assert.assertEquals("FB027", fBSoukinData.getFbsoukindatasikibetukey());
                    Assert.assertEquals("1001", fBSoukinData.getSyoricd());
                    Assert.assertEquals("1000001", fBSoukinData.getSyorisosikicd());
                    Assert.assertEquals(BizDate.valueOf(20160220), fBSoukinData.getSyoriYmd());
                    Assert.assertEquals(C_Gyoumucd.KHSISIHARAIYOKUEI, fBSoukinData.getGyoumucd());
                    Assert.assertEquals(C_Tantositucd.DAIRITENKEIYAKU, fBSoukinData.getTantositucd());
                    Assert.assertEquals(C_ShrhousiteiKbn.FB_2EIGYOUBI, fBSoukinData.getShrhousiteikbn());
                    Assert.assertEquals("1003", fBSoukinData.getBankcd());
                    Assert.assertEquals("103", fBSoukinData.getSitencd());
                    Assert.assertEquals(C_YokinKbn.TOUZA, fBSoukinData.getYokinkbn());
                    Assert.assertEquals("103", fBSoukinData.getKouzano());
                    Assert.assertEquals("ううう", fBSoukinData.getKzmeiginmkn());
                    Assert.assertEquals("11807111233", fBSoukinData.getKeirisyono());

                    continue;
                }

                assertTrue(map.isEmpty());
            }
            Assert.assertEquals(22, iCount);
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

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(P_JOB_CD_02, BizDate.valueOf(20160220),
                C_Gyoumucd.KHSISIHARAI2EIGO, C_Gyoumucd.KHSISIHARAIYOKUEI, C_Gyoumucd.SKFUSEIRITUPHENKIN)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {

                fBSoukinData = iter.next();
                iCount++;
            }

            Assert.assertEquals(22, iCount);
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

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterid("Bz107");
        key3.setRecoveryfilterkey1("FB006");
        key3.setTableid("BT_FBSoukinData");
        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20(){

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(P_JOB_CD_02, BizDate.valueOf(20160220),
                C_Gyoumucd.KHSISIHARAI2EIGO, C_Gyoumucd.KHSISIHARAIYOKUEI, C_Gyoumucd.SKFUSEIRITUPHENKIN)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {
                fBSoukinData = iter.next();
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "FB006");

                iCount++;
            }
            Assert.assertEquals(21, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Bz107");
        key1.setRecoveryfilterkey1("FB005");
        key1.setTableid("BT_FBSoukinData");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try (ExDBUpdatableResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(P_JOB_CD_02, BizDate.valueOf(20160220),
                C_Gyoumucd.KHSISIHARAI2EIGO, C_Gyoumucd.KHSISIHARAIYOKUEI, C_Gyoumucd.SKFUSEIRITUPHENKIN)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {
                fBSoukinData = iter.next();
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "FB006");
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "FB005");
                iCount++;
            }
            assertEquals(20, iCount);
        }
    }

}
