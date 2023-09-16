
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 下位組織更新要フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kaisosikiupdyouflag</td><td colspan="3">下位組織更新要フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 * </table>
 */
public class C_Kaisosikiupdyouflag extends Classification<C_Kaisosikiupdyouflag> {

    private static final long serialVersionUID = 1L;


    public static final C_Kaisosikiupdyouflag HUYOU = new C_Kaisosikiupdyouflag("0");

    public static final C_Kaisosikiupdyouflag YOU = new C_Kaisosikiupdyouflag("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        lock(C_Kaisosikiupdyouflag.class);
    }

    private C_Kaisosikiupdyouflag(String value) {
        super(value);
    }

    public static C_Kaisosikiupdyouflag valueOf(String value) {
        return valueOf(C_Kaisosikiupdyouflag.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kaisosikiupdyouflag.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kaisosikiupdyouflag.class, patternId, value);
    }
}
