
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ChkkekkaKbn</td><td colspan="3">チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARNING}</td><td>&quot;1&quot;</td><td>ワーニング</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;2&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_ChkkekkaKbn extends Classification<C_ChkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ChkkekkaKbn SEIJYOU = new C_ChkkekkaKbn("0");

    public static final C_ChkkekkaKbn WARNING = new C_ChkkekkaKbn("1");

    public static final C_ChkkekkaKbn ERROR = new C_ChkkekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, WARNING, "WARNING", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_ChkkekkaKbn.class);
    }

    private C_ChkkekkaKbn(String value) {
        super(value);
    }

    public static C_ChkkekkaKbn valueOf(String value) {
        return valueOf(C_ChkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ChkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ChkkekkaKbn.class, patternId, value);
    }
}
