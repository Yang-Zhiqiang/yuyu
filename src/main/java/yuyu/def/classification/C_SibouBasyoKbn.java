
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡場所区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SibouBasyoKbn</td><td colspan="3">死亡場所区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BYOUIN}</td><td>&quot;1&quot;</td><td>病院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINRYOUJYO}</td><td>&quot;2&quot;</td><td>診療所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RJNHKNSST}</td><td>&quot;3&quot;</td><td>介護老人保健施設</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOSANJYO}</td><td>&quot;4&quot;</td><td>助産所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RJNHOMU}</td><td>&quot;5&quot;</td><td>老人ホーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JITAKU}</td><td>&quot;6&quot;</td><td>自宅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI}</td><td>&quot;8&quot;</td><td>海外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;7&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SibouBasyoKbn extends Classification<C_SibouBasyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SibouBasyoKbn BLNK = new C_SibouBasyoKbn("0");

    public static final C_SibouBasyoKbn BYOUIN = new C_SibouBasyoKbn("1");

    public static final C_SibouBasyoKbn SINRYOUJYO = new C_SibouBasyoKbn("2");

    public static final C_SibouBasyoKbn RJNHKNSST = new C_SibouBasyoKbn("3");

    public static final C_SibouBasyoKbn JYOSANJYO = new C_SibouBasyoKbn("4");

    public static final C_SibouBasyoKbn RJNHOMU = new C_SibouBasyoKbn("5");

    public static final C_SibouBasyoKbn JITAKU = new C_SibouBasyoKbn("6");

    public static final C_SibouBasyoKbn KAIGAI = new C_SibouBasyoKbn("8");

    public static final C_SibouBasyoKbn SONOTA = new C_SibouBasyoKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BYOUIN, "BYOUIN", false);
        addPattern(PATTERN_DEFAULT, SINRYOUJYO, "SINRYOUJYO", false);
        addPattern(PATTERN_DEFAULT, RJNHKNSST, "RJNHKNSST", false);
        addPattern(PATTERN_DEFAULT, JYOSANJYO, "JYOSANJYO", false);
        addPattern(PATTERN_DEFAULT, RJNHOMU, "RJNHOMU", false);
        addPattern(PATTERN_DEFAULT, JITAKU, "JITAKU", false);
        addPattern(PATTERN_DEFAULT, KAIGAI, "KAIGAI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SibouBasyoKbn.class);
    }

    private C_SibouBasyoKbn(String value) {
        super(value);
    }

    public static C_SibouBasyoKbn valueOf(String value) {
        return valueOf(C_SibouBasyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SibouBasyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SibouBasyoKbn.class, patternId, value);
    }
}
