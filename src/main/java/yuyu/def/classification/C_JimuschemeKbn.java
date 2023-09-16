
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 事務スキーム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JimuschemeKbn</td><td colspan="3">事務スキーム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;01&quot;</td><td>ショップ系スキーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN}</td><td>&quot;02&quot;</td><td>窓販系スキーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGIN}</td><td>&quot;03&quot;</td><td>地銀系スキーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENSINKYOU}</td><td>&quot;04&quot;</td><td>全信協系スキーム</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #SHOP}</td><td>&quot;01&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MADOHAN}</td><td>&quot;02&quot;</td><td>窓販</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGIN}</td><td>&quot;03&quot;</td><td>地銀</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENSINKYOU}</td><td>&quot;04&quot;</td><td>全信協</td></tr>
 * </table>
 */
public class C_JimuschemeKbn extends Classification<C_JimuschemeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JimuschemeKbn BLNK = new C_JimuschemeKbn("00");

    public static final C_JimuschemeKbn SHOP = new C_JimuschemeKbn("01");

    public static final C_JimuschemeKbn MADOHAN = new C_JimuschemeKbn("02");

    public static final C_JimuschemeKbn TIGIN = new C_JimuschemeKbn("03");

    public static final C_JimuschemeKbn ZENSINKYOU = new C_JimuschemeKbn("04");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, MADOHAN, "MADOHAN", false);
        addPattern(PATTERN_DEFAULT, TIGIN, "TIGIN", false);
        addPattern(PATTERN_DEFAULT, ZENSINKYOU, "ZENSINKYOU", false);


        addPattern(PATTERN_SELECT, SHOP, "SHOP", true);
        addPattern(PATTERN_SELECT, MADOHAN, "MADOHAN", false);
        addPattern(PATTERN_SELECT, TIGIN, "TIGIN", false);
        addPattern(PATTERN_SELECT, ZENSINKYOU, "ZENSINKYOU", false);


        lock(C_JimuschemeKbn.class);
    }

    private C_JimuschemeKbn(String value) {
        super(value);
    }

    public static C_JimuschemeKbn valueOf(String value) {
        return valueOf(C_JimuschemeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JimuschemeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JimuschemeKbn.class, patternId, value);
    }
}
