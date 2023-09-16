
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * （資産運用）異動事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZfiIdoujiyuuKbn</td><td colspan="3">（資産運用）異動事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="44">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SINKEIYAKU}</td><td>&quot;010&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;020&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKUBFR}</td><td>&quot;030&quot;</td><td>減額（変更前）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKUNEW}</td><td>&quot;031&quot;</td><td>減額（変更後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEITSBFR}</td><td>&quot;040&quot;</td><td>生年月日・性訂正（変更前）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEITSNEW}</td><td>&quot;041&quot;</td><td>生年月日・性訂正（変更後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUTORIKESI}</td><td>&quot;050&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;051&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;052&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;053&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJYO}</td><td>&quot;054&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMENSEKI}</td><td>&quot;055&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMENSEKISHRNASI}</td><td>&quot;056&quot;</td><td>死亡免責（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMUKOUKIBARAIPSHR}</td><td>&quot;057&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMUKOUSHRNASI}</td><td>&quot;058&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;060&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;061&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;070&quot;</td><td>目標額到達時円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPBFR}</td><td>&quot;080&quot;</td><td>指数連動積立金積増（移転なし）（変更前）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPNEW}</td><td>&quot;081&quot;</td><td>指数連動積立金積増（移転なし）（変更後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPITNBFR}</td><td>&quot;082&quot;</td><td>指数連動積立金積増（移転同時）（変更前）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPITNNEW}</td><td>&quot;083&quot;</td><td>指数連動積立金積増（移転同時）（変更後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUSYOUMETU}</td><td>&quot;090&quot;</td><td>Ｐ未入消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUTRKS}</td><td>&quot;910&quot;</td><td>新契約［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUTRKS}</td><td>&quot;920&quot;</td><td>解約［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKUBFRTRKS}</td><td>&quot;930&quot;</td><td>減額（変更前）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKUNEWTRKS}</td><td>&quot;931&quot;</td><td>減額（変更後）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEITSBFRTRKS}</td><td>&quot;940&quot;</td><td>生年月日・性訂正（変更前）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEITSNEWTRKS}</td><td>&quot;941&quot;</td><td>生年月日・性訂正（変更後）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUTORIKESITRKS}</td><td>&quot;950&quot;</td><td>契約取消［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOUTRKS}</td><td>&quot;951&quot;</td><td>無効［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFFTRKS}</td><td>&quot;952&quot;</td><td>クーリングオフ［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYOTRKS}</td><td>&quot;953&quot;</td><td>解除［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJYOTRKS}</td><td>&quot;954&quot;</td><td>死亡解除［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMENSEKITRKS}</td><td>&quot;955&quot;</td><td>死亡免責［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMENSEKISHRNASITRKS}</td><td>&quot;956&quot;</td><td>死亡免責（支払なし）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMUKOUKIBARAIPSHRTRKS}</td><td>&quot;957&quot;</td><td>死亡無効（既払Ｐ支払）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUMUKOUSHRNASITRKS}</td><td>&quot;958&quot;</td><td>死亡無効（支払なし）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUTRKS}</td><td>&quot;960&quot;</td><td>死亡［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAITRKS}</td><td>&quot;961&quot;</td><td>高度障害［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNKTRKS}</td><td>&quot;970&quot;</td><td>目標額到達時円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPITNBFRTRKS}</td><td>&quot;982&quot;</td><td>指数連動積立金積増（移転同時）（変更前）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUURNDTMTTKNUPITNNEWTRKS}</td><td>&quot;983&quot;</td><td>指数連動積立金積増（移転同時）（変更後）［取消］</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUSYOUMETUTRKS}</td><td>&quot;990&quot;</td><td>Ｐ未入消滅［取消］</td></tr>
 * </table>
 */
