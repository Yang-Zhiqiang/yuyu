
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店商品コード用払込回数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtsyouhincdHrkkaisuu</td><td colspan="3">代理店商品コード用払込回数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;1&quot;</td><td>一時払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEIJYUN}</td><td>&quot;2&quot;</td><td>平準払い</td></tr>
 * </table>
 */
public class C_DrtsyouhincdHrkkaisuu extends Classification<C_DrtsyouhincdHrkkaisuu> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtsyouhincdHrkkaisuu BLNK = new C_DrtsyouhincdHrkkaisuu("0");

    public static final C_DrtsyouhincdHrkkaisuu ITIJI = new C_DrtsyouhincdHrkkaisuu("1");

    public static final C_DrtsyouhincdHrkkaisuu HEIJYUN = new C_DrtsyouhincdHrkkaisuu("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, HEIJYUN, "HEIJYUN", false);


        lock(C_DrtsyouhincdHrkkaisuu.class);
    }

    private C_DrtsyouhincdHrkkaisuu(String value) {
        super(value);
    }

    public static C_DrtsyouhincdHrkkaisuu valueOf(String value) {
        return valueOf(C_DrtsyouhincdHrkkaisuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtsyouhincdHrkkaisuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtsyouhincdHrkkaisuu.class, patternId, value);
    }
}
