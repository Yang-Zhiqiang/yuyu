package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金依頼書PDF作成クラスのメソッド {@link EditPdfHenkinirai#exec(MosnaiCheckParam, C_KouzasyuruiKbn, C_Ketkekkacd)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPdfHenkiniraiTest_exec {

    private final static String mosNo1 = "971112222";

    private final static String mosNo2 = "971112230";

    @Inject
    private EditPdfHenkinirai editPdfHenkinirai;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT_SP_単体テスト仕様書（共通）_返金依頼書PDF作成";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPdfHenkiniraiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {
            SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
            C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
            C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;
            editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=971112222", "エラーメッセージ");
            throw e;
        }
    }


    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;
        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  null;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000017", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.BLNK, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.ARI, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("りそな銀行", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("天理支店", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("チア　イチアユ", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000025", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.YENKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.ARI, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("りそな銀行", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("天理支店", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("チア　イチア", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000033", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.YENKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.ARI, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("りそな銀行", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("天理支店", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("ユヒメイ　イチアユ", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000041", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.YENKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.NONE, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }


    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  C_KouzasyuruiKbn.YENKOUZA;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.exec(mosnaiCheckParam, kouzasyuruiKbn, ketkekkacd);

        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000066", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.SMBC, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.YENKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.NONE, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970000188");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  null;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.editHenkiniraisyo(syoriCTL, syoriCTL.getMosno(), C_SkeijimuKbn.MIZUHO, ketkekkacd, kouzasyuruiKbn, C_Tuukasyu.JPY);
        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("970000188", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.YENKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.NONE, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  null;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.editHenkiniraisyo(syoriCTL, syoriCTL.getMosno(), C_SkeijimuKbn.MIZUHO, ketkekkacd, kouzasyuruiKbn, C_Tuukasyu.USD);
        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("860000108", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.GAIKAKOUZA, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.NONE, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }



    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        mosnaiCheckParam.setCategoryID("skcommon");
        mosnaiCheckParam.setKinouID("EditPdfHenkinirai");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160121162000000");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000114");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160120));
        C_KouzasyuruiKbn kouzasyuruiKbn =  null;
        C_Ketkekkacd ketkekkacd = C_Ketkekkacd.MUJYOUKEN;

        editPdfHenkinirai.editHenkiniraisyo(syoriCTL, syoriCTL.getMosno(), C_SkeijimuKbn.MIZUHO, ketkekkacd, kouzasyuruiKbn, C_Tuukasyu.BLNK);
        SkHenkiniraisyoBean skHenkiniraisyoBean = editPdfHenkinirai.getSkHenkiniraisyoBean();
        exStringEquals("870000114", skHenkiniraisyoBean.getIrMosno(), "（ＩＲ）申込番号");
        exClassificationEquals(C_SkeijimuKbn.MIZUHO, skHenkiniraisyoBean.getIrSkeijimukbn(), "（ＩＲ）新契約事務区分");
        exClassificationEquals(C_Ketkekkacd.MUJYOUKEN, skHenkiniraisyoBean.getIrKetkekkacd(), "（ＩＲ）決定結果コード");
        exClassificationEquals(C_KouzasyuruiKbn.BLNK, skHenkiniraisyoBean.getIrKouzasyuruikbn(), "（ＩＲ）口座種類区分");
        exClassificationEquals(C_UmuKbn.NONE, skHenkiniraisyoBean.getIrKznrkumu(), "（ＩＲ）口座情報入力有無");
        exStringEquals("", skHenkiniraisyoBean.getIrBanknmkj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrSitennmkj(), "（ＩＲ）支店名（漢字）");
        exStringEquals("", skHenkiniraisyoBean.getIrKzmeiginmkn(), "（ＩＲ）口座名義人氏名（カナ）");
    }
}
