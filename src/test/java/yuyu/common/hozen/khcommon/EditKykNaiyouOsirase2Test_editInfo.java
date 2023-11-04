package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集２のメソッド {@link EditKykNaiyouOsirase2#editInfo(IT_KykKihon ,BizDate ,
        BizDate ,String ,ZT_GaikaKokyakuTuutiTy)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase2Test_editInfo {

    @Inject
    private EditKykNaiyouOsirase2 editKykNaiyouOsirase2;

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集２";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsirase2Test_editInfo.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSisuuKihon());

    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetNenrei.class).to(SetNenreiMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetNenreiMockForHozen.caller = EditKykNaiyouOsirase2Test_editInfo.class;
        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase2Test_editInfo.class;
        KeisanGaikakanzanMockForHozen.caller = EditKykNaiyouOsirase2Test_editInfo.class;
    }

    @AfterClass
    public static void testClear() {
        SetNenreiMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditInfo_A1() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate pSyoriYmd = BizDate.valueOf(20190101);
        BizDate pKykoutoubi = BizDate.valueOf(20190101);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        String message = "";
        try{
            editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);
        }catch(CommonBizAppException e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditInfo_A2() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate pSyoriYmd = BizDate.valueOf(20190101);
        BizDate pKykoutoubi = BizDate.valueOf(20190101);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();;

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        C_ErrorKbn errkbn = editKykNaiyouOsirase2.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditInfo_A3() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate pSyoriYmd = BizDate.valueOf(20190101);
        BizDate pKykoutoubi = BizDate.valueOf(20190101);
        String pSyouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 10, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 1, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000013", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190101), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1100), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(1111,BizCurrencyTypes.YEN), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(4444,BizCurrencyTypes.YEN), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(3333,BizCurrencyTypes.YEN), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "００００年　０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "米ドル", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "USD", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1010", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "110000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "100100", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "101000", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1010", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "1", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "110000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "1102", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "101", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "1", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "２０１９年　７月１９日", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "110000", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "0", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "0", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "0", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月2日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "1", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "110000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "1234500", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1010", "（中継用）為替レート＿１");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(1100,BizCurrencyTypes.YEN), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditInfo_A4() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000024");
        BizDate pSyoriYmd = BizDate.valueOf(20190201);
        BizDate pKykoutoubi = BizDate.valueOf(20190202);
        String pSyouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 12, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 2, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000024", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190202), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(110,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(440,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(330.60,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "００００年　０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "米ドル", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "USD", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "2", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "210000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "10020000", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "105000", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1050", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "1200", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1050", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "11000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "44000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "33060", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "1210", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "0", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "2", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "05009", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "２０１９年　７月１８日", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "13000", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "0", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "0", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "0", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月1日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "1", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "11000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "1234100", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1050", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "4", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年3月1日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "1", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "13000", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "1234300", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "0", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "1234", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "0", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1050", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "2", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2019年2月2日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "1", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "13000", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "12311", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1050", "（中継用）為替レート＿３");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(110.00,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 1), BizCurrency.valueOf(130.00,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 1), BizCurrency.valueOf(130.00,BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 2), BizNumber.valueOf(10.5), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditInfo_A5() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000035");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190302);
        String pSyouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 13, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 3, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000035", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190302), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1300), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "００００年　０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "0", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "310000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "130000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05009", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "２０１９年　７月２２日", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "2816000", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "ボラコン１", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月3日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "1", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "1100000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "1233100", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "4", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年4月3日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "1", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "1400000", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "1233400", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "1", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "1234", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "1324", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1060", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "2", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2019年3月2日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "1", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "1400000", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "12311", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1060", "（中継用）為替レート＿３");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 1), BizCurrency.valueOf(14000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 1), BizCurrency.valueOf(14000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testEditInfo_A6() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000046");
        BizDate pSyoriYmd = BizDate.valueOf(20190929);
        BizDate pKykoutoubi = BizDate.valueOf(20190930);
        String pSyouhnHanmeiKbn = "06";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000046", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190930), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　９月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "３年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "410000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "100400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "1", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "248900", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年4月28日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "110000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(1100), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testEditInfo_A7() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000057");
        BizDate pSyoriYmd = BizDate.valueOf(20190930);
        BizDate pKykoutoubi = BizDate.valueOf(20190930);
        String pSyouhnHanmeiKbn = "06";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000057", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190930), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　９月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "422800", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年5月30日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "110000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "0", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年6月30日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "120000", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1060", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "0", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2018年7月30日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "130000", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1060", "（中継用）為替レート＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx4(), "0", "（中継用）積立金推移履歴区分＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix4(), "2018年8月30日", "（中継用）契約応当日＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix4(), "", "（中継用）積立金状態＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax4(), "150000", "（中継用）保険料積立金額（契約通貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx4(), "2001", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux4(), "", "（中継用）指数＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux4(), "", "（中継用）指数上昇率符号＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux4(), "", "（中継用）指数上昇率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx4(), "", "（中継用）積立金増加率（文字列）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex4(), "1060", "（中継用）為替レート＿４");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx5(), "0", "（中継用）積立金推移履歴区分＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix5(), "2018年9月30日", "（中継用）契約応当日＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix5(), "", "（中継用）積立金状態＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax5(), "130000", "（中継用）保険料積立金額（契約通貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx5(), "2001", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux5(), "", "（中継用）指数＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux5(), "", "（中継用）指数上昇率符号＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux5(), "", "（中継用）指数上昇率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx5(), "", "（中継用）積立金増加率（文字列）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex5(), "1060", "（中継用）為替レート＿５");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx6(), "0", "（中継用）積立金推移履歴区分＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix6(), "2018年10月30日", "（中継用）契約応当日＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix6(), "", "（中継用）積立金状態＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax6(), "160000", "（中継用）保険料積立金額（契約通貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx6(), "2001", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux6(), "", "（中継用）指数＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux6(), "", "（中継用）指数上昇率符号＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux6(), "", "（中継用）指数上昇率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx6(), "", "（中継用）積立金増加率（文字列）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex6(), "1060", "（中継用）為替レート＿６");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx7(), "0", "（中継用）積立金推移履歴区分＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix7(), "2018年11月30日", "（中継用）契約応当日＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix7(), "", "（中継用）積立金状態＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax7(), "170000", "（中継用）保険料積立金額（契約通貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx7(), "2001", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux7(), "", "（中継用）指数＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux7(), "", "（中継用）指数上昇率符号＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux7(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx7(), "", "（中継用）積立金増加率（文字列）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex7(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx8(), "0", "（中継用）積立金推移履歴区分＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix8(), "2018年12月30日", "（中継用）契約応当日＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix8(), "", "（中継用）積立金状態＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax8(), "180000", "（中継用）保険料積立金額（契約通貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx8(), "2001", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux8(), "", "（中継用）指数＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux8(), "", "（中継用）指数上昇率符号＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux8(), "", "（中継用）指数上昇率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx8(), "", "（中継用）積立金増加率（文字列）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex8(), "1060", "（中継用）為替レート＿８");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx9(), "0", "（中継用）積立金推移履歴区分＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix9(), "2019年1月30日", "（中継用）契約応当日＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix9(), "", "（中継用）積立金状態＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax9(), "190000", "（中継用）保険料積立金額（契約通貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx9(), "2001", "（中継用）保険料積立金額（円貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux9(), "", "（中継用）指数＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux9(), "", "（中継用）指数上昇率符号＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux9(), "", "（中継用）指数上昇率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx9(), "", "（中継用）積立金増加率（文字列）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex9(), "1060", "（中継用）為替レート＿９");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx10(), "0", "（中継用）積立金推移履歴区分＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix10(), "2019年2月28日", "（中継用）契約応当日＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix10(), "", "（中継用）積立金状態＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax10(), "200000", "（中継用）保険料積立金額（契約通貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx10(), "2001", "（中継用）保険料積立金額（円貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux10(), "", "（中継用）指数＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux10(), "", "（中継用）指数上昇率符号＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux10(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx10(), "", "（中継用）積立金増加率（文字列）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex10(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx11(), "0", "（中継用）積立金推移履歴区分＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix11(), "2019年3月30日", "（中継用）契約応当日＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix11(), "", "（中継用）積立金状態＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax11(), "210000", "（中継用）保険料積立金額（契約通貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx11(), "2001", "（中継用）保険料積立金額（円貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux11(), "", "（中継用）指数＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux11(), "", "（中継用）指数上昇率符号＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux11(), "", "（中継用）指数上昇率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx11(), "", "（中継用）積立金増加率（文字列）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex11(), "1060", "（中継用）為替レート＿１１");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(1100), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 1), BizCurrency.valueOf(1200), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 1), BizCurrency.valueOf(1300), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 1), BizCurrency.valueOf(1500), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 1), BizCurrency.valueOf(1300), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 1), BizCurrency.valueOf(1600), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 1), BizCurrency.valueOf(1700), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 1), BizCurrency.valueOf(1800), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 1), BizCurrency.valueOf(1900), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 1), BizCurrency.valueOf(2000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 1), BizCurrency.valueOf(2100), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testEditInfo_A8() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000068");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000068", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190830), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05012", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月30日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "1", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "110000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "1233000", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "0", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年2月28日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "1", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "110100", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "1233100", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "1", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "1221", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "1331", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1060", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "0", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2018年3月30日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "1", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "110200", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "1233200", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "0", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "1222", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "1332", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1060", "（中継用）為替レート＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx4(), "0", "（中継用）積立金推移履歴区分＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix4(), "2018年4月30日", "（中継用）契約応当日＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix4(), "1", "（中継用）積立金状態＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax4(), "110300", "（中継用）保険料積立金額（契約通貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx4(), "2001", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux4(), "1233300", "（中継用）指数＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux4(), "0", "（中継用）指数上昇率符号＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux4(), "1223", "（中継用）指数上昇率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx4(), "1333", "（中継用）積立金増加率（文字列）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex4(), "1060", "（中継用）為替レート＿４");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx5(), "0", "（中継用）積立金推移履歴区分＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix5(), "2018年5月30日", "（中継用）契約応当日＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix5(), "1", "（中継用）積立金状態＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax5(), "110400", "（中継用）保険料積立金額（契約通貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx5(), "2001", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux5(), "1233400", "（中継用）指数＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux5(), "0", "（中継用）指数上昇率符号＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux5(), "1224", "（中継用）指数上昇率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx5(), "1334", "（中継用）積立金増加率（文字列）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex5(), "1060", "（中継用）為替レート＿５");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx6(), "0", "（中継用）積立金推移履歴区分＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix6(), "2018年6月30日", "（中継用）契約応当日＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix6(), "1", "（中継用）積立金状態＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax6(), "110500", "（中継用）保険料積立金額（契約通貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx6(), "2001", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux6(), "1233500", "（中継用）指数＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux6(), "0", "（中継用）指数上昇率符号＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux6(), "1225", "（中継用）指数上昇率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx6(), "1335", "（中継用）積立金増加率（文字列）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex6(), "1060", "（中継用）為替レート＿６");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx7(), "0", "（中継用）積立金推移履歴区分＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix7(), "2018年7月30日", "（中継用）契約応当日＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix7(), "1", "（中継用）積立金状態＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax7(), "110600", "（中継用）保険料積立金額（契約通貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx7(), "2001", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux7(), "1233600", "（中継用）指数＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux7(), "0", "（中継用）指数上昇率符号＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux7(), "1226", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx7(), "1336", "（中継用）積立金増加率（文字列）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex7(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx8(), "0", "（中継用）積立金推移履歴区分＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix8(), "2018年8月30日", "（中継用）契約応当日＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix8(), "1", "（中継用）積立金状態＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax8(), "110700", "（中継用）保険料積立金額（契約通貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx8(), "2001", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux8(), "1233700", "（中継用）指数＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux8(), "0", "（中継用）指数上昇率符号＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux8(), "1227", "（中継用）指数上昇率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx8(), "1337", "（中継用）積立金増加率（文字列）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex8(), "1060", "（中継用）為替レート＿８");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx9(), "0", "（中継用）積立金推移履歴区分＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix9(), "2018年9月30日", "（中継用）契約応当日＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix9(), "1", "（中継用）積立金状態＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax9(), "110800", "（中継用）保険料積立金額（契約通貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx9(), "2001", "（中継用）保険料積立金額（円貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux9(), "1233800", "（中継用）指数＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux9(), "0", "（中継用）指数上昇率符号＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux9(), "1228", "（中継用）指数上昇率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx9(), "1338", "（中継用）積立金増加率（文字列）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex9(), "1060", "（中継用）為替レート＿９");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx10(), "0", "（中継用）積立金推移履歴区分＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix10(), "2018年10月30日", "（中継用）契約応当日＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix10(), "1", "（中継用）積立金状態＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax10(), "110900", "（中継用）保険料積立金額（契約通貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx10(), "2001", "（中継用）保険料積立金額（円貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux10(), "1233900", "（中継用）指数＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux10(), "0", "（中継用）指数上昇率符号＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux10(), "1229", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx10(), "1339", "（中継用）積立金増加率（文字列）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex10(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx11(), "0", "（中継用）積立金推移履歴区分＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix11(), "2018年11月30日", "（中継用）契約応当日＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix11(), "1", "（中継用）積立金状態＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax11(), "111000", "（中継用）保険料積立金額（契約通貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx11(), "2001", "（中継用）保険料積立金額（円貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux11(), "1234000", "（中継用）指数＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux11(), "0", "（中継用）指数上昇率符号＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux11(), "1230", "（中継用）指数上昇率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx11(), "1340", "（中継用）積立金増加率（文字列）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex11(), "1060", "（中継用）為替レート＿１１");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 1), BizCurrency.valueOf(1100), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 1), BizCurrency.valueOf(1101), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 5, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 1), BizCurrency.valueOf(1102), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 6, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 1), BizCurrency.valueOf(1103), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 7, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 1), BizCurrency.valueOf(1104), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 8, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 1), BizCurrency.valueOf(1105), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 9, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 1), BizCurrency.valueOf(1106), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 10, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 1), BizCurrency.valueOf(1107), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 11, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 1), BizCurrency.valueOf(1108), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 12, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 1), BizCurrency.valueOf(1109), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 13, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 1), BizCurrency.valueOf(1110), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 14, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testEditInfo_A9() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000079");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000079", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190830), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05012", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testEditInfo_A10() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000080", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190830), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05012", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testEditInfo_A11() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000091");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000091", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190830), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "248900", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05011", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testEditInfo_A12() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000105");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 0), 14, "被保険者年齢");
        exNumericEquals((int)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "getNkshrStartNenrei", 0, 1), 4, "保険期間");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000105", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190830), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1400), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(11000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 1), BizCurrency.valueOf(44000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 1), BizCurrency.valueOf(33000), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 2), BizNumber.valueOf(10.6), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "248900", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05011", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testEditInfo_A13() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000116");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyaisatumsgcd1(), "03002", "（中継用）挨拶文メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyaisatumsgcd2(), null, "（中継用）挨拶文メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "271700", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05011", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月30日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "2", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "220000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "3", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年2月28日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "3", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "220200", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "1233100", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "1", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "1221", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "1331", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1060", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "0", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2018年3月30日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "2", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "220400", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "1235", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1060", "（中継用）為替レート＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx4(), "0", "（中継用）積立金推移履歴区分＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix4(), "2018年4月30日", "（中継用）契約応当日＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix4(), "2", "（中継用）積立金状態＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax4(), "220600", "（中継用）保険料積立金額（契約通貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx4(), "2001", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux4(), "", "（中継用）指数＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux4(), "", "（中継用）指数上昇率符号＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux4(), "", "（中継用）指数上昇率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx4(), "1235", "（中継用）積立金増加率（文字列）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex4(), "1060", "（中継用）為替レート＿４");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx5(), "0", "（中継用）積立金推移履歴区分＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix5(), "2018年5月30日", "（中継用）契約応当日＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix5(), "1", "（中継用）積立金状態＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax5(), "110400", "（中継用）保険料積立金額（契約通貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx5(), "2001", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux5(), "1233400", "（中継用）指数＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux5(), "0", "（中継用）指数上昇率符号＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux5(), "1224", "（中継用）指数上昇率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx5(), "1334", "（中継用）積立金増加率（文字列）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex5(), "1060", "（中継用）為替レート＿５");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx6(), "0", "（中継用）積立金推移履歴区分＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix6(), "2018年6月30日", "（中継用）契約応当日＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix6(), "2", "（中継用）積立金状態＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax6(), "221000", "（中継用）保険料積立金額（契約通貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx6(), "2001", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux6(), "", "（中継用）指数＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux6(), "", "（中継用）指数上昇率符号＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux6(), "", "（中継用）指数上昇率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx6(), "1235", "（中継用）積立金増加率（文字列）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex6(), "1060", "（中継用）為替レート＿６");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx7(), "0", "（中継用）積立金推移履歴区分＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix7(), "2018年7月30日", "（中継用）契約応当日＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix7(), "2", "（中継用）積立金状態＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax7(), "221200", "（中継用）保険料積立金額（契約通貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx7(), "2001", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux7(), "", "（中継用）指数＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux7(), "", "（中継用）指数上昇率符号＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux7(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx7(), "1235", "（中継用）積立金増加率（文字列）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex7(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx8(), "0", "（中継用）積立金推移履歴区分＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix8(), "2018年8月30日", "（中継用）契約応当日＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix8(), "2", "（中継用）積立金状態＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax8(), "221400", "（中継用）保険料積立金額（契約通貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx8(), "2001", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux8(), "", "（中継用）指数＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux8(), "", "（中継用）指数上昇率符号＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux8(), "", "（中継用）指数上昇率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx8(), "1235", "（中継用）積立金増加率（文字列）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex8(), "1060", "（中継用）為替レート＿８");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx9(), "0", "（中継用）積立金推移履歴区分＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix9(), "2018年9月30日", "（中継用）契約応当日＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix9(), "2", "（中継用）積立金状態＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax9(), "221600", "（中継用）保険料積立金額（契約通貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx9(), "2001", "（中継用）保険料積立金額（円貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux9(), "", "（中継用）指数＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux9(), "", "（中継用）指数上昇率符号＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux9(), "", "（中継用）指数上昇率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx9(), "1235", "（中継用）積立金増加率（文字列）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex9(), "1060", "（中継用）為替レート＿９");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx10(), "0", "（中継用）積立金推移履歴区分＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix10(), "2018年10月30日", "（中継用）契約応当日＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix10(), "2", "（中継用）積立金状態＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax10(), "221800", "（中継用）保険料積立金額（契約通貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx10(), "2001", "（中継用）保険料積立金額（円貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux10(), "", "（中継用）指数＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux10(), "", "（中継用）指数上昇率符号＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux10(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx10(), "1235", "（中継用）積立金増加率（文字列）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex10(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx11(), "0", "（中継用）積立金推移履歴区分＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix11(), "2018年11月30日", "（中継用）契約応当日＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix11(), "2", "（中継用）積立金状態＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax11(), "222000", "（中継用）保険料積立金額（契約通貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx11(), "2001", "（中継用）保険料積立金額（円貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux11(), "", "（中継用）指数＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux11(), "", "（中継用）指数上昇率符号＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux11(), "", "（中継用）指数上昇率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx11(), "1235", "（中継用）積立金増加率（文字列）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex11(), "1060", "（中継用）為替レート＿１１");

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testEditInfo_A14() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000127");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyaisatumsgcd1(), "03001", "（中継用）挨拶文メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyaisatumsgcd2(), null, "（中継用）挨拶文メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "271700", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05011", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月30日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "2", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "240000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx2(), "0", "（中継用）積立金推移履歴区分＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix2(), "2018年2月28日", "（中継用）契約応当日＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix2(), "2", "（中継用）積立金状態＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax2(), "220200", "（中継用）保険料積立金額（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx2(), "2001", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux2(), "", "（中継用）指数＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux2(), "", "（中継用）指数上昇率符号＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux2(), "", "（中継用）指数上昇率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx2(), "1235", "（中継用）積立金増加率（文字列）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex2(), "1060", "（中継用）為替レート＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx3(), "0", "（中継用）積立金推移履歴区分＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix3(), "2018年3月30日", "（中継用）契約応当日＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix3(), "2", "（中継用）積立金状態＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax3(), "220400", "（中継用）保険料積立金額（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx3(), "2001", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux3(), "", "（中継用）指数＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux3(), "", "（中継用）指数上昇率符号＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux3(), "", "（中継用）指数上昇率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx3(), "1235", "（中継用）積立金増加率（文字列）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex3(), "1060", "（中継用）為替レート＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx4(), "0", "（中継用）積立金推移履歴区分＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix4(), "2018年4月30日", "（中継用）契約応当日＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix4(), "2", "（中継用）積立金状態＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax4(), "220600", "（中継用）保険料積立金額（契約通貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx4(), "2001", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux4(), "", "（中継用）指数＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux4(), "", "（中継用）指数上昇率符号＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux4(), "", "（中継用）指数上昇率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx4(), "1235", "（中継用）積立金増加率（文字列）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex4(), "1060", "（中継用）為替レート＿４");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx5(), "0", "（中継用）積立金推移履歴区分＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix5(), "2018年5月30日", "（中継用）契約応当日＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix5(), "2", "（中継用）積立金状態＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax5(), "220800", "（中継用）保険料積立金額（契約通貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx5(), "2001", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux5(), "", "（中継用）指数＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux5(), "", "（中継用）指数上昇率符号＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux5(), "", "（中継用）指数上昇率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx5(), "1235", "（中継用）積立金増加率（文字列）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex5(), "1060", "（中継用）為替レート＿５");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx6(), "0", "（中継用）積立金推移履歴区分＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix6(), "2018年6月30日", "（中継用）契約応当日＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix6(), "2", "（中継用）積立金状態＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax6(), "221000", "（中継用）保険料積立金額（契約通貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx6(), "2001", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux6(), "", "（中継用）指数＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux6(), "", "（中継用）指数上昇率符号＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux6(), "", "（中継用）指数上昇率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx6(), "1235", "（中継用）積立金増加率（文字列）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex6(), "1060", "（中継用）為替レート＿６");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx7(), "0", "（中継用）積立金推移履歴区分＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix7(), "2018年7月30日", "（中継用）契約応当日＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix7(), "2", "（中継用）積立金状態＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax7(), "221200", "（中継用）保険料積立金額（契約通貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx7(), "2001", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux7(), "", "（中継用）指数＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux7(), "", "（中継用）指数上昇率符号＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux7(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx7(), "1235", "（中継用）積立金増加率（文字列）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex7(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx8(), "0", "（中継用）積立金推移履歴区分＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix8(), "2018年8月30日", "（中継用）契約応当日＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix8(), "2", "（中継用）積立金状態＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax8(), "221400", "（中継用）保険料積立金額（契約通貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx8(), "2001", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux8(), "", "（中継用）指数＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux8(), "", "（中継用）指数上昇率符号＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux8(), "", "（中継用）指数上昇率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx8(), "1235", "（中継用）積立金増加率（文字列）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex8(), "1060", "（中継用）為替レート＿８");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx9(), "0", "（中継用）積立金推移履歴区分＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix9(), "2018年9月30日", "（中継用）契約応当日＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix9(), "2", "（中継用）積立金状態＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax9(), "221600", "（中継用）保険料積立金額（契約通貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx9(), "2001", "（中継用）保険料積立金額（円貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux9(), "", "（中継用）指数＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux9(), "", "（中継用）指数上昇率符号＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux9(), "", "（中継用）指数上昇率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx9(), "1235", "（中継用）積立金増加率（文字列）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex9(), "1060", "（中継用）為替レート＿９");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx10(), "0", "（中継用）積立金推移履歴区分＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix10(), "2018年10月30日", "（中継用）契約応当日＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix10(), "2", "（中継用）積立金状態＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax10(), "221800", "（中継用）保険料積立金額（契約通貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx10(), "2001", "（中継用）保険料積立金額（円貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux10(), "", "（中継用）指数＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux10(), "", "（中継用）指数上昇率符号＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux10(), "", "（中継用）指数上昇率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx10(), "1235", "（中継用）積立金増加率（文字列）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex10(), "1060", "（中継用）為替レート＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx11(), "0", "（中継用）積立金推移履歴区分＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix11(), "2018年11月30日", "（中継用）契約応当日＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix11(), "2", "（中継用）積立金状態＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax11(), "222000", "（中継用）保険料積立金額（契約通貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx11(), "2001", "（中継用）保険料積立金額（円貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux11(), "", "（中継用）指数＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux11(), "", "（中継用）指数上昇率符号＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux11(), "", "（中継用）指数上昇率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx11(), "1235", "（中継用）積立金増加率（文字列）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex11(), "1060", "（中継用）為替レート＿１１");

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testEditInfo_A15() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000138");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        String className = "";
        try{
            editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);
        }catch(CommonBizAppException e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。指数連動年金積立金計算が実行できませんでした。", "メッセージ内容");

    }


    @Test
    @TestOrder(160)
    @Transactional
    public void testEditInfo_A16() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000149");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "００００年　０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "10", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "４年確定年金", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenkhrikmrate(), "1060", "（中継用）円貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyitijibrpkyktuuka(), "", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingaku(), "2001", "（中継用）基準金額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkkawaserate(), "1060", "（中継用）基準金額為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgkkyktuuka(), "", "（中継用）年金原資額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykijyunkingakukyktuuka(), "140000", "（中継用）基準金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1060", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "1100000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkktuuka(), "4400000", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitatekngkkyen(), "2001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "3300000", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "2001", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05008", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05010", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyttdkkigen(), "２０１９年　９月１７日", "（中継用）お手続き期限");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykrnkgnsgk(), "241800", "（中継用）仮年金原資額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysetteibairitustr(), "12", "（中継用）設定倍率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtjygnstr(), "1234", "（中継用）積立金増加率上限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzkrtkgnstr(), "0", "（中継用）積立金増加率下限（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytumitateriritustr(), "1235", "（中継用）積立利率（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuunm(), "", "（中継用）指数名");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknsuiirirekikbnx1(), "1", "（中継用）積立金推移履歴区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykeiyakuoutoubix1(), "2018年1月30日", "（中継用）契約応当日＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknjyoutaix1(), "1", "（中継用）積立金状態＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkktuukax1(), "120000", "（中継用）保険料積立金額（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyptumitatekngkyenx1(), "2001", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuux1(), "1234000", "（中継用）指数＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuuprituhugoux1(), "", "（中継用）指数上昇率符号＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysisuuupritux1(), "", "（中継用）指数上昇率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytmttknzoukaritustrx1(), "", "（中継用）積立金増加率（文字列）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykawaseratex1(), "1060", "（中継用）為替レート＿１");

    }


    @Test
    @TestOrder(170)
    @Transactional
    public void testEditInfo_A17() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111133");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtygengkumu(), "0", "（中継用）減額有無");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testEditInfo_A18() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190830);
        BizDate pKykoutoubi = BizDate.valueOf(20190830);
        String pSyouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        editKykNaiyouOsirase2.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtygengkumu(), "1", "（中継用）減額有無");
    }
}
