
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報設定対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkinfosettaisyoKbn</td><td colspan="3">選択情報設定対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SITEINASI}</td><td>&quot;0&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHK}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 * </table>
 */
public class C_SntkinfosettaisyoKbn extends Classification<C_SntkinfosettaisyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkinfosettaisyoKbn SITEINASI = new C_SntkinfosettaisyoKbn("0");

    public static final C_SntkinfosettaisyoKbn KYK = new C_SntkinfosettaisyoKbn("1");

    public static final C_SntkinfosettaisyoKbn HHK = new C_SntkinfosettaisyoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEINASI, "SITEINASI", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHK, "HHK", false);


        lock(C_SntkinfosettaisyoKbn.class);
    }

    private C_SntkinfosettaisyoKbn(String value) {
        super(value);
    }

    public static C_SntkinfosettaisyoKbn valueOf(String value) {
        return valueOf(C_SntkinfosettaisyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkinfosettaisyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkinfosettaisyoKbn.class, patternId, value);
    }
}
