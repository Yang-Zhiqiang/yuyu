
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinIdouKbn</td><td colspan="3">資金移動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FB_AZUKARI}</td><td>&quot;1&quot;</td><td>ＦＢ送金予定／預り金</td></tr>
 * </table>
 */
public class C_SikinIdouKbn extends Classification<C_SikinIdouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinIdouKbn BLNK = new C_SikinIdouKbn("0");

    public static final C_SikinIdouKbn FB_AZUKARI = new C_SikinIdouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FB_AZUKARI, "FB_AZUKARI", false);


        lock(C_SikinIdouKbn.class);
    }

    private C_SikinIdouKbn(String value) {
        super(value);
    }

    public static C_SikinIdouKbn valueOf(String value) {
        return valueOf(C_SikinIdouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinIdouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinIdouKbn.class, patternId, value);
    }
}
