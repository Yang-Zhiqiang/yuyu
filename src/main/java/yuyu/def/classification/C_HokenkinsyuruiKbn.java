
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HokenkinsyuruiKbn</td><td colspan="3">保険金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHOKENKIN}</td><td>&quot;1&quot;</td><td>死亡保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDHOKENKIN}</td><td>&quot;2&quot;</td><td>高度障害保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAIHOKENKIN}</td><td>&quot;3&quot;</td><td>災害保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUKIN}</td><td>&quot;5&quot;</td><td>死亡給付金</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHOKENKIN}</td><td>&quot;1&quot;</td><td>死亡保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDHOKENKIN}</td><td>&quot;2&quot;</td><td>高度障害保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAIHOKENKIN}</td><td>&quot;3&quot;</td><td>災害死亡保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUKIN}</td><td>&quot;5&quot;</td><td>死亡給付金</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KYHSYURUI KYHSYURUI}<br />(給付種類)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHOKENKIN}</td><td>&quot;1&quot;</td><td>主Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAIHOKENKIN}</td><td>&quot;3&quot;</td><td>災Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUKIN}</td><td>&quot;5&quot;</td><td>主Ｓ（死亡給付金）</td></tr>
 * </table>
 */
public class C_HokenkinsyuruiKbn extends Classification<C_HokenkinsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HokenkinsyuruiKbn BLNK = new C_HokenkinsyuruiKbn("0");

    public static final C_HokenkinsyuruiKbn SBHOKENKIN = new C_HokenkinsyuruiKbn("1");

    public static final C_HokenkinsyuruiKbn KDHOKENKIN = new C_HokenkinsyuruiKbn("2");

    public static final C_HokenkinsyuruiKbn SAIGAIHOKENKIN = new C_HokenkinsyuruiKbn("3");

    public static final C_HokenkinsyuruiKbn SBKYUUHUKIN = new C_HokenkinsyuruiKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REPORT = "2";

    public static final String PATTERN_KYHSYURUI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SBHOKENKIN, "SBHOKENKIN", false);
        addPattern(PATTERN_DEFAULT, KDHOKENKIN, "KDHOKENKIN", false);
        addPattern(PATTERN_DEFAULT, SAIGAIHOKENKIN, "SAIGAIHOKENKIN", false);
        addPattern(PATTERN_DEFAULT, SBKYUUHUKIN, "SBKYUUHUKIN", false);


        addPattern(PATTERN_REPORT, BLNK, "BLNK", true);
        addPattern(PATTERN_REPORT, SBHOKENKIN, "SBHOKENKIN", false);
        addPattern(PATTERN_REPORT, KDHOKENKIN, "KDHOKENKIN", false);
        addPattern(PATTERN_REPORT, SAIGAIHOKENKIN, "SAIGAIHOKENKIN", false);
        addPattern(PATTERN_REPORT, SBKYUUHUKIN, "SBKYUUHUKIN", false);


        addPattern(PATTERN_KYHSYURUI, BLNK, "BLNK", true);
        addPattern(PATTERN_KYHSYURUI, SBHOKENKIN, "SBHOKENKIN", false);
        addPattern(PATTERN_KYHSYURUI, SAIGAIHOKENKIN, "SAIGAIHOKENKIN", false);
        addPattern(PATTERN_KYHSYURUI, SBKYUUHUKIN, "SBKYUUHUKIN", false);


        lock(C_HokenkinsyuruiKbn.class);
    }

    private C_HokenkinsyuruiKbn(String value) {
        super(value);
    }

    public static C_HokenkinsyuruiKbn valueOf(String value) {
        return valueOf(C_HokenkinsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HokenkinsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HokenkinsyuruiKbn.class, patternId, value);
    }
}
