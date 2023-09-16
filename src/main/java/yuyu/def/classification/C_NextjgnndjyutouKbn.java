
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 翌事業年度充当区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NextjgnndjyutouKbn</td><td colspan="3">翌事業年度充当区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUJGNNDMAEJYUTOU}</td><td>&quot;1&quot;</td><td>当事業年度以前充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEXTJGNNDJYUTOU}</td><td>&quot;2&quot;</td><td>翌事業年度充当</td></tr>
 * </table>
 */
public class C_NextjgnndjyutouKbn extends Classification<C_NextjgnndjyutouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NextjgnndjyutouKbn BLNK = new C_NextjgnndjyutouKbn("0");

    public static final C_NextjgnndjyutouKbn TOUJGNNDMAEJYUTOU = new C_NextjgnndjyutouKbn("1");

    public static final C_NextjgnndjyutouKbn NEXTJGNNDJYUTOU = new C_NextjgnndjyutouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUJGNNDMAEJYUTOU, "TOUJGNNDMAEJYUTOU", false);
        addPattern(PATTERN_DEFAULT, NEXTJGNNDJYUTOU, "NEXTJGNNDJYUTOU", false);


        lock(C_NextjgnndjyutouKbn.class);
    }

    private C_NextjgnndjyutouKbn(String value) {
        super(value);
    }

    public static C_NextjgnndjyutouKbn valueOf(String value) {
        return valueOf(C_NextjgnndjyutouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NextjgnndjyutouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NextjgnndjyutouKbn.class, patternId, value);
    }
}
