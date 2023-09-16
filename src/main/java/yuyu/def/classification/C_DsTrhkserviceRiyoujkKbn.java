
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ取引サービス利用状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsTrhkserviceRiyoujkKbn</td><td colspan="3">ＤＳ取引サービス利用状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOU_KA}</td><td>&quot;1&quot;</td><td>利用可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOU_HUKA}</td><td>&quot;2&quot;</td><td>利用不可</td></tr>
 * </table>
 */
public class C_DsTrhkserviceRiyoujkKbn extends Classification<C_DsTrhkserviceRiyoujkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsTrhkserviceRiyoujkKbn BLNK = new C_DsTrhkserviceRiyoujkKbn("0");

    public static final C_DsTrhkserviceRiyoujkKbn RIYOU_KA = new C_DsTrhkserviceRiyoujkKbn("1");

    public static final C_DsTrhkserviceRiyoujkKbn RIYOU_HUKA = new C_DsTrhkserviceRiyoujkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RIYOU_KA, "RIYOU_KA", false);
        addPattern(PATTERN_DEFAULT, RIYOU_HUKA, "RIYOU_HUKA", false);


        lock(C_DsTrhkserviceRiyoujkKbn.class);
    }

    private C_DsTrhkserviceRiyoujkKbn(String value) {
        super(value);
    }

    public static C_DsTrhkserviceRiyoujkKbn valueOf(String value) {
        return valueOf(C_DsTrhkserviceRiyoujkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsTrhkserviceRiyoujkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsTrhkserviceRiyoujkKbn.class, patternId, value);
    }
}
