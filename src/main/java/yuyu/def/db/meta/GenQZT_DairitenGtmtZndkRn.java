package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店月末残高情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenGtmtZndkRn extends AbstractExDBTable<ZT_DairitenGtmtZndkRn> {

    public GenQZT_DairitenGtmtZndkRn() {
        this("ZT_DairitenGtmtZndkRn");
    }

    public GenQZT_DairitenGtmtZndkRn(String pAlias) {
        super("ZT_DairitenGtmtZndkRn", ZT_DairitenGtmtZndkRn.class, pAlias);
    }

    public String ZT_DairitenGtmtZndkRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrndatakijyunymd = new ExDBFieldString<>("zrndatakijyunymd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrntuuka = new ExDBFieldString<>("zrntuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnkyknmkndrtengtmtzndk = new ExDBFieldString<>("zrnkyknmkndrtengtmtzndk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnkyknmkjdrtengtmtzndk = new ExDBFieldString<>("zrnkyknmkjdrtengtmtzndk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhhknnmkjdrtengtmtzndk = new ExDBFieldString<>("zrnhhknnmkjdrtengtmtzndk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnitijibrp = new ExDBFieldNumber<>("zrnitijibrp", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrngoukeip2 = new ExDBFieldNumber<>("zrngoukeip2", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnzennoup = new ExDBFieldNumber<>("zrnzennoup", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrntumitatekngk = new ExDBFieldNumber<>("zrntumitatekngk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrntargettktoutatubi = new ExDBFieldString<>("zrntargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnmokuhyouti = new ExDBFieldNumber<>("zrnmokuhyouti", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnmokuhyoukngk = new ExDBFieldNumber<>("zrnmokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkaiyakuhr = new ExDBFieldNumber<>("zrnkaiyakuhr", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnkihrkmpjytym = new ExDBFieldString<>("zrnkihrkmpjytym", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkihrpruikeigk = new ExDBFieldNumber<>("zrnkihrpruikeigk", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrntousyokykjikawaserate = new ExDBFieldString<>("zrntousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnmankiymd = new ExDBFieldString<>("zrnmankiymd", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkishrkinruikeigk = new ExDBFieldNumber<>("zrnkishrkinruikeigk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsjkkktyouseigk = new ExDBFieldNumber<>("zrnsjkkktyouseigk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkaiyakukjgk = new ExDBFieldNumber<>("zrnkaiyakukjgk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsoneki = new ExDBFieldNumber<>("zrnsoneki", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnsonekicalchunouflg = new ExDBFieldString<>("zrnsonekicalchunouflg", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrngmeigyoubijiyenshrrate = new ExDBFieldString<>("zrngmeigyoubijiyenshrrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrngmeigyoubijikawaserate = new ExDBFieldString<>("zrngmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrntousyokykjiyennyknrate = new ExDBFieldString<>("zrntousyokykjiyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrntousyokykjigaikanyknrate = new ExDBFieldString<>("zrntousyokykjigaikanyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnkanyuusyaknrno = new ExDBFieldString<>("zrnkanyuusyaknrno", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhrkstgktuuka = new ExDBFieldString<>("zrnhrkstgktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnmokuhyoukngktuuka = new ExDBFieldString<>("zrnmokuhyoukngktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsonotaseisankin = new ExDBFieldNumber<>("zrnsonotaseisankin", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnyenkansansaiyousign = new ExDBFieldString<>("zrnyenkansansaiyousign", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrnkykjiyoteitmttriritu = new ExDBFieldString<>("zrnkykjiyoteitmttriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhukusuutuukaflg = new ExDBFieldString<>("zrnhukusuutuukaflg", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnyenkansanhunoflg = new ExDBFieldString<>("zrnyenkansanhunoflg", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrntyusyaku20 = new ExDBFieldString<>("zrntyusyaku20", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsyaatkioydrtencd = new ExDBFieldString<>("zrnskeibsyaatkioydrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsybatkioydrtencd = new ExDBFieldString<>("zrnskeibsybatkioydrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsyaatkidrtencd = new ExDBFieldString<>("zrnskeibsyaatkidrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsybatkidrtencd = new ExDBFieldString<>("zrnskeibsybatkidrtencd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsyaatkibosyuucd = new ExDBFieldString<>("zrnskeibsyaatkibosyuucd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnskeibsybatkibosyuucd = new ExDBFieldString<>("zrnskeibsybatkibosyuucd", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnitijibrpkyktuukagtmtzndk = new ExDBFieldNumber<>("zrnitijibrpkyktuukagtmtzndk", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrngoukeip2kyktuuka = new ExDBFieldNumber<>("zrngoukeip2kyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnzennoupkyktuuka = new ExDBFieldNumber<>("zrnzennoupkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrntmttkngkkyktuuka = new ExDBFieldNumber<>("zrntmttkngkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkaiyakuhrkyktuuka = new ExDBFieldNumber<>("zrnkaiyakuhrkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkishrkinruikeigkkyktuuka = new ExDBFieldNumber<>("zrnkishrkinruikeigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsjkkktyouseigkkyktuuka = new ExDBFieldNumber<>("zrnsjkkktyouseigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkaiyakukjgkkyktuuka = new ExDBFieldNumber<>("zrnkaiyakukjgkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsonekikyktuuka = new ExDBFieldNumber<>("zrnsonekikyktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnsonekicalchunouflgsmbc = new ExDBFieldString<>("zrnsonekicalchunouflgsmbc", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsonotaseisankinkyktuuka = new ExDBFieldNumber<>("zrnsonotaseisankinkyktuuka", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrntyusyakusmbc = new ExDBFieldString<>("zrntyusyakusmbc", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, BizNumber> zrngmeigyoubijigaikashrrate = new ExDBFieldString<>("zrngmeigyoubijigaikashrrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnkihrpruikeigkkyktuuka = new ExDBFieldNumber<>("zrnkihrpruikeigkkyktuuka", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrngoukeip2smtb = new ExDBFieldNumber<>("zrngoukeip2smtb", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnsonekismtb = new ExDBFieldNumber<>("zrnsonekismtb", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnsonekicalchunouflgsmtb = new ExDBFieldString<>("zrnsonekicalchunouflgsmtb", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_DairitenGtmtZndkRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_DairitenGtmtZndkRn, String> zrnyobiv56 = new ExDBFieldString<>("zrnyobiv56", this);
}
