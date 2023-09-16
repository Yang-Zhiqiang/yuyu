
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ブランク付ＭＦ連動済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BlnktkMfrenflg</td><td colspan="3">ブランク付ＭＦ連動済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ＭＦ未連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>ＭＦ連動済</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_BlnktkMfrenflg extends Classification<C_BlnktkMfrenflg> {

    private static final long serialVersionUID = 1L;


    public static final C_BlnktkMfrenflg NONE = new C_BlnktkMfrenflg("0");

    public static final C_BlnktkMfrenflg SUMI = new C_BlnktkMfrenflg("1");

    public static final C_BlnktkMfrenflg BLNK = new C_BlnktkMfrenflg("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_BlnktkMfrenflg.class);
    }

    private C_BlnktkMfrenflg(String value) {
        super(value);
    }

    public static C_BlnktkMfrenflg valueOf(String value) {
        return valueOf(C_BlnktkMfrenflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BlnktkMfrenflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BlnktkMfrenflg.class, patternId, value);
    }
}
