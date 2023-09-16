
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特約種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tkyksyurui</td><td colspan="3">特約種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSKTKY}</td><td>&quot;1&quot;</td><td>指定代理請求特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKNKUKTTKY}</td><td>&quot;2&quot;</td><td>後継年金受取人指定特約</td></tr>
 * </table>
 */
public class C_Tkyksyurui extends Classification<C_Tkyksyurui> {

    private static final long serialVersionUID = 1L;


    public static final C_Tkyksyurui BLNK = new C_Tkyksyurui("0");

    public static final C_Tkyksyurui STDRSKTKY = new C_Tkyksyurui("1");

    public static final C_Tkyksyurui KKNKUKTTKY = new C_Tkyksyurui("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, STDRSKTKY, "STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, KKNKUKTTKY, "KKNKUKTTKY", false);


        lock(C_Tkyksyurui.class);
    }

    private C_Tkyksyurui(String value) {
        super(value);
    }

    public static C_Tkyksyurui valueOf(String value) {
        return valueOf(C_Tkyksyurui.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tkyksyurui.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tkyksyurui.class, patternId, value);
    }
}
