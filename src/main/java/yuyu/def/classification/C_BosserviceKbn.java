
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集使用サービス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosserviceKbn</td><td colspan="3">募集使用サービス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUU}</td><td>&quot;1&quot;</td><td>募集サービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MDHN}</td><td>&quot;2&quot;</td><td>窓販サービス</td></tr>
 * </table>
 */
public class C_BosserviceKbn extends Classification<C_BosserviceKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosserviceKbn BLNK = new C_BosserviceKbn("0");

    public static final C_BosserviceKbn BOSYUU = new C_BosserviceKbn("1");

    public static final C_BosserviceKbn MDHN = new C_BosserviceKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYUU, "BOSYUU", false);
        addPattern(PATTERN_DEFAULT, MDHN, "MDHN", false);


        lock(C_BosserviceKbn.class);
    }

    private C_BosserviceKbn(String value) {
        super(value);
    }

    public static C_BosserviceKbn valueOf(String value) {
        return valueOf(C_BosserviceKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosserviceKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosserviceKbn.class, patternId, value);
    }
}
