
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 索引通算照会区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuintsnSyoukaiKbn</td><td colspan="3">索引通算照会区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKEYSYOUKAI}</td><td>&quot;1&quot;</td><td>契約キー照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGISYOUKAI}</td><td>&quot;2&quot;</td><td>名義照会</td></tr>
 * </table>
 */
public class C_SakuintsnSyoukaiKbn extends Classification<C_SakuintsnSyoukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuintsnSyoukaiKbn BLNK = new C_SakuintsnSyoukaiKbn("0");

    public static final C_SakuintsnSyoukaiKbn KYKKEYSYOUKAI = new C_SakuintsnSyoukaiKbn("1");

    public static final C_SakuintsnSyoukaiKbn MEIGISYOUKAI = new C_SakuintsnSyoukaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKKEYSYOUKAI, "KYKKEYSYOUKAI", false);
        addPattern(PATTERN_DEFAULT, MEIGISYOUKAI, "MEIGISYOUKAI", false);


        lock(C_SakuintsnSyoukaiKbn.class);
    }

    private C_SakuintsnSyoukaiKbn(String value) {
        super(value);
    }

    public static C_SakuintsnSyoukaiKbn valueOf(String value) {
        return valueOf(C_SakuintsnSyoukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuintsnSyoukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuintsnSyoukaiKbn.class, patternId, value);
    }
}
