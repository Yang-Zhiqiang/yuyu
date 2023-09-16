
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理案内不要理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriAnnaiFuyouRiyuuKbn</td><td colspan="3">数理案内不要理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ANNAITYUU}</td><td>&quot;00&quot;</td><td>案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;01&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN_KURISAGE}</td><td>&quot;02&quot;</td><td>払満・繰下げ</td></tr>
 * </table>
 */
public class C_SuuriAnnaiFuyouRiyuuKbn extends Classification<C_SuuriAnnaiFuyouRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriAnnaiFuyouRiyuuKbn ANNAITYUU = new C_SuuriAnnaiFuyouRiyuuKbn("00");

    public static final C_SuuriAnnaiFuyouRiyuuKbn ITIJI = new C_SuuriAnnaiFuyouRiyuuKbn("01");

    public static final C_SuuriAnnaiFuyouRiyuuKbn HARAIMAN_KURISAGE = new C_SuuriAnnaiFuyouRiyuuKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ANNAITYUU, "ANNAITYUU", true);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN_KURISAGE, "HARAIMAN_KURISAGE", false);


        lock(C_SuuriAnnaiFuyouRiyuuKbn.class);
    }

    private C_SuuriAnnaiFuyouRiyuuKbn(String value) {
        super(value);
    }

    public static C_SuuriAnnaiFuyouRiyuuKbn valueOf(String value) {
        return valueOf(C_SuuriAnnaiFuyouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriAnnaiFuyouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriAnnaiFuyouRiyuuKbn.class, patternId, value);
    }
}
