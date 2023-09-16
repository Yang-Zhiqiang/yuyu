
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyuukinjyoutaiKbn</td><td colspan="3">入金状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SONOTA_MINYUUKIN}</td><td>&quot;0&quot;</td><td>その他(未入金)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINCHKMIRYOU}</td><td>&quot;1&quot;</td><td>入金チェック未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_KAKIN}</td><td>&quot;2&quot;</td><td>過金による成立保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_HUSOKUKIN}</td><td>&quot;3&quot;</td><td>不足金による成立保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSIIKKATUYOU}</td><td>&quot;4&quot;</td><td>マル指一括要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUUGAKUSEITOU}</td><td>&quot;5&quot;</td><td>領収額正当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOSIN2KAGETUIKKATU}</td><td>&quot;6&quot;</td><td>預振２ヶ月一括</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;7&quot;</td><td>消滅</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_NYUUKINJYOUHOUHUITTI NYUUKINJYOUHOUHUITTI}<br />(入金情報不一致)</td><td align="center">○</td><td>{@link #SONOTA_MINYUUKIN}</td><td>&quot;0&quot;</td><td>未入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINCHKMIRYOU}</td><td>&quot;1&quot;</td><td>入金チェック未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_KAKIN}</td><td>&quot;2&quot;</td><td>Ｐ過金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_HUSOKUKIN}</td><td>&quot;3&quot;</td><td>Ｐ不足</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSIIKKATUYOU}</td><td>&quot;4&quot;</td><td>一括入金必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUUGAKUSEITOU}</td><td>&quot;5&quot;</td><td>領収額正当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOSIN2KAGETUIKKATU}</td><td>&quot;6&quot;</td><td>預振２ヶ月一括必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;7&quot;</td><td>消滅</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(申込状況照会)</td><td align="center">○</td><td>{@link #SONOTA_MINYUUKIN}</td><td>&quot;0&quot;</td><td>未入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINCHKMIRYOU}</td><td>&quot;1&quot;</td><td>入金チェック未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_KAKIN}</td><td>&quot;2&quot;</td><td>過金による成立保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUHORYUU_HUSOKUKIN}</td><td>&quot;3&quot;</td><td>不足金による成立保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUSIIKKATUYOU}</td><td>&quot;4&quot;</td><td>一括要Ｐ有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUUGAKUSEITOU}</td><td>&quot;5&quot;</td><td>領収額正当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;7&quot;</td><td>成立／不成立</td></tr>
 * </table>
 */
public class C_NyuukinjyoutaiKbn extends Classification<C_NyuukinjyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyuukinjyoutaiKbn SONOTA_MINYUUKIN = new C_NyuukinjyoutaiKbn("0");

    public static final C_NyuukinjyoutaiKbn NYUUKINCHKMIRYOU = new C_NyuukinjyoutaiKbn("1");

    public static final C_NyuukinjyoutaiKbn SEIRITUHORYUU_KAKIN = new C_NyuukinjyoutaiKbn("2");

    public static final C_NyuukinjyoutaiKbn SEIRITUHORYUU_HUSOKUKIN = new C_NyuukinjyoutaiKbn("3");

    public static final C_NyuukinjyoutaiKbn MARUSIIKKATUYOU = new C_NyuukinjyoutaiKbn("4");

    public static final C_NyuukinjyoutaiKbn RYOUSYUUGAKUSEITOU = new C_NyuukinjyoutaiKbn("5");

    public static final C_NyuukinjyoutaiKbn YOSIN2KAGETUIKKATU = new C_NyuukinjyoutaiKbn("6");

    public static final C_NyuukinjyoutaiKbn SYOUMETU = new C_NyuukinjyoutaiKbn("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NYUUKINJYOUHOUHUITTI = "2";

    public static final String PATTERN_SYOUKAI = "3";


    static {

        addPattern(PATTERN_DEFAULT, SONOTA_MINYUUKIN, "SONOTA_MINYUUKIN", true);
        addPattern(PATTERN_DEFAULT, NYUUKINCHKMIRYOU, "NYUUKINCHKMIRYOU", false);
        addPattern(PATTERN_DEFAULT, SEIRITUHORYUU_KAKIN, "SEIRITUHORYUU_KAKIN", false);
        addPattern(PATTERN_DEFAULT, SEIRITUHORYUU_HUSOKUKIN, "SEIRITUHORYUU_HUSOKUKIN", false);
        addPattern(PATTERN_DEFAULT, MARUSIIKKATUYOU, "MARUSIIKKATUYOU", false);
        addPattern(PATTERN_DEFAULT, RYOUSYUUGAKUSEITOU, "RYOUSYUUGAKUSEITOU", false);
        addPattern(PATTERN_DEFAULT, YOSIN2KAGETUIKKATU, "YOSIN2KAGETUIKKATU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, SONOTA_MINYUUKIN, "SONOTA_MINYUUKIN", true);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, NYUUKINCHKMIRYOU, "NYUUKINCHKMIRYOU", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, SEIRITUHORYUU_KAKIN, "SEIRITUHORYUU_KAKIN", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, SEIRITUHORYUU_HUSOKUKIN, "SEIRITUHORYUU_HUSOKUKIN", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, MARUSIIKKATUYOU, "MARUSIIKKATUYOU", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, RYOUSYUUGAKUSEITOU, "RYOUSYUUGAKUSEITOU", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, YOSIN2KAGETUIKKATU, "YOSIN2KAGETUIKKATU", false);
        addPattern(PATTERN_NYUUKINJYOUHOUHUITTI, SYOUMETU, "SYOUMETU", false);


        addPattern(PATTERN_SYOUKAI, SONOTA_MINYUUKIN, "SONOTA_MINYUUKIN", true);
        addPattern(PATTERN_SYOUKAI, NYUUKINCHKMIRYOU, "NYUUKINCHKMIRYOU", false);
        addPattern(PATTERN_SYOUKAI, SEIRITUHORYUU_KAKIN, "SEIRITUHORYUU_KAKIN", false);
        addPattern(PATTERN_SYOUKAI, SEIRITUHORYUU_HUSOKUKIN, "SEIRITUHORYUU_HUSOKUKIN", false);
        addPattern(PATTERN_SYOUKAI, MARUSIIKKATUYOU, "MARUSIIKKATUYOU", false);
        addPattern(PATTERN_SYOUKAI, RYOUSYUUGAKUSEITOU, "RYOUSYUUGAKUSEITOU", false);
        addPattern(PATTERN_SYOUKAI, SYOUMETU, "SYOUMETU", false);


        lock(C_NyuukinjyoutaiKbn.class);
    }

    private C_NyuukinjyoutaiKbn(String value) {
        super(value);
    }

    public static C_NyuukinjyoutaiKbn valueOf(String value) {
        return valueOf(C_NyuukinjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyuukinjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyuukinjyoutaiKbn.class, patternId, value);
    }
}
