package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全Ｄ支払統計契約情報設定クラスのメソッド {@link SetKhDshrTukiKykInfo#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SetKhDshrTukiKykInfoTest_exec {

    @Inject
    private SetKhDshrTukiKykInfo setKhDshrTukiKykInfo;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約保全Ｄ支払統計契約情報設定";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(AnsyuuSetTetudukityuuiInfoTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000016");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("SetKhDshrTukiKykInfo");

        BizDate denymd = BizDate.valueOf(20200106);
        BizDate syoriYmd = BizDate.valueOf(20200107);

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(kykKihon, khozenCommonParam,
            denymd, syoriYmd);

        exNumericEquals(editDshrTukiTanKoumokuBean.getRenno(), 1, "連番");
        exStringEquals(editDshrTukiTanKoumokuBean.getSkno(), "", "請求番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyono(), "10806000016", "証券番号");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSeikyuurirekiNo(), 0, "請求履歴番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getHenkousikibetuKey(), "", "変更識別キー");
        exDateEquals(editDshrTukiTanKoumokuBean.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyouhnCd(), "M120", "商品コード");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(editDshrTukiTanKoumokuBean.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(editDshrTukiTanKoumokuBean.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getKihons(), BizCurrency.valueOf(1690901,BizCurrencyTypes.YEN), "基本Ｓ");
        assertEquals("予定利率", editDshrTukiTanKoumokuBean.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(editDshrTukiTanKoumokuBean.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getSiharaid(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "支払Ｄ");
        assertNull(editDshrTukiTanKoumokuBean.getKhHaitouKanri());
        assertNull(editDshrTukiTanKoumokuBean.getKhTumitateDKanri());
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinKinou(), "SetKhDshrTukiKykInfo", "業務用更新機能ＩＤ");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000027");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("SetKhDshrTukiKykInfo");

        BizDate denymd = BizDate.valueOf(20200106);
        BizDate syoriYmd = BizDate.valueOf(20200107);
        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(kykKihon, khozenCommonParam,
            denymd, syoriYmd);

        exNumericEquals(editDshrTukiTanKoumokuBean.getRenno(), 1, "連番");
        exStringEquals(editDshrTukiTanKoumokuBean.getSkno(), "", "請求番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyono(), "10806000027", "証券番号");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSeikyuurirekiNo(), 0, "請求履歴番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getHenkousikibetuKey(), "", "変更識別キー");
        exDateEquals(editDshrTukiTanKoumokuBean.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyouhnCd(), "M122", "商品コード");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSyouhnsdNo(), 3, "商品世代番号");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "契約状態");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoumetujiyuu(), C_Syoumetujiyuu.KAIJO, "消滅事由");
        exDateEquals(editDshrTukiTanKoumokuBean.getKykymd(), BizDate.valueOf("20200103"), "契約日");
        exDateEquals(editDshrTukiTanKoumokuBean.getYendthnkymd(), BizDate.valueOf("20200107"), "円建変更日");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getKihons(), BizCurrency.valueOf(1690903, BizCurrencyTypes.YEN), "基本Ｓ");
        assertEquals("予定利率", editDshrTukiTanKoumokuBean.getYoteiriritu(), BizNumber.valueOf(0.024));
        exDateEquals(editDshrTukiTanKoumokuBean.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getSiharaid(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "支払Ｄ");
        assertNull(editDshrTukiTanKoumokuBean.getKhHaitouKanri());
        assertNull(editDshrTukiTanKoumokuBean.getKhTumitateDKanri());
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinKinou(), "SetKhDshrTukiKykInfo", "業務用更新機能ＩＤ");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000038");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        baseUserInfo.getUser().setUserId("Junit");
        khozenCommonParam.setFunctionId("SetKhDshrTukiKykInfo");

        BizDate denymd = BizDate.valueOf(20200106);
        BizDate syoriYmd = BizDate.valueOf(20200107);

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(kykKihon, khozenCommonParam,
            denymd, syoriYmd);

        assertNull(editDshrTukiTanKoumokuBean.getRenno());
        exStringEquals(editDshrTukiTanKoumokuBean.getSkno(), null, "請求番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyono(), null, "証券番号");
        assertNull(editDshrTukiTanKoumokuBean.getSeikyuurirekiNo());
        exStringEquals(editDshrTukiTanKoumokuBean.getHenkousikibetuKey(), null, "変更識別キー");
        exDateEquals(editDshrTukiTanKoumokuBean.getSyoriYmd(), null, "処理年月日");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoriKbn(), null, "処理区分");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getHrkkeiro(), null, "払込経路");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyouhnCd(), null, "商品コード");
        assertNull(editDshrTukiTanKoumokuBean.getSyouhnsdNo());
        exClassificationEquals(editDshrTukiTanKoumokuBean.getKykjyoutai(), null, "契約状態");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoumetujiyuu(), null, "消滅事由");
        exDateEquals(editDshrTukiTanKoumokuBean.getKykymd(), null, "契約日");
        exDateEquals(editDshrTukiTanKoumokuBean.getYendthnkymd(), null, "円建変更日");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getKihons(), null, "基本Ｓ");
        assertEquals("予定利率", editDshrTukiTanKoumokuBean.getYoteiriritu(), null);
        exDateEquals(editDshrTukiTanKoumokuBean.getDenymd(), null, "伝票日付");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getSiharaid(), null, "支払Ｄ");
        assertNull(editDshrTukiTanKoumokuBean.getKhHaitouKanri());
        assertNull(editDshrTukiTanKoumokuBean.getKhTumitateDKanri());
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");

    }
}