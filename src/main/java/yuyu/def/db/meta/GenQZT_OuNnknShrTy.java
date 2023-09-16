package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_OuNnknShrTy;

/**
 * ＯＵ用年金支払テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_OuNnknShrTy extends AbstractExDBTable<ZT_OuNnknShrTy> {

    public GenQZT_OuNnknShrTy() {
        this("ZT_OuNnknShrTy");
    }

    public GenQZT_OuNnknShrTy(String pAlias) {
        super("ZT_OuNnknShrTy", ZT_OuNnknShrTy.class, pAlias);
    }

    public String ZT_OuNnknShrTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztykijyunym = new ExDBFieldString<>("ztykijyunym", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysiharaisosikicd = new ExDBFieldString<>("ztysiharaisosikicd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyjikohasseiymd = new ExDBFieldString<>("ztyjikohasseiymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztytukigakunengakukbn = new ExDBFieldString<>("ztytukigakunengakukbn", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztykeiyakunenkingaku = new ExDBFieldNumber<>("ztykeiyakunenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztykasannkgk = new ExDBFieldNumber<>("ztykasannkgk", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztyuwanosenenkingaku = new ExDBFieldNumber<>("ztyuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztysasihikisiharaigaku = new ExDBFieldNumber<>("ztysasihikisiharaigaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztysiharainenkingaku = new ExDBFieldNumber<>("ztysiharainenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztysiboujikyuuhukingaku = new ExDBFieldNumber<>("ztysiboujikyuuhukingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztysiharaid = new ExDBFieldNumber<>("ztysiharaid", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztygensentyousyuuzeigaku = new ExDBFieldNumber<>("ztygensentyousyuuzeigaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztysonotasiharaikingaku = new ExDBFieldNumber<>("ztysonotasiharaikingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztyttkekstkjyutukngk = new ExDBFieldNumber<>("ztyttkekstkjyutukngk", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkingakurank = new ExDBFieldString<>("ztynenkingakurank", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysyorinaiyoukbn = new ExDBFieldString<>("ztysyorinaiyoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinsiharaihouhoukbn = new ExDBFieldString<>("ztynenkinsiharaihouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinhanbaimeisyou = new ExDBFieldString<>("ztynenkinhanbaimeisyou", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynkshrhasseiriyuukbn = new ExDBFieldString<>("ztynkshrhasseiriyuukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztykknsetymd = new ExDBFieldString<>("ztykknsetymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynksjihihokensyaage = new ExDBFieldString<>("ztynksjihihokensyaage", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynksjidai2hhknsyaage = new ExDBFieldString<>("ztynksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynkuketorininkbn = new ExDBFieldString<>("ztynkuketorininkbn", this);

    public final ExDBFieldNumber<ZT_OuNnknShrTy, Long> ztynkuktrnnhukusuuninzuu = new ExDBFieldNumber<>("ztynkuktrnnhukusuuninzuu", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyhihokensyasibouymd = new ExDBFieldString<>("ztyhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydai2hihokensyasibouymd = new ExDBFieldString<>("ztydai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyhoujinuketorininhyouji = new ExDBFieldString<>("ztyhoujinuketorininhyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynktouduketorihouhoukbn = new ExDBFieldString<>("ztynktouduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztytatekaearihyouji = new ExDBFieldString<>("ztytatekaearihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztykasitukearihyouji = new ExDBFieldString<>("ztykasitukearihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztytokuyakuarihyouji = new ExDBFieldString<>("ztytokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynkzeiseitekikakutkykkbn = new ExDBFieldString<>("ztynkzeiseitekikakutkykkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysiharaikaisuukbn = new ExDBFieldString<>("ztysiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztymotokykhrkhouhoukbn = new ExDBFieldString<>("ztymotokykhrkhouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyseisikakymd = new ExDBFieldString<>("ztyseisikakymd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztysegcd = new ExDBFieldString<>("ztysegcd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten1oyacd = new ExDBFieldString<>("ztydairiten1oyacd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten1oyakanjinm = new ExDBFieldString<>("ztydairiten1oyakanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten2oyacd = new ExDBFieldString<>("ztydairiten2oyacd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten2oyakanjinm = new ExDBFieldString<>("ztydairiten2oyakanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten1cd = new ExDBFieldString<>("ztydairiten1cd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten1kanjinm = new ExDBFieldString<>("ztydairiten1kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybosyuunin1cd = new ExDBFieldString<>("ztybosyuunin1cd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybosyuu1kanjinm = new ExDBFieldString<>("ztybosyuu1kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten2cd = new ExDBFieldString<>("ztydairiten2cd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztydairiten2kanjinm = new ExDBFieldString<>("ztydairiten2kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybosyuunin2cd = new ExDBFieldString<>("ztybosyuunin2cd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybosyuu2kanjinm = new ExDBFieldString<>("ztybosyuu2kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztybankcd = new ExDBFieldString<>("ztybankcd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyshitencd = new ExDBFieldString<>("ztyshitencd", this);

    public final ExDBFieldString<ZT_OuNnknShrTy, String> ztyyobiv71 = new ExDBFieldString<>("ztyyobiv71", this);
}
