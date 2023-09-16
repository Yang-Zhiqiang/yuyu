
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約管理年金種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kknenkinsyu</td><td colspan="3">契約管理年金種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTI}</td><td>&quot;1&quot;</td><td>確定年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;2&quot;</td><td>終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSY_SYSN}</td><td>&quot;3&quot;</td><td>保証期間付終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGKHSY_SYSN}</td><td>&quot;4&quot;</td><td>総額保証付終身年金</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #KKTI}</td><td>&quot;1&quot;</td><td>確定年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;2&quot;</td><td>終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSY_SYSN}</td><td>&quot;3&quot;</td><td>保証期間付終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGKHSY_SYSN}</td><td>&quot;4&quot;</td><td>総額保証付終身年金</td></tr>
 * </table>
 */
public class C_Kknenkinsyu extends Classification<C_Kknenkinsyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kknenkinsyu BLNK = new C_Kknenkinsyu("0");

    public static final C_Kknenkinsyu KKTI = new C_Kknenkinsyu("1");

    public static final C_Kknenkinsyu SYSN = new C_Kknenkinsyu("2");

    public static final C_Kknenkinsyu HSY_SYSN = new C_Kknenkinsyu("3");

    public static final C_Kknenkinsyu SGKHSY_SYSN = new C_Kknenkinsyu("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKTI, "KKTI", false);
        addPattern(PATTERN_DEFAULT, SYSN, "SYSN", false);
        addPattern(PATTERN_DEFAULT, HSY_SYSN, "HSY_SYSN", false);
        addPattern(PATTERN_DEFAULT, SGKHSY_SYSN, "SGKHSY_SYSN", false);


        addPattern(PATTERN_NOBLNK, KKTI, "KKTI", false);
        addPattern(PATTERN_NOBLNK, SYSN, "SYSN", false);
        addPattern(PATTERN_NOBLNK, HSY_SYSN, "HSY_SYSN", false);
        addPattern(PATTERN_NOBLNK, SGKHSY_SYSN, "SGKHSY_SYSN", false);


        lock(C_Kknenkinsyu.class);
    }

    private C_Kknenkinsyu(String value) {
        super(value);
    }

    public static C_Kknenkinsyu valueOf(String value) {
        return valueOf(C_Kknenkinsyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kknenkinsyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kknenkinsyu.class, patternId, value);
    }
}
