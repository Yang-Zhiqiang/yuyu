
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrkriyuuKbn</td><td colspan="3">登録理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEISATEI}</td><td>&quot;1&quot;</td><td>新契約査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINKEKKA}</td><td>&quot;2&quot;</td><td>契約確認結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUSATEI}</td><td>&quot;3&quot;</td><td>復活査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRSATEI}</td><td>&quot;4&quot;</td><td>支払査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FREEINSURANCE}</td><td>&quot;5&quot;</td><td>フリーインシュアランス該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIRISKTORIHIKI}</td><td>&quot;6&quot;</td><td>ハイリスク取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #SKEISATEI}</td><td>&quot;1&quot;</td><td>新契約査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINKEKKA}</td><td>&quot;2&quot;</td><td>契約確認結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUSATEI}</td><td>&quot;3&quot;</td><td>復活査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRSATEI}</td><td>&quot;4&quot;</td><td>支払査定時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FREEINSURANCE}</td><td>&quot;5&quot;</td><td>フリーインシュアランス該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIRISKTORIHIKI}</td><td>&quot;6&quot;</td><td>ハイリスク取引</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_TrkriyuuKbn extends Classification<C_TrkriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrkriyuuKbn BLNK = new C_TrkriyuuKbn("0");

    public static final C_TrkriyuuKbn SKEISATEI = new C_TrkriyuuKbn("1");

    public static final C_TrkriyuuKbn KYKKAKUNINKEKKA = new C_TrkriyuuKbn("2");

    public static final C_TrkriyuuKbn HUKKATUSATEI = new C_TrkriyuuKbn("3");

    public static final C_TrkriyuuKbn SHRSATEI = new C_TrkriyuuKbn("4");

    public static final C_TrkriyuuKbn FREEINSURANCE = new C_TrkriyuuKbn("5");

    public static final C_TrkriyuuKbn HIRISKTORIHIKI = new C_TrkriyuuKbn("6");

    public static final C_TrkriyuuKbn SONOTA = new C_TrkriyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEISATEI, "SKEISATEI", false);
        addPattern(PATTERN_DEFAULT, KYKKAKUNINKEKKA, "KYKKAKUNINKEKKA", false);
        addPattern(PATTERN_DEFAULT, HUKKATUSATEI, "HUKKATUSATEI", false);
        addPattern(PATTERN_DEFAULT, SHRSATEI, "SHRSATEI", false);
        addPattern(PATTERN_DEFAULT, FREEINSURANCE, "FREEINSURANCE", false);
        addPattern(PATTERN_DEFAULT, HIRISKTORIHIKI, "HIRISKTORIHIKI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_NOBLNK, SKEISATEI, "SKEISATEI", false);
        addPattern(PATTERN_NOBLNK, KYKKAKUNINKEKKA, "KYKKAKUNINKEKKA", false);
        addPattern(PATTERN_NOBLNK, HUKKATUSATEI, "HUKKATUSATEI", false);
        addPattern(PATTERN_NOBLNK, SHRSATEI, "SHRSATEI", false);
        addPattern(PATTERN_NOBLNK, FREEINSURANCE, "FREEINSURANCE", false);
        addPattern(PATTERN_NOBLNK, HIRISKTORIHIKI, "HIRISKTORIHIKI", false);
        addPattern(PATTERN_NOBLNK, SONOTA, "SONOTA", false);


        lock(C_TrkriyuuKbn.class);
    }

    private C_TrkriyuuKbn(String value) {
        super(value);
    }

    public static C_TrkriyuuKbn valueOf(String value) {
        return valueOf(C_TrkriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrkriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrkriyuuKbn.class, patternId, value);
    }
}
