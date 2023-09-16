
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 一般課程試験免除区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IpnsknmnjKbn</td><td colspan="3">一般課程試験免除区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>免除なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>免除あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOUKAKU}</td><td>&quot;2&quot;</td><td>既合格者</td></tr>
 * </table>
 */
public class C_IpnsknmnjKbn extends Classification<C_IpnsknmnjKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IpnsknmnjKbn NONE = new C_IpnsknmnjKbn("0");

    public static final C_IpnsknmnjKbn ARI = new C_IpnsknmnjKbn("1");

    public static final C_IpnsknmnjKbn GOUKAKU = new C_IpnsknmnjKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, GOUKAKU, "GOUKAKU", false);


        lock(C_IpnsknmnjKbn.class);
    }

    private C_IpnsknmnjKbn(String value) {
        super(value);
    }

    public static C_IpnsknmnjKbn valueOf(String value) {
        return valueOf(C_IpnsknmnjKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IpnsknmnjKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IpnsknmnjKbn.class, patternId, value);
    }
}
