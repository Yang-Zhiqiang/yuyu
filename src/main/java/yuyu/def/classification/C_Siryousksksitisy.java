
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資料請求作成対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Siryousksksitisy</td><td colspan="3">資料請求作成対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERR}</td><td>&quot;1&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;2&quot;</td><td>申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSERR}</td><td>&quot;3&quot;</td><td>申込書・エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOU}</td><td>&quot;4&quot;</td><td>資料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOUERR}</td><td>&quot;5&quot;</td><td>資料・エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOUMOS}</td><td>&quot;6&quot;</td><td>資料・申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOUMOSERR}</td><td>&quot;7&quot;</td><td>資料・申込書・エラー</td></tr>
 * </table>
 */
public class C_Siryousksksitisy extends Classification<C_Siryousksksitisy> {

    private static final long serialVersionUID = 1L;


    public static final C_Siryousksksitisy BLNK = new C_Siryousksksitisy("0");

    public static final C_Siryousksksitisy ERR = new C_Siryousksksitisy("1");

    public static final C_Siryousksksitisy MOS = new C_Siryousksksitisy("2");

    public static final C_Siryousksksitisy MOSERR = new C_Siryousksksitisy("3");

    public static final C_Siryousksksitisy SIRYOU = new C_Siryousksksitisy("4");

    public static final C_Siryousksksitisy SIRYOUERR = new C_Siryousksksitisy("5");

    public static final C_Siryousksksitisy SIRYOUMOS = new C_Siryousksksitisy("6");

    public static final C_Siryousksksitisy SIRYOUMOSERR = new C_Siryousksksitisy("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ERR, "ERR", false);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);
        addPattern(PATTERN_DEFAULT, MOSERR, "MOSERR", false);
        addPattern(PATTERN_DEFAULT, SIRYOU, "SIRYOU", false);
        addPattern(PATTERN_DEFAULT, SIRYOUERR, "SIRYOUERR", false);
        addPattern(PATTERN_DEFAULT, SIRYOUMOS, "SIRYOUMOS", false);
        addPattern(PATTERN_DEFAULT, SIRYOUMOSERR, "SIRYOUMOSERR", false);


        lock(C_Siryousksksitisy.class);
    }

    private C_Siryousksksitisy(String value) {
        super(value);
    }

    public static C_Siryousksksitisy valueOf(String value) {
        return valueOf(C_Siryousksksitisy.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Siryousksksitisy.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Siryousksksitisy.class, patternId, value);
    }
}
