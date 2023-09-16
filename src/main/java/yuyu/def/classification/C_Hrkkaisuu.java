
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 払込回数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hrkkaisuu</td><td colspan="3">払込回数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;1&quot;</td><td>月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;6&quot;</td><td>年２回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;12&quot;</td><td>年１回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;99&quot;</td><td>一時払い</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DISPKANAARI DISPKANAARI}<br />(表示用（送り仮名あり）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;1&quot;</td><td>月払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;6&quot;</td><td>年２回払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;12&quot;</td><td>年１回払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;99&quot;</td><td>一時払い</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DISPKANANASI DISPKANANASI}<br />(表示用（送り仮名なし）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;1&quot;</td><td>月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;6&quot;</td><td>年２回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;12&quot;</td><td>年１回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;99&quot;</td><td>一時払</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECTHEIJYUN SELECTHEIJYUN}<br />(選択（平準払）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;1&quot;</td><td>月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HALFY}</td><td>&quot;6&quot;</td><td>年２回払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;12&quot;</td><td>年１回払</td></tr>
 * </table>
 */
public class C_Hrkkaisuu extends Classification<C_Hrkkaisuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Hrkkaisuu BLNK = new C_Hrkkaisuu("0");

    public static final C_Hrkkaisuu TUKI = new C_Hrkkaisuu("1");

    public static final C_Hrkkaisuu HALFY = new C_Hrkkaisuu("6");

    public static final C_Hrkkaisuu NEN = new C_Hrkkaisuu("12");

    public static final C_Hrkkaisuu ITIJI = new C_Hrkkaisuu("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DISPKANAARI = "2";

    public static final String PATTERN_DISPKANANASI = "3";

    public static final String PATTERN_SELECTHEIJYUN = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);
        addPattern(PATTERN_DEFAULT, HALFY, "HALFY", false);
        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);


        addPattern(PATTERN_DISPKANAARI, BLNK, "BLNK", true);
        addPattern(PATTERN_DISPKANAARI, TUKI, "TUKI", false);
        addPattern(PATTERN_DISPKANAARI, HALFY, "HALFY", false);
        addPattern(PATTERN_DISPKANAARI, NEN, "NEN", false);
        addPattern(PATTERN_DISPKANAARI, ITIJI, "ITIJI", false);


        addPattern(PATTERN_DISPKANANASI, BLNK, "BLNK", true);
        addPattern(PATTERN_DISPKANANASI, TUKI, "TUKI", false);
        addPattern(PATTERN_DISPKANANASI, HALFY, "HALFY", false);
        addPattern(PATTERN_DISPKANANASI, NEN, "NEN", false);
        addPattern(PATTERN_DISPKANANASI, ITIJI, "ITIJI", false);


        addPattern(PATTERN_SELECTHEIJYUN, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECTHEIJYUN, TUKI, "TUKI", false);
        addPattern(PATTERN_SELECTHEIJYUN, HALFY, "HALFY", false);
        addPattern(PATTERN_SELECTHEIJYUN, NEN, "NEN", false);


        lock(C_Hrkkaisuu.class);
    }

    private C_Hrkkaisuu(String value) {
        super(value);
    }

    public static C_Hrkkaisuu valueOf(String value) {
        return valueOf(C_Hrkkaisuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hrkkaisuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hrkkaisuu.class, patternId, value);
    }
}
