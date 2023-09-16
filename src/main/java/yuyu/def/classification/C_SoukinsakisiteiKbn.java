
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送金先指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SoukinsakisiteiKbn</td><td colspan="3">送金先指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSOUZOKUNIN}</td><td>&quot;2&quot;</td><td>契約者相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SoukinsakisiteiKbn extends Classification<C_SoukinsakisiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SoukinsakisiteiKbn BLNK = new C_SoukinsakisiteiKbn("0");

    public static final C_SoukinsakisiteiKbn KYK = new C_SoukinsakisiteiKbn("1");

    public static final C_SoukinsakisiteiKbn KYKSOUZOKUNIN = new C_SoukinsakisiteiKbn("2");

    public static final C_SoukinsakisiteiKbn SONOTA = new C_SoukinsakisiteiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, KYKSOUZOKUNIN, "KYKSOUZOKUNIN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SoukinsakisiteiKbn.class);
    }

    private C_SoukinsakisiteiKbn(String value) {
        super(value);
    }

    public static C_SoukinsakisiteiKbn valueOf(String value) {
        return valueOf(C_SoukinsakisiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SoukinsakisiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SoukinsakisiteiKbn.class, patternId, value);
    }
}
