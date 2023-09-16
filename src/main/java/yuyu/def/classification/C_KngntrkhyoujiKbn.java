
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 権限登録表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KngntrkhyoujiKbn</td><td colspan="3">権限登録表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>表示無</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>表示有</td></tr>
 * </table>
 */
public class C_KngntrkhyoujiKbn extends Classification<C_KngntrkhyoujiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KngntrkhyoujiKbn NONE = new C_KngntrkhyoujiKbn("0");

    public static final C_KngntrkhyoujiKbn ARI = new C_KngntrkhyoujiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_KngntrkhyoujiKbn.class);
    }

    private C_KngntrkhyoujiKbn(String value) {
        super(value);
    }

    public static C_KngntrkhyoujiKbn valueOf(String value) {
        return valueOf(C_KngntrkhyoujiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KngntrkhyoujiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KngntrkhyoujiKbn.class, patternId, value);
    }
}
