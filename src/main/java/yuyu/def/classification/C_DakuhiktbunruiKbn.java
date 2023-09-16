
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 諾否決定分類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DakuhiktbunruiKbn</td><td colspan="3">諾否決定分類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAKUHIKETTEI}</td><td>&quot;1&quot;</td><td>諾否決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_DakuhiktbunruiKbn extends Classification<C_DakuhiktbunruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DakuhiktbunruiKbn BLNK = new C_DakuhiktbunruiKbn("0");

    public static final C_DakuhiktbunruiKbn DAKUHIKETTEI = new C_DakuhiktbunruiKbn("1");

    public static final C_DakuhiktbunruiKbn SYOUMETU = new C_DakuhiktbunruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAKUHIKETTEI, "DAKUHIKETTEI", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_DakuhiktbunruiKbn.class);
    }

    private C_DakuhiktbunruiKbn(String value) {
        super(value);
    }

    public static C_DakuhiktbunruiKbn valueOf(String value) {
        return valueOf(C_DakuhiktbunruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DakuhiktbunruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DakuhiktbunruiKbn.class, patternId, value);
    }
}
