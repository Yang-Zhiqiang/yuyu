package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新期末保有Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SinkimatuHoyuuFRn extends AbstractExDBTable<ZT_SinkimatuHoyuuFRn> {

    public GenQZT_SinkimatuHoyuuFRn() {
        this("ZT_SinkimatuHoyuuFRn");
    }

    public GenQZT_SinkimatuHoyuuFRn(String pAlias) {
        super("ZT_SinkimatuHoyuuFRn", ZT_SinkimatuHoyuuFRn.class, pAlias);
    }

    public String ZT_SinkimatuHoyuuFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntantoukojincd = new ExDBFieldString<>("zrntantoukojincd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntantousyasetteiym = new ExDBFieldString<>("zrntantousyasetteiym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkeijyousakikbn = new ExDBFieldString<>("zrnkeijyousakikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkeijyousakisosiki = new ExDBFieldString<>("zrnkeijyousakisosiki", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnutiwakekbn = new ExDBFieldString<>("zrnutiwakekbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntantoukeiyakukbn = new ExDBFieldString<>("zrntantoukeiyakukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsaisinbsyym = new ExDBFieldString<>("zrnsaisinbsyym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmaruteisyuruikigou = new ExDBFieldString<>("zrnmaruteisyuruikigou", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Integer> zrnyobin3 = new ExDBFieldNumber<>("zrnyobin3", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkykniyutksytioukbn = new ExDBFieldString<>("zrnkykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnteisyuuhyj = new ExDBFieldString<>("zrnteisyuuhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnitijibryourouhyj = new ExDBFieldString<>("zrnitijibryourouhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmrtihukahyj = new ExDBFieldString<>("zrnmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnseizonmrtihukahyj = new ExDBFieldString<>("zrnseizonmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnteigenmrtihukahyj = new ExDBFieldString<>("zrnteigenmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsynymrtihukahyj = new ExDBFieldString<>("zrnsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnreguardmrtihukahyj = new ExDBFieldString<>("zrnreguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnreguardmrsyuhukahyj = new ExDBFieldString<>("zrnreguardmrsyuhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnvguardmrtihukahyj = new ExDBFieldString<>("zrnvguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkaigonktkykhukahyj = new ExDBFieldString<>("zrnkaigonktkykhukahyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrngoukeisisttkyktkknsnp = new ExDBFieldNumber<>("zrngoukeisisttkyktkknsnp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, BizNumber> zrnkensuun3 = new ExDBFieldString<>("zrnkensuun3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnhenkougohosyous = new ExDBFieldNumber<>("zrnhenkougohosyous", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnhtns = new ExDBFieldNumber<>("zrnhtns", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnkaiyakusiharaikngk = new ExDBFieldNumber<>("zrnkaiyakusiharaikngk", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsikkounyknkaisuu = new ExDBFieldString<>("zrnsikkounyknkaisuu", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsyorisosikicd = new ExDBFieldString<>("zrnsyorisosikicd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntikusyokansisyakijyhyj = new ExDBFieldString<>("zrntikusyokansisyakijyhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkeizokutyuuihyouji = new ExDBFieldString<>("zrnkeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntyohkkeiyakutyuuikbn = new ExDBFieldString<>("zrntyohkkeiyakutyuuikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x4 = new ExDBFieldString<>("zrnyobiv1x4", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrndantaisyozokucd = new ExDBFieldString<>("zrndantaisyozokucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsuperknkuseikatupackhyj = new ExDBFieldString<>("zrnsuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnjikokykhyj = new ExDBFieldString<>("zrnjikokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkikeiyakutyuuihyouji = new ExDBFieldString<>("zrnkikeiyakutyuuihyouji", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnsyuuseis = new ExDBFieldNumber<>("zrnsyuuseis", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnclubsumiseikaiinkykkbn = new ExDBFieldString<>("zrnclubsumiseikaiinkykkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrngatkihmkknrkmaekykhyj = new ExDBFieldString<>("zrngatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrngatkisetteikouhokykhyj = new ExDBFieldString<>("zrngatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnbosyuu25keikahyj = new ExDBFieldString<>("zrnbosyuu25keikahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntokuteidaisyokudanhyj = new ExDBFieldString<>("zrntokuteidaisyokudanhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhoyuuikantsgkykhyj = new ExDBFieldString<>("zrnhoyuuikantsgkykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntokubeturuletikuhyj = new ExDBFieldString<>("zrntokubeturuletikuhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnfieldtantousyaarihyj = new ExDBFieldString<>("zrnfieldtantousyaarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x5 = new ExDBFieldString<>("zrnyobiv1x5", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrncatkihmkknrkmaekykhyj = new ExDBFieldString<>("zrncatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrncatkisetteikouhokykhyj = new ExDBFieldString<>("zrncatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnseppankeijyoukbn = new ExDBFieldString<>("zrnseppankeijyoukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnfollowtantousyakbn = new ExDBFieldString<>("zrnfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnhosyouminaosikaisuuv2 = new ExDBFieldString<>("zrnhosyouminaosikaisuuv2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntenkangosyono = new ExDBFieldString<>("zrntenkangosyono", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnqpackhyj = new ExDBFieldString<>("zrnqpackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntenkangoqpackhyj = new ExDBFieldString<>("zrntenkangoqpackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsyuruihnkutkbttrtkhyj = new ExDBFieldString<>("zrnsyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrntnkngsyuhnkutkbttrtkhyj = new ExDBFieldString<>("zrntnkngsyuhnkutkbttrtkhyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkibanhikitugikbn = new ExDBFieldString<>("zrnkibanhikitugikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x6 = new ExDBFieldString<>("zrnyobiv1x6", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkaigomarusyuuhukahyj = new ExDBFieldString<>("zrnkaigomarusyuuhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnyobiv1x7 = new ExDBFieldString<>("zrnyobiv1x7", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsyoritorikesihyj = new ExDBFieldString<>("zrnsyoritorikesihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmrtikousinkatakbn = new ExDBFieldString<>("zrnmrtikousinkatakbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnpmenkbnv1 = new ExDBFieldString<>("zrnpmenkbnv1", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnsyukeiyakutkknsnp = new ExDBFieldNumber<>("zrnsyukeiyakutkknsnp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrndai3bunyanenkansanp = new ExDBFieldNumber<>("zrndai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnnyuuintkykhukahyj = new ExDBFieldString<>("zrnnyuuintkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnnyuuintkykhukahyj20ijyou = new ExDBFieldString<>("zrnnyuuintkykhukahyj20ijyou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnnyuuintkykhukahyj5ijyou = new ExDBFieldString<>("zrnnyuuintkykhukahyj5ijyou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmarusyotkykhukahyj = new ExDBFieldString<>("zrnmarusyotkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmarujyuutkykhukahyj = new ExDBFieldString<>("zrnmarujyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkakudaimaruitkykhukahyj = new ExDBFieldString<>("zrnkakudaimaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkakunyuutkykhukahyj = new ExDBFieldString<>("zrnkakunyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnmaruitkykhukahyj = new ExDBFieldString<>("zrnmaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkensuuyuuguukbn = new ExDBFieldString<>("zrnkensuuyuuguukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkaigosynyteikikbn = new ExDBFieldString<>("zrnkaigosynyteikikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkaigosynyteikishrkskbn = new ExDBFieldString<>("zrnkaigosynyteikishrkskbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrngyousekibosyujisikakucd = new ExDBFieldString<>("zrngyousekibosyujisikakucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrngyskboshtnsineiyksnkbn = new ExDBFieldString<>("zrngyskboshtnsineiyksnkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsiktsynymrtihukahyj = new ExDBFieldString<>("zrnsiktsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsiktsynyteikikbn = new ExDBFieldString<>("zrnsiktsynyteikikbn", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnseikatusyuunyuumrtis = new ExDBFieldNumber<>("zrnseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnlivguardhukahyj = new ExDBFieldString<>("zrnlivguardhukahyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFRn, Long> zrnlivguards = new ExDBFieldNumber<>("zrnlivguards", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnbluekzjtkaisiymd = new ExDBFieldString<>("zrnbluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnknkuzusnzyrtstkbn = new ExDBFieldString<>("zrnknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnkzktourokuservicearihyj = new ExDBFieldString<>("zrnkzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);
}
