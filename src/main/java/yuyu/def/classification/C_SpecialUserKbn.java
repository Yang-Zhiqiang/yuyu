
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特別ユーザー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SpecialUserKbn</td><td colspan="3">特別ユーザー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SUPER}</td><td>&quot;1&quot;</td><td>スーパーユーザー</td></tr>
 *  <tr><td align="center">○</td><td>{@link #IPPAN}</td><td>&quot;2&quot;</td><td>一般ユーザー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKKEN}</td><td>&quot;3&quot;</td><td>特権ユーザー</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RADIO RADIO}<br />(RADIO)</td><td align="center">○</td><td>{@link #IPPAN}</td><td>&quot;2&quot;</td><td>一般ユーザー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKKEN}</td><td>&quot;3&quot;</td><td>特権ユーザー</td></tr>
 * </table>
 */
public class C_SpecialUserKbn extends Classification<C_SpecialUserKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SpecialUserKbn SUPER = new C_SpecialUserKbn("1");

    public static final C_SpecialUserKbn IPPAN = new C_SpecialUserKbn("2");

    public static final C_SpecialUserKbn TOKKEN = new C_SpecialUserKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";


    static {

        addPattern(PATTERN_DEFAULT, SUPER, "SUPER", false);
        addPattern(PATTERN_DEFAULT, IPPAN, "IPPAN", true);
        addPattern(PATTERN_DEFAULT, TOKKEN, "TOKKEN", false);


        addPattern(PATTERN_RADIO, IPPAN, "IPPAN", true);
        addPattern(PATTERN_RADIO, TOKKEN, "TOKKEN", false);


        lock(C_SpecialUserKbn.class);
    }

    private C_SpecialUserKbn(String value) {
        super(value);
    }

    public static C_SpecialUserKbn valueOf(String value) {
        return valueOf(C_SpecialUserKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SpecialUserKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SpecialUserKbn.class, patternId, value);
    }
}
