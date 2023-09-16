
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 構成員契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouseiinkykKbn</td><td colspan="3">構成員契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOUNASI}</td><td>&quot;1&quot;</td><td>該当なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KOUSEIIN}</td><td>&quot;2&quot;</td><td>被保険者＝構成員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT_KOUSEIIN}</td><td>&quot;3&quot;</td><td>死亡受取人＝構成員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANY_DAIRITENSYOKUIN}</td><td>&quot;4&quot;</td><td>マル契、マル被、マル受のいずれかが、代理店職員の家族または代理店職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSK_BOSYUU}</td><td>&quot;5&quot;</td><td>指定代理請求人＝募集人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT_STDRSK}</td><td>&quot;6&quot;</td><td>死亡受取人＝指定代理請求人＝募集人</td></tr>
 * </table>
 */
public class C_KouseiinkykKbn extends Classification<C_KouseiinkykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouseiinkykKbn BLNK = new C_KouseiinkykKbn("0");

    public static final C_KouseiinkykKbn GAITOUNASI = new C_KouseiinkykKbn("1");

    public static final C_KouseiinkykKbn HHKN_KOUSEIIN = new C_KouseiinkykKbn("2");

    public static final C_KouseiinkykKbn SBUKT_KOUSEIIN = new C_KouseiinkykKbn("3");

    public static final C_KouseiinkykKbn ANY_DAIRITENSYOKUIN = new C_KouseiinkykKbn("4");

    public static final C_KouseiinkykKbn STDRSK_BOSYUU = new C_KouseiinkykKbn("5");

    public static final C_KouseiinkykKbn SBUKT_STDRSK = new C_KouseiinkykKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAITOUNASI, "GAITOUNASI", false);
        addPattern(PATTERN_DEFAULT, HHKN_KOUSEIIN, "HHKN_KOUSEIIN", false);
        addPattern(PATTERN_DEFAULT, SBUKT_KOUSEIIN, "SBUKT_KOUSEIIN", false);
        addPattern(PATTERN_DEFAULT, ANY_DAIRITENSYOKUIN, "ANY_DAIRITENSYOKUIN", false);
        addPattern(PATTERN_DEFAULT, STDRSK_BOSYUU, "STDRSK_BOSYUU", false);
        addPattern(PATTERN_DEFAULT, SBUKT_STDRSK, "SBUKT_STDRSK", false);


        lock(C_KouseiinkykKbn.class);
    }

    private C_KouseiinkykKbn(String value) {
        super(value);
    }

    public static C_KouseiinkykKbn valueOf(String value) {
        return valueOf(C_KouseiinkykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouseiinkykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouseiinkykKbn.class, patternId, value);
    }
}
