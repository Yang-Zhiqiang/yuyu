
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 出力選択区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OutselectKbn</td><td colspan="3">出力選択区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NKSYOUSYO}</td><td>&quot;1&quot;</td><td>年金証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;2&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_OutselectKbn extends Classification<C_OutselectKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OutselectKbn NKSYOUSYO = new C_OutselectKbn("1");

    public static final C_OutselectKbn SONOTA = new C_OutselectKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NKSYOUSYO, "NKSYOUSYO", true);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_OutselectKbn.class);
    }

    private C_OutselectKbn(String value) {
        super(value);
    }

    public static C_OutselectKbn valueOf(String value) {
        return valueOf(C_OutselectKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OutselectKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OutselectKbn.class, patternId, value);
    }
}
