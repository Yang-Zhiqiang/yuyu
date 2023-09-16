
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ブランク付要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YouhiblnkKbn</td><td colspan="3">ブランク付要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;2&quot;</td><td>不要</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOHUYOU NOHUYOU}<br />(不要なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 * </table>
 */
public class C_YouhiblnkKbn extends Classification<C_YouhiblnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YouhiblnkKbn BLNK = new C_YouhiblnkKbn("0");

    public static final C_YouhiblnkKbn YOU = new C_YouhiblnkKbn("1");

    public static final C_YouhiblnkKbn HUYOU = new C_YouhiblnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOHUYOU = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);


        addPattern(PATTERN_NOHUYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_NOHUYOU, YOU, "YOU", false);


        lock(C_YouhiblnkKbn.class);
    }

    private C_YouhiblnkKbn(String value) {
        super(value);
    }

    public static C_YouhiblnkKbn valueOf(String value) {
        return valueOf(C_YouhiblnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YouhiblnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YouhiblnkKbn.class, patternId, value);
    }
}
