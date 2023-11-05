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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tksytratkikjn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 最低Ｐチェッククラスのメソッド {@link CheckSaiteiP#getSaiteiP(MosnaiCheckParam,HT_SyoriCTL,HT_MosKihon,HT_MosSyouhn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSaiteiPTest_getSaiteiP {

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
            testDataAndTblMap = testDataMaker.getInData(CheckSaiteiPTest_getSaiteiP.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testGetSaiteiP_A1() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN2;

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112220", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testGetSaiteiP_A2() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112238");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112238", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetSaiteiP_A3() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112246");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾉ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        MockObjectManager.initialize();

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);
        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 1001, BizCurrencyTypes.DOLLAR), "最低Ｐ");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(40)
    public void testGetSaiteiP_A4() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112253");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112253", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testGetSaiteiP_A5() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112329");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾉ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.BLNK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5102152");

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);
        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 506, BizCurrencyTypes.YEN), "最低Ｐ");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testGetSaiteiP_A6() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112261");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾉ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 0, BizCurrencyTypes.YEN), "最低Ｐ");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(70)
    public void testGetSaiteiP_A7() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112279");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ2");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN2;

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112279", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(80)
    public void testGetSaiteiP_A8() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112287");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112287", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testGetSaiteiP_A9() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112295");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN3;
        MockObjectManager.initialize();

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);
        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 2002, BizCurrencyTypes.AU_DOLLAR), "最低Ｐ");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(100)
    public void testGetSaiteiP_A10() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112303");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;

        try{
            checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112303", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testGetSaiteiP_A11() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112337");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕA");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SINKIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);
        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 605, BizCurrencyTypes.YEN), "最低Ｐ");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testGetSaiteiP_A12() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112311");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕB");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SINKIN);

        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

        HenkanTuukaMockForSinkeiyaku.SYORIPTN = HenkanTuukaMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;

        BizCurrency saiteiP = checkSaiteiP.getSaiteiP(mosnaiCheckParam, syoriCTL, mosKihon, mosSyouhn, syouhnZokusei);

        exBizCalcbleEquals(saiteiP, BizCurrency.valueOf( 0, BizCurrencyTypes.YEN), "最低Ｐ");

    }


}
