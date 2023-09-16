
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 設計書申込書作成エラー出力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SekmossakuseiErroutKbn</td><td colspan="3">設計書申込書作成エラー出力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAMEN}</td><td>&quot;1&quot;</td><td>画面メッセージ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERRORSHEET}</td><td>&quot;2&quot;</td><td>エラーシートメッセージ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;3&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SekmossakuseiErroutKbn extends Classification<C_SekmossakuseiErroutKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SekmossakuseiErroutKbn NONE = new C_SekmossakuseiErroutKbn("0");

    public static final C_SekmossakuseiErroutKbn GAMEN = new C_SekmossakuseiErroutKbn("1");

    public static final C_SekmossakuseiErroutKbn ERRORSHEET = new C_SekmossakuseiErroutKbn("2");

    public static final C_SekmossakuseiErroutKbn SONOTA = new C_SekmossakuseiErroutKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, GAMEN, "GAMEN", false);
        addPattern(PATTERN_DEFAULT, ERRORSHEET, "ERRORSHEET", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SekmossakuseiErroutKbn.class);
    }

    private C_SekmossakuseiErroutKbn(String value) {
        super(value);
    }

    public static C_SekmossakuseiErroutKbn valueOf(String value) {
        return valueOf(C_SekmossakuseiErroutKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SekmossakuseiErroutKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SekmossakuseiErroutKbn.class, patternId, value);
    }
}
