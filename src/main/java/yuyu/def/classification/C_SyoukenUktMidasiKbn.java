
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 証券受取人見出し区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukenUktMidasiKbn</td><td colspan="3">証券受取人見出し区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;01&quot;</td><td>何もしない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHKKUKT}</td><td>&quot;02&quot;</td><td>死亡保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;03&quot;</td><td>年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDR}</td><td>&quot;04&quot;</td><td>指定代理請求人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKFKUKT}</td><td>&quot;05&quot;</td><td>死亡給付金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKSDR}</td><td>&quot;06&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKKYKSDR}</td><td>&quot;07&quot;</td><td>保険契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKSDROLD}</td><td>&quot;08&quot;</td><td>被保険者代理人（２０２０年３月以前は指定代理請求人）</td></tr>
 * </table>
 */
public class C_SyoukenUktMidasiKbn extends Classification<C_SyoukenUktMidasiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukenUktMidasiKbn BLNK = new C_SyoukenUktMidasiKbn("00");

    public static final C_SyoukenUktMidasiKbn NONE = new C_SyoukenUktMidasiKbn("01");

    public static final C_SyoukenUktMidasiKbn SBHKKUKT = new C_SyoukenUktMidasiKbn("02");

    public static final C_SyoukenUktMidasiKbn NKUKT = new C_SyoukenUktMidasiKbn("03");

    public static final C_SyoukenUktMidasiKbn STDR = new C_SyoukenUktMidasiKbn("04");

    public static final C_SyoukenUktMidasiKbn SBKFKUKT = new C_SyoukenUktMidasiKbn("05");

    public static final C_SyoukenUktMidasiKbn HHKSDR = new C_SyoukenUktMidasiKbn("06");

    public static final C_SyoukenUktMidasiKbn HKKYKSDR = new C_SyoukenUktMidasiKbn("07");

    public static final C_SyoukenUktMidasiKbn HHKSDROLD = new C_SyoukenUktMidasiKbn("08");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, SBHKKUKT, "SBHKKUKT", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);
        addPattern(PATTERN_DEFAULT, STDR, "STDR", false);
        addPattern(PATTERN_DEFAULT, SBKFKUKT, "SBKFKUKT", false);
        addPattern(PATTERN_DEFAULT, HHKSDR, "HHKSDR", false);
        addPattern(PATTERN_DEFAULT, HKKYKSDR, "HKKYKSDR", false);
        addPattern(PATTERN_DEFAULT, HHKSDROLD, "HHKSDROLD", false);


        lock(C_SyoukenUktMidasiKbn.class);
    }

    private C_SyoukenUktMidasiKbn(String value) {
        super(value);
    }

    public static C_SyoukenUktMidasiKbn valueOf(String value) {
        return valueOf(C_SyoukenUktMidasiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukenUktMidasiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukenUktMidasiKbn.class, patternId, value);
    }
}
