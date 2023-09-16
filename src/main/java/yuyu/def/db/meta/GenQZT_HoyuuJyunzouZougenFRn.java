package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保有純増増減Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HoyuuJyunzouZougenFRn extends AbstractExDBTable<ZT_HoyuuJyunzouZougenFRn> {

    public GenQZT_HoyuuJyunzouZougenFRn() {
        this("ZT_HoyuuJyunzouZougenFRn");
    }

    public GenQZT_HoyuuJyunzouZougenFRn(String pAlias) {
        super("ZT_HoyuuJyunzouZougenFRn", ZT_HoyuuJyunzouZougenFRn.class, pAlias);
    }

    public String ZT_HoyuuJyunzouZougenFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntantoukojincd = new ExDBFieldString<>("zrntantoukojincd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntantousyasetteiym = new ExDBFieldString<>("zrntantousyasetteiym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkeijyousakikbn = new ExDBFieldString<>("zrnkeijyousakikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkeijyousakisosiki = new ExDBFieldString<>("zrnkeijyousakisosiki", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnutiwakekbn = new ExDBFieldString<>("zrnutiwakekbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntantoukeiyakukbn = new ExDBFieldString<>("zrntantoukeiyakukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsaisinbsyym = new ExDBFieldString<>("zrnsaisinbsyym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmaruteisyuruikigou = new ExDBFieldString<>("zrnmaruteisyuruikigou", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Integer> zrnyobin3 = new ExDBFieldNumber<>("zrnyobin3", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkykniyutksytioukbn = new ExDBFieldString<>("zrnkykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnteisyuuhyj = new ExDBFieldString<>("zrnteisyuuhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnitijibryourouhyj = new ExDBFieldString<>("zrnitijibryourouhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmrtihukahyj = new ExDBFieldString<>("zrnmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnseizonmrtihukahyj = new ExDBFieldString<>("zrnseizonmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnteigenmrtihukahyj = new ExDBFieldString<>("zrnteigenmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsynymrtihukahyj = new ExDBFieldString<>("zrnsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnreguardmrtihukahyj = new ExDBFieldString<>("zrnreguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnreguardmrsyuhukahyj = new ExDBFieldString<>("zrnreguardmrsyuhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnvguardmrtihukahyj = new ExDBFieldString<>("zrnvguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkaigonktkykhukahyj = new ExDBFieldString<>("zrnkaigonktkykhukahyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrngoukeisisttkyktkknsnp = new ExDBFieldNumber<>("zrngoukeisisttkyktkknsnp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, BizNumber> zrnkensuun3 = new ExDBFieldString<>("zrnkensuun3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnhenkougohosyous = new ExDBFieldNumber<>("zrnhenkougohosyous", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnhtns = new ExDBFieldNumber<>("zrnhtns", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnkaiyakusiharaikngk = new ExDBFieldNumber<>("zrnkaiyakusiharaikngk", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsikkounyknkaisuu = new ExDBFieldString<>("zrnsikkounyknkaisuu", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsyorisosikicd = new ExDBFieldString<>("zrnsyorisosikicd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntikusyokansisyakijyhyj = new ExDBFieldString<>("zrntikusyokansisyakijyhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkeizokutyuuihyouji = new ExDBFieldString<>("zrnkeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntyohkkeiyakutyuuikbn = new ExDBFieldString<>("zrntyohkkeiyakutyuuikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x4 = new ExDBFieldString<>("zrnyobiv1x4", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrndantaisyozokucd = new ExDBFieldString<>("zrndantaisyozokucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsuperknkuseikatupackhyj = new ExDBFieldString<>("zrnsuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnjikokykhyj = new ExDBFieldString<>("zrnjikokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkikeiyakutyuuihyouji = new ExDBFieldString<>("zrnkikeiyakutyuuihyouji", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnsyuuseis = new ExDBFieldNumber<>("zrnsyuuseis", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnclubsumiseikaiinkykkbn = new ExDBFieldString<>("zrnclubsumiseikaiinkykkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrngatkihmkknrkmaekykhyj = new ExDBFieldString<>("zrngatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrngatkisetteikouhokykhyj = new ExDBFieldString<>("zrngatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnbosyuu25keikahyj = new ExDBFieldString<>("zrnbosyuu25keikahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntokuteidaisyokudanhyj = new ExDBFieldString<>("zrntokuteidaisyokudanhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhoyuuikantsgkykhyj = new ExDBFieldString<>("zrnhoyuuikantsgkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntokubeturuletikuhyj = new ExDBFieldString<>("zrntokubeturuletikuhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnfieldtantousyaarihyj = new ExDBFieldString<>("zrnfieldtantousyaarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x5 = new ExDBFieldString<>("zrnyobiv1x5", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrncatkihmkknrkmaekykhyj = new ExDBFieldString<>("zrncatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrncatkisetteikouhokykhyj = new ExDBFieldString<>("zrncatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnseppankeijyoukbn = new ExDBFieldString<>("zrnseppankeijyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnfollowtantousyakbn = new ExDBFieldString<>("zrnfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnhosyouminaosikaisuuv2 = new ExDBFieldString<>("zrnhosyouminaosikaisuuv2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntenkangosyono = new ExDBFieldString<>("zrntenkangosyono", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnqpackhyj = new ExDBFieldString<>("zrnqpackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntenkangoqpackhyj = new ExDBFieldString<>("zrntenkangoqpackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsyuruihnkutkbttrtkhyj = new ExDBFieldString<>("zrnsyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrntnkngsyuhnkutkbttrtkhyj = new ExDBFieldString<>("zrntnkngsyuhnkutkbttrtkhyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkibanhikitugikbn = new ExDBFieldString<>("zrnkibanhikitugikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x6 = new ExDBFieldString<>("zrnyobiv1x6", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkaigomarusyuuhukahyj = new ExDBFieldString<>("zrnkaigomarusyuuhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnyobiv1x7 = new ExDBFieldString<>("zrnyobiv1x7", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsyoritorikesihyj = new ExDBFieldString<>("zrnsyoritorikesihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmrtikousinkatakbn = new ExDBFieldString<>("zrnmrtikousinkatakbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnpmenkbnv1 = new ExDBFieldString<>("zrnpmenkbnv1", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnsyukeiyakutkknsnp = new ExDBFieldNumber<>("zrnsyukeiyakutkknsnp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrndai3bunyanenkansanp = new ExDBFieldNumber<>("zrndai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnnyuuintkykhukahyj = new ExDBFieldString<>("zrnnyuuintkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnnyuuintkykhukahyj20ijyou = new ExDBFieldString<>("zrnnyuuintkykhukahyj20ijyou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnnyuuintkykhukahyj5ijyou = new ExDBFieldString<>("zrnnyuuintkykhukahyj5ijyou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmarusyotkykhukahyj = new ExDBFieldString<>("zrnmarusyotkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmarujyuutkykhukahyj = new ExDBFieldString<>("zrnmarujyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkakudaimaruitkykhukahyj = new ExDBFieldString<>("zrnkakudaimaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkakunyuutkykhukahyj = new ExDBFieldString<>("zrnkakunyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnmaruitkykhukahyj = new ExDBFieldString<>("zrnmaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkensuuyuuguukbn = new ExDBFieldString<>("zrnkensuuyuuguukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkaigosynyteikikbn = new ExDBFieldString<>("zrnkaigosynyteikikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkaigosynyteikishrkskbn = new ExDBFieldString<>("zrnkaigosynyteikishrkskbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrngyousekibosyujisikakucd = new ExDBFieldString<>("zrngyousekibosyujisikakucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrngyskboshtnsineiyksnkbn = new ExDBFieldString<>("zrngyskboshtnsineiyksnkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsiktsynymrtihukahyj = new ExDBFieldString<>("zrnsiktsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsiktsynyteikikbn = new ExDBFieldString<>("zrnsiktsynyteikikbn", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnseikatusyuunyuumrtis = new ExDBFieldNumber<>("zrnseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnlivguardhukahyj = new ExDBFieldString<>("zrnlivguardhukahyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFRn, Long> zrnlivguards = new ExDBFieldNumber<>("zrnlivguards", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnbluekzjtkaisiymd = new ExDBFieldString<>("zrnbluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnknkuzusnzyrtstkbn = new ExDBFieldString<>("zrnknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnkzktourokuservicearihyj = new ExDBFieldString<>("zrnkzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);
}
