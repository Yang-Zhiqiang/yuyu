
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 積立金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TumitatekinKbn</td><td colspan="3">積立金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUU}</td><td>&quot;01&quot;</td><td>指数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITU}</td><td>&quot;02&quot;</td><td>定率</td></tr>
 * </table>
 */
public class C_TumitatekinKbn extends Classification<C_TumitatekinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TumitatekinKbn BLNK = new C_TumitatekinKbn("00");

    public static final C_TumitatekinKbn SISUU = new C_TumitatekinKbn("01");

    public static final C_TumitatekinKbn TEIRITU = new C_TumitatekinKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SISUU, "SISUU", false);
        addPattern(PATTERN_DEFAULT, TEIRITU, "TEIRITU", false);


        lock(C_TumitatekinKbn.class);
    }

    private C_TumitatekinKbn(String value) {
        super(value);
    }

    public static C_TumitatekinKbn valueOf(String value) {
        return valueOf(C_TumitatekinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TumitatekinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TumitatekinKbn.class, patternId, value);
    }
}
