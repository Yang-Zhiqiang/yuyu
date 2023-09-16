
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受付状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktkJyoutaiKbn</td><td colspan="3">受付状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYORI}</td><td>&quot;1&quot;</td><td>未処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;2&quot;</td><td>処理済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;3&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;9&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_UktkJyoutaiKbn extends Classification<C_UktkJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UktkJyoutaiKbn BLNK = new C_UktkJyoutaiKbn("0");

    public static final C_UktkJyoutaiKbn MISYORI = new C_UktkJyoutaiKbn("1");

    public static final C_UktkJyoutaiKbn SYORIZUMI = new C_UktkJyoutaiKbn("2");

    public static final C_UktkJyoutaiKbn TORIKESI = new C_UktkJyoutaiKbn("3");

    public static final C_UktkJyoutaiKbn ERROR = new C_UktkJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", false);
        addPattern(PATTERN_DEFAULT, SYORIZUMI, "SYORIZUMI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_UktkJyoutaiKbn.class);
    }

    private C_UktkJyoutaiKbn(String value) {
        super(value);
    }

    public static C_UktkJyoutaiKbn valueOf(String value) {
        return valueOf(C_UktkJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktkJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktkJyoutaiKbn.class, patternId, value);
    }
}
