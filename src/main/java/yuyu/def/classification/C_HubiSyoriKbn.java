
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備用処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HubiSyoriKbn</td><td colspan="3">不備用処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYORI}</td><td>&quot;1&quot;</td><td>処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;2&quot;</td><td>照会</td></tr>
 * </table>
 */
public class C_HubiSyoriKbn extends Classification<C_HubiSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HubiSyoriKbn SYORI = new C_HubiSyoriKbn("1");

    public static final C_HubiSyoriKbn SYOUKAI = new C_HubiSyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYORI, "SYORI", true);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);


        lock(C_HubiSyoriKbn.class);
    }

    private C_HubiSyoriKbn(String value) {
        super(value);
    }

    public static C_HubiSyoriKbn valueOf(String value) {
        return valueOf(C_HubiSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HubiSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HubiSyoriKbn.class, patternId, value);
    }
}
