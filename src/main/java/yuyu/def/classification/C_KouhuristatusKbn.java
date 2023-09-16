
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 口振ステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouhuristatusKbn</td><td colspan="3">口振ステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUSYORITYUU}</td><td>&quot;1&quot;</td><td>登録処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;2&quot;</td><td>正常完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUUKKNERROR}</td><td>&quot;3&quot;</td><td>金融機関でのエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURIGWERRORORTYUUSI}</td><td>&quot;4&quot;</td><td>口振受付ＧＷでのエラーまたは中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUUKKNTYUUSI}</td><td>&quot;9&quot;</td><td>金融機関での中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIZANERROR}</td><td>&quot;A&quot;</td><td>改竄エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNINKAKUNINERROR}</td><td>&quot;B&quot;</td><td>本人確認エラー</td></tr>
 * </table>
 */
public class C_KouhuristatusKbn extends Classification<C_KouhuristatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouhuristatusKbn BLNK = new C_KouhuristatusKbn("0");

    public static final C_KouhuristatusKbn TOUROKUSYORITYUU = new C_KouhuristatusKbn("1");

    public static final C_KouhuristatusKbn SEIJYOU = new C_KouhuristatusKbn("2");

    public static final C_KouhuristatusKbn KINYUUKKNERROR = new C_KouhuristatusKbn("3");

    public static final C_KouhuristatusKbn KOUHURIGWERRORORTYUUSI = new C_KouhuristatusKbn("4");

    public static final C_KouhuristatusKbn KINYUUKKNTYUUSI = new C_KouhuristatusKbn("9");

    public static final C_KouhuristatusKbn KAIZANERROR = new C_KouhuristatusKbn("A");

    public static final C_KouhuristatusKbn HONNINKAKUNINERROR = new C_KouhuristatusKbn("B");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKUSYORITYUU, "TOUROKUSYORITYUU", false);
        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_DEFAULT, KINYUUKKNERROR, "KINYUUKKNERROR", false);
        addPattern(PATTERN_DEFAULT, KOUHURIGWERRORORTYUUSI, "KOUHURIGWERRORORTYUUSI", false);
        addPattern(PATTERN_DEFAULT, KINYUUKKNTYUUSI, "KINYUUKKNTYUUSI", false);
        addPattern(PATTERN_DEFAULT, KAIZANERROR, "KAIZANERROR", false);
        addPattern(PATTERN_DEFAULT, HONNINKAKUNINERROR, "HONNINKAKUNINERROR", false);


        lock(C_KouhuristatusKbn.class);
    }

    private C_KouhuristatusKbn(String value) {
        super(value);
    }

    public static C_KouhuristatusKbn valueOf(String value) {
        return valueOf(C_KouhuristatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouhuristatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouhuristatusKbn.class, patternId, value);
    }
}
