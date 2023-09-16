
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通貨種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tuukasyu</td><td colspan="3">通貨種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPY}</td><td>&quot;JPY&quot;</td><td>円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;USD&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EUR}</td><td>&quot;EUR&quot;</td><td>ユーロ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;AUD&quot;</td><td>豪ドル</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #JPY}</td><td>&quot;JPY&quot;</td><td>円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;USD&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EUR}</td><td>&quot;EUR&quot;</td><td>ユーロ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;AUD&quot;</td><td>豪ドル</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_GAIKA GAIKA}<br />(外貨)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;USD&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;AUD&quot;</td><td>豪ドル</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNKGAIKA NOBLNKGAIKA}<br />(外貨（ブランクなし）)</td><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;USD&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;AUD&quot;</td><td>豪ドル</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPY}</td><td>&quot;JPY&quot;</td><td>円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;USD&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;AUD&quot;</td><td>豪ドル</td></tr>
 * </table>
 */
public class C_Tuukasyu extends Classification<C_Tuukasyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Tuukasyu BLNK = new C_Tuukasyu("0");

    public static final C_Tuukasyu JPY = new C_Tuukasyu("JPY");

    public static final C_Tuukasyu USD = new C_Tuukasyu("USD");

    public static final C_Tuukasyu EUR = new C_Tuukasyu("EUR");

    public static final C_Tuukasyu AUD = new C_Tuukasyu("AUD");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_GAIKA = "3";

    public static final String PATTERN_NOBLNKGAIKA = "4";

    public static final String PATTERN_SELECT = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JPY, "JPY", false);
        addPattern(PATTERN_DEFAULT, USD, "USD", false);
        addPattern(PATTERN_DEFAULT, EUR, "EUR", false);
        addPattern(PATTERN_DEFAULT, AUD, "AUD", false);


        addPattern(PATTERN_NOBLNK, JPY, "JPY", false);
        addPattern(PATTERN_NOBLNK, USD, "USD", false);
        addPattern(PATTERN_NOBLNK, EUR, "EUR", false);
        addPattern(PATTERN_NOBLNK, AUD, "AUD", false);


        addPattern(PATTERN_GAIKA, BLNK, "BLNK", true);
        addPattern(PATTERN_GAIKA, USD, "USD", false);
        addPattern(PATTERN_GAIKA, AUD, "AUD", false);


        addPattern(PATTERN_NOBLNKGAIKA, USD, "USD", false);
        addPattern(PATTERN_NOBLNKGAIKA, AUD, "AUD", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, JPY, "JPY", false);
        addPattern(PATTERN_SELECT, USD, "USD", false);
        addPattern(PATTERN_SELECT, AUD, "AUD", false);


        lock(C_Tuukasyu.class);
    }

    private C_Tuukasyu(String value) {
        super(value);
    }

    public static C_Tuukasyu valueOf(String value) {
        return valueOf(C_Tuukasyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tuukasyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tuukasyu.class, patternId, value);
    }
}
