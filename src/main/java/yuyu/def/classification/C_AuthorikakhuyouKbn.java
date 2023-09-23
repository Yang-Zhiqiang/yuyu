
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オーソリ確認不要区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AuthorikakhuyouKbn</td><td colspan="3">オーソリ確認不要区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORIKAKHUYOU}</td><td>&quot;1&quot;</td><td>オーソリ確認不要</td></tr>
 * </table>
 */
public class C_AuthorikakhuyouKbn extends Classification<C_AuthorikakhuyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AuthorikakhuyouKbn BLNK = new C_AuthorikakhuyouKbn("0");

    public static final C_AuthorikakhuyouKbn AUTHORIKAKHUYOU = new C_AuthorikakhuyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, AUTHORIKAKHUYOU, "AUTHORIKAKHUYOU", false);


        lock(C_AuthorikakhuyouKbn.class);
    }

    private C_AuthorikakhuyouKbn(String value) {
        super(value);
    }

    public static C_AuthorikakhuyouKbn valueOf(String value) {
        return valueOf(C_AuthorikakhuyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AuthorikakhuyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AuthorikakhuyouKbn.class, patternId, value);
    }
}