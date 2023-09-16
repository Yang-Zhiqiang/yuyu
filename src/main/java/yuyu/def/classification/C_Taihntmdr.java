
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 体格判定戻り値 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Taihntmdr</td><td colspan="3">体格判定戻り値</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #CHK_NONE}</td><td>&quot;0&quot;</td><td>未チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NORMAL}</td><td>&quot;1&quot;</td><td>普通体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAJYUU}</td><td>&quot;2&quot;</td><td>過重体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKEI}</td><td>&quot;3&quot;</td><td>過軽体</td></tr>
 * </table>
 */
public class C_Taihntmdr extends Classification<C_Taihntmdr> {

    private static final long serialVersionUID = 1L;


    public static final C_Taihntmdr CHK_NONE = new C_Taihntmdr("0");

    public static final C_Taihntmdr NORMAL = new C_Taihntmdr("1");

    public static final C_Taihntmdr KAJYUU = new C_Taihntmdr("2");

    public static final C_Taihntmdr KAKEI = new C_Taihntmdr("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, CHK_NONE, "CHK_NONE", true);
        addPattern(PATTERN_DEFAULT, NORMAL, "NORMAL", false);
        addPattern(PATTERN_DEFAULT, KAJYUU, "KAJYUU", false);
        addPattern(PATTERN_DEFAULT, KAKEI, "KAKEI", false);


        lock(C_Taihntmdr.class);
    }

    private C_Taihntmdr(String value) {
        super(value);
    }

    public static C_Taihntmdr valueOf(String value) {
        return valueOf(C_Taihntmdr.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Taihntmdr.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Taihntmdr.class, patternId, value);
    }
}
