
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 伝票処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DensyoriKbn</td><td colspan="3">伝票処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="46">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_KZHKSR}</td><td>&quot;1010&quot;</td><td>初回Ｐ口座引去</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_GNKHRKM}</td><td>&quot;1020&quot;</td><td>初回Ｐ銀行振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_CREDITNYKN}</td><td>&quot;1030&quot;</td><td>初回Ｐクレジット入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_ONLINENYKN}</td><td>&quot;1040&quot;</td><td>初回Ｐオンライン入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_HNKN}</td><td>&quot;1050&quot;</td><td>初回Ｐ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_HNKNTRKS}</td><td>&quot;1060&quot;</td><td>初回Ｐ返金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1070&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRUKTEISEI_1P}</td><td>&quot;1080&quot;</td><td>仮受訂正（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_HNKNKB}</td><td>&quot;1090&quot;</td><td>初回Ｐ返金希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_KKN}</td><td>&quot;1100&quot;</td><td>初回Ｐ過金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FP_KKNTRKS}</td><td>&quot;1110&quot;</td><td>初回Ｐ過金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2010&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHENKO}</td><td>&quot;2020&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIYMDSEITEISEI}</td><td>&quot;2030&quot;</td><td>生年月日性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_KYKTRKS}</td><td>&quot;2040&quot;</td><td>契約取消（契約取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_CLNGOFF}</td><td>&quot;2050&quot;</td><td>契約取消（クーリングオフ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_KJY}</td><td>&quot;2060&quot;</td><td>契約取消（解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKATTU}</td><td>&quot;2070&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKTHENKOU}</td><td>&quot;2080&quot;</td><td>払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_SBKAIJO}</td><td>&quot;2090&quot;</td><td>契約取消（死亡解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_SBMENSEKI}</td><td>&quot;2100&quot;</td><td>契約取消（死亡免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHKSRNYKN}</td><td>&quot;2110&quot;</td><td>口座引去入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITNYKN}</td><td>&quot;2120&quot;</td><td>クレジット入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINENYKN}</td><td>&quot;2130&quot;</td><td>オンライン入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MSYPJYT}</td><td>&quot;2140&quot;</td><td>未収Ｐ充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRUKTEISEI}</td><td>&quot;2150&quot;</td><td>仮受訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYKNTRKS}</td><td>&quot;2160&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMINYKN}</td><td>&quot;2210&quot;</td><td>振込入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINENYKN_GNKHRKM}</td><td>&quot;2220&quot;</td><td>オンライン入金（銀行振込）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINENYKN_HANDKRK}</td><td>&quot;2230&quot;</td><td>オンライン入金（ハンド仮受金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKNSHR}</td><td>&quot;3010&quot;</td><td>給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHNKNKNSHR}</td><td>&quot;3020&quot;</td><td>死亡返還金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;3030&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHOKNKNSHR}</td><td>&quot;3040&quot;</td><td>死亡保険金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDHOKNKNSHR}</td><td>&quot;3050&quot;</td><td>高度障害保険金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGTSRYSHR}</td><td>&quot;4010&quot;</td><td>代理店手数料支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGTSRYNYKN}</td><td>&quot;4020&quot;</td><td>代理店手数料入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_GANMUKOU}</td><td>&quot;2170&quot;</td><td>契約取消（がん無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYKNTRKS}</td><td>&quot;2180&quot;</td><td>一括入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MSYPJYT_PMENYOUP}</td><td>&quot;2190&quot;</td><td>未収Ｐ充当（Ｐ免要Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS_MOUSIDEMUKOU}</td><td>&quot;2200&quot;</td><td>契約取消（申出無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAISIHARAI}</td><td>&quot;5010&quot;</td><td>年金・初回支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIKAIMEIKOUSIHARAI}</td><td>&quot;5020&quot;</td><td>年金・２回目以降支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTASIHARAI}</td><td>&quot;5030&quot;</td><td>年金・その他支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUSIHARAI}</td><td>&quot;5040&quot;</td><td>年金・死亡一時金支払</td></tr>
 * </table>
 */
