
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 災害割増不支払原因区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SghshrgeninKbn</td><td colspan="3">災害割増不支払原因区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;1&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKS_KOI}</td><td>&quot;2&quot;</td><td>契約者の故意・重過失</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KOI}</td><td>&quot;3&quot;</td><td>被保険者の故意・重過失</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUKE_KOI}</td><td>&quot;4&quot;</td><td>保険金受取人の故意・重過失</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_HANZAI}</td><td>&quot;5&quot;</td><td>被保険者の犯罪行為</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTIH}</td><td>&quot;6&quot;</td><td>告知義務違反</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JD}</td><td>&quot;7&quot;</td><td>重大事由解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他免責事由該当</td></tr>
 * </table>
 */
public class C_SghshrgeninKbn extends Classification<C_SghshrgeninKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SghshrgeninKbn BLNK = new C_SghshrgeninKbn("0");

    public static final C_SghshrgeninKbn HG = new C_SghshrgeninKbn("1");

    public static final C_SghshrgeninKbn KYKS_KOI = new C_SghshrgeninKbn("2");

    public static final C_SghshrgeninKbn HHKN_KOI = new C_SghshrgeninKbn("3");

    public static final C_SghshrgeninKbn SUKE_KOI = new C_SghshrgeninKbn("4");

    public static final C_SghshrgeninKbn HHKN_HANZAI = new C_SghshrgeninKbn("5");

    public static final C_SghshrgeninKbn KKTIH = new C_SghshrgeninKbn("6");

    public static final C_SghshrgeninKbn JD = new C_SghshrgeninKbn("7");

    public static final C_SghshrgeninKbn SONOTA = new C_SghshrgeninKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HG, "HG", false);
        addPattern(PATTERN_DEFAULT, KYKS_KOI, "KYKS_KOI", false);
        addPattern(PATTERN_DEFAULT, HHKN_KOI, "HHKN_KOI", false);
        addPattern(PATTERN_DEFAULT, SUKE_KOI, "SUKE_KOI", false);
        addPattern(PATTERN_DEFAULT, HHKN_HANZAI, "HHKN_HANZAI", false);
        addPattern(PATTERN_DEFAULT, KKTIH, "KKTIH", false);
        addPattern(PATTERN_DEFAULT, JD, "JD", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SghshrgeninKbn.class);
    }

    private C_SghshrgeninKbn(String value) {
        super(value);
    }

    public static C_SghshrgeninKbn valueOf(String value) {
        return valueOf(C_SghshrgeninKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SghshrgeninKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SghshrgeninKbn.class, patternId, value);
    }
}
