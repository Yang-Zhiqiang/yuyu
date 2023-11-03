package yuyu.common.siharai.chksk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.id.PKJM_SkNaiyouChk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求内容チェック結果設定処理のメソッド{@link SiSKNaiyouChkkekkaSettei#exec(C_SeikyuuSyubetu, String, C_SikinouModeIdKbn,
 *              CheckSbSkNaiyouKekkaBean, CheckKdSkNaiyouKekkaBean, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSKNaiyouChkkekkaSetteiTest_exec {

    @Inject
    private SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_請求内容チェック結果設定処理";

    private final static String sheetName = "テストデータ";

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiSKNaiyouChkkekkaSetteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SiharaiDomManager mgr = SWAKInjector.getInstance(
            SiharaiDomManager.class);
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK,
            C_YobidasimotoTaskKbn.SATEI));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            C_YobidasimotoTaskKbn.TETUDUKI_SYOUNIN));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK,
            C_YobidasimotoTaskKbn.SESYOU_KAIKETU));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYASEIBETU_MINYUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_SITEIDR,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SKSKINFO_CHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.TDKDADR_UMUCHK,
            C_YobidasimotoTaskKbn.SKUKE));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.POSTALCD_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.ADRKJ_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.TELNO_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.BANKCD_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.SITENCD_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.YOKINSYUMOKU_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.KOUZANO_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
        mgr.delete(new PKJM_SkNaiyouChk(C_SKNaiyouChkKbn.KZDOUKBN_MINYUCHK,
            C_YobidasimotoTaskKbn.SINDANSYORYOUSHR));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "（死亡）請求内容チェック結果警告メッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "111111", "メッセージID");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "222222", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "333333", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "444444", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "555555", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "666666", "メッセージ引数5");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

        JM_SkNaiyouChk skNaiyouChk = (JM_SkNaiyouChk) MockObjectManager.getArgument(SiMsgHikisuuSettei.class, "exec",
            0, 0);
        exClassificationEquals(skNaiyouChk.getSknaiyouchkkbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exClassificationEquals(skNaiyouChk.getYobidasimototaskkbn(), C_YobidasimotoTaskKbn.SKUKE, "呼出元タスク区分");
        exClassificationEquals(skNaiyouChk.getMsgsyubetu(), C_MsgSyubetu.WARNING, "メッセージ種別");
        exClassificationEquals(skNaiyouChk.getSateikaisouyouhikbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(skNaiyouChk.getKeisankahikbn(), C_KahiKbn.KA, "計算可否区分");
        exStringEquals(skNaiyouChk.getMessageId(), "111111", "メッセージＩＤ");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 1, "MSG 1");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 2, "MSG 2");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 3, "MSG 3");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 4, "MSG 4");
        MockObjectManager.assertArgumentPassed(SiMsgHikisuuSettei.class, "exec", 5, "MSG 5");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.TENKEN, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.HUKA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(0), "111111", "メッセージID");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(1), "222222", "メッセージ引数1");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(2), "333333", "メッセージ引数2");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(3), "444444", "メッセージ引数3");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(4), "555555", "メッセージ引数4");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(5), "666666", "メッセージ引数5");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.TENKEN, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.HUKA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI1, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI2, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI3, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI4, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SESSYOU1, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SESSYOU2, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI1, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI2, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean,chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI3, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SATEI4, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SESSYOU1, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.SESSYOU2, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISATEISB,
            C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = new CheckSdsSkNaiyouKekkaBean();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.POSTALCD_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SDSSHR, TeisuuSiharai.SISINDANSYORYOUSIHARAI,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        assertNull(checkSbkrSkNaiyouKekkaBean);

        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().size(), 6,
            "（診断書料支払）請求内容チェック結果警告メッセージ件数");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(0)), "111111",
            "メッセージID");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(1)), "222222",
            "メッセージ引数1");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(2)), "333333",
            "メッセージ引数2");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(3)), "444444",
            "メッセージ引数3");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(4)), "555555",
            "メッセージ引数4");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(5)), "666666",
            "メッセージ引数5");
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size(), 0,
            "（診断書料支払）請求内容チェック結果エラーメッセージ件数");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = new CheckSdsSkNaiyouKekkaBean();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.ADRKJ_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SDSSHR, TeisuuSiharai.SISINDANSYORYOUSIHARAI,
            C_SikinouModeIdKbn.TENKEN, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        assertNull(checkSbkrSkNaiyouKekkaBean);
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().size(), 0,
            "（診断書料支払）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size(), 1,
            "（診断書料支払）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageId(), "111111", "メッセージID");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = new CheckSdsSkNaiyouKekkaBean();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TELNO_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SDSSHR, TeisuuSiharai.SISINDANSYORYOUSIHARAI,
            C_SikinouModeIdKbn.TENKEN, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        assertNull(checkSbkrSkNaiyouKekkaBean);
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().size(), 0,
            "（診断書料支払）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size(), 1,
            "（診断書料支払）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageId(), "111111", "メッセージID");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(311)
    public void testExec_A32() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = new CheckSbkrSkNaiyouKekkaBean();

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SIUKTHOU_MINYUCHK);
        ChkKekkaBean.setMsgHikisuu1("MSG 1");
        ChkKekkaBean.setMsgHikisuu2("MSG 2");
        ChkKekkaBean.setMsgHikisuu3("MSG 3");
        ChkKekkaBean.setMsgHikisuu4("MSG 4");
        ChkKekkaBean.setMsgHikisuu5("MSG 5");
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SBKRUKTK, TeisuuSiharai.SISIBOUKARIUKETUKE,
            null, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,checkSbkrSkNaiyouKekkaBean,
            checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().size(), 6,
            "（死亡仮受付）請求内容チェック結果警告メッセージ件数");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(0)), "111111",
            "メッセージID");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(1)), "222222",
            "メッセージ引数1");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(2)), "333333",
            "メッセージ引数2");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(3)), "444444",
            "メッセージ引数3");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(4)), "555555",
            "メッセージ引数4");
        exStringEquals(String.valueOf(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().get(5)), "666666",
            "メッセージ引数5");
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().size(), 0,
            "（死亡仮受付）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(312)
    public void testExec_A33() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = new CheckSbkrSkNaiyouKekkaBean();

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKSYU_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SBKRUKTK, TeisuuSiharai.SISIBOUKARIUKETUKE,
            null, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,checkSbkrSkNaiyouKekkaBean,
            checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().size(), 0,
            "（死亡仮受付）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().size(), 1,
            "（死亡仮受付）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageId(), "111111", "メッセージID");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(313)
    public void testExec_A34() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = new CheckSbkrSkNaiyouKekkaBean();

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SHRKKN_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SBKRUKTK, TeisuuSiharai.SISIBOUKARIUKETUKE,
            null, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,checkSbkrSkNaiyouKekkaBean,
            checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().size(), 0,
            "（死亡仮受付）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().size(), 1,
            "（死亡仮受付）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageId(), "111111", "メッセージID");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(320)
    public void testExec_B1() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.BLNK, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(330)
    public void testExec_B2() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HIGAITOU);
        chkKekkaBeanLst.add(ChkKekkaBean);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(340)
    public void testExec_B3() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(350)
    public void testExec_B4() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "111111", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(360)
    public void testExec_B5() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(370)
    public void testExec_B6() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 18, "（死亡）請求内容チェック結果警告メッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "000001", "メッセージID");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "222222", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "333333", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "444444", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "555555", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "666666", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(6), "000002", "メッセージID");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(7), "222222", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(8), "333333", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(9), "444444", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(10), "555555", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(11), "666666", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(12), "000003", "メッセージID");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(13), "222222", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(14), "333333", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(15), "444444", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(16), "555555", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(17), "666666", "メッセージ引数5");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(380)
    public void testExec_B7() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_SITEIDR);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSKINFO_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TDKDADR_UMUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SB, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 3,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "000001", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageId(),
            "000002", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageId(),
            "000003", "メッセージID");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(390)
    public void testExec_B8() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 18, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(0), "000001", "メッセージID");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(1), "222222", "メッセージ引数1");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(2), "333333", "メッセージ引数2");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(3), "444444", "メッセージ引数3");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(4), "555555", "メッセージ引数4");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(5), "666666", "メッセージ引数5");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(6), "000002", "メッセージID");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(7), "222222", "メッセージ引数1");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(8), "333333", "メッセージ引数2");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(9), "444444", "メッセージ引数3");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(10), "555555", "メッセージ引数4");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(11), "666666", "メッセージ引数5");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(12), "000003", "メッセージID");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(13), "222222", "メッセージ引数1");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(14), "333333", "メッセージ引数2");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(15), "444444", "メッセージ引数3");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(16), "555555", "メッセージ引数4");
        exStringEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().get(17), "666666", "メッセージ引数5");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(400)
    public void testExec_B9() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();
        checkSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = new CheckKdSkNaiyouKekkaBean();
        checkKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
        checkKdSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_SITEIDR);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSKINFO_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TDKDADR_UMUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.KOUSG, TeisuuSiharai.SISEIKYUUUKETUKESB,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（死亡）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0,
            "（死亡）請求内容チェック結果エラーメッセージ件数");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkKdSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "（高度障害）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 3,
            "（高度障害）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "000001", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageId(),
            "000002", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(1).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        exStringEquals(checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageId(),
            "000003", "メッセージID");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[0].toString(),
            "222222", "メッセージ引数1");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[1].toString(),
            "333333", "メッセージ引数2");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[2].toString(),
            "444444", "メッセージ引数3");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[3].toString(),
            "555555", "メッセージ引数4");
        exStringEquals(
            checkKdSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(2).getMessageArgs()[4].toString(),
            "666666", "メッセージ引数5");
        assertNull(checkSbkrSkNaiyouKekkaBean);
        assertNull(checkSdsSkNaiyouKekkaBean);
    }

    @Test
    @TestOrder(410)
    public void testExec_B10() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = new CheckSdsSkNaiyouKekkaBean();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KRKKEIJYO_CHK);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.BANKCD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SITENCD_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SDSSHR, TeisuuSiharai.SISINDANSYORYOUSIHARAI,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        assertNull(checkSbkrSkNaiyouKekkaBean);
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().size(), 18,
            "（診断書料支払）請求内容チェック結果警告メッセージ件数");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(0)), "000001",
            "メッセージID");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(1)), "222222",
            "メッセージ引数1");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(2)), "333333",
            "メッセージ引数2");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(3)), "444444",
            "メッセージ引数3");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(4)), "555555",
            "メッセージ引数4");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(5)), "666666",
            "メッセージ引数5");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(6)), "000002",
            "メッセージID");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(7)), "222222",
            "メッセージ引数1");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(8)), "333333",
            "メッセージ引数2");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(9)), "444444",
            "メッセージ引数3");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(10)), "555555",
            "メッセージ引数4");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(11)), "666666",
            "メッセージ引数5");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(12)), "000003",
            "メッセージID");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(13)), "222222",
            "メッセージ引数1");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(14)), "333333",
            "メッセージ引数2");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(15)), "444444",
            "メッセージ引数3");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(16)), "555555",
            "メッセージ引数4");
        exStringEquals(String.valueOf(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().get(17)), "666666",
            "メッセージ引数5");
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size(), 0,
            "（診断書料支払）請求内容チェック結果エラーメッセージ件数");
    }

    @Test
    @TestOrder(420)
    public void testExec_B11() {

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = null;

        CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = null;

        CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = null;

        CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = new CheckSdsSkNaiyouKekkaBean();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean ChkKekkaBean = new ChkKekkaBean();
        ChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.YOKINSYUMOKU_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean);
        ChkKekkaBean ChkKekkaBean2 = new ChkKekkaBean();
        ChkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KOUZANO_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean2);
        ChkKekkaBean ChkKekkaBean3 = new ChkKekkaBean();
        ChkKekkaBean3.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZDOUKBN_MINYUCHK);
        chkKekkaBeanLst.add(ChkKekkaBean3);

        siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SDSSHR, TeisuuSiharai.SISINDANSYORYOUSIHARAI,
            C_SikinouModeIdKbn.INPUT, checkSbSkNaiyouKekkaBean, checkKdSkNaiyouKekkaBean,
            checkSbkrSkNaiyouKekkaBean, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

        assertNull(checkSbSkNaiyouKekkaBean);
        assertNull(checkKdSkNaiyouKekkaBean);
        assertNull(checkSbkrSkNaiyouKekkaBean);
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().size(), 0,
            "（診断書料支払）請求内容チェック結果警告メッセージ件数");
        exNumericEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size(), 3,
            "（診断書料支払）請求内容チェック結果エラーメッセージ件数");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageId(), "000001", "メッセージID");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(0)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageId(), "000002", "メッセージID");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(1)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageId(), "000003", "メッセージID");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageArgs()[0].toString(), "222222", "メッセージ引数1");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageArgs()[1].toString(), "333333", "メッセージ引数2");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageArgs()[2].toString(), "444444", "メッセージ引数3");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageArgs()[3].toString(), "555555", "メッセージ引数4");
        exStringEquals(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().get(2)
            .getMessageArgs()[4].toString(), "666666", "メッセージ引数5");
    }

}
