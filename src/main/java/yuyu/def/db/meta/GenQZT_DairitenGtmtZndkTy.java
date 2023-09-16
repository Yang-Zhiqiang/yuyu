package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店月末残高情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenGtmtZndkTy extends AbstractExDBTable<ZT_DairitenGtmtZndkTy> {

    public GenQZT_DairitenGtmtZndkTy() {
        this("ZT_DairitenGtmtZndkTy");
    }

    public GenQZT_DairitenGtmtZndkTy(String pAlias) {
        super("ZT_DairitenGtmtZndkTy", ZT_DairitenGtmtZndkTy.class, pAlias);
    }

    public String ZT_DairitenGtmtZndkTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztydatakijyunymd = new ExDBFieldString<>("ztydatakijyunymd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztytuuka = new ExDBFieldString<>("ztytuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztykyknmkndrtengtmtzndk = new ExDBFieldString<>("ztykyknmkndrtengtmtzndk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztykyknmkjdrtengtmtzndk = new ExDBFieldString<>("ztykyknmkjdrtengtmtzndk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhhknnmkjdrtengtmtzndk = new ExDBFieldString<>("ztyhhknnmkjdrtengtmtzndk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyitijibrp = new ExDBFieldNumber<>("ztyitijibrp", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztygoukeip2 = new ExDBFieldNumber<>("ztygoukeip2", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyzennoup = new ExDBFieldNumber<>("ztyzennoup", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztytumitatekngk = new ExDBFieldNumber<>("ztytumitatekngk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztytargettktoutatubi = new ExDBFieldString<>("ztytargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztymokuhyouti = new ExDBFieldNumber<>("ztymokuhyouti", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztymokuhyoukngk = new ExDBFieldNumber<>("ztymokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykaiyakuhr = new ExDBFieldNumber<>("ztykaiyakuhr", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztykihrkmpjytym = new ExDBFieldString<>("ztykihrkmpjytym", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykihrpruikeigk = new ExDBFieldNumber<>("ztykihrpruikeigk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztytousyokykjikawaserate = new ExDBFieldString<>("ztytousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztymankiymd = new ExDBFieldString<>("ztymankiymd", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykishrkinruikeigk = new ExDBFieldNumber<>("ztykishrkinruikeigk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysjkkktyouseigk = new ExDBFieldNumber<>("ztysjkkktyouseigk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykaiyakukjgk = new ExDBFieldNumber<>("ztykaiyakukjgk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysoneki = new ExDBFieldNumber<>("ztysoneki", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztysonekicalchunouflg = new ExDBFieldString<>("ztysonekicalchunouflg", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztygmeigyoubijiyenshrrate = new ExDBFieldString<>("ztygmeigyoubijiyenshrrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztygmeigyoubijikawaserate = new ExDBFieldString<>("ztygmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztytousyokykjiyennyknrate = new ExDBFieldString<>("ztytousyokykjiyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztytousyokykjigaikanyknrate = new ExDBFieldString<>("ztytousyokykjigaikanyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztykanyuusyaknrno = new ExDBFieldString<>("ztykanyuusyaknrno", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhrkstgktuuka = new ExDBFieldString<>("ztyhrkstgktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztymokuhyoukngktuuka = new ExDBFieldString<>("ztymokuhyoukngktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysonotaseisankin = new ExDBFieldNumber<>("ztysonotaseisankin", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyyenkansansaiyousign = new ExDBFieldString<>("ztyyenkansansaiyousign", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztykykjiyoteitmttriritu = new ExDBFieldString<>("ztykykjiyoteitmttriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhukusuutuukaflg = new ExDBFieldString<>("ztyhukusuutuukaflg", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyyenkansanhunoflg = new ExDBFieldString<>("ztyyenkansanhunoflg", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztytyusyaku20 = new ExDBFieldString<>("ztytyusyaku20", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsyaatkioydrtencd = new ExDBFieldString<>("ztyskeibsyaatkioydrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsybatkioydrtencd = new ExDBFieldString<>("ztyskeibsybatkioydrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsyaatkidrtencd = new ExDBFieldString<>("ztyskeibsyaatkidrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsybatkidrtencd = new ExDBFieldString<>("ztyskeibsybatkidrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsyaatkibosyuucd = new ExDBFieldString<>("ztyskeibsyaatkibosyuucd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyskeibsybatkibosyuucd = new ExDBFieldString<>("ztyskeibsybatkibosyuucd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyitijibrpkyktuukagtmtzndk = new ExDBFieldNumber<>("ztyitijibrpkyktuukagtmtzndk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztygoukeip2kyktuuka = new ExDBFieldNumber<>("ztygoukeip2kyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyzennoupkyktuuka = new ExDBFieldNumber<>("ztyzennoupkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztytmttkngkkyktuuka = new ExDBFieldNumber<>("ztytmttkngkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykaiyakuhrkyktuuka = new ExDBFieldNumber<>("ztykaiyakuhrkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykishrkinruikeigkkyktuuka = new ExDBFieldNumber<>("ztykishrkinruikeigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysjkkktyouseigkkyktuuka = new ExDBFieldNumber<>("ztysjkkktyouseigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykaiyakukjgkkyktuuka = new ExDBFieldNumber<>("ztykaiyakukjgkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysonekikyktuuka = new ExDBFieldNumber<>("ztysonekikyktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztysonekicalchunouflgsmbc = new ExDBFieldString<>("ztysonekicalchunouflgsmbc", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysonotaseisankinkyktuuka = new ExDBFieldNumber<>("ztysonotaseisankinkyktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztytyusyakusmbc = new ExDBFieldString<>("ztytyusyakusmbc", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, BizNumber> ztygmeigyoubijigaikashrrate = new ExDBFieldString<>("ztygmeigyoubijigaikashrrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztykihrpruikeigkkyktuuka = new ExDBFieldNumber<>("ztykihrpruikeigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztygoukeip2smtb = new ExDBFieldNumber<>("ztygoukeip2smtb", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztysonekismtb = new ExDBFieldNumber<>("ztysonekismtb", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztysonekicalchunouflgsmtb = new ExDBFieldString<>("ztysonekicalchunouflgsmtb", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkTy, String> ztyyobiv56 = new ExDBFieldString<>("ztyyobiv56", this);
}
