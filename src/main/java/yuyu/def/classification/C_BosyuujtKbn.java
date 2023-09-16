
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集人状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosyuujtKbn</td><td colspan="3">募集人状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUKANOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUMAE}</td><td>&quot;2&quot;</td><td>登録前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUHAI}</td><td>&quot;3&quot;</td><td>業廃</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUBOSYUU}</td><td>&quot;4&quot;</td><td>無募集</td></tr>
 * </table>
 */
public class C_BosyuujtKbn extends Classification<C_BosyuujtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosyuujtKbn BLNK = new C_BosyuujtKbn("0");

    public static final C_BosyuujtKbn BOSYUUKANOU = new C_BosyuujtKbn("1");

    public static final C_BosyuujtKbn TOUROKUMAE = new C_BosyuujtKbn("2");

    public static final C_BosyuujtKbn GYOUHAI = new C_BosyuujtKbn("3");

    public static final C_BosyuujtKbn MUBOSYUU = new C_BosyuujtKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYUUKANOU, "BOSYUUKANOU", false);
        addPattern(PATTERN_DEFAULT, TOUROKUMAE, "TOUROKUMAE", false);
        addPattern(PATTERN_DEFAULT, GYOUHAI, "GYOUHAI", false);
        addPattern(PATTERN_DEFAULT, MUBOSYUU, "MUBOSYUU", false);


        lock(C_BosyuujtKbn.class);
    }

    private C_BosyuujtKbn(String value) {
        super(value);
    }

    public static C_BosyuujtKbn valueOf(String value) {
        return valueOf(C_BosyuujtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosyuujtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosyuujtKbn.class, patternId, value);
    }
}
