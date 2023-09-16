
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 索引通算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuintsnKbn</td><td colspan="3">索引通算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_SakuintsnKbn extends Classification<C_SakuintsnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuintsnKbn SEIJYOU = new C_SakuintsnKbn("0");

    public static final C_SakuintsnKbn ERROR = new C_SakuintsnKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_SakuintsnKbn.class);
    }

    private C_SakuintsnKbn(String value) {
        super(value);
    }

    public static C_SakuintsnKbn valueOf(String value) {
        return valueOf(C_SakuintsnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuintsnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuintsnKbn.class, patternId, value);
    }
}
