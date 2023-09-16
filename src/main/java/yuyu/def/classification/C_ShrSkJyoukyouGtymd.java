
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払請求状況該当日 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrSkJyoukyouGtymd</td><td colspan="3">支払請求状況該当日</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SHRSYORIYMD}</td><td>&quot;1&quot;</td><td>支払処理日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEYMD}</td><td>&quot;2&quot;</td><td>申出受付日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUTEITORIKESIYMD}</td><td>&quot;3&quot;</td><td>工程取消日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSTORIKOMIYMD}</td><td>&quot;4&quot;</td><td>請求書取込日</td></tr>
 * </table>
 */
public class C_ShrSkJyoukyouGtymd extends Classification<C_ShrSkJyoukyouGtymd> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrSkJyoukyouGtymd SHRSYORIYMD = new C_ShrSkJyoukyouGtymd("1");

    public static final C_ShrSkJyoukyouGtymd MOUSIDEYMD = new C_ShrSkJyoukyouGtymd("2");

    public static final C_ShrSkJyoukyouGtymd KOUTEITORIKESIYMD = new C_ShrSkJyoukyouGtymd("3");

    public static final C_ShrSkJyoukyouGtymd SKSTORIKOMIYMD = new C_ShrSkJyoukyouGtymd("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SHRSYORIYMD, "SHRSYORIYMD", true);
        addPattern(PATTERN_DEFAULT, MOUSIDEYMD, "MOUSIDEYMD", false);
        addPattern(PATTERN_DEFAULT, KOUTEITORIKESIYMD, "KOUTEITORIKESIYMD", false);
        addPattern(PATTERN_DEFAULT, SKSTORIKOMIYMD, "SKSTORIKOMIYMD", false);


        lock(C_ShrSkJyoukyouGtymd.class);
    }

    private C_ShrSkJyoukyouGtymd(String value) {
        super(value);
    }

    public static C_ShrSkJyoukyouGtymd valueOf(String value) {
        return valueOf(C_ShrSkJyoukyouGtymd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrSkJyoukyouGtymd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrSkJyoukyouGtymd.class, patternId, value);
    }
}
