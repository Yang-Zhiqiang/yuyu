
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 会計担当者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KaikeitantousyaKbn</td><td colspan="3">会計担当者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIRIKAIKEITANTOU}</td><td>&quot;01&quot;</td><td>経理会計担当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIGYOUHIKAIKEITANTOU}</td><td>&quot;02&quot;</td><td>事業費会計担当</td></tr>
 * </table>
 */
public class C_KaikeitantousyaKbn extends Classification<C_KaikeitantousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KaikeitantousyaKbn BLNK = new C_KaikeitantousyaKbn("00");

    public static final C_KaikeitantousyaKbn KEIRIKAIKEITANTOU = new C_KaikeitantousyaKbn("01");

    public static final C_KaikeitantousyaKbn JIGYOUHIKAIKEITANTOU = new C_KaikeitantousyaKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KEIRIKAIKEITANTOU, "KEIRIKAIKEITANTOU", false);
        addPattern(PATTERN_DEFAULT, JIGYOUHIKAIKEITANTOU, "JIGYOUHIKAIKEITANTOU", false);


        lock(C_KaikeitantousyaKbn.class);
    }

    private C_KaikeitantousyaKbn(String value) {
        super(value);
    }

    public static C_KaikeitantousyaKbn valueOf(String value) {
        return valueOf(C_KaikeitantousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KaikeitantousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KaikeitantousyaKbn.class, patternId, value);
    }
}
