
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者代理権発動状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykdrknHtdjytKbn</td><td colspan="3">契約者代理権発動状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 * </table>
 */
public class C_KykdrknHtdjytKbn extends Classification<C_KykdrknHtdjytKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykdrknHtdjytKbn BLNK = new C_KykdrknHtdjytKbn("0");

    public static final C_KykdrknHtdjytKbn SETTEI = new C_KykdrknHtdjytKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SETTEI, "SETTEI", false);


        lock(C_KykdrknHtdjytKbn.class);
    }

    private C_KykdrknHtdjytKbn(String value) {
        super(value);
    }

    public static C_KykdrknHtdjytKbn valueOf(String value) {
        return valueOf(C_KykdrknHtdjytKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykdrknHtdjytKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykdrknHtdjytKbn.class, patternId, value);
    }
}
