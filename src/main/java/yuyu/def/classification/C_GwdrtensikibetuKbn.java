
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷ代理店識別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GwdrtensikibetuKbn</td><td colspan="3">ＧＷ代理店識別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPNDRTN}</td><td>&quot;01&quot;</td><td>一般代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>SMBC</td></tr>
 * </table>
 */
public class C_GwdrtensikibetuKbn extends Classification<C_GwdrtensikibetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GwdrtensikibetuKbn BLNK = new C_GwdrtensikibetuKbn("00");

    public static final C_GwdrtensikibetuKbn IPNDRTN = new C_GwdrtensikibetuKbn("01");

    public static final C_GwdrtensikibetuKbn SMBC = new C_GwdrtensikibetuKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IPNDRTN, "IPNDRTN", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);


        lock(C_GwdrtensikibetuKbn.class);
    }

    private C_GwdrtensikibetuKbn(String value) {
        super(value);
    }

    public static C_GwdrtensikibetuKbn valueOf(String value) {
        return valueOf(C_GwdrtensikibetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GwdrtensikibetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GwdrtensikibetuKbn.class, patternId, value);
    }
}
