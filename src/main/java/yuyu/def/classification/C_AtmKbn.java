
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＴＭ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AtmKbn</td><td colspan="3">ＡＴＭ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISYA}</td><td>&quot;1&quot;</td><td>自社ＡＴＭ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKEI}</td><td>&quot;2&quot;</td><td>提携ＡＴＭ</td></tr>
 * </table>
 */
public class C_AtmKbn extends Classification<C_AtmKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AtmKbn BLNK = new C_AtmKbn("0");

    public static final C_AtmKbn JISYA = new C_AtmKbn("1");

    public static final C_AtmKbn TEIKEI = new C_AtmKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JISYA, "JISYA", false);
        addPattern(PATTERN_DEFAULT, TEIKEI, "TEIKEI", false);


        lock(C_AtmKbn.class);
    }

    private C_AtmKbn(String value) {
        super(value);
    }

    public static C_AtmKbn valueOf(String value) {
        return valueOf(C_AtmKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AtmKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AtmKbn.class, patternId, value);
    }
}
