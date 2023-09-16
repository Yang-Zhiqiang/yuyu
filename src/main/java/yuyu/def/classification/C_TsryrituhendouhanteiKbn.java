
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料率変動判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsryrituhendouhanteiKbn</td><td colspan="3">手数料率変動判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HNKNONE}</td><td>&quot;0&quot;</td><td>変更なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNKARI}</td><td>&quot;1&quot;</td><td>変更あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;2&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_TsryrituhendouhanteiKbn extends Classification<C_TsryrituhendouhanteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsryrituhendouhanteiKbn HNKNONE = new C_TsryrituhendouhanteiKbn("0");

    public static final C_TsryrituhendouhanteiKbn HNKARI = new C_TsryrituhendouhanteiKbn("1");

    public static final C_TsryrituhendouhanteiKbn ERROR = new C_TsryrituhendouhanteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HNKNONE, "HNKNONE", true);
        addPattern(PATTERN_DEFAULT, HNKARI, "HNKARI", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_TsryrituhendouhanteiKbn.class);
    }

    private C_TsryrituhendouhanteiKbn(String value) {
        super(value);
    }

    public static C_TsryrituhendouhanteiKbn valueOf(String value) {
        return valueOf(C_TsryrituhendouhanteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsryrituhendouhanteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsryrituhendouhanteiKbn.class, patternId, value);
    }
}
