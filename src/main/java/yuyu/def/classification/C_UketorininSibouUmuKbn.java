
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人死亡有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UketorininSibouUmuKbn</td><td colspan="3">受取人死亡有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTSBARI}</td><td>&quot;1&quot;</td><td>受取人死亡あり</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #UKTSBARI}</td><td>&quot;1&quot;</td><td>受取人死亡あり</td></tr>
 * </table>
 */
public class C_UketorininSibouUmuKbn extends Classification<C_UketorininSibouUmuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UketorininSibouUmuKbn BLNK = new C_UketorininSibouUmuKbn("0");

    public static final C_UketorininSibouUmuKbn UKTSBARI = new C_UketorininSibouUmuKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UKTSBARI, "UKTSBARI", false);


        addPattern(PATTERN_NOBLNK, UKTSBARI, "UKTSBARI", true);


        lock(C_UketorininSibouUmuKbn.class);
    }

    private C_UketorininSibouUmuKbn(String value) {
        super(value);
    }

    public static C_UketorininSibouUmuKbn valueOf(String value) {
        return valueOf(C_UketorininSibouUmuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UketorininSibouUmuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UketorininSibouUmuKbn.class, patternId, value);
    }
}
