package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 年齢範囲チェックマスタエンティティリスト取得(主キー範囲、主契約型区分有無、特約申込商品情報有無)のテストクラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    private final static C_Channelcd    channelcd1        = C_Channelcd.SMBC;
    private final static String         syusyouhncd1      = "M210";
    private final static Integer        syouhnsdno1       = Integer.valueOf(10);
    private final static BizNumber      nen1              = BizNumber.valueOf(26);
    private final static Integer        seibetu1          = Integer.valueOf(1);
    private final static C_KataKbn      syukatakbn1       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn1        = Integer.valueOf(4);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn1  = C_HknkknsmnKbn.NENMANKI;
    private final static Integer        syuhrkkkn1        = Integer.valueOf(8);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn1  = C_HrkkknsmnKbn.NENMANKI;
    private final static String         tksyouhncd1       = "M310";
    private final static BizNumber      tkhknkkn1         = BizNumber.valueOf(28);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn1   = C_HknkknsmnKbn.NENMANKI;
    private final static BizNumber      tkhrkkkn1         = BizNumber.valueOf(26);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn1   = C_HrkkknsmnKbn.NENMANKI;
    private final static C_UmuKbn       syukatakbnumu1    = C_UmuKbn.ARI;
    private final static C_UmuKbn       tkykmossyouhnumu1 = C_UmuKbn.ARI;

    private final static C_Channelcd    channelcd2        = C_Channelcd.SINKIN;

    private final static C_Channelcd    channelcd3        = C_Channelcd.MIZUHO;
    private final static String         syusyouhncd3      = "T330";
    private final static Integer        syouhnsdno3       = Integer.valueOf(10);
    private final static BizNumber      nen3              = BizNumber.valueOf(26);
    private final static Integer        seibetu3          = Integer.valueOf(1);
    private final static C_KataKbn      syukatakbn3       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn3        = Integer.valueOf(4);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn3  = C_HknkknsmnKbn.SAIMANKI;
    private final static Integer        syuhrkkkn3        = Integer.valueOf(8);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn3  = C_HrkkknsmnKbn.SAIMANKI;
    private final static String         tksyouhncd3       = "T380";
    private final static BizNumber      tkhknkkn3         = BizNumber.valueOf(28);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn3   = C_HknkknsmnKbn.SAIMANKI;
    private final static BizNumber      tkhrkkkn3         = BizNumber.valueOf(26);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn3   = C_HrkkknsmnKbn.SAIMANKI;
    private final static C_UmuKbn       syukatakbnumu3    = C_UmuKbn.NONE;
    private final static C_UmuKbn       tkykmossyouhnumu3 = C_UmuKbn.ARI;

    private final static C_Channelcd    channelcd4        = C_Channelcd.TIGIN;
    private final static String         syusyouhncd4      = "M890";
    private final static Integer        syouhnsdno4       = Integer.valueOf(10);
    private final static BizNumber      nen4              = BizNumber.valueOf(26);
    private final static Integer        seibetu4          = Integer.valueOf(1);
    private final static C_KataKbn      syukatakbn4       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn4        = Integer.valueOf(4);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn4  = C_HknkknsmnKbn.SAIMANKI;
    private final static Integer        syuhrkkkn4        = Integer.valueOf(8);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn4  = C_HrkkknsmnKbn.SAIMANKI;
    private final static String         tksyouhncd4       = "M980";
    private final static BizNumber      tkhknkkn4         = BizNumber.valueOf(28);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn4   = C_HknkknsmnKbn.SAIMANKI;
    private final static BizNumber      tkhrkkkn4         = BizNumber.valueOf(26);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn4   = C_HrkkknsmnKbn.SAIMANKI;
    private final static C_UmuKbn       syukatakbnumu4    = C_UmuKbn.ARI;
    private final static C_UmuKbn       tkykmossyouhnumu4 = C_UmuKbn.NONE;

    private final static C_Channelcd    channelcd5        = C_Channelcd.YUUSEIKAISYA;
    private final static String         syusyouhncd5      = "T360";
    private final static Integer        syouhnsdno5       = Integer.valueOf(10);
    private final static BizNumber      nen5              = BizNumber.valueOf(26);
    private final static Integer        seibetu5          = Integer.valueOf(1);
    private final static C_KataKbn      syukatakbn5       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn5        = Integer.valueOf(4);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn5  = C_HknkknsmnKbn.NENMANKI;
    private final static Integer        syuhrkkkn5        = Integer.valueOf(8);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn5  = C_HrkkknsmnKbn.NENMANKI;
    private final static String         tksyouhncd5       = "T390";
    private final static BizNumber      tkhknkkn5         = BizNumber.valueOf(28);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn5   = C_HknkknsmnKbn.NENMANKI;
    private final static BizNumber      tkhrkkkn5         = BizNumber.valueOf(26);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn5   = C_HrkkknsmnKbn.NENMANKI;
    private final static C_UmuKbn       syukatakbnumu5    = C_UmuKbn.NONE;
    private final static C_UmuKbn       tkykmossyouhnumu5 = C_UmuKbn.NONE;

    private final static C_Channelcd    channelcd6        = C_Channelcd.YUUSEIGINKOU;
    private final static String         syusyouhncd6      = "E001";
    private final static Integer        syouhnsdno6       = Integer.valueOf(20);
    private final static BizNumber      nen6              = BizNumber.valueOf(32);
    private final static Integer        seibetu6          = Integer.valueOf(2);
    private final static C_KataKbn      syukatakbn6       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn6        = Integer.valueOf(8);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn6  = C_HknkknsmnKbn.BLNK;
    private final static Integer        syuhrkkkn6        = Integer.valueOf(12);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn6  = C_HrkkknsmnKbn.BLNK;
    private final static String         tksyouhncd6       = "E002";
    private final static BizNumber      tkhknkkn6         = BizNumber.valueOf(38);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn6   = C_HknkknsmnKbn.BLNK;
    private final static BizNumber      tkhrkkkn6         = BizNumber.valueOf(36);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn6   = C_HrkkknsmnKbn.BLNK;
    private final static C_UmuKbn       syukatakbnumu6    = C_UmuKbn.ARI;
    private final static C_UmuKbn       tkykmossyouhnumu6 = C_UmuKbn.ARI;


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_ChkNenreiHani> chkNenreiHaniLst = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd1, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            syukatakbnumu1, tkykmossyouhnumu1);

        Assert.assertEquals(0, chkNenreiHaniLst.size());

        insertTestData();
    }
    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkNenreiHani());

    }


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkNenreiHani> chkNenreiHaniLst = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd2, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            syukatakbnumu1, tkykmossyouhnumu1);

        Assert.assertEquals(0, chkNenreiHaniLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkNenreiHani> chkNenreiHaniLst1 = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd1, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            syukatakbnumu1, tkykmossyouhnumu1);

        Assert.assertEquals(1, chkNenreiHaniLst1.size());

        Assert.assertEquals(C_Channelcd.SMBC, chkNenreiHaniLst1.get(0).getChannelcd());

        Assert.assertEquals("M210", chkNenreiHaniLst1.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst1.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkNenreiHaniLst1.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkNenreiHaniLst1.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkNenreiHaniLst1.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkNenreiHaniLst1.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkNenreiHaniLst1.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkNenreiHaniLst1.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst1.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkNenreiHaniLst1.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst1.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst1.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkNenreiHaniLst1.get(0).getTokusyuchkno());

        Assert.assertEquals("M310", chkNenreiHaniLst1.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst1.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkNenreiHaniLst1.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkNenreiHaniLst1.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst1.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkNenreiHaniLst1.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkNenreiHaniLst1.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst1.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst1.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkNenreiHaniLst1.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkNenreiHaniLst1.get(0).getHhknseito());

        List<BM_ChkNenreiHani> chkNenreiHaniLst2 = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd3, syusyouhncd3, syouhnsdno3, nen3, seibetu3, syukatakbn3, syuhknkkn3, syuhknkknsmnkbn3,
            syuhrkkkn3, syuhrkkknsmnkbn3, tksyouhncd3, tkhknkkn3, tkhknkknsmnkbn3, tkhrkkkn3, tkhrkkknsmnkbn3,
            syukatakbnumu3, tkykmossyouhnumu3);

        Assert.assertEquals(1, chkNenreiHaniLst2.size());

        Assert.assertEquals(C_Channelcd.MIZUHO, chkNenreiHaniLst2.get(0).getChannelcd());

        Assert.assertEquals("T330", chkNenreiHaniLst2.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst2.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkNenreiHaniLst2.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkNenreiHaniLst2.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkNenreiHaniLst2.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkNenreiHaniLst2.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkNenreiHaniLst2.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkNenreiHaniLst2.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst2.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkNenreiHaniLst2.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst2.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst2.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkNenreiHaniLst2.get(0).getTokusyuchkno());

        Assert.assertEquals("T380", chkNenreiHaniLst2.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst2.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkNenreiHaniLst2.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkNenreiHaniLst2.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst2.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkNenreiHaniLst2.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkNenreiHaniLst2.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst2.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst2.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkNenreiHaniLst2.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkNenreiHaniLst2.get(0).getHhknseito());

        List<BM_ChkNenreiHani> chkNenreiHaniLst3 = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd4, syusyouhncd4, syouhnsdno4, nen4, seibetu4, syukatakbn4, syuhknkkn4, syuhknkknsmnkbn4,
            syuhrkkkn4, syuhrkkknsmnkbn4, tksyouhncd4, tkhknkkn4, tkhknkknsmnkbn4, tkhrkkkn4, tkhrkkknsmnkbn4,
            syukatakbnumu4, tkykmossyouhnumu4);

        Assert.assertEquals(1, chkNenreiHaniLst3.size());

        Assert.assertEquals(C_Channelcd.TIGIN, chkNenreiHaniLst3.get(0).getChannelcd());

        Assert.assertEquals("M890", chkNenreiHaniLst3.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst3.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkNenreiHaniLst3.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkNenreiHaniLst3.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkNenreiHaniLst3.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkNenreiHaniLst3.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkNenreiHaniLst3.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkNenreiHaniLst3.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst3.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkNenreiHaniLst3.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst3.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst3.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkNenreiHaniLst3.get(0).getTokusyuchkno());

        Assert.assertEquals("M980", chkNenreiHaniLst3.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst3.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkNenreiHaniLst3.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkNenreiHaniLst3.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst3.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkNenreiHaniLst3.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkNenreiHaniLst3.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst3.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst3.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkNenreiHaniLst3.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkNenreiHaniLst3.get(0).getHhknseito());

        List<BM_ChkNenreiHani> chkNenreiHaniLst4 = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd5, syusyouhncd5, syouhnsdno5, nen5, seibetu5, syukatakbn5, syuhknkkn5, syuhknkknsmnkbn5,
            syuhrkkkn5, syuhrkkknsmnkbn5, tksyouhncd5, tkhknkkn5, tkhknkknsmnkbn5, tkhrkkkn5, tkhrkkknsmnkbn5,
            syukatakbnumu5, tkykmossyouhnumu5);

        Assert.assertEquals(1, chkNenreiHaniLst4.size());

        Assert.assertEquals(C_Channelcd.YUUSEIKAISYA, chkNenreiHaniLst4.get(0).getChannelcd());

        Assert.assertEquals("T360", chkNenreiHaniLst4.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst4.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkNenreiHaniLst4.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkNenreiHaniLst4.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkNenreiHaniLst4.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkNenreiHaniLst4.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkNenreiHaniLst4.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkNenreiHaniLst4.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkNenreiHaniLst4.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkNenreiHaniLst4.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst4.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst4.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkNenreiHaniLst4.get(0).getTokusyuchkno());

        Assert.assertEquals("T390", chkNenreiHaniLst4.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst4.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkNenreiHaniLst4.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkNenreiHaniLst4.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst4.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkNenreiHaniLst4.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkNenreiHaniLst4.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkNenreiHaniLst4.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkNenreiHaniLst4.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkNenreiHaniLst4.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkNenreiHaniLst4.get(0).getHhknseito());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkNenreiHani> chkNenreiHaniList = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd6, syusyouhncd6, syouhnsdno6, nen6, seibetu6, syukatakbn6, syuhknkkn6, syuhknkknsmnkbn6,
            syuhrkkkn6, syuhrkkknsmnkbn6, tksyouhncd6, tkhknkkn6, tkhknkknsmnkbn6, tkhrkkkn6, tkhrkkknsmnkbn6,
            syukatakbnumu6, tkykmossyouhnumu6);

        Assert.assertEquals(10, chkNenreiHaniList.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), 1, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), 1, 3), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), 2, 3), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");
        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36, C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        for (BM_ChkNenreiHani chkhkNenreiHani : chkNenreiHaniList) {
            map.remove($(
                chkhkNenreiHani.getChannelcd(),
                chkhkNenreiHani.getSyusyouhncd(),
                chkhkNenreiHani.getSyusyouhnsdnofrom(),
                chkhkNenreiHani.getSyusyouhnsdnoto(),
                chkhkNenreiHani.getSyukatakbn(),
                chkhkNenreiHani.getSyuhknkkn(), chkhkNenreiHani.getSyuhknkknto(),
                chkhkNenreiHani.getSyuhknkknsmnkbn(),
                chkhkNenreiHani.getSyuhrkkkn(), chkhkNenreiHani.getSyuhrkkknto(),
                chkhkNenreiHani.getSyuhrkkknsmnkbn(),
                chkhkNenreiHani.getSyufromnen(),
                chkhkNenreiHani.getSyutonen(),
                chkhkNenreiHani.getTokusyuchkno(),
                chkhkNenreiHani.getTksyouhncd(),
                chkhkNenreiHani.getTkhknkkn(), chkhkNenreiHani.getTkhknkknto(),
                chkhkNenreiHani.getTkhknkknsmnkbn(),
                chkhkNenreiHani.getTkhrkkkn(), chkhkNenreiHani.getTkhrkkknto(),
                chkhkNenreiHani.getTkhrkkknsmnkbn(),
                chkhkNenreiHani.getTkfromnen(),
                chkhkNenreiHani.getTktonen(),
                chkhkNenreiHani.getHhknseifrom(),
                chkhkNenreiHani.getHhknseito()));
        }
        assertTrue(map.isEmpty());
    }

    private BizNumber Bn(int n){
        return BizNumber.valueOf(n);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkNenreiHani> chkNenreiHaniList = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd2, "", syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            syukatakbnumu1, tkykmossyouhnumu1);

        Assert.assertEquals(0, chkNenreiHaniList.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_ChkNenreiHani> chkNenreiHaniList = bizDomManager.getChkNenreiHanisByPkSyukatakbnumuTkykmossyouhnumu(
            channelcd2, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, "", tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            syukatakbnumu1, tkykmossyouhnumu1);

        Assert.assertEquals(0, chkNenreiHaniList.size());
    }
}
