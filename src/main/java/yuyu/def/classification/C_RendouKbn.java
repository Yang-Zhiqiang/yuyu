
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RendouKbn</td><td colspan="3">連動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISIJIRATE}</td><td>&quot;1&quot;</td><td>開始時レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISIJIATORATE}</td><td>&quot;2&quot;</td><td>開始時後レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJIRATE}</td><td>&quot;3&quot;</td><td>２次レート</td></tr>
 * </table>
 */
public class C_RendouKbn extends Classification<C_RendouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RendouKbn BLNK = new C_RendouKbn("0");

    public static final C_RendouKbn KAISIJIRATE = new C_RendouKbn("1");

    public static final C_RendouKbn KAISIJIATORATE = new C_RendouKbn("2");

    public static final C_RendouKbn NIJIRATE = new C_RendouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAISIJIRATE, "KAISIJIRATE", false);
        addPattern(PATTERN_DEFAULT, KAISIJIATORATE, "KAISIJIATORATE", false);
        addPattern(PATTERN_DEFAULT, NIJIRATE, "NIJIRATE", false);


        lock(C_RendouKbn.class);
    }

    private C_RendouKbn(String value) {
        super(value);
    }

    public static C_RendouKbn valueOf(String value) {
        return valueOf(C_RendouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RendouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RendouKbn.class, patternId, value);
    }
}
