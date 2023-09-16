
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ドキュメント区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DocumentKbn</td><td colspan="3">ドキュメント区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #HAKKOU}</td><td>&quot;1&quot;</td><td>発行</td></tr>
 *  <tr><td align="center">○</td><td>{@link #TOUTYAKU}</td><td>&quot;2&quot;</td><td>到着</td></tr>
 * </table>
 */
public class C_DocumentKbn extends Classification<C_DocumentKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DocumentKbn HAKKOU = new C_DocumentKbn("1");

    public static final C_DocumentKbn TOUTYAKU = new C_DocumentKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HAKKOU, "HAKKOU", false);
        addPattern(PATTERN_DEFAULT, TOUTYAKU, "TOUTYAKU", true);


        lock(C_DocumentKbn.class);
    }

    private C_DocumentKbn(String value) {
        super(value);
    }

    public static C_DocumentKbn valueOf(String value) {
        return valueOf(C_DocumentKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DocumentKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DocumentKbn.class, patternId, value);
    }
}
