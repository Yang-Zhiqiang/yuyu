
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 伝票用システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DensysKbn</td><td colspan="3">伝票用システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;10&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;20&quot;</td><td>契約保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKSIHARAI}</td><td>&quot;30&quot;</td><td>保険金・給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGKANRI}</td><td>&quot;40&quot;</td><td>代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;50&quot;</td><td>年金支払</td></tr>
 * </table>
 */
public class C_DensysKbn extends Classification<C_DensysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DensysKbn BLNK = new C_DensysKbn("0");

    public static final C_DensysKbn SKEI = new C_DensysKbn("10");

    public static final C_DensysKbn HOZEN = new C_DensysKbn("20");

    public static final C_DensysKbn HKSIHARAI = new C_DensysKbn("30");

    public static final C_DensysKbn AGKANRI = new C_DensysKbn("40");

    public static final C_DensysKbn NENKIN = new C_DensysKbn("50");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);
        addPattern(PATTERN_DEFAULT, HKSIHARAI, "HKSIHARAI", false);
        addPattern(PATTERN_DEFAULT, AGKANRI, "AGKANRI", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);


        lock(C_DensysKbn.class);
    }

    private C_DensysKbn(String value) {
        super(value);
    }

    public static C_DensysKbn valueOf(String value) {
        return valueOf(C_DensysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DensysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DensysKbn.class, patternId, value);
    }
}
