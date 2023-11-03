package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_MassitknKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyorisimetknKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * MosnaiCheckクラスのメソッド {@link MosnaiCheck#exec(MosnaiCheckParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class MosnaiCheckTest_exec{

    private MosnaiCheck mosnaiCheck;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(JidouSetSyokika.class).to(JidouSetSyokikaMockForSinkeiyaku.class);
                bind(SetKisoKoumoku.class).to(SetKisoKoumokuMockForSinkeiyaku.class);
                bind(CheckTblMosDairiten.class).to(CheckTblMosDairitenMockForSinkeiyaku.class);
                bind(CheckTblMosKihon.class).to(CheckTblMosKihonMockForSinkeiyaku.class);
                bind(CheckTblMosSyouhin.class).to(CheckTblMosSyouhinMockForSinkeiyaku.class);
                bind(CheckTblUketorinin.class).to(CheckTblUketorininMockForSinkeiyaku.class);
                bind(CheckSentakujyouhou.class).to(CheckSentakujyouhouMockForSinkeiyaku.class);
                bind(CheckFatca.class).to(CheckFatcaMockForSinkeiyaku.class);
                bind(CheckTblKouzaJyouhou.class).to(CheckTblKouzaJyouhouMockForSinkeiyaku.class);
                bind(CheckTblKokutisyo.class).to(CheckTblKokutisyoMockForSinkeiyaku.class);
                bind(SetSP.class).to(SetSPMockForSinkeiyaku.class);
                bind(CheckSP.class).to(CheckSPMockForSinkeiyaku.class);
                bind(CheckSkTuusan.class).to(CheckSkTuusanMockForSinkeiyaku.class);
                bind(HanteiKykKakunin.class).to(HanteiKykKakuninMockForSinkeiyaku.class);
                bind(HanteiLINC.class).to(HanteiLINCMockForSinkeiyaku.class);
                bind(HanteiLINCjyusinkekka.class).to(HanteiLINCjyusinkekkaMockForSinkeiyaku.class);
                bind(SateiKetteiJissiRuleHantei.class).to(SateiKetteiJissiRuleHanteiMockForSinkeiyaku.class);
                bind(CheckHubiKanri.class).to(CheckHubiKanriMockForSinkeiyaku.class);
                bind(CheckSeirituHoryuu.class).to(CheckSeirituHoryuuMockForSinkeiyaku.class);
                bind(Seiritu.class).to(SeirituMockForSinkeiyaku.class);
                bind(EditPrintFile.class).to(EditPrintFileMockForSinkeiyaku.class);
                bind(HanteiHituyouSyorui.class).to(HanteiHituyouSyoruiMockForSinkeiyaku.class);
                bind(Kettei.class).to(KetteiMockForSinkeiyaku.class);
                bind(SetSateijt.class).to(SetSateijtMockForSinkeiyaku.class);
                bind(CheckTblNyuukinHenkin.class).to(CheckTblNyuukinHenkinMockForSinkeiyaku.class);
                bind(CheckYakkanJyuryouHouhou.class).to(CheckYakkanJyuryouHouhouMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(CheckTblCreditCardInfo.class).to(CheckTblCreditCardInfoMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        JidouSetSyokikaMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        SetKisoKoumokuMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblMosDairitenMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblMosKihonMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblUketorininMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckSentakujyouhouMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckFatcaMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblKouzaJyouhouMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblKokutisyoMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        SetSPMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckSPMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckSkTuusanMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        HanteiKykKakuninMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        HanteiLINCMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckHubiKanriMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckSeirituHoryuuMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        SeirituMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        EditPrintFileMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        HanteiHituyouSyoruiMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        KetteiMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        SetSateijtMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblNyuukinHenkinMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
        CheckTblCreditCardInfoMockForSinkeiyaku.caller = MosnaiCheckTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        JidouSetSyokikaMockForSinkeiyaku.caller = null;
        SetKisoKoumokuMockForSinkeiyaku.caller = null;
        CheckTblMosDairitenMockForSinkeiyaku.caller = null;
        CheckTblMosKihonMockForSinkeiyaku.caller = null;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = null;
        CheckTblUketorininMockForSinkeiyaku.caller = null;
        CheckSentakujyouhouMockForSinkeiyaku.caller = null;
        CheckFatcaMockForSinkeiyaku.caller = null;
        CheckTblKouzaJyouhouMockForSinkeiyaku.caller = null;
        CheckTblKokutisyoMockForSinkeiyaku.caller = null;
        SetSPMockForSinkeiyaku.caller = null;
        CheckSPMockForSinkeiyaku.caller = null;
        CheckSkTuusanMockForSinkeiyaku.caller = null;
        HanteiKykKakuninMockForSinkeiyaku.caller = null;
        HanteiLINCMockForSinkeiyaku.caller = null;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.caller = null;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.caller = null;
        CheckHubiKanriMockForSinkeiyaku.caller = null;
        CheckSeirituHoryuuMockForSinkeiyaku.caller = null;
        SeirituMockForSinkeiyaku.caller = null;
        EditPrintFileMockForSinkeiyaku.caller = null;
        HanteiHituyouSyoruiMockForSinkeiyaku.caller = null;
        KetteiMockForSinkeiyaku.caller = null;
        SetSateijtMockForSinkeiyaku.caller = null;
        CheckTblNyuukinHenkinMockForSinkeiyaku.caller = null;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.caller =  null;
        CheckTblCreditCardInfoMockForSinkeiyaku.caller =  null;

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = null;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = null;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = null;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = null;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = null;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = null;
        SetSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = null;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = null;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = null;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = null;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = null;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = null;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = null;
        SeirituMockForSinkeiyaku.SYORIPTN = null;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = null;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = null;
        KetteiMockForSinkeiyaku.SYORIPTN = null;
        SetSateijtMockForSinkeiyaku.SYORIPTN = null;
        CheckTblNyuukinHenkinMockForSinkeiyaku.SYORIPTN = null;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN = null;
        CheckTblCreditCardInfoMockForSinkeiyaku.SYORIPTN =  null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblNyuukinHenkinMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblCreditCardInfoMockForSinkeiyaku.SYORIPTN =  CheckTblCreditCardInfoMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123458");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        HT_CreditCardJyouhou creditCardJyouhou = new HT_CreditCardJyouhou();

        creditCardJyouhou.getKousinsyaId();

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getListHubiMsg().get(0).getMosno(), "100000001", "申込番号");
        exNumericEquals(mosnaiCheckParam.getListHubiMsg().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getListHubiMsg().get(1).getMosno(), "100000002", "申込番号");
        exNumericEquals(mosnaiCheckParam.getListHubiMsg().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblNyuukinHenkinMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123466");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.NONE);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20120731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.ARI);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getListHubiMsg().get(0).getMosno(), "100000001", "申込番号");
        exNumericEquals(mosnaiCheckParam.getListHubiMsg().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getListHubiMsg().get(1).getMosno(), "100000002", "申込番号");
        exNumericEquals(mosnaiCheckParam.getListHubiMsg().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123474");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.HORYU);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123474");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("890123474");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        syoriCTL.setHubiMsgs(hubiMsgLst);

        syoriCTL.setMosKihon(null);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setListHubiMsg(null);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.ARI);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().size(), 0, "不備メッセージテーブルエンティティリスト");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblNyuukinHenkinMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123482");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.HORYU);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123482");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("890123482");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        syoriCTL.setHubiMsgs(hubiMsgLst);

        syoriCTL.setMosKihon(null);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.ARI);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setListHubiMsg(null);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().size(), 0, "不備メッセージテーブルエンティティリスト");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.HUYOU);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123490");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20150731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.ARI);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123508");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETHORYU_KAKUNIN);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.ARI);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123516");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETHORYU_KAKUNIN);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.ARI);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123490");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_UW);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.ARI);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123490");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_MD);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.ARI);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123540");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2B);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.HJY);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.ARI);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123557");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.KKT);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.SYOURYAKU);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123565");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.BLNK);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.ARI);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123573");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.HJY);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.ARI);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123581");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(null);
        mosKihon.setSntkhoukbn(C_SntkhouKbn.KKT);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.ARI);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.NONE);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123599");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setListHubiMsg(null);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.ARI);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true , "申込番号");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123607");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono(null);
        mosKihon.setMossakuseiymd(BizDate.valueOf("20120730"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.BLNK);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000001");
        hubiMsg1.setRenno(1);
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000002");
        hubiMsg2.setRenno(2);
        hubiMsgLst.add(hubiMsg1);
        hubiMsgLst.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true, "不備メッセージテーブルエンティティリスト");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;

        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        KetteiMockForSinkeiyaku.SYORIPTN = KetteiMockForSinkeiyaku.TESTPATTERN1;
        SetSateijtMockForSinkeiyaku.SYORIPTN = SetSateijtMockForSinkeiyaku.TESTPATTERN1;
        CheckTblNyuukinHenkinMockForSinkeiyaku.SYORIPTN = CheckTblNyuukinHenkinMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123615");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.MOSTENKEN_ZUMI);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);

        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();

        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123615");
        hubiMsg1.setRenno(1);
        hubiMsg1.setHubimsg("不備メッセージテスト１２３");
        hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
        hubiMsg1.setGyoumuKousinsyaId("usertest");
        hubiMsg1.setGyoumuKousinTime("20160519121224999");

        hubiMsgLst.add(hubiMsg1);

        syoriCTL.setHubiMsgs(hubiMsgLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg01 = new HT_HubiMsg();
        hubiMsg01.setMosno("890123615");
        hubiMsg01.setRenno(1);
        hubiMsg01.setHubimsg("不備メッセージテスト４５５");
        hubiMsg01.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
        hubiMsg01.setGyoumuKousinsyaId("administrator");
        hubiMsg01.setGyoumuKousinTime("20160520181830999");

        HT_HubiMsg hubiMsg02 = new HT_HubiMsg();
        hubiMsg02.setMosno("890123615");
        hubiMsg02.setRenno(2);
        hubiMsg02.setHubimsg("不備メッセージテスト９９９");
        hubiMsg02.setHubisyubetukbn(C_HubisyubetuKbn.KIHON_HUBI);
        hubiMsg02.setGyoumuKousinsyaId("administrator");
        hubiMsg02.setGyoumuKousinTime("20160520181830999");

        hubiMsgList.add(hubiMsg01);
        hubiMsgList.add(hubiMsg02);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubimsg(), "不備メッセージテスト４５５", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubimsg(), "不備メッセージテスト９９９", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {


        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        KetteiMockForSinkeiyaku.SYORIPTN = KetteiMockForSinkeiyaku.TESTPATTERN1;
        SetSateijtMockForSinkeiyaku.SYORIPTN = SetSateijtMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);


        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");
        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123615");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);

        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);

        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.MOSTENKEN_ZUMI);

        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);

        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);

        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);

        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);

        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);

        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);

        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);

        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);


        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();

        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123615");
        hubiMsg1.setRenno(1);
        hubiMsg1.setHubimsg("不備メッセージテスト１２３");

        hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
        hubiMsg1.setGyoumuKousinsyaId("usertest");
        hubiMsg1.setGyoumuKousinTime("20160519121224999");

        hubiMsgLst.add(hubiMsg1);

        syoriCTL.setHubiMsgs(hubiMsgLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);


        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg01 = new HT_HubiMsg();
        hubiMsg01.setMosno("890123615");
        hubiMsg01.setRenno(1);
        hubiMsg01.setHubimsg("不備メッセージテスト４５５");

        hubiMsg01.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
        hubiMsg01.setGyoumuKousinsyaId("administrator");
        hubiMsg01.setGyoumuKousinTime("20160520181830999");

        HT_HubiMsg hubiMsg02 = new HT_HubiMsg();
        hubiMsg02.setMosno("890123615");
        hubiMsg02.setRenno(2);
        hubiMsg02.setHubimsg("不備メッセージテスト９９９");

        hubiMsg02.setHubisyubetukbn(C_HubisyubetuKbn.KIHON_HUBI);
        hubiMsg02.setGyoumuKousinsyaId("administrator");
        hubiMsg02.setGyoumuKousinTime("20160520181830999");

        hubiMsgList.add(hubiMsg01);
        hubiMsgList.add(hubiMsg02);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubimsg(), "不備メッセージテスト４５５", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubimsg(), "不備メッセージテスト９９９", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {


        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        KetteiMockForSinkeiyaku.SYORIPTN = KetteiMockForSinkeiyaku.TESTPATTERN1;
        SetSateijtMockForSinkeiyaku.SYORIPTN = SetSateijtMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);


        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");
        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123615");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);

        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);

        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.MOSTENKEN_ZUMI);

        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);

        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);

        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);

        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);

        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);

        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);

        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);

        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");


        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();

        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123615");
        hubiMsg1.setRenno(1);
        hubiMsg1.setHubimsg("不備メッセージテスト１２３");

        hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
        hubiMsg1.setGyoumuKousinsyaId("usertest");
        hubiMsg1.setGyoumuKousinTime("20160519121224999");

        hubiMsgLst.add(hubiMsg1);

        syoriCTL.setHubiMsgs(hubiMsgLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);


        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg01 = new HT_HubiMsg();
        hubiMsg01.setMosno("890123615");
        hubiMsg01.setRenno(1);
        hubiMsg01.setHubimsg("不備メッセージテスト４５５");

        hubiMsg01.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
        hubiMsg01.setGyoumuKousinsyaId("administrator");
        hubiMsg01.setGyoumuKousinTime("20160520181830999");

        HT_HubiMsg hubiMsg02 = new HT_HubiMsg();
        hubiMsg02.setMosno("890123615");
        hubiMsg02.setRenno(2);
        hubiMsg02.setHubimsg("不備メッセージテスト９９９");

        hubiMsg02.setHubisyubetukbn(C_HubisyubetuKbn.KIHON_HUBI);
        hubiMsg02.setGyoumuKousinsyaId("administrator");
        hubiMsg02.setGyoumuKousinTime("20160520181830999");

        hubiMsgList.add(hubiMsg01);
        hubiMsgList.add(hubiMsg02);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubimsg(), "不備メッセージテスト４５５", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubimsg(), "不備メッセージテスト９９９", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.WARNING);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, MessageId.WHC1014 + " " + MessageUtil.getMessage(MessageId.WHC1014));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "890123615", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, C_MsgKbn.WARNING);
        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANHUKA, "ＳＰ計算可否区分");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {


        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        KetteiMockForSinkeiyaku.SYORIPTN = KetteiMockForSinkeiyaku.TESTPATTERN1;
        SetSateijtMockForSinkeiyaku.SYORIPTN = SetSateijtMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);


        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");
        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123615");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);

        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);

        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.MOSTENKEN_ZUMI);

        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);

        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);

        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);

        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);

        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);

        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);

        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);

        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);


        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();

        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123615");
        hubiMsg1.setRenno(1);
        hubiMsg1.setHubimsg("不備メッセージテスト１２３");

        hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
        hubiMsg1.setGyoumuKousinsyaId("usertest");
        hubiMsg1.setGyoumuKousinTime("20160519121224999");

        hubiMsgLst.add(hubiMsg1);

        syoriCTL.setHubiMsgs(hubiMsgLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);


        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg01 = new HT_HubiMsg();
        hubiMsg01.setMosno("890123615");
        hubiMsg01.setRenno(1);
        hubiMsg01.setHubimsg("不備メッセージテスト４５５");

        hubiMsg01.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
        hubiMsg01.setGyoumuKousinsyaId("administrator");
        hubiMsg01.setGyoumuKousinTime("20160520181830999");

        HT_HubiMsg hubiMsg02 = new HT_HubiMsg();
        hubiMsg02.setMosno("890123615");
        hubiMsg02.setRenno(2);
        hubiMsg02.setHubimsg("不備メッセージテスト９９９");

        hubiMsg02.setHubisyubetukbn(C_HubisyubetuKbn.KIHON_HUBI);
        hubiMsg02.setGyoumuKousinsyaId("administrator");
        hubiMsg02.setGyoumuKousinTime("20160520181830999");

        hubiMsgList.add(hubiMsg01);
        hubiMsgList.add(hubiMsg02);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubimsg(), "不備メッセージテスト４５５", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubimsg(), "不備メッセージテスト９９９", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {


        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        SeirituMockForSinkeiyaku.SYORIPTN = SeirituMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        KetteiMockForSinkeiyaku.SYORIPTN = KetteiMockForSinkeiyaku.TESTPATTERN1;
        SetSateijtMockForSinkeiyaku.SYORIPTN = SetSateijtMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);


        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");
        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("890123615");
        syoriCTL.setSyono("10000000001");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.ARI);
        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL.setHjynrkumu(C_UmuKbn.ARI);

        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.NONE);

        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.MOSTENKEN_ZUMI);

        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);

        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);

        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);

        syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);

        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);

        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);

        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);

        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);


        List<HT_HubiMsg> hubiMsgLst = new ArrayList<>();

        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("890123615");
        hubiMsg1.setRenno(1);
        hubiMsg1.setHubimsg("不備メッセージテスト１２３");

        hubiMsg1.setHubisyubetukbn(C_HubisyubetuKbn.KETHORYU_HUBI);
        hubiMsg1.setGyoumuKousinsyaId("usertest");
        hubiMsg1.setGyoumuKousinTime("20160519121224999");

        hubiMsgLst.add(hubiMsg1);

        syoriCTL.setHubiMsgs(hubiMsgLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);


        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg01 = new HT_HubiMsg();
        hubiMsg01.setMosno("890123615");
        hubiMsg01.setRenno(1);
        hubiMsg01.setHubimsg("不備メッセージテスト４５５");

        hubiMsg01.setHubisyubetukbn(C_HubisyubetuKbn.SRHORYU_HUBI);
        hubiMsg01.setGyoumuKousinsyaId("administrator");
        hubiMsg01.setGyoumuKousinTime("20160520181830999");

        HT_HubiMsg hubiMsg02 = new HT_HubiMsg();
        hubiMsg02.setMosno("890123615");
        hubiMsg02.setRenno(2);
        hubiMsg02.setHubimsg("不備メッセージテスト９９９");

        hubiMsg02.setHubisyubetukbn(C_HubisyubetuKbn.KIHON_HUBI);
        hubiMsg02.setGyoumuKousinsyaId("administrator");
        hubiMsg02.setGyoumuKousinTime("20160520181830999");

        hubiMsgList.add(hubiMsg01);
        hubiMsgList.add(hubiMsg02);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getRenno(), 1, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubimsg(), "不備メッセージテスト４５５", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(0).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getMosno(), "890123615", "申込番号");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getRenno(), 2, "連番");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubimsg(), "不備メッセージテスト９９９", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinsyaId(), "administrator", "業務用更新者ＩＤ");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs().get(1).getGyoumuKousinTime(), "20160520181830999", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getGyoumuKousinsyaId(), "2", "業務用更新者ＩＤ");
        assertNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("860000058");
        syoriCTL.setSyono("17806000208");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        List<HT_MosSyouhn> htmsyLst = new ArrayList<>();
        HT_MosSyouhn htmsy = new  HT_MosSyouhn();
        htmsy.setMosno("860000017");
        htmsy.setSyouhncd("ﾕﾍ");
        htmsy.setSyouhnsdno(1);
        htmsy.setRyouritusdno("L");
        htmsy.setSyutkkbn(C_SyutkKbn.SYU);
        htmsyLst.add(htmsy);
        syoriCTL.setMosSyouhns(htmsyLst);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        mosKihon.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setListHubiMsg(null);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.ARI);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true , "申込番号");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckFatcaMockForSinkeiyaku.SYORIPTN = CheckFatcaMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKouzaJyouhouMockForSinkeiyaku.SYORIPTN = CheckTblKouzaJyouhouMockForSinkeiyaku.TESTPATTERN1;
        CheckTblKokutisyoMockForSinkeiyaku.SYORIPTN = CheckTblKokutisyoMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HanteiKykKakuninMockForSinkeiyaku.SYORIPTN = HanteiKykKakuninMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCMockForSinkeiyaku.SYORIPTN = HanteiLINCMockForSinkeiyaku.TESTPATTERN1;
        HanteiLINCjyusinkekkaMockForSinkeiyaku.SYORIPTN = HanteiLINCjyusinkekkaMockForSinkeiyaku.TESTPATTERN1;
        SateiKetteiJissiRuleHanteiMockForSinkeiyaku.SYORIPTN = SateiKetteiJissiRuleHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckHubiKanriMockForSinkeiyaku.SYORIPTN = CheckHubiKanriMockForSinkeiyaku.TESTPATTERN1;
        CheckSeirituHoryuuMockForSinkeiyaku.SYORIPTN = CheckSeirituHoryuuMockForSinkeiyaku.TESTPATTERN1;
        EditPrintFileMockForSinkeiyaku.SYORIPTN = EditPrintFileMockForSinkeiyaku.TESTPATTERN1;
        HanteiHituyouSyoruiMockForSinkeiyaku.SYORIPTN = HanteiHituyouSyoruiMockForSinkeiyaku.TESTPATTERN1;
        CheckYakkanJyuryouHouhouMockForSinkeiyaku.SYORIPTN =  CheckYakkanJyuryouHouhouMockForSinkeiyaku.TESTPATTERN1;

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKosTime("20150806");
        mosnaiCheckParam.setKosID("2");

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("860000041");
        syoriCTL.setSyono("17806000264");
        syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL.setKznrkumu(C_UmuKbn.NONE);
        syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL.setHjynrkumu(C_UmuKbn.NONE);
        syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
        syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIZUMI);
        syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL.setJimusrhkbn(C_JimusrhKbn.NONE);
        syoriCTL.setSyssrhkbn(C_SyssrhKbn.NONE);
        syoriCTL.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL.setGyoumuKousinTime("20150706");
        syoriCTL.setGyoumuKousinsyaId("1");
        syoriCTL.setHubiMsgs(null);

        HT_MosKihon mosKihon = syoriCTL.createMosKihon();
        mosKihon.setDoujikaiyakusyono("10000000001");
        mosKihon.setMossakuseiymd(BizDate.valueOf("20110731"));
        mosKihon.setSntkhoukbn(C_SntkhouKbn.NONE);
        mosKihon.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        mosKihon.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon.setGyoumuKousinTime("20150706");
        mosKihon.setGyoumuKousinsyaId("1");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setListHubiMsg(null);

        HT_Tokunin tokunin = syoriCTL.createTokunin();
        tokunin.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        tokunin.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        tokunin.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        tokunin.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        tokunin.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        tokunin.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
        tokunin.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        tokunin.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
        tokunin.setSyorisimetknkbn(C_SyorisimetknKbn.NONE);
        tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
        tokunin.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
        tokunin.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        tokunin.setMassitknkbn(C_MassitknKbn.NONE);
        tokunin.setSonotatknkbn(C_SonotaTokuninKbn.ARI);

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinTime(), "20150806", "業務用更新時間");
        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getGyoumuKousinsyaId(), "2", "業業務用更新者ＩＤ");
        exBooleanEquals(mosnaiCheckParam.getDataSyoriControl().getHubiMsgs() == null, true , "申込番号");
        assertNotNull("特認テーブル", mosnaiCheckParam.getDataSyoriControl().getTokunin());
    }

}
