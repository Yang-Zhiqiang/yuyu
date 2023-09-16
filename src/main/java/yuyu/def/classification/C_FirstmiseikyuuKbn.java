
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 初回年金未請求区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FirstmiseikyuuKbn</td><td colspan="3">初回年金未請求区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEIKYUU}</td><td>&quot;1&quot;</td><td>未請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUUSUMI}</td><td>&quot;2&quot;</td><td>請求済</td></tr>
 * </table>
 */
public class C_FirstmiseikyuuKbn extends Classification<C_FirstmiseikyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FirstmiseikyuuKbn BLNK = new C_FirstmiseikyuuKbn("0");

    public static final C_FirstmiseikyuuKbn MISEIKYUU = new C_FirstmiseikyuuKbn("1");

    public static final C_FirstmiseikyuuKbn SEIKYUUSUMI = new C_FirstmiseikyuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MISEIKYUU, "MISEIKYUU", false);
        addPattern(PATTERN_DEFAULT, SEIKYUUSUMI, "SEIKYUUSUMI", false);


        lock(C_FirstmiseikyuuKbn.class);
    }

    private C_FirstmiseikyuuKbn(String value) {
        super(value);
    }

    public static C_FirstmiseikyuuKbn valueOf(String value) {
        return valueOf(C_FirstmiseikyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FirstmiseikyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FirstmiseikyuuKbn.class, patternId, value);
    }
}
