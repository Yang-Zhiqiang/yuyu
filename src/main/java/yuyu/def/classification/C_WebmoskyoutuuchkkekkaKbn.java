
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｗｅｂ申込共通チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WebmoskyoutuuchkkekkaKbn</td><td colspan="3">Ｗｅｂ申込共通チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATAIJYOUERROR}</td><td>&quot;1&quot;</td><td>データ異常エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGEUPERROR}</td><td>&quot;2&quot;</td><td>年齢アップエラー</td></tr>
 * </table>
 */
public class C_WebmoskyoutuuchkkekkaKbn extends Classification<C_WebmoskyoutuuchkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WebmoskyoutuuchkkekkaKbn SEIJYOU = new C_WebmoskyoutuuchkkekkaKbn("0");

    public static final C_WebmoskyoutuuchkkekkaKbn DATAIJYOUERROR = new C_WebmoskyoutuuchkkekkaKbn("1");

    public static final C_WebmoskyoutuuchkkekkaKbn AGEUPERROR = new C_WebmoskyoutuuchkkekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, DATAIJYOUERROR, "DATAIJYOUERROR", false);
        addPattern(PATTERN_DEFAULT, AGEUPERROR, "AGEUPERROR", false);


        lock(C_WebmoskyoutuuchkkekkaKbn.class);
    }

    private C_WebmoskyoutuuchkkekkaKbn(String value) {
        super(value);
    }

    public static C_WebmoskyoutuuchkkekkaKbn valueOf(String value) {
        return valueOf(C_WebmoskyoutuuchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WebmoskyoutuuchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WebmoskyoutuuchkkekkaKbn.class, patternId, value);
    }
}
