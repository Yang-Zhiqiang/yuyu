
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 交換契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoukankykKbn</td><td colspan="3">交換契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOUNASI}</td><td>&quot;1&quot;</td><td>該当なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOUKENENARI}</td><td>&quot;2&quot;</td><td>該当懸念あり</td></tr>
 * </table>
 */
public class C_KoukankykKbn extends Classification<C_KoukankykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoukankykKbn BLNK = new C_KoukankykKbn("0");

    public static final C_KoukankykKbn GAITOUNASI = new C_KoukankykKbn("1");

    public static final C_KoukankykKbn GAITOUKENENARI = new C_KoukankykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAITOUNASI, "GAITOUNASI", false);
        addPattern(PATTERN_DEFAULT, GAITOUKENENARI, "GAITOUKENENARI", false);


        lock(C_KoukankykKbn.class);
    }

    private C_KoukankykKbn(String value) {
        super(value);
    }

    public static C_KoukankykKbn valueOf(String value) {
        return valueOf(C_KoukankykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoukankykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoukankykKbn.class, patternId, value);
    }
}
