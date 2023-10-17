package yuyu.def.biz.manager;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.sorter.SortBM_ChkNenreiHani2;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2 {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 0, "年齢範囲チェックマスタ２エンティティリストのサイズ");
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllChkNenreiHani2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllChkNenreiHani2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 0, "年齢範囲チェックマスタ２エンティティリストのサイズ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            C_UmuKbn.NONE,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 1, "年齢範囲チェックマスタ２エンティティリストのサイズ");
        exClassificationEquals(chkNenreiHani2List.get(0).getChannelcd(), C_Channelcd.SMBC, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyukatakbn(), C_KataKbn.HONNIN_TUMA, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(0).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getTokusyuchkno(), BizNumber.valueOf(7), "特殊チェック番号");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.MIZUHO,
            "ｱ1",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 3, "年齢範囲チェックマスタ２エンティティリストのサイズ");

        SortBM_ChkNenreiHani2 sortBM_ChkNenreiHani2 = new SortBM_ChkNenreiHani2();
        chkNenreiHani2List = sortBM_ChkNenreiHani2.OrderBM_ChkNenreiHani2ByPkAsc(chkNenreiHani2List);

        exClassificationEquals(chkNenreiHani2List.get(0).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnofrom(), 9, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnoto(), 11, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseifrom(), 3, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseito(), 5, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkkn(), 4, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkknto(), 6, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkkn(), 5, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkknto(), 7, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyufromnen(), BizNumber.valueOf(29), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyutonen(), BizNumber.valueOf(31), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1233), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteirirituto(), BizNumber.valueOf(1.1235), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(0).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getTokusyuchkno(), BizNumber.valueOf(26), "特殊チェック番号");

        exClassificationEquals(chkNenreiHani2List.get(1).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(1).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(1).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(1).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(1).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(1).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getTokusyuchkno(), BizNumber.valueOf(27), "特殊チェック番号");

        exClassificationEquals(chkNenreiHani2List.get(2).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(2).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(2).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(2).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(2).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(2).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(2).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getTokusyuchkno(), BizNumber.valueOf(28), "特殊チェック番号");

        chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMTB,
            "ｱ1",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.NONE,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 3, "年齢範囲チェックマスタ２エンティティリストのサイズ");

        chkNenreiHani2List = sortBM_ChkNenreiHani2.OrderBM_ChkNenreiHani2ByPkAsc(chkNenreiHani2List);

        exClassificationEquals(chkNenreiHani2List.get(0).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnofrom(), 9, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(0).getSyusyouhnsdnoto(), 11, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseifrom(), 3, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(0).getHhknseito(), 5, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkkn(), 4, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhknkknto(), 6, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkkn(), 5, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(0).getSyuhrkkknto(), 7, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(0).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyufromnen(), BizNumber.valueOf(29), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyutonen(), BizNumber.valueOf(31), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1233), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getSyuyoteirirituto(), BizNumber.valueOf(1.1235), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(0).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(0).getTokusyuchkno(), BizNumber.valueOf(29), "特殊チェック番号");

        exClassificationEquals(chkNenreiHani2List.get(1).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(1).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(1).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(1).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(1).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(1).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(1).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(1).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(1).getTokusyuchkno(), BizNumber.valueOf(30), "特殊チェック番号");

        exClassificationEquals(chkNenreiHani2List.get(2).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkNenreiHani2List.get(2).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkNenreiHani2List.get(2).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkNenreiHani2List.get(2).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkNenreiHani2List.get(2).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkNenreiHani2List.get(2).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkNenreiHani2List.get(2).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkNenreiHani2List.get(2).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkNenreiHani2List.get(2).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkNenreiHani2List.get(2).getTokusyuchkno(), BizNumber.valueOf(31), "特殊チェック番号");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMBC,
            "",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 0, "年齢範囲チェックマスタ２エンティティリストのサイズ");

        chkNenreiHani2List = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            C_UmuKbn.ARI,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(1.1234),
            7,
            4,
            C_UmuKbn.ARI,
            "",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(10),
            C_HrkkknsmnKbn.SAIMANKI);

        exNumericEquals(chkNenreiHani2List.size(), 0, "年齢範囲チェックマスタ２エンティティリストのサイズ");
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
