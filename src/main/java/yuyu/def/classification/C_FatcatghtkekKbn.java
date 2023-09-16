
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＦＡＴＣＡ対象判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FatcatghtkekKbn</td><td colspan="3">ＦＡＴＣＡ対象判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOU}</td><td>&quot;0&quot;</td><td>対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAI}</td><td>&quot;1&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_FatcatghtkekKbn extends Classification<C_FatcatghtkekKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FatcatghtkekKbn TAISYOU = new C_FatcatghtkekKbn("0");

    public static final C_FatcatghtkekKbn TAISYOUGAI = new C_FatcatghtkekKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", true);
        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", false);


        lock(C_FatcatghtkekKbn.class);
    }

    private C_FatcatghtkekKbn(String value) {
        super(value);
    }

    public static C_FatcatghtkekKbn valueOf(String value) {
        return valueOf(C_FatcatghtkekKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FatcatghtkekKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FatcatghtkekKbn.class, patternId, value);
    }
}
