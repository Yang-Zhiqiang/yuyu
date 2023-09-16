
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * システムコード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SysCdKbn</td><td colspan="3">システムコード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;BLNK&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAY}</td><td>&quot;RAY&quot;</td><td>ＲＡＹ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAL}</td><td>&quot;PAL&quot;</td><td>ＰＡＬ</td></tr>
 * </table>
 */
public class C_SysCdKbn extends Classification<C_SysCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SysCdKbn BLNK = new C_SysCdKbn("BLNK");

    public static final C_SysCdKbn RAY = new C_SysCdKbn("RAY");

    public static final C_SysCdKbn PAL = new C_SysCdKbn("PAL");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RAY, "RAY", false);
        addPattern(PATTERN_DEFAULT, PAL, "PAL", false);


        lock(C_SysCdKbn.class);
    }

    private C_SysCdKbn(String value) {
        super(value);
    }

    public static C_SysCdKbn valueOf(String value) {
        return valueOf(C_SysCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SysCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SysCdKbn.class, patternId, value);
    }
}
