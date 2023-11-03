package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzdairiten.BzChkAgYuukou;
import yuyu.common.biz.bzdairiten.BzChkAgYuukouMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzChkBsYuukou;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouHengaku;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouHengakuMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyoMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikan;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikanMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrkno;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrknoMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouin;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouinMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetBsInfoMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetBuntanInfo;
import yuyu.common.biz.bzdairiten.BzGetBuntanInfoMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetDairitenItakuSyouhn;
import yuyu.common.biz.bzdairiten.BzGetDairitenItakuSyouhnMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcdMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhou;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhouMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfoMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 申込代理店TBLチェックのメソッド {@link CheckTblMosDairiten#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosDairitenTest_exec {

    @Inject
    private CheckTblMosDairiten checkTblMosDairiten;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込代理店TBLチェック";

    private final static String sheetName = "INデータ";

    @Before
    public void Before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(ConvertChannelcd.class).to(ConvertChannelcdMockForSinkeiyaku.class);
                bind(BzGetBsInfoKouin.class).to(BzGetBsInfoKouinMockForSinkeiyaku.class);
                bind(BzGetBsInfoBstrkno.class).to(BzGetBsInfoBstrknoMockForSinkeiyaku.class);
                bind(BzGetBsInfo.class).to(BzGetBsInfoMockForSinkeiyaku.class);
                bind(BzChkBsYuukou.class).to(BzChkBsYuukouMockForSinkeiyaku.class);
                bind(BzChkBsYuukouHengaku.class).to(BzChkBsYuukouHengakuMockForSinkeiyaku.class);
                bind(BzChkAgYuukou.class).to(BzChkAgYuukouMockForSinkeiyaku.class);
                bind(BzGetAgInfoKinyuuKikan.class).to(BzGetAgInfoKinyuuKikanMockForSinkeiyaku.class);
                bind(BzGetAgInfo.class).to(BzGetAgInfoMockForSinkeiyaku.class);
                bind(BzGetAgInfoJimusyo.class).to(BzGetAgInfoJimusyoMockForSinkeiyaku.class);
                bind(BzGetBuntanInfo.class).to(BzGetBuntanInfoMockForSinkeiyaku.class);
                bind(GetSkChannelInfo.class).to(GetSkChannelInfoMockForSinkeiyaku.class);
                bind(GetDairitenKobetuJyouhou.class).to(GetDairitenKobetuJyouhouMockForSinkeiyaku.class);
                bind(BzGetDairitenItakuSyouhn.class).to(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class);
                bind(SetKisoKoumoku.class).to(SetKisoKoumokuMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosDairitenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @BeforeClass
    public static void testInit() {

        ConvertChannelcdMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetBsInfoKouinMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetBsInfoBstrknoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetBsInfoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzChkBsYuukouMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzChkBsYuukouHengakuMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzChkAgYuukouMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetAgInfoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetAgInfoJimusyoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetBuntanInfoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        GetSkChannelInfoMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
        SetKisoKoumokuMockForSinkeiyaku.caller = CheckTblMosDairitenTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.caller = null;
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = null;
        BzGetBsInfoKouinMockForSinkeiyaku.caller = null;
        BzGetBsInfoKouinMockForSinkeiyaku.SYORIPTN = null;
        BzGetBsInfoBstrknoMockForSinkeiyaku.caller = null;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = null;
        BzGetBsInfoMockForSinkeiyaku.caller = null;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = null;
        BzChkBsYuukouMockForSinkeiyaku.caller = null;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = null;
        BzChkBsYuukouHengakuMockForSinkeiyaku.caller = null;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = null;
        BzChkAgYuukouMockForSinkeiyaku.caller = null;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = null;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.caller = null;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = null;
        BzGetAgInfoMockForSinkeiyaku.caller = null;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = null;
        BzGetAgInfoJimusyoMockForSinkeiyaku.caller = null;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = null;
        BzGetBuntanInfoMockForSinkeiyaku.caller = null;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = null;
        GetSkChannelInfoMockForSinkeiyaku.caller = null;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = null;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.caller = null;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = null;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.caller = null;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = null;
        SetKisoKoumokuMockForSinkeiyaku.caller = null;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = null;
    }
    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("10001");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(mosnaiCheckParam.getKiteiCheckChannelCd(), C_Channelcd.TIGIN, "規定チェック用チャネルコード");

        exStringEquals((String)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 1), "10001", "親代理店コード");

        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 1), "M110", "商品コード");
        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 2), "", "予定利率適用分類１");
        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 3), "", "予定利率適用分類２");
        exClassificationEquals((C_SkeijimuKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 4), C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals((C_BoskyuusiRiyuuKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 5), C_BoskyuusiRiyuuKbn.OTHER, "募集休止理由区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.GAISANTIGIN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.GAISANSINKIN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMTB);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.SMTB, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SHOPMDHN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.SHOP, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.MIZUHO);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.MIZUHO, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIGINKOU);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.YUUTYO, "新契約事務区分");
    }


    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIKAISYA);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.NIHONYUUBIN, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIKANPO);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.KANPOSEIMEI, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SONOTAMADOHAN);

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("M110");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "861110005", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "861110005", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店の入力が必要です。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0009", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    public void testExec_A14() {
        try {
            MockObjectManager.initialize();
            BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110013");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20180710111400000");
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
            mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

            checkTblMosDairiten.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(150)
    public void testExec_A15() {
        try {
            MockObjectManager.initialize();
            BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110021");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20180710111400000");
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
            mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

            checkTblMosDairiten.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：861110021", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(2010)
    public void testExec_B1() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2020)
    public void testExec_B2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN8;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860000025", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "2001710", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 0), null, "チャネルコード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoKinyuuKikanMockForSinkeiyaku.class, "exec", 0, 0), "1023", "金融機関コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoKinyuuKikanMockForSinkeiyaku.class, "exec", 0, 1), "223", "金融機関支店コード");

    }

    @Test
    @Transactional
    @TestOrder(2030)
    public void testExec_B3() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860000033", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");

        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 0), C_Channelcd.SINKIN, "チャネルコード");

    }

    @Test
    @Transactional
    @TestOrder(2040)
    public void testExec_B4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");



    }

    @Test
    @Transactional
    @TestOrder(2050)
    public void testExec_B5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2060)
    public void testExec_B6() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000066", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000066", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2070)
    public void testExec_B7() {
        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2080)
    public void testExec_B8() {

        MockObjectManager.initialize();
        BzGetBsInfoKouinMockForSinkeiyaku.SYORIPTN = BzGetBsInfoKouinMockForSinkeiyaku.TESTPATTERN2;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2090)
    public void testExec_B9() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "代理店情報の各種コード入力項目に不整合があります。", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(2100)
    public void testExec_B10() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2110)
    public void testExec_B11() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2120)
    public void testExec_B12() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN3;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


    }

    @Test
    @Transactional
    @TestOrder(2130)
    public void testExec_B13() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000132", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2140)
    public void testExec_B14() {

        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2150)
    public void testExec_B15() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000157", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2160)
    public void testExec_B16() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000165", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2170)
    public void testExec_B17() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000173", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2180)
    public void testExec_B18() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000181", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000181", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "860000181", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2190)
    public void testExec_B19() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN3;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2200)
    public void testExec_B20() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000207", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2210)
    public void testExec_B21() {

        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(2220)
    public void testExec_B22() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000223", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(2230)
    public void testExec_B23() {
        MockObjectManager.initialize();
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000231", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店情報の各種コード入力項目に不整合があります。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0171", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }


    @Test
    @Transactional
    @TestOrder(3010)
    public void testExec_C1() {

        MockObjectManager.initialize();
        BzGetBsInfoKouinMockForSinkeiyaku.SYORIPTN = BzGetBsInfoKouinMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001007");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001007", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "行員コードが存在しません。　行員コード　４００００１０００００７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001007", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), "400001000007", "取扱行員コード");


    }

    @Test
    @Transactional
    @TestOrder(3020)
    public void testExec_C2() {

        MockObjectManager.initialize();
        BzGetBsInfoKouinMockForSinkeiyaku.SYORIPTN = BzGetBsInfoKouinMockForSinkeiyaku.TESTPATTERN2;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001015");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001015", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "123456", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), "400001000006", "取扱行員コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "2101080", "代理店コード");

        exStringEquals((String)MockObjectManager.getArgument(BzGetBsInfoKouinMockForSinkeiyaku.class, "exec", 0, 0), "1023", "金融機関コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetBsInfoKouinMockForSinkeiyaku.class, "exec", 0, 1), "400001000007", "行員コード");

    }


    @Test
    @Transactional
    @TestOrder(3030)
    public void testExec_C3() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001023");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ａ担当者コードエラー", "エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(3040)
    public void testExec_C4() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001031");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｂ担当者コードエラー", "エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(3050)
    public void testExec_C5() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001049");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001049", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人登録番号が存在しません。　募集人登録番号　１００６２０６３０００２３", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1012", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001049", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");

    }

    @Test
    @Transactional
    @TestOrder(3060)
    public void testExec_C6() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001056");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(null);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001056", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");


    }

    @Test
    @Transactional
    @TestOrder(3070)
    public void testExec_C7() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN2;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001064");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001064", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "123456", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "2101080", "代理店コード");

        exStringEquals((String)MockObjectManager.getArgument(BzGetBsInfoBstrknoMockForSinkeiyaku.class, "exec", 0, 0), "1006206300023", "募集人登録番号");

    }

    @Test
    @Transactional
    @TestOrder(3080)
    public void testExec_C8() {

        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001072");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001072", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "個人コードが存在しません。　個人コード　１２３４５６６", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0122", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001072", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");


    }

    @Test
    @Transactional
    @TestOrder(3090)
    public void testExec_C9() {

        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001080");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860001080", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBosyuucd(), "010012", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");

        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "D001", "代理店コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetBsInfoMockForSinkeiyaku.class, "exec", 0, 0), "123456", "募集人コード");

    }


    @Test
    @Transactional
    @TestOrder(4010)
    public void testExec_D1() {
        MockObjectManager.initialize();
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN3;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 1), "M110", "商品コード");
        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 2), "", "予定利率適用分類１");
        exStringEquals((String)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 3), "", "予定利率適用分類２");
        exClassificationEquals((C_SkeijimuKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 4), C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals((C_BoskyuusiRiyuuKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "checkBosyuuKyuusi", 0, 5), C_BoskyuusiRiyuuKbn.OTHER, "募集休止理由区分");
    }


    @Test
    @Transactional
    @TestOrder(4020)
    public void testExec_D2() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002013");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860002013", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人コードが有効ではありません。　募集人コード　０１００１２", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0123", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(4030)
    public void testExec_D3() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002021");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 0), "010012", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20160311"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(4040)
    public void testExec_D4() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002039");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860002039", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人コードが有効ではありません。　募集人コード　０１００１２", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0123", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(4050)
    public void testExec_D5() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002047");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 0), "010012", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20160309"), "基準年月日");

    }

    @Test
    @Transactional
    @TestOrder(4060)
    public void testExec_D6() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002054");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860002054", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人コードが有効ではありません。　募集人コード　０１００１２", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0123", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(4070)
    public void testExec_D7() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002062");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 0), "010012", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180710"), "基準年月日");

    }

    @Test
    @Transactional
    @TestOrder(4080)
    public void testExec_D8() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN3;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002096");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "登録日を確認してください　Ａ担当者登録なし", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(4090)
    public void testExec_D9() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002104");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "登録日を確認してください　Ｂ担当者登録なし", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(4100)
    public void testExec_D10() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002112");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "登録日を確認してください　Ａ担当者登録日　２０１８年０７月１３日", "エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(4110)
    public void testExec_D11() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002120");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "登録日を確認してください　Ｂ担当者登録日　２０１８年０７月１３日", "エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(4120)
    public void testExec_D12() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002138");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(4130)
    public void testExec_D13() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN6;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002146");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ａ担当者登録抹消日　２０１８年０７月１３日", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(4140)
    public void testExec_D14() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN6;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002153");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｂ担当者登録抹消日　２０１８年０７月１３日", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(4150)
    public void testExec_D15() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002161");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");



    }

    @Test
    @Transactional
    @TestOrder(5010)
    public void testExec_E1() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003003");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "変額募集資格が登録されていません　住友生命へ連絡してください", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(5020)
    public void testExec_E2() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003011");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 0), "010013", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180714"), "基準年月日");

    }

    @Test
    @Transactional
    @TestOrder(5030)
    public void testExec_E3() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003029");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860003029", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "入力された募集人は現在、変額保険資格が有効ではありません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1013", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(5040)
    public void testExec_E4() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003037");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 0), "010012", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20160309"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(5050)
    public void testExec_E5() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003045");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860003045", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "入力された募集人は現在、変額保険資格が有効ではありません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1013", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(5060)
    public void testExec_E6() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860003052");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 0), "010012", "募集人コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkBsYuukouHengakuMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180710"), "基準年月日");

    }

    @Test
    @Transactional
    @TestOrder(5070)
    public void testExec_E7() {
        MockObjectManager.initialize();
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002047");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(6010)
    public void testExec_F1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN9;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860004001", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店コードが存在しません。　取扱代理店コード　Ｄ００１", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0120", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "D001", "代理店コード");


    }

    @Test
    @Transactional
    @TestOrder(6020)
    public void testExec_F2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN9;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004019");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ａ担当者組織コードエラー", "エラーメッセージ");


    }

    @Test
    @Transactional
    @TestOrder(6020)
    public void testExec_F3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN9;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004027");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｂ担当者組織コードエラー", "エラーメッセージ");


    }

    @Test
    @Transactional
    @TestOrder(6040)
    public void testExec_F4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN10;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN4;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004035");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860004035", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "3001715", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "2101079", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "123450", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");


    }

    @Test
    @Transactional
    @TestOrder(6050)
    public void testExec_F5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004043");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860004043", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "D001", "代理店コード");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");
        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 0), C_Channelcd.MIZUHO, "チャネルコード");

    }

    @Test
    @Transactional
    @TestOrder(6060)
    public void testExec_F6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860004050");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860004050", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");

    }


    @Test
    @Transactional
    @TestOrder(7010)
    public void testExec_G1() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005008");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "代理店が存在しません。　金融機関コード　１０２３　支店コード　２２３", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(7020)
    public void testExec_G2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005016");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860005016", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店が存在しません。　金融機関コード　１０２３　支店コード　２２３", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0119", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoKinyuuKikanMockForSinkeiyaku.class, "exec", 0, 0), "1023", "金融機関コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoKinyuuKikanMockForSinkeiyaku.class, "exec", 0, 1), "223", "金融機関支店コード");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860005016", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "募集人コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");


    }

    @Test
    @Transactional
    @TestOrder(7030)
    public void testExec_G3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN9;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005024");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860005024", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "2001710", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "123450", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");



    }

    @Test
    @Transactional
    @TestOrder(7040)
    public void testExec_G4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN6;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005032");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルの件数");


        exStringEquals(hubiMsgLst.get(0).getMosno(), "860005032", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２３　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1014", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


        exStringEquals(hubiMsgLst.get(1).getMosno(), "860005032", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２３　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1014", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(7050)
    public void testExec_G5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN4;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005040");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860005040", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");



    }

    @Test
    @Transactional
    @TestOrder(7060)
    public void testExec_G6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005057");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860005057", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２３　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1014", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(7070)
    public void testExec_G7() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN5;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005065");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860005065", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２３　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KHC1014", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(7080)
    public void testExec_G8() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005073");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２", "エラーメッセージ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "３　親代理店コード　２００１７１６", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(7090)
    public void testExec_G9() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005081");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ａ担当者組織コードエラー", "エラーメッセージ");

        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoJimusyoMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "親代理店コード");
        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoJimusyoMockForSinkeiyaku.class, "exec", 0, 1), "5009", "代理店事務所コード");

    }

    @Test
    @Transactional
    @TestOrder(7100)
    public void testExec_G10() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005099");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｂ担当者組織コードエラー", "エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(7110)
    public void testExec_G11() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005107");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860005107", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人に対応する代理店と事務所コードに関連性がありません。　事務所コード　５００９", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1060", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(7120)
    public void testExec_G12() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN6;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005115");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860005115", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "3001717", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "123452", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000017", "代理店管理組織コード");


    }

    @Test
    @Transactional
    @TestOrder(7130)
    public void testExec_G13() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860005123");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860005123", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getTratkiagcd(), "", "募集人コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), null, "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");


    }

    @Test
    @Transactional
    @TestOrder(8010)
    public void testExec_H1() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006006");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860006006", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】金融機関コードが募集人の所属する親代理店と一致しません。　金融機関コード　１０２３　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1014", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(8020)
    public void testExec_H2() {
        MockObjectManager.initialize();

        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006014");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(8030)
    public void testExec_H3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006022");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "親代理店コードが有効ではありません。　親代理店コード　９００１７１７", "エラーメッセージ");



    }

    @Test
    @Transactional
    @TestOrder(8040)
    public void testExec_H4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006030");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180714"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(8050)
    public void testExec_H5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006048");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860006048", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】親代理店コードが有効ではありません。　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0121", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(8060)
    public void testExec_H6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006055");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20160309"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(8070)
    public void testExec_H7() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006063");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860006063", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）親代理店コードが有効ではありません。　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KHC0121", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(8080)
    public void testExec_H8() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860006071");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180710"), "基準年月日");


    }


    @Test
    @Transactional
    @TestOrder(9010)
    public void testExec_I1() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007004");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(9020)
    public void testExec_I2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN5;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007012");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "代理店コードが有効ではありません。　取扱代理店コード　３００１７１９", "エラーメッセージ");


    }

    @Test
    @Transactional
    @TestOrder(9030)
    public void testExec_I3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN5;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007020");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "3001715", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180714"), "基準年月日");



    }

    @Test
    @Transactional
    @TestOrder(9040)
    public void testExec_I4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007038");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860007038", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店コードが有効ではありません。　取扱代理店コード　３００１７１５", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC0073", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(9050)
    public void testExec_I5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007046");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "3001715", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20160309"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(9060)
    public void testExec_I6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN1;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007053");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860007053", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店コードが有効ではありません。　取扱代理店コード　３００１７１５", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC0073", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(9070)
    public void testExec_I7() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007061");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 0), "3001715", "代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(BzChkAgYuukouMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf("20180710"), "基準年月日");


    }

    @Test
    @Transactional
    @TestOrder(10010)
    public void testExec_J1() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860008002");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


    }

    @Test
    @Transactional
    @TestOrder(10020)
    public void testExec_J2() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860008010");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860008010", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.SMTB, "新契約事務区分");

        HT_MosKihon mosKihon = syoriCTL1.getMosKihon();
        exClassificationEquals(mosKihon.getKoureitaioukbn(), null, "高齢者対応区分");

        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(GetSkChannelInfoMockForSinkeiyaku.class, "exec", 0, 0), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals((String)MockObjectManager.getArgument(GetSkChannelInfoMockForSinkeiyaku.class, "exec", 0, 1), "", "代理店コード");
    }

    @Test
    @Transactional
    @TestOrder(10030)
    public void testExec_J3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN7;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860008028");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860008028", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.NIHONYUUBIN, "新契約事務区分");

        HT_MosKihon mosKihon = syoriCTL1.getMosKihon();
        exClassificationEquals(mosKihon.getKoureitaioukbn(), null, "高齢者対応区分");

    }
    @Test
    @Transactional
    @TestOrder(10040)
    public void testExec_J4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860008036");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860008036", "申込番号");
        exClassificationEquals(syoriCTL1.getSkeijimukbn(), C_SkeijimuKbn.SMTB, "申込番号");

        HT_MosKihon mosKihon = syoriCTL1.getMosKihon();
        exClassificationEquals(mosKihon.getKoureitaioukbn(), C_KoureisyaTaiouKbn.BLNK, "高齢者対応区分");

    }

    @Test
    @Transactional
    @TestOrder(11010)
    public void testExec_K1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009000");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(11020)
    public void testExec_K2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009018");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(11030)
    public void testExec_K3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009026");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860009026", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "受付管理ＩＤの入力が必要です。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0175", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(11040)
    public void testExec_K4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009034");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860009034", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "受付管理ＩＤの体系が正しくありません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1005", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");



    }

    @Test
    @Transactional
    @TestOrder(11050)
    public void testExec_K5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009042");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


    }

    @Test
    @Transactional
    @TestOrder(11060)
    public void testExec_K6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009059");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860009059", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "受付管理ＩＤが重複しています。受付管理ＩＤ：１８０１１１１１１１１　重複申込番号：８６１１１００１３", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHA1066", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(11070)
    public void testExec_K7() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009067");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860009067", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "受付管理ＩＤが重複しています。受付管理ＩＤ：１８０１１２１１１１１　重複申込番号：８６１１１００２１　他、１件", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHA1067", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(11080)
    public void testExec_K8() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009075");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


    }

    @Test
    @Transactional
    @TestOrder(11090)
    public void testExec_K9() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009083");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860009083", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "受付管理ＩＤの入力は不要です。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0176", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(12010)
    public void testExec_L1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010008");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(12020)
    public void testExec_L2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010016");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(12030)
    public void testExec_L3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN8;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010024");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(GetDairitenKobetuJyouhouMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "親代理店コード");
        exClassificationEquals((C_MosUketukeKbn)MockObjectManager.getArgument(GetDairitenKobetuJyouhouMockForSinkeiyaku.class, "exec", 0, 1), C_MosUketukeKbn.DIRECT, "申込受付区分");

    }

    @Test
    @Transactional
    @TestOrder(12040)
    public void testExec_L4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010032");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(12050)
    public void testExec_L5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010040");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860010040", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ＣＩＦコードの入力が必要です。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(12060)
    public void testExec_L6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010057");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860010057", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ＣＩＦコードが正しくありません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(12070)
    public void testExec_L7() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010065");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");


    }

    @Test
    @Transactional
    @TestOrder(12080)
    public void testExec_L8() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN7;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010073");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860010073", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）ＣＩＦコードの入力が必要です。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(13010)
    public void testExec_M1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        ConvertChannelcdMockForSinkeiyaku.SYORIPTN = ConvertChannelcdMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012004");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012004", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010013", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");

        exClassificationEquals(mosnaiCheckParam.getKiteiCheckChannelCd(), C_Channelcd.TIGIN, "規定チェック用チャネルコード");
    }

    @Test
    @Transactional
    @TestOrder(13020)
    public void testExec_M2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012012");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012012", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010013", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");
    }

    @Test
    @Transactional
    @TestOrder(13030)
    public void testExec_M3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012020");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012020", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010013", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");
    }

    @Test
    @Transactional
    @TestOrder(13040)
    public void testExec_M4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN6;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012038");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012038", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "9001717", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "3001717", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010012", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "123452", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000017", "代理店管理組織コード");
    }

    @Test
    @Transactional
    @TestOrder(13050)
    public void testExec_M5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN3;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012046");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012046", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010011", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), null, "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");

        HT_MosDairiten mosDairiten1 = syoriCTL1.getMosDairitenByRenno(2);
        exStringEquals(mosDairiten1.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten1.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten1.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten1.getBosyuucd(), "010012", "募集人コード");
        exStringEquals(mosDairiten1.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten1.getDaibosyuucd(), null, "代表募集人コード");
        exStringEquals(mosDairiten1.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");

        HT_MosDairiten mosDairiten2 = syoriCTL1.getMosDairitenByRenno(3);
        exStringEquals(mosDairiten2.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten2.getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairiten2.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten2.getBosyuucd(), "010012", "募集人コード");
        exStringEquals(mosDairiten2.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten2.getDaibosyuucd(), null, "代表募集人コード");
        exStringEquals(mosDairiten2.getDrtenkanrisosikicd(), "4000015", "代理店管理組織コード");
    }

    @Test
    @Transactional
    @TestOrder(13060)
    public void testExec_M6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN9;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860012053");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), "860012053", "申込番号");

        HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(1);
        exStringEquals(mosDairiten.getBsyujoyadrtencd(), "3001023", "募集時親代理店コード");
        exStringEquals(mosDairiten.getTratkiagcd(), "2001710", "取扱代理店コード");
        exStringEquals(mosDairiten.getOyadrtencd(), "9001717", "親代理店コード");
        exStringEquals(mosDairiten.getBosyuucd(), "010011", "募集人コード");
        exStringEquals(mosDairiten.getTratkikouinncd(), null, "取扱行員コード");
        exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");

        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 0), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals((String)MockObjectManager.getArgument(ConvertChannelcdMockForSinkeiyaku.class, "exec", 0, 1), "9001717", "親代理店コード");

    }

    @Test
    @Transactional
    @TestOrder(14010)
    public void testExec_N1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860013002");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(14020)
    public void testExec_N2() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860013010");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }
    @Test
    @Transactional
    @TestOrder(14030)
    public void testExec_N3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN3;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860013028");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(14040)
    public void testExec_N4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN11;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN6;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860013036");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191014));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860013036", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "募集人情報に重複があります。　募集人コード　０１００１２", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0170", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(14050)
    public void testExec_N5() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860013044");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集人情報に重複があります。　募集人コード　０１００１３", "エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(15010)
    public void testExec_O1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014000");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(15020)
    public void testExec_O2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014018");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(15030)
    public void testExec_O3() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014026");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860014026", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "代理店の分担割合が正しくありません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0048", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(15040)
    public void testExec_O4() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014034");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String)MockObjectManager.getArgument(BzGetAgInfoMockForSinkeiyaku.class, "exec", 0, 0), "D001", "代理店コード");


    }

    @Test
    @Transactional
    @TestOrder(15050)
    public void testExec_O5() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoJimusyoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoJimusyoMockForSinkeiyaku.TESTPATTERN3;
        GetDairitenKobetuJyouhouMockForSinkeiyaku.SYORIPTN = GetDairitenKobetuJyouhouMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014042");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860014042", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "注意事項　Ｂ扱者の入力要否を確認してください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1007", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(15060)
    public void testExec_O6() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN6;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;

        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014059");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180101"));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exStringEquals((String) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 0, 0),
            "", "代理店コード");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 0, 1),
            BizDateYM.valueOf("201801"), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class,
            "execBuntanaiteSiteinasi", 0, 2),
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "代理店商品識別区分");
        exClassificationEquals(
            (C_Hrkkaisuu) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 0, 3),
            C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(
            (C_DiritenplannmKbn) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 0, 4),
            C_DiritenplannmKbn.BLNK, "代理店プラン名区分");

        exStringEquals((String) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 1, 0),
            "9001717", "代理店コード");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 1, 1),
            BizDateYM.valueOf("201801"), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class,
            "execBuntanaiteSiteinasi", 1, 2),
            C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "代理店商品識別区分");
        exClassificationEquals(
            (C_Hrkkaisuu) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 1, 3),
            C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(
            (C_DiritenplannmKbn) MockObjectManager.getArgument(BzGetBuntanInfoMockForSinkeiyaku.class, "execBuntanaiteSiteinasi", 1, 4),
            C_DiritenplannmKbn.BLNK, "代理店プラン名区分");

    }

    @Test
    @Transactional
    @TestOrder(15070)
    public void testExec_O7() {

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN6;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;

        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014067");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180719"));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860014067", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "注意事項　Ｂ扱者の入力要否を確認してください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1007", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(15080)
    public void testExec_O8() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN6;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;

        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014075");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180719"));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860014075", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "注意事項　Ｂ扱者の代理店を確認してください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1008", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(15090)
    public void testExec_O9() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN6;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;

        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014083");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180719"));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(15060)
    public void testExec_O11() {
        MockObjectManager.initialize();

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN6;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN4;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;

        BzGetBuntanInfoMockForSinkeiyaku.SYORIPTN = BzGetBuntanInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860014059");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180101"));

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860014059", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "注意事項　Ｂ扱者の入力要否を確認してください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1007", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(16010)
    public void testExec_P1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860015007");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(16020)
    public void testExec_P2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860015015");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860015015", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "特定関係法人該当懸念ありです。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(16030)
    public void testExec_P3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(17010)
    public void testExec_Q1() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017003");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");
    }

    @Test
    @Transactional
    @TestOrder(17020)
    public void testExec_Q2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017011");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 3);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "10", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17030)
    public void testExec_Q3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017029");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "XX", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17040)
    public void testExec_Q4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017037");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "02", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17050)
    public void testExec_Q5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017045");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860017045", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】初期死亡保険金抑制型一時払終身保険（外貨建）を取扱えません。　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1119", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "01", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17060)
    public void testExec_Q6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017052");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860017052", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）初期死亡保険金抑制型一時払終身保険（外貨建）を取扱えません。　親代理店コード　９００１７１７", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KHC1119", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20180710111400000", "業務用更新時間");

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "01", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17070)
    public void testExec_Q7() {
        MockObjectManager.initialize();
        BzGetBsInfoBstrknoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoBstrknoMockForSinkeiyaku.TESTPATTERN5;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN8;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN3;
        GetSkChannelInfoMockForSinkeiyaku.SYORIPTN = GetSkChannelInfoMockForSinkeiyaku.TESTPATTERN2;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860017060");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("M110", 2);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");
    }

    @Test
    @Transactional
    @TestOrder(17080)
    public void testExec_Q8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "03", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17090)
    public void testExec_Q9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "02", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17100)
    public void testExec_Q10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "01", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(17110)
    public void testExec_Q11() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "01", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }
    @Test
    @Transactional
    @TestOrder(17120)
    public void testExec_Q12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001999");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "02", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }
    @Test
    @Transactional
    @TestOrder(17130)
    public void testExec_Q13() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN5;
        BzChkAgYuukouMockForSinkeiyaku.SYORIPTN = BzChkAgYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouHengakuMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouHengakuMockForSinkeiyaku.TESTPATTERN2;
        BzChkBsYuukouMockForSinkeiyaku.SYORIPTN = BzChkBsYuukouMockForSinkeiyaku.TESTPATTERN2;
        BzGetBsInfoMockForSinkeiyaku.SYORIPTN = BzGetBsInfoMockForSinkeiyaku.TESTPATTERN1;
        BzGetAgInfoKinyuuKikanMockForSinkeiyaku.SYORIPTN = BzGetAgInfoKinyuuKikanMockForSinkeiyaku.TESTPATTERN1;
        BzGetDairitenItakuSyouhnMockForSinkeiyaku.SYORIPTN = BzGetDairitenItakuSyouhnMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001981");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180710111400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei pSyuSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);

        mosnaiCheckParam.setSyuSyouhnZokusei(pSyuSyouhnZokusei);
        checkTblMosDairiten.exec(mosnaiCheckParam);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 0), "9001717", "代理店コード");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class,
            "exec", 0, 1), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI, "商品識別区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 2), "2", "払込方法区分");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 3), "01", "プラン名区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(BzGetDairitenItakuSyouhnMockForSinkeiyaku.class, "exec", 0, 4), BizDate.valueOf("20160311"), "基準日");
    }

}
