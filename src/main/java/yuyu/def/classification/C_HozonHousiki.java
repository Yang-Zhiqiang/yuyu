
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保存方式 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HozonHousiki</td><td colspan="3">保存方式</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #LOCAL}</td><td>&quot;LOCAL&quot;</td><td>ローカル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILESERVER}</td><td>&quot;FILESERVER&quot;</td><td>ファイルサーバ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB}</td><td>&quot;DB&quot;</td><td>データベース</td></tr>
 * </table>
 */
public class C_HozonHousiki extends Classification<C_HozonHousiki> {

    private static final long serialVersionUID = 1L;


    public static final C_HozonHousiki LOCAL = new C_HozonHousiki("LOCAL");

    public static final C_HozonHousiki FILESERVER = new C_HozonHousiki("FILESERVER");

    public static final C_HozonHousiki DB = new C_HozonHousiki("DB");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, LOCAL, "LOCAL", true);
        addPattern(PATTERN_DEFAULT, FILESERVER, "FILESERVER", false);
        addPattern(PATTERN_DEFAULT, DB, "DB", false);


        lock(C_HozonHousiki.class);
    }

    private C_HozonHousiki(String value) {
        super(value);
    }

    public static C_HozonHousiki valueOf(String value) {
        return valueOf(C_HozonHousiki.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HozonHousiki.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HozonHousiki.class, patternId, value);
    }
}
