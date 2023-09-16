package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 解約返戻金相当額Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KaiykHrSoutougakuTy extends AbstractExDBTable<ZT_KaiykHrSoutougakuTy> {

    public GenQZT_KaiykHrSoutougakuTy() {
        this("ZT_KaiykHrSoutougakuTy");
    }

    public GenQZT_KaiykHrSoutougakuTy(String pAlias) {
        super("ZT_KaiykHrSoutougakuTy", ZT_KaiykHrSoutougakuTy.class, pAlias);
    }

    public String ZT_KaiykHrSoutougakuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyyobiv12 = new ExDBFieldString<>("ztyyobiv12", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykeisankijyunym = new ExDBFieldString<>("ztykeisankijyunym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysyutkkbn = new ExDBFieldString<>("ztysyutkkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytenkanitijibaraikbn = new ExDBFieldString<>("ztytenkanitijibaraikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytyuutohukahyouji = new ExDBFieldString<>("ztytyuutohukahyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysuuriyouyobin6 = new ExDBFieldString<>("ztysuuriyouyobin6", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysotodasikousinkbn = new ExDBFieldString<>("ztysotodasikousinkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhokensyuruikigouyobi = new ExDBFieldString<>("ztyhokensyuruikigouyobi", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytokuyakugatakbn = new ExDBFieldString<>("ztytokuyakugatakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyharaizumientyoujiage = new ExDBFieldString<>("ztyharaizumientyoujiage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysiteimpbairitu = new ExDBFieldString<>("ztysiteimpbairitu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyseizonkyuuhukinshrmd = new ExDBFieldString<>("ztyseizonkyuuhukinshrmd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykeikanensuu = new ExDBFieldString<>("ztykeikanensuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykeikatukisuu = new ExDBFieldString<>("ztykeikatukisuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytnknhktgkujyarhyouji = new ExDBFieldString<>("ztytnknhktgkujyarhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytokuyakukbn = new ExDBFieldString<>("ztytokuyakukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytokuyakuno = new ExDBFieldString<>("ztytokuyakuno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyrecordno = new ExDBFieldString<>("ztyrecordno", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztymfkuriagekurisagekbn = new ExDBFieldString<>("ztymfkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztymfannaihuyouriyuukbn = new ExDBFieldString<>("ztymfannaihuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyhokenhoutekiyouhyouji = new ExDBFieldString<>("ztyhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysintokujyouhyouji = new ExDBFieldString<>("ztysintokujyouhyouji", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyyobiv15 = new ExDBFieldString<>("ztyyobiv15", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyerrtokuteikoumoku = new ExDBFieldString<>("ztyerrtokuteikoumoku", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztykaiyakuhr = new ExDBFieldNumber<>("ztykaiyakuhr", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyryumsbbnkaiyakuhr = new ExDBFieldNumber<>("ztyryumsbbnkaiyakuhr", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztysaisinyoteiriritu = new ExDBFieldString<>("ztysaisinyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_KaiykHrSoutougakuTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_KaiykHrSoutougakuTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);
}
