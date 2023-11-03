package yuyu.common.hozen.setuibean;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
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
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutaiMockForHozen;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.KeisanCV;
import yuyu.common.hozen.khcommon.KeisanCVMockForHozen;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanKijyungkMockForHozen;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanV;
import yuyu.common.hozen.khcommon.KeisanVMockForHozen;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisan;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisanMockForHozen;
import yuyu.common.hozen.khcommon.TokujoSSakugenNaiyouKeisan;
import yuyu.common.hozen.khcommon.TokujoSSakugenNaiyouKeisanMockForHozen;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保障内容のメソッド{@link SetHosyou#exec(KhozenCommonParam, SetHosyouExecUiBeanParam)}
 *                         テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHosyouTest_exec extends AbstractTest{
    private final static String dSyono1 = "10806000016";
    private final static String dSyono2 = "10806000027";
    private final static String dSyono3 = "10806000038";
    private final static String dSyono4 = "10806000049";
    private final static String dSyono5 = "10806000050";
    private final static String dSyono6 = "10806000061";
    private final static String dSyono7 = "10806000072";
    private final static String dSyono8 = "10806000108";
    private final static String dSyono9 = "10806000201";
    private final static String dSyono10 = "10806000212";
    private final static String dSyono11 = "12806345672";
    private final static String dSyono12 = "11807111196";
    private final static String dSyono13 = "11807111141";
    private final static String dSyono14 = "11807111129";
    private final static String dSyono15 = "11807111233";
    private final static String dSyono16 = "60806000011";
    private final static String dSyono17 = "60806000033";
    private final static String dSyono18 = "60806000192";
    private final static String dSyono19 = "11807111576";
    private final static String dSyono20 = "11807111587";
    private final static String dSyono21 = "11807195998";
    private final static String dSyono22 = "11807196003";
    private final static String dSyono23 = "11807196014";
    private final static String dSyono24 = "99806001191";
    private final static String dSyono25 = "99806001021";
    private final static String dSyono26 = "99806001249";
    private final static String dSyono27 = "99806001113";
    private final static String dSyono28 = "17806000013";
    private final static String dSyono29 = "17806000024";
    private KhozenCommonParam khozenCommonParam;
    private SetHosyouExecUiBeanParamImpl setHosyouExecUiBeanParamImpl;

    private SetHosyou setHosyou;

    private final static String fileName = "UT_SP_単体テスト仕様書_保障内容設定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SyouhntaniKousingoPkeisan.class).to(SyouhntaniKousingoPkeisanMockForHozen.class);
                bind(TokujoSSakugenNaiyouKeisan.class).to(TokujoSSakugenNaiyouKeisanMockForHozen.class);
                bind(KeisanV.class).to(KeisanVMockForHozen.class);
                bind(KeisanCV.class).to(KeisanCVMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class);
                bind(KeisanKijyungk.class).to(KeisanKijyungkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SyouhntaniKousingoPkeisanMockForHozen.caller = SetHosyouTest_exec.class;
        TokujoSSakugenNaiyouKeisanMockForHozen.caller = SetHosyouTest_exec.class;
        KeisanVMockForHozen.caller = SetHosyouTest_exec.class;
        KeisanCVMockForHozen.caller = SetHosyouTest_exec.class;
        CalcHkShrKngkMockForHozen.caller = SetHosyouTest_exec.class;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.caller = SetHosyouTest_exec.class;
        KeisanKijyungkMockForHozen.caller = SetHosyouTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        SyouhntaniKousingoPkeisanMockForHozen.caller = null;
        TokujoSSakugenNaiyouKeisanMockForHozen.caller = null;
        KeisanVMockForHozen.caller = null;
        KeisanCVMockForHozen.caller = null;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = null;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = null;
        KeisanVMockForHozen.SYORIPTN = null;
        KeisanCVMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.caller = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.caller = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
        KeisanKijyungkMockForHozen.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHosyouTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllHutanpoBui());
        bizDomManager.delete(bizDomManager.getAllSisuuKihon());

        bizDomManager.delete(bizDomManager.getAllFundIndexKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyouExecUiBeanParamImpl.setSyono(dSyono1);
        String errorMessage = null;
        try {
            setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);
        } catch (CommonBizAppException ex) {
            errorMessage = ex.getMessage();
        }
        exStringEquals(errorMessage, "システム整合性エラーです。契約商品TBL 証券番号=10806000016", "エラーメッセージ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20150203));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "10806000027", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.getSysDate().toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2).toString(), C_SiinKbn.SP.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の死因区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBHOKENKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 4).toString(), C_Sdpd.SD.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出のＳ建Ｐ建区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 5).toString(), C_Hrkkeiro.KOUHURI.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の払込経路");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 0).toString(), "10806000027", "保険金額計算（解約返戻金計算拡張情報作成）の２次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 1).toString(), BizDate.getSysDate().toString(), "保険金額計算（解約返戻金計算拡張情報作成）の２次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 2).toString(), C_SiinKbn.SG.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の２次呼出の死因区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 3).toString(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の２次呼出の保険金種類区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 4).toString(), C_Sdpd.SD.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出のＳ建Ｐ建区分");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1, 5).toString(), C_Hrkkeiro.KOUHURI.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の払込経路");

        MockObjectManager.assertArgumentPassed(SyouhinUtil.class, "hantei", 0, "M110");

        GetSjkkktyouseiyourirituBean bean = (GetSjkkktyouseiyourirituBean)MockObjectManager.getArgument(GetSjkkktyouseiyouriritu.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhncd(), "M110",                            "市場価格調整用利率取得＃メイン処理の呼出の商品コード");
        exDateEquals(bean.getKijyunymd(), BizDate.getSysDate(),             "市場価格調整用利率取得＃メイン処理の呼出の基準日");
        exNumericEquals(bean.getHknkkn(), 2,                                "市場価格調整用利率取得＃メイン処理の呼出の保険期間");
        exClassificationEquals(bean.getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "市場価格調整用利率取得＃メイン処理の呼出の保険期間歳満期区分");
        exNumericEquals(bean.getHhknnen(), 0,                               "市場価格調整用利率取得＃メイン処理の呼出の被保険者年齢");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "10806000027", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20150202), "契約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 0), BizDate.valueOf(20150202), "契約年月日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 1), BizDate.valueOf(20150203), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 2), null, "次回Ｐ充当年月");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 3), null, "払込回数");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 4), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exStringEquals((String)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 5), "M110", "商品コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWKijunYM.class, "exec", 0, 6), null, "円建変更日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 0), BizDate.valueOf(20150202), "契約日");
        exNumericEquals((Integer)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 1), 2, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 2), C_UmuKbn.NONE, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 3), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 4), BizDate.valueOf(20150203), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 5), BizDateYM.valueOf(201502), "計算基準年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 6), BizDateYM.valueOf(201803), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 7), BizNumber.valueOf(4.4), "積立利率");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 8), BizCurrency.valueOf(40000), "定率積立金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttkn.class, "exec", 0, 9), BizCurrency.valueOf(404), "指数連動積立金額");

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "入院保険", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuaisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "（保障内容）愛称名区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 11, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(0), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), BizCurrency.valueOf(0), "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), null, "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), null, "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(0), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyohinhanteikbn(), 999, "（保障内容）主契約商品判定区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyumvatekiumu(), C_UmuKbn.ARI, "（保障内容）主契約ＭＶＡ適用有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusbhkuktumu(), C_UmuKbn.ARI, "（保障内容）主契約死亡保険金受取有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusbkyuuhukinuktumu(), C_UmuKbn.ARI, "（保障内容）主契約死亡給付金受取有無");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkymd(), null, "（保障内容）円建変更日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf("20150204"), "（保障内容）積立金移転日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkshrstartymd(), BizDate.valueOf("20180310"), "（保障内容）主契約年金支払開始日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.valueOf(40).toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(60).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "指数名０１", "（保障内容）指数名");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusetteibairitu().toString(), BizNumber.valueOf(2.2).toString(), "（保障内容）設定倍率");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu().toString(), BizNumber.valueOf(330).toString(), "（保障内容）予定利率");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyutumitateriritu().toString(), BizNumber.valueOf(440).toString(), "（保障内容）積立利率");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyukyksjkkktyouseiriritu().toString(), BizNumber.valueOf(550).toString(), "（保障内容）契約時市場価格調整用利率");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuskisjkkktyouseiriritu().toString(), BizNumber.valueOf(880).toString(), "（保障内容）照会時市場価格調整用利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), null, "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), null, "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), null, "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), null, "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), null, "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), null, "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), null, "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), null, "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), null, "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), null, "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.BLNK, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(0), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(),null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.NONE, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.NONE, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.NONE, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.NONE, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(1000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.NONE, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.NONE, "（保障内容）主契約次回更新有無");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        changeSystemDate(BizDate.valueOf(20150203));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono3);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "商品名Ｚ１３０", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 12, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(0), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), BizCurrency.valueOf(0), "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), null, "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), null, "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(0), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(), null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.valueOf(30).toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(70).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "", "（保障内容）指数名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), null, "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), null, "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), null, "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), null, "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), null, "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), null, "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), null, "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), null, "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), null, "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), null, "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.BLNK, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(0), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(), null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.NONE, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.NONE, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.NONE, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.NONE, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(1000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.NONE, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.NONE, "（保障内容）主契約次回更新有無");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu().toString(), BizNumber.valueOf(0).toString(), "（保障内容）予定利率");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf("20150205"), "（保障内容）積立金移転日");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuskisjkkktyouseiriritu().toString(), BizNumber.valueOf(0).toString(), "（保障内容）照会時市場価格調整用利率");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        changeSystemDate(BizDate.valueOf(20150203));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono4);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "商品名Ｚ１４０", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 13, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(0), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), null, "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), BizDate.valueOf(20150302), "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), BizDate.valueOf(20160201), "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(10000), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.ZERO.toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(100).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "", "（保障内容）指数名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), null, "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), null, "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), null, "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), null, "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), null, "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), null, "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), null, "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), null, "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), null, "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), null, "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(30000), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.ONE, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.TOW, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.THREE, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.ARI, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(), null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.NONE, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.NONE, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.ARI, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.ARI, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(1000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.ARI, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.NONE, "（保障内容）主契約次回更新有無");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf("20150203"), "（保障内容）積立金移転日");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        changeSystemDate(BizDate.valueOf(20150203));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN3;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono5);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "商品名Ｚ１５０", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 14, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(0), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), BizCurrency.valueOf(0), "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), null, "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), null, "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(0), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.Y1, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), BizDate.valueOf(20160101), "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), BizDate.valueOf(20161201), "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(10000), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), null, "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), null, "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), null, "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), null, "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), null, "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), null, "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), null, "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), null, "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(31000), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "601", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "不担保部位名６０１", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.ONE, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "602", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "不担保部位名６０２", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.TOW, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "603", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "不担保部位名６０３", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.THREE, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "604", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "不担保部位名６０４", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.FOUR, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(), null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.ARI, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.NONE, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.NONE, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.NONE, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(3000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.ARI, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.NONE, "（保障内容）主契約次回更新有無");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf("20150202"), "（保障内容）積立金移転日");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.ZERO.toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(100).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "", "（保障内容）指数名");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN4;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN5;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono6);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "商品名Ｚ１６０", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 15, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(0), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), BizCurrency.valueOf(0), "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), null, "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), null, "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(0), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.Y3, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), BizDate.valueOf(20160101), "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), BizDate.valueOf(20161201), "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(10000), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), BizDate.valueOf(20160102), "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), BizDate.valueOf(20161202), "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(20000), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), BizDate.valueOf(20160103), "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), BizDate.valueOf(20161203), "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(30000), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), null, "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), null, "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), null, "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), null, "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(0), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(31000), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.ONE, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.TOW, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.THREE, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.ARI, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(), null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.NONE, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.ARI, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.NONE, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.NONE, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(3000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.NONE, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.ARI, "（保障内容）主契約次回更新有無");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), null, "（保障内容）積立金移転日");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.valueOf(20).toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(80).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "指数名０２", "（保障内容）指数名");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN6;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN6;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono7);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyouhnnm(), "商品名Ｚ１７０", "（保障内容）主契約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約通貨種類");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukatakbn(), C_KataKbn.HONNIN, "（保障内容）主契約型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "（保障内容）主契約給付限度型区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhhknnen(), 52, "（保障内容）主契約被保険者年齢");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykymd(), BizDate.valueOf(20150202), "（保障内容）主契約契約日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusknnkaisiymd(), BizDate.valueOf(20150302), "（保障内容）主契約責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyugansknnkaisiymd(), BizDate.valueOf(20150602), "（保障内容）がん責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyufktsknnkaisiymd(), BizDate.valueOf(20150702), "（保障内容）主契約復活責任開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyuhkgogansknnkaisiymd(), BizDate.valueOf(20150802), "（保障内容）復活後がん責任開始日");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkkn(), 2, "（保障内容）主契約保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "（保障内容）主契約保険期間歳満期区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkkn(), 16, "（保障内容）第１保険期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusdpdkbn(), C_Sdpd.SD, "（保障内容）Ｓ建Ｐ建区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkkn(), 12, "（保障内容）主契約払込期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）主契約払込期間歳満期区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonssyuruikbn(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）主契約基本Ｓ種類区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihons(), BizCurrency.valueOf(20000), "（保障内容）主契約基本保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(), BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusaigaisbhknkngaku(), BizCurrency.valueOf(30001), "（保障内容）災害死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukihonkyhgk(), BizCurrency.valueOf(40000), "（保障内容）主契約基本給付金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyup(), BizCurrency.valueOf(21000), "（保障内容）主契約保険料");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosgop(), BizCurrency.valueOf(50000), "（保障内容）主契約次回更新後保険料");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "（保障内容）主契約手術給付金型区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyurokudaildkbn(), C_6daiLdKbn.ARI, "（保障内容）主契約６大生活習慣病追加給付型区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhntgk(), BizCurrency.valueOf(0), "（保障内容）主契約がん入院給付日額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnstartymd(), BizDate.valueOf(20150302), "（保障内容）主契約支払削減開始日");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgnendymd(), BizDate.valueOf(20160201), "（保障内容）主契約支払削減終了日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyushrskgngos(), BizCurrency.valueOf(10000), "（保障内容）主契約支払削減後保険金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunnkinsyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）主契約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunenkinkkn(), 5, "（保障内容）主契約年金期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnkkn(), C_Tkjyskgnkkn.Y5, "（保障内容）主契約特条削減期間");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd1(), BizDate.valueOf(20160101), "（保障内容）主契約特条削減保険年度開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd1(), BizDate.valueOf(20161201), "（保障内容）主契約特条削減保険年度終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns1(), BizCurrency.valueOf(10000), "（保障内容）主契約特条削減保険金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd2(), BizDate.valueOf(20160102), "（保障内容）主契約特条削減保険年度開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd2(), BizDate.valueOf(20161202), "（保障内容）主契約特条削減保険年度終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns2(), BizCurrency.valueOf(20000), "（保障内容）主契約特条削減保険金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd3(), BizDate.valueOf(20160103), "（保障内容）主契約特条削減保険年度開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd3(), BizDate.valueOf(20161203), "（保障内容）主契約特条削減保険年度終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns3(), BizCurrency.valueOf(30000), "（保障内容）主契約特条削減保険金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd4(), BizDate.valueOf(20160104), "（保障内容）主契約特条削減保険年度開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd4(), BizDate.valueOf(20161204), "（保障内容）主契約特条削減保険年度終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns4(), BizCurrency.valueOf(40000), "（保障内容）主契約特条削減保険金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndsymd5(), BizDate.valueOf(20160105), "（保障内容）主契約特条削減保険年度開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgnhkndeymd5(), BizDate.valueOf(20161205), "（保障内容）主契約特条削減保険年度終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyskgns5(), BizCurrency.valueOf(50000), "（保障内容）主契約特条削減保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）主契約特条標点");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutkjyp(), BizCurrency.valueOf(30000), "（保障内容）主契約特条保険料");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd1(), "701", "（保障内容）主契約不担保部位コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm1(), "不担保部位名７０１", "（保障内容）主契約不担保部位名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn1(), C_Htnpkkn.BLNK, "（保障内容）主契約不担保期間１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd2(), "702", "（保障内容）主契約不担保部位コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm2(), "不担保部位名７０２", "（保障内容）主契約不担保部位名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn2(), C_Htnpkkn.ONE, "（保障内容）主契約不担保期間２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd3(), "703", "（保障内容）主契約不担保部位コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm3(), "不担保部位名７０３", "（保障内容）主契約不担保部位名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn3(), C_Htnpkkn.TOW, "（保障内容）主契約不担保期間３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuicd4(), "704", "（保障内容）主契約不担保部位コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpbuinm4(), "不担保部位名７０４", "（保障内容）主契約不担保部位名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhtnpkkn4(), C_Htnpkkn.THREE, "（保障内容）主契約不担保期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutokkdsghtnpkbn(), C_TokkoudosghtnpKbn.ARI, "（保障内容）主契約特定高度障害不担保区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyututakngk(), null, "（保障内容）主契約積立金額");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukouryokuhasseiymd(), BizDate.valueOf(20150102), "（保障内容）主契約効力発生日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudai1hknkknsbsyokuseiumu(), C_UmuKbn.ARI, "（保障内容）主契約第１保険期間中死亡保険金額抑制有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusgsbhsyumu(), C_UmuKbn.ARI, "（保障内容）主契約災害死亡保障有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuhknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "（保障内容）主契約保険期間区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyutsnshrgndhjumu(), C_UmuKbn.ARI, "（保障内容）主契約通算支払限度表示有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunkhknumu(), C_UmuKbn.NONE, "（保障内容）主契約年金保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyugannyukyhumu(), C_UmuKbn.NONE, "（保障内容）主契約がん入院給付有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）主契約基本給付金額倍率区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyusndkyhkinshrskgnumu(), C_UmuKbn.ARI, "（保障内容）主契約初年度給付金支払削減有無");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudispsyutsnshrgndgk(), BizCurrency.valueOf(3000), "（保障内容）（表示用）主契約通算支払限度額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyuhghkumu(), C_UmuKbn.NONE, "（保障内容）主契約変額保険有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyunextkosumu(), C_UmuKbn.ARI, "（保障内容）主契約次回更新有無");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), null, "（保障内容）積立金移転日");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.valueOf(60).toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(40).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "", "（保障内容）指数名");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanCVMockForHozen.SYORIPTN = KeisanCVMockForHozen.TESTPATTERN3;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().size(), 0, "件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanCVMockForHozen.SYORIPTN = KeisanCVMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono3);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        KeisanCVMockForHozen.SYORIPTN = KeisanCVMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono4);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().size(), 1, "件数");
        exStringEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundunitkbnval(), "米ドルファンド", "（保障内容）（表示用）ユニットファンド区分値");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundunitkbn(), C_UnitFundKbn.USDFUND, "（保障内容）（表示用）ユニットファンド区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispunitsuu(), BizNumber.valueOf(1000), "（保障内容）（表示用）ユニット数");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundindex(), BizNumber.valueOf(11), "（保障内容）（表示用）ファンドインデックス");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudisptutakngk(), BizCurrency.valueOf(11000), "（保障内容）（表示用）積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispwariai(), BizNumber.valueOf(50), "（保障内容）（表示用）割合");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyouExecUiBeanParamImpl.setSyono(dSyono5);
        KeisanCVMockForHozen.SYORIPTN = KeisanCVMockForHozen.TESTPATTERN2;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().size(), 3, "件数");
        exStringEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundunitkbnval(), "米ドルファンド", "（保障内容）（表示用）ユニットファンド区分値");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundunitkbn(), C_UnitFundKbn.USDFUND, "（保障内容）（表示用）ユニットファンド区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispunitsuu(), BizNumber.valueOf(1000), "（保障内容）（表示用）ユニット数");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispfundindex(), BizNumber.valueOf(11), "（保障内容）（表示用）ファンドインデックス");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudisptutakngk(), BizCurrency.valueOf(11000), "（保障内容）（表示用）積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(0)
            .getVhsyudispwariai(), BizNumber.valueOf(60), "（保障内容）（表示用）割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudispfundunitkbnval(), "ユーロファンド", "（保障内容）（表示用）ユニットファンド区分値");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudispfundunitkbn(), C_UnitFundKbn.EURFUND, "（保障内容）（表示用）ユニットファンド区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudispunitsuu(), BizNumber.valueOf(2000), "（保障内容）（表示用）ユニット数");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudispfundindex(), BizNumber.valueOf(12), "（保障内容）（表示用）ファンドインデックス");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudisptutakngk(), BizCurrency.valueOf(24000), "（保障内容）（表示用）積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(1)
            .getVhsyudispwariai(), BizNumber.valueOf(70), "（保障内容）（表示用）割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudispfundunitkbnval(), "豪ドルファンド", "（保障内容）（表示用）ユニットファンド区分値");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudispfundunitkbn(), C_UnitFundKbn.AUDFUND, "（保障内容）（表示用）ユニットファンド区分");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudispunitsuu(), BizNumber.valueOf(3000), "（保障内容）（表示用）ユニット数");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudispfundindex(), BizNumber.valueOf(13), "（保障内容）（表示用）ファンドインデックス");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudisptutakngk(), BizCurrency.valueOf(39000), "（保障内容）（表示用）積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getTbktInfoDataSourceBeanCommonParamLst().get(2)
            .getVhsyudispwariai(), BizNumber.valueOf(80), "（保障内容）（表示用）割合");
    }

    @Test(expected=EntityNotFoundException.class)
    @TestOrder(120)
    public void testExec_A12() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyouExecUiBeanParamImpl.setSyono(dSyono11);

        String errorMessage = null;
        try {
            boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);
        } catch (EntityNotFoundException ex) {
            errorMessage = ex.getMessage();
            throw ex;
        }
        exStringEquals(errorMessage, "必要なエンティティが見つかれません。", "エラーメッセージ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono3);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm(), null, "（保障内容）（表示用）特約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyunkshrtkyknksyukbn(), null, "（保障内容）年金支払特約年金種類区分");
        assertNull(setHosyouExecUiBeanParamImpl.getVhsyunkshrtkyknksyukkn());
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyunstkhukaumukbn(), C_UmuKbn.NONE, "（保障内容）（表示用）年金支払特約付加有無");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono4);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm(), "年金支払特約", "（保障内容）（表示用）特約商品名");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyunkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（保障内容）年金支払特約年金種類区分");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyunkshrtkyknksyukkn(), 5, "（保障内容）年金支払特約年金期間");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyunstkhukaumukbn(), C_UmuKbn.ARI, "（保障内容）（表示用）年金支払特約付加有無");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono8);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), null, "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), null, "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), null, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), null, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), null, "（保障内容）（表示用）特約給付限度型区分１");
        assertNull(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1());
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), null, "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), null, "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), null, "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), null, "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), null, "（保障内容）（表示用）特約復活がん責任開始日１");
        assertNull(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1());
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), null, "（保障内容）（表示用）特約保険期間歳満期区分１");
        assertNull(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1());
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), null, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), null, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), null, "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), null, "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), null, "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), null, "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), null, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), null, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), null, "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), null, "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), null, "（保障内容）（表示用）特約年金種類区分１");
        assertNull(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1());
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), null, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), null, "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), null, "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), null, "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), null, "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), null, "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), null, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), null, "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), null, "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), null, "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), null, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), null, "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), null, "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), null, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), null, "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), null, "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), null, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), null, "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), null, "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), null, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), null, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), null, "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), null, "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), null, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), null, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), null, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), null, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), null, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), null, "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), null, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), null, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "M110", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "入院保険", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono3);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "Z130", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "商品名Ｚ１３０", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono4);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "Z140", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "商品名Ｚ１４０", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.BLNK, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), null, "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN3;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN4;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono5);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "Z150", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "商品名Ｚ１５０", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.Y1, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "601", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "不担保部位名６０１", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "602", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "不担保部位名６０２", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "603", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "不担保部位名６０３", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "604", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "不担保部位名６０４", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.FOUR, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN4;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN5;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono6);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "Z160", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "商品名Ｚ１６０", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.Y3, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN6;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN6;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono7);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "Z170", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "商品名Ｚ１７０", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(50000), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.Y5, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), BizDate.valueOf(20160104), "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), BizDate.valueOf(20161204), "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), BizDate.valueOf(20160105), "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), BizDate.valueOf(20161205), "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(50000), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "701", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "不担保部位名７０１", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "702", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "不担保部位名７０２", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "703", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "不担保部位名７０３", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "704", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "不担保部位名７０４", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.ARI, "（保障内容）（表示用）特約次回更新有無１");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN3;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN6;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono9);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "M110", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "入院保険", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd2(), "Z130", "（保障内容）（表示用）特約商品コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm2(), "商品名Ｚ１３０", "（保障内容）（表示用）特約商品名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu2(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn2(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn2(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen2(), 52, "（保障内容）（表示用）特約被保険者年齢２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd2(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd2(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd2(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd2(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd2(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn2(), 2, "（保障内容）（表示用）特約保険期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn2(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn2(), 12, "（保障内容）（表示用）特約払込期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn2(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn2(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons2(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp2(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk2(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn2(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn2(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd2(), null, "（保障内容）（表示用）特約支払削減開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd2(), null, "（保障内容）（表示用）特約支払削減終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn2(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn2(), 5, "（保障内容）（表示用）特約年金期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn2(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd12(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd12(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns12(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd22(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd22(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns22(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd32(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd32(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns32(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd42(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd42(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns42(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd52(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd52(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns52(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten2(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd12(), "", "（保障内容）（表示用）特約不担保部位コード１＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm12(), "", "（保障内容）（表示用）特約不担保部位名１＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn12(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd22(), "", "（保障内容）（表示用）特約不担保部位コード２＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm22(), "", "（保障内容）（表示用）特約不担保部位名２＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn22(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd32(), "", "（保障内容）（表示用）特約不担保部位コード３＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm32(), "", "（保障内容）（表示用）特約不担保部位名３＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn32(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd42(), "", "（保障内容）（表示用）特約不担保部位コード４＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm42(), "", "（保障内容）（表示用）特約不担保部位名４＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn42(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn2(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd2(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn2(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk2(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd3(), "Z140", "（保障内容）（表示用）特約商品コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm3(), "商品名Ｚ１４０", "（保障内容）（表示用）特約商品名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu3(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn3(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn3(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen3(), 52, "（保障内容）（表示用）特約被保険者年齢３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd3(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd3(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd3(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd3(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd3(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn3(), 2, "（保障内容）（表示用）特約保険期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn3(), C_HknkknsmnKbn.BLNK, "（保障内容）（表示用）特約保険期間歳満期区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn3(), 12, "（保障内容）（表示用）特約払込期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn3(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn3(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons3(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp3(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk3(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop3(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn3(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn3(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk3(), null, "（保障内容）（表示用）特約がん入院給付日額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd3(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd3(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos3(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn3(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn3(), 5, "（保障内容）（表示用）特約年金期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn3(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd13(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd13(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns13(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd23(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd23(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns23(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd33(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd33(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns33(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd43(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd43(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns43(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd53(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd53(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns53(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten3(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp3(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd13(), "", "（保障内容）（表示用）特約不担保部位コード１＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm13(), "", "（保障内容）（表示用）特約不担保部位名１＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn13(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd23(), "", "（保障内容）（表示用）特約不担保部位コード２＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm23(), "", "（保障内容）（表示用）特約不担保部位名２＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn23(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd33(), "", "（保障内容）（表示用）特約不担保部位コード３＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm33(), "", "（保障内容）（表示用）特約不担保部位名３＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn33(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd43(), "", "（保障内容）（表示用）特約不担保部位コード４＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm43(), "", "（保障内容）（表示用）特約不担保部位名４＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn43(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn3(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk3(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd3(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約がん入院給付有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn3(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk3(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd4(), "Z150", "（保障内容）（表示用）特約商品コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm4(), "商品名Ｚ１５０", "（保障内容）（表示用）特約商品名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu4(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn4(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn4(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen4(), 52, "（保障内容）（表示用）特約被保険者年齢４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd4(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd4(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd4(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd4(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd4(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn4(), 2, "（保障内容）（表示用）特約保険期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn4(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn4(), 12, "（保障内容）（表示用）特約払込期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn4(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn4(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons4(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp4(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk4(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn4(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn4(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd4(), null, "（保障内容）（表示用）特約支払削減開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd4(), null, "（保障内容）（表示用）特約支払削減終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn4(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn4(), 5, "（保障内容）（表示用）特約年金期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn4(), C_Tkjyskgnkkn.Y1, "（保障内容）（表示用）特約特条削減期間４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd14(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd14(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns14(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd24(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd24(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns24(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd34(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd34(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns34(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd44(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd44(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns44(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd54(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd54(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns54(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten4(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp4(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd14(), "601", "（保障内容）（表示用）特約不担保部位コード１＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm14(), "不担保部位名６０１", "（保障内容）（表示用）特約不担保部位名１＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn14(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間１＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd24(), "602", "（保障内容）（表示用）特約不担保部位コード２＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm24(), "不担保部位名６０２", "（保障内容）（表示用）特約不担保部位名２＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn24(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間２＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd34(), "603", "（保障内容）（表示用）特約不担保部位コード３＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm34(), "不担保部位名６０３", "（保障内容）（表示用）特約不担保部位名３＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn34(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間３＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd44(), "604", "（保障内容）（表示用）特約不担保部位コード４＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm44(), "不担保部位名６０４", "（保障内容）（表示用）特約不担保部位名４＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn44(), C_Htnpkkn.FOUR, "（保障内容）（表示用）特約不担保期間４＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn4(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd4(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu4(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn4(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk4(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu4(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd5(), "Z160", "（保障内容）（表示用）特約商品コード５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm5(), "商品名Ｚ１６０", "（保障内容）（表示用）特約商品名５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu5(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn5(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn5(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen5(), 52, "（保障内容）（表示用）特約被保険者年齢５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd5(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd5(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd5(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd5(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd5(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn5(), 2, "（保障内容）（表示用）特約保険期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn5(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn5(), 12, "（保障内容）（表示用）特約払込期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn5(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn5(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons5(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp5(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk5(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn5(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn5(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd5(), null, "（保障内容）（表示用）特約支払削減開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd5(), null, "（保障内容）（表示用）特約支払削減終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn5(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn5(), 5, "（保障内容）（表示用）特約年金期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn5(), C_Tkjyskgnkkn.Y3, "（保障内容）（表示用）特約特条削減期間５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd15(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd15(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns15(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd25(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd25(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns25(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd35(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd35(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns35(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd45(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd45(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns45(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd55(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd55(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns55(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten5(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp5(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd15(), "", "（保障内容）（表示用）特約不担保部位コード１＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm15(), "", "（保障内容）（表示用）特約不担保部位名１＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn15(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd25(), "", "（保障内容）（表示用）特約不担保部位コード２＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm25(), "", "（保障内容）（表示用）特約不担保部位名２＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn25(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd35(), "", "（保障内容）（表示用）特約不担保部位コード３＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm35(), "", "（保障内容）（表示用）特約不担保部位名３＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn35(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd45(), "", "（保障内容）（表示用）特約不担保部位コード４＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm45(), "", "（保障内容）（表示用）特約不担保部位名４＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn45(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn5(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd5(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu5(), C_UmuKbn.ARI, "（保障内容）（表示用）特約年金保険有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn5(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk5(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd6(), "Z170", "（保障内容）（表示用）特約商品コード６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm6(), "商品名Ｚ１７０", "（保障内容）（表示用）特約商品名６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu6(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn6(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn6(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen6(), 52, "（保障内容）（表示用）特約被保険者年齢６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd6(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd6(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd6(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd6(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd6(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn6(), 2, "（保障内容）（表示用）特約保険期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn6(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn6(), 12, "（保障内容）（表示用）特約払込期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn6(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn6(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons6(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp6(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk6(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn6(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn6(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd6(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd6(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos6(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn6(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn6(), 5, "（保障内容）（表示用）特約年金期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn6(), C_Tkjyskgnkkn.Y5, "（保障内容）（表示用）特約特条削減期間６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd16(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd16(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns16(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd26(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd26(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns26(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd36(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd36(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns36(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd46(), BizDate.valueOf(20160104), "（保障内容）（表示用）特約特条削減保険年度開始日４＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd46(), BizDate.valueOf(20161204), "（保障内容）（表示用）特約特条削減保険年度終了日４＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns46(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約特条削減保険金額４＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd56(), BizDate.valueOf(20160105), "（保障内容）（表示用）特約特条削減保険年度開始日５＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd56(), BizDate.valueOf(20161205), "（保障内容）（表示用）特約特条削減保険年度終了日５＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns56(), BizCurrency.valueOf(50000), "（保障内容）（表示用）特約特条削減保険金額５＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten6(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp6(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd16(), "701", "（保障内容）（表示用）特約不担保部位コード１＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm16(), "不担保部位名７０１", "（保障内容）（表示用）特約不担保部位名１＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn16(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd26(), "702", "（保障内容）（表示用）特約不担保部位コード２＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm26(), "不担保部位名７０２", "（保障内容）（表示用）特約不担保部位名２＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn26(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd36(), "703", "（保障内容）（表示用）特約不担保部位コード３＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm36(), "不担保部位名７０３", "（保障内容）（表示用）特約不担保部位名３＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn36(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd46(), "704", "（保障内容）（表示用）特約不担保部位コード４＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm46(), "不担保部位名７０４", "（保障内容）（表示用）特約不担保部位名４＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn46(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn6(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd6(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu6(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn6(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu6(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk6(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd7(), "Z180", "（保障内容）（表示用）特約商品コード７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm7(), "商品名Ｚ１８０", "（保障内容）（表示用）特約商品名７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu7(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn7(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn7(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen7(), 52, "（保障内容）（表示用）特約被保険者年齢７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd7(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd7(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd7(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd7(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd7(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn7(), 2, "（保障内容）（表示用）特約保険期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn7(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）（表示用）特約保険期間歳満期区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn7(), 12, "（保障内容）（表示用）特約払込期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn7(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn7(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons7(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp7(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk7(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn7(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn7(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd7(), null, "（保障内容）（表示用）特約支払削減開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd7(), null, "（保障内容）（表示用）特約支払削減終了日７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn7(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn7(), 5, "（保障内容）（表示用）特約年金期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn7(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd17(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd17(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns17(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd27(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd27(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns27(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd37(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd37(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns37(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd47(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd47(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns47(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd57(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd57(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns57(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten7(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd17(), "", "（保障内容）（表示用）特約不担保部位コード１＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm17(), "", "（保障内容）（表示用）特約不担保部位名１＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn17(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd27(), "", "（保障内容）（表示用）特約不担保部位コード２＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm27(), "", "（保障内容）（表示用）特約不担保部位名２＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn27(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd37(), "", "（保障内容）（表示用）特約不担保部位コード３＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm37(), "", "（保障内容）（表示用）特約不担保部位名３＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn37(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd47(), "", "（保障内容）（表示用）特約不担保部位コード４＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm47(), "", "（保障内容）（表示用）特約不担保部位名４＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn47(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn7(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd7(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn7(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk7(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd8(), "Z190", "（保障内容）（表示用）特約商品コード８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm8(), "商品名Ｚ１９０", "（保障内容）（表示用）特約商品名８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu8(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn8(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn8(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen8(), 52, "（保障内容）（表示用）特約被保険者年齢８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd8(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd8(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd8(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd8(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd8(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn8(), 2, "（保障内容）（表示用）特約保険期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn8(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn8(), 12, "（保障内容）（表示用）特約払込期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn8(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn8(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons8(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp8(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk8(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn8(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn8(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd8(), null, "（保障内容）（表示用）特約支払削減開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd8(), null, "（保障内容）（表示用）特約支払削減終了日８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn8(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn8(), 5, "（保障内容）（表示用）特約年金期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn8(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd18(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd18(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns18(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd28(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd28(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns28(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd38(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd38(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns38(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd48(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd48(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns48(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd58(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd58(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns58(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten8(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd18(), "", "（保障内容）（表示用）特約不担保部位コード１＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm18(), "", "（保障内容）（表示用）特約不担保部位名１＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn18(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd28(), "", "（保障内容）（表示用）特約不担保部位コード２＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm28(), "", "（保障内容）（表示用）特約不担保部位名２＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn28(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd38(), "", "（保障内容）（表示用）特約不担保部位コード３＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm38(), "", "（保障内容）（表示用）特約不担保部位名３＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn38(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd48(), "", "（保障内容）（表示用）特約不担保部位コード４＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm48(), "", "（保障内容）（表示用）特約不担保部位名４＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn48(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn8(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd8(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn8(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk8(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd9(), "Z200", "（保障内容）（表示用）特約商品コード９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm9(), "商品名Ｚ２００", "（保障内容）（表示用）特約商品名９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu9(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn9(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn9(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen9(), 52, "（保障内容）（表示用）特約被保険者年齢９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd9(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd9(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd9(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd9(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd9(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn9(), 2, "（保障内容）（表示用）特約保険期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn9(), C_HknkknsmnKbn.BLNK, "（保障内容）（表示用）特約保険期間歳満期区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn9(), 12, "（保障内容）（表示用）特約払込期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn9(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn9(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons9(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp9(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk9(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop9(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn9(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn9(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk9(), null, "（保障内容）（表示用）特約がん入院給付日額９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd9(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd9(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos9(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn9(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn9(), 5, "（保障内容）（表示用）特約年金期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn9(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd19(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd19(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns19(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd29(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd29(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns29(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd39(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd39(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns39(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd49(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd49(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns49(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd59(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd59(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns59(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten9(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp9(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd19(), "", "（保障内容）（表示用）特約不担保部位コード１＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm19(), "", "（保障内容）（表示用）特約不担保部位名１＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn19(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd29(), "", "（保障内容）（表示用）特約不担保部位コード２＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm29(), "", "（保障内容）（表示用）特約不担保部位名２＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn29(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd39(), "", "（保障内容）（表示用）特約不担保部位コード３＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm39(), "", "（保障内容）（表示用）特約不担保部位名３＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn39(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd49(), "", "（保障内容）（表示用）特約不担保部位コード４＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm49(), "", "（保障内容）（表示用）特約不担保部位名４＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn49(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn9(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk9(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd9(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約がん入院給付有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn9(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk9(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd10(), "Z210", "（保障内容）（表示用）特約商品コード１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm10(), "商品名Ｚ２１０", "（保障内容）（表示用）特約商品名１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu10(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn10(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn10(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen10(), 52, "（保障内容）（表示用）特約被保険者年齢１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd10(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd10(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd10(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd10(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd10(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn10(), 2, "（保障内容）（表示用）特約保険期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn10(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn10(), 12, "（保障内容）（表示用）特約払込期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn10(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn10(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons10(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp10(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk10(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn10(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn10(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd10(), null, "（保障内容）（表示用）特約支払削減開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd10(), null, "（保障内容）（表示用）特約支払削減終了日１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn10(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn10(), 5, "（保障内容）（表示用）特約年金期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn10(), C_Tkjyskgnkkn.Y1, "（保障内容）（表示用）特約特条削減期間１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd110(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd110(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns110(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd210(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd210(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns210(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd310(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd310(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns310(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd410(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd410(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns410(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd510(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd510(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns510(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten10(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp10(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd110(), "601", "（保障内容）（表示用）特約不担保部位コード１＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm110(), "不担保部位名６０１", "（保障内容）（表示用）特約不担保部位名１＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn110(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間１＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd210(), "602", "（保障内容）（表示用）特約不担保部位コード２＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm210(), "不担保部位名６０２", "（保障内容）（表示用）特約不担保部位名２＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn210(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間２＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd310(), "603", "（保障内容）（表示用）特約不担保部位コード３＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm310(), "不担保部位名６０３", "（保障内容）（表示用）特約不担保部位名３＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn310(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間３＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd410(), "604", "（保障内容）（表示用）特約不担保部位コード４＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm410(), "不担保部位名６０４", "（保障内容）（表示用）特約不担保部位名４＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn410(), C_Htnpkkn.FOUR, "（保障内容）（表示用）特約不担保期間４＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn10(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd10(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn10(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk10(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu10(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１０");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN3;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN6;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono10);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd1(), "M110", "（保障内容）（表示用）特約商品コード１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm1(), "入院保険", "（保障内容）（表示用）特約商品名１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu1(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn1(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn1(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen1(), 52, "（保障内容）（表示用）特約被保険者年齢１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd1(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd1(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd1(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd1(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd1(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn1(), 2, "（保障内容）（表示用）特約保険期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn1(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn1(), 12, "（保障内容）（表示用）特約払込期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn1(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn1(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons1(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp1(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk1(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn1(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn1(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd1(), null, "（保障内容）（表示用）特約支払削減開始日１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd1(), null, "（保障内容）（表示用）特約支払削減終了日１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn1(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn1(), 5, "（保障内容）（表示用）特約年金期間１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn1(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd11(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd11(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns11(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd21(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd21(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns21(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd31(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd31(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns31(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd41(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd41(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns41(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd51(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd51(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns51(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten1(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd11(), "", "（保障内容）（表示用）特約不担保部位コード１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm11(), "", "（保障内容）（表示用）特約不担保部位名１＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn11(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd21(), "", "（保障内容）（表示用）特約不担保部位コード２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm21(), "", "（保障内容）（表示用）特約不担保部位名２＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn21(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd31(), "", "（保障内容）（表示用）特約不担保部位コード３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm31(), "", "（保障内容）（表示用）特約不担保部位名３＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn31(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd41(), "", "（保障内容）（表示用）特約不担保部位コード４＿１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm41(), "", "（保障内容）（表示用）特約不担保部位名４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn41(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn1(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk1(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd1(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn1(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk1(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無１");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu1(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd2(), "Z130", "（保障内容）（表示用）特約商品コード２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm2(), "商品名Ｚ１３０", "（保障内容）（表示用）特約商品名２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu2(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn2(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn2(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen2(), 52, "（保障内容）（表示用）特約被保険者年齢２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd2(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd2(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd2(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd2(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd2(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn2(), 2, "（保障内容）（表示用）特約保険期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn2(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn2(), 12, "（保障内容）（表示用）特約払込期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn2(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn2(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons2(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp2(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk2(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn2(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn2(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd2(), null, "（保障内容）（表示用）特約支払削減開始日２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd2(), null, "（保障内容）（表示用）特約支払削減終了日２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn2(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分２");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn2(), 5, "（保障内容）（表示用）特約年金期間２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn2(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd12(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd12(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns12(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd22(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd22(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns22(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd32(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd32(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns32(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd42(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd42(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns42(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd52(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd52(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns52(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten2(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd12(), "", "（保障内容）（表示用）特約不担保部位コード１＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm12(), "", "（保障内容）（表示用）特約不担保部位名１＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn12(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd22(), "", "（保障内容）（表示用）特約不担保部位コード２＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm22(), "", "（保障内容）（表示用）特約不担保部位名２＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn22(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd32(), "", "（保障内容）（表示用）特約不担保部位コード３＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm32(), "", "（保障内容）（表示用）特約不担保部位名３＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn32(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd42(), "", "（保障内容）（表示用）特約不担保部位コード４＿２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm42(), "", "（保障内容）（表示用）特約不担保部位名４＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn42(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn2(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk2(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額２");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd2(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn2(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無２");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk2(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無２");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu2(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無２");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd3(), "Z140", "（保障内容）（表示用）特約商品コード３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm3(), "商品名Ｚ１４０", "（保障内容）（表示用）特約商品名３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu3(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn3(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn3(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen3(), 52, "（保障内容）（表示用）特約被保険者年齢３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd3(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd3(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd3(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd3(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd3(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn3(), 2, "（保障内容）（表示用）特約保険期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn3(), C_HknkknsmnKbn.BLNK, "（保障内容）（表示用）特約保険期間歳満期区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn3(), 12, "（保障内容）（表示用）特約払込期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn3(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn3(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons3(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp3(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk3(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop3(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn3(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn3(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk3(), null, "（保障内容）（表示用）特約がん入院給付日額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd3(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd3(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos3(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn3(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分３");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn3(), 5, "（保障内容）（表示用）特約年金期間３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn3(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd13(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd13(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns13(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd23(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd23(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns23(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd33(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd33(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns33(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd43(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd43(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns43(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd53(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd53(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns53(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten3(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp3(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd13(), "", "（保障内容）（表示用）特約不担保部位コード１＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm13(), "", "（保障内容）（表示用）特約不担保部位名１＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn13(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd23(), "", "（保障内容）（表示用）特約不担保部位コード２＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm23(), "", "（保障内容）（表示用）特約不担保部位名２＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn23(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd33(), "", "（保障内容）（表示用）特約不担保部位コード３＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm33(), "", "（保障内容）（表示用）特約不担保部位名３＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn33(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd43(), "", "（保障内容）（表示用）特約不担保部位コード４＿３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm43(), "", "（保障内容）（表示用）特約不担保部位名４＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn43(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn3(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk3(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額３");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd3(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約がん入院給付有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn3(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無３");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk3(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu3(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無３");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu3(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無３");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd4(), "Z150", "（保障内容）（表示用）特約商品コード４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm4(), "商品名Ｚ１５０", "（保障内容）（表示用）特約商品名４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu4(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn4(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn4(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen4(), 52, "（保障内容）（表示用）特約被保険者年齢４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd4(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd4(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd4(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd4(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd4(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn4(), 2, "（保障内容）（表示用）特約保険期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn4(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn4(), 12, "（保障内容）（表示用）特約払込期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn4(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn4(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons4(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp4(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk4(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn4(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn4(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd4(), null, "（保障内容）（表示用）特約支払削減開始日４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd4(), null, "（保障内容）（表示用）特約支払削減終了日４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn4(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分４");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn4(), 5, "（保障内容）（表示用）特約年金期間４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn4(), C_Tkjyskgnkkn.Y1, "（保障内容）（表示用）特約特条削減期間４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd14(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd14(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns14(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd24(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd24(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns24(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd34(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd34(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns34(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd44(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd44(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns44(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd54(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd54(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns54(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten4(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp4(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd14(), "601", "（保障内容）（表示用）特約不担保部位コード１＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm14(), "不担保部位名６０１", "（保障内容）（表示用）特約不担保部位名１＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn14(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間１＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd24(), "602", "（保障内容）（表示用）特約不担保部位コード２＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm24(), "不担保部位名６０２", "（保障内容）（表示用）特約不担保部位名２＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn24(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間２＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd34(), "603", "（保障内容）（表示用）特約不担保部位コード３＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm34(), "不担保部位名６０３", "（保障内容）（表示用）特約不担保部位名３＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn34(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間３＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd44(), "604", "（保障内容）（表示用）特約不担保部位コード４＿４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm44(), "不担保部位名６０４", "（保障内容）（表示用）特約不担保部位名４＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn44(), C_Htnpkkn.FOUR, "（保障内容）（表示用）特約不担保期間４＿４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn4(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk4(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額４");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd4(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu4(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn4(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無４");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk4(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu4(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無４");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu4(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無４");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd5(), "Z160", "（保障内容）（表示用）特約商品コード５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm5(), "商品名Ｚ１６０", "（保障内容）（表示用）特約商品名５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu5(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn5(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn5(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen5(), 52, "（保障内容）（表示用）特約被保険者年齢５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd5(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd5(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd5(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd5(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd5(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn5(), 2, "（保障内容）（表示用）特約保険期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn5(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn5(), 12, "（保障内容）（表示用）特約払込期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn5(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn5(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons5(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp5(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk5(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn5(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn5(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd5(), null, "（保障内容）（表示用）特約支払削減開始日５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd5(), null, "（保障内容）（表示用）特約支払削減終了日５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn5(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分５");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn5(), 5, "（保障内容）（表示用）特約年金期間５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn5(), C_Tkjyskgnkkn.Y3, "（保障内容）（表示用）特約特条削減期間５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd15(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd15(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns15(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd25(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd25(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns25(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd35(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd35(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns35(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd45(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd45(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns45(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd55(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd55(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns55(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten5(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp5(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd15(), "", "（保障内容）（表示用）特約不担保部位コード１＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm15(), "", "（保障内容）（表示用）特約不担保部位名１＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn15(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd25(), "", "（保障内容）（表示用）特約不担保部位コード２＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm25(), "", "（保障内容）（表示用）特約不担保部位名２＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn25(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd35(), "", "（保障内容）（表示用）特約不担保部位コード３＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm35(), "", "（保障内容）（表示用）特約不担保部位名３＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn35(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd45(), "", "（保障内容）（表示用）特約不担保部位コード４＿５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm45(), "", "（保障内容）（表示用）特約不担保部位名４＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn45(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn5(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk5(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額５");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd5(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu5(), C_UmuKbn.ARI, "（保障内容）（表示用）特約年金保険有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn5(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無５");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk5(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無５");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu5(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無５");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd6(), "Z170", "（保障内容）（表示用）特約商品コード６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm6(), "商品名Ｚ１７０", "（保障内容）（表示用）特約商品名６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu6(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn6(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn6(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen6(), 52, "（保障内容）（表示用）特約被保険者年齢６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd6(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd6(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd6(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd6(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd6(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn6(), 2, "（保障内容）（表示用）特約保険期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn6(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn6(), 12, "（保障内容）（表示用）特約払込期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn6(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn6(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons6(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp6(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk6(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn6(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn6(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd6(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd6(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos6(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn6(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分６");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn6(), 5, "（保障内容）（表示用）特約年金期間６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn6(), C_Tkjyskgnkkn.Y5, "（保障内容）（表示用）特約特条削減期間６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd16(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd16(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns16(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd26(), BizDate.valueOf(20160102), "（保障内容）（表示用）特約特条削減保険年度開始日２＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd26(), BizDate.valueOf(20161202), "（保障内容）（表示用）特約特条削減保険年度終了日２＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns26(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約特条削減保険金額２＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd36(), BizDate.valueOf(20160103), "（保障内容）（表示用）特約特条削減保険年度開始日３＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd36(), BizDate.valueOf(20161203), "（保障内容）（表示用）特約特条削減保険年度終了日３＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns36(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条削減保険金額３＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd46(), BizDate.valueOf(20160104), "（保障内容）（表示用）特約特条削減保険年度開始日４＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd46(), BizDate.valueOf(20161204), "（保障内容）（表示用）特約特条削減保険年度終了日４＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns46(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約特条削減保険金額４＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd56(), BizDate.valueOf(20160105), "（保障内容）（表示用）特約特条削減保険年度開始日５＿６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd56(), BizDate.valueOf(20161205), "（保障内容）（表示用）特約特条削減保険年度終了日５＿６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns56(), BizCurrency.valueOf(50000), "（保障内容）（表示用）特約特条削減保険金額５＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten6(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp6(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd16(), "701", "（保障内容）（表示用）特約不担保部位コード１＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm16(), "不担保部位名７０１", "（保障内容）（表示用）特約不担保部位名１＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn16(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd26(), "702", "（保障内容）（表示用）特約不担保部位コード２＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm26(), "不担保部位名７０２", "（保障内容）（表示用）特約不担保部位名２＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn26(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd36(), "703", "（保障内容）（表示用）特約不担保部位コード３＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm36(), "不担保部位名７０３", "（保障内容）（表示用）特約不担保部位名３＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn36(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd46(), "704", "（保障内容）（表示用）特約不担保部位コード４＿６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm46(), "不担保部位名７０４", "（保障内容）（表示用）特約不担保部位名４＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn46(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn6(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk6(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額６");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd6(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu6(), C_UmuKbn.ARI, "（保障内容）（表示用）特約通算支払限度表示有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn6(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu6(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無６");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk6(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無６");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu6(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無６");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd7(), "Z180", "（保障内容）（表示用）特約商品コード７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm7(), "商品名Ｚ１８０", "（保障内容）（表示用）特約商品名７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu7(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn7(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn7(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen7(), 52, "（保障内容）（表示用）特約被保険者年齢７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd7(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd7(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd7(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd7(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd7(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn7(), 2, "（保障内容）（表示用）特約保険期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn7(), C_HknkknsmnKbn.SAIMANKI, "（保障内容）（表示用）特約保険期間歳満期区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn7(), 12, "（保障内容）（表示用）特約払込期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn7(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn7(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons7(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp7(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk7(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn7(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn7(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd7(), null, "（保障内容）（表示用）特約支払削減開始日７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd7(), null, "（保障内容）（表示用）特約支払削減終了日７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn7(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分７");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn7(), 5, "（保障内容）（表示用）特約年金期間７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn7(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd17(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd17(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns17(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd27(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd27(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns27(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd37(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd37(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns37(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd47(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd47(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns47(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd57(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd57(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns57(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten7(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd17(), "", "（保障内容）（表示用）特約不担保部位コード１＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm17(), "", "（保障内容）（表示用）特約不担保部位名１＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn17(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd27(), "", "（保障内容）（表示用）特約不担保部位コード２＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm27(), "", "（保障内容）（表示用）特約不担保部位名２＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn27(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd37(), "", "（保障内容）（表示用）特約不担保部位コード３＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm37(), "", "（保障内容）（表示用）特約不担保部位名３＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn37(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd47(), "", "（保障内容）（表示用）特約不担保部位コード４＿７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm47(), "", "（保障内容）（表示用）特約不担保部位名４＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn47(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn7(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk7(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額７");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd7(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn7(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無７");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk7(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無７");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu7(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無７");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd8(), "Z190", "（保障内容）（表示用）特約商品コード８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm8(), "商品名Ｚ１９０", "（保障内容）（表示用）特約商品名８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu8(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn8(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn8(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen8(), 52, "（保障内容）（表示用）特約被保険者年齢８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd8(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd8(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd8(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd8(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd8(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn8(), 2, "（保障内容）（表示用）特約保険期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn8(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn8(), 12, "（保障内容）（表示用）特約払込期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn8(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn8(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons8(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp8(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk8(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn8(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn8(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd8(), null, "（保障内容）（表示用）特約支払削減開始日８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd8(), null, "（保障内容）（表示用）特約支払削減終了日８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn8(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分８");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn8(), 5, "（保障内容）（表示用）特約年金期間８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn8(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd18(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd18(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns18(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd28(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd28(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns28(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd38(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd38(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns38(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd48(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd48(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns48(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd58(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd58(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns58(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten8(), C_Tkjyhyouten.BLNK, "（保障内容）（表示用）特約特条標点８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条保険料８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd18(), "", "（保障内容）（表示用）特約不担保部位コード１＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm18(), "", "（保障内容）（表示用）特約不担保部位名１＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn18(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd28(), "", "（保障内容）（表示用）特約不担保部位コード２＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm28(), "", "（保障内容）（表示用）特約不担保部位名２＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn28(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間２＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd38(), "", "（保障内容）（表示用）特約不担保部位コード３＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm38(), "", "（保障内容）（表示用）特約不担保部位名３＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn38(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間３＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd48(), "", "（保障内容）（表示用）特約不担保部位コード４＿８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm48(), "", "（保障内容）（表示用）特約不担保部位名４＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn48(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間４＿８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn8(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk8(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額８");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd8(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn8(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無８");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk8(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約変額保険有無８");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu8(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無８");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd9(), "Z200", "（保障内容）（表示用）特約商品コード９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm9(), "商品名Ｚ２００", "（保障内容）（表示用）特約商品名９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu9(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn9(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn9(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen9(), 52, "（保障内容）（表示用）特約被保険者年齢９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd9(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd9(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd9(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd9(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd9(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn9(), 2, "（保障内容）（表示用）特約保険期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn9(), C_HknkknsmnKbn.BLNK, "（保障内容）（表示用）特約保険期間歳満期区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn9(), 12, "（保障内容）（表示用）特約払込期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn9(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn9(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons9(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp9(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk9(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop9(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn9(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn9(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk9(), null, "（保障内容）（表示用）特約がん入院給付日額９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd9(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約支払削減開始日９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd9(), BizDate.valueOf(20160201), "（保障内容）（表示用）特約支払削減終了日９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos9(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約支払削減後保険金額９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn9(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分９");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn9(), 5, "（保障内容）（表示用）特約年金期間９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn9(), C_Tkjyskgnkkn.BLNK, "（保障内容）（表示用）特約特条削減期間９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd19(), null, "（保障内容）（表示用）特約特条削減保険年度開始日１＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd19(), null, "（保障内容）（表示用）特約特条削減保険年度終了日１＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns19(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額１＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd29(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd29(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns29(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd39(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd39(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns39(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd49(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd49(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns49(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd59(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd59(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns59(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten9(), C_Tkjyhyouten.HYOUTEN100, "（保障内容）（表示用）特約特条標点９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp9(), BizCurrency.valueOf(30000), "（保障内容）（表示用）特約特条保険料９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd19(), "", "（保障内容）（表示用）特約不担保部位コード１＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm19(), "", "（保障内容）（表示用）特約不担保部位名１＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn19(), C_Htnpkkn.BLNK, "（保障内容）（表示用）特約不担保期間１＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd29(), "", "（保障内容）（表示用）特約不担保部位コード２＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm29(), "", "（保障内容）（表示用）特約不担保部位名２＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn29(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間２＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd39(), "", "（保障内容）（表示用）特約不担保部位コード３＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm39(), "", "（保障内容）（表示用）特約不担保部位名３＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn39(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間３＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd49(), "", "（保障内容）（表示用）特約不担保部位コード４＿９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm49(), "", "（保障内容）（表示用）特約不担保部位名４＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn49(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間４＿９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn9(), C_TokkoudosghtnpKbn.ARI, "（保障内容）（表示用）特約特定高度障害不担保区分９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk9(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額９");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd9(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約がん入院給付有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn9(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約初年度給付金支払削減有無９");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk9(), BizCurrency.valueOf(1000), "（保障内容）（表示用）特約通算支払限度額９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu9(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無９");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu9(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無９");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhncd10(), "Z210", "（保障内容）（表示用）特約商品コード１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksyouhnnm10(), "商品名Ｚ２１０", "（保障内容）（表示用）特約商品名１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkktuukasyu10(), C_Tuukasyu.JPY, "（保障内容）（表示用）特約契約通貨１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptokyakukatakbn10(), C_KataKbn.HONNIN, "（保障内容）（表示用）特約型区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkyhgdkatakbn10(), C_KyhgndkataKbn.TYPE180, "（保障内容）（表示用）特約給付限度型区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhhknnen10(), 52, "（保障内容）（表示用）特約被保険者年齢１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkykymd10(), BizDate.valueOf(20150202), "（保障内容）（表示用）特約契約日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksknnkaisiymd10(), BizDate.valueOf(20150302), "（保障内容）（表示用）特約責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgaskkaisiymd10(), BizDate.valueOf(20150602), "（保障内容）（表示用）特約がん責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkskkaisiymd10(), BizDate.valueOf(20150702), "（保障内容）（表示用）特約復活責任開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhkgskksiymd10(), BizDate.valueOf(20150802), "（保障内容）（表示用）特約復活がん責任開始日１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkkn10(), 2, "（保障内容）（表示用）特約保険期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhknkknsmnkbn10(), C_HknkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約保険期間歳満期区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkkn10(), 12, "（保障内容）（表示用）特約払込期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhrkkknsmnkbn10(), C_HrkkknsmnKbn.NENMANKI, "（保障内容）（表示用）特約払込期間歳満期区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihsyuruikbn10(), C_KihonssyuruiKbn.NICHIGAKU, "（保障内容）（表示用）特約基本Ｓ種類区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihons10(), BizCurrency.valueOf(20000), "（保障内容）（表示用）特約基本Ｓ１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkp10(), BizCurrency.valueOf(21000), "（保障内容）（表示用）特約Ｐ１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkihonkyhgk10(), BizCurrency.valueOf(40000), "（保障内容）（表示用）特約基本給付金額１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosgop10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約次回更新後保険料１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksykyhkatakbn10(), C_SyukyhkinkataKbn.SYU2, "（保障内容）（表示用）特約手術給付金型区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptk6daildkbn10(), C_6daiLdKbn.ARI, "（保障内容）（表示用）特約６大生活習慣病追加給付型区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkganyukyhntgk10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約がん入院給付日額１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgstrymd10(), null, "（保障内容）（表示用）特約支払削減開始日１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgnedymd10(), null, "（保障内容）（表示用）特約支払削減終了日１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkshrskgngos10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約支払削減後保険金額１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinsyukbn10(), C_Nenkinsyu.KAKUTEINENKIN, "（保障内容）（表示用）特約年金種類区分１０");
        exNumericEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknenkinkkn10(), 5, "（保障内容）（表示用）特約年金期間１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgnkkn10(), C_Tkjyskgnkkn.Y1, "（保障内容）（表示用）特約特条削減期間１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd110(), BizDate.valueOf(20160101), "（保障内容）（表示用）特約特条削減保険年度開始日１＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd110(), BizDate.valueOf(20161201), "（保障内容）（表示用）特約特条削減保険年度終了日１＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns110(), BizCurrency.valueOf(10000), "（保障内容）（表示用）特約特条削減保険金額１＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd210(), null, "（保障内容）（表示用）特約特条削減保険年度開始日２＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd210(), null, "（保障内容）（表示用）特約特条削減保険年度終了日２＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns210(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額２＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd310(), null, "（保障内容）（表示用）特約特条削減保険年度開始日３＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd310(), null, "（保障内容）（表示用）特約特条削減保険年度終了日３＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns310(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額３＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd410(), null, "（保障内容）（表示用）特約特条削減保険年度開始日４＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd410(), null, "（保障内容）（表示用）特約特条削減保険年度終了日４＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns410(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額４＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdsymd510(), null, "（保障内容）（表示用）特約特条削減保険年度開始日５＿１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjkhkdeymd510(), null, "（保障内容）（表示用）特約特条削減保険年度終了日５＿１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyskgns510(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約特条削減保険金額５＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyhyouten10(), C_Tkjyhyouten.HYOUTEN125, "（保障内容）（表示用）特約特条標点１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkjyp10(), BizCurrency.valueOf(31000), "（保障内容）（表示用）特約特条保険料１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd110(), "601", "（保障内容）（表示用）特約不担保部位コード１＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm110(), "不担保部位名６０１", "（保障内容）（表示用）特約不担保部位名１＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn110(), C_Htnpkkn.ONE, "（保障内容）（表示用）特約不担保期間１＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd210(), "602", "（保障内容）（表示用）特約不担保部位コード２＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm210(), "不担保部位名６０２", "（保障内容）（表示用）特約不担保部位名２＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn210(), C_Htnpkkn.TOW, "（保障内容）（表示用）特約不担保期間２＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd310(), "603", "（保障内容）（表示用）特約不担保部位コード３＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm310(), "不担保部位名６０３", "（保障内容）（表示用）特約不担保部位名３＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn310(), C_Htnpkkn.THREE, "（保障内容）（表示用）特約不担保期間３＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuicd410(), "604", "（保障内容）（表示用）特約不担保部位コード４＿１０");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpbuinm410(), "不担保部位名６０４", "（保障内容）（表示用）特約不担保部位名４＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhtnpkkn410(), C_Htnpkkn.FOUR, "（保障内容）（表示用）特約不担保期間４＿１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktkkdsghtpkbn10(), C_TokkoudosghtnpKbn.BLNK, "（保障内容）（表示用）特約特定高度障害不担保区分１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktutakngk10(), BizCurrency.valueOf(0), "（保障内容）（表示用）特約積立金額１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkrkhasseiymd10(), BizDate.valueOf(20150102), "（保障内容）（表示用）特約効力発生日１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndhjumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約通算支払限度表示有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknkhknumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約年金保険有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkgannyukyhumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約がん入院給付有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkkgbairitukbn10(), C_KhnkyhkgbairituKbn.NIBAI, "（保障内容）（表示用）特約基本給付金額倍率区分１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptksndkyhkinshrskgnumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約初年度給付金支払削減有無１０");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptktsnshrgndgk10(), BizCurrency.valueOf(3000), "（保障内容）（表示用）特約通算支払限度額１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptkhghkumu10(), C_UmuKbn.ARI, "（保障内容）（表示用）特約変額保険有無１０");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyudisptknextkosumu10(), C_UmuKbn.NONE, "（保障内容）（表示用）特約次回更新有無１０");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), null, "（保障内容）積立金移転日");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendourate().toString(), BizNumber.ZERO.toString(), "（保障内容）指数連動部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttrate().toString(), BizNumber.valueOf(100).toString(), "（保障内容）定率積立部分割合");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuunm(), "", "（保障内容）指数名");
    }



    @Test
    @TestOrder(240)
    public void testExec_A24() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono12);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  BizCurrency.optional(), "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), BizCurrency.optional(), "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.optional(), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu().toString(), BizNumber.valueOf(0).toString(), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.BLNK, "（保障内容）円建変更状態区分");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf(20190619), "（保障内容）積立金移転日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.ARI, "（保障内容）現在金額表示不可状態有無");

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "11807111196", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.valueOf(20190508).toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBKYUUHUKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "11807111196", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190510), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190510), "契約日");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono13);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu().toString(), BizNumber.valueOf(0).toString(), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.YENDTHNKZUMI, "（保障内容）円建変更状態区分");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf(20190620), "（保障内容）積立金移転日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "11807111141", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.getSysDate().toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBKYUUHUKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "11807111141", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190509), "契約日");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono14);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  BizCurrency.valueOf(100), "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), BizCurrency.valueOf(100), "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exStringEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu().toString(), BizNumber.valueOf(330).toString(), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.BLNK, "（保障内容）円建変更状態区分");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf(20190621), "（保障内容）積立金移転日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "11807111129", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.getSysDate().toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBKYUUHUKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "11807111129", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190509), "契約日");
    }


    @Test
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono15);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        GetYoteirirituBean getYoteirirituBean = (GetYoteirirituBean)MockObjectManager.getArgument(GetYoteiriritu.class, "exec", 0, 0);
        exStringEquals(getYoteirirituBean.getSyouhncd(), "ﾕﾁ", "商品コード");
        exDateEquals(getYoteirirituBean.getKijyunymd(), BizDate.getSysDate(), "基準日");
        exDateEquals(getYoteirirituBean.getSknnkaisiymd(), BizDate.valueOf("20150302"), "責任開始日");
        exDateEquals(getYoteirirituBean.getKykymd(), BizDate.valueOf(20190508), "契約日");
        exNumericEquals(getYoteirirituBean.getHknkkn(), 2, "保険期間");
        exClassificationEquals(getYoteirirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(getYoteirirituBean.getHhknnen(), 52, "被保険者年齢");
        exStringEquals(getYoteirirituBean.getSitihsyuriritu().toString(), "0", "最低保証利率");


        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu(), BizNumber.valueOf(0), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.BLNK, "（保障内容）円建変更状態区分");
        exDateEquals(setHosyouExecUiBeanParamImpl.getVhsyutmttknitenymd(), BizDate.valueOf(20190622), "（保障内容）積立金移転日");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "11807111233", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.getSysDate().toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBKYUUHUKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "11807111233", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190508), "契約日");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono16);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        GetYoteirirituBean getYoteirirituBean = (GetYoteirirituBean)MockObjectManager.getArgument(GetYoteiriritu.class, "exec", 0, 0);
        exStringEquals(getYoteirirituBean.getSyouhncd(), "ﾕﾁ", "商品コード");
        exDateEquals(getYoteirirituBean.getKijyunymd(), BizDate.getSysDate(), "基準日");
        exDateEquals(getYoteirirituBean.getSknnkaisiymd(), BizDate.valueOf("20150302"), "責任開始日");
        exDateEquals(getYoteirirituBean.getKykymd(), BizDate.valueOf("20190508"), "契約日");
        exNumericEquals(getYoteirirituBean.getHknkkn(), 2, "保険期間");
        exClassificationEquals(getYoteirirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(getYoteirirituBean.getHhknnen(), 52, "被保険者年齢");
        exStringEquals(getYoteirirituBean.getSitihsyuriritu().toString(), "0", "最低保証利率");


        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu(), BizNumber.valueOf(0), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "60806000011", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190508), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190508), "契約日");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono17);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        GetYoteirirituBean getYoteirirituBean = (GetYoteirirituBean)MockObjectManager.getArgument(GetYoteiriritu.class, "exec", 0, 0);
        exStringEquals(getYoteirirituBean.getSyouhncd(), "ﾕﾁ", "商品コード");
        exDateEquals(getYoteirirituBean.getKijyunymd(), BizDate.getSysDate(), "基準日");
        exDateEquals(getYoteirirituBean.getSknnkaisiymd(), BizDate.valueOf("20150302"), "責任開始日");
        exDateEquals(getYoteirirituBean.getKykymd(), BizDate.valueOf("20190508"), "契約日");
        exNumericEquals(getYoteirirituBean.getHknkkn(), 2, "保険期間");
        exClassificationEquals(getYoteirirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(getYoteirirituBean.getHhknnen(), 52, "被保険者年齢");
        exStringEquals(getYoteirirituBean.getSitihsyuriritu().toString(), "0", "最低保証利率");


        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuyoteiriritu(), BizNumber.valueOf(0), "（保障内容）予定利率");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykjisiteituukasyu(), C_Tuukasyu.JPY, "（保障内容）主契約契約時指定通貨種類");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuitijibrumu(), C_UmuKbn.ARI, "一時払有無");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono18);

        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono19);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyukyktumitateriritu(), BizNumber.valueOf(250), "（保障内容）契約時積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyu10nentumitateriritu(), BizNumber.valueOf(270), "（保障内容）１０年経過後積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.optional(), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(),null, "（保障内容）主契約基準金額");

        HanteiHokenKikanBean hanteiHokenKikanBean =
            (HanteiHokenKikanBean) MockObjectManager.getArgument(HanteiHokenKikan.class, "exec", 0, 0);
        exDateEquals(hanteiHokenKikanBean.getKykYmd(), BizDate.valueOf(20200808), "契約日");
        exDateEquals(hanteiHokenKikanBean.getCalcKijyunYmd(), BizDate.valueOf(20190808), "計算基準日");
        exStringEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhncd(), "P110", "商品コード");
        exNumericEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhnsdno(), 1, "商品世代番号");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono20);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyukyktumitateriritu(), BizNumber.valueOf(0), "（保障内容）契約時積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyu10nentumitateriritu(), BizNumber.valueOf(0), "（保障内容）１０年経過後積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額 ");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), BizCurrency.valueOf(11000), "（保障内容）主契約基準金額");

        MockObjectManager.assertArgumentPassed(KeisanKijyungkMockForHozen.class, "exec", 0, BizDate.valueOf(20190827));
        MockObjectManager.assertArgumentPassed(KeisanKijyungkMockForHozen.class, "exec", 1, BizCurrency.valueOf(2655971));
        MockObjectManager.assertArgumentPassed(KeisanKijyungkMockForHozen.class, "exec", 2, BizCurrency.valueOf(54321));
        MockObjectManager.assertArgumentPassed(KeisanKijyungkMockForHozen.class, "exec", 3,C_Tuukasyu.USD);
        MockObjectManager.assertArgumentPassed(KeisanKijyungkMockForHozen.class, "exec", 4,C_Tkhukaumu.HUKA);
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono21);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.valueOf(500), "（保障内容）現在積立金額 ");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), BizCurrency.valueOf(11000), "（保障内容）主契約基準金額");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono22);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), BizCurrency.valueOf(234234), "（保障内容）主契約基準金額");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono23);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), null, "（保障内容）主契約基準金額");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190510));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono24);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(),  BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(),  BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.BLNK, "（保障内容）円建変更状態区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.ARI, "（保障内容）現在金額表示不可状態有無");

        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0).toString(), "99806001191", "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の証券番号");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1).toString(), BizDate.valueOf(20190508).toString(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の計算基準日");
        exStringEquals(MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3).toString(), C_HokenkinsyuruiKbn.SBKYUUHUKIN.getValue(), "保険金額計算（解約返戻金計算拡張情報作成）の１次呼出の保険金種類区分");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "99806001191", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190508), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190510), "契約日");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono25);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(),  BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(),  BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  BizCurrency.valueOf(40000), "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), BizCurrency.valueOf(404), "（保障内容）指数連動積立金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.BLNK, "（保障内容）円建変更状態区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "99806001021", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190509), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190509), "契約日");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190509));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        setHosyouExecUiBeanParamImpl.setSyono(dSyono26);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(),  BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(),  BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyuyendthnkjyoutaikbn(), C_YendthnkJyoutaiKbn.YENDTHNKZUMI, "（保障内容）円建変更状態区分");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "99806001249", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190509), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190509), "契約日");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20150202));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        SyouhntaniKousingoPkeisanMockForHozen.SYORIPTN = SyouhntaniKousingoPkeisanMockForHozen.TESTPATTERN3;
        TokujoSSakugenNaiyouKeisanMockForHozen.SYORIPTN = TokujoSSakugenNaiyouKeisanMockForHozen.TESTPATTERN6;

        setHosyouExecUiBeanParamImpl.setSyono(dSyono27);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaisbhknkngaku(),  BizCurrency.valueOf(20001), "（保障内容）現在死亡保険金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(),  BizCurrency.valueOf(500), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyuteiritutmttkngk(),  null, "（保障内容）定率積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusisuurendoutmttkngk(), null, "（保障内容）指数連動積立金額");
        exClassificationEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaikngkhyjfukaumu(), C_UmuKbn.NONE, "（保障内容）現在金額表示不可状態有無");

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean)MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(), "99806001113", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20150201), "判定基準日");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20150202), "契約日");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono28);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyukyktumitateriritu(), BizNumber.valueOf(250), "（保障内容）契約時積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyu10nentumitateriritu(), BizNumber.valueOf(270), "（保障内容）１０年経過後積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.optional(), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), BizCurrency.valueOf(2), "（保障内容）主契約基準金額");

        HanteiHokenKikanBean hanteiHokenKikanBean =
            (HanteiHokenKikanBean) MockObjectManager.getArgument(HanteiHokenKikan.class, "exec", 0, 0);
        exDateEquals(hanteiHokenKikanBean.getKykYmd(), BizDate.valueOf(20200808), "契約日");
        exDateEquals(hanteiHokenKikanBean.getCalcKijyunYmd(), BizDate.valueOf(20190808), "計算基準日");
        exStringEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhncd(), "ﾕﾃ", "商品コード");
        exNumericEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhnsdno(), 1, "商品世代番号");
    }
    @Test
    @TestOrder(410)
    public void testExec_A41() {

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20190808));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setHosyouExecUiBeanParamImpl = new SetHosyouExecUiBeanParamImpl();
        setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyouExecUiBeanParamImpl.setSyono(dSyono29);
        boolean syorikeka = setHosyou.exec(khozenCommonParam, setHosyouExecUiBeanParamImpl);

        exBooleanEquals(syorikeka, true, "処理結果");

        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyukyktumitateriritu(), BizNumber.valueOf(250), "（保障内容）契約時積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyu10nentumitateriritu(), BizNumber.valueOf(270), "（保障内容）１０年経過後積立利率");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyugenzaitmttkngk(), BizCurrency.optional(), "（保障内容）現在積立金額");
        exBizCalcbleEquals(setHosyouExecUiBeanParamImpl.getVhsyusyukykkjnkngk(), BizCurrency.valueOf(360), "（保障内容）主契約基準金額");

        HanteiHokenKikanBean hanteiHokenKikanBean =
            (HanteiHokenKikanBean) MockObjectManager.getArgument(HanteiHokenKikan.class, "exec", 0, 0);
        exDateEquals(hanteiHokenKikanBean.getKykYmd(), BizDate.valueOf(20200808), "契約日");
        exDateEquals(hanteiHokenKikanBean.getCalcKijyunYmd(), BizDate.valueOf(20190808), "計算基準日");
        exStringEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(hanteiHokenKikanBean.getSyouhnZokusei().getSyouhnsdno(), 1, "商品世代番号");
    }

}
