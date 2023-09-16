
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当状態判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitoujyoutaiHanteiKbn</td><td colspan="3">配当状態判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DHANEI_TIENNASI}</td><td>&quot;1&quot;</td><td>配当反映遅れなし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DHANEI_SUMI}</td><td>&quot;11&quot;</td><td>配当反映済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DHANEI_MITOURAI}</td><td>&quot;12&quot;</td><td>初回配当金支払日未到来</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DHANEI_TIEN1}</td><td>&quot;21&quot;</td><td>配当反映遅れ（１年）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DHANEI_TIEN2}</td><td>&quot;31&quot;</td><td>配当反映遅れ（２年以上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MF_HUSEIGOU}</td><td>&quot;41&quot;</td><td>ＭＦ不整合</td></tr>
 * </table>
 */
public class C_HaitoujyoutaiHanteiKbn extends Classification<C_HaitoujyoutaiHanteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitoujyoutaiHanteiKbn BLNK = new C_HaitoujyoutaiHanteiKbn("0");

    public static final C_HaitoujyoutaiHanteiKbn DHANEI_TIENNASI = new C_HaitoujyoutaiHanteiKbn("1");

    public static final C_HaitoujyoutaiHanteiKbn DHANEI_SUMI = new C_HaitoujyoutaiHanteiKbn("11");

    public static final C_HaitoujyoutaiHanteiKbn DHANEI_MITOURAI = new C_HaitoujyoutaiHanteiKbn("12");

    public static final C_HaitoujyoutaiHanteiKbn DHANEI_TIEN1 = new C_HaitoujyoutaiHanteiKbn("21");

    public static final C_HaitoujyoutaiHanteiKbn DHANEI_TIEN2 = new C_HaitoujyoutaiHanteiKbn("31");

    public static final C_HaitoujyoutaiHanteiKbn MF_HUSEIGOU = new C_HaitoujyoutaiHanteiKbn("41");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DHANEI_TIENNASI, "DHANEI_TIENNASI", false);
        addPattern(PATTERN_DEFAULT, DHANEI_SUMI, "DHANEI_SUMI", false);
        addPattern(PATTERN_DEFAULT, DHANEI_MITOURAI, "DHANEI_MITOURAI", false);
        addPattern(PATTERN_DEFAULT, DHANEI_TIEN1, "DHANEI_TIEN1", false);
        addPattern(PATTERN_DEFAULT, DHANEI_TIEN2, "DHANEI_TIEN2", false);
        addPattern(PATTERN_DEFAULT, MF_HUSEIGOU, "MF_HUSEIGOU", false);


        lock(C_HaitoujyoutaiHanteiKbn.class);
    }

    private C_HaitoujyoutaiHanteiKbn(String value) {
        super(value);
    }

    public static C_HaitoujyoutaiHanteiKbn valueOf(String value) {
        return valueOf(C_HaitoujyoutaiHanteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitoujyoutaiHanteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitoujyoutaiHanteiKbn.class, patternId, value);
    }
}
