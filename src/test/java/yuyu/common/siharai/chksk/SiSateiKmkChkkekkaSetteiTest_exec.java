package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定項目チェック結果設定処理のメソッド{@link SiSateiKmkChkkekkaSettei#exec(C_SeikyuuSyubetu, String, C_SikinouModeIdKbn,
 *              CheckSbSkNaiyouKekkaBean, CheckKdSkNaiyouKekkaBean, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSateiKmkChkkekkaSetteiTest_exec {

    @Inject
    private SiSateiKmkChkkekkaSettei siSateiKmkChkkekkaSettei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_査定項目チェック結果設定処理";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiSateiKmkChkkekkaSetteiTest_exec.class,fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager mgr = SWAKInjector.getInstance(SiharaiDomManager.class);
        mgr.delete(mgr.getAllSkNaiyouChk());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB, C_SikinouModeIdKbn.INPUT,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");

        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

        JM_SkNaiyouChk skNaiyouChk = (JM_SkNaiyouChk) MockObjectManager.getArgument(SiMsgHikisuuSettei.class, "exec",
            0, 0);
        exClassificationEquals(skNaiyouChk.getSknaiyouchkkbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exClassificationEquals(skNaiyouChk.getYobidasimototaskkbn(), C_YobidasimotoTaskKbn.SKUKE, "呼出元タスク区分");
        exStringEquals(skNaiyouChk.getMessageId(), "EBA0045", "メッセージＩＤ");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 1, "MSG 1");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 2, "MSG 2");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 3, "MSG 3");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 4, "MSG 4");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 5, "MSG 5");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB, C_SikinouModeIdKbn.TENKEN,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SATEI1,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SATEI2,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SATEI3,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SATEI4,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SESSYOU1,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB, C_SikinouModeIdKbn.SESSYOU2,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBeanTemp = new ChkKekkaBean();
        ChkKekkaBeanTemp.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        ChkKekkaBeanTemp.setMsgHikisuu1("MSG 1");
        ChkKekkaBeanTemp.setMsgHikisuu2("MSG 2");
        ChkKekkaBeanTemp.setMsgHikisuu3("MSG 3");
        ChkKekkaBeanTemp.setMsgHikisuu4("MSG 4");
        ChkKekkaBeanTemp.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBeanTemp);
        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 2, "（死亡）査定項目チェック結果のサイズ");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK, "請求内容チェック区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SEIYMD_MINYUCHK, "請求内容チェック区分");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555　処理結果　結果コード＝666666、結果事由＝777777、エラー項番＝888888、証券番号＝999999、レコード種別＝100000",
            "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(160)
    public void testExec_B1() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, null, null, checkSbSkNaiyouKekkaBean,
            checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（死亡）査定項目チェック結果のサイズ");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            null, "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "（高度障害）査定項目チェック結果のサイズ");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            "処理結果　結果コード＝111111、結果事由＝222222、エラー項番＝333333、証券番号＝444444、レコード種別＝555555", "査定項目メッセージ");
    }

    @Test
    @TestOrder(170)
    public void testExec_C1() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYOUMETU_CHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBeanTemp = new ChkKekkaBean();
        ChkKekkaBeanTemp.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBeanTemp.setMsgHikisuu1("MSG 1");
        ChkKekkaBeanTemp.setMsgHikisuu2("MSG 2");
        ChkKekkaBeanTemp.setMsgHikisuu3("MSG 3");
        ChkKekkaBeanTemp.setMsgHikisuu4("MSG 4");
        ChkKekkaBeanTemp.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBeanTemp);

        try {
            siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
                C_SikinouModeIdKbn.INPUT,
                checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　JM_SkNaiyouChk　key:C_SKNaiyouChkKbn=20101", "査定項目メッセージ");
        }
    }

    @Test
    @TestOrder(180)
    public void testExec_C2() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.BLNK, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT,
            checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean, chkKekkaBeanLst);
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（死亡）査定項目チェック結果のサイズ");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            null, "査定項目メッセージ");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "（高度障害）査定項目チェック結果のサイズ");
        exStringEquals(checkKdSkNaiyouKekkaBean.getSateiKoumokuMessage(),
            null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(190)
    public void testExec_D1() {
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(null);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSateiKmkChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT,
            checkSbSkNaiyouKekkaBean, null, chkKekkaBeanLst);
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
    }
}
