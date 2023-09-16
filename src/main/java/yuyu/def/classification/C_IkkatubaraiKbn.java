
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 一括払区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IkkatubaraiKbn</td><td colspan="3">一括払区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;1&quot;</td><td>一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKIIKKATU}</td><td>&quot;2&quot;</td><td>定期一括払</td></tr>
 * </table>
 */
public class C_IkkatubaraiKbn extends Classification<C_IkkatubaraiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IkkatubaraiKbn BLNK = new C_IkkatubaraiKbn("0");

    public static final C_IkkatubaraiKbn IKKATU = new C_IkkatubaraiKbn("1");

    public static final C_IkkatubaraiKbn TEIKIIKKATU = new C_IkkatubaraiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IKKATU, "IKKATU", false);
        addPattern(PATTERN_DEFAULT, TEIKIIKKATU, "TEIKIIKKATU", false);


        lock(C_IkkatubaraiKbn.class);
    }

    private C_IkkatubaraiKbn(String value) {
        super(value);
    }

    public static C_IkkatubaraiKbn valueOf(String value) {
        return valueOf(C_IkkatubaraiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IkkatubaraiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IkkatubaraiKbn.class, patternId, value);
    }
}
