
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振込依頼書印刷対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkmiraiinsatuKbn</td><td colspan="3">振込依頼書印刷対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI1KAIPJUUTOUKIN}</td><td>&quot;1&quot;</td><td>第１回保険料充当金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKANYUUKIN}</td><td>&quot;2&quot;</td><td>追加入金</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #DAI1KAIPJUUTOUKIN}</td><td>&quot;1&quot;</td><td>第１回保険料充当金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKANYUUKIN}</td><td>&quot;2&quot;</td><td>追加入金</td></tr>
 * </table>
 */
public class C_HrkmiraiinsatuKbn extends Classification<C_HrkmiraiinsatuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkmiraiinsatuKbn BLNK = new C_HrkmiraiinsatuKbn("0");

    public static final C_HrkmiraiinsatuKbn DAI1KAIPJUUTOUKIN = new C_HrkmiraiinsatuKbn("1");

    public static final C_HrkmiraiinsatuKbn TUIKANYUUKIN = new C_HrkmiraiinsatuKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAI1KAIPJUUTOUKIN, "DAI1KAIPJUUTOUKIN", false);
        addPattern(PATTERN_DEFAULT, TUIKANYUUKIN, "TUIKANYUUKIN", false);


        addPattern(PATTERN_NOBLNK, DAI1KAIPJUUTOUKIN, "DAI1KAIPJUUTOUKIN", true);
        addPattern(PATTERN_NOBLNK, TUIKANYUUKIN, "TUIKANYUUKIN", false);


        lock(C_HrkmiraiinsatuKbn.class);
    }

    private C_HrkmiraiinsatuKbn(String value) {
        super(value);
    }

    public static C_HrkmiraiinsatuKbn valueOf(String value) {
        return valueOf(C_HrkmiraiinsatuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkmiraiinsatuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkmiraiinsatuKbn.class, patternId, value);
    }
}
