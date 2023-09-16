
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約年金種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sknenkinsyu</td><td colspan="3">新契約年金種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTI5}</td><td>&quot;1&quot;</td><td>５年確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTI10}</td><td>&quot;2&quot;</td><td>１０年確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTI15}</td><td>&quot;3&quot;</td><td>１５年確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGKHSYSYSN}</td><td>&quot;8&quot;</td><td>年金総額保証付終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTI5DAI1BAIGAKU}</td><td>&quot;A&quot;</td><td>５年確定（第１回年金倍額型）</td></tr>
 * </table>
 */
public class C_Sknenkinsyu extends Classification<C_Sknenkinsyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Sknenkinsyu BLNK = new C_Sknenkinsyu("0");

    public static final C_Sknenkinsyu KKTI5 = new C_Sknenkinsyu("1");

    public static final C_Sknenkinsyu KKTI10 = new C_Sknenkinsyu("2");

    public static final C_Sknenkinsyu KKTI15 = new C_Sknenkinsyu("3");

    public static final C_Sknenkinsyu SGKHSYSYSN = new C_Sknenkinsyu("8");

    public static final C_Sknenkinsyu KKTI5DAI1BAIGAKU = new C_Sknenkinsyu("A");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKTI5, "KKTI5", false);
        addPattern(PATTERN_DEFAULT, KKTI10, "KKTI10", false);
        addPattern(PATTERN_DEFAULT, KKTI15, "KKTI15", false);
        addPattern(PATTERN_DEFAULT, SGKHSYSYSN, "SGKHSYSYSN", false);
        addPattern(PATTERN_DEFAULT, KKTI5DAI1BAIGAKU, "KKTI5DAI1BAIGAKU", false);


        lock(C_Sknenkinsyu.class);
    }

    private C_Sknenkinsyu(String value) {
        super(value);
    }

    public static C_Sknenkinsyu valueOf(String value) {
        return valueOf(C_Sknenkinsyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sknenkinsyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sknenkinsyu.class, patternId, value);
    }
}
