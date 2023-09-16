
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求内容チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SKNaiyouChkkekkaKbn</td><td colspan="3">請求内容チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARNING}</td><td>&quot;1&quot;</td><td>ワーニング</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;2&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUNIN}</td><td>&quot;3&quot;</td><td>特認エラー</td></tr>
 * </table>
 */
public class C_SKNaiyouChkkekkaKbn extends Classification<C_SKNaiyouChkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SKNaiyouChkkekkaKbn SEIJYOU = new C_SKNaiyouChkkekkaKbn("0");

    public static final C_SKNaiyouChkkekkaKbn WARNING = new C_SKNaiyouChkkekkaKbn("1");

    public static final C_SKNaiyouChkkekkaKbn ERROR = new C_SKNaiyouChkkekkaKbn("2");

    public static final C_SKNaiyouChkkekkaKbn TOKUNIN = new C_SKNaiyouChkkekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_DEFAULT, WARNING, "WARNING", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, TOKUNIN, "TOKUNIN", false);


        lock(C_SKNaiyouChkkekkaKbn.class);
    }

    private C_SKNaiyouChkkekkaKbn(String value) {
        super(value);
    }

    public static C_SKNaiyouChkkekkaKbn valueOf(String value) {
        return valueOf(C_SKNaiyouChkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SKNaiyouChkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SKNaiyouChkkekkaKbn.class, patternId, value);
    }
}
