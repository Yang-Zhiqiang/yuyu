
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 為替手数料区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KawasetsryKbn</td><td colspan="3">為替手数料区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISSEIRATE}</td><td>&quot;1&quot;</td><td>実勢為替レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUKINRATE}</td><td>&quot;2&quot;</td><td>入金為替レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUKKINRATE}</td><td>&quot;3&quot;</td><td>出金為替レート</td></tr>
 * </table>
 */
public class C_KawasetsryKbn extends Classification<C_KawasetsryKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KawasetsryKbn BLNK = new C_KawasetsryKbn("0");

    public static final C_KawasetsryKbn JISSEIRATE = new C_KawasetsryKbn("1");

    public static final C_KawasetsryKbn NYUKINRATE = new C_KawasetsryKbn("2");

    public static final C_KawasetsryKbn SYUKKINRATE = new C_KawasetsryKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JISSEIRATE, "JISSEIRATE", false);
        addPattern(PATTERN_DEFAULT, NYUKINRATE, "NYUKINRATE", false);
        addPattern(PATTERN_DEFAULT, SYUKKINRATE, "SYUKKINRATE", false);


        lock(C_KawasetsryKbn.class);
    }

    private C_KawasetsryKbn(String value) {
        super(value);
    }

    public static C_KawasetsryKbn valueOf(String value) {
        return valueOf(C_KawasetsryKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KawasetsryKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KawasetsryKbn.class, patternId, value);
    }
}
