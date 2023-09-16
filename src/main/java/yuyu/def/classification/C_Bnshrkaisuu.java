
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分割支払回数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Bnshrkaisuu</td><td colspan="3">分割支払回数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN12KAI}</td><td>&quot;1&quot;</td><td>年１２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN6KAI}</td><td>&quot;2&quot;</td><td>年６回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN4KAI}</td><td>&quot;3&quot;</td><td>年４回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN3KAI}</td><td>&quot;4&quot;</td><td>年３回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN2KAI}</td><td>&quot;6&quot;</td><td>年２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN1KAI}</td><td>&quot;12&quot;</td><td>年１回</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN1KAI}</td><td>&quot;12&quot;</td><td>年１回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN2KAI}</td><td>&quot;6&quot;</td><td>年２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN4KAI}</td><td>&quot;3&quot;</td><td>年４回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN6KAI}</td><td>&quot;2&quot;</td><td>年６回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN12KAI}</td><td>&quot;1&quot;</td><td>年１２回</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">&nbsp;</td><td>{@link #NEN12KAI}</td><td>&quot;1&quot;</td><td>年１２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN6KAI}</td><td>&quot;2&quot;</td><td>年６回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN4KAI}</td><td>&quot;3&quot;</td><td>年４回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN2KAI}</td><td>&quot;6&quot;</td><td>年２回</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN1KAI}</td><td>&quot;12&quot;</td><td>年１回</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_NKSYOUSYO NKSYOUSYO}<br />(年金証書)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN1KAI}</td><td>&quot;12&quot;</td><td>年１回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN2KAI}</td><td>&quot;6&quot;</td><td>年２回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN4KAI}</td><td>&quot;3&quot;</td><td>年４回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN6KAI}</td><td>&quot;2&quot;</td><td>年６回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN12KAI}</td><td>&quot;1&quot;</td><td>年１２回払</td></tr>
 * </table>
 */
public class C_Bnshrkaisuu extends Classification<C_Bnshrkaisuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Bnshrkaisuu BLNK = new C_Bnshrkaisuu("0");

    public static final C_Bnshrkaisuu NEN12KAI = new C_Bnshrkaisuu("1");

    public static final C_Bnshrkaisuu NEN6KAI = new C_Bnshrkaisuu("2");

    public static final C_Bnshrkaisuu NEN4KAI = new C_Bnshrkaisuu("3");

    public static final C_Bnshrkaisuu NEN3KAI = new C_Bnshrkaisuu("4");

    public static final C_Bnshrkaisuu NEN2KAI = new C_Bnshrkaisuu("6");

    public static final C_Bnshrkaisuu NEN1KAI = new C_Bnshrkaisuu("12");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_TORIKOMI = "3";

    public static final String PATTERN_NKSYOUSYO = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NEN12KAI, "NEN12KAI", false);
        addPattern(PATTERN_DEFAULT, NEN6KAI, "NEN6KAI", false);
        addPattern(PATTERN_DEFAULT, NEN4KAI, "NEN4KAI", false);
        addPattern(PATTERN_DEFAULT, NEN3KAI, "NEN3KAI", false);
        addPattern(PATTERN_DEFAULT, NEN2KAI, "NEN2KAI", false);
        addPattern(PATTERN_DEFAULT, NEN1KAI, "NEN1KAI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, NEN1KAI, "NEN1KAI", false);
        addPattern(PATTERN_SELECT, NEN2KAI, "NEN2KAI", false);
        addPattern(PATTERN_SELECT, NEN4KAI, "NEN4KAI", false);
        addPattern(PATTERN_SELECT, NEN6KAI, "NEN6KAI", false);
        addPattern(PATTERN_SELECT, NEN12KAI, "NEN12KAI", false);


        addPattern(PATTERN_TORIKOMI, NEN12KAI, "NEN12KAI", false);
        addPattern(PATTERN_TORIKOMI, NEN6KAI, "NEN6KAI", false);
        addPattern(PATTERN_TORIKOMI, NEN4KAI, "NEN4KAI", false);
        addPattern(PATTERN_TORIKOMI, NEN2KAI, "NEN2KAI", false);
        addPattern(PATTERN_TORIKOMI, NEN1KAI, "NEN1KAI", false);


        addPattern(PATTERN_NKSYOUSYO, BLNK, "BLNK", true);
        addPattern(PATTERN_NKSYOUSYO, NEN1KAI, "NEN1KAI", false);
        addPattern(PATTERN_NKSYOUSYO, NEN2KAI, "NEN2KAI", false);
        addPattern(PATTERN_NKSYOUSYO, NEN4KAI, "NEN4KAI", false);
        addPattern(PATTERN_NKSYOUSYO, NEN6KAI, "NEN6KAI", false);
        addPattern(PATTERN_NKSYOUSYO, NEN12KAI, "NEN12KAI", false);


        lock(C_Bnshrkaisuu.class);
    }

    private C_Bnshrkaisuu(String value) {
        super(value);
    }

    public static C_Bnshrkaisuu valueOf(String value) {
        return valueOf(C_Bnshrkaisuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Bnshrkaisuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Bnshrkaisuu.class, patternId, value);
    }
}
