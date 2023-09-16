
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送付先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SouhusakiKbn</td><td colspan="3">送付先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TDADD}</td><td>&quot;1&quot;</td><td>届出住所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDADDIGAI}</td><td>&quot;2&quot;</td><td>届出住所以外</td></tr>
 * </table>
 */
public class C_SouhusakiKbn extends Classification<C_SouhusakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SouhusakiKbn TDADD = new C_SouhusakiKbn("1");

    public static final C_SouhusakiKbn TDADDIGAI = new C_SouhusakiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TDADD, "TDADD", true);
        addPattern(PATTERN_DEFAULT, TDADDIGAI, "TDADDIGAI", false);


        lock(C_SouhusakiKbn.class);
    }

    private C_SouhusakiKbn(String value) {
        super(value);
    }

    public static C_SouhusakiKbn valueOf(String value) {
        return valueOf(C_SouhusakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SouhusakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SouhusakiKbn.class, patternId, value);
    }
}
