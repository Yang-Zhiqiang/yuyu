
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 設計書番号体系区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeknotkKbn</td><td colspan="3">設計書番号体系区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #IPNDRTN}</td><td>&quot;A&quot;</td><td>一般代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECT}</td><td>&quot;D&quot;</td><td>ダイレクト販売</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSEK}</td><td>&quot;K&quot;</td><td>簡易設計</td></tr>
 * </table>
 */
public class C_SeknotkKbn extends Classification<C_SeknotkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeknotkKbn IPNDRTN = new C_SeknotkKbn("A");

    public static final C_SeknotkKbn DIRECT = new C_SeknotkKbn("D");

    public static final C_SeknotkKbn KSEK = new C_SeknotkKbn("K");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, IPNDRTN, "IPNDRTN", true);
        addPattern(PATTERN_DEFAULT, DIRECT, "DIRECT", false);
        addPattern(PATTERN_DEFAULT, KSEK, "KSEK", false);


        lock(C_SeknotkKbn.class);
    }

    private C_SeknotkKbn(String value) {
        super(value);
    }

    public static C_SeknotkKbn valueOf(String value) {
        return valueOf(C_SeknotkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeknotkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeknotkKbn.class, patternId, value);
    }
}
