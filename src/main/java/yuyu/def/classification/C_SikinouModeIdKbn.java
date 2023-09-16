
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金給付金支払機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinouModeIdKbn</td><td colspan="3">保険金給付金支払機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="21">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;input&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKEN}</td><td>&quot;tenken&quot;</td><td>点検</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKI_SATEIHUYOU}</td><td>&quot;tetuduki_sateihuyou&quot;</td><td>手続（査定不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN_SATEIHUYOU}</td><td>&quot;syounin_sateihuyou&quot;</td><td>承認（査定不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI1}</td><td>&quot;satei1&quot;</td><td>査定１次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI2}</td><td>&quot;satei2&quot;</td><td>査定２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI3}</td><td>&quot;satei3&quot;</td><td>査定３次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI4}</td><td>&quot;satei4&quot;</td><td>査定４次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKI_SATEIYOU}</td><td>&quot;tetuduki_sateiyou&quot;</td><td>手続（査定要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN_SATEIYOU}</td><td>&quot;syounin_sateiyou&quot;</td><td>承認（査定要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SESSYOU1}</td><td>&quot;sessyou1&quot;</td><td>折衝１次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SESSYOU2}</td><td>&quot;sessyou2&quot;</td><td>折衝２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIKETU_SESSYOUHUYOU}</td><td>&quot;kaiketu_sessyouhuyou&quot;</td><td>解決入力（折衝不要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIKETU_SESSYOUYOU}</td><td>&quot;kaiketu_sessyouyou&quot;</td><td>解決入力（折衝要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINIRAITYUU}</td><td>&quot;kakuniniraityuu&quot;</td><td>確認依頼中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKANRITYUU}</td><td>&quot;hubikanrityuu&quot;</td><td>不備管理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITOUROKU}</td><td>&quot;hubitouroku&quot;</td><td>不備登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBISYOUNIN}</td><td>&quot;hubisyounin&quot;</td><td>不備承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAITOUMATI}</td><td>&quot;hubikaitoumati&quot;</td><td>不備回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;hubikaisyou&quot;</td><td>不備解消</td></tr>
 * </table>
 */
public class C_SikinouModeIdKbn extends Classification<C_SikinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinouModeIdKbn DEFAULT = new C_SikinouModeIdKbn("default");

    public static final C_SikinouModeIdKbn INPUT = new C_SikinouModeIdKbn("input");

    public static final C_SikinouModeIdKbn TENKEN = new C_SikinouModeIdKbn("tenken");

    public static final C_SikinouModeIdKbn TETUDUKI_SATEIHUYOU = new C_SikinouModeIdKbn("tetuduki_sateihuyou");

    public static final C_SikinouModeIdKbn SYOUNIN_SATEIHUYOU = new C_SikinouModeIdKbn("syounin_sateihuyou");

    public static final C_SikinouModeIdKbn SATEI1 = new C_SikinouModeIdKbn("satei1");

    public static final C_SikinouModeIdKbn SATEI2 = new C_SikinouModeIdKbn("satei2");

    public static final C_SikinouModeIdKbn SATEI3 = new C_SikinouModeIdKbn("satei3");

    public static final C_SikinouModeIdKbn SATEI4 = new C_SikinouModeIdKbn("satei4");

    public static final C_SikinouModeIdKbn TETUDUKI_SATEIYOU = new C_SikinouModeIdKbn("tetuduki_sateiyou");

    public static final C_SikinouModeIdKbn SYOUNIN_SATEIYOU = new C_SikinouModeIdKbn("syounin_sateiyou");

    public static final C_SikinouModeIdKbn SESSYOU1 = new C_SikinouModeIdKbn("sessyou1");

    public static final C_SikinouModeIdKbn SESSYOU2 = new C_SikinouModeIdKbn("sessyou2");

    public static final C_SikinouModeIdKbn KAIKETU_SESSYOUHUYOU = new C_SikinouModeIdKbn("kaiketu_sessyouhuyou");

    public static final C_SikinouModeIdKbn KAIKETU_SESSYOUYOU = new C_SikinouModeIdKbn("kaiketu_sessyouyou");

    public static final C_SikinouModeIdKbn KAKUNINIRAITYUU = new C_SikinouModeIdKbn("kakuniniraityuu");

    public static final C_SikinouModeIdKbn HUBIKANRITYUU = new C_SikinouModeIdKbn("hubikanrityuu");

    public static final C_SikinouModeIdKbn HUBITOUROKU = new C_SikinouModeIdKbn("hubitouroku");

    public static final C_SikinouModeIdKbn HUBISYOUNIN = new C_SikinouModeIdKbn("hubisyounin");

    public static final C_SikinouModeIdKbn HUBIKAITOUMATI = new C_SikinouModeIdKbn("hubikaitoumati");

    public static final C_SikinouModeIdKbn HUBIKAISYOU = new C_SikinouModeIdKbn("hubikaisyou");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, TENKEN, "TENKEN", false);
        addPattern(PATTERN_DEFAULT, TETUDUKI_SATEIHUYOU, "TETUDUKI_SATEIHUYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN_SATEIHUYOU, "SYOUNIN_SATEIHUYOU", false);
        addPattern(PATTERN_DEFAULT, SATEI1, "SATEI1", false);
        addPattern(PATTERN_DEFAULT, SATEI2, "SATEI2", false);
        addPattern(PATTERN_DEFAULT, SATEI3, "SATEI3", false);
        addPattern(PATTERN_DEFAULT, SATEI4, "SATEI4", false);
        addPattern(PATTERN_DEFAULT, TETUDUKI_SATEIYOU, "TETUDUKI_SATEIYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN_SATEIYOU, "SYOUNIN_SATEIYOU", false);
        addPattern(PATTERN_DEFAULT, SESSYOU1, "SESSYOU1", false);
        addPattern(PATTERN_DEFAULT, SESSYOU2, "SESSYOU2", false);
        addPattern(PATTERN_DEFAULT, KAIKETU_SESSYOUHUYOU, "KAIKETU_SESSYOUHUYOU", false);
        addPattern(PATTERN_DEFAULT, KAIKETU_SESSYOUYOU, "KAIKETU_SESSYOUYOU", false);
        addPattern(PATTERN_DEFAULT, KAKUNINIRAITYUU, "KAKUNINIRAITYUU", false);
        addPattern(PATTERN_DEFAULT, HUBIKANRITYUU, "HUBIKANRITYUU", false);
        addPattern(PATTERN_DEFAULT, HUBITOUROKU, "HUBITOUROKU", false);
        addPattern(PATTERN_DEFAULT, HUBISYOUNIN, "HUBISYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUBIKAITOUMATI, "HUBIKAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);


        lock(C_SikinouModeIdKbn.class);
    }

    private C_SikinouModeIdKbn(String value) {
        super(value);
    }

    public static C_SikinouModeIdKbn valueOf(String value) {
        return valueOf(C_SikinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinouModeIdKbn.class, patternId, value);
    }
}
