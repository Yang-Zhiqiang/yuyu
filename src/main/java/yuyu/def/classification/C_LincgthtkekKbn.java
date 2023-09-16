
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ該当判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LincgthtkekKbn</td><td colspan="3">ＬＩＮＣ該当判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIHANTEI}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAITAISYOUGAI}</td><td>&quot;1&quot;</td><td>ＬＩＮＣ照会対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAITAISYOU}</td><td>&quot;2&quot;</td><td>ＬＩＮＣ照会対象</td></tr>
 * </table>
 */
public class C_LincgthtkekKbn extends Classification<C_LincgthtkekKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LincgthtkekKbn MIHANTEI = new C_LincgthtkekKbn("0");

    public static final C_LincgthtkekKbn SYOUKAITAISYOUGAI = new C_LincgthtkekKbn("1");

    public static final C_LincgthtkekKbn SYOUKAITAISYOU = new C_LincgthtkekKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIHANTEI, "MIHANTEI", true);
        addPattern(PATTERN_DEFAULT, SYOUKAITAISYOUGAI, "SYOUKAITAISYOUGAI", false);
        addPattern(PATTERN_DEFAULT, SYOUKAITAISYOU, "SYOUKAITAISYOU", false);


        lock(C_LincgthtkekKbn.class);
    }

    private C_LincgthtkekKbn(String value) {
        super(value);
    }

    public static C_LincgthtkekKbn valueOf(String value) {
        return valueOf(C_LincgthtkekKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LincgthtkekKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LincgthtkekKbn.class, patternId, value);
    }
}
