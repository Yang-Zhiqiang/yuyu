
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ８割９割保証特約適用フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_8wari9waritkytekiyouflg</td><td colspan="3">８割９割保証特約適用フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>適用なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HATIWARI}</td><td>&quot;1&quot;</td><td>８割保証特約適用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUWARI}</td><td>&quot;2&quot;</td><td>９割保証特約適用</td></tr>
 * </table>
 */
public class C_8wari9waritkytekiyouflg extends Classification<C_8wari9waritkytekiyouflg> {

    private static final long serialVersionUID = 1L;


    public static final C_8wari9waritkytekiyouflg NONE = new C_8wari9waritkytekiyouflg("0");

    public static final C_8wari9waritkytekiyouflg HATIWARI = new C_8wari9waritkytekiyouflg("1");

    public static final C_8wari9waritkytekiyouflg KYUUWARI = new C_8wari9waritkytekiyouflg("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HATIWARI, "HATIWARI", false);
        addPattern(PATTERN_DEFAULT, KYUUWARI, "KYUUWARI", false);


        lock(C_8wari9waritkytekiyouflg.class);
    }

    private C_8wari9waritkytekiyouflg(String value) {
        super(value);
    }

    public static C_8wari9waritkytekiyouflg valueOf(String value) {
        return valueOf(C_8wari9waritkytekiyouflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_8wari9waritkytekiyouflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_8wari9waritkytekiyouflg.class, patternId, value);
    }
}
