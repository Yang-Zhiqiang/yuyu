package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.HenkanTuukaMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tksytratkikjn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 最低Ｐチェッククラスのメソッド {@link CheckSaiteiP#exec(MosnaiCheckParam,HT_MosSyouhn,BizCurrency,C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSaiteiPTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_最低Ｐチェック";
    private final static String sheetName = "INデータ";

    private CheckSaiteiP checkSaiteiP;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckTuusan.class).to(CheckTuusanMockForSinkeiyaku.class);
                bind(HenkanTuuka.class).to(HenkanTuukaMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
            }
        });
        checkSaiteiP = SWAKInjector.getInstance(CheckSaiteiP.class);
    }

    @BeforeClass
    public static void testInit(){
        CheckTuusanMockForSinkeiyaku.caller = CheckSaiteiPTest_getSaiteiP.class;
        SetHubiMsgMockForSinkeiyaku.caller = CheckSaiteiPTest_getSaiteiP.class;
        HenkanTuukaMockForSinkeiyaku.caller = CheckSaiteiPTest_getSaiteiP.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.caller = null;
        HenkanTuukaMockForSinkeiyaku.caller = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSaiteiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkSaiteiP());
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiP());

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112246");
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        BizCurrency syutkp = BizCurrency.valueOf( 500, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.BLNK);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("代理店");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN18;
        MockObjectManager.initialize();

        checkSaiteiP.exec(mosnaiCheckParam, mosSyouhn, syouhnZokusei , syutkp, tuukasyu);

        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), "", "メッセージ文言上段");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "最低保険料未達　払込金額は1,001円以上にしてください", "メッセージ文言下段");
        exClassificationEquals((C_SekmossakuseiErroutKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2),C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 3, C_Channelcd.TIGIN);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 4, C_PtratkituukasiteiKbn.SITEITUUKA);

        exBooleanEquals(checkSaiteiP.getChkhubigaitouflg(), true, "チェック不備該当フラグ");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112303");
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        BizCurrency syutkp = BizCurrency.valueOf( 500, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        checkSaiteiP.exec(mosnaiCheckParam, mosSyouhn, syouhnZokusei, syutkp, tuukasyu);

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "EHC1046 保険料が1,001円未満です。保険料を確認ください。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");

        exClassificationEquals(mosnaiCheckParam.getSaiteiPChkErrUmu(), C_UmuKbn.ARI, "最低保険料チェックエラー有無");

        exBooleanEquals(checkSaiteiP.getChkhubigaitouflg(), true, "チェック不備該当フラグ");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112311");
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕA");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        BizCurrency syutkp = BizCurrency.valueOf( 500, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        checkSaiteiP.exec(mosnaiCheckParam, mosSyouhn, syouhnZokusei, syutkp, tuukasyu);

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "EHC1046 保険料が1,001円未満です。保険料を確認ください。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");
        exClassificationEquals(mosnaiCheckParam.getSaiteiPChkErrUmu(), C_UmuKbn.ARI, "最低保険料チェックエラー有無");

        exBooleanEquals(checkSaiteiP.getChkhubigaitouflg(), true, "チェック不備該当フラグ");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112329");
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾂ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        BizCurrency syutkp = BizCurrency.valueOf( 506, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        checkSaiteiP.exec(mosnaiCheckParam, mosSyouhn, syouhnZokusei, syutkp, tuukasyu);

        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");

        exBooleanEquals(checkSaiteiP.getChkhubigaitouflg(), false, "チェック不備該当フラグ");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112337");
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾃ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        BizCurrency syutkp = BizCurrency.valueOf( 500, BizCurrencyTypes.YEN);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        checkSaiteiP.exec(mosnaiCheckParam, mosSyouhn, syouhnZokusei, syutkp, tuukasyu);

        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");

        exBooleanEquals(checkSaiteiP.getChkhubigaitouflg(), false, "チェック不備該当フラグ");
    }
}
