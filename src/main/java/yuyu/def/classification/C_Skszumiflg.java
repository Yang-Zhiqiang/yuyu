
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 作成済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Skszumiflg</td><td colspan="3">作成済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISAKUSEI}</td><td>&quot;0&quot;</td><td>未作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIZUMI}</td><td>&quot;1&quot;</td><td>作成済</td></tr>
 * </table>
 */
public class C_Skszumiflg extends Classification<C_Skszumiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Skszumiflg MISAKUSEI = new C_Skszumiflg("0");

    public static final C_Skszumiflg SAKUSEIZUMI = new C_Skszumiflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISAKUSEI, "MISAKUSEI", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIZUMI, "SAKUSEIZUMI", false);


        lock(C_Skszumiflg.class);
    }

    private C_Skszumiflg(String value) {
        super(value);
    }

    public static C_Skszumiflg valueOf(String value) {
        return valueOf(C_Skszumiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Skszumiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Skszumiflg.class, patternId, value);
    }
}
