
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票送付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyhysouhuKbn</td><td colspan="3">帳票送付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTENTYOKUSOU}</td><td>&quot;1&quot;</td><td>代理店直送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITENSOUHU}</td><td>&quot;2&quot;</td><td>支店送付</td></tr>
 * </table>
 */
public class C_TyhysouhuKbn extends Classification<C_TyhysouhuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyhysouhuKbn BLNK = new C_TyhysouhuKbn("0");

    public static final C_TyhysouhuKbn DRTENTYOKUSOU = new C_TyhysouhuKbn("1");

    public static final C_TyhysouhuKbn SITENSOUHU = new C_TyhysouhuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DRTENTYOKUSOU, "DRTENTYOKUSOU", false);
        addPattern(PATTERN_DEFAULT, SITENSOUHU, "SITENSOUHU", false);


        lock(C_TyhysouhuKbn.class);
    }

    private C_TyhysouhuKbn(String value) {
        super(value);
    }

    public static C_TyhysouhuKbn valueOf(String value) {
        return valueOf(C_TyhysouhuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyhysouhuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyhysouhuKbn.class, patternId, value);
    }
}
