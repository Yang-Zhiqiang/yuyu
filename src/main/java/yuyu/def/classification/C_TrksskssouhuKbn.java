
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取消請求書送付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrksskssouhuKbn</td><td colspan="3">取消請求書送付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DAIRITENATESOUHUYOU}</td><td>&quot;0&quot;</td><td>代理店あて送付要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENSONAETUKEARI}</td><td>&quot;1&quot;</td><td>代理店備付有（送付不要）</td></tr>
 * </table>
 */
public class C_TrksskssouhuKbn extends Classification<C_TrksskssouhuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrksskssouhuKbn DAIRITENATESOUHUYOU = new C_TrksskssouhuKbn("0");

    public static final C_TrksskssouhuKbn DAIRITENSONAETUKEARI = new C_TrksskssouhuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DAIRITENATESOUHUYOU, "DAIRITENATESOUHUYOU", true);
        addPattern(PATTERN_DEFAULT, DAIRITENSONAETUKEARI, "DAIRITENSONAETUKEARI", false);


        lock(C_TrksskssouhuKbn.class);
    }

    private C_TrksskssouhuKbn(String value) {
        super(value);
    }

    public static C_TrksskssouhuKbn valueOf(String value) {
        return valueOf(C_TrksskssouhuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrksskssouhuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrksskssouhuKbn.class, patternId, value);
    }
}
