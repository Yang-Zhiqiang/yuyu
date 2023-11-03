package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiJijotdkkenseiyakusyoBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事情届兼誓約書編集のメソッド{@link EditJijotdkkenseiyakusyo#exec(EditJijotdkkenseiyakusyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditJijotdkkenseiyakusyoTest_exec {

    @Inject
    private EditJijotdkkenseiyakusyo editJijotdkkenseiyakusyo;

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        EditJijotdkkenseiyakusyoBean editJijotdkkenseiyakusyoBean = SWAKInjector
            .getInstance(EditJijotdkkenseiyakusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editJijotdkkenseiyakusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJijotdkkenseiyakusyo.exec(editJijotdkkenseiyakusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        EditJijotdkkenseiyakusyoBean editJijotdkkenseiyakusyoBean = SWAKInjector
            .getInstance(EditJijotdkkenseiyakusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20191010"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editJijotdkkenseiyakusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJijotdkkenseiyakusyo.exec(editJijotdkkenseiyakusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        EditJijotdkkenseiyakusyoBean editJijotdkkenseiyakusyoBean = SWAKInjector
            .getInstance(EditJijotdkkenseiyakusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20191010"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editJijotdkkenseiyakusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editJijotdkkenseiyakusyo.exec(editJijotdkkenseiyakusyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e ;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        EditJijotdkkenseiyakusyoBean editJijotdkkenseiyakusyoBean = SWAKInjector
            .getInstance(EditJijotdkkenseiyakusyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20191111"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);
        editJijotdkkenseiyakusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editJijotdkkenseiyakusyoBean.setSyono("860000041");
        editJijotdkkenseiyakusyoBean.setHknknukt("アイウエオ");
        editJijotdkkenseiyakusyoBean.setDrsk("カキクケコ");
        ReportServicesBean reportServicesBean = editJijotdkkenseiyakusyo.exec(editJijotdkkenseiyakusyoBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0],"860000041", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf("20191111"), "処理日付");
        SiJijotdkkenseiyakusyoBean siJijotdkkenseiyakusyoBean = (SiJijotdkkenseiyakusyoBean) (reportServicesBean.getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO.getValue()))[0];
        exStringEquals(siJijotdkkenseiyakusyoBean.getIrSyono(), "８６０００００４１", "（ＩＲ）証券番号");
        exStringEquals(siJijotdkkenseiyakusyoBean.getIrHknknuktnm(), "アイウエオ", "（ＩＲ）保険金等受取人");
        exStringEquals(siJijotdkkenseiyakusyoBean.getIrDrsknm(), "カキクケコ", "（ＩＲ）代理請求人");

    }
}
