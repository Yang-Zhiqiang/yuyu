
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 掲示板区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjbnKbn</td><td colspan="3">掲示板区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #IPNDRTN}</td><td>&quot;A&quot;</td><td>一般代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGINHNY}</td><td>&quot;B&quot;</td><td>地銀汎用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKINHNY}</td><td>&quot;C&quot;</td><td>信金汎用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;S&quot;</td><td>SMBC</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPD_SMBC}</td><td>&quot;X&quot;</td><td>サポデ(SMBC)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPD_TIGIN}</td><td>&quot;Y&quot;</td><td>サポデ(地銀)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPD_IPNDRTN}</td><td>&quot;Z&quot;</td><td>サポデ(一般代理店)</td></tr>
 * </table>
 */
public class C_KjbnKbn extends Classification<C_KjbnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjbnKbn IPNDRTN = new C_KjbnKbn("A");

    public static final C_KjbnKbn TIGINHNY = new C_KjbnKbn("B");

    public static final C_KjbnKbn SINKINHNY = new C_KjbnKbn("C");

    public static final C_KjbnKbn SMBC = new C_KjbnKbn("S");

    public static final C_KjbnKbn SPD_SMBC = new C_KjbnKbn("X");

    public static final C_KjbnKbn SPD_TIGIN = new C_KjbnKbn("Y");

    public static final C_KjbnKbn SPD_IPNDRTN = new C_KjbnKbn("Z");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, IPNDRTN, "IPNDRTN", true);
        addPattern(PATTERN_DEFAULT, TIGINHNY, "TIGINHNY", false);
        addPattern(PATTERN_DEFAULT, SINKINHNY, "SINKINHNY", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, SPD_SMBC, "SPD_SMBC", false);
        addPattern(PATTERN_DEFAULT, SPD_TIGIN, "SPD_TIGIN", false);
        addPattern(PATTERN_DEFAULT, SPD_IPNDRTN, "SPD_IPNDRTN", false);


        lock(C_KjbnKbn.class);
    }

    private C_KjbnKbn(String value) {
        super(value);
    }

    public static C_KjbnKbn valueOf(String value) {
        return valueOf(C_KjbnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjbnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjbnKbn.class, patternId, value);
    }
}
