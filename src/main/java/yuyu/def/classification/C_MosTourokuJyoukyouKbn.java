
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込情報登録状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosTourokuJyoukyouKbn</td><td colspan="3">申込情報登録状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MITOUROKU}</td><td>&quot;0&quot;</td><td>未登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUZUMI}</td><td>&quot;1&quot;</td><td>登録済</td></tr>
 * </table>
 */
public class C_MosTourokuJyoukyouKbn extends Classification<C_MosTourokuJyoukyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosTourokuJyoukyouKbn MITOUROKU = new C_MosTourokuJyoukyouKbn("0");

    public static final C_MosTourokuJyoukyouKbn TOUROKUZUMI = new C_MosTourokuJyoukyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MITOUROKU, "MITOUROKU", true);
        addPattern(PATTERN_DEFAULT, TOUROKUZUMI, "TOUROKUZUMI", false);


        lock(C_MosTourokuJyoukyouKbn.class);
    }

    private C_MosTourokuJyoukyouKbn(String value) {
        super(value);
    }

    public static C_MosTourokuJyoukyouKbn valueOf(String value) {
        return valueOf(C_MosTourokuJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosTourokuJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosTourokuJyoukyouKbn.class, patternId, value);
    }
}
