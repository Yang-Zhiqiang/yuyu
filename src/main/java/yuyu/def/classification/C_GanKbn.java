
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * がん区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GanKbn</td><td colspan="3">がん区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAN}</td><td>&quot;1&quot;</td><td>がん</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANIGAI}</td><td>&quot;2&quot;</td><td>がん以外</td></tr>
 * </table>
 */
public class C_GanKbn extends Classification<C_GanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GanKbn BLNK = new C_GanKbn("0");

    public static final C_GanKbn GAN = new C_GanKbn("1");

    public static final C_GanKbn GANIGAI = new C_GanKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAN, "GAN", false);
        addPattern(PATTERN_DEFAULT, GANIGAI, "GANIGAI", false);


        lock(C_GanKbn.class);
    }

    private C_GanKbn(String value) {
        super(value);
    }

    public static C_GanKbn valueOf(String value) {
        return valueOf(C_GanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GanKbn.class, patternId, value);
    }
}
