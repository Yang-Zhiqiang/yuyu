
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 無効表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MukouHyj</td><td colspan="3">無効表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;1&quot;</td><td>無効</td></tr>
 * </table>
 */
public class C_MukouHyj extends Classification<C_MukouHyj> {

    private static final long serialVersionUID = 1L;


    public static final C_MukouHyj BLANK = new C_MukouHyj("0");

    public static final C_MukouHyj MUKOU = new C_MukouHyj("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);


        lock(C_MukouHyj.class);
    }

    private C_MukouHyj(String value) {
        super(value);
    }

    public static C_MukouHyj valueOf(String value) {
        return valueOf(C_MukouHyj.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MukouHyj.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MukouHyj.class, patternId, value);
    }
}