public class C_ZfiIdoujiyuuKbn extends Classification<C_ZfiIdoujiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZfiIdoujiyuuKbn SINKEIYAKU = new C_ZfiIdoujiyuuKbn("010");

    public static final C_ZfiIdoujiyuuKbn KAIYAKU = new C_ZfiIdoujiyuuKbn("020");

    public static final C_ZfiIdoujiyuuKbn GENGAKUBFR = new C_ZfiIdoujiyuuKbn("030");

    public static final C_ZfiIdoujiyuuKbn GENGAKUNEW = new C_ZfiIdoujiyuuKbn("031");

    public static final C_ZfiIdoujiyuuKbn SEINENGAPPISEITSBFR = new C_ZfiIdoujiyuuKbn("040");

    public static final C_ZfiIdoujiyuuKbn SEINENGAPPISEITSNEW = new C_ZfiIdoujiyuuKbn("041");

    public static final C_ZfiIdoujiyuuKbn KEIYAKUTORIKESI = new C_ZfiIdoujiyuuKbn("050");

    public static final C_ZfiIdoujiyuuKbn MUKOU = new C_ZfiIdoujiyuuKbn("051");

    public static final C_ZfiIdoujiyuuKbn COOLINGOFF = new C_ZfiIdoujiyuuKbn("052");

    public static final C_ZfiIdoujiyuuKbn KAIJYO = new C_ZfiIdoujiyuuKbn("053");

    public static final C_ZfiIdoujiyuuKbn SIBOUKAIJYO = new C_ZfiIdoujiyuuKbn("054");

    public static final C_ZfiIdoujiyuuKbn SIBOUMENSEKI = new C_ZfiIdoujiyuuKbn("055");

    public static final C_ZfiIdoujiyuuKbn SIBOUMENSEKISHRNASI = new C_ZfiIdoujiyuuKbn("056");

    public static final C_ZfiIdoujiyuuKbn SIBOUMUKOUKIBARAIPSHR = new C_ZfiIdoujiyuuKbn("057");

    public static final C_ZfiIdoujiyuuKbn SIBOUMUKOUSHRNASI = new C_ZfiIdoujiyuuKbn("058");

    public static final C_ZfiIdoujiyuuKbn SIBOU = new C_ZfiIdoujiyuuKbn("060");

    public static final C_ZfiIdoujiyuuKbn KOUDOSYOUGAI = new C_ZfiIdoujiyuuKbn("061");

    public static final C_ZfiIdoujiyuuKbn MKHGKTTTYENDTHNK = new C_ZfiIdoujiyuuKbn("070");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPBFR = new C_ZfiIdoujiyuuKbn("080");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPNEW = new C_ZfiIdoujiyuuKbn("081");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPITNBFR = new C_ZfiIdoujiyuuKbn("082");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPITNNEW = new C_ZfiIdoujiyuuKbn("083");

    public static final C_ZfiIdoujiyuuKbn PMINYUSYOUMETU = new C_ZfiIdoujiyuuKbn("090");

    public static final C_ZfiIdoujiyuuKbn SINKEIYAKUTRKS = new C_ZfiIdoujiyuuKbn("910");

    public static final C_ZfiIdoujiyuuKbn KAIYAKUTRKS = new C_ZfiIdoujiyuuKbn("920");

    public static final C_ZfiIdoujiyuuKbn GENGAKUBFRTRKS = new C_ZfiIdoujiyuuKbn("930");

    public static final C_ZfiIdoujiyuuKbn GENGAKUNEWTRKS = new C_ZfiIdoujiyuuKbn("931");

    public static final C_ZfiIdoujiyuuKbn SEINENGAPPISEITSBFRTRKS = new C_ZfiIdoujiyuuKbn("940");

    public static final C_ZfiIdoujiyuuKbn SEINENGAPPISEITSNEWTRKS = new C_ZfiIdoujiyuuKbn("941");

    public static final C_ZfiIdoujiyuuKbn KEIYAKUTORIKESITRKS = new C_ZfiIdoujiyuuKbn("950");

    public static final C_ZfiIdoujiyuuKbn MUKOUTRKS = new C_ZfiIdoujiyuuKbn("951");

    public static final C_ZfiIdoujiyuuKbn COOLINGOFFTRKS = new C_ZfiIdoujiyuuKbn("952");

    public static final C_ZfiIdoujiyuuKbn KAIJYOTRKS = new C_ZfiIdoujiyuuKbn("953");

    public static final C_ZfiIdoujiyuuKbn SIBOUKAIJYOTRKS = new C_ZfiIdoujiyuuKbn("954");

    public static final C_ZfiIdoujiyuuKbn SIBOUMENSEKITRKS = new C_ZfiIdoujiyuuKbn("955");

    public static final C_ZfiIdoujiyuuKbn SIBOUMENSEKISHRNASITRKS = new C_ZfiIdoujiyuuKbn("956");

    public static final C_ZfiIdoujiyuuKbn SIBOUMUKOUKIBARAIPSHRTRKS = new C_ZfiIdoujiyuuKbn("957");

    public static final C_ZfiIdoujiyuuKbn SIBOUMUKOUSHRNASITRKS = new C_ZfiIdoujiyuuKbn("958");

    public static final C_ZfiIdoujiyuuKbn SIBOUTRKS = new C_ZfiIdoujiyuuKbn("960");

    public static final C_ZfiIdoujiyuuKbn KOUDOSYOUGAITRKS = new C_ZfiIdoujiyuuKbn("961");

    public static final C_ZfiIdoujiyuuKbn MKHGKTTTYENDTHNKTRKS = new C_ZfiIdoujiyuuKbn("970");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPITNBFRTRKS = new C_ZfiIdoujiyuuKbn("982");

    public static final C_ZfiIdoujiyuuKbn SISUURNDTMTTKNUPITNNEWTRKS = new C_ZfiIdoujiyuuKbn("983");

    public static final C_ZfiIdoujiyuuKbn PMINYUSYOUMETUTRKS = new C_ZfiIdoujiyuuKbn("990");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SINKEIYAKU, "SINKEIYAKU", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKUBFR, "GENGAKUBFR", false);
        addPattern(PATTERN_DEFAULT, GENGAKUNEW, "GENGAKUNEW", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEITSBFR, "SEINENGAPPISEITSBFR", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEITSNEW, "SEINENGAPPISEITSNEW", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUTORIKESI, "KEIYAKUTORIKESI", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJYO, "SIBOUKAIJYO", false);
        addPattern(PATTERN_DEFAULT, SIBOUMENSEKI, "SIBOUMENSEKI", false);
        addPattern(PATTERN_DEFAULT, SIBOUMENSEKISHRNASI, "SIBOUMENSEKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, SIBOUMUKOUKIBARAIPSHR, "SIBOUMUKOUKIBARAIPSHR", false);
        addPattern(PATTERN_DEFAULT, SIBOUMUKOUSHRNASI, "SIBOUMUKOUSHRNASI", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPBFR, "SISUURNDTMTTKNUPBFR", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPNEW, "SISUURNDTMTTKNUPNEW", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPITNBFR, "SISUURNDTMTTKNUPITNBFR", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPITNNEW, "SISUURNDTMTTKNUPITNNEW", false);
        addPattern(PATTERN_DEFAULT, PMINYUSYOUMETU, "PMINYUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUTRKS, "SINKEIYAKUTRKS", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUTRKS, "KAIYAKUTRKS", false);
        addPattern(PATTERN_DEFAULT, GENGAKUBFRTRKS, "GENGAKUBFRTRKS", false);
        addPattern(PATTERN_DEFAULT, GENGAKUNEWTRKS, "GENGAKUNEWTRKS", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEITSBFRTRKS, "SEINENGAPPISEITSBFRTRKS", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEITSNEWTRKS, "SEINENGAPPISEITSNEWTRKS", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUTORIKESITRKS, "KEIYAKUTORIKESITRKS", false);
        addPattern(PATTERN_DEFAULT, MUKOUTRKS, "MUKOUTRKS", false);
        addPattern(PATTERN_DEFAULT, COOLINGOFFTRKS, "COOLINGOFFTRKS", false);
        addPattern(PATTERN_DEFAULT, KAIJYOTRKS, "KAIJYOTRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJYOTRKS, "SIBOUKAIJYOTRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUMENSEKITRKS, "SIBOUMENSEKITRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUMENSEKISHRNASITRKS, "SIBOUMENSEKISHRNASITRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUMUKOUKIBARAIPSHRTRKS, "SIBOUMUKOUKIBARAIPSHRTRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUMUKOUSHRNASITRKS, "SIBOUMUKOUSHRNASITRKS", false);
        addPattern(PATTERN_DEFAULT, SIBOUTRKS, "SIBOUTRKS", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAITRKS, "KOUDOSYOUGAITRKS", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNKTRKS, "MKHGKTTTYENDTHNKTRKS", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPITNBFRTRKS, "SISUURNDTMTTKNUPITNBFRTRKS", false);
        addPattern(PATTERN_DEFAULT, SISUURNDTMTTKNUPITNNEWTRKS, "SISUURNDTMTTKNUPITNNEWTRKS", false);
        addPattern(PATTERN_DEFAULT, PMINYUSYOUMETUTRKS, "PMINYUSYOUMETUTRKS", false);


        lock(C_ZfiIdoujiyuuKbn.class);
    }

    private C_ZfiIdoujiyuuKbn(String value) {
        super(value);
    }

    public static C_ZfiIdoujiyuuKbn valueOf(String value) {
        return valueOf(C_ZfiIdoujiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZfiIdoujiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZfiIdoujiyuuKbn.class, patternId, value);
    }
}
