
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮ファイル区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KarifileKbn</td><td colspan="3">仮ファイル区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HON}</td><td>&quot;0&quot;</td><td>本ファイル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARI}</td><td>&quot;1&quot;</td><td>仮ファイル</td></tr>
 * </table>
 */
public class C_KarifileKbn extends Classification<C_KarifileKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KarifileKbn HON = new C_KarifileKbn("0");

    public static final C_KarifileKbn KARI = new C_KarifileKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HON, "HON", true);
        addPattern(PATTERN_DEFAULT, KARI, "KARI", false);


        lock(C_KarifileKbn.class);
    }

    private C_KarifileKbn(String value) {
        super(value);
    }

    public static C_KarifileKbn valueOf(String value) {
        return valueOf(C_KarifileKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KarifileKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KarifileKbn.class, patternId, value);
    }
}
