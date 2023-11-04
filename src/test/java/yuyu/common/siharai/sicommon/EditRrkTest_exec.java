package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続履歴TBL編集のメソッド{@link EditRrk#makeTtdkRrk(EditRrkTblParam,EditRrkTblBean} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditRrkTest_exec extends AbstractTest {

    @Inject
    private EditRrk editRrk;

    @Inject
    private EditRrkTblParamImpl editRrkTblParamImpl;

    @Inject
    private EditRrkTblParamSiKekkaImpl editRrkTblParamSiKekkaImpl;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_手続履歴TBL編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditRrkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        try {
            editRrk.makeTtdkRrk(null, new EditRrkTblBean());
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditRrkTblParam'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditRrkTblBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo(null);

        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seiNo'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("");

        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seiNo'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("12345678901");

        bean.setSyoNo(null);

        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoNo'", "エラーメッセージ");
        }
    }
    @Test
    @TestOrder(60)
    public void testExec_A6() {

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("12345678901");

        bean.setSyoNo("");

        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoNo'", "エラーメッセージ");
        }
    }


    @Test
    @TestOrder(70)
    public void testExec_A7() {

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("12345678901");

        bean.setSyoNo("80000000026");

        bean.setSyoriYmd(null);

        try {
            editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
        }
    }


    @Test
    @TestOrder(80)
    public void testExec_A8() {

        baseUserInfo.getUser().setUserId("administrator1");

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("12345678901");

        bean.setSyoNo("80000000026");

        bean.setSyoriYmd(BizDate.valueOf(20160116));


        bean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);

        bean.setSeiRrkNo(1);

        bean.setShrSkbtKey("100000000000000002");

        bean.setSateiSkbtKey("100000000000000001");

        editRrkTblParamSiKekkaImpl.setSyanaicomment("年回は来週一に開催される");

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditRrkTblBean resultBean = editRrk.makeTtdkRrk(editRrkTblParamSiKekkaImpl, bean);

        exStringEquals(resultBean.getSeiNo(), "12345678901", "請求番号");

        exStringEquals(resultBean.getSyoNo(), "80000000026", "証券番号");

        exDateEquals(resultBean.getSyoriYmd(), BizDate.valueOf(20160116), "処理年月日");


        exClassificationEquals(resultBean.getJimKakuteiUmuKbn(), C_JimukakuteiKbn.KAKUTEI, "事務確定区分");

        exNumericEquals(resultBean.getSeiRrkNo(), 1, "請求履歴番号");

        exStringEquals(resultBean.getShrSkbtKey(), "100000000000000002", "支払識別キー");

        exStringEquals(resultBean.getSateiSkbtKey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSkno(), "12345678901", "手続履歴TBL．請求番号");

        exStringEquals(resultBean.getTtdkRireki().getSyono(), "80000000026", "手続履歴TBL．証券番号");

        exDateEquals(resultBean.getTtdkRireki().getSyoriYmd(), BizDate.valueOf(20160116),
            "手続履歴TBL. 処理年月日");


        exStringEquals(resultBean.getTtdkRireki().getSyorisosikicd(), null,
            "手続履歴TBL．処理組織コード");


        exClassificationEquals(resultBean.getTtdkRireki().getJimukakuteiumukbn(), C_JimukakuteiKbn.KAKUTEI,
            "手続履歴TBL．事務確定区分");

        exStringEquals(String.valueOf(resultBean.getSeiRrkNo()), "1", "手続履歴TBL．請求履歴番号");

        exStringEquals(resultBean.getTtdkRireki().getShrsikibetukey(), "100000000000000002",
            "手続履歴TBL．支払識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSateisyouninskbtkey(), "100000000000000001",
            "手続履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSyanaicomment(), "年回は来週一に開催される",
            "手続履歴TBL．社内用コメント");


        exStringEquals(resultBean.getTtdkRireki().getKossyoricd(), "E10000001",
            "手続履歴TBL．更新処理コード");


        exStringEquals(resultBean.getTtdkRireki().getKossyorisscd(), "S1000001",
            "手続履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getTtdkRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "手続履歴TBL．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        baseUserInfo.getUser().setUserId("administrator1");

        EditRrkTblBean bean = new EditRrkTblBean();

        bean.setSeiNo("12345678901");

        bean.setSyoNo("80000000026");

        bean.setSyoriYmd(BizDate.valueOf(20160116));


        bean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);

        bean.setSeiRrkNo(1);

        bean.setShrSkbtKey("100000000000000002");

        bean.setSateiSkbtKey("100000000000000001");

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditRrkTblBean resultBean = editRrk.makeTtdkRrk(editRrkTblParamImpl, bean);

        exStringEquals(resultBean.getSeiNo(), "12345678901", "請求番号");

        exStringEquals(resultBean.getSyoNo(), "80000000026", "証券番号");

        exDateEquals(resultBean.getSyoriYmd(), BizDate.valueOf(20160116), "処理年月日");


        exClassificationEquals(resultBean.getJimKakuteiUmuKbn(), C_JimukakuteiKbn.KAKUTEI, "事務確定区分");

        exNumericEquals(resultBean.getSeiRrkNo(), 1, "請求履歴番号");

        exStringEquals(resultBean.getShrSkbtKey(), "100000000000000002", "支払識別キー");

        exStringEquals(resultBean.getSateiSkbtKey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSkno(), "12345678901", "手続履歴TBL．請求番号");

        exStringEquals(resultBean.getTtdkRireki().getSyono(), "80000000026", "手続履歴TBL．証券番号");


        exDateEquals(resultBean.getTtdkRireki().getSyoriYmd(), BizDate.valueOf(20160116),
            "手続履歴TBL. 処理年月日");


        exStringEquals(resultBean.getTtdkRireki().getSyorisosikicd(), null,
            "手続履歴TBL．処理組織コード");


        exClassificationEquals(resultBean.getTtdkRireki().getJimukakuteiumukbn(), C_JimukakuteiKbn.KAKUTEI,
            "手続履歴TBL．事務確定区分");

        exStringEquals(String.valueOf(resultBean.getSeiRrkNo()), "1", "手続履歴TBL．請求履歴番号");

        exStringEquals(resultBean.getTtdkRireki().getShrsikibetukey(), "100000000000000002",
            "手続履歴TBL．支払識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSateisyouninskbtkey(), "100000000000000001",
            "手続履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getTtdkRireki().getSyanaicomment(), null,
            "手続履歴TBL．社内用コメント");


        exStringEquals(resultBean.getTtdkRireki().getKossyoricd(), "E10000001",
            "手続履歴TBL．更新処理コード");


        exStringEquals(resultBean.getTtdkRireki().getKossyorisscd(), "S1000001",
            "手続履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getTtdkRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "手続履歴TBL．業務用更新者ＩＤ");
    }

    @AfterClass
    @Transactional
    public static void BzGetSousasyaSyozokuSosikiData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
        baseDomManager.delete(baseDomManager.getAllUserIdKanrens());
        baseDomManager.delete(baseDomManager.getAllIdCards());
        baseDomManager.delete(baseDomManager.getAllUsers());
    }
}
