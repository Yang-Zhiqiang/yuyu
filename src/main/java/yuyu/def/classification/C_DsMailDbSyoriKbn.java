
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳメールＤＢ処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsMailDbSyoriKbn</td><td colspan="3">ＤＳメールＤＢ処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSIN}</td><td>&quot;2&quot;</td><td>更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;3&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_DsMailDbSyoriKbn extends Classification<C_DsMailDbSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsMailDbSyoriKbn BLNK = new C_DsMailDbSyoriKbn("0");

    public static final C_DsMailDbSyoriKbn TOUROKU = new C_DsMailDbSyoriKbn("1");

    public static final C_DsMailDbSyoriKbn KOUSIN = new C_DsMailDbSyoriKbn("2");

    public static final C_DsMailDbSyoriKbn SAKUJYO = new C_DsMailDbSyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, KOUSIN, "KOUSIN", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_DsMailDbSyoriKbn.class);
    }

    private C_DsMailDbSyoriKbn(String value) {
        super(value);
    }

    public static C_DsMailDbSyoriKbn valueOf(String value) {
        return valueOf(C_DsMailDbSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsMailDbSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsMailDbSyoriKbn.class, patternId, value);
    }
}
