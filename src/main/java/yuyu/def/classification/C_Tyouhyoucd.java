
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tyouhyoucd</td><td colspan="3">帳票コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKKR}</td><td>&quot;1&quot;</td><td>ｱXX</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNSYKN}</td><td>&quot;2&quot;</td><td>ｱXX</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURIKAISIANNAI}</td><td>&quot;3&quot;</td><td>ｱ01</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURIMINYUUTUUTI}</td><td>&quot;4&quot;</td><td>ｱ02</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOUTUUTI}</td><td>&quot;5&quot;</td><td>ｱ03</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEIS}</td><td>&quot;6&quot;</td><td>ｲ01</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJITUTOURAIANNAI}</td><td>&quot;7&quot;</td><td>ｱ04</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKOKUYOKOKUTUUTI}</td><td>&quot;8&quot;</td><td>ｱ05</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIPNYKNKANSYOUTUUTI}</td><td>&quot;9&quot;</td><td>ｱ06</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOUTUUTI}</td><td>&quot;10&quot;</td><td>ｱ07</td></tr>
 * </table>
 */
public class C_Tyouhyoucd extends Classification<C_Tyouhyoucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Tyouhyoucd BLNK = new C_Tyouhyoucd("0");

    public static final C_Tyouhyoucd TTDKKR = new C_Tyouhyoucd("1");

    public static final C_Tyouhyoucd HKNSYKN = new C_Tyouhyoucd("2");

    public static final C_Tyouhyoucd KOUHURIKAISIANNAI = new C_Tyouhyoucd("3");

    public static final C_Tyouhyoucd KOUHURIMINYUUTUUTI = new C_Tyouhyoucd("4");

    public static final C_Tyouhyoucd SIKKOUTUUTI = new C_Tyouhyoucd("5");

    public static final C_Tyouhyoucd KOUJYOSYOUMEIS = new C_Tyouhyoucd("6");

    public static final C_Tyouhyoucd KIJITUTOURAIANNAI = new C_Tyouhyoucd("7");

    public static final C_Tyouhyoucd SINKOKUYOKOKUTUUTI = new C_Tyouhyoucd("8");

    public static final C_Tyouhyoucd ITIPNYKNKANSYOUTUUTI = new C_Tyouhyoucd("9");

    public static final C_Tyouhyoucd MUKOUTUUTI = new C_Tyouhyoucd("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TTDKKR, "TTDKKR", false);
        addPattern(PATTERN_DEFAULT, HKNSYKN, "HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, KOUHURIKAISIANNAI, "KOUHURIKAISIANNAI", false);
        addPattern(PATTERN_DEFAULT, KOUHURIMINYUUTUUTI, "KOUHURIMINYUUTUUTI", false);
        addPattern(PATTERN_DEFAULT, SIKKOUTUUTI, "SIKKOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEIS, "KOUJYOSYOUMEIS", false);
        addPattern(PATTERN_DEFAULT, KIJITUTOURAIANNAI, "KIJITUTOURAIANNAI", false);
        addPattern(PATTERN_DEFAULT, SINKOKUYOKOKUTUUTI, "SINKOKUYOKOKUTUUTI", false);
        addPattern(PATTERN_DEFAULT, ITIPNYKNKANSYOUTUUTI, "ITIPNYKNKANSYOUTUUTI", false);
        addPattern(PATTERN_DEFAULT, MUKOUTUUTI, "MUKOUTUUTI", false);


        lock(C_Tyouhyoucd.class);
    }

    private C_Tyouhyoucd(String value) {
        super(value);
    }

    public static C_Tyouhyoucd valueOf(String value) {
        return valueOf(C_Tyouhyoucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tyouhyoucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tyouhyoucd.class, patternId, value);
    }
}
