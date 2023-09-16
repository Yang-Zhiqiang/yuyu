
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求種別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeikyuuSyubetu</td><td colspan="3">請求種別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYH}</td><td>&quot;1&quot;</td><td>給付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB}</td><td>&quot;2&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSG}</td><td>&quot;3&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LN}</td><td>&quot;4&quot;</td><td>リビングニーズ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PM}</td><td>&quot;5&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKRUKTK}</td><td>&quot;6&quot;</td><td>死亡仮受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SDSSHR}</td><td>&quot;7&quot;</td><td>診断書料支払</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_HK HK}<br />(保険金)</td><td align="center">○</td><td>{@link #SB}</td><td>&quot;2&quot;</td><td>死亡</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_HKSYOUKAI HKSYOUKAI}<br />(保険金照会)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB}</td><td>&quot;2&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKRUKTK}</td><td>&quot;6&quot;</td><td>死亡仮受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SDSSHR}</td><td>&quot;7&quot;</td><td>診断書料支払</td></tr>
 * </table>
 */
public class C_SeikyuuSyubetu extends Classification<C_SeikyuuSyubetu> {

    private static final long serialVersionUID = 1L;


    public static final C_SeikyuuSyubetu BLNK = new C_SeikyuuSyubetu("0");

    public static final C_SeikyuuSyubetu KYH = new C_SeikyuuSyubetu("1");

    public static final C_SeikyuuSyubetu SB = new C_SeikyuuSyubetu("2");

    public static final C_SeikyuuSyubetu KOUSG = new C_SeikyuuSyubetu("3");

    public static final C_SeikyuuSyubetu LN = new C_SeikyuuSyubetu("4");

    public static final C_SeikyuuSyubetu PM = new C_SeikyuuSyubetu("5");

    public static final C_SeikyuuSyubetu SBKRUKTK = new C_SeikyuuSyubetu("6");

    public static final C_SeikyuuSyubetu SDSSHR = new C_SeikyuuSyubetu("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HK = "2";

    public static final String PATTERN_HKSYOUKAI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYH, "KYH", false);
        addPattern(PATTERN_DEFAULT, SB, "SB", false);
        addPattern(PATTERN_DEFAULT, KOUSG, "KOUSG", false);
        addPattern(PATTERN_DEFAULT, LN, "LN", false);
        addPattern(PATTERN_DEFAULT, PM, "PM", false);
        addPattern(PATTERN_DEFAULT, SBKRUKTK, "SBKRUKTK", false);
        addPattern(PATTERN_DEFAULT, SDSSHR, "SDSSHR", false);


        addPattern(PATTERN_HK, SB, "SB", true);


        addPattern(PATTERN_HKSYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_HKSYOUKAI, SB, "SB", false);
        addPattern(PATTERN_HKSYOUKAI, SBKRUKTK, "SBKRUKTK", false);
        addPattern(PATTERN_HKSYOUKAI, SDSSHR, "SDSSHR", false);


        lock(C_SeikyuuSyubetu.class);
    }

    private C_SeikyuuSyubetu(String value) {
        super(value);
    }

    public static C_SeikyuuSyubetu valueOf(String value) {
        return valueOf(C_SeikyuuSyubetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeikyuuSyubetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeikyuuSyubetu.class, patternId, value);
    }
}
