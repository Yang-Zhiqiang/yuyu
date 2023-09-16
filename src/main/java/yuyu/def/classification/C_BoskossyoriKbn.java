
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集人更新処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BoskossyoriKbn</td><td colspan="3">募集人更新処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYH}</td><td>&quot;1&quot;</td><td>業廃</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEI}</td><td>&quot;2&quot;</td><td>改姓</td></tr>
 * </table>
 */
public class C_BoskossyoriKbn extends Classification<C_BoskossyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BoskossyoriKbn BLNK = new C_BoskossyoriKbn("0");

    public static final C_BoskossyoriKbn GYH = new C_BoskossyoriKbn("1");

    public static final C_BoskossyoriKbn KAISEI = new C_BoskossyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GYH, "GYH", false);
        addPattern(PATTERN_DEFAULT, KAISEI, "KAISEI", false);


        lock(C_BoskossyoriKbn.class);
    }

    private C_BoskossyoriKbn(String value) {
        super(value);
    }

    public static C_BoskossyoriKbn valueOf(String value) {
        return valueOf(C_BoskossyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BoskossyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BoskossyoriKbn.class, patternId, value);
    }
}
