
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込消滅区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MossyoumetuKbn</td><td colspan="3">申込消滅区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #MIKAKUTEI}</td><td>&quot;0&quot;</td><td>未確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;2&quot;</td><td>見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI}</td><td>&quot;3&quot;</td><td>延期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTRKS}</td><td>&quot;4&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKIKANKEIKA}</td><td>&quot;5&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKOSEIRITU_KARISEIRITU}</td><td>&quot;6&quot;</td><td>個々成立（仮成立）</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_MossyoumetuKbn extends Classification<C_MossyoumetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MossyoumetuKbn MIKAKUTEI = new C_MossyoumetuKbn("0");

    public static final C_MossyoumetuKbn SEIRITU = new C_MossyoumetuKbn("1");

    public static final C_MossyoumetuKbn MIAWASE = new C_MossyoumetuKbn("2");

    public static final C_MossyoumetuKbn ENKI = new C_MossyoumetuKbn("3");

    public static final C_MossyoumetuKbn MOSTRKS = new C_MossyoumetuKbn("4");

    public static final C_MossyoumetuKbn YUUKOUKIKANKEIKA = new C_MossyoumetuKbn("5");

    public static final C_MossyoumetuKbn KOKOSEIRITU_KARISEIRITU = new C_MossyoumetuKbn("6");

    public static final C_MossyoumetuKbn BLNK = new C_MossyoumetuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIKAKUTEI, "MIKAKUTEI", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, MIAWASE, "MIAWASE", false);
        addPattern(PATTERN_DEFAULT, ENKI, "ENKI", false);
        addPattern(PATTERN_DEFAULT, MOSTRKS, "MOSTRKS", false);
        addPattern(PATTERN_DEFAULT, YUUKOUKIKANKEIKA, "YUUKOUKIKANKEIKA", false);
        addPattern(PATTERN_DEFAULT, KOKOSEIRITU_KARISEIRITU, "KOKOSEIRITU_KARISEIRITU", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_MossyoumetuKbn.class);
    }

    private C_MossyoumetuKbn(String value) {
        super(value);
    }

    public static C_MossyoumetuKbn valueOf(String value) {
        return valueOf(C_MossyoumetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MossyoumetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MossyoumetuKbn.class, patternId, value);
    }
}
