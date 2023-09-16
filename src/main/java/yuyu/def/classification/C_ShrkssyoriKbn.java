
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払後検証処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrkssyoriKbn</td><td colspan="3">支払後検証処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKS}</td><td>&quot;1&quot;</td><td>支払後検証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKKANSKANRI}</td><td>&quot;2&quot;</td><td>請求勧奨管理</td></tr>
 * </table>
 */
public class C_ShrkssyoriKbn extends Classification<C_ShrkssyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrkssyoriKbn BLNK = new C_ShrkssyoriKbn("0");

    public static final C_ShrkssyoriKbn SHRKS = new C_ShrkssyoriKbn("1");

    public static final C_ShrkssyoriKbn SKKANSKANRI = new C_ShrkssyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHRKS, "SHRKS", false);
        addPattern(PATTERN_DEFAULT, SKKANSKANRI, "SKKANSKANRI", false);


        lock(C_ShrkssyoriKbn.class);
    }

    private C_ShrkssyoriKbn(String value) {
        super(value);
    }

    public static C_ShrkssyoriKbn valueOf(String value) {
        return valueOf(C_ShrkssyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrkssyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrkssyoriKbn.class, patternId, value);
    }
}
