package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 解約返戻金相当額Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KaiykHrSoutougakuRn extends AbstractExDBTable<ZT_KaiykHrSoutougakuRn> {

    public GenQZT_KaiykHrSoutougakuRn() {
        this("ZT_KaiykHrSoutougakuRn");
    }

    public GenQZT_KaiykHrSoutougakuRn(String pAlias) {
        super("ZT_KaiykHrSoutougakuRn", ZT_KaiykHrSoutougakuRn.class, pAlias);
    }

    public String ZT_KaiykHrSoutougakuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkeisankijyunym = new ExDBFieldString<>("zrnkeisankijyunym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsyutkkbn = new ExDBFieldString<>("zrnsyutkkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntenkanitijibaraikbn = new ExDBFieldString<>("zrntenkanitijibaraikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntyuutohukahyouji = new ExDBFieldString<>("zrntyuutohukahyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsuuriyouyobin6 = new ExDBFieldString<>("zrnsuuriyouyobin6", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsotodasikousinkbn = new ExDBFieldString<>("zrnsotodasikousinkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhokensyuruikigouyobi = new ExDBFieldString<>("zrnhokensyuruikigouyobi", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntokuyakugatakbn = new ExDBFieldString<>("zrntokuyakugatakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnharaizumientyoujiage = new ExDBFieldString<>("zrnharaizumientyoujiage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnentyoukikan = new ExDBFieldString<>("zrnentyoukikan", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsiteimpbairitu = new ExDBFieldString<>("zrnsiteimpbairitu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnseizonkyuuhukinshrmd = new ExDBFieldString<>("zrnseizonkyuuhukinshrmd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkeikanensuu = new ExDBFieldString<>("zrnkeikanensuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkeikatukisuu = new ExDBFieldString<>("zrnkeikatukisuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntnknhktgkujyarhyouji = new ExDBFieldString<>("zrntnknhktgkujyarhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntokuyakukbn = new ExDBFieldString<>("zrntokuyakukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntokuyakuno = new ExDBFieldString<>("zrntokuyakuno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrndi2hknkknikoujihisyaage = new ExDBFieldString<>("zrndi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnrecordno = new ExDBFieldString<>("zrnrecordno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnmfkuriagekurisagekbn = new ExDBFieldString<>("zrnmfkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnmfannaihuyouriyuukbn = new ExDBFieldString<>("zrnmfannaihuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhrizmjhknsyukigousdkbn = new ExDBFieldString<>("zrnhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnhokenhoutekiyouhyouji = new ExDBFieldString<>("zrnhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsintokujyouhyouji = new ExDBFieldString<>("zrnsintokujyouhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnytirrthndsysnmnskaisuu = new ExDBFieldString<>("zrnytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkrsgjhknsyukigousdkbn = new ExDBFieldString<>("zrnkrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnyobiv15 = new ExDBFieldString<>("zrnyobiv15", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnerrtokuteikoumoku = new ExDBFieldString<>("zrnerrtokuteikoumoku", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnhenkougokihons = new ExDBFieldNumber<>("zrnhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnhenkougosibous = new ExDBFieldNumber<>("zrnhenkougosibous", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrngyousekihyoujis = new ExDBFieldNumber<>("zrngyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnwnasigoukeitenkanteikis = new ExDBFieldNumber<>("zrnwnasigoukeitenkanteikis", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnkaiyakuhr = new ExDBFieldNumber<>("zrnkaiyakuhr", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnryumsbbnkaiyakuhr = new ExDBFieldNumber<>("zrnryumsbbnkaiyakuhr", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnsaisinyoteiriritu = new ExDBFieldString<>("zrnsaisinyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnmvakeisankijyunymd = new ExDBFieldString<>("zrnmvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);
}
