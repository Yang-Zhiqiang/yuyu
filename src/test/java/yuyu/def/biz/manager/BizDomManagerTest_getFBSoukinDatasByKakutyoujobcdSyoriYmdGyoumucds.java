package yuyu.def.biz.manager;

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

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds {

    @Inject
    BizDomManager bizDomManager;

    private final static C_Gyoumucd[] gyoumucd1 = {C_Gyoumucd.NENKINJIDOUSOUKIN, C_Gyoumucd.BLNK};
    private final static C_Gyoumucd[] gyoumucd2 = {C_Gyoumucd.SKFUSEIRITUPHENKIN,C_Gyoumucd.KHSISIHARAIYOKUEI, C_Gyoumucd.KHSISIHARAI2EIGO};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20160328), gyoumucd1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_FBSoukinData fBSoukinData1 = new BT_FBSoukinData("1");
        fBSoukinData1.setGyoumucd(C_Gyoumucd.NENKINJIDOUSOUKIN);
        fBSoukinData1.setSyoricd("1000");
        fBSoukinData1.setSyorisosikicd("1000547");
        fBSoukinData1.setSyoriYmd(BizDate.valueOf(20160328));
        fBSoukinData1.setKeirisyono("11807111185");
        fBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData1.setBankcd("2003");
        fBSoukinData1.setSitencd("903");
        fBSoukinData1.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData1.setKouzano("987654321");
        fBSoukinData1.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData1);

        BT_FBSoukinData fBSoukinData2 = new BT_FBSoukinData("2");
        fBSoukinData2.setGyoumucd(C_Gyoumucd.NENKINJIDOUSOUKIN);
        fBSoukinData2.setSyoricd("1000");
        fBSoukinData2.setSyorisosikicd("1000547");
        fBSoukinData2.setSyoriYmd(BizDate.valueOf(20160329));
        fBSoukinData2.setKeirisyono("11807111185");
        fBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData2.setBankcd("2003");
        fBSoukinData2.setSitencd("903");
        fBSoukinData2.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData2.setKouzano("987654321");
        fBSoukinData2.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData2);

        BT_FBSoukinData fBSoukinData3 = new BT_FBSoukinData("3");
        fBSoukinData3.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData3.setSyoricd("1000");
        fBSoukinData3.setSyorisosikicd("1000547");
        fBSoukinData3.setSyoriYmd(BizDate.valueOf(20160328));
        fBSoukinData3.setKeirisyono("11807111185");
        fBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData3.setBankcd("2003");
        fBSoukinData3.setSitencd("903");
        fBSoukinData3.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData3.setKouzano("987654321");
        fBSoukinData3.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData3);

        BT_FBSoukinData fBSoukinData4 = new BT_FBSoukinData("6");
        fBSoukinData4.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData4.setSyoricd("1001");
        fBSoukinData4.setSyorisosikicd("1001547");
        fBSoukinData4.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData4.setKeirisyono("11807111185");
        fBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData4.setBankcd("2003");
        fBSoukinData4.setSitencd("903");
        fBSoukinData4.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData4.setKouzano("987654321");
        fBSoukinData4.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData4);

        BT_FBSoukinData fBSoukinData5 = new BT_FBSoukinData("7");
        fBSoukinData5.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData5.setSyoricd("1001");
        fBSoukinData5.setSyorisosikicd("1001548");
        fBSoukinData5.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData5.setKeirisyono("11807111185");
        fBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData5.setBankcd("2003");
        fBSoukinData5.setSitencd("903");
        fBSoukinData5.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData5.setKouzano("987654321");
        fBSoukinData5.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData5);

        BT_FBSoukinData fBSoukinData6 = new BT_FBSoukinData("8");
        fBSoukinData6.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData6.setSyoricd("1001");
        fBSoukinData6.setSyorisosikicd("1001549");
        fBSoukinData6.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData6.setKeirisyono("11807111185");
        fBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData6.setBankcd("2003");
        fBSoukinData6.setSitencd("903");
        fBSoukinData6.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData6.setKouzano("987654321");
        fBSoukinData6.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData6);

        BT_FBSoukinData fBSoukinData7 = new BT_FBSoukinData("9");
        fBSoukinData7.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData7.setSyoricd("1001");
        fBSoukinData7.setSyorisosikicd("1001550");
        fBSoukinData7.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData7.setKeirisyono("11807111185");
        fBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData7.setBankcd("2003");
        fBSoukinData7.setSitencd("903");
        fBSoukinData7.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData7.setKouzano("987654321");
        fBSoukinData7.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData7);

        BT_FBSoukinData fBSoukinData8 = new BT_FBSoukinData("10");
        fBSoukinData8.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData8.setSyoricd("1001");
        fBSoukinData8.setSyorisosikicd("1001551");
        fBSoukinData8.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData8.setKeirisyono("11807111185");
        fBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData8.setBankcd("2003");
        fBSoukinData8.setSitencd("903");
        fBSoukinData8.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData8.setKouzano("987654321");
        fBSoukinData8.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData8);

        BT_FBSoukinData fBSoukinData9 = new BT_FBSoukinData("11");
        fBSoukinData9.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData9.setSyoricd("1001");
        fBSoukinData9.setSyorisosikicd("1001551");
        fBSoukinData9.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData9.setKeirisyono("11807111185");
        fBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("2"));
        fBSoukinData9.setBankcd("2003");
        fBSoukinData9.setSitencd("903");
        fBSoukinData9.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData9.setKouzano("987654321");
        fBSoukinData9.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData9);

        BT_FBSoukinData fBSoukinData10 = new BT_FBSoukinData("12");
        fBSoukinData10.setGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        fBSoukinData10.setSyoricd("1001");
        fBSoukinData10.setSyorisosikicd("1001551");
        fBSoukinData10.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData10.setKeirisyono("11807111185");
        fBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData10.setBankcd("2003");
        fBSoukinData10.setSitencd("903");
        fBSoukinData10.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData10.setKouzano("987654321");
        fBSoukinData10.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData10);

        BT_FBSoukinData fBSoukinData11 = new BT_FBSoukinData("13");
        fBSoukinData11.setGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        fBSoukinData11.setSyoricd("1001");
        fBSoukinData11.setSyorisosikicd("1001551");
        fBSoukinData11.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData11.setKeirisyono("11807111185");
        fBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData11.setBankcd("2003");
        fBSoukinData11.setSitencd("903");
        fBSoukinData11.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData11.setKouzano("987654321");
        fBSoukinData11.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData11);

        BT_FBSoukinData fBSoukinData12 = new BT_FBSoukinData("14");
        fBSoukinData12.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData12.setSyoricd("1001");
        fBSoukinData12.setSyorisosikicd("1001551");
        fBSoukinData12.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData12.setKeirisyono("11807111185");
        fBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData12.setBankcd("2003");
        fBSoukinData12.setSitencd("903");
        fBSoukinData12.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData12.setKouzano("987654321");
        fBSoukinData12.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData12);

        BT_FBSoukinData fBSoukinData13 = new BT_FBSoukinData("15");
        fBSoukinData13.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData13.setSyoricd("1001");
        fBSoukinData13.setSyorisosikicd("1001551");
        fBSoukinData13.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData13.setKeirisyono("11807111185");
        fBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData13.setBankcd("2002");
        fBSoukinData13.setSitencd("903");
        fBSoukinData13.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData13.setKouzano("987654321");
        fBSoukinData13.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData13);

        BT_FBSoukinData fBSoukinData14 = new BT_FBSoukinData("16");
        fBSoukinData14.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData14.setSyoricd("1001");
        fBSoukinData14.setSyorisosikicd("1001551");
        fBSoukinData14.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData14.setKeirisyono("11807111185");
        fBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData14.setBankcd("2001");
        fBSoukinData14.setSitencd("903");
        fBSoukinData14.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData14.setKouzano("987654321");
        fBSoukinData14.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData14);

        BT_FBSoukinData fBSoukinData15 = new BT_FBSoukinData("17");
        fBSoukinData15.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData15.setSyoricd("1001");
        fBSoukinData15.setSyorisosikicd("1001551");
        fBSoukinData15.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData15.setKeirisyono("11807111185");
        fBSoukinData15.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData15.setBankcd("2001");
        fBSoukinData15.setSitencd("902");
        fBSoukinData15.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData15.setKouzano("987654321");
        fBSoukinData15.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData15);

        BT_FBSoukinData fBSoukinData16 = new BT_FBSoukinData("18");
        fBSoukinData16.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData16.setSyoricd("1001");
        fBSoukinData16.setSyorisosikicd("1001551");
        fBSoukinData16.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData16.setKeirisyono("11807111185");
        fBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData16.setBankcd("2001");
        fBSoukinData16.setSitencd("901");
        fBSoukinData16.setYokinkbn(C_YokinKbn.valueOf("9"));
        fBSoukinData16.setKouzano("987654321");
        fBSoukinData16.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData16);

        BT_FBSoukinData fBSoukinData17 = new BT_FBSoukinData("19");
        fBSoukinData17.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData17.setSyoricd("1001");
        fBSoukinData17.setSyorisosikicd("1001551");
        fBSoukinData17.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData17.setKeirisyono("11807111185");
        fBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData17.setBankcd("2001");
        fBSoukinData17.setSitencd("901");
        fBSoukinData17.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData17.setKouzano("987654321");
        fBSoukinData17.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData17);

        BT_FBSoukinData fBSoukinData18 = new BT_FBSoukinData("20");
        fBSoukinData18.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData18.setSyoricd("1001");
        fBSoukinData18.setSyorisosikicd("1001551");
        fBSoukinData18.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData18.setKeirisyono("11807111185");
        fBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData18.setBankcd("2001");
        fBSoukinData18.setSitencd("901");
        fBSoukinData18.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData18.setKouzano("987654321");
        fBSoukinData18.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData18);

        BT_FBSoukinData fBSoukinData19 = new BT_FBSoukinData("21");
        fBSoukinData19.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData19.setSyoricd("1001");
        fBSoukinData19.setSyorisosikicd("1001551");
        fBSoukinData19.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData19.setKeirisyono("11807111185");
        fBSoukinData19.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData19.setBankcd("2001");
        fBSoukinData19.setSitencd("901");
        fBSoukinData19.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData19.setKouzano("987654320");
        fBSoukinData19.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData19);

        BT_FBSoukinData fBSoukinData20 = new BT_FBSoukinData("22");
        fBSoukinData20.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData20.setSyoricd("1001");
        fBSoukinData20.setSyorisosikicd("1001551");
        fBSoukinData20.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData20.setKeirisyono("11807111185");
        fBSoukinData20.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData20.setBankcd("2001");
        fBSoukinData20.setSitencd("901");
        fBSoukinData20.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData20.setKouzano("987654310");
        fBSoukinData20.setKzmeiginmkn("アイウエオ");

        bizDomManager.insert(fBSoukinData20);

        BT_FBSoukinData fBSoukinData21 = new BT_FBSoukinData("23");
        fBSoukinData21.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData21.setSyoricd("1001");
        fBSoukinData21.setSyorisosikicd("1001551");
        fBSoukinData21.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData21.setKeirisyono("11807111185");
        fBSoukinData21.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData21.setBankcd("2001");
        fBSoukinData21.setSitencd("901");
        fBSoukinData21.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData21.setKouzano("987654310");
        fBSoukinData21.setKzmeiginmkn("アイウエ");

        bizDomManager.insert(fBSoukinData21);

        BT_FBSoukinData fBSoukinData22 = new BT_FBSoukinData("24");
        fBSoukinData22.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData22.setSyoricd("1001");
        fBSoukinData22.setSyorisosikicd("1001551");
        fBSoukinData22.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData22.setKeirisyono("11807111185");
        fBSoukinData22.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData22.setBankcd("2001");
        fBSoukinData22.setSitencd("901");
        fBSoukinData22.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData22.setKouzano("987654310");
        fBSoukinData22.setKzmeiginmkn("アイウ");

        bizDomManager.insert(fBSoukinData22);

        BT_FBSoukinData fBSoukinData23 = new BT_FBSoukinData("25");
        fBSoukinData23.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData23.setSyoricd("1001");
        fBSoukinData23.setSyorisosikicd("1001551");
        fBSoukinData23.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData23.setKeirisyono("11807111174");
        fBSoukinData23.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData23.setBankcd("2001");
        fBSoukinData23.setSitencd("901");
        fBSoukinData23.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData23.setKouzano("987654310");
        fBSoukinData23.setKzmeiginmkn("アイウ");

        bizDomManager.insert(fBSoukinData23);

        BT_FBSoukinData fBSoukinData24 = new BT_FBSoukinData("26");
        fBSoukinData24.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        fBSoukinData24.setSyoricd("1001");
        fBSoukinData24.setSyorisosikicd("1001551");
        fBSoukinData24.setSyoriYmd(BizDate.valueOf(20170328));
        fBSoukinData24.setKeirisyono("11807111163");
        fBSoukinData24.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData24.setBankcd("2001");
        fBSoukinData24.setSitencd("901");
        fBSoukinData24.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData24.setKouzano("987654310");
        fBSoukinData24.setKzmeiginmkn("アイウ");

        bizDomManager.insert(fBSoukinData24);

        BM_FBSoukinListKanri fBSoukinListKanri1 = new BM_FBSoukinListKanri("1000", "1000547");
        fBSoukinListKanri1.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri1.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        bizDomManager.insert(fBSoukinListKanri1);

        BM_FBSoukinListKanri fBSoukinListKanri2 = new BM_FBSoukinListKanri("1001", "1000547");
        fBSoukinListKanri2.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri2.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        bizDomManager.insert(fBSoukinListKanri2);

        BM_FBSoukinListKanri fBSoukinListKanri3 = new BM_FBSoukinListKanri("1000", "1001547");
        fBSoukinListKanri3.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri3.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        bizDomManager.insert(fBSoukinListKanri3);

        BM_FBSoukinListKanri fBSoukinListKanri4 = new BM_FBSoukinListKanri("1001", "1001547");
        fBSoukinListKanri4.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri4.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        bizDomManager.insert(fBSoukinListKanri4);

        BM_FBSoukinListKanri fBSoukinListKanri5 = new BM_FBSoukinListKanri("1001", "1001548");
        fBSoukinListKanri5.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri5.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        bizDomManager.insert(fBSoukinListKanri5);

        BM_FBSoukinListKanri fBSoukinListKanri6 = new BM_FBSoukinListKanri("1001", "1001549");
        fBSoukinListKanri6.setTantositucd(C_Tantositucd.valueOf("527"));
        fBSoukinListKanri6.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SHRMESS);

        bizDomManager.insert(fBSoukinListKanri6);

        BM_FBSoukinListKanri fBSoukinListKanri7 = new BM_FBSoukinListKanri("1001", "1001550");
        fBSoukinListKanri7.setTantositucd(C_Tantositucd.valueOf("526"));
        fBSoukinListKanri7.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SHRMESS);

        bizDomManager.insert(fBSoukinListKanri7);

        BM_FBSoukinListKanri fBSoukinListKanri8 = new BM_FBSoukinListKanri("1001", "1001551");
        fBSoukinListKanri8.setTantositucd(C_Tantositucd.valueOf("460"));
        fBSoukinListKanri8.setFbmeisaisyoruicd(C_SyoruiCdKbn.HK_SHRMESS);

        bizDomManager.insert(fBSoukinListKanri8);
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
    public void noResult1() {

        try (ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20150328), gyoumucd1))  {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20160328), gyoumucd1)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {

                fBSoukinData = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("1", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20170328), gyoumucd2)) {

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData fBSoukinData = null;
            while (iter.hasNext()) {
                fBSoukinData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("26", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("25", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("24", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("23", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("22", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("21", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("20", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals("19", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals("18", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals("17", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals("16", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals("15", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals("14", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals("13", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (15 == iCount) {

                    Assert.assertEquals("12", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals("11", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (17 == iCount) {

                    Assert.assertEquals("10", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (18 == iCount) {

                    Assert.assertEquals("9", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (19 == iCount) {

                    Assert.assertEquals("8", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (20 == iCount) {

                    Assert.assertEquals("7", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }

                if (21 == iCount) {

                    Assert.assertEquals("6", fBSoukinData.getFbsoukindatasikibetukey());

                    continue;
                }
            }
            Assert.assertEquals(21, iCount);
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

        try(ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20170328), gyoumucd2);){

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData bT_FBSoukinData = null;
            while (iter.hasNext()) {

                bT_FBSoukinData = iter.next();
                iCount++;
            }
            Assert.assertEquals(21, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {
        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RGDI");
        skipKey1.setTableid("BT_FBSoukinData");
        skipKey1.setRecoveryfilterid("Bz107");
        skipKey1.setRecoveryfilterkey1("26");

        bizDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz107");
        recoveryFilter1.setRecoveryfilternm("FB送金データフィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");

        bizDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try(ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20170328), gyoumucd2);){

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData bT_FBSoukinData = null;
            while (iter.hasNext()) {

                bT_FBSoukinData = iter.next();
                assertNotEquals(bT_FBSoukinData.getFbsoukindatasikibetukey(), "26");
                iCount++;
            }
            Assert.assertEquals(20, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey skipKey2 = new BT_SkipKey("A03");
        skipKey2.setKakutyoujobcd("RGDI");
        skipKey2.setTableid("BT_FBSoukinData");
        skipKey2.setRecoveryfilterid("Bz107");
        skipKey2.setRecoveryfilterkey1("25");

        bizDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try(ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds("RGDI", BizDate.valueOf(20170328), gyoumucd2);){

            int iCount = 0;
            Iterator<BT_FBSoukinData> iter = beans.iterator();
            BT_FBSoukinData bT_FBSoukinData = null;
            while (iter.hasNext()) {

                bT_FBSoukinData = iter.next();
                assertNotEquals(bT_FBSoukinData.getFbsoukindatasikibetukey(), "26");
                assertNotEquals(bT_FBSoukinData.getFbsoukindatasikibetukey(), "25");
                iCount++;
            }
            Assert.assertEquals(19, iCount);
        }
    }
}
