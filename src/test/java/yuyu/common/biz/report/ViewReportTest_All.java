package yuyu.common.biz.report;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link ViewReport}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 * <br />
 */
@RunWith(Suite.class)
@SuiteClasses({ ViewReportTest_getHozonKknTani.class
    , ViewReportTest_editCommaTuuka.class
    , ViewReportTest_editCommaTuuka2.class
    , ViewReportTest_editCommaKen.class
    , ViewReportTest_editSama.class
    , ViewReportTest_editSamaKana.class
    , ViewReportTest_editOntyuu.class
    , ViewReportTest_editNen.class
    , ViewReportTest_editKen.class
    , ViewReportTest_editEn.class
    , ViewReportTest_editKai.class
    , ViewReportTest_editKaigyoSama.class
    , ViewReportTest_editAdrDisp.class
    , ViewReportTest_editCommaTuukaNoSpace.class
    , ViewReportTest_editCommaTuukaNoSpace2.class
})

public class ViewReportTest_All {

}