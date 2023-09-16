
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取消理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrksriyuuKbn</td><td colspan="3">取消理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAYOUBOU}</td><td>&quot;1&quot;</td><td>お客様要望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_TrksriyuuKbn extends Classification<C_TrksriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrksriyuuKbn BLNK = new C_TrksriyuuKbn("0");

    public static final C_TrksriyuuKbn OKYAKUSAMAYOUBOU = new C_TrksriyuuKbn("1");

    public static final C_TrksriyuuKbn SONOTA = new C_TrksriyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAYOUBOU, "OKYAKUSAMAYOUBOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_TrksriyuuKbn.class);
    }

    private C_TrksriyuuKbn(String value) {
        super(value);
    }

    public static C_TrksriyuuKbn valueOf(String value) {
        return valueOf(C_TrksriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrksriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrksriyuuKbn.class, patternId, value);
    }
}
