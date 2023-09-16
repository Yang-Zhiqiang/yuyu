
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * フロー遷移有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FlowseniumuKbn</td><td colspan="3">フロー遷移有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKANRYOU}</td><td>&quot;10&quot;</td><td>未完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;90&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_FlowseniumuKbn extends Classification<C_FlowseniumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FlowseniumuKbn BLNK = new C_FlowseniumuKbn("0");

    public static final C_FlowseniumuKbn MIKANRYOU = new C_FlowseniumuKbn("10");

    public static final C_FlowseniumuKbn KANRYOU = new C_FlowseniumuKbn("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MIKANRYOU, "MIKANRYOU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_FlowseniumuKbn.class);
    }

    private C_FlowseniumuKbn(String value) {
        super(value);
    }

    public static C_FlowseniumuKbn valueOf(String value) {
        return valueOf(C_FlowseniumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FlowseniumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FlowseniumuKbn.class, patternId, value);
    }
}
