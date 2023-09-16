
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 未入内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MinyuunaiyouKbn</td><td colspan="3">未入内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIP}</td><td>&quot;1&quot;</td><td>初回Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;2&quot;</td><td>継続Ｐ</td></tr>
 * </table>
 */
public class C_MinyuunaiyouKbn extends Classification<C_MinyuunaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MinyuunaiyouKbn BLNK = new C_MinyuunaiyouKbn("0");

    public static final C_MinyuunaiyouKbn SYOKAIP = new C_MinyuunaiyouKbn("1");

    public static final C_MinyuunaiyouKbn KEIZOKUP = new C_MinyuunaiyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOKAIP, "SYOKAIP", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUP, "KEIZOKUP", false);


        lock(C_MinyuunaiyouKbn.class);
    }

    private C_MinyuunaiyouKbn(String value) {
        super(value);
    }

    public static C_MinyuunaiyouKbn valueOf(String value) {
        return valueOf(C_MinyuunaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MinyuunaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MinyuunaiyouKbn.class, patternId, value);
    }
}
