
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案内収納用システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AnsyuusysKbn</td><td colspan="3">案内収納用システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;1&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;2&quot;</td><td>契約保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;9&quot;</td><td>全体</td></tr>
 * </table>
 */
public class C_AnsyuusysKbn extends Classification<C_AnsyuusysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AnsyuusysKbn BLNK = new C_AnsyuusysKbn("0");

    public static final C_AnsyuusysKbn SKEI = new C_AnsyuusysKbn("1");

    public static final C_AnsyuusysKbn HOZEN = new C_AnsyuusysKbn("2");

    public static final C_AnsyuusysKbn ALL = new C_AnsyuusysKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_AnsyuusysKbn.class);
    }

    private C_AnsyuusysKbn(String value) {
        super(value);
    }

    public static C_AnsyuusysKbn valueOf(String value) {
        return valueOf(C_AnsyuusysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AnsyuusysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AnsyuusysKbn.class, patternId, value);
    }
}
