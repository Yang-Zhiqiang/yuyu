
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不承諾通知送付先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HusyoudakuTuutiSouhusakiKbn</td><td colspan="3">不承諾通知送付先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KOKYAKUATE}</td><td>&quot;1&quot;</td><td>顧客宛て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENATE}</td><td>&quot;2&quot;</td><td>代理店宛て</td></tr>
 * </table>
 */
public class C_HusyoudakuTuutiSouhusakiKbn extends Classification<C_HusyoudakuTuutiSouhusakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HusyoudakuTuutiSouhusakiKbn KOKYAKUATE = new C_HusyoudakuTuutiSouhusakiKbn("1");

    public static final C_HusyoudakuTuutiSouhusakiKbn DAIRITENATE = new C_HusyoudakuTuutiSouhusakiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KOKYAKUATE, "KOKYAKUATE", true);
        addPattern(PATTERN_DEFAULT, DAIRITENATE, "DAIRITENATE", false);


        lock(C_HusyoudakuTuutiSouhusakiKbn.class);
    }

    private C_HusyoudakuTuutiSouhusakiKbn(String value) {
        super(value);
    }

    public static C_HusyoudakuTuutiSouhusakiKbn valueOf(String value) {
        return valueOf(C_HusyoudakuTuutiSouhusakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HusyoudakuTuutiSouhusakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HusyoudakuTuutiSouhusakiKbn.class, patternId, value);
    }
}
