package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.suuri.srcommon.SrFindTekiyouCategoryTest_All;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSetTest_exec;
import yuyu.common.suuri.suuricommon.SrHoyuuKeiyakuCheckTest_exec;

/**
 * 全メソッド（数理）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    /** 2017/8/16 */
    // 数理統計 数理共通 保有契約判定
    SrHoyuuKeiyakuCheckTest_exec.class,
    // 数理統計 数理共通 摘要項目取得
    SrFindTekiyouCategoryTest_All.class,
    // 数理統計 数理共通 数理用区分変換設定
    SrSuuriKbnHenkanSetTest_exec.class,
    // 数理統計 数理共通 新契約成立項目共通設定
    SrSinkykSeirituKoumokuCommonSetTest_exec.class,

})
public class TestAll_Suuri {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
