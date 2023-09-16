
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BknsyoriKbn</td><td colspan="3">備金処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;1&quot;</td><td>備金削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKA}</td><td>&quot;2&quot;</td><td>備金追加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;3&quot;</td><td>取消</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KHSELECT KHSELECT}<br />(保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;1&quot;</td><td>備金削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;3&quot;</td><td>取消</td></tr>
 * </table>
 */
public class C_BknsyoriKbn extends Classification<C_BknsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BknsyoriKbn BLNK = new C_BknsyoriKbn("0");

    public static final C_BknsyoriKbn SAKUJYO = new C_BknsyoriKbn("1");

    public static final C_BknsyoriKbn TUIKA = new C_BknsyoriKbn("2");

    public static final C_BknsyoriKbn TORIKESI = new C_BknsyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KHSELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);
        addPattern(PATTERN_DEFAULT, TUIKA, "TUIKA", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_KHSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSELECT, SAKUJYO, "SAKUJYO", false);
        addPattern(PATTERN_KHSELECT, TORIKESI, "TORIKESI", false);


        lock(C_BknsyoriKbn.class);
    }

    private C_BknsyoriKbn(String value) {
        super(value);
    }

    public static C_BknsyoriKbn valueOf(String value) {
        return valueOf(C_BknsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BknsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BknsyoriKbn.class, patternId, value);
    }
}
