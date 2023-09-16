
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 媒体区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BaitaiKbn</td><td colspan="3">媒体区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PC}</td><td>&quot;1&quot;</td><td>ＰＣ</td></tr>
 * </table>
 */
public class C_BaitaiKbn extends Classification<C_BaitaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BaitaiKbn BLANK = new C_BaitaiKbn("0");

    public static final C_BaitaiKbn PC = new C_BaitaiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, PC, "PC", false);


        lock(C_BaitaiKbn.class);
    }

    private C_BaitaiKbn(String value) {
        super(value);
    }

    public static C_BaitaiKbn valueOf(String value) {
        return valueOf(C_BaitaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BaitaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BaitaiKbn.class, patternId, value);
    }
}
