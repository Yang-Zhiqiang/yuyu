
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択必須区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkhissuKbn</td><td colspan="3">選択必須区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NINI}</td><td>&quot;0&quot;</td><td>任意　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HISSU}</td><td>&quot;1&quot;</td><td>必須</td></tr>
 * </table>
 */
public class C_SntkhissuKbn extends Classification<C_SntkhissuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkhissuKbn NINI = new C_SntkhissuKbn("0");

    public static final C_SntkhissuKbn HISSU = new C_SntkhissuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NINI, "NINI", true);
        addPattern(PATTERN_DEFAULT, HISSU, "HISSU", false);


        lock(C_SntkhissuKbn.class);
    }

    private C_SntkhissuKbn(String value) {
        super(value);
    }

    public static C_SntkhissuKbn valueOf(String value) {
        return valueOf(C_SntkhissuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkhissuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkhissuKbn.class, patternId, value);
    }
}
