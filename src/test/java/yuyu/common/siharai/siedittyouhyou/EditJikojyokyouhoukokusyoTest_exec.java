package yuyu.common.siharai.siedittyouhyou;

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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiJikoJkHoukokusBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事故状況報告書編集のメソッド{@link EditJikojyokyouhoukokusyo#exec(EditJikojyokyouhoukokusyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditJikojyokyouhoukokusyoTest_exec {
    @Inject
    private EditJikojyokyouhoukokusyo editJikojyokyouhoukokusyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_事故状況報告書編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditJikojyokyouhoukokusyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_KD_JIKOJKS));
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector
            .getInstance(EditJikojyokyouhoukokusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJikojyokyouhoukokusyo.exec(editJikojyokyouhoukokusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector
            .getInstance(EditJikojyokyouhoukokusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJikojyokyouhoukokusyo.exec(editJikojyokyouhoukokusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector
            .getInstance(EditJikojyokyouhoukokusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151212"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJikojyokyouhoukokusyo.exec(editJikojyokyouhoukokusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector
            .getInstance(EditJikojyokyouhoukokusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151214"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        ReportServicesBean reportServicesBean = editJikojyokyouhoukokusyo.exec(editJikojyokyouhoukokusyoBean);
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20151214"), "処理日付");
        SiJikoJkHoukokusBean siJikoJkHoukokusBean = (SiJikoJkHoukokusBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_KD_JIKOJKS.getValue()))[0];
        exStringEquals(siJikoJkHoukokusBean.getIrSyoriymd(), "2015年12月14日", "（ＩＲ）処理年月日");
        exStringEquals(siJikoJkHoukokusBean.getIrHozonkkn(), "3ヵ月", "（ＩＲ）処理年月日");
    }
}
