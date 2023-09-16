
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * レコード種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RecordsyuruiKbn</td><td colspan="3">レコード種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HEADER_REC}</td><td>&quot;1&quot;</td><td>ヘッダーレコード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATA_REC}</td><td>&quot;2&quot;</td><td>データレコード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRAILER_REC}</td><td>&quot;3&quot;</td><td>トレーラレコード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #END_REC}</td><td>&quot;4&quot;</td><td>エンドレコード</td></tr>
 * </table>
 */
public class C_RecordsyuruiKbn extends Classification<C_RecordsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RecordsyuruiKbn HEADER_REC = new C_RecordsyuruiKbn("1");

    public static final C_RecordsyuruiKbn DATA_REC = new C_RecordsyuruiKbn("2");

    public static final C_RecordsyuruiKbn TRAILER_REC = new C_RecordsyuruiKbn("3");

    public static final C_RecordsyuruiKbn END_REC = new C_RecordsyuruiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HEADER_REC, "HEADER_REC", true);
        addPattern(PATTERN_DEFAULT, DATA_REC, "DATA_REC", false);
        addPattern(PATTERN_DEFAULT, TRAILER_REC, "TRAILER_REC", false);
        addPattern(PATTERN_DEFAULT, END_REC, "END_REC", false);


        lock(C_RecordsyuruiKbn.class);
    }

    private C_RecordsyuruiKbn(String value) {
        super(value);
    }

    public static C_RecordsyuruiKbn valueOf(String value) {
        return valueOf(C_RecordsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RecordsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RecordsyuruiKbn.class, patternId, value);
    }
}
