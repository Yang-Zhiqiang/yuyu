
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 商品分類積立金予測区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouhnBunruiTmttkinyskKbn</td><td colspan="3">商品分類積立金予測区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JGRO}</td><td>&quot;01&quot;</td><td>Ｊロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JGRO2}</td><td>&quot;02&quot;</td><td>ＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANOGRO_SISU}</td><td>&quot;03&quot;</td><td>たのしみグローバル（指数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANOGRO_TEIRITU}</td><td>&quot;04&quot;</td><td>たのしみグローバル（定率）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANOGRO2_SISU}</td><td>&quot;05&quot;</td><td>たのしみグローバルⅡ（指数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANOGRO2_TEIRITU_TEIKI_NASI}</td><td>&quot;06&quot;</td><td>たのしみグローバルⅡ（定率）（定期支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANOGRO2_TEIRITU_TEIKI_ARI}</td><td>&quot;07&quot;</td><td>たのしみグローバルⅡ（定率）（定期支払あり）</td></tr>
 * </table>
 */
public class C_SyouhnBunruiTmttkinyskKbn extends Classification<C_SyouhnBunruiTmttkinyskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouhnBunruiTmttkinyskKbn BLNK = new C_SyouhnBunruiTmttkinyskKbn("0");

    public static final C_SyouhnBunruiTmttkinyskKbn JGRO = new C_SyouhnBunruiTmttkinyskKbn("01");

    public static final C_SyouhnBunruiTmttkinyskKbn JGRO2 = new C_SyouhnBunruiTmttkinyskKbn("02");

    public static final C_SyouhnBunruiTmttkinyskKbn TANOGRO_SISU = new C_SyouhnBunruiTmttkinyskKbn("03");

    public static final C_SyouhnBunruiTmttkinyskKbn TANOGRO_TEIRITU = new C_SyouhnBunruiTmttkinyskKbn("04");

    public static final C_SyouhnBunruiTmttkinyskKbn TANOGRO2_SISU = new C_SyouhnBunruiTmttkinyskKbn("05");

    public static final C_SyouhnBunruiTmttkinyskKbn TANOGRO2_TEIRITU_TEIKI_NASI = new C_SyouhnBunruiTmttkinyskKbn("06");

    public static final C_SyouhnBunruiTmttkinyskKbn TANOGRO2_TEIRITU_TEIKI_ARI = new C_SyouhnBunruiTmttkinyskKbn("07");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JGRO, "JGRO", false);
        addPattern(PATTERN_DEFAULT, JGRO2, "JGRO2", false);
        addPattern(PATTERN_DEFAULT, TANOGRO_SISU, "TANOGRO_SISU", false);
        addPattern(PATTERN_DEFAULT, TANOGRO_TEIRITU, "TANOGRO_TEIRITU", false);
        addPattern(PATTERN_DEFAULT, TANOGRO2_SISU, "TANOGRO2_SISU", false);
        addPattern(PATTERN_DEFAULT, TANOGRO2_TEIRITU_TEIKI_NASI, "TANOGRO2_TEIRITU_TEIKI_NASI", false);
        addPattern(PATTERN_DEFAULT, TANOGRO2_TEIRITU_TEIKI_ARI, "TANOGRO2_TEIRITU_TEIKI_ARI", false);


        lock(C_SyouhnBunruiTmttkinyskKbn.class);
    }

    private C_SyouhnBunruiTmttkinyskKbn(String value) {
        super(value);
    }

    public static C_SyouhnBunruiTmttkinyskKbn valueOf(String value) {
        return valueOf(C_SyouhnBunruiTmttkinyskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouhnBunruiTmttkinyskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouhnBunruiTmttkinyskKbn.class, patternId, value);
    }
}
