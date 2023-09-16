
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＲ情報処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MrinfosyoriKbn</td><td colspan="3">ＭＲ情報処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SHINKI}</td><td>&quot;1&quot;</td><td>新規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;3&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_MrinfosyoriKbn extends Classification<C_MrinfosyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MrinfosyoriKbn SHINKI = new C_MrinfosyoriKbn("1");

    public static final C_MrinfosyoriKbn HENKOU = new C_MrinfosyoriKbn("2");

    public static final C_MrinfosyoriKbn SAKUJYO = new C_MrinfosyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SHINKI, "SHINKI", true);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_MrinfosyoriKbn.class);
    }

    private C_MrinfosyoriKbn(String value) {
        super(value);
    }

    public static C_MrinfosyoriKbn valueOf(String value) {
        return valueOf(C_MrinfosyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MrinfosyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MrinfosyoriKbn.class, patternId, value);
    }
}
