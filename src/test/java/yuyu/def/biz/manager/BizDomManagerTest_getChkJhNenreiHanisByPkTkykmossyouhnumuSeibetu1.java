package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 年齢範囲事方書チェックマスタエンティティリスト取得 主キー範囲、特約申込商品情報有無、性別のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1 {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1";

    private final static String sheetName = "INデータ";
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.SMBC,
            "M210", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.NENMANKI, 8, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.ARI, "M310", BizNumber.valueOf(28), C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(26), C_HrkkknsmnKbn.NENMANKI);

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
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1.class, fileName,
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

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.SHOP,
            "", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.NENMANKI, 8, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.ARI, "M310", BizNumber.valueOf(28), C_HknkknsmnKbn.NENMANKI, BizNumber.valueOf(26), C_HrkkknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst1 = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.SMBC,
            "M210", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.NENMANKI, 8, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.ARI, "M310", BizNumber.valueOf(28), C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(26), C_HrkkknsmnKbn.NENMANKI);

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

        Assert.assertEquals(BizNumber.valueOf(1.1234), chkJhNenreiHaniLst1.get(0).getSyuyoteiriritufrom());

        Assert.assertEquals(BizNumber.valueOf(1.1236), chkJhNenreiHaniLst1.get(0).getSyuyoteirirituto());

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

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst2 = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.TIGIN,
            "M890", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.SAIMANKI, 8, C_HrkkknsmnKbn.SAIMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.NONE, "M980", BizNumber.valueOf(99), C_HknkknsmnKbn.SAIMANKI,
            BizNumber.valueOf(26), C_HrkkknsmnKbn.SAIMANKI);

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

        Assert.assertEquals(BizNumber.valueOf(1.1234), chkJhNenreiHaniLst2.get(0).getSyuyoteiriritufrom());

        Assert.assertEquals(BizNumber.valueOf(1.1236), chkJhNenreiHaniLst2.get(0).getSyuyoteirirituto());

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

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.YUUSEIGINKOU,
            "E001", 20, C_KataKbn.HONIN_KO, 8, C_HknkknsmnKbn.BLNK, 12, C_HrkkknsmnKbn.BLNK, BizNumber.valueOf(32),
            2, BizNumber.valueOf(1.4567), C_UmuKbn.ARI, "E002", BizNumber.valueOf(38), C_HknkknsmnKbn.BLNK, BizNumber.valueOf(36), C_HrkkknsmnKbn.BLNK);

        Assert.assertEquals(10, chkJhNenreiHaniLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 19, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), Bn(1.4566), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), Bn(1.4566), Bn(1.4568), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(32), 1, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(31), Bn(33), 1, 3), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), 2, 3), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 20, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(33), Bn(1.4567), Bn(1.4568), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), 2, 2), "1");

        map.put($(C_Channelcd.YUUSEIGINKOU, "E001", 20, 21, C_KataKbn.HONIN_KO, 8, 8, C_HknkknsmnKbn.BLNK, 12, 12,
            C_HrkkknsmnKbn.BLNK, Bn(32), Bn(32), Bn(1.4567), Bn(1.4567), Bn(10), "E002",
            Bn(38), 38, C_HknkknsmnKbn.BLNK, Bn(36), 36,
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
                    chkJhNenreiHani.getSyuyoteiriritufrom(),
                    chkJhNenreiHani.getSyuyoteirirituto(),
                    chkJhNenreiHani.getTokusyuchkno(),
                    chkJhNenreiHani.getTksyouhncd(),
                    chkJhNenreiHani.getTkhknkkn(),chkJhNenreiHani.getTkhknkknto(),
                    chkJhNenreiHani.getTkhknkknsmnkbn(),
                    chkJhNenreiHani.getTkhrkkkn(),chkJhNenreiHani.getTkhrkkknto(),
                    chkJhNenreiHani.getTkhrkkknsmnkbn(),
                    chkJhNenreiHani.getTkfromnen(),
                    chkJhNenreiHani.getTktonen(),
                    chkJhNenreiHani.getHhknseifrom(),
                    chkJhNenreiHani.getHhknseito()));
        }

        assertTrue(map.isEmpty());
    }

    private BizNumber Bn(double n){
        return BizNumber.valueOf(n);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.SHOP,
            "", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.NENMANKI, 8, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.ARI, "M310", BizNumber.valueOf(28), C_HknkknsmnKbn.NENMANKI, BizNumber.valueOf(26), C_HrkkknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_ChkJhNenreiHani> chkJhNenreiHaniLst = bizDomManager.getChkJhNenreiHanisByPkTkykmossyouhnumuSeibetu1(C_Channelcd.SHOP,
            "M210", 10, C_KataKbn.HONIN_KO, 4, C_HknkknsmnKbn.NENMANKI, 8, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(26),
            1, BizNumber.valueOf(1.1235), C_UmuKbn.ARI, "", BizNumber.valueOf(28), C_HknkknsmnKbn.NENMANKI, BizNumber.valueOf(26), C_HrkkknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkJhNenreiHaniLst.size());
    }
}
