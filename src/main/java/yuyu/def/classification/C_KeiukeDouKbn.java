
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契受同一区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeiukeDouKbn</td><td colspan="3">契受同一区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETU}</td><td>&quot;1&quot;</td><td>契受別</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOU}</td><td>&quot;2&quot;</td><td>契受同一</td></tr>
 * </table>
 */
public class C_KeiukeDouKbn extends Classification<C_KeiukeDouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeiukeDouKbn BLNK = new C_KeiukeDouKbn("0");

    public static final C_KeiukeDouKbn BETU = new C_KeiukeDouKbn("1");

    public static final C_KeiukeDouKbn DOU = new C_KeiukeDouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BETU, "BETU", false);
        addPattern(PATTERN_DEFAULT, DOU, "DOU", false);


        lock(C_KeiukeDouKbn.class);
    }

    private C_KeiukeDouKbn(String value) {
        super(value);
    }

    public static C_KeiukeDouKbn valueOf(String value) {
        return valueOf(C_KeiukeDouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeiukeDouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeiukeDouKbn.class, patternId, value);
    }
}
