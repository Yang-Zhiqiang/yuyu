
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金調査ファイル処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BknTyousaFSyoriKbn</td><td colspan="3">備金調査ファイル処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="20">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;01&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBSAIGAIS}</td><td>&quot;02&quot;</td><td>死亡災害Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;03&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAISAIGAIS}</td><td>&quot;04&quot;</td><td>高度障害災害Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REGUARDTANTAI}</td><td>&quot;05&quot;</td><td>リガード単体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REGUARDTOKUYAKU}</td><td>&quot;06&quot;</td><td>リガード特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VGUARDTANTAI}</td><td>&quot;07&quot;</td><td>Ｖガード単体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VGUARDTOKUYAKU}</td><td>&quot;08&quot;</td><td>Ｖガード特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOTANTAI}</td><td>&quot;09&quot;</td><td>介護単体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOTOKUYAKU}</td><td>&quot;10&quot;</td><td>介護特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LN}</td><td>&quot;11&quot;</td><td>ＬＮ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUSIBOU}</td><td>&quot;12&quot;</td><td>家族死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUKOUDOSYOUGAI}</td><td>&quot;13&quot;</td><td>家族高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUSAIGAI}</td><td>&quot;14&quot;</td><td>家族災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYUUHUKIN}</td><td>&quot;15&quot;</td><td>死亡給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBSAIGAIKYUUHUKIN}</td><td>&quot;16&quot;</td><td>死亡災害給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKIKEA}</td><td>&quot;17&quot;</td><td>早期ケア</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANTYOUKISUPPORT}</td><td>&quot;18&quot;</td><td>がん長期サポート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDANS_DAINIGANSINDANS}</td><td>&quot;19&quot;</td><td>がん診断保険金、第２がん診断保険金</td></tr>
 * </table>
 */
public class C_BknTyousaFSyoriKbn extends Classification<C_BknTyousaFSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BknTyousaFSyoriKbn BLNK = new C_BknTyousaFSyoriKbn("0");

    public static final C_BknTyousaFSyoriKbn SIBOU = new C_BknTyousaFSyoriKbn("01");

    public static final C_BknTyousaFSyoriKbn SBSAIGAIS = new C_BknTyousaFSyoriKbn("02");

    public static final C_BknTyousaFSyoriKbn KOUDOSYOUGAI = new C_BknTyousaFSyoriKbn("03");

    public static final C_BknTyousaFSyoriKbn KOUDOSYOUGAISAIGAIS = new C_BknTyousaFSyoriKbn("04");

    public static final C_BknTyousaFSyoriKbn REGUARDTANTAI = new C_BknTyousaFSyoriKbn("05");

    public static final C_BknTyousaFSyoriKbn REGUARDTOKUYAKU = new C_BknTyousaFSyoriKbn("06");

    public static final C_BknTyousaFSyoriKbn VGUARDTANTAI = new C_BknTyousaFSyoriKbn("07");

    public static final C_BknTyousaFSyoriKbn VGUARDTOKUYAKU = new C_BknTyousaFSyoriKbn("08");

    public static final C_BknTyousaFSyoriKbn KAIGOTANTAI = new C_BknTyousaFSyoriKbn("09");

    public static final C_BknTyousaFSyoriKbn KAIGOTOKUYAKU = new C_BknTyousaFSyoriKbn("10");

    public static final C_BknTyousaFSyoriKbn LN = new C_BknTyousaFSyoriKbn("11");

    public static final C_BknTyousaFSyoriKbn KAZOKUSIBOU = new C_BknTyousaFSyoriKbn("12");

    public static final C_BknTyousaFSyoriKbn KAZOKUKOUDOSYOUGAI = new C_BknTyousaFSyoriKbn("13");

    public static final C_BknTyousaFSyoriKbn KAZOKUSAIGAI = new C_BknTyousaFSyoriKbn("14");

    public static final C_BknTyousaFSyoriKbn SBKYUUHUKIN = new C_BknTyousaFSyoriKbn("15");

    public static final C_BknTyousaFSyoriKbn SBSAIGAIKYUUHUKIN = new C_BknTyousaFSyoriKbn("16");

    public static final C_BknTyousaFSyoriKbn SOUKIKEA = new C_BknTyousaFSyoriKbn("17");

    public static final C_BknTyousaFSyoriKbn GANTYOUKISUPPORT = new C_BknTyousaFSyoriKbn("18");

    public static final C_BknTyousaFSyoriKbn GANSINDANS_DAINIGANSINDANS = new C_BknTyousaFSyoriKbn("19");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, SBSAIGAIS, "SBSAIGAIS", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAISAIGAIS, "KOUDOSYOUGAISAIGAIS", false);
        addPattern(PATTERN_DEFAULT, REGUARDTANTAI, "REGUARDTANTAI", false);
        addPattern(PATTERN_DEFAULT, REGUARDTOKUYAKU, "REGUARDTOKUYAKU", false);
        addPattern(PATTERN_DEFAULT, VGUARDTANTAI, "VGUARDTANTAI", false);
        addPattern(PATTERN_DEFAULT, VGUARDTOKUYAKU, "VGUARDTOKUYAKU", false);
        addPattern(PATTERN_DEFAULT, KAIGOTANTAI, "KAIGOTANTAI", false);
        addPattern(PATTERN_DEFAULT, KAIGOTOKUYAKU, "KAIGOTOKUYAKU", false);
        addPattern(PATTERN_DEFAULT, LN, "LN", false);
        addPattern(PATTERN_DEFAULT, KAZOKUSIBOU, "KAZOKUSIBOU", false);
        addPattern(PATTERN_DEFAULT, KAZOKUKOUDOSYOUGAI, "KAZOKUKOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, KAZOKUSAIGAI, "KAZOKUSAIGAI", false);
        addPattern(PATTERN_DEFAULT, SBKYUUHUKIN, "SBKYUUHUKIN", false);
        addPattern(PATTERN_DEFAULT, SBSAIGAIKYUUHUKIN, "SBSAIGAIKYUUHUKIN", false);
        addPattern(PATTERN_DEFAULT, SOUKIKEA, "SOUKIKEA", false);
        addPattern(PATTERN_DEFAULT, GANTYOUKISUPPORT, "GANTYOUKISUPPORT", false);
        addPattern(PATTERN_DEFAULT, GANSINDANS_DAINIGANSINDANS, "GANSINDANS_DAINIGANSINDANS", false);


        lock(C_BknTyousaFSyoriKbn.class);
    }

    private C_BknTyousaFSyoriKbn(String value) {
        super(value);
    }

    public static C_BknTyousaFSyoriKbn valueOf(String value) {
        return valueOf(C_BknTyousaFSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BknTyousaFSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BknTyousaFSyoriKbn.class, patternId, value);
    }
}
