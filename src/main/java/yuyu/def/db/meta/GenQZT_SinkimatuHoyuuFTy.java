package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新期末保有Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SinkimatuHoyuuFTy extends AbstractExDBTable<ZT_SinkimatuHoyuuFTy> {

    public GenQZT_SinkimatuHoyuuFTy() {
        this("ZT_SinkimatuHoyuuFTy");
    }

    public GenQZT_SinkimatuHoyuuFTy(String pAlias) {
        super("ZT_SinkimatuHoyuuFTy", ZT_SinkimatuHoyuuFTy.class, pAlias);
    }

    public String ZT_SinkimatuHoyuuFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytantoukojincd = new ExDBFieldString<>("ztytantoukojincd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytantousyasetteiym = new ExDBFieldString<>("ztytantousyasetteiym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykeijyousakikbn = new ExDBFieldString<>("ztykeijyousakikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykeijyousakisosiki = new ExDBFieldString<>("ztykeijyousakisosiki", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyutiwakekbn = new ExDBFieldString<>("ztyutiwakekbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytantoukeiyakukbn = new ExDBFieldString<>("ztytantoukeiyakukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysaisinbsyym = new ExDBFieldString<>("ztysaisinbsyym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymaruteisyuruikigou = new ExDBFieldString<>("ztymaruteisyuruikigou", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Integer> ztyyobin3 = new ExDBFieldNumber<>("ztyyobin3", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykykniyutksytioukbn = new ExDBFieldString<>("ztykykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyteisyuuhyj = new ExDBFieldString<>("ztyteisyuuhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyitijibryourouhyj = new ExDBFieldString<>("ztyitijibryourouhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymrtihukahyj = new ExDBFieldString<>("ztymrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyseizonmrtihukahyj = new ExDBFieldString<>("ztyseizonmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyteigenmrtihukahyj = new ExDBFieldString<>("ztyteigenmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysynymrtihukahyj = new ExDBFieldString<>("ztysynymrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyreguardmrtihukahyj = new ExDBFieldString<>("ztyreguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyreguardmrsyuhukahyj = new ExDBFieldString<>("ztyreguardmrsyuhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyvguardmrtihukahyj = new ExDBFieldString<>("ztyvguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykaigonktkykhukahyj = new ExDBFieldString<>("ztykaigonktkykhukahyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztygoukeisisttkyktkknsnp = new ExDBFieldNumber<>("ztygoukeisisttkyktkknsnp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, BizNumber> ztykensuun3 = new ExDBFieldString<>("ztykensuun3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyhenkougohosyous = new ExDBFieldNumber<>("ztyhenkougohosyous", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyhtns = new ExDBFieldNumber<>("ztyhtns", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztykaiyakusiharaikngk = new ExDBFieldNumber<>("ztykaiyakusiharaikngk", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysikkounyknkaisuu = new ExDBFieldString<>("ztysikkounyknkaisuu", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysyorisosikicd = new ExDBFieldString<>("ztysyorisosikicd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytikusyokansisyakijyhyj = new ExDBFieldString<>("ztytikusyokansisyakijyhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykeizokutyuuihyouji = new ExDBFieldString<>("ztykeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytyohkkeiyakutyuuikbn = new ExDBFieldString<>("ztytyohkkeiyakutyuuikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztydantaisyozokucd = new ExDBFieldString<>("ztydantaisyozokucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysuperknkuseikatupackhyj = new ExDBFieldString<>("ztysuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyjikokykhyj = new ExDBFieldString<>("ztyjikokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykikeiyakutyuuihyouji = new ExDBFieldString<>("ztykikeiyakutyuuihyouji", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztysyuuseis = new ExDBFieldNumber<>("ztysyuuseis", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyclubsumiseikaiinkykkbn = new ExDBFieldString<>("ztyclubsumiseikaiinkykkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztygatkihmkknrkmaekykhyj = new ExDBFieldString<>("ztygatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztygatkisetteikouhokykhyj = new ExDBFieldString<>("ztygatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztybosyuu25keikahyj = new ExDBFieldString<>("ztybosyuu25keikahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytokuteidaisyokudanhyj = new ExDBFieldString<>("ztytokuteidaisyokudanhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhoyuuikantsgkykhyj = new ExDBFieldString<>("ztyhoyuuikantsgkykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytokubeturuletikuhyj = new ExDBFieldString<>("ztytokubeturuletikuhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyfieldtantousyaarihyj = new ExDBFieldString<>("ztyfieldtantousyaarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x5 = new ExDBFieldString<>("ztyyobiv1x5", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztycatkihmkknrkmaekykhyj = new ExDBFieldString<>("ztycatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztycatkisetteikouhokykhyj = new ExDBFieldString<>("ztycatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyseppankeijyoukbn = new ExDBFieldString<>("ztyseppankeijyoukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyfollowtantousyakbn = new ExDBFieldString<>("ztyfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyhosyouminaosikaisuuv2 = new ExDBFieldString<>("ztyhosyouminaosikaisuuv2", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytenkangosyono = new ExDBFieldString<>("ztytenkangosyono", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyqpackhyj = new ExDBFieldString<>("ztyqpackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytenkangoqpackhyj = new ExDBFieldString<>("ztytenkangoqpackhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysyuruihnkutkbttrtkhyj = new ExDBFieldString<>("ztysyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztytnkngsyuhnkutkbttrtkhyj = new ExDBFieldString<>("ztytnkngsyuhnkutkbttrtkhyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykibanhikitugikbn = new ExDBFieldString<>("ztykibanhikitugikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x6 = new ExDBFieldString<>("ztyyobiv1x6", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykaigomarusyuuhukahyj = new ExDBFieldString<>("ztykaigomarusyuuhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyyobiv1x7 = new ExDBFieldString<>("ztyyobiv1x7", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysyoritorikesihyj = new ExDBFieldString<>("ztysyoritorikesihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymrtikousinkatakbn = new ExDBFieldString<>("ztymrtikousinkatakbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztypmenkbnv1 = new ExDBFieldString<>("ztypmenkbnv1", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztysyukeiyakutkknsnp = new ExDBFieldNumber<>("ztysyukeiyakutkknsnp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztydai3bunyanenkansanp = new ExDBFieldNumber<>("ztydai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztynyuuintkykhukahyj = new ExDBFieldString<>("ztynyuuintkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztynyuuintkykhukahyj20ijyou = new ExDBFieldString<>("ztynyuuintkykhukahyj20ijyou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztynyuuintkykhukahyj5ijyou = new ExDBFieldString<>("ztynyuuintkykhukahyj5ijyou", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymarusyotkykhukahyj = new ExDBFieldString<>("ztymarusyotkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymarujyuutkykhukahyj = new ExDBFieldString<>("ztymarujyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykakudaimaruitkykhukahyj = new ExDBFieldString<>("ztykakudaimaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykakunyuutkykhukahyj = new ExDBFieldString<>("ztykakunyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztymaruitkykhukahyj = new ExDBFieldString<>("ztymaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykensuuyuuguukbn = new ExDBFieldString<>("ztykensuuyuuguukbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykaigosynyteikikbn = new ExDBFieldString<>("ztykaigosynyteikikbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykaigosynyteikishrkskbn = new ExDBFieldString<>("ztykaigosynyteikishrkskbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztygyousekibosyujisikakucd = new ExDBFieldString<>("ztygyousekibosyujisikakucd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztygyskboshtnsineiyksnkbn = new ExDBFieldString<>("ztygyskboshtnsineiyksnkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysiktsynymrtihukahyj = new ExDBFieldString<>("ztysiktsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysiktsynyteikikbn = new ExDBFieldString<>("ztysiktsynyteikikbn", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztyseikatusyuunyuumrtis = new ExDBFieldNumber<>("ztyseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztylivguardhukahyj = new ExDBFieldString<>("ztylivguardhukahyj", this);

    public final ExDBFieldNumber<ZT_SinkimatuHoyuuFTy, Long> ztylivguards = new ExDBFieldNumber<>("ztylivguards", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztybluekzjtkaisiymd = new ExDBFieldString<>("ztybluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztyknkuzusnzyrtstkbn = new ExDBFieldString<>("ztyknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztykzktourokuservicearihyj = new ExDBFieldString<>("ztykzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_SinkimatuHoyuuFTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);
}
