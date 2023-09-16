
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡・受取人変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SbukthnkKbn</td><td colspan="3">死亡・受取人変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SIBOU}</td><td>&quot;1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHNK}</td><td>&quot;2&quot;</td><td>受取人変更</td></tr>
 * </table>
 */
public class C_SbukthnkKbn extends Classification<C_SbukthnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SbukthnkKbn SIBOU = new C_SbukthnkKbn("1");

    public static final C_SbukthnkKbn UKTHNK = new C_SbukthnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", true);
        addPattern(PATTERN_DEFAULT, UKTHNK, "UKTHNK", false);


        lock(C_SbukthnkKbn.class);
    }

    private C_SbukthnkKbn(String value) {
        super(value);
    }

    public static C_SbukthnkKbn valueOf(String value) {
        return valueOf(C_SbukthnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SbukthnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SbukthnkKbn.class, patternId, value);
    }
}
