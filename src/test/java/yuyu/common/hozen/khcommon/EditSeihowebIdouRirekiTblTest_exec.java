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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.HenkanTuukaMockForHozen;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ用異動履歴ＴＢＬ編集のメソッド {@link EditSeihowebIdouRirekiTbl#exec(BizDate ,C_SyoriKbn ,String ,
        String ,String ,String ,IT_KykKihon ,IT_AnsyuKihon )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihowebIdouRirekiTblTest_exec {

    @Inject
    private EditSeihowebIdouRirekiTbl editSeihowebIdouRirekiTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ用異動履歴ＴＢＬ編集";

    private final static String sheetName = "INデータ";

    private final static String syoNo0  = "16806000012";

    private final static String syoNo1  = "17806000013";

    private final static String syoNo2  = "17806000024";

    private final static String syoNo3  = "17806000035";

    private final static String syoNo4  = "17806000046";

    private final static String syoNo5  = "17806000057";

    private final static String syoNo6  = "17806000068";

    private final static String syoNo7  = "17806000079";

    private final static String syoNo8  = "17806000080";

    private final static String syoNo9  = "17806000091";

    private final static String syoNo10  = "17806000105";

    private final static String syoNo11  = "17806000116";

    private final static String syoNo13  = "17806000138";

    private final static String syoNo14  = "17806000149";

    private final static String syoNo15  = "17806000150";

    private final static String syoNo16  = "17806000161";

    private final static String syoNo17  = "17806000172";

    private final static String syoNo18  = "17806000183";

    private final static String syoNo19  = "17806000194";

    private final static String syoNo20  = "17806000208";

    private final static String syoNo21  = "17806000219";

    private final static String syoNo22  = "17806000220";

    private final static String syoNo23  = "17806000231";

    private final static String syoNo24  = "17806000242";

    private final static String syoNo25  = "99806001526";

    private final static String syoNo26  = "17806000264";

    private final static String syoNo27  = "17806000275";

    private final static String syoNo28  = "17806000286";

    private final static String syoNo29  = "17806000297";

    private final static String syoNo30  = "17806000301";

    private final static String syoNo31  = "17806000312";

    private final static String syoNo32  = "17806000323";

    private final static String syoNo33  = "17806000334";

    private final static String syoNo34  = "17806000345";

    private final static String syoNo35  = "17806000356";

    private final static String syoNo36   = "17806000367";

    private final static String syoNo37  = "17806000378";

    private final static String syoNo38  = "99806001489";

    private final static String syoNo39  = "99806001490";

    private final static String syoNo40  = "99806001504";

    private final static String syoNo41  = "99806026310";

    private final static String syoNo42  = "99806026321";

    @BeforeClass
    public static void testInit() {

        KeisanIkkatuPGkMockForKhansyuu.caller = EditSeihowebIdouRirekiTblTest_exec.class;
        HenkanTuukaMockForHozen.caller = EditSeihowebIdouRirekiTblTest_exec.class;
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HenkanTuuka.class).to(HenkanTuukaMockForHozen.class);
                bind(KeisanIkkatuPGk.class).to(KeisanIkkatuPGkMockForKhansyuu.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {

        KeisanIkkatuPGkMockForKhansyuu.caller = null;
        HenkanTuukaMockForHozen.caller = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSeihowebIdouRirekiTblTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0009";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DSEISAN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo0);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo0);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "案内収納基本テーブルのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0010";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo1);

        MockObjectManager.initialize();
        KeisanIkkatuPGkMockForKhansyuu.SYORIPTN = KeisanIkkatuPGkMockForKhansyuu.TESTPATTERN1;
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000013", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0010", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "住所変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "001", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0001", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.ARI, "代理店分担有無");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd2(), "012", "代理店コード２");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd2(), "0012", "募集人コード２");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1231", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1001", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201801), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1010), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khjyuusyohenkou", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");

        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMockForKhansyuu.class, "exec", 0);
        exStringEquals(pKeisanIkkatuPGkBean.getSyouhnCd(), "ﾕｹ", "商品コード");
        exNumericEquals(pKeisanIkkatuPGkBean.getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(pKeisanIkkatuPGkBean.getRyouritusdNo(), "J", "料率世代番号");
        exBizCalcbleEquals(pKeisanIkkatuPGkBean.getHokenryou(), BizCurrency.valueOf(1010), "保険料");
        exNumericEquals(pKeisanIkkatuPGkBean.getKeikamon(), 6, "経過月数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分");

        exBooleanEquals((Boolean)MockObjectManager.getArgument(KeisanIkkatuPGkMockForKhansyuu.class, "exec", 1), false, "一括割引不要フラグ");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0020";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_MEIGIHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo2);

        MockObjectManager.initialize();
        KeisanIkkatuPGkMockForKhansyuu.SYORIPTN = KeisanIkkatuPGkMockForKhansyuu.TESTPATTERN2;
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000024", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0020", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "名義変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "002", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0002", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd2(), "", "代理店コード２");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd2(), "", "募集人コード２");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1232", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1002", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201802), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(2001), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khmeigihenkou", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");

        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMockForKhansyuu.class, "exec", 0);
        exStringEquals(pKeisanIkkatuPGkBean.getSyouhnCd(), "ﾕｹ", "商品コード");
        exNumericEquals(pKeisanIkkatuPGkBean.getSyouhnsdNo(), 2, "商品世代番号");
        exStringEquals(pKeisanIkkatuPGkBean.getRyouritusdNo(), "J", "料率世代番号");
        exBizCalcbleEquals(pKeisanIkkatuPGkBean.getHokenryou(), BizCurrency.valueOf(10.02, BizCurrencyTypes.DOLLAR), "保険料");
        exNumericEquals(pKeisanIkkatuPGkBean.getKeikamon(), 12, "経過月数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");

        exBooleanEquals((Boolean)MockObjectManager.getArgument(KeisanIkkatuPGkMockForKhansyuu.class, "exec", 1), false, "一括割引不要フラグ");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0030";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KAIYAKU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000035", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0030", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "解約消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "003", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0003", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1233", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1003", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201803), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 3, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1003), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0040";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo4);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo4);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000046", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0040", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "解約消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "004", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0004", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1234", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1004", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201804), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 4, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1004), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khbatchkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0050";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_GENGAKU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo5);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo5);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000057", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0050", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "減額", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "005", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0005", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1235", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1005", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201805), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 5, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(10.05, BizCurrencyTypes.DOLLAR), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0060";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo6);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo6);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000068", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0060", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "契約内容変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "006", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0006", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1236", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1006", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201806), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 6, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1006), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiteidairitokuyakuhuka", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0070";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SEINENGAPPISEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo7);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo7);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000079", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0070", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "生年月日性訂正", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "007", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0007", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1237", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1007", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201807), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 7, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(10.07, BizCurrencyTypes.DOLLAR), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.SIBOU ;
        String pHenkousikibetukey = "0080";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0080", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0090";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SYOUKENSAIHAKKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo9);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo9);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000091", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0090", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "証券再発行", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "009", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0009", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1239", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1009", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201809), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 9, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1009), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsyoukensaihakkou", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0100";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo10);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo10);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000105", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0100", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "契約内容変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "010", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0010", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1240", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1010", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201810), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 10, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1010), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khkaigomaebaraitkhenkou", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0110";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo11);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo11);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000116", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0110", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "契約取消", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "011", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0011", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1241", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1011", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201811), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1011), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khkeiyakutorikesi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI;
        String pHenkousikibetukey = "0130";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo13);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo13);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000138", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0130", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "円建変更取消", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "013", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0013", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1243", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1013", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201801), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 13, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1013), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khkanikeiyakunaiyouteisei", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YYKIDOUUKE;
        String pHenkousikibetukey = "0140";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo14);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo14);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }
    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.HRIHENNONE;
        String pHenkousikibetukey = "0150";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo15);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo15);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YYKIDOUTORIKESI;
        String pHenkousikibetukey = "0160";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo16);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo16);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0170";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo17);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo17);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000172", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0170", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "脱退（払込方法変更）", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "017", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0017", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1247", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1017", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201805), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 17, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1017), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khonlinedattai", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }
    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0180";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo18);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo18);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000183", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0180", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "脱退（契約変更）", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "018", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0018", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1248", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1018", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201806), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 18, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1018), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khonlinedattai", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }
    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0190";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo19);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo19);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000194", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0190", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "脱退（解約等）", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "019", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0019", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1249", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1019", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201807), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 19, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1019), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khonlinedattai", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0200";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo20);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo20);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000208", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0200", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "脱退（その他）", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "020", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0020", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1250", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1020", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 20, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1020), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khonlinedattai", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0210";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo21);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo21);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000219", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0210", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "脱退（払込方法変更）", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "021", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0021", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1251", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1021", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201809), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 21, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1021), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khdattai", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0220";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DSHR;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo22);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo22);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000220", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0220", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "配当支払", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "022", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0022", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1252", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201810), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 22, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1022), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khdshr", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0230";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo23);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo23);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI;
        String pHenkousikibetukey = "0240";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DSEISAN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo24);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo24);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0250";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo25);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo25);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "99806001526", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0250", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険料払込方法変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "025", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0025", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd2(), "", "代理店コード２");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd2(), "", "募集人コード２");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1255", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1025", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201802), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 25, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1016), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0260";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DSEISAN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo26);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo26);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0270";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo27);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo27);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0280";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_DSEISAN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo28);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo28);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }
    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;
        String pHenkousikibetukey = "0290";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo29);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo29);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(),
            "円建変更（目標到達による変更）", "生保Ｗｅｂ異動区分内容１");

    }
    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;
        String pHenkousikibetukey = "0300";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo30);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo30);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(),
            "円建変更（請求による変更）", "生保Ｗｅｂ異動区分内容１");

    }
    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0310";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo31);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo31);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI;
        String pHenkousikibetukey = "0320";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo32);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo32);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(),
            "積立金移転取消", "生保Ｗｅｂ異動区分内容１");

    }
    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0330";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo33);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo33);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.TMTTKNHANEI_ITEN;
        String pHenkousikibetukey = "0340";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo34);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo34);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(),
            "積立金移転", "生保Ｗｅｂ異動区分内容１");

    }
    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0350";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo35);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo35);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.JIDOUSOUKINSEISANZUMI;
        String pHenkousikibetukey = "0360";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo36);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo36);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(),
            "解約消滅", "生保Ｗｅｂ異動区分内容１");

    }
    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0370";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo37);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo37);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }
    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YYKIDOUUKE;
        String pHenkousikibetukey = "0380";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo38);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo38);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }
    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.HRIHENNONE;
        String pHenkousikibetukey = "0390";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo39);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo39);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }
    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.YYKIDOUTORIKESI;
        String pHenkousikibetukey = "0400";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo40);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo40);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.DATTAIUKE;
        String pHenkousikibetukey = "0410";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo41);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo41);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "99806026310", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0410", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険料払込方法変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "041", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0041", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd2(), "", "代理店コード２");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd2(), "", "募集人コード２");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1246", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1041", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201804), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 33, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1016), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khyoyakuidoukousin", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {

        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.BLNK;
        String pHenkousikibetukey = "0420";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo42);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo42);

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();
        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "99806026321", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0420", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "契約内容変更", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "042", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0042", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd2(), "", "代理店コード２");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd2(), "", "募集人コード２");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1246", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1042", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201804), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 33, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1016), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khkzktrkkykdrhnk", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.SBKYUUHUSHR;
        String pHenkousikibetukey = "0081";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0081", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_A45() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.MENSEKI;
        String pHenkousikibetukey = "0082";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0082", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_A46() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.SBKAIJO;
        String pHenkousikibetukey = "0083";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0083", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_A47() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.SBMUKOU;
        String pHenkousikibetukey = "0084";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0084", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testExec_A48() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.KOUDOSYOUGAI;
        String pHenkousikibetukey = "0085";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0085", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testExec_A49() {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.KAIJO;
        String pHenkousikibetukey = "0086";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exStringEquals(seihowebIdouRireki.get(0).getSyono(), "17806000080", "証券番号");
        exStringEquals(seihowebIdouRireki.get(0).getHenkousikibetukey(), "0086", "変更識別キー");
        exDateYMEquals(seihowebIdouRireki.get(0).getIdouhasseiym(), BizDateYM.valueOf(201811), "異動発生年月");
        exDateEquals(seihowebIdouRireki.get(0).getIdouhasseiymd(), BizDate.valueOf(20181102), "異動発生年月日");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou1(), "保険金等支払消滅", "生保Ｗｅｂ異動区分内容１");
        exStringEquals(seihowebIdouRireki.get(0).getSeihowebidoukbnnaiyou2(), "", "生保Ｗｅｂ異動区分内容２");
        exStringEquals(seihowebIdouRireki.get(0).getDairitencd1(), "008", "代理店コード１");
        exStringEquals(seihowebIdouRireki.get(0).getBosyuucd1(), "0008", "募集人コード１");
        exClassificationEquals(seihowebIdouRireki.get(0).getDrtenbunumu(), C_UmuKbn.NONE, "代理店分担有無");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(seihowebIdouRireki.get(0).getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exClassificationEquals(seihowebIdouRireki.get(0).getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");
        exDateYMEquals(seihowebIdouRireki.get(0).getBosyuuym(), BizDateYM.valueOf(201806), "募集年月");
        exStringEquals(seihowebIdouRireki.get(0).getCifcd(), "1238", "ＣＩＦコード");
        exStringEquals(seihowebIdouRireki.get(0).getBankcd(), "1008", "銀行コード");
        exDateYMEquals(seihowebIdouRireki.get(0).getJkipjytym(), BizDateYM.valueOf(201808), "次回Ｐ充当年月");
        exStringEquals(seihowebIdouRireki.get(0).getKyknmkj(), "契約者名漢字", "契約者名（漢字）");
        exStringEquals(seihowebIdouRireki.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(seihowebIdouRireki.get(0).getSyouhnsdno(), 8, "商品世代番号");
        exDateEquals(seihowebIdouRireki.get(0).getKykymd(), BizDate.valueOf(20170424), "契約日");
        exBizCalcbleEquals(seihowebIdouRireki.get(0).getHokenryou(), BizCurrency.valueOf(1008), "保険料");
        exClassificationEquals(seihowebIdouRireki.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "業務用更新機能ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(seihowebIdouRireki.get(0).getGyoumuKousinTime(), "20170406161709098", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testExec_A50 () {
        BizDate pIdouhasseiymd = BizDate.valueOf(20181102);
        C_SyoriKbn pSyoriKbn = C_SyoriKbn.JIKOU ;
        String pHenkousikibetukey = "0087";
        String pGyoumuKousinKinou = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String pGyoumuKousinsyaId = "Junit";
        String pGyoumuKousinTime = "20170406161709098";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);

        MockObjectManager.initialize();
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;

        editSeihowebIdouRirekiTbl.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        List<IT_SeihowebIdouRireki> seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRirekis();

        exNumericEquals(seihowebIdouRireki.size(), 0, "生保Ｗｅｂ用異動履歴テーブルのサイズ");
    }
}