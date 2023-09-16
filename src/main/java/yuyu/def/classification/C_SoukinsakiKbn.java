
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送金先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SoukinsakiKbn</td><td colspan="3">送金先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHURIKZ}</td><td>&quot;1&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHURIKZIGAI}</td><td>&quot;2&quot;</td><td>保険料振替口座以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKSHRKZ}</td><td>&quot;3&quot;</td><td>定期支払金支払口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKSHRKZIGAI}</td><td>&quot;4&quot;</td><td>定期支払金支払口座以外</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PHURIKZ}</td><td>&quot;1&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_HK HK}<br />(保険金給付金支払用)</td><td align="center">&nbsp;</td><td>{@link #PHURIKZ}</td><td>&quot;1&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td align="center">○</td><td>{@link #PHURIKZIGAI}</td><td>&quot;2&quot;</td><td>保険料振替口座以外</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KH KH}<br />(契約保全用)</td><td align="center">○</td><td>{@link #PHURIKZ}</td><td>&quot;1&quot;</td><td>保険料振替口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>保険料振替口座以外</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_KHPHURIKZIGAI KHPHURIKZIGAI}<br />(契約保全用保険料振替口座以外のみ)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>保険料振替口座以外</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT_TKSHKSHRKZ SELECT_TKSHKSHRKZ}<br />(選択（定期支払金支払口座）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKSHRKZ}</td><td>&quot;3&quot;</td><td>定期支払金支払口座</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KH_TKSHKSHRKZ KH_TKSHKSHRKZ}<br />(契約保全用（定期支払金支払口座）)</td><td align="center">○</td><td>{@link #TKSHKSHRKZ}</td><td>&quot;3&quot;</td><td>定期支払金支払口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>定期支払金支払口座以外</td></tr>
 * </table>
 */
public class C_SoukinsakiKbn extends Classification<C_SoukinsakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SoukinsakiKbn BLNK = new C_SoukinsakiKbn("0");

    public static final C_SoukinsakiKbn PHURIKZ = new C_SoukinsakiKbn("1");

    public static final C_SoukinsakiKbn PHURIKZIGAI = new C_SoukinsakiKbn("2");

    public static final C_SoukinsakiKbn TKSHKSHRKZ = new C_SoukinsakiKbn("3");

    public static final C_SoukinsakiKbn TKSHKSHRKZIGAI = new C_SoukinsakiKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_HK = "3";

    public static final String PATTERN_KH = "4";

    public static final String PATTERN_KHPHURIKZIGAI = "5";

    public static final String PATTERN_SELECT_TKSHKSHRKZ = "6";

    public static final String PATTERN_KH_TKSHKSHRKZ = "7";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PHURIKZ, "PHURIKZ", false);
        addPattern(PATTERN_DEFAULT, PHURIKZIGAI, "PHURIKZIGAI", false);
        addPattern(PATTERN_DEFAULT, TKSHKSHRKZ, "TKSHKSHRKZ", false);
        addPattern(PATTERN_DEFAULT, TKSHKSHRKZIGAI, "TKSHKSHRKZIGAI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, PHURIKZ, "PHURIKZ", false);


        addPattern(PATTERN_HK, PHURIKZ, "PHURIKZ", false);
        addPattern(PATTERN_HK, PHURIKZIGAI, "PHURIKZIGAI", true);


        addPattern(PATTERN_KH, PHURIKZ, "PHURIKZ", true);
        addPattern(PATTERN_KH, BLNK, "BLNK", false);


        addPattern(PATTERN_KHPHURIKZIGAI, BLNK, "BLNK", true);


        addPattern(PATTERN_SELECT_TKSHKSHRKZ, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT_TKSHKSHRKZ, TKSHKSHRKZ, "TKSHKSHRKZ", false);


        addPattern(PATTERN_KH_TKSHKSHRKZ, TKSHKSHRKZ, "TKSHKSHRKZ", true);
        addPattern(PATTERN_KH_TKSHKSHRKZ, BLNK, "BLNK", false);


        lock(C_SoukinsakiKbn.class);
    }

    private C_SoukinsakiKbn(String value) {
        super(value);
    }

    public static C_SoukinsakiKbn valueOf(String value) {
        return valueOf(C_SoukinsakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SoukinsakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SoukinsakiKbn.class, patternId, value);
    }
}
