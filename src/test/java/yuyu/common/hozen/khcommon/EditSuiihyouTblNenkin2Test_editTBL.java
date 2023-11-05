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
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 推移表ＴＢＬ編集のメソッド {@link EditSuiihyouTblNenkin2#editTBL(KhozenCommonParam, IT_KykKihon,
 *  List<IT_KykSyouhn>, List<IT_KykSyouhn>, IT_HhknSya, BizDate, EditHokenSyoukenParam, C_SinsaihkKbn, BM_SyouhnZokusei, IT_KykSonotaTkyk,IT_Zennou)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblNenkin2Test_editTBL {

    @Inject
    private EditSuiihyouTblNenkin2 ditSuiihyouTblNenkin2;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_推移表ＴＢＬ編集（年金）２";
    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WSuiihyouNenkin2.class).to(WSuiihyouNenkin2MockForHozen.class);
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        WSuiihyouNenkin2MockForHozen.caller = EditSuiihyouTblNenkin2Test_editTBL.class;
        KeisanWExtMockForHozen.caller = EditSuiihyouTblNenkin2Test_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WSuiihyouNenkin2MockForHozen.caller = null;
        WSuiihyouNenkin2MockForHozen.SYORIPTN = null;
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditSuiihyouTblNenkin2Test_editTBL.class, fileName, sheetName);

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

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditTBL_A1() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190305);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_Zennou zennou = null;

        try {
            ditSuiihyouTblNenkin2.editTBL(
                khozenCommonParam,
                kykKihon,
                kykSyouhnSyuLst,
                kykSyouhnTkLst,
                hhknSya,
                syoriYmd,
                editHokenSyoukenParam,
                C_SinsaihkKbn.SIN,
                syouhnZokusei,
                kykSonotaTkyk,
                zennou);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。予定利率取得が実行できませんでした。", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN1;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190305);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000024");
        IT_Zennou zennou = ansyuKihon.getZennous().get(0);

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SIN,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkin2MockForHozen.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｲ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "2", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(2.2), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 2, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 3, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 62, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(102), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(202), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20190305), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.2), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), BizDate.valueOf(20190201), "初回保険料領収日");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20190201), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20190401), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exBizCalcbleEquals(wSuiihyouParam.getHeijyunP(), BizCurrency.valueOf(302), "平準払Ｐ");
        exBizCalcbleEquals(wSuiihyouParam.getYoteiRirituList().get(0), BizNumber.valueOf(0.0125), "予定利率リスト[0]");
        exBizCalcbleEquals(wSuiihyouParam.getYoteiRirituList().get(1), BizNumber.valueOf(1.2), "予定利率リスト[1]");
        exClassificationEquals(wSuiihyouParam.getZennouUmuKbn(), C_UmuKbn.ARI, "前納有無区分");
        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(100), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), BizDate.valueOf(20190302), "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), BizDate.valueOf(20190302), "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), BizCurrency.valueOf(200), "前納入金額");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 12, "件数");

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            exStringEquals(suiihyouLst.get(i).getSyono(), "17806000024", "証券番号");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20190305), "帳票作成日");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), 1, "経過年数");
            if (i == 9) {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20140302), "計算基準日");
            }
            else {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20190302), "計算基準日");
            }
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDateYM.valueOf(201901), "計算年月");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "1", "推移表種別");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(2), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(3), "円換算適用為替レート（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(4), "円換算適用為替レート変動額（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(5), "円換算適用為替レート変動額（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(6), "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(7), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(8), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(9), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(10), "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(11), "円換算適用為替レート（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(12), "円換算適用為替レート（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(13), "円換算適用為替レート（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(14), "円換算適用為替レート変動額（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(15), "円換算適用為替レート変動額（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(16), "ＭＶＡ適用外解約返戻金額２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(17), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(18), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(19), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(20), "ＭＶＡ適用外保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(21), "円換算適用為替レート（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(22), "円換算適用為替レート（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(23), "円換算適用為替レート（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(24), "円換算適用為替レート変動額（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(25), "円換算適用為替レート変動額（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(26), "ＭＶＡ適用外解約返戻金額３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(27), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(28), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(30), "ＭＶＡ適用外保険料積立金３");
            exClassificationEquals(suiihyouLst.get(i).getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(31), "予定利率計算基準利率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(32), "予定利率計算基準利率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(33), "予定利率計算基準利率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen1(), BizCurrency.valueOf(34), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen2(), BizCurrency.valueOf(35), "前納残高（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen3(), BizCurrency.valueOf(36), "前納残高（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen1(), BizCurrency.valueOf(37), "既払込保険料（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen2(), BizCurrency.valueOf(38), "既払込保険料（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen3(), BizCurrency.valueOf(39), "既払込保険料（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp1(), BizCurrency.valueOf(40), "既払込保険料１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp2(), BizCurrency.valueOf(41), "既払込保険料２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp3(), BizCurrency.valueOf(42), "既払込保険料３");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin2", "業務用更新機能ＩＤ");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User１", "業務用更新者ＩＤ");

            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
            exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu1(), BizNumber.ZERO, "指数上昇率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu2(), BizNumber.ZERO, "指数上昇率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu3(), BizNumber.ZERO, "指数上昇率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        }

    }


    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN2;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190306);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_Zennou zennou = null;

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);
        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkin2MockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｲ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "6", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(2.6), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 6, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 7, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 66, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(106), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(206), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20190305), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.6), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), BizDate.valueOf(20190201), "初回保険料領収日");

        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getZennouUmuKbn(), C_UmuKbn.NONE, "前納有無区分");
        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(0), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), BizCurrency.valueOf(0), "前納入金額");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 2, "件数");

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            exStringEquals(suiihyouLst.get(i).getSyono(), "17806000068", "証券番号");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20190306), "帳票作成日");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), 1, "経過年数");
            if (i == 0) {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20190302), "計算基準日");
            }
            else {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20190303), "計算基準日");
            }
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDateYM.valueOf(201901), "計算年月");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "1", "推移表種別");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(2), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(3), "円換算適用為替レート（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(4), "円換算適用為替レート変動額（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(5), "円換算適用為替レート変動額（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(6), "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(7), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(8), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(9), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(10), "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(11), "円換算適用為替レート（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(12), "円換算適用為替レート（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(13), "円換算適用為替レート（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(14), "円換算適用為替レート変動額（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(15), "円換算適用為替レート変動額（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(16), "ＭＶＡ適用外解約返戻金額２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(17), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(18), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(19), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(20), "ＭＶＡ適用外保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(21), "円換算適用為替レート（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(22), "円換算適用為替レート（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(23), "円換算適用為替レート（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(24), "円換算適用為替レート変動額（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(25), "円換算適用為替レート変動額（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(26), "ＭＶＡ適用外解約返戻金額３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(27), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(28), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(30), "ＭＶＡ適用外保険料積立金３");
            exClassificationEquals(suiihyouLst.get(i).getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(31), "予定利率計算基準利率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(32), "予定利率計算基準利率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(33), "予定利率計算基準利率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen1(), BizCurrency.valueOf(34), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen2(), BizCurrency.valueOf(35), "前納残高（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen3(), BizCurrency.valueOf(36), "前納残高（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen1(), BizCurrency.valueOf(37), "既払込保険料（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen2(), BizCurrency.valueOf(38), "既払込保険料（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen3(), BizCurrency.valueOf(39), "既払込保険料（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp1(), BizCurrency.valueOf(40), "既払込保険料１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp2(), BizCurrency.valueOf(41), "既払込保険料２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp3(), BizCurrency.valueOf(42), "既払込保険料３");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin2", "業務用更新機能ＩＤ");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User１", "業務用更新者ＩＤ");

        }

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN3;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190304);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_Zennou zennou = null;

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);
        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkin2MockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｲ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "8", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(2.8), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 8, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 9, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 68, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(108), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(208), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20190305), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.8), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), BizDate.valueOf(20190201), "初回保険料領収日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SAI, "新規再発行区分");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 0, "件数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190305);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_Zennou zennou = null;

        try {
            ditSuiihyouTblNenkin2.editTBL(
                khozenCommonParam,
                kykKihon,
                kykSyouhnSyuLst,
                kykSyouhnTkLst,
                hhknSya,
                syoriYmd,
                editHokenSyoukenParam,
                C_SinsaihkKbn.BLNK,
                syouhnZokusei,
                kykSonotaTkyk,
                zennou);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN4;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190306);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_Zennou zennou = null;

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);
        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouNenkin2MockForHozen.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｻ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "789", "料率世代番号");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 12, "件数");

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            exStringEquals(suiihyouLst.get(i).getSyono(), "17806000091", "証券番号");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20190306), "帳票作成日");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), 1, "経過年数");
            if (i == 9) {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20140303), "計算基準日");
            }
            else {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20190303), "計算基準日");
            }
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDateYM.valueOf(201901), "計算年月");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "1", "推移表種別");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(2), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(3), "円換算適用為替レート（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(4), "円換算適用為替レート変動額（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(5), "円換算適用為替レート変動額（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(6), "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(7), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(8), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(9), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(10), "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(11), "円換算適用為替レート（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(12), "円換算適用為替レート（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(13), "円換算適用為替レート（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(14), "円換算適用為替レート変動額（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(15), "円換算適用為替レート変動額（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(16), "ＭＶＡ適用外解約返戻金額２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(17), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(18), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(19), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(20), "ＭＶＡ適用外保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(21), "円換算適用為替レート（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(22), "円換算適用為替レート（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(23), "円換算適用為替レート（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(24), "円換算適用為替レート変動額（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(25), "円換算適用為替レート変動額（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(26), "ＭＶＡ適用外解約返戻金額３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(27), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(28), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(30), "ＭＶＡ適用外保険料積立金３");
            exClassificationEquals(suiihyouLst.get(i).getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(31), "予定利率計算基準利率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(32), "予定利率計算基準利率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(33), "予定利率計算基準利率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen1(), BizCurrency.valueOf(34), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen2(), BizCurrency.valueOf(35), "前納残高（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen3(), BizCurrency.valueOf(36), "前納残高（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen1(), BizCurrency.valueOf(37), "既払込保険料（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen2(), BizCurrency.valueOf(38), "既払込保険料（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen3(), BizCurrency.valueOf(39), "既払込保険料（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp1(), BizCurrency.valueOf(40), "既払込保険料１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp2(), BizCurrency.valueOf(41), "既払込保険料２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp3(), BizCurrency.valueOf(42), "既払込保険料３");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin2", "業務用更新機能ＩＤ");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User１", "業務用更新者ＩＤ");
        }

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN3;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190306);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_Zennou zennou = null;

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN3;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190306);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_Zennou zennou = null;

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        MockObjectManager.initialize();
        WSuiihyouNenkin2MockForHozen.SYORIPTN = WSuiihyouNenkin2MockForHozen.TESTPATTERN5;
        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblNenkin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20190305);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20140401));

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("11807111174");
        IT_Zennou zennou = ansyuKihon.getZennous().get(0);

        ditSuiihyouTblNenkin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SIN,
            syouhnZokusei,
            kykSonotaTkyk,
            zennou);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 11, "件数");

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            exStringEquals(suiihyouLst.get(i).getSyono(), "11807111174", "証券番号");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20190305), "帳票作成日");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), 1, "経過年数");
            if (i == 9) {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20140303), "計算基準日");
            }
            else {
                exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20190302), "計算基準日");
            }
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDateYM.valueOf(201901), "計算年月");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "1", "推移表種別");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(2), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(3), "円換算適用為替レート（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(4), "円換算適用為替レート変動額（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(5), "円換算適用為替レート変動額（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(6), "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(7), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(8), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(9), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(10), "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(11), "円換算適用為替レート（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(12), "円換算適用為替レート（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(13), "円換算適用為替レート（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(14), "円換算適用為替レート変動額（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(15), "円換算適用為替レート変動額（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(16), "ＭＶＡ適用外解約返戻金額２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(17), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(18), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(19), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(20), "ＭＶＡ適用外保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(21), "円換算適用為替レート（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(22), "円換算適用為替レート（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(23), "円換算適用為替レート（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(24), "円換算適用為替レート変動額（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(25), "円換算適用為替レート変動額（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(26), "ＭＶＡ適用外解約返戻金額３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(27), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(28), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(29), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(30), "ＭＶＡ適用外保険料積立金３");
            exClassificationEquals(suiihyouLst.get(i).getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(31), "予定利率計算基準利率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(32), "予定利率計算基準利率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(33), "予定利率計算基準利率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen1(), BizCurrency.valueOf(34), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen2(), BizCurrency.valueOf(35), "前納残高（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen3(), BizCurrency.valueOf(36), "前納残高（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen1(), BizCurrency.valueOf(37), "既払込保険料（円貨）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen2(), BizCurrency.valueOf(38), "既払込保険料（円貨）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen3(), BizCurrency.valueOf(39), "既払込保険料（円貨）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp1(), BizCurrency.valueOf(40), "既払込保険料１");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp2(), BizCurrency.valueOf(41), "既払込保険料２");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp3(), BizCurrency.valueOf(42), "既払込保険料３");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblNenkin2", "業務用更新機能ＩＤ");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User１", "業務用更新者ＩＤ");

            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
            exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
            exBizCalcbleEquals(suiihyouLst.get(i).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu1(), BizNumber.ZERO, "指数上昇率１");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu2(), BizNumber.ZERO, "指数上昇率２");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu3(), BizNumber.ZERO, "指数上昇率３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        }

    }
}
