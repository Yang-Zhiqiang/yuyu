
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集システム制御区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosyuusysctrlKbn</td><td colspan="3">募集システム制御区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;1&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGIN}</td><td>&quot;2&quot;</td><td>地銀</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIN}</td><td>&quot;3&quot;</td><td>信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECT}</td><td>&quot;4&quot;</td><td>ダイレクト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUKIN}</td><td>&quot;5&quot;</td><td>マル金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;6&quot;</td><td>ＳＭＴＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAISANTIGIN}</td><td>&quot;7&quot;</td><td>概算設計のみの地銀</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAISANSINKIN}</td><td>&quot;8&quot;</td><td>概算設計のみの信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAMADOHAN}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIGINKOU}</td><td>&quot;A&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKAISYA}</td><td>&quot;B&quot;</td><td>郵便局会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKANPO}</td><td>&quot;C&quot;</td><td>かんぽ生命</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOPMDHN}</td><td>&quot;D&quot;</td><td>ショップ窓販</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;E&quot;</td><td>みずほ銀行</td></tr>
 * </table>
 */
public class C_BosyuusysctrlKbn extends Classification<C_BosyuusysctrlKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosyuusysctrlKbn BLNK = new C_BosyuusysctrlKbn("0");

    public static final C_BosyuusysctrlKbn SMBC = new C_BosyuusysctrlKbn("1");

    public static final C_BosyuusysctrlKbn TIGIN = new C_BosyuusysctrlKbn("2");

    public static final C_BosyuusysctrlKbn SINKIN = new C_BosyuusysctrlKbn("3");

    public static final C_BosyuusysctrlKbn DIRECT = new C_BosyuusysctrlKbn("4");

    public static final C_BosyuusysctrlKbn MARUKIN = new C_BosyuusysctrlKbn("5");

    public static final C_BosyuusysctrlKbn SMTB = new C_BosyuusysctrlKbn("6");

    public static final C_BosyuusysctrlKbn GAISANTIGIN = new C_BosyuusysctrlKbn("7");

    public static final C_BosyuusysctrlKbn GAISANSINKIN = new C_BosyuusysctrlKbn("8");

    public static final C_BosyuusysctrlKbn SONOTAMADOHAN = new C_BosyuusysctrlKbn("9");

    public static final C_BosyuusysctrlKbn YUUSEIGINKOU = new C_BosyuusysctrlKbn("A");

    public static final C_BosyuusysctrlKbn YUUSEIKAISYA = new C_BosyuusysctrlKbn("B");

    public static final C_BosyuusysctrlKbn YUUSEIKANPO = new C_BosyuusysctrlKbn("C");

    public static final C_BosyuusysctrlKbn SHOPMDHN = new C_BosyuusysctrlKbn("D");

    public static final C_BosyuusysctrlKbn MIZUHO = new C_BosyuusysctrlKbn("E");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, TIGIN, "TIGIN", false);
        addPattern(PATTERN_DEFAULT, SINKIN, "SINKIN", false);
        addPattern(PATTERN_DEFAULT, DIRECT, "DIRECT", false);
        addPattern(PATTERN_DEFAULT, MARUKIN, "MARUKIN", false);
        addPattern(PATTERN_DEFAULT, SMTB, "SMTB", false);
        addPattern(PATTERN_DEFAULT, GAISANTIGIN, "GAISANTIGIN", false);
        addPattern(PATTERN_DEFAULT, GAISANSINKIN, "GAISANSINKIN", false);
        addPattern(PATTERN_DEFAULT, SONOTAMADOHAN, "SONOTAMADOHAN", false);
        addPattern(PATTERN_DEFAULT, YUUSEIGINKOU, "YUUSEIGINKOU", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKAISYA, "YUUSEIKAISYA", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKANPO, "YUUSEIKANPO", false);
        addPattern(PATTERN_DEFAULT, SHOPMDHN, "SHOPMDHN", false);
        addPattern(PATTERN_DEFAULT, MIZUHO, "MIZUHO", false);


        lock(C_BosyuusysctrlKbn.class);
    }

    private C_BosyuusysctrlKbn(String value) {
        super(value);
    }

    public static C_BosyuusysctrlKbn valueOf(String value) {
        return valueOf(C_BosyuusysctrlKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosyuusysctrlKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosyuusysctrlKbn.class, patternId, value);
    }
}
