package yuyu.common.hozen.khcommon;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 通算用金額取得クラスのメソッド {@link GetKhTuusanyouKngk} クラスに含まれる全メソッドの、
 * テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    GetKhTuusanyouKngkTest_getAlltsnkngk.class,
    GetKhTuusanyouKngkTest_getTsnyouTuukasyu.class,
    GetKhTuusanyouKngkTest_getTsnyouSibous.class,
    GetKhTuusanyouKngkTest_getTsnyouItijip.class,
    GetKhTuusanyouKngkTest_getTsnyouNkgns.class,
    GetKhTuusanyouKngkTest_getTsnyouYennyknkgk.class,
})
public class GetKhTuusanyouKngkTest_All {
}
