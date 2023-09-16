
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkhouKbn</td><td colspan="3">選択方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKT}</td><td>&quot;1&quot;</td><td>告知扱</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJY}</td><td>&quot;2&quot;</td><td>報状扱</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;3&quot;</td><td>無告知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKUGYOU}</td><td>&quot;4&quot;</td><td>職業のみ告知</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKT}</td><td>&quot;1&quot;</td><td>告知扱</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJY}</td><td>&quot;2&quot;</td><td>報状扱</td></tr>
 * </table>
 */
public class C_SntkhouKbn extends Classification<C_SntkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkhouKbn BLNK = new C_SntkhouKbn("0");

    public static final C_SntkhouKbn KKT = new C_SntkhouKbn("1");

    public static final C_SntkhouKbn HJY = new C_SntkhouKbn("2");

    public static final C_SntkhouKbn NONE = new C_SntkhouKbn("3");

    public static final C_SntkhouKbn SYOKUGYOU = new C_SntkhouKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKT, "KKT", false);
        addPattern(PATTERN_DEFAULT, HJY, "HJY", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, SYOKUGYOU, "SYOKUGYOU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KKT, "KKT", false);
        addPattern(PATTERN_SELECT, HJY, "HJY", false);


        lock(C_SntkhouKbn.class);
    }

    private C_SntkhouKbn(String value) {
        super(value);
    }

    public static C_SntkhouKbn valueOf(String value) {
        return valueOf(C_SntkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkhouKbn.class, patternId, value);
    }
}
