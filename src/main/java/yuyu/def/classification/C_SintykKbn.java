
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SintykKbn</td><td colspan="3">進捗状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIWARIATE}</td><td>&quot;0&quot;</td><td>未割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MATI}</td><td>&quot;1&quot;</td><td>待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;2&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_SintykKbn extends Classification<C_SintykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SintykKbn MIWARIATE = new C_SintykKbn("0");

    public static final C_SintykKbn MATI = new C_SintykKbn("1");

    public static final C_SintykKbn HORYUU = new C_SintykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIWARIATE, "MIWARIATE", true);
        addPattern(PATTERN_DEFAULT, MATI, "MATI", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);


        lock(C_SintykKbn.class);
    }

    private C_SintykKbn(String value) {
        super(value);
    }

    public static C_SintykKbn valueOf(String value) {
        return valueOf(C_SintykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SintykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SintykKbn.class, patternId, value);
    }
}
