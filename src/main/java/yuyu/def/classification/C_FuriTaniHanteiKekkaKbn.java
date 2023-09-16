
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替伝票単位判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FuriTaniHanteiKekkaKbn</td><td colspan="3">振替伝票単位判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUDEN}</td><td>&quot;1&quot;</td><td>別伝票単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITUDEN}</td><td>&quot;2&quot;</td><td>同一伝票単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITUDENMEISAI}</td><td>&quot;3&quot;</td><td>同一伝票明細単位</td></tr>
 * </table>
 */
public class C_FuriTaniHanteiKekkaKbn extends Classification<C_FuriTaniHanteiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FuriTaniHanteiKekkaKbn BLNK = new C_FuriTaniHanteiKekkaKbn("0");

    public static final C_FuriTaniHanteiKekkaKbn BETUDEN = new C_FuriTaniHanteiKekkaKbn("1");

    public static final C_FuriTaniHanteiKekkaKbn DOUITUDEN = new C_FuriTaniHanteiKekkaKbn("2");

    public static final C_FuriTaniHanteiKekkaKbn DOUITUDENMEISAI = new C_FuriTaniHanteiKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BETUDEN, "BETUDEN", false);
        addPattern(PATTERN_DEFAULT, DOUITUDEN, "DOUITUDEN", false);
        addPattern(PATTERN_DEFAULT, DOUITUDENMEISAI, "DOUITUDENMEISAI", false);


        lock(C_FuriTaniHanteiKekkaKbn.class);
    }

    private C_FuriTaniHanteiKekkaKbn(String value) {
        super(value);
    }

    public static C_FuriTaniHanteiKekkaKbn valueOf(String value) {
        return valueOf(C_FuriTaniHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FuriTaniHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FuriTaniHanteiKekkaKbn.class, patternId, value);
    }
}
