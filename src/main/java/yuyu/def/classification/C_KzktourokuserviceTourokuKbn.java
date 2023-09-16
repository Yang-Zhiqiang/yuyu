
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ご家族登録サービス登録区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzktourokuserviceTourokuKbn</td><td colspan="3">ご家族登録サービス登録区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>申し込む</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>申し込まない</td></tr>
 * </table>
 */
public class C_KzktourokuserviceTourokuKbn extends Classification<C_KzktourokuserviceTourokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzktourokuserviceTourokuKbn BLNK = new C_KzktourokuserviceTourokuKbn("0");

    public static final C_KzktourokuserviceTourokuKbn ARI = new C_KzktourokuserviceTourokuKbn("1");

    public static final C_KzktourokuserviceTourokuKbn NONE = new C_KzktourokuserviceTourokuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_KzktourokuserviceTourokuKbn.class);
    }

    private C_KzktourokuserviceTourokuKbn(String value) {
        super(value);
    }

    public static C_KzktourokuserviceTourokuKbn valueOf(String value) {
        return valueOf(C_KzktourokuserviceTourokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzktourokuserviceTourokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzktourokuserviceTourokuKbn.class, patternId, value);
    }
}
