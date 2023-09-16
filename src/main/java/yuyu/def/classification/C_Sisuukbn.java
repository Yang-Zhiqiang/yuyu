
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 指数区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sisuukbn</td><td colspan="3">指数区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLCON1}</td><td>&quot;1&quot;</td><td>ボラコン１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLCON2}</td><td>&quot;2&quot;</td><td>ボラコン２</td></tr>
 * </table>
 */
public class C_Sisuukbn extends Classification<C_Sisuukbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Sisuukbn BLNK = new C_Sisuukbn("0");

    public static final C_Sisuukbn BLCON1 = new C_Sisuukbn("1");

    public static final C_Sisuukbn BLCON2 = new C_Sisuukbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BLCON1, "BLCON1", false);
        addPattern(PATTERN_DEFAULT, BLCON2, "BLCON2", false);


        lock(C_Sisuukbn.class);
    }

    private C_Sisuukbn(String value) {
        super(value);
    }

    public static C_Sisuukbn valueOf(String value) {
        return valueOf(C_Sisuukbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sisuukbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sisuukbn.class, patternId, value);
    }
}
