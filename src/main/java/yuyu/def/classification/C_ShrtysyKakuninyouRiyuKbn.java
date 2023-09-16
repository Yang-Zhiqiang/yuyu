
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払調書確認要理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrtysyKakuninyouRiyuKbn</td><td colspan="3">支払調書確認要理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="17">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJO}</td><td>&quot;1&quot;</td><td>支払事由（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAITYOUHYOTEISI}</td><td>&quot;2&quot;</td><td>手続注意設定あり（支払調書作成停止）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAITOKOUTODOKE}</td><td>&quot;3&quot;</td><td>手続注意設定あり（海外渡航届受理）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENSASIOSAE}</td><td>&quot;4&quot;</td><td>手続注意設定あり（保険契約差押え）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINJISAISEI}</td><td>&quot;5&quot;</td><td>手続注意設定あり（民事再生）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJISEISAN}</td><td>&quot;6&quot;</td><td>手続注意設定あり（消滅時清算）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKARIUKE}</td><td>&quot;7&quot;</td><td>支払方法（仮受計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOHUMEI}</td><td>&quot;8&quot;</td><td>住所不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISHENKANHUKA}</td><td>&quot;9&quot;</td><td>ＪＩＳコード変換不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITIKEN}</td><td>&quot;10&quot;</td><td>質権設定あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHUMEI}</td><td>&quot;11&quot;</td><td>受取人不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHUKUSUU}</td><td>&quot;12&quot;</td><td>受取人複数</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOTYOUKA}</td><td>&quot;13&quot;</td><td>住所文字数超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENNAIHKSUKTSIBOU}</td><td>&quot;14&quot;</td><td>同一年内複数受取人死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTSIBOUSKITIJIKIN}</td><td>&quot;15&quot;</td><td>受取人死亡後即一時金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAIKYOJYUUSYA}</td><td>&quot;16&quot;</td><td>海外居住者</td></tr>
 * </table>
 */
public class C_ShrtysyKakuninyouRiyuKbn extends Classification<C_ShrtysyKakuninyouRiyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrtysyKakuninyouRiyuKbn BLNK = new C_ShrtysyKakuninyouRiyuKbn("0");

    public static final C_ShrtysyKakuninyouRiyuKbn SIBOUKAIJO = new C_ShrtysyKakuninyouRiyuKbn("1");

    public static final C_ShrtysyKakuninyouRiyuKbn SIHARAITYOUHYOTEISI = new C_ShrtysyKakuninyouRiyuKbn("2");

    public static final C_ShrtysyKakuninyouRiyuKbn KAIGAITOKOUTODOKE = new C_ShrtysyKakuninyouRiyuKbn("3");

    public static final C_ShrtysyKakuninyouRiyuKbn HOKENSASIOSAE = new C_ShrtysyKakuninyouRiyuKbn("4");

    public static final C_ShrtysyKakuninyouRiyuKbn MINJISAISEI = new C_ShrtysyKakuninyouRiyuKbn("5");

    public static final C_ShrtysyKakuninyouRiyuKbn SYOUMETUJISEISAN = new C_ShrtysyKakuninyouRiyuKbn("6");

    public static final C_ShrtysyKakuninyouRiyuKbn SHRKARIUKE = new C_ShrtysyKakuninyouRiyuKbn("7");

    public static final C_ShrtysyKakuninyouRiyuKbn JYUUSYOHUMEI = new C_ShrtysyKakuninyouRiyuKbn("8");

    public static final C_ShrtysyKakuninyouRiyuKbn JISHENKANHUKA = new C_ShrtysyKakuninyouRiyuKbn("9");

    public static final C_ShrtysyKakuninyouRiyuKbn SITIKEN = new C_ShrtysyKakuninyouRiyuKbn("10");

    public static final C_ShrtysyKakuninyouRiyuKbn UKTHUMEI = new C_ShrtysyKakuninyouRiyuKbn("11");

    public static final C_ShrtysyKakuninyouRiyuKbn UKTHUKUSUU = new C_ShrtysyKakuninyouRiyuKbn("12");

    public static final C_ShrtysyKakuninyouRiyuKbn JYUUSYOTYOUKA = new C_ShrtysyKakuninyouRiyuKbn("13");

    public static final C_ShrtysyKakuninyouRiyuKbn NENNAIHKSUKTSIBOU = new C_ShrtysyKakuninyouRiyuKbn("14");

    public static final C_ShrtysyKakuninyouRiyuKbn UKTSIBOUSKITIJIKIN = new C_ShrtysyKakuninyouRiyuKbn("15");

    public static final C_ShrtysyKakuninyouRiyuKbn KAIGAIKYOJYUUSYA = new C_ShrtysyKakuninyouRiyuKbn("16");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJO, "SIBOUKAIJO", false);
        addPattern(PATTERN_DEFAULT, SIHARAITYOUHYOTEISI, "SIHARAITYOUHYOTEISI", false);
        addPattern(PATTERN_DEFAULT, KAIGAITOKOUTODOKE, "KAIGAITOKOUTODOKE", false);
        addPattern(PATTERN_DEFAULT, HOKENSASIOSAE, "HOKENSASIOSAE", false);
        addPattern(PATTERN_DEFAULT, MINJISAISEI, "MINJISAISEI", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUJISEISAN, "SYOUMETUJISEISAN", false);
        addPattern(PATTERN_DEFAULT, SHRKARIUKE, "SHRKARIUKE", false);
        addPattern(PATTERN_DEFAULT, JYUUSYOHUMEI, "JYUUSYOHUMEI", false);
        addPattern(PATTERN_DEFAULT, JISHENKANHUKA, "JISHENKANHUKA", false);
        addPattern(PATTERN_DEFAULT, SITIKEN, "SITIKEN", false);
        addPattern(PATTERN_DEFAULT, UKTHUMEI, "UKTHUMEI", false);
        addPattern(PATTERN_DEFAULT, UKTHUKUSUU, "UKTHUKUSUU", false);
        addPattern(PATTERN_DEFAULT, JYUUSYOTYOUKA, "JYUUSYOTYOUKA", false);
        addPattern(PATTERN_DEFAULT, NENNAIHKSUKTSIBOU, "NENNAIHKSUKTSIBOU", false);
        addPattern(PATTERN_DEFAULT, UKTSIBOUSKITIJIKIN, "UKTSIBOUSKITIJIKIN", false);
        addPattern(PATTERN_DEFAULT, KAIGAIKYOJYUUSYA, "KAIGAIKYOJYUUSYA", false);


        lock(C_ShrtysyKakuninyouRiyuKbn.class);
    }

    private C_ShrtysyKakuninyouRiyuKbn(String value) {
        super(value);
    }

    public static C_ShrtysyKakuninyouRiyuKbn valueOf(String value) {
        return valueOf(C_ShrtysyKakuninyouRiyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrtysyKakuninyouRiyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrtysyKakuninyouRiyuKbn.class, patternId, value);
    }
}
