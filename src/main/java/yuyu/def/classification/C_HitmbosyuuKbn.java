
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 非対面募集区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HitmbosyuuKbn</td><td colspan="3">非対面募集区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISSI}</td><td>&quot;1&quot;</td><td>実施</td></tr>
 * </table>
 */
public class C_HitmbosyuuKbn extends Classification<C_HitmbosyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HitmbosyuuKbn BLNK = new C_HitmbosyuuKbn("0");

    public static final C_HitmbosyuuKbn JISSI = new C_HitmbosyuuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JISSI, "JISSI", false);


        lock(C_HitmbosyuuKbn.class);
    }

    private C_HitmbosyuuKbn(String value) {
        super(value);
    }

    public static C_HitmbosyuuKbn valueOf(String value) {
        return valueOf(C_HitmbosyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HitmbosyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HitmbosyuuKbn.class, patternId, value);
    }
}
