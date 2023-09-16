
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * お知らせ回答状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OsirasekaitoujkKbn</td><td colspan="3">お知らせ回答状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAITOUHUYOU}</td><td>&quot;0&quot;</td><td>回答不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKAITOU}</td><td>&quot;1&quot;</td><td>未回答</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUZUMI}</td><td>&quot;2&quot;</td><td>回答済</td></tr>
 * </table>
 */
public class C_OsirasekaitoujkKbn extends Classification<C_OsirasekaitoujkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OsirasekaitoujkKbn KAITOUHUYOU = new C_OsirasekaitoujkKbn("0");

    public static final C_OsirasekaitoujkKbn MIKAITOU = new C_OsirasekaitoujkKbn("1");

    public static final C_OsirasekaitoujkKbn KAITOUZUMI = new C_OsirasekaitoujkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAITOUHUYOU, "KAITOUHUYOU", true);
        addPattern(PATTERN_DEFAULT, MIKAITOU, "MIKAITOU", false);
        addPattern(PATTERN_DEFAULT, KAITOUZUMI, "KAITOUZUMI", false);


        lock(C_OsirasekaitoujkKbn.class);
    }

    private C_OsirasekaitoujkKbn(String value) {
        super(value);
    }

    public static C_OsirasekaitoujkKbn valueOf(String value) {
        return valueOf(C_OsirasekaitoujkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OsirasekaitoujkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OsirasekaitoujkKbn.class, patternId, value);
    }
}
