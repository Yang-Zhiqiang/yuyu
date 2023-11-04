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
import yuyu.def.biz.sorter.SortBM_ChkJhNenreiHani2;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkJhNenreiHani2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkJhNenreiHani2sByPkTkykmossyouhnumu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhNenreiHani2sByPkTkykmossyouhnumu {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkJhNenreiHani2sByPkTkykmossyouhnumu";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.ARI);

        exNumericEquals(chkJhNenreiHani2List.size(), 0, "件数");
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkJhNenreiHani2sByPkTkykmossyouhnumu.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllChkJhNenreiHani2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllChkJhNenreiHani2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.ARI);

        exNumericEquals(chkJhNenreiHani2List.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.MIZUHO,
            "ｱ1",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.NONE);

        exNumericEquals(chkJhNenreiHani2List.size(), 1, "年齢範囲事方書チェックマスタ２のサイズ");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(chkJhNenreiHani2List.get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkJhNenreiHani2List.get(0).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkJhNenreiHani2List.get(0).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getTokusyuchkno(), BizNumber.valueOf(26), "特殊チェック番号");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.SMTB,
            "ｱ1",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.ARI);

        exNumericEquals(chkJhNenreiHani2List.size(), 3, "年齢範囲事方書チェックマスタ２のサイズ");

        SortBM_ChkJhNenreiHani2 sortBM_ChkJhNenreiHani2 = new SortBM_ChkJhNenreiHani2();
        chkJhNenreiHani2List = sortBM_ChkJhNenreiHani2.OrderBM_ChkJhNenreiHani2ByPkAsc(chkJhNenreiHani2List);

        exClassificationEquals(chkJhNenreiHani2List.get(0).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkJhNenreiHani2List.get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyusyouhnsdnofrom(), 9, "（主契約）商品世代番号自");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyusyouhnsdnoto(), 11, "（主契約）商品世代番号至");
        exNumericEquals(chkJhNenreiHani2List.get(0).getHhknseifrom(), 3, "被保険者性別自");
        exNumericEquals(chkJhNenreiHani2List.get(0).getHhknseito(), 5, "被保険者性別至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhknkkn(), 4, "主契約保険期間");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhknkknto(), 6, "主契約保険期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhrkkkn(), 5, "主契約払込期間");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyuhrkkknto(), 7, "主契約払込期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(0).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyufromnen(), BizNumber.valueOf(29), "主契約年齢自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyutonen(), BizNumber.valueOf(31), "主契約年齢至");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkJhNenreiHani2List.get(0).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(0).getTokusyuchkno(), BizNumber.valueOf(27), "特殊チェック番号");

        exClassificationEquals(chkJhNenreiHani2List.get(1).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkJhNenreiHani2List.get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkJhNenreiHani2List.get(1).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkJhNenreiHani2List.get(1).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkJhNenreiHani2List.get(1).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(1).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(1).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(1).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(1).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(1).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(1).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkJhNenreiHani2List.get(1).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(1).getTokusyuchkno(), BizNumber.valueOf(28), "特殊チェック番号");

        exClassificationEquals(chkJhNenreiHani2List.get(2).getChannelcd(), C_Channelcd.SMTB, "チャネルコード");
        exStringEquals(chkJhNenreiHani2List.get(2).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyusyouhnsdnofrom(), 10, "（主契約）商品世代番号自");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyusyouhnsdnoto(), 10, "（主契約）商品世代番号至");
        exNumericEquals(chkJhNenreiHani2List.get(2).getHhknseifrom(), 4, "被保険者性別自");
        exNumericEquals(chkJhNenreiHani2List.get(2).getHhknseito(), 4, "被保険者性別至");
        exClassificationEquals(chkJhNenreiHani2List.get(2).getSyukatakbn(), C_KataKbn.HONNIN, "主契約型区分");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyuhknkkn(), 5, "主契約保険期間");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyuhknkknto(), 5, "主契約保険期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(2).getSyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "主契約保険期間歳満期区分");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyuhrkkkn(), 6, "主契約払込期間");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyuhrkkknto(), 6, "主契約払込期間至");
        exClassificationEquals(chkJhNenreiHani2List.get(2).getSyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "主契約払込期間歳満期区分");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(2).getSyufromnen(), BizNumber.valueOf(30), "主契約年齢自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(2).getSyutonen(), BizNumber.valueOf(30), "主契約年齢至");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(2).getSyuyoteiriritufrom(), BizNumber.valueOf(1.1234), "主契約予定利率自");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(2).getSyuyoteirirituto(), BizNumber.valueOf(1.1234), "主契約予定利率至");
        exNumericEquals(chkJhNenreiHani2List.get(2).getSyudai1hknkkn(), 7, "主契約第１保険期間");
        exBizCalcbleEquals(chkJhNenreiHani2List.get(2).getTokusyuchkno(), BizNumber.valueOf(29), "特殊チェック番号");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.MIZUHO,
            "",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "ｱ11",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.ARI);

        exNumericEquals(chkJhNenreiHani2List.size(), 0, "件数");

        chkJhNenreiHani2List = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumu(
            C_Channelcd.MIZUHO,
            "ｱ1",
            10,
            BizNumber.valueOf(30),
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            7,
            "",
            BizNumber.valueOf(10),
            C_HknkknsmnKbn.NENMANKI,
            BizNumber.valueOf(9),
            C_HrkkknsmnKbn.SAIMANKI,
            C_UmuKbn.ARI);

        exNumericEquals(chkJhNenreiHani2List.size(), 0, "件数");
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
