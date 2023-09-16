
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * メッセージ引数内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MsgHikisuuNaiyouKbn</td><td colspan="3">メッセージ引数内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MESSAGEID}</td><td>&quot;1&quot;</td><td>メッセージＩＤ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUMOKUMEI}</td><td>&quot;2&quot;</td><td>項目名</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;3&quot;</td><td>入力値</td></tr>
 * </table>
 */
public class C_MsgHikisuuNaiyouKbn extends Classification<C_MsgHikisuuNaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MsgHikisuuNaiyouKbn BLNK = new C_MsgHikisuuNaiyouKbn("0");

    public static final C_MsgHikisuuNaiyouKbn MESSAGEID = new C_MsgHikisuuNaiyouKbn("1");

    public static final C_MsgHikisuuNaiyouKbn KOUMOKUMEI = new C_MsgHikisuuNaiyouKbn("2");

    public static final C_MsgHikisuuNaiyouKbn INPUT = new C_MsgHikisuuNaiyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, MESSAGEID, "MESSAGEID", false);
        addPattern(PATTERN_DEFAULT, KOUMOKUMEI, "KOUMOKUMEI", false);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);


        lock(C_MsgHikisuuNaiyouKbn.class);
    }

    private C_MsgHikisuuNaiyouKbn(String value) {
        super(value);
    }

    public static C_MsgHikisuuNaiyouKbn valueOf(String value) {
        return valueOf(C_MsgHikisuuNaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MsgHikisuuNaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MsgHikisuuNaiyouKbn.class, patternId, value);
    }
}
