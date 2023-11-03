package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 受取人要フラグ取得クラスのメソッド {@link GetUktYouFlg#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class GetUktYouFlgTest_exec {

    private final static String mosNo1 = "780000014";

    private final static String mosNo2 = "780000022";

    private final static String mosNo3 = "780000030";

    private final static String mosNo4 = "780000048";

    private final static String mosNo5 = "780000055";

    private final static String mosNo6 = "780000063";

    private final static String mosNo7 = "780000071";

    private final static String mosNo8 = "780000089";

    private final static String mosNo9 = "860000025";

    private final static String mosNo10 = "860000058";

    private final static String mosNo11 = "860000066";

    private final static String mosNo12 = "860000074";

    private final static String mosNo13 = "860000082";

    private final static String mosNo14 = "860000090";

    private final static String fileName = "UT-SP_単体テスト仕様書_受取人要フラグ取得";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private GetUktYouFlg getUktYouFlg;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetUktYouFlgTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        try {
            getUktYouFlg.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=780000014", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ3", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), true, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ4", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), true, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ3", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), true, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ4", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), true, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ5", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), true, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ6", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), true, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ7", 1);
        BM_SyouhnZokusei syouhnZokusei1 = bizDomManager.getSyouhnZokusei("ｱ8", 1);
        BM_SyouhnZokusei syouhnZokusei2 = bizDomManager.getSyouhnZokusei("ｱ9", 1);
        listTkSyouhnZokusei.add(syouhnZokusei);
        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), true, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), true, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), true, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), true, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), true, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), true, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), true, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), true, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), true, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), true, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ1", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), true, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ2", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), true, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ5", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), true, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ6", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｲ7", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), false, "定期支払金受取人要フラグ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        getUktYouFlg.exec(mosnaiCheckParam);

        exBooleanEquals(getUktYouFlg.getFlgSbUkt(), false, "死亡受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgMnkUkt(), false, "満期受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKzkTrkSrv(), false, "家族登録サービス要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgKykDr(), false, "契約者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgHhknDr(), false, "被保険者代理人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHnknknUkt(), false, "死亡返還金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbHknknUkt(), false, "死亡保険金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgSbKyhknUkt(), false, "死亡給付金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgNkUkt(), false, "年金受取人要フラグ");
        exBooleanEquals(getUktYouFlg.getFlgTikShrknUkt(), true, "定期支払金受取人要フラグ");
    }
}