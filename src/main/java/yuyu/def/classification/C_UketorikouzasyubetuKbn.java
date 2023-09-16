
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取口座種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UketorikouzasyubetuKbn</td><td colspan="3">受取口座種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKIUKETORIKIN}</td><td>&quot;1&quot;</td><td>定期支払金口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSSOUKINYOUKOUZA}</td><td>&quot;2&quot;</td><td>ＤＳ送金用口座</td></tr>
 * </table>
 */
public class C_UketorikouzasyubetuKbn extends Classification<C_UketorikouzasyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UketorikouzasyubetuKbn BLNK = new C_UketorikouzasyubetuKbn("0");

    public static final C_UketorikouzasyubetuKbn TEIKIUKETORIKIN = new C_UketorikouzasyubetuKbn("1");

    public static final C_UketorikouzasyubetuKbn DSSOUKINYOUKOUZA = new C_UketorikouzasyubetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TEIKIUKETORIKIN, "TEIKIUKETORIKIN", false);
        addPattern(PATTERN_DEFAULT, DSSOUKINYOUKOUZA, "DSSOUKINYOUKOUZA", false);


        lock(C_UketorikouzasyubetuKbn.class);
    }

    private C_UketorikouzasyubetuKbn(String value) {
        super(value);
    }

    public static C_UketorikouzasyubetuKbn valueOf(String value) {
        return valueOf(C_UketorikouzasyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UketorikouzasyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UketorikouzasyubetuKbn.class, patternId, value);
    }
}
