
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納備金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennoubikinKbn</td><td colspan="3">前納備金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YUUKOU}</td><td>&quot;0&quot;</td><td>有効中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BIKIN}</td><td>&quot;1&quot;</td><td>備金</td></tr>
 * </table>
 */
public class C_ZennoubikinKbn extends Classification<C_ZennoubikinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennoubikinKbn YUUKOU = new C_ZennoubikinKbn("0");

    public static final C_ZennoubikinKbn BIKIN = new C_ZennoubikinKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", true);
        addPattern(PATTERN_DEFAULT, BIKIN, "BIKIN", false);


        lock(C_ZennoubikinKbn.class);
    }

    private C_ZennoubikinKbn(String value) {
        super(value);
    }

    public static C_ZennoubikinKbn valueOf(String value) {
        return valueOf(C_ZennoubikinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennoubikinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennoubikinKbn.class, patternId, value);
    }
}
