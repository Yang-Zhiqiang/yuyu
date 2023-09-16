
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 勘定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KanjyouKbn</td><td colspan="3">勘定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN}</td><td>&quot;1&quot;</td><td>一般勘定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETU}</td><td>&quot;2&quot;</td><td>特別勘定</td></tr>
 * </table>
 */
public class C_KanjyouKbn extends Classification<C_KanjyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KanjyouKbn BLNK = new C_KanjyouKbn("0");

    public static final C_KanjyouKbn IPPAN = new C_KanjyouKbn("1");

    public static final C_KanjyouKbn TOKUBETU = new C_KanjyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IPPAN, "IPPAN", false);
        addPattern(PATTERN_DEFAULT, TOKUBETU, "TOKUBETU", false);


        lock(C_KanjyouKbn.class);
    }

    private C_KanjyouKbn(String value) {
        super(value);
    }

    public static C_KanjyouKbn valueOf(String value) {
        return valueOf(C_KanjyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KanjyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KanjyouKbn.class, patternId, value);
    }
}
