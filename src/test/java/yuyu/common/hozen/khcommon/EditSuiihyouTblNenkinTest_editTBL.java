package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 推移表ＴＢＬ編集（年金）のメソッド {@link EditSuiihyouTblNenkin#editTBL(KhozenCommonParam,
        IT_KykKihon, List<IT_KykSyouhn>, List<IT_KykSyouhn>, IT_HhknSya, BizDate, EditHokenSyoukenParam, C_SinsaihkKbn ,
        BM_SyouhnZokusei, IT_KykSonotaTkyk )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblNenkinTest_editTBL {

    @Inject
    private EditSuiihyouTblNenkin editSuiihyouTblNenkin;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_推移表ＴＢＬ編集（年金）";
    private final static String sheetName = "テストデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
                bind(WSuiihyouNenkin.class).to(WSuiihyouNenkinMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanWExtMockForHozen.caller = EditSuiihyouTblNenkinTest_editTBL.class;
        WSuiihyouNenkinMockForHozen.caller = EditSuiihyouTblNenkinTest_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
        WSuiihyouNenkinMockForHozen.caller = null;
        WSuiihyouNenkinMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditSuiihyouTblNenkinTest_editTBL.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test (expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditTBL_A1() {
        KhozenCommonParam pKkanriCommonParam = new KhozenCommonParam();
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000013");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181115);
        EditHokenSyoukenParam pEditHokenSyoukenParam = new EditHokenSyoukenParam();
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.BLNK;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;

        try {
            editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
                pKykKihon,
                pKykSyohnSyuLst,
                pKykSyouhnLst,
                pHhknSya,
                pSyoriYmd,
                pEditHokenSyoukenParam,
                pCSinsaihkKbn,
                pSyouhnZokusei,
                pKykSonotaTkyk);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000013");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181015);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN2;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkinMockForHozen.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 78, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1000), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.5432), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.1234), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(202012), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(3000), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(4000), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(1.2345), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(1.2345), "積立利率");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20181001), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20181005), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.BLNK, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 10, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(0.12), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(0.1234), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(23), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(1000), "ターゲット特約基準金額");

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "件数");

        exStringEquals(suiihyouLst.get(0).getSyono(), "17806000013", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20181015), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), BizDate.valueOf(20181001), "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), BizDateYM.valueOf(201810), "計算年月");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exClassificationEquals(suiihyouLst.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(suiihyouLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(1000), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin", "業務用更新機能ＩＤ");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup2(), BizNumber.valueOf(1), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame2(), BizNumber.valueOf(2), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown2(), BizNumber.valueOf(3), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup2(), BizNumber.valueOf(4), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown2(), BizNumber.valueOf(5), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(6), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(7), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(8), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(9), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu2(), BizNumber.valueOf(11), "指数上昇率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu2(), BizNumber.valueOf(12), "積立金増加率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(13), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(14), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(15), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup2(), BizCurrency.valueOf(16), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame2(), BizCurrency.valueOf(17), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown2(), BizCurrency.valueOf(18), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka2(), BizCurrency.valueOf(19), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(20), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(21), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka2(), BizCurrency.valueOf(22), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(23), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(24), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka2(), BizCurrency.valueOf(25), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(26), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(27), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin2(), BizCurrency.valueOf(28), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame2(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka2(), BizCurrency.valueOf(30), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(31), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(32), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin2(), BizCurrency.valueOf(33), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake12(), BizCurrency.valueOf(34), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake22(), BizCurrency.valueOf(35), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup3(), BizNumber.valueOf(36), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame3(), BizNumber.valueOf(37), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown3(), BizNumber.valueOf(38), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup3(), BizNumber.valueOf(39), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown3(), BizNumber.valueOf(40), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(41), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(42), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(43), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(44), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(45), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu3(), BizNumber.valueOf(46), "指数上昇率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu3(), BizNumber.valueOf(47), "積立金増加率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(48), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(49), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(50), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup3(), BizCurrency.valueOf(51), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame3(), BizCurrency.valueOf(52), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown3(), BizCurrency.valueOf(53), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka3(), BizCurrency.valueOf(54), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(56), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka3(), BizCurrency.valueOf(57), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(58), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(59), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka3(), BizCurrency.valueOf(60), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(61), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(62), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin3(), BizCurrency.valueOf(63), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame3(), BizCurrency.valueOf(64), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka3(), BizCurrency.valueOf(65), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(66), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(67), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin3(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake13(), BizCurrency.valueOf(69), " 積立金内訳（１）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake23(), BizCurrency.valueOf(70), "積立金内訳（２）３");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "06", "推移表種別");

        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), " 円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exClassificationEquals(suiihyouLst.get(0).getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000024");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.BLNK;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN4;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkinMockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "123", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(1.2345), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 11, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1010), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20181015), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.5432), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(201810), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(770), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(230), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0.1234), "積立利率");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20181001), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20181005), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 10, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(0.12), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(0.1234), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(23), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(1000), "ターゲット特約基準金額");

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "件数");

        exStringEquals(suiihyouLst.get(0).getSyono(), "17806000024", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20181001), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), BizDate.valueOf(20181001), "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), BizDateYM.valueOf(201810), "計算年月");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exClassificationEquals(suiihyouLst.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");

        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup(), BizNumber.valueOf(101), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame(), BizNumber.valueOf(102), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown(), BizNumber.valueOf(103), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(105), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(106), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(107), " 円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(108), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(109), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(110), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup(), BizCurrency.valueOf(111), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame(), BizCurrency.valueOf(112), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown(), BizCurrency.valueOf(113), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(114), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(115), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(116), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(117), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(118), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(119), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(120), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(121), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(122), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin(), BizCurrency.valueOf(123), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame(), BizCurrency.valueOf(124), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(125), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(126), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(127), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(128), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu1(), BizNumber.valueOf(129), "指数上昇率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu1(), BizNumber.valueOf(130), "積立金増加率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake11(), BizCurrency.valueOf(131), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake21(), BizCurrency.valueOf(132), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(133), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(134), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(135), "ＭＶＡ適用積立金額（解約控除前）（低下）１");

        exBizCalcbleEquals(suiihyouLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(1000), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin", "業務用更新機能ＩＤ");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup2(), BizNumber.valueOf(1), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame2(), BizNumber.valueOf(2), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown2(), BizNumber.valueOf(3), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup2(), BizNumber.valueOf(4), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown2(), BizNumber.valueOf(5), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(6), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(7), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(8), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(9), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu2(), BizNumber.valueOf(11), "指数上昇率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu2(), BizNumber.valueOf(12), "積立金増加率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(13), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(14), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(15), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup2(), BizCurrency.valueOf(16), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame2(), BizCurrency.valueOf(17), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown2(), BizCurrency.valueOf(18), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka2(), BizCurrency.valueOf(19), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(20), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(21), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka2(), BizCurrency.valueOf(22), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(23), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(24), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka2(), BizCurrency.valueOf(25), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(26), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(27), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin2(), BizCurrency.valueOf(28), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame2(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka2(), BizCurrency.valueOf(30), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(31), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(32), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin2(), BizCurrency.valueOf(33), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake12(), BizCurrency.valueOf(34), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake22(), BizCurrency.valueOf(35), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup3(), BizNumber.valueOf(36), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame3(), BizNumber.valueOf(37), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown3(), BizNumber.valueOf(38), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup3(), BizNumber.valueOf(39), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown3(), BizNumber.valueOf(40), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(41), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(42), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(43), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(44), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(45), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu3(), BizNumber.valueOf(46), "指数上昇率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu3(), BizNumber.valueOf(47), "積立金増加率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(48), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(49), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(50), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup3(), BizCurrency.valueOf(51), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame3(), BizCurrency.valueOf(52), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown3(), BizCurrency.valueOf(53), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka3(), BizCurrency.valueOf(54), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(56), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka3(), BizCurrency.valueOf(57), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(58), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(59), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka3(), BizCurrency.valueOf(60), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(61), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(62), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin3(), BizCurrency.valueOf(63), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame3(), BizCurrency.valueOf(64), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka3(), BizCurrency.valueOf(65), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(66), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(67), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin3(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake13(), BizCurrency.valueOf(69), " 積立金内訳（１）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake23(), BizCurrency.valueOf(70), "積立金内訳（２）３");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "06", "推移表種別");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000035");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181020);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN1;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkinMockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "123", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(1.2345), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 11, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1010), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20181015), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.5432), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(201810), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(770), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(230), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0.1234), "積立利率");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20181001), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20181005), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 10, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(0.12), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(0.1234), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(23), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(1000), "ターゲット特約基準金額");

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "件数");
        exStringEquals(suiihyouLst.get(0).getSyono(),"17806000035", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20181020), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 99, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), null, "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), null, "計算年月");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(suiihyouLst.get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "00", "推移表種別");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000046");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SIN;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN3;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkinMockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "123", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(1.2345), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 11, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1010), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20181015), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.5432), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(201810), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(770), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(230), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0.1234), "積立利率");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20181001), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20181005), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 10, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(0.12), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(0.1234), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(23), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(1000), "ターゲット特約基準金額");

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 3, "件数");

        for (int i = 0; i < suiihyouLst.size(); i++) {
            exStringEquals(suiihyouLst.get(i).getSyono(), "17806000046", "証券番号");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20181001), "帳票作成日");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), 1, "経過年数");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20181001), "計算基準日");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDateYM.valueOf(201810), "計算年月");
            exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");

            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(101), "市場価格調整用利率（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(102), "市場価格調整用利率（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(103), "市場価格調整用利率（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（上）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(105), "市場価格調整用利率変動幅（下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka(), BizNumber.valueOf(106), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(107), " 円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(108), "円換算適用為替レート（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(109), "円換算適用為替レート変動額（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(110), "円換算適用為替レート変動額（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(111), "ＭＶＡ適用解約返戻金額（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(112), "ＭＶＡ適用解約返戻金額（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(113), "ＭＶＡ適用解約返戻金額（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(114), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(115), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(116), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(117), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(118), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(119), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(120), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(121), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(122), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(123), "ＭＶＡ適用保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(124), "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(125), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(126), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(127), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(128), "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu1(), BizNumber.valueOf(129), "指数上昇率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu1(), BizNumber.valueOf(130), "積立金増加率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake11(), BizCurrency.valueOf(131), "積立金内訳（１）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake21(), BizCurrency.valueOf(132), "積立金内訳（２）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(133), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(134), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(135), "ＭＶＡ適用積立金額（解約控除前）（低下）１");

            exBizCalcbleEquals(suiihyouLst.get(i).getMkhyouyensysnikougk(), BizCurrency.valueOf(1000), "目標到達時円建終身保険移行特約目標額");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin", "業務用更新機能ＩＤ");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup2(), BizNumber.valueOf(1), "市場価格調整用利率（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame2(), BizNumber.valueOf(2), "市場価格調整用利率（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown2(), BizNumber.valueOf(3), "市場価格調整用利率（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup2(), BizNumber.valueOf(4), "市場価格調整用利率変動幅（上）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown2(), BizNumber.valueOf(5), "市場価格調整用利率変動幅（下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(6), "円換算適用為替レート（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(7), "円換算適用為替レート（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(8), "円換算適用為替レート（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(9), "円換算適用為替レート変動額（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu2(), BizNumber.valueOf(11), "指数上昇率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu2(), BizNumber.valueOf(12), "積立金増加率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(13), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(14), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(15), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup2(), BizCurrency.valueOf(16), "ＭＶＡ適用解約返戻金額（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame2(), BizCurrency.valueOf(17), "ＭＶＡ適用解約返戻金額（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown2(), BizCurrency.valueOf(18), "ＭＶＡ適用解約返戻金額（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka2(), BizCurrency.valueOf(19), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(20), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(21), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka2(), BizCurrency.valueOf(22), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(23), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(24), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka2(), BizCurrency.valueOf(25), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(26), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(27), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin2(), BizCurrency.valueOf(28), "ＭＶＡ適用保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(30), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(31), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(32), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(33), "ＭＶＡ適用外保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake12(), BizCurrency.valueOf(34), "積立金内訳（１）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake22(), BizCurrency.valueOf(35), "積立金内訳（２）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup3(), BizNumber.valueOf(36), "市場価格調整用利率（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame3(), BizNumber.valueOf(37), "市場価格調整用利率（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown3(), BizNumber.valueOf(38), "市場価格調整用利率（低下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup3(), BizNumber.valueOf(39), "市場価格調整用利率変動幅（上）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown3(), BizNumber.valueOf(40), "市場価格調整用利率変動幅（下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(41), "円換算適用為替レート（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(42), "円換算適用為替レート（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(43), "円換算適用為替レート（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(44), "円換算適用為替レート変動額（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(45), "円換算適用為替レート変動額（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu3(), BizNumber.valueOf(46), "指数上昇率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu3(), BizNumber.valueOf(47), "積立金増加率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(48), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(49), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(50), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup3(), BizCurrency.valueOf(51), "ＭＶＡ適用解約返戻金額（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame3(), BizCurrency.valueOf(52), "ＭＶＡ適用解約返戻金額（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown3(), BizCurrency.valueOf(53), "ＭＶＡ適用解約返戻金額（低下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka3(), BizCurrency.valueOf(54), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(56), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka3(), BizCurrency.valueOf(57), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(58), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(59), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka3(), BizCurrency.valueOf(60), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(61), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(62), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin3(), BizCurrency.valueOf(63), "ＭＶＡ適用保険料積立金３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(64), "ＭＶＡ適用外解約返戻金額３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(65), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(66), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(67), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake13(), BizCurrency.valueOf(69), " 積立金内訳（１）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake23(), BizCurrency.valueOf(70), "積立金内訳（２）３");
            if (i == 0) {
                exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "00", "推移表種別");
            }
            else if (i == 1) {
                exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "01", "推移表種別");
            }
            else {
                exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "06", "推移表種別");
            }
        }
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000057");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SIN;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN4;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("User1");
        KhozenCommonParam pKkanriCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin");
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000068");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya pHhknSya = new IT_HhknSya();
        BizDate pSyoriYmd = BizDate.valueOf(20181001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181005));
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.BLNK;
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setMvatekikkn(10);
        pSyouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        IT_KykSonotaTkyk pKykSonotaTkyk = new IT_KykSonotaTkyk();
        pKykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(1000));


        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkinMockForHozen.SYORIPTN = WSuiihyouNenkinMockForHozen.TESTPATTERN3;

        editSuiihyouTblNenkin.editTBL(pKkanriCommonParam,
            pKykKihon,
            pKykSyohnSyuLst,
            pKykSyouhnLst,
            pHhknSya,
            pSyoriYmd,
            pEditHokenSyoukenParam,
            pCSinsaihkKbn,
            pSyouhnZokusei,
            pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "件数");

        exStringEquals(suiihyouLst.get(0).getSyono(), "17806000068", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20181001), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), BizDate.valueOf(20181001), "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), BizDateYM.valueOf(201810), "計算年月");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exClassificationEquals(suiihyouLst.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");

        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup(), BizNumber.valueOf(101), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame(), BizNumber.valueOf(102), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown(), BizNumber.valueOf(103), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(105), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(106), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(107), " 円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(108), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(109), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(110), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup(), BizCurrency.valueOf(111), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame(), BizCurrency.valueOf(112), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown(), BizCurrency.valueOf(113), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(114), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(115), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(116), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(117), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(118), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(119), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(120), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(121), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(122), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin(), BizCurrency.valueOf(123), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame(), BizCurrency.valueOf(124), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(125), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(126), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(127), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(128), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu1(), BizNumber.valueOf(129), "指数上昇率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu1(), BizNumber.valueOf(130), "積立金増加率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake11(), BizCurrency.valueOf(131), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake21(), BizCurrency.valueOf(132), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(133), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(134), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(135), "ＭＶＡ適用積立金額（解約控除前）（低下）１");

        exBizCalcbleEquals(suiihyouLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(1000), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin", "業務用更新機能ＩＤ");
        exStringEquals(suiihyouLst.get(0).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup2(), BizNumber.valueOf(1), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame2(), BizNumber.valueOf(2), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown2(), BizNumber.valueOf(3), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup2(), BizNumber.valueOf(4), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown2(), BizNumber.valueOf(5), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(6), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(7), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(8), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(9), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu2(), BizNumber.valueOf(11), "指数上昇率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu2(), BizNumber.valueOf(12), "積立金増加率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(13), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(14), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(15), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup2(), BizCurrency.valueOf(16), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame2(), BizCurrency.valueOf(17), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown2(), BizCurrency.valueOf(18), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka2(), BizCurrency.valueOf(19), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(20), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(21), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka2(), BizCurrency.valueOf(22), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(23), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(24), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka2(), BizCurrency.valueOf(25), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(26), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(27), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin2(), BizCurrency.valueOf(28), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame2(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka2(), BizCurrency.valueOf(30), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(31), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(32), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin2(), BizCurrency.valueOf(33), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake12(), BizCurrency.valueOf(34), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake22(), BizCurrency.valueOf(35), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtup3(), BizNumber.valueOf(36), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtsame3(), BizNumber.valueOf(37), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrtdown3(), BizNumber.valueOf(38), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendouup3(), BizNumber.valueOf(39), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSjkkktusirrthendoudown3(), BizNumber.valueOf(40), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(41), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(42), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(43), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(44), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(45), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu3(), BizNumber.valueOf(46), "指数上昇率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTmttknzoukaritu3(), BizNumber.valueOf(47), "積立金増加率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(48), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(49), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(50), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwup3(), BizCurrency.valueOf(51), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwsame3(), BizCurrency.valueOf(52), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwdown3(), BizCurrency.valueOf(53), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyendaka3(), BizCurrency.valueOf(54), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(56), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyendaka3(), BizCurrency.valueOf(57), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(58), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(59), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyendaka3(), BizCurrency.valueOf(60), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(61), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(62), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvaariptumitatekin3(), BizCurrency.valueOf(63), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewsame3(), BizCurrency.valueOf(64), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyendaka3(), BizCurrency.valueOf(65), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(66), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(67), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getMvanoneptumitatekin3(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake13(), BizCurrency.valueOf(69), " 積立金内訳（１）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getTutmttknutiwake23(), BizCurrency.valueOf(70), "積立金内訳（２）３");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "00", "推移表種別");
        exClassificationEquals(suiihyouLst.get(0).getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyouLst.get(0).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyouLst.get(0).getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
    }

}
