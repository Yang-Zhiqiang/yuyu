
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 基本Ｓ種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KihonssyuruiKbn</td><td colspan="3">基本Ｓ種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NICHIGAKU}</td><td>&quot;1&quot;</td><td>日額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUSANGENDO}</td><td>&quot;2&quot;</td><td>通算限度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUJYUTUKYHKIN}</td><td>&quot;3&quot;</td><td>手術給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKIN}</td><td>&quot;4&quot;</td><td>給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUGAKU}</td><td>&quot;5&quot;</td><td>月額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONKHG}</td><td>&quot;6&quot;</td><td>基本給付金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKIN}</td><td>&quot;7&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUNKIN}</td><td>&quot;8&quot;</td><td>基準金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKKIJYUNKIN}</td><td>&quot;9&quot;</td><td>円建変更後基準金額</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>基本保険金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NICHIGAKU}</td><td>&quot;1&quot;</td><td>給付日額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUSANGENDO}</td><td>&quot;2&quot;</td><td>通算限度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUJYUTUKYHKIN}</td><td>&quot;3&quot;</td><td>手術給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKIN}</td><td>&quot;4&quot;</td><td>給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUGAKU}</td><td>&quot;5&quot;</td><td>月額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONKHG}</td><td>&quot;6&quot;</td><td>基本給付金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKIN}</td><td>&quot;7&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUNKIN}</td><td>&quot;8&quot;</td><td>基準金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKKIJYUNKIN}</td><td>&quot;9&quot;</td><td>円建変更後基準金額</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_CHECK CHECK}<br />(取扱規定チェック用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>基本保険金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NICHIGAKU}</td><td>&quot;1&quot;</td><td>日額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUSANGENDO}</td><td>&quot;2&quot;</td><td>通算限度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUJYUTUKYHKIN}</td><td>&quot;3&quot;</td><td>手術給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKIN}</td><td>&quot;4&quot;</td><td>給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUGAKU}</td><td>&quot;5&quot;</td><td>月額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKIN}</td><td>&quot;7&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUNKIN}</td><td>&quot;8&quot;</td><td>基準金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKKIJYUNKIN}</td><td>&quot;9&quot;</td><td>円建変更後基準金額</td></tr>
 * </table>
 */
public class C_KihonssyuruiKbn extends Classification<C_KihonssyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KihonssyuruiKbn BLNK = new C_KihonssyuruiKbn("0");

    public static final C_KihonssyuruiKbn NICHIGAKU = new C_KihonssyuruiKbn("1");

    public static final C_KihonssyuruiKbn TUUSANGENDO = new C_KihonssyuruiKbn("2");

    public static final C_KihonssyuruiKbn SYUJYUTUKYHKIN = new C_KihonssyuruiKbn("3");

    public static final C_KihonssyuruiKbn KYHKIN = new C_KihonssyuruiKbn("4");

    public static final C_KihonssyuruiKbn GETUGAKU = new C_KihonssyuruiKbn("5");

    public static final C_KihonssyuruiKbn KIHONKHG = new C_KihonssyuruiKbn("6");

    public static final C_KihonssyuruiKbn HKNKIN = new C_KihonssyuruiKbn("7");

    public static final C_KihonssyuruiKbn KIJYUNKIN = new C_KihonssyuruiKbn("8");

    public static final C_KihonssyuruiKbn YENDTHNKKIJYUNKIN = new C_KihonssyuruiKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REPORT = "2";

    public static final String PATTERN_CHECK = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NICHIGAKU, "NICHIGAKU", false);
        addPattern(PATTERN_DEFAULT, TUUSANGENDO, "TUUSANGENDO", false);
        addPattern(PATTERN_DEFAULT, SYUJYUTUKYHKIN, "SYUJYUTUKYHKIN", false);
        addPattern(PATTERN_DEFAULT, KYHKIN, "KYHKIN", false);
        addPattern(PATTERN_DEFAULT, GETUGAKU, "GETUGAKU", false);
        addPattern(PATTERN_DEFAULT, KIHONKHG, "KIHONKHG", false);
        addPattern(PATTERN_DEFAULT, HKNKIN, "HKNKIN", false);
        addPattern(PATTERN_DEFAULT, KIJYUNKIN, "KIJYUNKIN", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKKIJYUNKIN, "YENDTHNKKIJYUNKIN", false);


        addPattern(PATTERN_REPORT, BLNK, "BLNK", true);
        addPattern(PATTERN_REPORT, NICHIGAKU, "NICHIGAKU", false);
        addPattern(PATTERN_REPORT, TUUSANGENDO, "TUUSANGENDO", false);
        addPattern(PATTERN_REPORT, SYUJYUTUKYHKIN, "SYUJYUTUKYHKIN", false);
        addPattern(PATTERN_REPORT, KYHKIN, "KYHKIN", false);
        addPattern(PATTERN_REPORT, GETUGAKU, "GETUGAKU", false);
        addPattern(PATTERN_REPORT, KIHONKHG, "KIHONKHG", false);
        addPattern(PATTERN_REPORT, HKNKIN, "HKNKIN", false);
        addPattern(PATTERN_REPORT, KIJYUNKIN, "KIJYUNKIN", false);
        addPattern(PATTERN_REPORT, YENDTHNKKIJYUNKIN, "YENDTHNKKIJYUNKIN", false);


        addPattern(PATTERN_CHECK, BLNK, "BLNK", true);
        addPattern(PATTERN_CHECK, NICHIGAKU, "NICHIGAKU", false);
        addPattern(PATTERN_CHECK, TUUSANGENDO, "TUUSANGENDO", false);
        addPattern(PATTERN_CHECK, SYUJYUTUKYHKIN, "SYUJYUTUKYHKIN", false);
        addPattern(PATTERN_CHECK, KYHKIN, "KYHKIN", false);
        addPattern(PATTERN_CHECK, GETUGAKU, "GETUGAKU", false);
        addPattern(PATTERN_CHECK, HKNKIN, "HKNKIN", false);
        addPattern(PATTERN_CHECK, KIJYUNKIN, "KIJYUNKIN", false);
        addPattern(PATTERN_CHECK, YENDTHNKKIJYUNKIN, "YENDTHNKKIJYUNKIN", false);


        lock(C_KihonssyuruiKbn.class);
    }

    private C_KihonssyuruiKbn(String value) {
        super(value);
    }

    public static C_KihonssyuruiKbn valueOf(String value) {
        return valueOf(C_KihonssyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KihonssyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KihonssyuruiKbn.class, patternId, value);
    }
}
