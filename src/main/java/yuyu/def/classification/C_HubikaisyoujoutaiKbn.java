
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備解消状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HubikaisyoujoutaiKbn</td><td colspan="3">不備解消状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAITOUMATI}</td><td>&quot;1&quot;</td><td>不備回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOUMATI}</td><td>&quot;2&quot;</td><td>不備解消待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOUZUMI}</td><td>&quot;3&quot;</td><td>不備解消済</td></tr>
 * </table>
 */
public class C_HubikaisyoujoutaiKbn extends Classification<C_HubikaisyoujoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HubikaisyoujoutaiKbn BLNK = new C_HubikaisyoujoutaiKbn("0");

    public static final C_HubikaisyoujoutaiKbn HUBIKAITOUMATI = new C_HubikaisyoujoutaiKbn("1");

    public static final C_HubikaisyoujoutaiKbn HUBIKAISYOUMATI = new C_HubikaisyoujoutaiKbn("2");

    public static final C_HubikaisyoujoutaiKbn HUBIKAISYOUZUMI = new C_HubikaisyoujoutaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUBIKAITOUMATI, "HUBIKAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOUMATI, "HUBIKAISYOUMATI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOUZUMI, "HUBIKAISYOUZUMI", false);


        lock(C_HubikaisyoujoutaiKbn.class);
    }

    private C_HubikaisyoujoutaiKbn(String value) {
        super(value);
    }

    public static C_HubikaisyoujoutaiKbn valueOf(String value) {
        return valueOf(C_HubikaisyoujoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HubikaisyoujoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HubikaisyoujoutaiKbn.class, patternId, value);
    }
}
