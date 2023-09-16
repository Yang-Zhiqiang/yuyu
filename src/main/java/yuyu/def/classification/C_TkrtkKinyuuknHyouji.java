
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特例地域金融機関表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkrtkKinyuuknHyouji</td><td colspan="3">特例地域金融機関表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUREITIIKI}</td><td>&quot;1&quot;</td><td>特例地域金融機関</td></tr>
 * </table>
 */
public class C_TkrtkKinyuuknHyouji extends Classification<C_TkrtkKinyuuknHyouji> {

    private static final long serialVersionUID = 1L;


    public static final C_TkrtkKinyuuknHyouji BLNK = new C_TkrtkKinyuuknHyouji("0");

    public static final C_TkrtkKinyuuknHyouji TOKUREITIIKI = new C_TkrtkKinyuuknHyouji("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOKUREITIIKI, "TOKUREITIIKI", false);


        lock(C_TkrtkKinyuuknHyouji.class);
    }

    private C_TkrtkKinyuuknHyouji(String value) {
        super(value);
    }

    public static C_TkrtkKinyuuknHyouji valueOf(String value) {
        return valueOf(C_TkrtkKinyuuknHyouji.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkrtkKinyuuknHyouji.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkrtkKinyuuknHyouji.class, patternId, value);
    }
}
