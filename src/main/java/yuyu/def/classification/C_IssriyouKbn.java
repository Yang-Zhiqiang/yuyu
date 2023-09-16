
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＩＳＳ利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IssriyouKbn</td><td colspan="3">ＩＳＳ利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>利用なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>利用あり</td></tr>
 * </table>
 */
public class C_IssriyouKbn extends Classification<C_IssriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IssriyouKbn NONE = new C_IssriyouKbn("0");

    public static final C_IssriyouKbn ARI = new C_IssriyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_IssriyouKbn.class);
    }

    private C_IssriyouKbn(String value) {
        super(value);
    }

    public static C_IssriyouKbn valueOf(String value) {
        return valueOf(C_IssriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IssriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IssriyouKbn.class, patternId, value);
    }
}