public class C_DensyoriKbn extends Classification<C_DensyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DensyoriKbn BLNK = new C_DensyoriKbn("0");

    public static final C_DensyoriKbn FP_KZHKSR = new C_DensyoriKbn("1010");

    public static final C_DensyoriKbn FP_GNKHRKM = new C_DensyoriKbn("1020");

    public static final C_DensyoriKbn FP_CREDITNYKN = new C_DensyoriKbn("1030");

    public static final C_DensyoriKbn FP_ONLINENYKN = new C_DensyoriKbn("1040");

    public static final C_DensyoriKbn FP_HNKN = new C_DensyoriKbn("1050");

    public static final C_DensyoriKbn FP_HNKNTRKS = new C_DensyoriKbn("1060");

    public static final C_DensyoriKbn SEIRITU = new C_DensyoriKbn("1070");

    public static final C_DensyoriKbn KRUKTEISEI_1P = new C_DensyoriKbn("1080");

    public static final C_DensyoriKbn FP_HNKNKB = new C_DensyoriKbn("1090");

    public static final C_DensyoriKbn FP_KKN = new C_DensyoriKbn("1100");

    public static final C_DensyoriKbn FP_KKNTRKS = new C_DensyoriKbn("1110");

    public static final C_DensyoriKbn KAIYAKU = new C_DensyoriKbn("2010");

    public static final C_DensyoriKbn KYKHENKO = new C_DensyoriKbn("2020");

    public static final C_DensyoriKbn SEIYMDSEITEISEI = new C_DensyoriKbn("2030");

    public static final C_DensyoriKbn KYKTRKS_KYKTRKS = new C_DensyoriKbn("2040");

    public static final C_DensyoriKbn KYKTRKS_CLNGOFF = new C_DensyoriKbn("2050");

    public static final C_DensyoriKbn KYKTRKS_KJY = new C_DensyoriKbn("2060");

    public static final C_DensyoriKbn HUKATTU = new C_DensyoriKbn("2070");

    public static final C_DensyoriKbn HRKTHENKOU = new C_DensyoriKbn("2080");

    public static final C_DensyoriKbn KYKTRKS_SBKAIJO = new C_DensyoriKbn("2090");

    public static final C_DensyoriKbn KYKTRKS_SBMENSEKI = new C_DensyoriKbn("2100");

    public static final C_DensyoriKbn KZHKSRNYKN = new C_DensyoriKbn("2110");

    public static final C_DensyoriKbn CREDITNYKN = new C_DensyoriKbn("2120");

    public static final C_DensyoriKbn ONLINENYKN = new C_DensyoriKbn("2130");

    public static final C_DensyoriKbn MSYPJYT = new C_DensyoriKbn("2140");

    public static final C_DensyoriKbn KRUKTEISEI = new C_DensyoriKbn("2150");

    public static final C_DensyoriKbn NYKNTRKS = new C_DensyoriKbn("2160");

    public static final C_DensyoriKbn HURIKOMINYKN = new C_DensyoriKbn("2210");

    public static final C_DensyoriKbn ONLINENYKN_GNKHRKM = new C_DensyoriKbn("2220");

    public static final C_DensyoriKbn ONLINENYKN_HANDKRK = new C_DensyoriKbn("2230");

    public static final C_DensyoriKbn KYHKNSHR = new C_DensyoriKbn("3010");

    public static final C_DensyoriKbn SBHNKNKNSHR = new C_DensyoriKbn("3020");

    public static final C_DensyoriKbn PMEN = new C_DensyoriKbn("3030");

    public static final C_DensyoriKbn SBHOKNKNSHR = new C_DensyoriKbn("3040");

    public static final C_DensyoriKbn KDHOKNKNSHR = new C_DensyoriKbn("3050");

    public static final C_DensyoriKbn AGTSRYSHR = new C_DensyoriKbn("4010");

    public static final C_DensyoriKbn AGTSRYNYKN = new C_DensyoriKbn("4020");

    public static final C_DensyoriKbn KYKTRKS_GANMUKOU = new C_DensyoriKbn("2170");

    public static final C_DensyoriKbn IKKATUNYKNTRKS = new C_DensyoriKbn("2180");

    public static final C_DensyoriKbn MSYPJYT_PMENYOUP = new C_DensyoriKbn("2190");

    public static final C_DensyoriKbn KYKTRKS_MOUSIDEMUKOU = new C_DensyoriKbn("2200");

    public static final C_DensyoriKbn SYOKAISIHARAI = new C_DensyoriKbn("5010");

    public static final C_DensyoriKbn NIKAIMEIKOUSIHARAI = new C_DensyoriKbn("5020");

    public static final C_DensyoriKbn SONOTASIHARAI = new C_DensyoriKbn("5030");

    public static final C_DensyoriKbn SIBOUSIHARAI = new C_DensyoriKbn("5040");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FP_KZHKSR, "FP_KZHKSR", false);
        addPattern(PATTERN_DEFAULT, FP_GNKHRKM, "FP_GNKHRKM", false);
        addPattern(PATTERN_DEFAULT, FP_CREDITNYKN, "FP_CREDITNYKN", false);
        addPattern(PATTERN_DEFAULT, FP_ONLINENYKN, "FP_ONLINENYKN", false);
        addPattern(PATTERN_DEFAULT, FP_HNKN, "FP_HNKN", false);
        addPattern(PATTERN_DEFAULT, FP_HNKNTRKS, "FP_HNKNTRKS", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, KRUKTEISEI_1P, "KRUKTEISEI_1P", false);
        addPattern(PATTERN_DEFAULT, FP_HNKNKB, "FP_HNKNKB", false);
        addPattern(PATTERN_DEFAULT, FP_KKN, "FP_KKN", false);
        addPattern(PATTERN_DEFAULT, FP_KKNTRKS, "FP_KKNTRKS", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KYKHENKO, "KYKHENKO", false);
        addPattern(PATTERN_DEFAULT, SEIYMDSEITEISEI, "SEIYMDSEITEISEI", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_KYKTRKS, "KYKTRKS_KYKTRKS", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_CLNGOFF, "KYKTRKS_CLNGOFF", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_KJY, "KYKTRKS_KJY", false);
        addPattern(PATTERN_DEFAULT, HUKATTU, "HUKATTU", false);
        addPattern(PATTERN_DEFAULT, HRKTHENKOU, "HRKTHENKOU", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_SBKAIJO, "KYKTRKS_SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_SBMENSEKI, "KYKTRKS_SBMENSEKI", false);
        addPattern(PATTERN_DEFAULT, KZHKSRNYKN, "KZHKSRNYKN", false);
        addPattern(PATTERN_DEFAULT, CREDITNYKN, "CREDITNYKN", false);
        addPattern(PATTERN_DEFAULT, ONLINENYKN, "ONLINENYKN", false);
        addPattern(PATTERN_DEFAULT, MSYPJYT, "MSYPJYT", false);
        addPattern(PATTERN_DEFAULT, KRUKTEISEI, "KRUKTEISEI", false);
        addPattern(PATTERN_DEFAULT, NYKNTRKS, "NYKNTRKS", false);
        addPattern(PATTERN_DEFAULT, HURIKOMINYKN, "HURIKOMINYKN", false);
        addPattern(PATTERN_DEFAULT, ONLINENYKN_GNKHRKM, "ONLINENYKN_GNKHRKM", false);
        addPattern(PATTERN_DEFAULT, ONLINENYKN_HANDKRK, "ONLINENYKN_HANDKRK", false);
        addPattern(PATTERN_DEFAULT, KYHKNSHR, "KYHKNSHR", false);
        addPattern(PATTERN_DEFAULT, SBHNKNKNSHR, "SBHNKNKNSHR", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, SBHOKNKNSHR, "SBHOKNKNSHR", false);
        addPattern(PATTERN_DEFAULT, KDHOKNKNSHR, "KDHOKNKNSHR", false);
        addPattern(PATTERN_DEFAULT, AGTSRYSHR, "AGTSRYSHR", false);
        addPattern(PATTERN_DEFAULT, AGTSRYNYKN, "AGTSRYNYKN", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_GANMUKOU, "KYKTRKS_GANMUKOU", false);
        addPattern(PATTERN_DEFAULT, IKKATUNYKNTRKS, "IKKATUNYKNTRKS", false);
        addPattern(PATTERN_DEFAULT, MSYPJYT_PMENYOUP, "MSYPJYT_PMENYOUP", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS_MOUSIDEMUKOU, "KYKTRKS_MOUSIDEMUKOU", false);
        addPattern(PATTERN_DEFAULT, SYOKAISIHARAI, "SYOKAISIHARAI", false);
        addPattern(PATTERN_DEFAULT, NIKAIMEIKOUSIHARAI, "NIKAIMEIKOUSIHARAI", false);
        addPattern(PATTERN_DEFAULT, SONOTASIHARAI, "SONOTASIHARAI", false);
        addPattern(PATTERN_DEFAULT, SIBOUSIHARAI, "SIBOUSIHARAI", false);


        lock(C_DensyoriKbn.class);
    }

    private C_DensyoriKbn(String value) {
        super(value);
    }

    public static C_DensyoriKbn valueOf(String value) {
        return valueOf(C_DensyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DensyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DensyoriKbn.class, patternId, value);
    }
}
