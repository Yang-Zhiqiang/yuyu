
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集人一事務所登録区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosyuuitijimtrkKbn</td><td colspan="3">募集人一事務所登録区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>親代理店にて募集人コード登録</td></tr>
 * </table>
 */
public class C_BosyuuitijimtrkKbn extends Classification<C_BosyuuitijimtrkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosyuuitijimtrkKbn BLNK = new C_BosyuuitijimtrkKbn("0");

    public static final C_BosyuuitijimtrkKbn TOUROKU = new C_BosyuuitijimtrkKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);


        lock(C_BosyuuitijimtrkKbn.class);
    }

    private C_BosyuuitijimtrkKbn(String value) {
        super(value);
    }

    public static C_BosyuuitijimtrkKbn valueOf(String value) {
        return valueOf(C_BosyuuitijimtrkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosyuuitijimtrkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosyuuitijimtrkKbn.class, patternId, value);
    }
}
