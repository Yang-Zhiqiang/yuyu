
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Siharaijyoutaikbn</td><td colspan="3">支払状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MBR}</td><td>&quot;1&quot;</td><td>未払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIZUMI}</td><td>&quot;2&quot;</td><td>支払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;3&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;4&quot;</td><td>時効</td></tr>
 * </table>
 */
public class C_Siharaijyoutaikbn extends Classification<C_Siharaijyoutaikbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Siharaijyoutaikbn BLNK = new C_Siharaijyoutaikbn("0");

    public static final C_Siharaijyoutaikbn MBR = new C_Siharaijyoutaikbn("1");

    public static final C_Siharaijyoutaikbn SIHARAIZUMI = new C_Siharaijyoutaikbn("2");

    public static final C_Siharaijyoutaikbn TORIKESI = new C_Siharaijyoutaikbn("3");

    public static final C_Siharaijyoutaikbn JIKOU = new C_Siharaijyoutaikbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MBR, "MBR", false);
        addPattern(PATTERN_DEFAULT, SIHARAIZUMI, "SIHARAIZUMI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);


        lock(C_Siharaijyoutaikbn.class);
    }

    private C_Siharaijyoutaikbn(String value) {
        super(value);
    }

    public static C_Siharaijyoutaikbn valueOf(String value) {
        return valueOf(C_Siharaijyoutaikbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Siharaijyoutaikbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Siharaijyoutaikbn.class, patternId, value);
    }
}
