
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ起動モード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchModeKbn</td><td colspan="3">バッチ起動モード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DOUKI}</td><td>&quot;1&quot;</td><td>同期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIDOUKI}</td><td>&quot;2&quot;</td><td>非同期</td></tr>
 * </table>
 */
public class C_BatchModeKbn extends Classification<C_BatchModeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchModeKbn DOUKI = new C_BatchModeKbn("1");

    public static final C_BatchModeKbn HIDOUKI = new C_BatchModeKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DOUKI, "DOUKI", true);
        addPattern(PATTERN_DEFAULT, HIDOUKI, "HIDOUKI", false);


        lock(C_BatchModeKbn.class);
    }

    private C_BatchModeKbn(String value) {
        super(value);
    }

    public static C_BatchModeKbn valueOf(String value) {
        return valueOf(C_BatchModeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchModeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchModeKbn.class, patternId, value);
    }
}
