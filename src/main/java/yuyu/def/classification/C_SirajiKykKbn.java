
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 白地契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SirajiKykKbn</td><td colspan="3">白地契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUMEI}</td><td>&quot;0&quot;</td><td>不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRAJIKEIYAKU}</td><td>&quot;1&quot;</td><td>白地契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRAJIKEIYAKUIGAI}</td><td>&quot;2&quot;</td><td>白地契約以外</td></tr>
 * </table>
 */
public class C_SirajiKykKbn extends Classification<C_SirajiKykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SirajiKykKbn HUMEI = new C_SirajiKykKbn("0");

    public static final C_SirajiKykKbn SIRAJIKEIYAKU = new C_SirajiKykKbn("1");

    public static final C_SirajiKykKbn SIRAJIKEIYAKUIGAI = new C_SirajiKykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUMEI, "HUMEI", true);
        addPattern(PATTERN_DEFAULT, SIRAJIKEIYAKU, "SIRAJIKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIRAJIKEIYAKUIGAI, "SIRAJIKEIYAKUIGAI", false);


        lock(C_SirajiKykKbn.class);
    }

    private C_SirajiKykKbn(String value) {
        super(value);
    }

    public static C_SirajiKykKbn valueOf(String value) {
        return valueOf(C_SirajiKykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SirajiKykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SirajiKykKbn.class, patternId, value);
    }
}
