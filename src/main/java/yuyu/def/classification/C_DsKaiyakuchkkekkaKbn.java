
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ解約共通チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKaiyakuchkkekkaKbn</td><td colspan="3">ＤＳ解約共通チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENJYOUTAI}</td><td>&quot;1&quot;</td><td>保全有効状態チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKITYUUI}</td><td>&quot;2&quot;</td><td>手続注意チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITIKENSETTEI}</td><td>&quot;3&quot;</td><td>質権設定チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDATEHENKOUMAE}</td><td>&quot;4&quot;</td><td>円建変更前チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKIYMDHENKOU}</td><td>&quot;5&quot;</td><td>先日付変更チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKYMDMAE}</td><td>&quot;6&quot;</td><td>契約日前チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKINJYOUGEN}</td><td>&quot;7&quot;</td><td>送金上限チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MFHUSEIGOU}</td><td>&quot;8&quot;</td><td>ＭＦ不整合チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIHANEIHAITOUKIN}</td><td>&quot;9&quot;</td><td>未反映配当金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKINHANEIYMDSONZAI}</td><td>&quot;10&quot;</td><td>効力発生日後配当金反映日存在チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKOMIYUYOKIKAN}</td><td>&quot;11&quot;</td><td>払込猶予期間チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKIN}</td><td>&quot;12&quot;</td><td>配当金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIHANEITUMITATEKIN}</td><td>&quot;13&quot;</td><td>未反映積立金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUMIJYUUTOU}</td><td>&quot;14&quot;</td><td>前納未充当チェックエラー</td></tr>
 * </table>
 */
public class C_DsKaiyakuchkkekkaKbn extends Classification<C_DsKaiyakuchkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKaiyakuchkkekkaKbn BLNK = new C_DsKaiyakuchkkekkaKbn("0");

    public static final C_DsKaiyakuchkkekkaKbn HOZENJYOUTAI = new C_DsKaiyakuchkkekkaKbn("1");

    public static final C_DsKaiyakuchkkekkaKbn TETUDUKITYUUI = new C_DsKaiyakuchkkekkaKbn("2");

    public static final C_DsKaiyakuchkkekkaKbn SITIKENSETTEI = new C_DsKaiyakuchkkekkaKbn("3");

    public static final C_DsKaiyakuchkkekkaKbn YENDATEHENKOUMAE = new C_DsKaiyakuchkkekkaKbn("4");

    public static final C_DsKaiyakuchkkekkaKbn SAKIYMDHENKOU = new C_DsKaiyakuchkkekkaKbn("5");

    public static final C_DsKaiyakuchkkekkaKbn KYKYMDMAE = new C_DsKaiyakuchkkekkaKbn("6");

    public static final C_DsKaiyakuchkkekkaKbn SOUKINJYOUGEN = new C_DsKaiyakuchkkekkaKbn("7");

    public static final C_DsKaiyakuchkkekkaKbn MFHUSEIGOU = new C_DsKaiyakuchkkekkaKbn("8");

    public static final C_DsKaiyakuchkkekkaKbn MIHANEIHAITOUKIN = new C_DsKaiyakuchkkekkaKbn("9");

    public static final C_DsKaiyakuchkkekkaKbn HAITOUKINHANEIYMDSONZAI = new C_DsKaiyakuchkkekkaKbn("10");

    public static final C_DsKaiyakuchkkekkaKbn HARAIKOMIYUYOKIKAN = new C_DsKaiyakuchkkekkaKbn("11");

    public static final C_DsKaiyakuchkkekkaKbn HAITOUKIN = new C_DsKaiyakuchkkekkaKbn("12");

    public static final C_DsKaiyakuchkkekkaKbn MIHANEITUMITATEKIN = new C_DsKaiyakuchkkekkaKbn("13");

    public static final C_DsKaiyakuchkkekkaKbn ZENNOUMIJYUUTOU = new C_DsKaiyakuchkkekkaKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOZENJYOUTAI, "HOZENJYOUTAI", false);
        addPattern(PATTERN_DEFAULT, TETUDUKITYUUI, "TETUDUKITYUUI", false);
        addPattern(PATTERN_DEFAULT, SITIKENSETTEI, "SITIKENSETTEI", false);
        addPattern(PATTERN_DEFAULT, YENDATEHENKOUMAE, "YENDATEHENKOUMAE", false);
        addPattern(PATTERN_DEFAULT, SAKIYMDHENKOU, "SAKIYMDHENKOU", false);
        addPattern(PATTERN_DEFAULT, KYKYMDMAE, "KYKYMDMAE", false);
        addPattern(PATTERN_DEFAULT, SOUKINJYOUGEN, "SOUKINJYOUGEN", false);
        addPattern(PATTERN_DEFAULT, MFHUSEIGOU, "MFHUSEIGOU", false);
        addPattern(PATTERN_DEFAULT, MIHANEIHAITOUKIN, "MIHANEIHAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, HAITOUKINHANEIYMDSONZAI, "HAITOUKINHANEIYMDSONZAI", false);
        addPattern(PATTERN_DEFAULT, HARAIKOMIYUYOKIKAN, "HARAIKOMIYUYOKIKAN", false);
        addPattern(PATTERN_DEFAULT, HAITOUKIN, "HAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, MIHANEITUMITATEKIN, "MIHANEITUMITATEKIN", false);
        addPattern(PATTERN_DEFAULT, ZENNOUMIJYUUTOU, "ZENNOUMIJYUUTOU", false);


        lock(C_DsKaiyakuchkkekkaKbn.class);
    }

    private C_DsKaiyakuchkkekkaKbn(String value) {
        super(value);
    }

    public static C_DsKaiyakuchkkekkaKbn valueOf(String value) {
        return valueOf(C_DsKaiyakuchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKaiyakuchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKaiyakuchkkekkaKbn.class, patternId, value);
    }
}
