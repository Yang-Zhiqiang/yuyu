
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険種類記号世代区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HokenSyuruiKigouSedaiKbn</td><td colspan="3">保険種類記号世代区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU17}</td><td>&quot;J&quot;</td><td>２０１７料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU18_4}</td><td>&quot;K&quot;</td><td>２０１８料率（４月）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU18_8}</td><td>&quot;L&quot;</td><td>２０１８料率（８月）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU17}</td><td>&quot;J&quot;</td><td>Ｊ：２０１７料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU18_4}</td><td>&quot;K&quot;</td><td>Ｋ：２０１８料率（４月）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOU18_8}</td><td>&quot;L&quot;</td><td>Ｌ：２０１８料率（８月）</td></tr>
 * </table>
 */
public class C_HokenSyuruiKigouSedaiKbn extends Classification<C_HokenSyuruiKigouSedaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HokenSyuruiKigouSedaiKbn BLNK = new C_HokenSyuruiKigouSedaiKbn("0");

    public static final C_HokenSyuruiKigouSedaiKbn RYOU17 = new C_HokenSyuruiKigouSedaiKbn("J");

    public static final C_HokenSyuruiKigouSedaiKbn RYOU18_4 = new C_HokenSyuruiKigouSedaiKbn("K");

    public static final C_HokenSyuruiKigouSedaiKbn RYOU18_8 = new C_HokenSyuruiKigouSedaiKbn("L");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RYOU17, "RYOU17", false);
        addPattern(PATTERN_DEFAULT, RYOU18_4, "RYOU18_4", false);
        addPattern(PATTERN_DEFAULT, RYOU18_8, "RYOU18_8", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, RYOU17, "RYOU17", false);
        addPattern(PATTERN_SELECT, RYOU18_4, "RYOU18_4", false);
        addPattern(PATTERN_SELECT, RYOU18_8, "RYOU18_8", false);


        lock(C_HokenSyuruiKigouSedaiKbn.class);
    }

    private C_HokenSyuruiKigouSedaiKbn(String value) {
        super(value);
    }

    public static C_HokenSyuruiKigouSedaiKbn valueOf(String value) {
        return valueOf(C_HokenSyuruiKigouSedaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HokenSyuruiKigouSedaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HokenSyuruiKigouSedaiKbn.class, patternId, value);
    }
}
