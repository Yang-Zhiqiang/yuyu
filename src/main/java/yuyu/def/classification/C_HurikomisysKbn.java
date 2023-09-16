
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振込システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HurikomisysKbn</td><td colspan="3">振込システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;1&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;2&quot;</td><td>契約保全</td></tr>
 * </table>
 */
public class C_HurikomisysKbn extends Classification<C_HurikomisysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HurikomisysKbn BLNK = new C_HurikomisysKbn("0");

    public static final C_HurikomisysKbn SKEI = new C_HurikomisysKbn("1");

    public static final C_HurikomisysKbn HOZEN = new C_HurikomisysKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);


        lock(C_HurikomisysKbn.class);
    }

    private C_HurikomisysKbn(String value) {
        super(value);
    }

    public static C_HurikomisysKbn valueOf(String value) {
        return valueOf(C_HurikomisysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HurikomisysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HurikomisysKbn.class, patternId, value);
    }
}
