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
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
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
 * 推移表ＴＢＬ編集（年金３）のメソッド {@link EditSuiihyouTblNenkin#editTBL(KhozenCommonParam,
        IT_KykKihon, List<IT_KykSyouhn>, List<IT_KykSyouhn>, IT_HhknSya, BizDate, EditHokenSyoukenParam, C_SinsaihkKbn ,
        BM_SyouhnZokusei, IT_KykSonotaTkyk )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblNenkin3Test_editTBL {

    @Inject
    private EditSuiihyouTblNenkin3 editSuiihyouTblNenkin3;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    KhozenCommonParam pKkanriCommonParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_推移表ＴＢＬ編集（年金３）";
    private final static String sheetName = "テストデータ";

    @Inject
    private static Logger logger;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
            }
        });

        baseUserInfo.getUser().setUserId("User1");
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblNenkin3");
    }

    @BeforeClass
    public static void testInit() {
        KeisanWExtMockForHozen.caller = EditSuiihyouTblNenkin3Test_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSuiihyouTblNenkin3Test_editTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon("20806000019"));
        hozenDomManager.delete(hozenDomManager.getKykKihon("20806000020"));
    }


    @Test (expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditTBL_A1() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20201001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = new EditHokenSyoukenParam();
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei =
            bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        try {
            editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
                pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_B1() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000020");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        BizDate pSyoriYmd = BizDate.valueOf(20201001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SIN;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkKykSyouhn.getKyktuukasyu());

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 5, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 0, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 0, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "02", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000020", "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20201001), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_TSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_Default(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_TKeika0(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_TKeika1(Suiihyou, currencyType);
                    break;
                case 2:
                    checkWSuiihyou_TKeika2(Suiihyou, currencyType);
                    break;
                case 3:
                    checkWSuiihyou_TKeika3(Suiihyou, currencyType);
                    break;
                case 4:
                    checkWSuiihyou_TKeika4(Suiihyou, currencyType);
                    break;
                default:
                    break;
            }
        }
    }

    private void checkWSuiihyou_TKeika0(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20201001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202010), "計算年月");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(50000, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(47388.99, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(49755.62, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(52265.49, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(46138.99, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(48505.62, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(51015.49, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5210000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(5670000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6130000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5470000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(5960000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6440000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5760000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6270000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(6780000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(50000, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou_TKeika1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年月");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(51000, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(48858.05, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(50800.48, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(52840.41, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(47858.05, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(49800.48, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(51840.41, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5400000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(5880000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5620000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6120000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6620000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5850000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6370000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(6890000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(51000, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou_TKeika2(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年月");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(52020, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(50372.65, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(51867.29, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(53421.66, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(49622.65, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(51117.29, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(52671.66, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5600000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6100000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6590000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5770000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6280000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6790000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5940000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7000000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(52020, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou_TKeika3(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 3, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20231001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202310), "計算年月");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(53060.4, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(51934.21, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(52956.51, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(54009.30, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(51434.21, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(52456.51, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(53509.30, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5800000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6320000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6830000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5920000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6440000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6970000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(6040000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6570000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7110000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(53060.40, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou_TKeika4(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 4, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20241001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202410), "計算年月");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(54121.61, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(53544.17, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(54068.60, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(54603.40, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(53294.17, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(53818.60, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(54353.40, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(6010000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6550000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(7080000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(6070000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6610000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(7150000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(6130000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6680000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7220000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(54121.61, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou1_TSjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.03), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.02), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.01), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_B2() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000020");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20201015);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkKykSyouhn.getKyktuukasyu());

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 5, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 0, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 0, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "02", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000020", "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20201015), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_TSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_Default(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_TKeika0(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_TKeika1(Suiihyou, currencyType);
                    break;
                case 2:
                    checkWSuiihyou_TKeika2(Suiihyou, currencyType);
                    break;
                case 3:
                    checkWSuiihyou_TKeika3(Suiihyou, currencyType);
                    break;
                case 4:
                    checkWSuiihyou_TKeika4(Suiihyou, currencyType);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_B3() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000020");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20201015);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 4, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 0, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 0, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "02", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000020", "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20201015), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_TSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_Default(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年月");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年月");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 3, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20231001), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202310), "計算年月");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20241001), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202410), "計算年月");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_C1() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20201001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SIN;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkKykSyouhn.getKyktuukasyu());

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 5, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 3, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 1, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "01", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000019", "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "11", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20201001), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_SSjkkktusirrt(Suiihyou);
            checkWSuiihyou2_SSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_KawaseRate(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_SKeika0(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_SKeika1(Suiihyou, currencyType);
                    break;
                case 2:
                    checkWSuiihyou_SKeika2(Suiihyou, currencyType);
                    break;
                case 3:
                    checkWSuiihyou_SKeika3(Suiihyou, currencyType);
                    break;
                case 4:
                    checkWSuiihyou_SKeika4(Suiihyou, currencyType);
                    break;
                default:
                    break;
            }
        }
    }

    private void checkWSuiihyou_SKeika0(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20201001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202010), "計算年月");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(50000, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(47390.23, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(49755.74, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(52264.35, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(46140.23, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(48505.74, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(51014.35, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5210000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(5670000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6130000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5470000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(5960000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6440000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5760000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6270000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(6780000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(50000, currencyType), "積立金内訳（２）１");

        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(50000, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(47390.23, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(49755.74, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(52264.35, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(46140.23, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(48505.74, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(51014.35, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(5210000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(5670000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(6130000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(5470000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(5960000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(6440000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(5760000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(6270000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(6780000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(50000, currencyType), "積立金内訳（２）２");
    }

    private void checkWSuiihyou_SKeika1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年月");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.041), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(52050, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(49865.00, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(51846.48, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(53927.36, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(48865.00, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(50846.48, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(52927.36, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5510000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6000000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6490000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5740000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6250000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6760000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5970000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6500000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7030000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(52050, currencyType), "積立金内訳（２）１");

        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0.041), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(52050, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(49865.00, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(51846.48, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(53927.36, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(48865.00, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(50846.48, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(52927.36, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(5510000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(6000000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(6490000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(5740000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(6250000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(6760000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(5970000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(6500000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(7030000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(52050, currencyType), "積立金内訳（２）２");
    }

    private void checkWSuiihyou_SKeika2(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年月");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(-0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(52050, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(50402.49, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(51897.28, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(53451.77, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(49652.49, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(51147.28, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(52701.77, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5600000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6100000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6600000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(5770000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6280000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(6800000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(5950000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7000000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(52050, currencyType), "積立金内訳（２）１");

        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(52050, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(50402.49, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(51897.28, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(53451.77, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(49652.49, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(51147.28, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(52701.77, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(5600000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(6100000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(6600000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(5770000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(6280000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(6800000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(5950000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(6470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(7000000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(52050, currencyType), "積立金内訳（２）２");
    }

    private void checkWSuiihyou_SKeika3(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 3, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20231001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202310), "計算年月");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.041), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(54184.05, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(53034.56, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(54078.01, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(55152.56, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(52534.56, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(53578.01, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(54652.56, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5930000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6450000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6980000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(6050000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6580000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(7120000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(6170000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6710000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7260000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(54184.05, currencyType), "積立金内訳（２）１");

        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0.041), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(54184.05, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(53034.56, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(54078.01, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(55152.56, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(52534.56, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(53578.01, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(54652.56, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(5930000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6450000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(6980000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(6050000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6580000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(7120000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(6170000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6710000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7260000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(54184.05, currencyType), "積立金内訳（２）２");
    }

    private void checkWSuiihyou_SKeika4(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 4, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20241001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202410), "計算年月");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410001957), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(56405.61, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(55804.09, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(56350.39, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(56907.48, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(55554.09, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(56100.39, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(56657.48, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(6270000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(6830000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(7380000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(6330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(6890000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(7450000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(6390000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(6960000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(7530000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(56405.61, currencyType), "積立金内訳（２）１");

        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(54184.05, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(53606.22, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(54131.00, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(54666.16, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(53356.22, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(53881.00, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(54416.16, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(6020000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(6560000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(7090000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(6080000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(6620000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(7160000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(6140000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(6690000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(7230000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(54184.05, currencyType), "積立金内訳（２）２");
    }

    private void checkWSuiihyou1_SSjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.0305), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.0205), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.0105), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");
    }

    private void checkWSuiihyou2_SSjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.valueOf(0.0305), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.valueOf(0.0205), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.valueOf(0.0105), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）２");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_C2() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20201015);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkKykSyouhn.getKyktuukasyu());

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 5, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 3, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 1, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "01", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000019", "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "11", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20201015), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_SSjkkktusirrt(Suiihyou);
            checkWSuiihyou2_SSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_KawaseRate(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_SKeika0(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_SKeika1(Suiihyou, currencyType);
                    break;
                case 2:
                    checkWSuiihyou_SKeika2(Suiihyou, currencyType);
                    break;
                case 3:
                    checkWSuiihyou_SKeika3(Suiihyou, currencyType);
                    break;
                case 4:
                    checkWSuiihyou_SKeika4(Suiihyou, currencyType);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_C3() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20211001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 3, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 2, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 1, "指数下落回数１");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "01", "区分キー");
            exStringEquals(Suiihyou.getSyono(), "20806000019", "証券番号");
            exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "12", "推移表種別");
            exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20211001), "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
            checkWSuiihyou1_SSjkkktusirrt(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            checkWSuiihyou2_Default(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 2, "経過年数");
                    exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
                    exDateYMEquals(suiihyouLst.get(0).getCalcym(), BizDateYM.valueOf(202210), "計算年月");
                    exBizCalcbleEquals(suiihyouLst.get(0).getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
                    break;
                case 1:
                    exNumericEquals(suiihyouLst.get(1).getKeikanensuu(), 3, "経過年数");
                    exDateEquals(suiihyouLst.get(1).getCalckijyunymd(), BizDate.valueOf(20231001), "計算基準日");
                    exDateYMEquals(suiihyouLst.get(1).getCalcym(), BizDateYM.valueOf(202310), "計算年月");
                    exBizCalcbleEquals(suiihyouLst.get(1).getSisuuupritu1(), BizNumber.valueOf(-0.05), "指数上昇率１");
                    break;
                case 2:
                    exNumericEquals(suiihyouLst.get(2).getKeikanensuu(), 4, "経過年数");
                    exDateEquals(suiihyouLst.get(2).getCalckijyunymd(), BizDate.valueOf(20241001), "計算基準日");
                    exDateYMEquals(suiihyouLst.get(2).getCalcym(), BizDateYM.valueOf(202410), "計算年月");
                    exBizCalcbleEquals(suiihyouLst.get(2).getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_C4() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20231001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 1, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 0, "指数下落回数１");

        IT_Suiihyou Suiihyou = suiihyouLst.get(0);
        displayContents(Suiihyou);

        exStringEquals(Suiihyou.getKbnkey(), "01", "区分キー");
        exStringEquals(Suiihyou.getSyono(), "20806000019", "証券番号");
        exStringEquals(Suiihyou.getSuiihyousyubetu(), "13", "推移表種別");
        exDateEquals(Suiihyou.getTyouhyouymd(), BizDate.valueOf(20231001), "帳票作成日");
        exClassificationEquals(Suiihyou.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(6147500), "目標到達時円建終身保険移行特約目標額");
        exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20241001), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202410), "計算年月");
        exBizCalcbleEquals(Suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(Suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        checkWSuiihyou1_SSjkkktusirrt(Suiihyou);
        checkWSuiihyou2_SSjkkktusirrt(Suiihyou);
        checkWSuiihyou1_KawaseRate(Suiihyou);
        checkWSuiihyou2_KawaseRate(Suiihyou);
        checkWSuiihyou3_Default(Suiihyou);
        checkWSuiihyouOther_Default(Suiihyou);
    }


    @Test
    @TestOrder(90)
    public void testEditTBL_C5() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("20806000019");
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> pKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        BizDate pSyoriYmd = BizDate.valueOf(20241001);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(wkKykSyouhn.getSyouhncd(),wkKykSyouhn.getSyouhnsdno());
        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        editSuiihyouTblNenkin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,pKykSyouhnLst,new IT_HhknSya(),
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pSyouhnZokusei,pKykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "推移表レコード件数");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuUpCount1(), 0, "指数上昇回数１");
        exNumericEquals(editSuiihyouTblNenkin3.getSisuuDownCount1(), 0, "指数下落回数１");

        IT_Suiihyou Suiihyou = suiihyouLst.get(0);
        displayContents(Suiihyou);

        exStringEquals(suiihyouLst.get(0).getSyono(), "20806000019", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20241001), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 99, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), null, "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), null, "計算年月");
        exBizCalcbleEquals(Suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "00", "推移表種別");
        checkWSuiihyou1_Default(Suiihyou);
        checkWSuiihyou2_Default(Suiihyou);
        checkWSuiihyou3_Default(Suiihyou);
        checkWSuiihyouOther_Default(Suiihyou);
    }

    private void checkWSuiihyou1_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(112.95), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(122.95), " 円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(132.95), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
    }

    private void checkWSuiihyou2_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(112.95), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(122.95), " 円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(132.95), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
    }

    private void checkWSuiihyou2_KawaseRateDefault(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), " 円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
    }

    private void checkWSuiihyou3_KawaseRateDefault(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), " 円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
    }

    private void checkWSuiihyou1_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), " 円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
    }

    private void checkWSuiihyou2_Default(IT_Suiihyou suiihyou){
        checkWSuiihyou2_KawaseRateDefault(suiihyou);
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
    }

    private void checkWSuiihyou3_Default(IT_Suiihyou suiihyou){
        checkWSuiihyou3_KawaseRateDefault(suiihyou);
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame3(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.valueOf(0), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), " 積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
    }

    private void checkWSuiihyouOther_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
    }


    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算年月 = {}", pSuiihyou.getCalcym());
        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("▲ 解約返戻金計算の設定値");
    }

}
