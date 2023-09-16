
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 感染症区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KansensyouKbn</td><td colspan="3">感染症区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANSENSYOU}</td><td>&quot;1&quot;</td><td>感染症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANSENSYOUIGAI}</td><td>&quot;2&quot;</td><td>感染症以外</td></tr>
 * </table>
 */
public class C_KansensyouKbn extends Classification<C_KansensyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KansensyouKbn BLNK = new C_KansensyouKbn("0");

    public static final C_KansensyouKbn KANSENSYOU = new C_KansensyouKbn("1");

    public static final C_KansensyouKbn KANSENSYOUIGAI = new C_KansensyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANSENSYOU, "KANSENSYOU", false);
        addPattern(PATTERN_DEFAULT, KANSENSYOUIGAI, "KANSENSYOUIGAI", false);


        lock(C_KansensyouKbn.class);
    }

    private C_KansensyouKbn(String value) {
        super(value);
    }

    public static C_KansensyouKbn valueOf(String value) {
        return valueOf(C_KansensyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KansensyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KansensyouKbn.class, patternId, value);
    }
}
