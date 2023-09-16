
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ動作モード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchDousaModeKbn</td><td colspan="3">バッチ動作モード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;none&quot;</td><td>オンライン稼働時待機なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;all&quot;</td><td>オンライン稼働時待機あり</td></tr>
 * </table>
 */
public class C_BatchDousaModeKbn extends Classification<C_BatchDousaModeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchDousaModeKbn NONE = new C_BatchDousaModeKbn("none");

    public static final C_BatchDousaModeKbn ALL = new C_BatchDousaModeKbn("all");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_BatchDousaModeKbn.class);
    }

    private C_BatchDousaModeKbn(String value) {
        super(value);
    }

    public static C_BatchDousaModeKbn valueOf(String value) {
        return valueOf(C_BatchDousaModeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchDousaModeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchDousaModeKbn.class, patternId, value);
    }
}
