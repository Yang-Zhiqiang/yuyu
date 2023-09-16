
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 伝票用処理詳細区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DenSyorisyousaiKbn</td><td colspan="3">伝票用処理詳細区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHURIKAE_SIS}</td><td>&quot;1110&quot;</td><td>口座振替（ＳＩＳ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NET_KOUHURI_CSS}</td><td>&quot;1111&quot;</td><td>ネット口振（ＣＳＳ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;1120&quot;</td><td>クレジット</td></tr>
 * </table>
 */
public class C_DenSyorisyousaiKbn extends Classification<C_DenSyorisyousaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DenSyorisyousaiKbn BLNK = new C_DenSyorisyousaiKbn("0");

    public static final C_DenSyorisyousaiKbn KZHURIKAE_SIS = new C_DenSyorisyousaiKbn("1110");

    public static final C_DenSyorisyousaiKbn NET_KOUHURI_CSS = new C_DenSyorisyousaiKbn("1111");

    public static final C_DenSyorisyousaiKbn CREDIT = new C_DenSyorisyousaiKbn("1120");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KZHURIKAE_SIS, "KZHURIKAE_SIS", false);
        addPattern(PATTERN_DEFAULT, NET_KOUHURI_CSS, "NET_KOUHURI_CSS", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);


        lock(C_DenSyorisyousaiKbn.class);
    }

    private C_DenSyorisyousaiKbn(String value) {
        super(value);
    }

    public static C_DenSyorisyousaiKbn valueOf(String value) {
        return valueOf(C_DenSyorisyousaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DenSyorisyousaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DenSyorisyousaiKbn.class, patternId, value);
    }
}
