
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 停止区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TeisiKbn</td><td colspan="3">停止区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NORMAL}</td><td>&quot;0&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;1&quot;</td><td>停止中</td></tr>
 * </table>
 */
public class C_TeisiKbn extends Classification<C_TeisiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TeisiKbn NORMAL = new C_TeisiKbn("0");

    public static final C_TeisiKbn TEISI = new C_TeisiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NORMAL, "NORMAL", true);
        addPattern(PATTERN_DEFAULT, TEISI, "TEISI", false);


        lock(C_TeisiKbn.class);
    }

    private C_TeisiKbn(String value) {
        super(value);
    }

    public static C_TeisiKbn valueOf(String value) {
        return valueOf(C_TeisiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TeisiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TeisiKbn.class, patternId, value);
    }
}
