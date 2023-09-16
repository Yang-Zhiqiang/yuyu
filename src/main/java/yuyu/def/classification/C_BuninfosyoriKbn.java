
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分担情報処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BuninfosyoriKbn</td><td colspan="3">分担情報処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;3&quot;</td><td>終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;4&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_BuninfosyoriKbn extends Classification<C_BuninfosyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BuninfosyoriKbn BLNK = new C_BuninfosyoriKbn("0");

    public static final C_BuninfosyoriKbn TOUROKU = new C_BuninfosyoriKbn("1");

    public static final C_BuninfosyoriKbn HENKOU = new C_BuninfosyoriKbn("2");

    public static final C_BuninfosyoriKbn SYUURYOU = new C_BuninfosyoriKbn("3");

    public static final C_BuninfosyoriKbn SAKUJYO = new C_BuninfosyoriKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_BuninfosyoriKbn.class);
    }

    private C_BuninfosyoriKbn(String value) {
        super(value);
    }

    public static C_BuninfosyoriKbn valueOf(String value) {
        return valueOf(C_BuninfosyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BuninfosyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BuninfosyoriKbn.class, patternId, value);
    }
}
