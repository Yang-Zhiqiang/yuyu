
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ファイル種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FileSyuruiKbn</td><td colspan="3">ファイル種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DOWNLOAD}</td><td>&quot;D&quot;</td><td>ダウンロード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPLOAD}</td><td>&quot;U&quot;</td><td>アップロード</td></tr>
 * </table>
 */
public class C_FileSyuruiKbn extends Classification<C_FileSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FileSyuruiKbn DOWNLOAD = new C_FileSyuruiKbn("D");

    public static final C_FileSyuruiKbn UPLOAD = new C_FileSyuruiKbn("U");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DOWNLOAD, "DOWNLOAD", true);
        addPattern(PATTERN_DEFAULT, UPLOAD, "UPLOAD", false);


        lock(C_FileSyuruiKbn.class);
    }

    private C_FileSyuruiKbn(String value) {
        super(value);
    }

    public static C_FileSyuruiKbn valueOf(String value) {
        return valueOf(C_FileSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FileSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FileSyuruiKbn.class, patternId, value);
    }
}
