
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理レベル クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syorilv</td><td colspan="3">処理レベル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DAISOSIKI_KANRIDAISO}</td><td>&quot;0&quot;</td><td>代表組織毎の管理者権限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOSIKI_IKA}</td><td>&quot;1&quot;</td><td>組織以下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOSIKI_TYOKKA}</td><td>&quot;2&quot;</td><td>組織直下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUNIN}</td><td>&quot;3&quot;</td><td>募集人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEM_KANRI}</td><td>&quot;9&quot;</td><td>システム管理者権限</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DAIRITEN DAIRITEN}<br />(代理店・募集人登録時設定用)</td><td align="center">&nbsp;</td><td>{@link #DAISOSIKI_KANRIDAISO}</td><td>&quot;0&quot;</td><td>代表組織毎の管理者権限</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SOSIKI_IKA}</td><td>&quot;1&quot;</td><td>組織以下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOSIKI_TYOKKA}</td><td>&quot;2&quot;</td><td>組織直下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUNIN}</td><td>&quot;3&quot;</td><td>募集人</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_PATARN1 PATARN1}<br />(パターン１)</td><td align="center">○</td><td>{@link #SOSIKI_TYOKKA}</td><td>&quot;2&quot;</td><td>組織直下</td></tr>
 * </table>
 */
public class C_Syorilv extends Classification<C_Syorilv> {

    private static final long serialVersionUID = 1L;


    public static final C_Syorilv DAISOSIKI_KANRIDAISO = new C_Syorilv("0");

    public static final C_Syorilv SOSIKI_IKA = new C_Syorilv("1");

    public static final C_Syorilv SOSIKI_TYOKKA = new C_Syorilv("2");

    public static final C_Syorilv BOSYUUNIN = new C_Syorilv("3");

    public static final C_Syorilv SYSTEM_KANRI = new C_Syorilv("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DAIRITEN = "2";

    public static final String PATTERN_PATARN1 = "3";


    static {

        addPattern(PATTERN_DEFAULT, DAISOSIKI_KANRIDAISO, "DAISOSIKI_KANRIDAISO", true);
        addPattern(PATTERN_DEFAULT, SOSIKI_IKA, "SOSIKI_IKA", false);
        addPattern(PATTERN_DEFAULT, SOSIKI_TYOKKA, "SOSIKI_TYOKKA", false);
        addPattern(PATTERN_DEFAULT, BOSYUUNIN, "BOSYUUNIN", false);
        addPattern(PATTERN_DEFAULT, SYSTEM_KANRI, "SYSTEM_KANRI", false);


        addPattern(PATTERN_DAIRITEN, DAISOSIKI_KANRIDAISO, "DAISOSIKI_KANRIDAISO", false);
        addPattern(PATTERN_DAIRITEN, SOSIKI_IKA, "SOSIKI_IKA", true);
        addPattern(PATTERN_DAIRITEN, SOSIKI_TYOKKA, "SOSIKI_TYOKKA", false);
        addPattern(PATTERN_DAIRITEN, BOSYUUNIN, "BOSYUUNIN", false);


        addPattern(PATTERN_PATARN1, SOSIKI_TYOKKA, "SOSIKI_TYOKKA", true);


        lock(C_Syorilv.class);
    }

    private C_Syorilv(String value) {
        super(value);
    }

    public static C_Syorilv valueOf(String value) {
        return valueOf(C_Syorilv.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syorilv.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syorilv.class, patternId, value);
    }
}
