
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KhkinouModeIdKbn</td><td colspan="3">契約保全機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;input&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKEN}</td><td>&quot;tenken&quot;</td><td>点検</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;syounin&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUKZANNAIMATI}</td><td>&quot;kyuukzannaimati&quot;</td><td>旧口座案内待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDTOUROKUMATI}</td><td>&quot;cardtourokumati&quot;</td><td>カード情報登録待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORI}</td><td>&quot;syori&quot;</td><td>処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTKEY}</td><td>&quot;inputkey&quot;</td><td>キー入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;syoukai&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITOUROKU}</td><td>&quot;hubitouroku&quot;</td><td>不備登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBISYOUNIN}</td><td>&quot;hubisyounin&quot;</td><td>不備承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;hubikaisyou&quot;</td><td>不備解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAITOUMATI}</td><td>&quot;hubikaitoumati&quot;</td><td>不備回答待ち</td></tr>
 * </table>
 */
public class C_KhkinouModeIdKbn extends Classification<C_KhkinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KhkinouModeIdKbn DEFAULT = new C_KhkinouModeIdKbn("default");

    public static final C_KhkinouModeIdKbn INPUT = new C_KhkinouModeIdKbn("input");

    public static final C_KhkinouModeIdKbn TENKEN = new C_KhkinouModeIdKbn("tenken");

    public static final C_KhkinouModeIdKbn SYOUNIN = new C_KhkinouModeIdKbn("syounin");

    public static final C_KhkinouModeIdKbn KYUUKZANNAIMATI = new C_KhkinouModeIdKbn("kyuukzannaimati");

    public static final C_KhkinouModeIdKbn CARDTOUROKUMATI = new C_KhkinouModeIdKbn("cardtourokumati");

    public static final C_KhkinouModeIdKbn SYORI = new C_KhkinouModeIdKbn("syori");

    public static final C_KhkinouModeIdKbn INPUTKEY = new C_KhkinouModeIdKbn("inputkey");

    public static final C_KhkinouModeIdKbn SYOUKAI = new C_KhkinouModeIdKbn("syoukai");

    public static final C_KhkinouModeIdKbn HUBITOUROKU = new C_KhkinouModeIdKbn("hubitouroku");

    public static final C_KhkinouModeIdKbn HUBISYOUNIN = new C_KhkinouModeIdKbn("hubisyounin");

    public static final C_KhkinouModeIdKbn HUBIKAISYOU = new C_KhkinouModeIdKbn("hubikaisyou");

    public static final C_KhkinouModeIdKbn HUBIKAITOUMATI = new C_KhkinouModeIdKbn("hubikaitoumati");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, TENKEN, "TENKEN", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, KYUUKZANNAIMATI, "KYUUKZANNAIMATI", false);
        addPattern(PATTERN_DEFAULT, CARDTOUROKUMATI, "CARDTOUROKUMATI", false);
        addPattern(PATTERN_DEFAULT, SYORI, "SYORI", false);
        addPattern(PATTERN_DEFAULT, INPUTKEY, "INPUTKEY", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HUBITOUROKU, "HUBITOUROKU", false);
        addPattern(PATTERN_DEFAULT, HUBISYOUNIN, "HUBISYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);
        addPattern(PATTERN_DEFAULT, HUBIKAITOUMATI, "HUBIKAITOUMATI", false);


        lock(C_KhkinouModeIdKbn.class);
    }

    private C_KhkinouModeIdKbn(String value) {
        super(value);
    }

    public static C_KhkinouModeIdKbn valueOf(String value) {
        return valueOf(C_KhkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KhkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KhkinouModeIdKbn.class, patternId, value);
    }
}
