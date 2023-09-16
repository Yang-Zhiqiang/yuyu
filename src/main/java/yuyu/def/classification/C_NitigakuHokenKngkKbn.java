
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 日額・保険金額区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NitigakuHokenKngkKbn</td><td colspan="3">日額・保険金額区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NGAKU}</td><td>&quot;1&quot;</td><td>日額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGAKU}</td><td>&quot;2&quot;</td><td>保険金額</td></tr>
 * </table>
 */
public class C_NitigakuHokenKngkKbn extends Classification<C_NitigakuHokenKngkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NitigakuHokenKngkKbn BLNK = new C_NitigakuHokenKngkKbn("0");

    public static final C_NitigakuHokenKngkKbn NGAKU = new C_NitigakuHokenKngkKbn("1");

    public static final C_NitigakuHokenKngkKbn HGAKU = new C_NitigakuHokenKngkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NGAKU, "NGAKU", false);
        addPattern(PATTERN_DEFAULT, HGAKU, "HGAKU", false);


        lock(C_NitigakuHokenKngkKbn.class);
    }

    private C_NitigakuHokenKngkKbn(String value) {
        super(value);
    }

    public static C_NitigakuHokenKngkKbn valueOf(String value) {
        return valueOf(C_NitigakuHokenKngkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NitigakuHokenKngkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NitigakuHokenKngkKbn.class, patternId, value);
    }
}
