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
import yuyu.def.db.entity.BM_ChkJhNenreiHani;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 年齢範囲事方書チェックマスタエンティティリスト取得(主キー範囲、特約申込商品情報有無)のテストクラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getChkJhNenreiHanisByPkTkykmossyouhnumu {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkJhNenreiHanisByPkTkykmossyouhnumu";

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
    private final static C_UmuKbn       tkykmossyouhnumu1 = C_UmuKbn.ARI;

    private final static C_Channelcd    channelcd2        = C_Channelcd.SHOP;

    private final static C_Channelcd    channelcd3        = C_Channelcd.TIGIN;
    private final static String         syusyouhncd3      = "M890";
    private final static Integer        syouhnsdno3       = Integer.valueOf(10);
    private final static BizNumber      nen3              = BizNumber.valueOf(26);
    private final static Integer        seibetu3          = Integer.valueOf(1);
    private final static C_KataKbn      syukatakbn3       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn3        = Integer.valueOf(4);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn3  = C_HknkknsmnKbn.SAIMANKI;
    private final static Integer        syuhrkkkn3        = Integer.valueOf(8);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn3  = C_HrkkknsmnKbn.SAIMANKI;
    private final static String         tksyouhncd3       = "M980";
    private final static BizNumber      tkhknkkn3         = BizNumber.valueOf(28);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn3   = C_HknkknsmnKbn.SAIMANKI;
    private final static BizNumber      tkhrkkkn3         = BizNumber.valueOf(26);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn3   = C_HrkkknsmnKbn.SAIMANKI;
    private final static C_UmuKbn       tkykmossyouhnumu3 = C_UmuKbn.NONE;

    private final static C_Channelcd    channelcd4        = C_Channelcd.YUUSEIGINKOU;
    private final static String         syusyouhncd4      = "E001";
    private final static Integer        syouhnsdno4       = Integer.valueOf(20);
    private final static BizNumber      nen4              = BizNumber.valueOf(32);
    private final static Integer        seibetu4          = Integer.valueOf(2);
    private final static C_KataKbn      syukatakbn4       = C_KataKbn.HONIN_KO;
    private final static Integer        syuhknkkn4        = Integer.valueOf(8);
    private final static C_HknkknsmnKbn syuhknkknsmnkbn4  = C_HknkknsmnKbn.BLNK;
    private final static Integer        syuhrkkkn4        = Integer.valueOf(12);
    private final static C_HrkkknsmnKbn syuhrkkknsmnkbn4  = C_HrkkknsmnKbn.BLNK;
    private final static String         tksyouhncd4       = "E002";
    private final static BizNumber      tkhknkkn4         = BizNumber.valueOf(38);
    private final static C_HknkknsmnKbn tkhknkknsmnkbn4   = C_HknkknsmnKbn.BLNK;
    private final static BizNumber      tkhrkkkn4         = BizNumber.valueOf(36);
    private final static C_HrkkknsmnKbn tkhrkkknsmnkbn4   = C_HrkkknsmnKbn.BLNK;
    private final static C_UmuKbn       tkykmossyouhnumu4 = C_UmuKbn.ARI;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd1, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            tkykmossyouhnumu1);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());

        insertTestData();
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkJhNenreiHani());

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkJhNenreiHanisByPkTkykmossyouhnumu.class, fileName,
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

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd2, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            tkykmossyouhnumu1);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst1 = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd1, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            tkykmossyouhnumu1);

        Assert.assertEquals(1, chkJhNenreiHaniLst1.size());

        Assert.assertEquals(C_Channelcd.SMBC, chkJhNenreiHaniLst1.get(0).getChannelcd());

        Assert.assertEquals("M210", chkJhNenreiHaniLst1.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkJhNenreiHaniLst1.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkJhNenreiHaniLst1.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkJhNenreiHaniLst1.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkJhNenreiHaniLst1.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkJhNenreiHaniLst1.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkJhNenreiHaniLst1.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkJhNenreiHaniLst1.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkJhNenreiHaniLst1.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkJhNenreiHaniLst1.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst1.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst1.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkJhNenreiHaniLst1.get(0).getTokusyuchkno());

        Assert.assertEquals("M310", chkJhNenreiHaniLst1.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst1.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkJhNenreiHaniLst1.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.NENMANKI, chkJhNenreiHaniLst1.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst1.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkJhNenreiHaniLst1.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.NENMANKI, chkJhNenreiHaniLst1.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst1.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst1.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkJhNenreiHaniLst1.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkJhNenreiHaniLst1.get(0).getHhknseito());

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst2 = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd3, syusyouhncd3, syouhnsdno3, nen3, seibetu3, syukatakbn3, syuhknkkn3, syuhknkknsmnkbn3,
            syuhrkkkn3, syuhrkkknsmnkbn3, tksyouhncd3, tkhknkkn3, tkhknkknsmnkbn3, tkhrkkkn3, tkhrkkknsmnkbn3,
            tkykmossyouhnumu3);

        Assert.assertEquals(1, chkJhNenreiHaniLst2.size());

        Assert.assertEquals(C_Channelcd.TIGIN, chkJhNenreiHaniLst2.get(0).getChannelcd());

        Assert.assertEquals("M890", chkJhNenreiHaniLst2.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(9), chkJhNenreiHaniLst2.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(11), chkJhNenreiHaniLst2.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KataKbn.HONIN_KO, chkJhNenreiHaniLst2.get(0).getSyukatakbn());

        Assert.assertEquals(Integer.valueOf(3), chkJhNenreiHaniLst2.get(0).getSyuhknkkn());

        Assert.assertEquals(Integer.valueOf(5), chkJhNenreiHaniLst2.get(0).getSyuhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkJhNenreiHaniLst2.get(0).getSyuhknkknsmnkbn());

        Assert.assertEquals(Integer.valueOf(7), chkJhNenreiHaniLst2.get(0).getSyuhrkkkn());

        Assert.assertEquals(Integer.valueOf(9), chkJhNenreiHaniLst2.get(0).getSyuhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkJhNenreiHaniLst2.get(0).getSyuhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst2.get(0).getSyufromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst2.get(0).getSyutonen());

        Assert.assertEquals(BizNumber.valueOf(10), chkJhNenreiHaniLst2.get(0).getTokusyuchkno());

        Assert.assertEquals("M980", chkJhNenreiHaniLst2.get(0).getTksyouhncd());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst2.get(0).getTkhknkkn());

        Assert.assertEquals(Integer.valueOf(29), chkJhNenreiHaniLst2.get(0).getTkhknkknto());

        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, chkJhNenreiHaniLst2.get(0).getTkhknkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst2.get(0).getTkhrkkkn());

        Assert.assertEquals(Integer.valueOf(27), chkJhNenreiHaniLst2.get(0).getTkhrkkknto());

        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, chkJhNenreiHaniLst2.get(0).getTkhrkkknsmnkbn());

        Assert.assertEquals(BizNumber.valueOf(25), chkJhNenreiHaniLst2.get(0).getTkfromnen());

        Assert.assertEquals(BizNumber.valueOf(27), chkJhNenreiHaniLst2.get(0).getTktonen());

        Assert.assertEquals(Integer.valueOf(0), chkJhNenreiHaniLst2.get(0).getHhknseifrom());

        Assert.assertEquals(Integer.valueOf(2), chkJhNenreiHaniLst2.get(0).getHhknseito());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd4, syusyouhncd4, syouhnsdno4, nen4, seibetu4, syukatakbn4, syuhknkkn4, syuhknkknsmnkbn4,
            syuhrkkkn4, syuhrkkknsmnkbn4, tksyouhncd4, tkhknkkn4, tkhknkknsmnkbn4, tkhrkkkn4, tkhrkkknsmnkbn4,
            tkykmossyouhnumu4);

        Assert.assertEquals(10, chkJhNenreiHaniLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), 1, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), 1, 3), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), 2, 3), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(10), "E002", Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        for (BM_ChkJhNenreiHani chkJhNenreiHani : chkJhNenreiHaniLst) {
            map.remove(
                $(chkJhNenreiHani.getChannelcd(),
                    chkJhNenreiHani.getSyusyouhncd(),
                    chkJhNenreiHani.getSyusyouhnsdnofrom(),
                    chkJhNenreiHani.getSyusyouhnsdnoto(),
                    chkJhNenreiHani.getSyukatakbn(),
                    chkJhNenreiHani.getSyuhknkkn(), chkJhNenreiHani.getSyuhknkknto(),
                    chkJhNenreiHani.getSyuhknkknsmnkbn(),
                    chkJhNenreiHani.getSyuhrkkkn(), chkJhNenreiHani.getSyuhrkkknto(),
                    chkJhNenreiHani.getSyuhrkkknsmnkbn(),
                    chkJhNenreiHani.getSyufromnen(),
                    chkJhNenreiHani.getSyutonen(),
                    chkJhNenreiHani.getTokusyuchkno(),
                    chkJhNenreiHani.getTksyouhncd(),
                    chkJhNenreiHani.getTkhknkkn(), chkJhNenreiHani.getTkhknkknto(),
                    chkJhNenreiHani.getTkhknkknsmnkbn(),
                    chkJhNenreiHani.getTkhrkkkn(), chkJhNenreiHani.getTkhrkkknto(),
                    chkJhNenreiHani.getTkhrkkknsmnkbn(),
                    chkJhNenreiHani.getTkfromnen(),
                    chkJhNenreiHani.getTktonen(),
                    chkJhNenreiHani.getHhknseifrom(),
                    chkJhNenreiHani.getHhknseito()));
        }
        assertTrue(map.isEmpty());
    }

    private BizNumber Bn(int n){
        return BizNumber.valueOf(n);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd2, "", syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, tksyouhncd1, tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            tkykmossyouhnumu1);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumu(
            channelcd2, syusyouhncd1, syouhnsdno1, nen1, seibetu1, syukatakbn1, syuhknkkn1, syuhknkknsmnkbn1,
            syuhrkkkn1, syuhrkkknsmnkbn1, "", tkhknkkn1, tkhknkknsmnkbn1, tkhrkkkn1, tkhrkkknsmnkbn1,
            tkykmossyouhnumu1);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }
}
