package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn {

    @Inject
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";

    private static String P_JOB_CD_02 = "RGDH";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20110111), C_ShrhousiteiKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }


        BT_FBSoukinData fBSoukinData1 = new BT_FBSoukinData("1");
        fBSoukinData1.setGyoumucd(C_Gyoumucd.valueOf("0"));
        fBSoukinData1.setSyoricd("9001");
        fBSoukinData1.setSyorisosikicd("2016100");
        fBSoukinData1.setSyoriYmd(BizDate.valueOf(20110111));
        fBSoukinData1.setKeirisyono("11807111118");
        fBSoukinData1.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("0"));
        fBSoukinData1.setBankcd("1001");
        fBSoukinData1.setSitencd("001");
        fBSoukinData1.setYokinkbn(C_YokinKbn.valueOf("0"));
        fBSoukinData1.setKouzano("001");
        fBSoukinData1.setKzmeiginmkn("ああ");

        bizDomManager.insert(fBSoukinData1);

        BT_FBSoukinData fBSoukinData2 = new BT_FBSoukinData("2");
        fBSoukinData2.setGyoumucd(C_Gyoumucd.valueOf("0"));
        fBSoukinData2.setSyoricd("9001");
        fBSoukinData2.setSyorisosikicd("2016100");
        fBSoukinData2.setSyoriYmd(BizDate.valueOf(20110112));
        fBSoukinData2.setKeirisyono("11807111118");
        fBSoukinData2.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("0"));
        fBSoukinData2.setBankcd("1001");
        fBSoukinData2.setSitencd("001");
        fBSoukinData2.setYokinkbn(C_YokinKbn.valueOf("0"));
        fBSoukinData2.setKouzano("001");
        fBSoukinData2.setKzmeiginmkn("ああ");

        bizDomManager.insert(fBSoukinData2);

        BT_FBSoukinData fBSoukinData3 = new BT_FBSoukinData("3");
        fBSoukinData3.setGyoumucd(C_Gyoumucd.valueOf("0"));
        fBSoukinData3.setSyoricd("9001");
        fBSoukinData3.setSyorisosikicd("2016100");
        fBSoukinData3.setSyoriYmd(BizDate.valueOf(20110111));
        fBSoukinData3.setKeirisyono("11807111118");
        fBSoukinData3.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("1"));
        fBSoukinData3.setBankcd("1001");
        fBSoukinData3.setSitencd("001");
        fBSoukinData3.setYokinkbn(C_YokinKbn.valueOf("0"));
        fBSoukinData3.setKouzano("001");
        fBSoukinData3.setKzmeiginmkn("ああ");

        bizDomManager.insert(fBSoukinData3);

        BT_FBSoukinData fBSoukinData4 = new BT_FBSoukinData("4");
        fBSoukinData4.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData4.setSyoricd("9001");
        fBSoukinData4.setSyorisosikicd("2016100");
        fBSoukinData4.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData4.setKeirisyono("11807111152");
        fBSoukinData4.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData4.setBankcd("1003");
        fBSoukinData4.setSitencd("003");
        fBSoukinData4.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData4.setKouzano("003");
        fBSoukinData4.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData4);

        BT_FBSoukinData fBSoukinData5 = new BT_FBSoukinData("5");
        fBSoukinData5.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData5.setSyoricd("9001");
        fBSoukinData5.setSyorisosikicd("2016100");
        fBSoukinData5.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData5.setKeirisyono("11807111141");
        fBSoukinData5.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData5.setBankcd("1003");
        fBSoukinData5.setSitencd("003");
        fBSoukinData5.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData5.setKouzano("003");
        fBSoukinData5.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData5);

        BT_FBSoukinData fBSoukinData6 = new BT_FBSoukinData("6");
        fBSoukinData6.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData6.setSyoricd("9001");
        fBSoukinData6.setSyorisosikicd("2016100");
        fBSoukinData6.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData6.setKeirisyono("11807111130");
        fBSoukinData6.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData6.setBankcd("1003");
        fBSoukinData6.setSitencd("003");
        fBSoukinData6.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData6.setKouzano("003");
        fBSoukinData6.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData6);

        BT_FBSoukinData fBSoukinData7 = new BT_FBSoukinData("7");
        fBSoukinData7.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData7.setSyoricd("9001");
        fBSoukinData7.setSyorisosikicd("2016100");
        fBSoukinData7.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData7.setKeirisyono("11807111152");
        fBSoukinData7.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData7.setBankcd("1003");
        fBSoukinData7.setSitencd("003");
        fBSoukinData7.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData7.setKouzano("003");
        fBSoukinData7.setKzmeiginmkn("あえ");

        bizDomManager.insert(fBSoukinData7);

        BT_FBSoukinData fBSoukinData8 = new BT_FBSoukinData("8");
        fBSoukinData8.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData8.setSyoricd("9001");
        fBSoukinData8.setSyorisosikicd("2016100");
        fBSoukinData8.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData8.setKeirisyono("11807111152");
        fBSoukinData8.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData8.setBankcd("1003");
        fBSoukinData8.setSitencd("003");
        fBSoukinData8.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData8.setKouzano("003");
        fBSoukinData8.setKzmeiginmkn("あう");

        bizDomManager.insert(fBSoukinData8);

        BT_FBSoukinData fBSoukinData9 = new BT_FBSoukinData("9");
        fBSoukinData9.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData9.setSyoricd("9001");
        fBSoukinData9.setSyorisosikicd("2016100");
        fBSoukinData9.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData9.setKeirisyono("11807111152");
        fBSoukinData9.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData9.setBankcd("1003");
        fBSoukinData9.setSitencd("003");
        fBSoukinData9.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData9.setKouzano("002");
        fBSoukinData9.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData9);

        BT_FBSoukinData fBSoukinData10 = new BT_FBSoukinData("10");
        fBSoukinData10.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData10.setSyoricd("9001");
        fBSoukinData10.setSyorisosikicd("2016100");
        fBSoukinData10.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData10.setKeirisyono("11807111152");
        fBSoukinData10.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData10.setBankcd("1003");
        fBSoukinData10.setSitencd("003");
        fBSoukinData10.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData10.setKouzano("001");
        fBSoukinData10.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData10);

        BT_FBSoukinData fBSoukinData11 = new BT_FBSoukinData("11");
        fBSoukinData11.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData11.setSyoricd("9001");
        fBSoukinData11.setSyorisosikicd("2016100");
        fBSoukinData11.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData11.setKeirisyono("11807111152");
        fBSoukinData11.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData11.setBankcd("1003");
        fBSoukinData11.setSitencd("003");
        fBSoukinData11.setYokinkbn(C_YokinKbn.valueOf("3"));
        fBSoukinData11.setKouzano("003");
        fBSoukinData11.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData11);

        BT_FBSoukinData fBSoukinData12 = new BT_FBSoukinData("12");
        fBSoukinData12.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData12.setSyoricd("9001");
        fBSoukinData12.setSyorisosikicd("2016100");
        fBSoukinData12.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData12.setKeirisyono("11807111152");
        fBSoukinData12.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData12.setBankcd("1003");
        fBSoukinData12.setSitencd("003");
        fBSoukinData12.setYokinkbn(C_YokinKbn.valueOf("2"));
        fBSoukinData12.setKouzano("003");
        fBSoukinData12.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData12);

        BT_FBSoukinData fBSoukinData13 = new BT_FBSoukinData("13");
        fBSoukinData13.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData13.setSyoricd("9001");
        fBSoukinData13.setSyorisosikicd("2016100");
        fBSoukinData13.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData13.setKeirisyono("11807111152");
        fBSoukinData13.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData13.setBankcd("1003");
        fBSoukinData13.setSitencd("002");
        fBSoukinData13.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData13.setKouzano("003");
        fBSoukinData13.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData13);

        BT_FBSoukinData fBSoukinData14 = new BT_FBSoukinData("14");
        fBSoukinData14.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData14.setSyoricd("9001");
        fBSoukinData14.setSyorisosikicd("2016100");
        fBSoukinData14.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData14.setKeirisyono("11807111152");
        fBSoukinData14.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData14.setBankcd("1003");
        fBSoukinData14.setSitencd("001");
        fBSoukinData14.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData14.setKouzano("003");
        fBSoukinData14.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData14);

        BT_FBSoukinData fBSoukinData15 = new BT_FBSoukinData("15");
        fBSoukinData15.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData15.setSyoricd("9001");
        fBSoukinData15.setSyorisosikicd("2016100");
        fBSoukinData15.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData15.setKeirisyono("11807111152");
        fBSoukinData15.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData15.setBankcd("1002");
        fBSoukinData15.setSitencd("003");
        fBSoukinData15.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData15.setKouzano("003");
        fBSoukinData15.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData15);

        BT_FBSoukinData fBSoukinData16 = new BT_FBSoukinData("16");
        fBSoukinData16.setGyoumucd(C_Gyoumucd.valueOf("9945"));
        fBSoukinData16.setSyoricd("9001");
        fBSoukinData16.setSyorisosikicd("2016100");
        fBSoukinData16.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData16.setKeirisyono("11807111152");
        fBSoukinData16.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData16.setBankcd("1001");
        fBSoukinData16.setSitencd("003");
        fBSoukinData16.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData16.setKouzano("003");
        fBSoukinData16.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData16);

        BT_FBSoukinData fBSoukinData17 = new BT_FBSoukinData("17");
        fBSoukinData17.setGyoumucd(C_Gyoumucd.valueOf("9944"));
        fBSoukinData17.setSyoricd("9001");
        fBSoukinData17.setSyorisosikicd("2016100");
        fBSoukinData17.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData17.setKeirisyono("11807111152");
        fBSoukinData17.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData17.setBankcd("1003");
        fBSoukinData17.setSitencd("003");
        fBSoukinData17.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData17.setKouzano("003");
        fBSoukinData17.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData17);

        BT_FBSoukinData fBSoukinData18 = new BT_FBSoukinData("18");
        fBSoukinData18.setGyoumucd(C_Gyoumucd.valueOf("9943"));
        fBSoukinData18.setSyoricd("9001");
        fBSoukinData18.setSyorisosikicd("2016100");
        fBSoukinData18.setSyoriYmd(BizDate.valueOf(20110114));
        fBSoukinData18.setKeirisyono("11807111152");
        fBSoukinData18.setShrhousiteikbn(C_ShrhousiteiKbn.valueOf("3"));
        fBSoukinData18.setBankcd("1003");
        fBSoukinData18.setSitencd("003");
        fBSoukinData18.setYokinkbn(C_YokinKbn.valueOf("4"));
        fBSoukinData18.setKouzano("003");
        fBSoukinData18.setKzmeiginmkn("あお");

        bizDomManager.insert(fBSoukinData18);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllFBSoukinData());

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
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20110112), C_ShrhousiteiKbn.FB_YOKUJITU)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20110111), C_ShrhousiteiKbn.BLNK);

        int iCount = 0;
        for (BT_FBSoukinData fBSoukinData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("1", fBSoukinData.getFbsoukindatasikibetukey());
            }
        }

        Assert.assertEquals(1, iCount);
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<BT_FBSoukinData> beans =
            bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20110114), C_ShrhousiteiKbn.FB_3EIGYOUBI);

        int iCount = 0;
        for (BT_FBSoukinData fBSoukinData : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("18", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (2 == iCount) {

                Assert.assertEquals("17", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (3 == iCount) {
                Assert.assertEquals("16", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (4 == iCount) {
                Assert.assertEquals("15", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (5 == iCount) {

                Assert.assertEquals("14", fBSoukinData.getFbsoukindatasikibetukey());
            }
            if (6 == iCount) {

                Assert.assertEquals("13", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (7 == iCount) {

                Assert.assertEquals("12", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (8 == iCount) {

                Assert.assertEquals("11", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (9 == iCount) {

                Assert.assertEquals("10", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (10 == iCount) {

                Assert.assertEquals("9", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (11 == iCount) {

                Assert.assertEquals("8", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (12 == iCount) {

                Assert.assertEquals("7", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (13 == iCount) {

                Assert.assertEquals("6", fBSoukinData.getFbsoukindatasikibetukey());

            }
            if (14 == iCount) {

                Assert.assertEquals("5", fBSoukinData.getFbsoukindatasikibetukey());
            }

            if (15 == iCount) {

                Assert.assertEquals("4", fBSoukinData.getFbsoukindatasikibetukey());
            }
        }
        Assert.assertEquals(15, iCount);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<BT_FBSoukinData> fBSoukinDataLst = bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_JOB_CD_02,
            BizDate.valueOf(20110114), C_ShrhousiteiKbn.FB_3EIGYOUBI)){
            for(BT_FBSoukinData fBSoukinData : fBSoukinDataLst){

                iCount++;
            }

            Assert.assertEquals(15, iCount);
        }
    }

    @Test
    @TestOrder(62)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz107");
        filter.setRecoveryfilternm("FB送金データフィルタ");
        filter.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterid("Bz107");
        key3.setRecoveryfilterkey1("17");
        key3.setTableid("BT_FBSoukinData");
        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(70)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_FBSoukinData> fBSoukinDataLst = bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_JOB_CD_02,
            BizDate.valueOf(20110114), C_ShrhousiteiKbn.FB_3EIGYOUBI)){
            for(BT_FBSoukinData fBSoukinData : fBSoukinDataLst){
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "17");

                iCount++;
            }
            Assert.assertEquals(14, iCount);
        }
    }

    @Test
    @TestOrder(71)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key3 = new BT_SkipKey("A01");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterid("Bz107");
        key3.setRecoveryfilterkey1("18");
        key3.setTableid("BT_FBSoukinData");
        bizDomManager.insert(key3);

    }

    @Test
    @TestOrder(80)
    public void testSkippedFilter30(){

        int iCount = 0;
        try(ExDBResults<BT_FBSoukinData> fBSoukinDataLst = bizDomManager.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(P_JOB_CD_02,
            BizDate.valueOf(20110114), C_ShrhousiteiKbn.FB_3EIGYOUBI)){
            for(BT_FBSoukinData fBSoukinData : fBSoukinDataLst){
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "18");
                assertNotEquals(fBSoukinData.getFbsoukindatasikibetukey(), "17");

                iCount++;
            }
            assertEquals(13, iCount);
        }
    }
}


