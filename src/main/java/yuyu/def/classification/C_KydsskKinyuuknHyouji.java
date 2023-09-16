
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 協同組織金融機関表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KydsskKinyuuknHyouji</td><td colspan="3">協同組織金融機関表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUDOUSOSIKI}</td><td>&quot;1&quot;</td><td>協同組織金融機関</td></tr>
 * </table>
 */
public class C_KydsskKinyuuknHyouji extends Classification<C_KydsskKinyuuknHyouji> {

    private static final long serialVersionUID = 1L;


    public static final C_KydsskKinyuuknHyouji BLNK = new C_KydsskKinyuuknHyouji("0");

    public static final C_KydsskKinyuuknHyouji KYOUDOUSOSIKI = new C_KydsskKinyuuknHyouji("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYOUDOUSOSIKI, "KYOUDOUSOSIKI", false);


        lock(C_KydsskKinyuuknHyouji.class);
    }

    private C_KydsskKinyuuknHyouji(String value) {
        super(value);
    }

    public static C_KydsskKinyuuknHyouji valueOf(String value) {
        return valueOf(C_KydsskKinyuuknHyouji.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KydsskKinyuuknHyouji.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KydsskKinyuuknHyouji.class, patternId, value);
    }
}
