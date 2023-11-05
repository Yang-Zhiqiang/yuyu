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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * GetKhHenkouRirekiクラスのメソッド {@link GetKhHenkouRireki#getKhSisuurendoTmttknTblSakujyo(GetKhSisuurendoTmttknTblSakujyoBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetKhHenkouRirekiTest_exec {


    @Inject
    private GetKhHenkouRireki  getKhHenkouRireki;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約保全変更履歴取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckSTaniTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());

    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        GetKhSisuurendoTmttknTblSakujyoBean getKhSisuurendoTmttknTblSakujyoBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);

        IT_KhHenkouRireki khHenkouRireki = new IT_KhHenkouRireki();
        khHenkouRireki.setKbnkey("01");
        khHenkouRireki.setSyono("60806020017");
        khHenkouRireki.setBfrnaiyou("積立金対象年月：201809／連番：1／積立金効力開始日：20180901／定率積立金額：1000／指数連動積立金額：10000／指数上昇率：1.3529／積立金増加率：0.3528／積立金反映時積増判定日：20180902／積立金反映時指数：5.67809／移転前定率積立金額：12345600／移転前指数連動積立金額：23456700／通貨種類：USD");

        getKhSisuurendoTmttknTblSakujyoBean.setKhHenkouRireki(khHenkouRireki);

        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(getKhSisuurendoTmttknTblSakujyoBean);

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(HenkanTuuka.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getKbnkey(), "01", "区分キー");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSyono(), "60806020017", "証券番号");
        exDateYMEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttkntaisyouym(), BizDateYM.valueOf("201809"), "積立金対象年月");
        exNumericEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getRenno(), 1, "連番");
        exDateEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknkouryokukaisiymd(), BizDate.valueOf(20180901), "積立金効力開始日");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTeiritutmttkngk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSisuurendoutmttkngk(), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSisuuupritu(), BizNumber.valueOf(1.3529), "指数上昇率");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknzoukaritu(), BizNumber.valueOf(0.3528), "積立金増加率");
        exDateEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknhaneitmmshanteiymd(), BizDate.valueOf(20180902), "積立金反映時積増判定日");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknhaneisisuu(), BizNumber.valueOf(5.67809), "積立金反映時指数");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinKinou(), "init", "業務用更新機能ＩＤ");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinsyaId(), "init", "業務用更新者ＩＤ");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinTime(), "0", "業務用更新時間");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getItenmaeteiritutmttkngk(), BizCurrency.valueOf(12345600, BizCurrencyTypes.DOLLAR), "移転前定率積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(23456700, BizCurrencyTypes.DOLLAR), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        GetKhSisuurendoTmttknTblSakujyoBean getKhSisuurendoTmttknTblSakujyoBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);

        IT_KhHenkouRireki khHenkouRireki = new IT_KhHenkouRireki();
        khHenkouRireki.setKbnkey("02");
        khHenkouRireki.setSyono("60806020028");
        khHenkouRireki.setBfrnaiyou("");

        getKhSisuurendoTmttknTblSakujyoBean.setKhHenkouRireki(khHenkouRireki);

        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(getKhSisuurendoTmttknTblSakujyoBean);

        exBooleanEquals(getKhSisuurendoTmttknTblBean == null, true, "指数連動積増型年金積立金TBL取得Bean");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        GetKhSisuurendoTmttknTblSakujyoBean getKhSisuurendoTmttknTblSakujyoBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);

        IT_KhHenkouRireki khHenkouRireki = null;

        getKhSisuurendoTmttknTblSakujyoBean.setKhHenkouRireki(khHenkouRireki);

        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(getKhSisuurendoTmttknTblSakujyoBean);

        exBooleanEquals(getKhSisuurendoTmttknTblBean == null, true, "指数連動積増型年金積立金TBL取得Bean");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        GetKhSisuurendoTmttknTblSakujyoBean getKhSisuurendoTmttknTblSakujyoBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);

        IT_KhHenkouRireki khHenkouRireki = new IT_KhHenkouRireki();
        khHenkouRireki.setKbnkey("02");
        khHenkouRireki.setSyono("99806018928");
        khHenkouRireki.setBfrnaiyou("積立金対象年月：201909／連番：1／積立金効力開始日：20190901／定率積立金額：10240／指数連動積立金額：0／指数上昇率：0／積立金増加率：0／積立金反映時積増判定日：null／積立金反映時指数：0／移転前定率積立金額：0／移転前指数連動積立金額：0／通貨種類：AUD");

        getKhSisuurendoTmttknTblSakujyoBean.setKhHenkouRireki(khHenkouRireki);

        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(getKhSisuurendoTmttknTblSakujyoBean);

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(HenkanTuuka.class, "henkanTuukaKbnToType", 1, 0), C_Tuukasyu.AUD, "契約通貨種類");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getKbnkey(), "02", "区分キー");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSyono(), "99806018928", "証券番号");
        exDateYMEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttkntaisyouym(), BizDateYM.valueOf("201909"), "積立金対象年月");
        exNumericEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getRenno(), 1, "連番");
        exDateEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknkouryokukaisiymd(), BizDate.valueOf(20190901), "積立金効力開始日");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTeiritutmttkngk(), BizCurrency.valueOf(10240, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSisuurendoutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getSisuuupritu(), BizNumber.valueOf(0), "指数上昇率");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknzoukaritu(), BizNumber.valueOf(0), "積立金増加率");
        exDateEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknhaneitmmshanteiymd(), null, "積立金反映時積増判定日");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getTmttknhaneisisuu(), BizNumber.valueOf(0), "積立金反映時指数");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinKinou(), "init", "業務用更新機能ＩＤ");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinsyaId(), "init", "業務用更新者ＩＤ");
        exStringEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getGyoumuKousinTime(), "0", "業務用更新時間");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getItenmaeteiritutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "移転前定率積立金額");
        exBizCalcbleEquals(getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn().getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "移転前指数連動積立金額");

    }
}