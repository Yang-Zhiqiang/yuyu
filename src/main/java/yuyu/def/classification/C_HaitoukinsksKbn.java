
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当金作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitoukinsksKbn</td><td colspan="3">配当金作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIWARIATE1}</td><td>&quot;1&quot;</td><td>仮割当１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIWARIATE2}</td><td>&quot;2&quot;</td><td>仮割当２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIWARIATE3}</td><td>&quot;3&quot;</td><td>仮割当３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIWARIATE4}</td><td>&quot;4&quot;</td><td>仮割当４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIWARIATE5}</td><td>&quot;5&quot;</td><td>仮割当５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKKARIWARIATE}</td><td>&quot;6&quot;</td><td>円建変更時仮割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISIKI}</td><td>&quot;11&quot;</td><td>正式割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIDSIHARAI}</td><td>&quot;12&quot;</td><td>仮Ｄ支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKSEISIKI}</td><td>&quot;13&quot;</td><td>円建変更時正式割当</td></tr>
 * </table>
 */
public class C_HaitoukinsksKbn extends Classification<C_HaitoukinsksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitoukinsksKbn BLNK = new C_HaitoukinsksKbn("0");

    public static final C_HaitoukinsksKbn KARIWARIATE1 = new C_HaitoukinsksKbn("1");

    public static final C_HaitoukinsksKbn KARIWARIATE2 = new C_HaitoukinsksKbn("2");

    public static final C_HaitoukinsksKbn KARIWARIATE3 = new C_HaitoukinsksKbn("3");

    public static final C_HaitoukinsksKbn KARIWARIATE4 = new C_HaitoukinsksKbn("4");

    public static final C_HaitoukinsksKbn KARIWARIATE5 = new C_HaitoukinsksKbn("5");

    public static final C_HaitoukinsksKbn YENDTHNKKARIWARIATE = new C_HaitoukinsksKbn("6");

    public static final C_HaitoukinsksKbn SEISIKI = new C_HaitoukinsksKbn("11");

    public static final C_HaitoukinsksKbn KARIDSIHARAI = new C_HaitoukinsksKbn("12");

    public static final C_HaitoukinsksKbn YENDTHNKSEISIKI = new C_HaitoukinsksKbn("13");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KARIWARIATE1, "KARIWARIATE1", false);
        addPattern(PATTERN_DEFAULT, KARIWARIATE2, "KARIWARIATE2", false);
        addPattern(PATTERN_DEFAULT, KARIWARIATE3, "KARIWARIATE3", false);
        addPattern(PATTERN_DEFAULT, KARIWARIATE4, "KARIWARIATE4", false);
        addPattern(PATTERN_DEFAULT, KARIWARIATE5, "KARIWARIATE5", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKKARIWARIATE, "YENDTHNKKARIWARIATE", false);
        addPattern(PATTERN_DEFAULT, SEISIKI, "SEISIKI", false);
        addPattern(PATTERN_DEFAULT, KARIDSIHARAI, "KARIDSIHARAI", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKSEISIKI, "YENDTHNKSEISIKI", false);


        lock(C_HaitoukinsksKbn.class);
    }

    private C_HaitoukinsksKbn(String value) {
        super(value);
    }

    public static C_HaitoukinsksKbn valueOf(String value) {
        return valueOf(C_HaitoukinsksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitoukinsksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitoukinsksKbn.class, patternId, value);
    }
}
