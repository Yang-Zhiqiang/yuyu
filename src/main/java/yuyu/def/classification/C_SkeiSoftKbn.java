
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約ソフト名称区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkeiSoftKbn</td><td colspan="3">新契約ソフト名称区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SONOTA}</td><td>&quot;00&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANTAI}</td><td>&quot;50&quot;</td><td>単体年金</td></tr>
 * </table>
 */
public class C_SkeiSoftKbn extends Classification<C_SkeiSoftKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkeiSoftKbn SONOTA = new C_SkeiSoftKbn("00");

    public static final C_SkeiSoftKbn TANTAI = new C_SkeiSoftKbn("50");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", true);
        addPattern(PATTERN_DEFAULT, TANTAI, "TANTAI", false);


        lock(C_SkeiSoftKbn.class);
    }

    private C_SkeiSoftKbn(String value) {
        super(value);
    }

    public static C_SkeiSoftKbn valueOf(String value) {
        return valueOf(C_SkeiSoftKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkeiSoftKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkeiSoftKbn.class, patternId, value);
    }
}
