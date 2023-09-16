
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動グループ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidougroupKbn</td><td colspan="3">資金移動グループ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DUMMY}</td><td>&quot;ZZ&quot;</td><td>ダミー</td></tr>
 * </table>
 */
public class C_SikinidougroupKbn extends Classification<C_SikinidougroupKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidougroupKbn BLNK = new C_SikinidougroupKbn("00");

    public static final C_SikinidougroupKbn DUMMY = new C_SikinidougroupKbn("ZZ");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DUMMY, "DUMMY", false);


        lock(C_SikinidougroupKbn.class);
    }

    private C_SikinidougroupKbn(String value) {
        super(value);
    }

    public static C_SikinidougroupKbn valueOf(String value) {
        return valueOf(C_SikinidougroupKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidougroupKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidougroupKbn.class, patternId, value);
    }
}
