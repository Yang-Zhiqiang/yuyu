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
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 発生時課税支払調書TBL編集クラスのメソッド {@link HasseijikziEditShrtyousyotbl#exec(KhozenCommonParam,
 * HasseijikziEditShrtyousyotblParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HasseijikziEditShrtyousyotblTest_exec {

    @Inject
    private HasseijikziEditShrtyousyotbl hasseijikziEditShrtyousyotbl;

    @Inject
    HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    AS_Kinou kinou;

    private final static String fileName = "UT-SP_単体テスト仕様書（機能）_発生時課税支払調書TBL編集";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetNenrei.class).to(SetNenreiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetNenreiMockForHozen.caller = HasseijikziEditShrtyousyotblTest_exec.class;
        SetNenreiMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {

        SetNenreiMockForHozen.caller = null;
        SetNenreiMockForHozen.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HasseijikziEditShrtyousyotblTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertTestDataForTantouCd() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HasseijikziEditShrtyousyotblTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    public static void deleteTestDataForTantouCd() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.UKTRSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(500));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(1);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000013", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 6, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 98, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 98, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "2", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "1230001", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "旧通信先住所１", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "旧通信先住所２", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "旧通信先住所３", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "旧契約者", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "1", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN2;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setSyono("17806000024");
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.UKTRSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(1);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000024", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(520), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(2720), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "2", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "1230001", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "旧通信先住所１", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "旧通信先住所２", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "旧通信先住所３", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "旧契約者", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "1", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(1);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000035", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "07", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(1120), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(2720), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "1", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "1230001", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "旧通信先住所１", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "旧通信先住所２", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "旧通信先住所３", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "旧契約者", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "1", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(1);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000046", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "07", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(2720), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 1, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "1", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000057", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "07", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(2720), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000068", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000079", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000080", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000091", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000105", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000116", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000127", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000138", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000149", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000150", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "1", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "1010201", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "通信先住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "通信先住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "通信先住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "契約者", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "02", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000161");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000161", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000172");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000172", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000183");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000183", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000194");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000194", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000208", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000219");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000219", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000220");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000220", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "1", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000231");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000231", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "R01", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "4", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "0", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000242");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.KAIYAKU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        IT_KhTyousyo tyousyo = hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        exStringEquals(tyousyo.getSyono(), "17806000242", "証券番号");
        exDateEquals(tyousyo.getTyouhyouymd(), BizDate.valueOf(20190326), "帳票作成日");
        exNumericEquals(tyousyo.getShrtysyrenno(), 1, "支払調書連番");
        exStringEquals(tyousyo.getKacd(), "001", "課コード");
        exClassificationEquals(tyousyo.getTantocd(), C_TantouCdKbn.BLNK0, "担当コード");
        exStringEquals(tyousyo.getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exNumericEquals(tyousyo.getHknkkn(), 12, "保険期間");
        exNumericEquals(tyousyo.getHrkkkn(), 20, "払込期間");
        exNumericEquals(tyousyo.getHhknnen(), 99, "被保険者年齢");
        exNumericEquals(tyousyo.getKyknen(), 99, "契約者年齢");
        exDateEquals(tyousyo.getKykymd(), BizDate.valueOf(20180101), "契約日");
        exClassificationEquals(tyousyo.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(tyousyo.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(tyousyo.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");
        exStringEquals(tyousyo.getAnnaihuyouriyuukbn(), "01", "案内不要理由区分");
        exBizCalcbleEquals(tyousyo.getHrkp(), BizCurrency.valueOf(0), "払込保険料");
        exDateEquals(tyousyo.getKouryokuhasseiymd(), BizDate.valueOf(20190327), "効力発生日");
        exStringEquals(tyousyo.getMfadrsiyouhyouji(), "0", "ＭＦ住所使用表示");
        exStringEquals(tyousyo.getKihrpdmiseibidisp(), "0", "既払ＰＤ未整備表示");
        exStringEquals(tyousyo.getKihrpseibiyoudisp(), "0", "既払込Ｐ整備要表示");
        exBizCalcbleEquals(tyousyo.getShrgk(), BizCurrency.valueOf(400), "支払金額");
        exBizCalcbleEquals(tyousyo.getWarimsishrgkbizc(), BizCurrency.valueOf(0), "割増支払金額（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getZnnphrbizc(), BizCurrency.valueOf(0), "前納Ｐ等返戻金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getTtkekstkganribizc(), BizCurrency.valueOf(0), "立替貸付元利金（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkdbizc(), BizCurrency.valueOf(1200), "差引Ｄ（業務通貨型）");
        exBizCalcbleEquals(tyousyo.getSshkshrgk(), BizCurrency.valueOf(0), "差引支払金額");
        exBizCalcbleEquals(tyousyo.getMihrkmpbizc(), BizCurrency.valueOf(600), "未払込Ｐ（業務通貨型）");
        exDateEquals(tyousyo.getShrymd(), BizDate.valueOf(20190420), "支払日");
        exStringEquals(tyousyo.getSyorisosikicd(), "050607", "処理組織コード");
        exStringEquals(tyousyo.getSyoritaisyoukbn(), "", "処理対象区分");
        exStringEquals(tyousyo.getShrtysytsinyno(), "020304", "支払調書郵便番号");
        exStringEquals(tyousyo.getShrtysyadr1kj(), "支払調書住所１", "支払調書住所１（漢字）");
        exStringEquals(tyousyo.getShrtysyadr2kj(), "支払調書住所２", "支払調書住所２（漢字）");
        exStringEquals(tyousyo.getShrtysyadr3kj(), "支払調書住所３", "支払調書住所３（漢字）");
        exStringEquals(tyousyo.getKyknmkj(), "契約者", "契約者名（漢字）");
        exStringEquals(tyousyo.getHhknnmkj(), "小野", "被保険者名（漢字）");
        exStringEquals(tyousyo.getUktnmkj(), "受取人", "受取人名（漢字）");
        exStringEquals(tyousyo.getKjdaihyouuktnm(), "", "漢字代表受取人名");
        exBizCalcbleEquals(tyousyo.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(tyousyo.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exStringEquals(tyousyo.getShrtysysyuruicd(), "", "支払調書種類コード");
        exStringEquals(tyousyo.getTeknjikihrpseibidisp(), "0", "転換時既払込Ｐ未整備表示");
        exBizCalcbleEquals(tyousyo.getKihrkmp(), BizCurrency.valueOf(700), "既払込保険料");
        exStringEquals(tyousyo.getOnlinecentercutkbn(), "1", "オンラインセンターカット区分");
        exClassificationEquals(tyousyo.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(tyousyo.getHtykeihihnsyukbn(), "2", "必要経費編集区分");
        exBizCalcbleEquals(tyousyo.getSyuseijtshrdbizc(), BizCurrency.valueOf(0), "修正後実支払Ｄ（業務通貨型）");
        exStringEquals(tyousyo.getTouduketorihouhoukbn(), "0", "当Ｄ受取方法区分");
        exNumericEquals(tyousyo.getNenkinkkn(), 0, "年金期間");
        exStringEquals(tyousyo.getBankcd(), "0000", "銀行コード");
        exStringEquals(tyousyo.getBanknmkn(), "", "銀行名（カナ）");
        exStringEquals(tyousyo.getSitencd(), "000", "支店コード");
        exStringEquals(tyousyo.getSitennmkn(), "", "支店名（カナ）");
        exClassificationEquals(tyousyo.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(tyousyo.getYokinknmkn(), "", "預金口座種目名（カナ）");
        exStringEquals(tyousyo.getKouzano(), "000000000000", "口座番号");
        exStringEquals(tyousyo.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exDateEquals(tyousyo.getSakuseiymd(), BizDate.valueOf(20190326), "作成年月日");
        exStringEquals(tyousyo.getKykmnmeigibangou(), "808", "契約者ＭＮ名義番号");
        exStringEquals(tyousyo.getUktmnmeigibangou(), "909", "受取人ＭＮ名義番号");
        exStringEquals(tyousyo.getJigyoukykmndantaicd(), "", "事業契約用ＭＮ団体コード");
        exStringEquals(tyousyo.getMnsaiannaihnskakbn(), "00", "ＭＮ再案内本社回送区分");
        exStringEquals(tyousyo.getHuho2kykdisp(), "1", "普保Ⅱ契約表示");
        exClassificationEquals(tyousyo.getShrtysyhknsyukbn(), C_ShrtysyhknsyuKbn.SYUUSIN, "支払調書保険種類区分");
        exStringEquals(tyousyo.getShrtysykurikosidisp(), "0", "支払調書繰越表示");
        exStringEquals(tyousyo.getTsinyno(), "1010201", "通信先郵便番号");
        exStringEquals(tyousyo.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(tyousyo.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(tyousyo.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(tyousyo.getSynyhsjykykndisp(), "0", "収入保障年金受給権表示");
        exStringEquals(tyousyo.getTblsakuseihunodisp(), "", "テープ作成不能表示");
        exStringEquals(tyousyo.getDaihyouktkbn(), "0", "代表受取人区分");
        exStringEquals(tyousyo.getGyoumuKousinKinou(), "HasseijikziEditShrtyousyotbl", "業務用更新機能ＩＤ");
        exStringEquals(tyousyo.getGyoumuKousinsyaId(), "Wang", "業務用更新者ＩＤ");
        exStringEquals(tyousyo.getOldtsinyno(), "", "旧通信先郵便番号");
        exStringEquals(tyousyo.getOldtsinadr1kj(), "", "旧通信先住所１（漢字）");
        exStringEquals(tyousyo.getOldtsinadr2kj(), "", "旧通信先住所２（漢字）");
        exStringEquals(tyousyo.getOldtsinadr3kj(), "", "旧通信先住所３（漢字）");
        exStringEquals(tyousyo.getOldkyknmkj(), "", "旧契約者名（漢字）");
        exNumericEquals(tyousyo.getKykhnkkaisuu(), 0, "契約者変更回数");
        exStringEquals(tyousyo.getShrkykhtykeihiyouhyj(), "0", "支払時契約者必要経費要表示");
        exBizCalcbleEquals(tyousyo.getShrkykhtykeihi(), BizCurrency.valueOf(800), "支払時契約者必要経費");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20180101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(19850203), "生年月日");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(250)
    public void testExec_A25() {

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000253");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        try {

            hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性マスタにデータが存在しません。商品コード：ﾕｱ　商品世代番号：1", "メッセージ内容");

            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(260)
    public void testExec_A26() {

        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN3;

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000264");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        try {

            hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。他システム連動用区分値変換に失敗しました。区分名：案内不要理由区分　　区分値：2", "メッセージ内容");

            exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0),
                BizDate.valueOf(20180101), "基準日");
            exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1),
                BizDate.valueOf(19850203), "生年月日");

            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {

        deleteTestDataForTantouCd();
        insertTestDataForTantouCd();

        KhozenCommonParam commonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000275");
        commonParam.setBatchKeiyakuKihon(kykKihon);
        kinou.setKinouKbn(C_KinouKbn.BLNK);
        kinou.setKinouId("HasseijikziEditShrtyousyotbl");
        AM_User user = new AM_User();
        user.setUserId("Wang");
        changeCurrentUser(baseUserInfo, user);

        HasseijikziEditShrtyousyotblParam tblParam = SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
        tblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        tblParam.setMfadrsiyouhyouji(C_UmuKbn.NONE);
        tblParam.setShrtysytsinyno("020304");
        tblParam.setShrtysyadr1kj("支払調書住所１");
        tblParam.setShrtysyadr2kj("支払調書住所２");
        tblParam.setShrtysyadr3kj("支払調書住所３");
        tblParam.setUktnmkj("受取人");
        tblParam.setYenhaitoukin(BizCurrency.valueOf(1000));
        tblParam.setYensonotahaitoukin(BizCurrency.valueOf(200));
        tblParam.setHtsiryosyuKbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        tblParam.setYenkansansonotaseisank(BizCurrency.valueOf(300));
        tblParam.setShrgk(BizCurrency.valueOf(400));
        tblParam.setSynykngk(BizCurrency.valueOf(2720));
        tblParam.setMihrkmp(BizCurrency.valueOf(600));
        tblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        tblParam.setKykhnkkaisuu(0);
        tblParam.setSyoriymd(BizDate.valueOf(20190326));
        tblParam.setKouryokuhasseiYmd(BizDate.valueOf(20190327));
        tblParam.setShrymd(BizDate.valueOf(20190420));
        tblParam.setSyorisosikicd("050607");
        tblParam.setKihrkmp(BizCurrency.valueOf(700));
        tblParam.setKykmnmeigibangou("808");
        tblParam.setUktmnmeigibangou("909");
        tblParam.setShrkykhtykeihi(BizCurrency.valueOf(800));

        try {

            hasseijikziEditShrtyousyotbl.exec(commonParam, tblParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。担当コードマスタにデータが存在しません。担当コード：R", "メッセージ内容");

            throw e;
        }
    }
}