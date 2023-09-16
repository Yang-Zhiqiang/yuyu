
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ファイルステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FileStatusKbn</td><td colspan="3">ファイルステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;N&quot;</td><td>状態なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOWNLOADING}</td><td>&quot;D&quot;</td><td>ダウンロード中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPLOADING}</td><td>&quot;U&quot;</td><td>アップロード中</td></tr>
 * </table>
 */
public class C_FileStatusKbn extends Classification<C_FileStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FileStatusKbn NONE = new C_FileStatusKbn("N");

    public static final C_FileStatusKbn DOWNLOADING = new C_FileStatusKbn("D");

    public static final C_FileStatusKbn UPLOADING = new C_FileStatusKbn("U");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, DOWNLOADING, "DOWNLOADING", false);
        addPattern(PATTERN_DEFAULT, UPLOADING, "UPLOADING", false);


        lock(C_FileStatusKbn.class);
    }

    private C_FileStatusKbn(String value) {
        super(value);
    }

    public static C_FileStatusKbn valueOf(String value) {
        return valueOf(C_FileStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FileStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FileStatusKbn.class, patternId, value);
    }
}
