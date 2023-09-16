
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ダイレクト販売利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrcthanriyouKbn</td><td colspan="3">ダイレクト販売利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>利用なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOU}</td><td>&quot;1&quot;</td><td>資料請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNSIRYOU}</td><td>&quot;2&quot;</td><td>保険設計＆資料請求</td></tr>
 * </table>
 */
public class C_DrcthanriyouKbn extends Classification<C_DrcthanriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrcthanriyouKbn NONE = new C_DrcthanriyouKbn("0");

    public static final C_DrcthanriyouKbn SIRYOU = new C_DrcthanriyouKbn("1");

    public static final C_DrcthanriyouKbn HKNSIRYOU = new C_DrcthanriyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SIRYOU, "SIRYOU", false);
        addPattern(PATTERN_DEFAULT, HKNSIRYOU, "HKNSIRYOU", false);


        lock(C_DrcthanriyouKbn.class);
    }

    private C_DrcthanriyouKbn(String value) {
        super(value);
    }

    public static C_DrcthanriyouKbn valueOf(String value) {
        return valueOf(C_DrcthanriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrcthanriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrcthanriyouKbn.class, patternId, value);
    }
}
