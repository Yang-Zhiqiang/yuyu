
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特約取扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkykTratkiKbn</td><td colspan="3">特約取扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKAKANOU}</td><td>&quot;1&quot;</td><td>付加可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKAHISSU}</td><td>&quot;2&quot;</td><td>付加必須</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRATKINASI}</td><td>&quot;3&quot;</td><td>取扱なし</td></tr>
 * </table>
 */
public class C_TkykTratkiKbn extends Classification<C_TkykTratkiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkykTratkiKbn BLNK = new C_TkykTratkiKbn("0");

    public static final C_TkykTratkiKbn HUKAKANOU = new C_TkykTratkiKbn("1");

    public static final C_TkykTratkiKbn HUKAHISSU = new C_TkykTratkiKbn("2");

    public static final C_TkykTratkiKbn TRATKINASI = new C_TkykTratkiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKAKANOU, "HUKAKANOU", false);
        addPattern(PATTERN_DEFAULT, HUKAHISSU, "HUKAHISSU", false);
        addPattern(PATTERN_DEFAULT, TRATKINASI, "TRATKINASI", false);


        lock(C_TkykTratkiKbn.class);
    }

    private C_TkykTratkiKbn(String value) {
        super(value);
    }

    public static C_TkykTratkiKbn valueOf(String value) {
        return valueOf(C_TkykTratkiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkykTratkiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkykTratkiKbn.class, patternId, value);
    }
}
