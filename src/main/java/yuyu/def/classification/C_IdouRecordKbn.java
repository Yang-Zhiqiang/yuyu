
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 異動レコード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IdouRecordKbn</td><td colspan="3">異動レコード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MINUSRECORD}</td><td>&quot;1&quot;</td><td>マイナスレコード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PLUSRECORD}</td><td>&quot;2&quot;</td><td>プラスレコード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINGLERECORD}</td><td>&quot;3&quot;</td><td>単レコード</td></tr>
 * </table>
 */
public class C_IdouRecordKbn extends Classification<C_IdouRecordKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IdouRecordKbn MINUSRECORD = new C_IdouRecordKbn("1");

    public static final C_IdouRecordKbn PLUSRECORD = new C_IdouRecordKbn("2");

    public static final C_IdouRecordKbn SINGLERECORD = new C_IdouRecordKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MINUSRECORD, "MINUSRECORD", true);
        addPattern(PATTERN_DEFAULT, PLUSRECORD, "PLUSRECORD", false);
        addPattern(PATTERN_DEFAULT, SINGLERECORD, "SINGLERECORD", false);


        lock(C_IdouRecordKbn.class);
    }

    private C_IdouRecordKbn(String value) {
        super(value);
    }

    public static C_IdouRecordKbn valueOf(String value) {
        return valueOf(C_IdouRecordKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IdouRecordKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IdouRecordKbn.class, patternId, value);
    }
}
