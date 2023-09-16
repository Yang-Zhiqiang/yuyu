
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ターゲット特約目標値区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TargetTkMokuhyoutiKbn</td><td colspan="3">ターゲット特約目標値区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET105}</td><td>&quot;105&quot;</td><td>１０５％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET110}</td><td>&quot;110&quot;</td><td>１１０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET120}</td><td>&quot;120&quot;</td><td>１２０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET130}</td><td>&quot;130&quot;</td><td>１３０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET140}</td><td>&quot;140&quot;</td><td>１４０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET150}</td><td>&quot;150&quot;</td><td>１５０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET160}</td><td>&quot;160&quot;</td><td>１６０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET170}</td><td>&quot;170&quot;</td><td>１７０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET180}</td><td>&quot;180&quot;</td><td>１８０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET190}</td><td>&quot;190&quot;</td><td>１９０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGET200}</td><td>&quot;200&quot;</td><td>２００％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOTARGET}</td><td>&quot;999&quot;</td><td>設定しない</td></tr>
 * </table>
 */
public class C_TargetTkMokuhyoutiKbn extends Classification<C_TargetTkMokuhyoutiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TargetTkMokuhyoutiKbn BLNK = new C_TargetTkMokuhyoutiKbn("0");

    public static final C_TargetTkMokuhyoutiKbn TARGET105 = new C_TargetTkMokuhyoutiKbn("105");

    public static final C_TargetTkMokuhyoutiKbn TARGET110 = new C_TargetTkMokuhyoutiKbn("110");

    public static final C_TargetTkMokuhyoutiKbn TARGET120 = new C_TargetTkMokuhyoutiKbn("120");

    public static final C_TargetTkMokuhyoutiKbn TARGET130 = new C_TargetTkMokuhyoutiKbn("130");

    public static final C_TargetTkMokuhyoutiKbn TARGET140 = new C_TargetTkMokuhyoutiKbn("140");

    public static final C_TargetTkMokuhyoutiKbn TARGET150 = new C_TargetTkMokuhyoutiKbn("150");

    public static final C_TargetTkMokuhyoutiKbn TARGET160 = new C_TargetTkMokuhyoutiKbn("160");

    public static final C_TargetTkMokuhyoutiKbn TARGET170 = new C_TargetTkMokuhyoutiKbn("170");

    public static final C_TargetTkMokuhyoutiKbn TARGET180 = new C_TargetTkMokuhyoutiKbn("180");

    public static final C_TargetTkMokuhyoutiKbn TARGET190 = new C_TargetTkMokuhyoutiKbn("190");

    public static final C_TargetTkMokuhyoutiKbn TARGET200 = new C_TargetTkMokuhyoutiKbn("200");

    public static final C_TargetTkMokuhyoutiKbn NOTARGET = new C_TargetTkMokuhyoutiKbn("999");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TARGET105, "TARGET105", false);
        addPattern(PATTERN_DEFAULT, TARGET110, "TARGET110", false);
        addPattern(PATTERN_DEFAULT, TARGET120, "TARGET120", false);
        addPattern(PATTERN_DEFAULT, TARGET130, "TARGET130", false);
        addPattern(PATTERN_DEFAULT, TARGET140, "TARGET140", false);
        addPattern(PATTERN_DEFAULT, TARGET150, "TARGET150", false);
        addPattern(PATTERN_DEFAULT, TARGET160, "TARGET160", false);
        addPattern(PATTERN_DEFAULT, TARGET170, "TARGET170", false);
        addPattern(PATTERN_DEFAULT, TARGET180, "TARGET180", false);
        addPattern(PATTERN_DEFAULT, TARGET190, "TARGET190", false);
        addPattern(PATTERN_DEFAULT, TARGET200, "TARGET200", false);
        addPattern(PATTERN_DEFAULT, NOTARGET, "NOTARGET", false);


        lock(C_TargetTkMokuhyoutiKbn.class);
    }

    private C_TargetTkMokuhyoutiKbn(String value) {
        super(value);
    }

    public static C_TargetTkMokuhyoutiKbn valueOf(String value) {
        return valueOf(C_TargetTkMokuhyoutiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TargetTkMokuhyoutiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TargetTkMokuhyoutiKbn.class, patternId, value);
    }
}
