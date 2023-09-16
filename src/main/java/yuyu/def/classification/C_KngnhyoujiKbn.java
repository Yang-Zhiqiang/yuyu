
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 権限表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KngnhyoujiKbn</td><td colspan="3">権限表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>表示無</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>表示有</td></tr>
 * </table>
 */
public class C_KngnhyoujiKbn extends Classification<C_KngnhyoujiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KngnhyoujiKbn NONE = new C_KngnhyoujiKbn("0");

    public static final C_KngnhyoujiKbn ARI = new C_KngnhyoujiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_KngnhyoujiKbn.class);
    }

    private C_KngnhyoujiKbn(String value) {
        super(value);
    }

    public static C_KngnhyoujiKbn valueOf(String value) {
        return valueOf(C_KngnhyoujiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KngnhyoujiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KngnhyoujiKbn.class, patternId, value);
    }
}
