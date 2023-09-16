package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_OuNnknShrRn;

/**
 * ＯＵ用年金支払テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_OuNnknShrRn extends AbstractExDBTable<ZT_OuNnknShrRn> {

    public GenQZT_OuNnknShrRn() {
        this("ZT_OuNnknShrRn");
    }

    public GenQZT_OuNnknShrRn(String pAlias) {
        super("ZT_OuNnknShrRn", ZT_OuNnknShrRn.class, pAlias);
    }

    public String ZT_OuNnknShrRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnkijyunym = new ExDBFieldString<>("zrnkijyunym", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsiharaisosikicd = new ExDBFieldString<>("zrnsiharaisosikicd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnjikohasseiymd = new ExDBFieldString<>("zrnjikohasseiymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrntukigakunengakukbn = new ExDBFieldString<>("zrntukigakunengakukbn", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnkeiyakunenkingaku = new ExDBFieldNumber<>("zrnkeiyakunenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnkasannkgk = new ExDBFieldNumber<>("zrnkasannkgk", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnuwanosenenkingaku = new ExDBFieldNumber<>("zrnuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnsasihikisiharaigaku = new ExDBFieldNumber<>("zrnsasihikisiharaigaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnsiharainenkingaku = new ExDBFieldNumber<>("zrnsiharainenkingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnsiboujikyuuhukingaku = new ExDBFieldNumber<>("zrnsiboujikyuuhukingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnsiharaid = new ExDBFieldNumber<>("zrnsiharaid", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrngensentyousyuuzeigaku = new ExDBFieldNumber<>("zrngensentyousyuuzeigaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnsonotasiharaikingaku = new ExDBFieldNumber<>("zrnsonotasiharaikingaku", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnttkekstkjyutukngk = new ExDBFieldNumber<>("zrnttkekstkjyutukngk", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkingakurank = new ExDBFieldString<>("zrnnenkingakurank", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsyorinaiyoukbn = new ExDBFieldString<>("zrnsyorinaiyoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinsiharaihouhoukbn = new ExDBFieldString<>("zrnnenkinsiharaihouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinhanbaimeisyou = new ExDBFieldString<>("zrnnenkinhanbaimeisyou", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnkshrhasseiriyuukbn = new ExDBFieldString<>("zrnnkshrhasseiriyuukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnkknsetymd = new ExDBFieldString<>("zrnkknsetymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnksjihihokensyaage = new ExDBFieldString<>("zrnnksjihihokensyaage", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndai2hihokensyaseibetukbn = new ExDBFieldString<>("zrndai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnksjidai2hhknsyaage = new ExDBFieldString<>("zrnnksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnkuketorininkbn = new ExDBFieldString<>("zrnnkuketorininkbn", this);

    public final ExDBFieldNumber<ZT_OuNnknShrRn, Long> zrnnkuktrnnhukusuuninzuu = new ExDBFieldNumber<>("zrnnkuktrnnhukusuuninzuu", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnhihokensyasibouymd = new ExDBFieldString<>("zrnhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndai2hihokensyasibouymd = new ExDBFieldString<>("zrndai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnhoujinuketorininhyouji = new ExDBFieldString<>("zrnhoujinuketorininhyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnktouduketorihouhoukbn = new ExDBFieldString<>("zrnnktouduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrntatekaearihyouji = new ExDBFieldString<>("zrntatekaearihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnkasitukearihyouji = new ExDBFieldString<>("zrnkasitukearihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrntokuyakuarihyouji = new ExDBFieldString<>("zrntokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnkzeiseitekikakutkykkbn = new ExDBFieldString<>("zrnnkzeiseitekikakutkykkbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsiharaikaisuukbn = new ExDBFieldString<>("zrnsiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnmotokykhrkhouhoukbn = new ExDBFieldString<>("zrnmotokykhrkhouhoukbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnseisikakymd = new ExDBFieldString<>("zrnseisikakymd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnsegcd = new ExDBFieldString<>("zrnsegcd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten1oyacd = new ExDBFieldString<>("zrndairiten1oyacd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten1oyakanjinm = new ExDBFieldString<>("zrndairiten1oyakanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten2oyacd = new ExDBFieldString<>("zrndairiten2oyacd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten2oyakanjinm = new ExDBFieldString<>("zrndairiten2oyakanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten1cd = new ExDBFieldString<>("zrndairiten1cd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten1kanjinm = new ExDBFieldString<>("zrndairiten1kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbosyuunin1cd = new ExDBFieldString<>("zrnbosyuunin1cd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbosyuu1kanjinm = new ExDBFieldString<>("zrnbosyuu1kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten2cd = new ExDBFieldString<>("zrndairiten2cd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrndairiten2kanjinm = new ExDBFieldString<>("zrndairiten2kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbosyuunin2cd = new ExDBFieldString<>("zrnbosyuunin2cd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbosyuu2kanjinm = new ExDBFieldString<>("zrnbosyuu2kanjinm", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnbankcd = new ExDBFieldString<>("zrnbankcd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnshitencd = new ExDBFieldString<>("zrnshitencd", this);

    public final ExDBFieldString<ZT_OuNnknShrRn, String> zrnyobiv71 = new ExDBFieldString<>("zrnyobiv71", this);
}
