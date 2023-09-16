
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 傷病コード中分類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoubyouCdTyuubunruiKbn</td><td colspan="3">傷病コード中分類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="25">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAIKAKU}</td><td>&quot;2&quot;</td><td>体格</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDOUKINOSIKKAN}</td><td>&quot;4&quot;</td><td>運動器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKAKUKINOSIKKAN}</td><td>&quot;7&quot;</td><td>感覚器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUNYOU}</td><td>&quot;10&quot;</td><td>糖尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKUSEISINSEIBUTU}</td><td>&quot;15&quot;</td><td>悪性新生物</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEKKAKU}</td><td>&quot;20&quot;</td><td>結核</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIKEINOSIKKAN}</td><td>&quot;30&quot;</td><td>神経系の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYUUKIKEINOSIKKAN}</td><td>&quot;49&quot;</td><td>呼吸器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKETUATU}</td><td>&quot;50&quot;</td><td>高血圧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKETUATU}</td><td>&quot;53&quot;</td><td>低血圧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANKAIYOU}</td><td>&quot;60&quot;</td><td>消化器疾患・潰瘍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANTANNOU}</td><td>&quot;65&quot;</td><td>消化器疾患・胆のう</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANKANZOUSIKKAN}</td><td>&quot;67&quot;</td><td>消化器疾患・肝臓疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANSONOTA}</td><td>&quot;69&quot;</td><td>消化器疾患・その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANPAKUNYOU}</td><td>&quot;70&quot;</td><td>蛋白尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITUNYOUKIKEINOSIKKAN}</td><td>&quot;75&quot;</td><td>泌尿器系の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINSINTYUU}</td><td>&quot;77&quot;</td><td>妊娠中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUJINKASIKKAN}</td><td>&quot;78&quot;</td><td>婦人科疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETUNYOU}</td><td>&quot;79&quot;</td><td>血尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINHIDAI}</td><td>&quot;80&quot;</td><td>心肥大</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINZATUON}</td><td>&quot;82&quot;</td><td>心雑音</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYAKUHAKUIJYOU}</td><td>&quot;84&quot;</td><td>脈拍異常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINZOUSIKKAN}</td><td>&quot;87&quot;</td><td>心臓疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="25">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAIKAKU}</td><td>&quot;2&quot;</td><td>2：体格</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNDOUKINOSIKKAN}</td><td>&quot;4&quot;</td><td>4：運動器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKAKUKINOSIKKAN}</td><td>&quot;7&quot;</td><td>7：感覚器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUNYOU}</td><td>&quot;10&quot;</td><td>10：糖尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKUSEISINSEIBUTU}</td><td>&quot;15&quot;</td><td>15：悪性新生物</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEKKAKU}</td><td>&quot;20&quot;</td><td>20：結核</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIKEINOSIKKAN}</td><td>&quot;30&quot;</td><td>30：神経系の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYUUKIKEINOSIKKAN}</td><td>&quot;49&quot;</td><td>49：呼吸器の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKETUATU}</td><td>&quot;50&quot;</td><td>50：高血圧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKETUATU}</td><td>&quot;53&quot;</td><td>53：低血圧</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANKAIYOU}</td><td>&quot;60&quot;</td><td>60：消化器疾患・潰瘍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANTANNOU}</td><td>&quot;65&quot;</td><td>65：消化器疾患・胆のう</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANKANZOUSIKKAN}</td><td>&quot;67&quot;</td><td>67：消化器疾患・肝臓疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAKISIKKANSONOTA}</td><td>&quot;69&quot;</td><td>69：消化器疾患・その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANPAKUNYOU}</td><td>&quot;70&quot;</td><td>70：蛋白尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITUNYOUKIKEINOSIKKAN}</td><td>&quot;75&quot;</td><td>75：泌尿器系の疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINSINTYUU}</td><td>&quot;77&quot;</td><td>77：妊娠中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUJINKASIKKAN}</td><td>&quot;78&quot;</td><td>78：婦人科疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETUNYOU}</td><td>&quot;79&quot;</td><td>79：血尿</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINHIDAI}</td><td>&quot;80&quot;</td><td>80：心肥大</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINZATUON}</td><td>&quot;82&quot;</td><td>82：心雑音</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYAKUHAKUIJYOU}</td><td>&quot;84&quot;</td><td>84：脈拍異常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINZOUSIKKAN}</td><td>&quot;87&quot;</td><td>87：心臓疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>99：その他</td></tr>
 * </table>
 */
