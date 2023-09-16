
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 自動送金不可理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JidousoukinHukaRiyuuKbn</td><td colspan="3">自動送金不可理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUJTCHKERR_HKTTDKARI}</td><td>&quot;01&quot;</td><td>有効状態チェックエラー（他手続き有り等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUISETKYK}</td><td>&quot;02&quot;</td><td>手続注意設定契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STKNSETKYK}</td><td>&quot;03&quot;</td><td>質権設定契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMKZINFOMUKOU_KZINFOMTRK}</td><td>&quot;04&quot;</td><td>振込口座情報無効（口座情報未登録）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMKZINFOMUKOU_DATTAITYUUKYK}</td><td>&quot;05&quot;</td><td>振込口座情報無効（脱退中契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMKZINFOMUKOU_BANKHUZAI}</td><td>&quot;06&quot;</td><td>振込口座情報無効（銀行不在）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMKZINFOMUKOU_BANKMUKOU}</td><td>&quot;07&quot;</td><td>振込口座情報無効（銀行無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMKZINFOMUKOU_YENSHRHUKA}</td><td>&quot;08&quot;</td><td>振込口座情報無効（円貨支払不可）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZMGNNKYKSYAIGAI}</td><td>&quot;09&quot;</td><td>口座名義人契約者以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHURIATKIIGAI}</td><td>&quot;10&quot;</td><td>口座振替扱い以外</td></tr>
 * </table>
 */
public class C_JidousoukinHukaRiyuuKbn extends Classification<C_JidousoukinHukaRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JidousoukinHukaRiyuuKbn BLNK = new C_JidousoukinHukaRiyuuKbn("0");

    public static final C_JidousoukinHukaRiyuuKbn YUUKOUJTCHKERR_HKTTDKARI = new C_JidousoukinHukaRiyuuKbn("01");

    public static final C_JidousoukinHukaRiyuuKbn TTDKTYUUISETKYK = new C_JidousoukinHukaRiyuuKbn("02");

    public static final C_JidousoukinHukaRiyuuKbn STKNSETKYK = new C_JidousoukinHukaRiyuuKbn("03");

    public static final C_JidousoukinHukaRiyuuKbn HRKMKZINFOMUKOU_KZINFOMTRK = new C_JidousoukinHukaRiyuuKbn("04");

    public static final C_JidousoukinHukaRiyuuKbn HRKMKZINFOMUKOU_DATTAITYUUKYK = new C_JidousoukinHukaRiyuuKbn("05");

    public static final C_JidousoukinHukaRiyuuKbn HRKMKZINFOMUKOU_BANKHUZAI = new C_JidousoukinHukaRiyuuKbn("06");

    public static final C_JidousoukinHukaRiyuuKbn HRKMKZINFOMUKOU_BANKMUKOU = new C_JidousoukinHukaRiyuuKbn("07");

    public static final C_JidousoukinHukaRiyuuKbn HRKMKZINFOMUKOU_YENSHRHUKA = new C_JidousoukinHukaRiyuuKbn("08");

    public static final C_JidousoukinHukaRiyuuKbn KZMGNNKYKSYAIGAI = new C_JidousoukinHukaRiyuuKbn("09");

    public static final C_JidousoukinHukaRiyuuKbn KZHURIATKIIGAI = new C_JidousoukinHukaRiyuuKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUKOUJTCHKERR_HKTTDKARI, "YUUKOUJTCHKERR_HKTTDKARI", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUISETKYK, "TTDKTYUUISETKYK", false);
        addPattern(PATTERN_DEFAULT, STKNSETKYK, "STKNSETKYK", false);
        addPattern(PATTERN_DEFAULT, HRKMKZINFOMUKOU_KZINFOMTRK, "HRKMKZINFOMUKOU_KZINFOMTRK", false);
        addPattern(PATTERN_DEFAULT, HRKMKZINFOMUKOU_DATTAITYUUKYK, "HRKMKZINFOMUKOU_DATTAITYUUKYK", false);
        addPattern(PATTERN_DEFAULT, HRKMKZINFOMUKOU_BANKHUZAI, "HRKMKZINFOMUKOU_BANKHUZAI", false);
        addPattern(PATTERN_DEFAULT, HRKMKZINFOMUKOU_BANKMUKOU, "HRKMKZINFOMUKOU_BANKMUKOU", false);
        addPattern(PATTERN_DEFAULT, HRKMKZINFOMUKOU_YENSHRHUKA, "HRKMKZINFOMUKOU_YENSHRHUKA", false);
        addPattern(PATTERN_DEFAULT, KZMGNNKYKSYAIGAI, "KZMGNNKYKSYAIGAI", false);
        addPattern(PATTERN_DEFAULT, KZHURIATKIIGAI, "KZHURIATKIIGAI", false);


        lock(C_JidousoukinHukaRiyuuKbn.class);
    }

    private C_JidousoukinHukaRiyuuKbn(String value) {
        super(value);
    }

    public static C_JidousoukinHukaRiyuuKbn valueOf(String value) {
        return valueOf(C_JidousoukinHukaRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JidousoukinHukaRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JidousoukinHukaRiyuuKbn.class, patternId, value);
    }
}
