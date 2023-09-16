
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金照会区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyksyoukaiKbn</td><td colspan="3">入金照会区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUNYUUKINNSISAN}</td><td>&quot;1&quot;</td><td>前納入金試算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUPNYUUKINNSISAN}</td><td>&quot;2&quot;</td><td>継続Ｐ入金試算</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUPNYUUKINNSISAN}</td><td>&quot;2&quot;</td><td>継続Ｐ入金試算</td></tr>
 * </table>
 */
public class C_NyksyoukaiKbn extends Classification<C_NyksyoukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyksyoukaiKbn BLNK = new C_NyksyoukaiKbn("0");

    public static final C_NyksyoukaiKbn ZENNOUNYUUKINNSISAN = new C_NyksyoukaiKbn("1");

    public static final C_NyksyoukaiKbn KEIZOKUPNYUUKINNSISAN = new C_NyksyoukaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENNOUNYUUKINNSISAN, "ZENNOUNYUUKINNSISAN", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUPNYUUKINNSISAN, "KEIZOKUPNYUUKINNSISAN", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KEIZOKUPNYUUKINNSISAN, "KEIZOKUPNYUUKINNSISAN", false);


        lock(C_NyksyoukaiKbn.class);
    }

    private C_NyksyoukaiKbn(String value) {
        super(value);
    }

    public static C_NyksyoukaiKbn valueOf(String value) {
        return valueOf(C_NyksyoukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyksyoukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyksyoukaiKbn.class, patternId, value);
    }
}