public class C_SyoubyouCdTyuubunruiKbn extends Classification<C_SyoubyouCdTyuubunruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoubyouCdTyuubunruiKbn BLNK = new C_SyoubyouCdTyuubunruiKbn("0");

    public static final C_SyoubyouCdTyuubunruiKbn TAIKAKU = new C_SyoubyouCdTyuubunruiKbn("2");

    public static final C_SyoubyouCdTyuubunruiKbn UNDOUKINOSIKKAN = new C_SyoubyouCdTyuubunruiKbn("4");

    public static final C_SyoubyouCdTyuubunruiKbn KANKAKUKINOSIKKAN = new C_SyoubyouCdTyuubunruiKbn("7");

    public static final C_SyoubyouCdTyuubunruiKbn TOUNYOU = new C_SyoubyouCdTyuubunruiKbn("10");

    public static final C_SyoubyouCdTyuubunruiKbn AKUSEISINSEIBUTU = new C_SyoubyouCdTyuubunruiKbn("15");

    public static final C_SyoubyouCdTyuubunruiKbn KEKKAKU = new C_SyoubyouCdTyuubunruiKbn("20");

    public static final C_SyoubyouCdTyuubunruiKbn SINKEIKEINOSIKKAN = new C_SyoubyouCdTyuubunruiKbn("30");

    public static final C_SyoubyouCdTyuubunruiKbn KOKYUUKIKEINOSIKKAN = new C_SyoubyouCdTyuubunruiKbn("49");

    public static final C_SyoubyouCdTyuubunruiKbn KOUKETUATU = new C_SyoubyouCdTyuubunruiKbn("50");

    public static final C_SyoubyouCdTyuubunruiKbn TEIKETUATU = new C_SyoubyouCdTyuubunruiKbn("53");

    public static final C_SyoubyouCdTyuubunruiKbn SYOUKAKISIKKANKAIYOU = new C_SyoubyouCdTyuubunruiKbn("60");

    public static final C_SyoubyouCdTyuubunruiKbn SYOUKAKISIKKANTANNOU = new C_SyoubyouCdTyuubunruiKbn("65");

    public static final C_SyoubyouCdTyuubunruiKbn SYOUKAKISIKKANKANZOUSIKKAN = new C_SyoubyouCdTyuubunruiKbn("67");

    public static final C_SyoubyouCdTyuubunruiKbn SYOUKAKISIKKANSONOTA = new C_SyoubyouCdTyuubunruiKbn("69");

    public static final C_SyoubyouCdTyuubunruiKbn TANPAKUNYOU = new C_SyoubyouCdTyuubunruiKbn("70");

    public static final C_SyoubyouCdTyuubunruiKbn HITUNYOUKIKEINOSIKKAN = new C_SyoubyouCdTyuubunruiKbn("75");

    public static final C_SyoubyouCdTyuubunruiKbn NINSINTYUU = new C_SyoubyouCdTyuubunruiKbn("77");

    public static final C_SyoubyouCdTyuubunruiKbn HUJINKASIKKAN = new C_SyoubyouCdTyuubunruiKbn("78");

    public static final C_SyoubyouCdTyuubunruiKbn KETUNYOU = new C_SyoubyouCdTyuubunruiKbn("79");

    public static final C_SyoubyouCdTyuubunruiKbn SINHIDAI = new C_SyoubyouCdTyuubunruiKbn("80");

    public static final C_SyoubyouCdTyuubunruiKbn SINZATUON = new C_SyoubyouCdTyuubunruiKbn("82");

    public static final C_SyoubyouCdTyuubunruiKbn MYAKUHAKUIJYOU = new C_SyoubyouCdTyuubunruiKbn("84");

    public static final C_SyoubyouCdTyuubunruiKbn SINZOUSIKKAN = new C_SyoubyouCdTyuubunruiKbn("87");

    public static final C_SyoubyouCdTyuubunruiKbn SONOTA = new C_SyoubyouCdTyuubunruiKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TAIKAKU, "TAIKAKU", false);
        addPattern(PATTERN_DEFAULT, UNDOUKINOSIKKAN, "UNDOUKINOSIKKAN", false);
        addPattern(PATTERN_DEFAULT, KANKAKUKINOSIKKAN, "KANKAKUKINOSIKKAN", false);
        addPattern(PATTERN_DEFAULT, TOUNYOU, "TOUNYOU", false);
        addPattern(PATTERN_DEFAULT, AKUSEISINSEIBUTU, "AKUSEISINSEIBUTU", false);
        addPattern(PATTERN_DEFAULT, KEKKAKU, "KEKKAKU", false);
        addPattern(PATTERN_DEFAULT, SINKEIKEINOSIKKAN, "SINKEIKEINOSIKKAN", false);
        addPattern(PATTERN_DEFAULT, KOKYUUKIKEINOSIKKAN, "KOKYUUKIKEINOSIKKAN", false);
        addPattern(PATTERN_DEFAULT, KOUKETUATU, "KOUKETUATU", false);
        addPattern(PATTERN_DEFAULT, TEIKETUATU, "TEIKETUATU", false);
        addPattern(PATTERN_DEFAULT, SYOUKAKISIKKANKAIYOU, "SYOUKAKISIKKANKAIYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUKAKISIKKANTANNOU, "SYOUKAKISIKKANTANNOU", false);
        addPattern(PATTERN_DEFAULT, SYOUKAKISIKKANKANZOUSIKKAN, "SYOUKAKISIKKANKANZOUSIKKAN", false);
        addPattern(PATTERN_DEFAULT, SYOUKAKISIKKANSONOTA, "SYOUKAKISIKKANSONOTA", false);
        addPattern(PATTERN_DEFAULT, TANPAKUNYOU, "TANPAKUNYOU", false);
        addPattern(PATTERN_DEFAULT, HITUNYOUKIKEINOSIKKAN, "HITUNYOUKIKEINOSIKKAN", false);
        addPattern(PATTERN_DEFAULT, NINSINTYUU, "NINSINTYUU", false);
        addPattern(PATTERN_DEFAULT, HUJINKASIKKAN, "HUJINKASIKKAN", false);
        addPattern(PATTERN_DEFAULT, KETUNYOU, "KETUNYOU", false);
        addPattern(PATTERN_DEFAULT, SINHIDAI, "SINHIDAI", false);
        addPattern(PATTERN_DEFAULT, SINZATUON, "SINZATUON", false);
        addPattern(PATTERN_DEFAULT, MYAKUHAKUIJYOU, "MYAKUHAKUIJYOU", false);
        addPattern(PATTERN_DEFAULT, SINZOUSIKKAN, "SINZOUSIKKAN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, TAIKAKU, "TAIKAKU", false);
        addPattern(PATTERN_SELECT, UNDOUKINOSIKKAN, "UNDOUKINOSIKKAN", false);
        addPattern(PATTERN_SELECT, KANKAKUKINOSIKKAN, "KANKAKUKINOSIKKAN", false);
        addPattern(PATTERN_SELECT, TOUNYOU, "TOUNYOU", false);
        addPattern(PATTERN_SELECT, AKUSEISINSEIBUTU, "AKUSEISINSEIBUTU", false);
        addPattern(PATTERN_SELECT, KEKKAKU, "KEKKAKU", false);
        addPattern(PATTERN_SELECT, SINKEIKEINOSIKKAN, "SINKEIKEINOSIKKAN", false);
        addPattern(PATTERN_SELECT, KOKYUUKIKEINOSIKKAN, "KOKYUUKIKEINOSIKKAN", false);
        addPattern(PATTERN_SELECT, KOUKETUATU, "KOUKETUATU", false);
        addPattern(PATTERN_SELECT, TEIKETUATU, "TEIKETUATU", false);
        addPattern(PATTERN_SELECT, SYOUKAKISIKKANKAIYOU, "SYOUKAKISIKKANKAIYOU", false);
        addPattern(PATTERN_SELECT, SYOUKAKISIKKANTANNOU, "SYOUKAKISIKKANTANNOU", false);
        addPattern(PATTERN_SELECT, SYOUKAKISIKKANKANZOUSIKKAN, "SYOUKAKISIKKANKANZOUSIKKAN", false);
        addPattern(PATTERN_SELECT, SYOUKAKISIKKANSONOTA, "SYOUKAKISIKKANSONOTA", false);
        addPattern(PATTERN_SELECT, TANPAKUNYOU, "TANPAKUNYOU", false);
        addPattern(PATTERN_SELECT, HITUNYOUKIKEINOSIKKAN, "HITUNYOUKIKEINOSIKKAN", false);
        addPattern(PATTERN_SELECT, NINSINTYUU, "NINSINTYUU", false);
        addPattern(PATTERN_SELECT, HUJINKASIKKAN, "HUJINKASIKKAN", false);
        addPattern(PATTERN_SELECT, KETUNYOU, "KETUNYOU", false);
        addPattern(PATTERN_SELECT, SINHIDAI, "SINHIDAI", false);
        addPattern(PATTERN_SELECT, SINZATUON, "SINZATUON", false);
        addPattern(PATTERN_SELECT, MYAKUHAKUIJYOU, "MYAKUHAKUIJYOU", false);
        addPattern(PATTERN_SELECT, SINZOUSIKKAN, "SINZOUSIKKAN", false);
        addPattern(PATTERN_SELECT, SONOTA, "SONOTA", false);


        lock(C_SyoubyouCdTyuubunruiKbn.class);
    }

    private C_SyoubyouCdTyuubunruiKbn(String value) {
        super(value);
    }

    public static C_SyoubyouCdTyuubunruiKbn valueOf(String value) {
        return valueOf(C_SyoubyouCdTyuubunruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoubyouCdTyuubunruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoubyouCdTyuubunruiKbn.class, patternId, value);
    }
}
