
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 遷移先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SenisakiKbn</td><td colspan="3">遷移先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #JISYORI}</td><td>&quot;0&quot;</td><td>自処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUGISYORI}</td><td>&quot;1&quot;</td><td>次処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISI}</td><td>&quot;8&quot;</td><td>開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOO}</td><td>&quot;9&quot;</td><td>終了</td></tr>
 * </table>
 */
public class C_SenisakiKbn extends Classification<C_SenisakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SenisakiKbn JISYORI = new C_SenisakiKbn("0");

    public static final C_SenisakiKbn TUGISYORI = new C_SenisakiKbn("1");

    public static final C_SenisakiKbn KAISI = new C_SenisakiKbn("8");

    public static final C_SenisakiKbn SYUURYOO = new C_SenisakiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, JISYORI, "JISYORI", true);
        addPattern(PATTERN_DEFAULT, TUGISYORI, "TUGISYORI", false);
        addPattern(PATTERN_DEFAULT, KAISI, "KAISI", false);
        addPattern(PATTERN_DEFAULT, SYUURYOO, "SYUURYOO", false);


        lock(C_SenisakiKbn.class);
    }

    private C_SenisakiKbn(String value) {
        super(value);
    }

    public static C_SenisakiKbn valueOf(String value) {
        return valueOf(C_SenisakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SenisakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SenisakiKbn.class, patternId, value);
    }
}
