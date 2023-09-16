
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 為替レート種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KawaserateSyuruiKbn</td><td colspan="3">為替レート種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJIKAWASERATE}</td><td>&quot;1&quot;</td><td>公示為替レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PM17JIKAWASERATE}</td><td>&quot;3&quot;</td><td>１７時為替レート</td></tr>
 * </table>
 */
public class C_KawaserateSyuruiKbn extends Classification<C_KawaserateSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KawaserateSyuruiKbn BLNK = new C_KawaserateSyuruiKbn("0");

    public static final C_KawaserateSyuruiKbn KOUJIKAWASERATE = new C_KawaserateSyuruiKbn("1");

    public static final C_KawaserateSyuruiKbn PM17JIKAWASERATE = new C_KawaserateSyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUJIKAWASERATE, "KOUJIKAWASERATE", false);
        addPattern(PATTERN_DEFAULT, PM17JIKAWASERATE, "PM17JIKAWASERATE", false);


        lock(C_KawaserateSyuruiKbn.class);
    }

    private C_KawaserateSyuruiKbn(String value) {
        super(value);
    }

    public static C_KawaserateSyuruiKbn valueOf(String value) {
        return valueOf(C_KawaserateSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KawaserateSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KawaserateSyuruiKbn.class, patternId, value);
    }
}
