
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 平準払管理通貨判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HijynbrKanritukaHantKbn</td><td colspan="3">平準払管理通貨判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKDTYENHRKGKKOTEI}</td><td>&quot;1&quot;</td><td>外貨建円貨払込額固定</td></tr>
 * </table>
 */
public class C_HijynbrKanritukaHantKbn extends Classification<C_HijynbrKanritukaHantKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HijynbrKanritukaHantKbn BLNK = new C_HijynbrKanritukaHantKbn("0");

    public static final C_HijynbrKanritukaHantKbn GKDTYENHRKGKKOTEI = new C_HijynbrKanritukaHantKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GKDTYENHRKGKKOTEI, "GKDTYENHRKGKKOTEI", false);


        lock(C_HijynbrKanritukaHantKbn.class);
    }

    private C_HijynbrKanritukaHantKbn(String value) {
        super(value);
    }

    public static C_HijynbrKanritukaHantKbn valueOf(String value) {
        return valueOf(C_HijynbrKanritukaHantKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HijynbrKanritukaHantKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HijynbrKanritukaHantKbn.class, patternId, value);
    }
}
