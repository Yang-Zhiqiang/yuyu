package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#getSyuEntity(List)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getSyuEntity {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ連携項目編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_getSyuEntity.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testGetSyuEntity_A1() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        List<HT_MosSyouhn> pMosSyouhnLst = syoriCTL.getMosSyouhns();

        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnLst);

        assertNull(editPalRenkeiKoumoku.getMosSyouhn());
        assertNull(editPalRenkeiKoumoku.getSyouhnZokusei());
    }

    @Test
    @TestOrder(20)
    public void testGetSyuEntity_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        List<HT_MosSyouhn> pMosSyouhnLst = syoriCTL.getMosSyouhns();

        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnLst);

        HT_MosSyouhn mosSyouhn = editPalRenkeiKoumoku.getMosSyouhn();
        exStringEquals(mosSyouhn.getMosno(), "860000025", "申込番号");
        exStringEquals(mosSyouhn.getSyouhncd(), "1001", "商品コード");
        exNumericEquals(mosSyouhn.getSyouhnsdno(), 10, "商品世代番号");
        exClassificationEquals(mosSyouhn.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(mosSyouhn.getSknenkinsyu(), C_Sknenkinsyu.KKTI5, "新契約年金種類");
        exBizCalcbleEquals(mosSyouhn.getKihons(), BizCurrency.valueOf(3000), "基本Ｓ");
        exBizCalcbleEquals(mosSyouhn.getSeitoukihons(), BizCurrency.valueOf(5000), "正当基本Ｓ");
        exStringEquals(mosSyouhn.getGyoumuKousinsyaId(), "JunitTest1", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhn.getGyoumuKousinTime(), "20160101101010000", "業務用更新時間");

        BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "1001", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(syouhnZokusei.getRyouritusdno(), "010", "料率世代番号");
        exNumericEquals(syouhnZokusei.getSyohnsortno(), 111, "商品ソート番号");
        exStringEquals(syouhnZokusei.getGyoumuKousinsyaId(), "JunitTest1", "業務用更新者ＩＤ");
        exStringEquals(syouhnZokusei.getGyoumuKousinTime(), "20160101101010000", "業務用更新時間");
    }


    @Test
    @TestOrder(30)
    public void testGetSyuEntity_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        List<HT_MosSyouhn> pMosSyouhnLst = syoriCTL.getMosSyouhns();

        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnLst);

        HT_MosSyouhn mosSyouhn = editPalRenkeiKoumoku.getMosSyouhn();
        exStringEquals(mosSyouhn.getMosno(), "860000033", "申込番号");
        exStringEquals(mosSyouhn.getSyouhncd(), "1003", "商品コード");
        exNumericEquals(mosSyouhn.getSyouhnsdno(), 10, "商品世代番号");
        exClassificationEquals(mosSyouhn.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(mosSyouhn.getSknenkinsyu(), C_Sknenkinsyu.BLNK, "新契約年金種類");
        exBizCalcbleEquals(mosSyouhn.getKihons(), BizCurrency.valueOf(20000), "基本Ｓ");
        exBizCalcbleEquals(mosSyouhn.getSeitoukihons(), BizCurrency.valueOf(50000), "正当基本Ｓ");
        exStringEquals(mosSyouhn.getGyoumuKousinsyaId(), "JunitTest3", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhn.getGyoumuKousinTime(), "20160301101010000", "業務用更新時間");

        BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "1003", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(syouhnZokusei.getRyouritusdno(), "012", "料率世代番号");
        exNumericEquals(syouhnZokusei.getSyohnsortno(), 113, "商品ソート番号");
        exStringEquals(syouhnZokusei.getGyoumuKousinsyaId(), "JunitTest3", "業務用更新者ＩＤ");
        exStringEquals(syouhnZokusei.getGyoumuKousinTime(), "20160301101010000", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testGetSyuEntity_A4() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        List<HT_MosSyouhn> pMosSyouhnLst = syoriCTL.getMosSyouhns();

        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnLst);



        HT_MosSyouhn mosSyouhn = editPalRenkeiKoumoku.getMosSyouhn();
        exStringEquals(mosSyouhn.getMosno(), "860000025", "申込番号");
        exStringEquals(mosSyouhn.getSyouhncd(), "1001", "商品コード");
        exNumericEquals(mosSyouhn.getSyouhnsdno(), 10, "商品世代番号");
        exClassificationEquals(mosSyouhn.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(mosSyouhn.getSknenkinsyu(), C_Sknenkinsyu.KKTI5, "新契約年金種類");
        exBizCalcbleEquals(mosSyouhn.getKihons(), BizCurrency.valueOf(3000), "基本Ｓ");
        exBizCalcbleEquals(mosSyouhn.getSeitoukihons(), BizCurrency.valueOf(5000), "正当基本Ｓ");
        exStringEquals(mosSyouhn.getGyoumuKousinsyaId(), "JunitTest1", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhn.getGyoumuKousinTime(), "20160101101010000", "業務用更新時間");

        BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "1001", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(syouhnZokusei.getRyouritusdno(), "010", "料率世代番号");
        exNumericEquals(syouhnZokusei.getSyohnsortno(), 111, "商品ソート番号");
        exStringEquals(syouhnZokusei.getGyoumuKousinsyaId(), "JunitTest1", "業務用更新者ＩＤ");
        exStringEquals(syouhnZokusei.getGyoumuKousinTime(), "20160101101010000", "業務用更新時間");


        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        pMosSyouhnLst = syoriCTL.getMosSyouhns();

        editPalRenkeiKoumoku.getSyuEntity(pMosSyouhnLst);


        assertNull(editPalRenkeiKoumoku.getMosSyouhn());
        assertNull(editPalRenkeiKoumoku.getSyouhnZokusei());
    }
}