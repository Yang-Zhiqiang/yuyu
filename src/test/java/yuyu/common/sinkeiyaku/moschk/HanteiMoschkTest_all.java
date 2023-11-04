package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HanteiMoschk}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({HanteiMoschkTest_hanteiSpCheckKingakuSouiJissiyouhi.class
    ,HanteiMoschkTest_hanteiKykNenreiUpSekininkaisiNasiTyuui.class
    ,HanteiMoschkTest_hanteiKykNenreiUpSekininkaisiNasiKeikoku.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouGetYoteiriritu.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouGetTumitateriritu.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouYoteirirituUpDown.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouTumitaterirituUpDown.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouSetteibairituUpDown.class
    ,HanteiMoschkTest_hanteiYoteirirituHendouRendourituUpDown.class
    ,HanteiMoschkTest_hanteiSueokiKikan.class
    ,HanteiMoschkTest_hanteiItijiSaikouP.class
    ,HanteiMoschkTest_hanteiSpSaiteiS.class
    ,HanteiMoschkTest_hanteiSpSaikouS.class
    ,HanteiMoschkTest_hanteiSpSaikouNenkinGensiGendo.class
    ,HanteiMoschkTest_hanteiMosSyouhnSaiteiP.class
})
public class HanteiMoschkTest_all {
}