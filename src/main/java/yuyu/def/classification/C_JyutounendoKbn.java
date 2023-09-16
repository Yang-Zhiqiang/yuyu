
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 充当年度区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JyutounendoKbn</td><td colspan="3">充当年度区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO}</td><td>&quot;1&quot;</td><td>初年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDO}</td><td>&quot;2&quot;</td><td>次年度</td></tr>
 * </table>
 */
public class C_JyutounendoKbn extends Classification<C_JyutounendoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JyutounendoKbn BLNK = new C_JyutounendoKbn("0");

    public static final C_JyutounendoKbn SYONENDO = new C_JyutounendoKbn("1");

    public static final C_JyutounendoKbn JINENDO = new C_JyutounendoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYONENDO, "SYONENDO", false);
        addPattern(PATTERN_DEFAULT, JINENDO, "JINENDO", false);


        lock(C_JyutounendoKbn.class);
    }

    private C_JyutounendoKbn(String value) {
        super(value);
    }

    public static C_JyutounendoKbn valueOf(String value) {
        return valueOf(C_JyutounendoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JyutounendoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JyutounendoKbn.class, patternId, value);
    }
}
