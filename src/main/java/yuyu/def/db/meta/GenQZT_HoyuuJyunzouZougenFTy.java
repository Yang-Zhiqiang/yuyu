package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保有純増増減Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HoyuuJyunzouZougenFTy extends AbstractExDBTable<ZT_HoyuuJyunzouZougenFTy> {

    public GenQZT_HoyuuJyunzouZougenFTy() {
        this("ZT_HoyuuJyunzouZougenFTy");
    }

    public GenQZT_HoyuuJyunzouZougenFTy(String pAlias) {
        super("ZT_HoyuuJyunzouZougenFTy", ZT_HoyuuJyunzouZougenFTy.class, pAlias);
    }

    public String ZT_HoyuuJyunzouZougenFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytantoukojincd = new ExDBFieldString<>("ztytantoukojincd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytantousyasetteiym = new ExDBFieldString<>("ztytantousyasetteiym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykeijyousakikbn = new ExDBFieldString<>("ztykeijyousakikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykeijyousakisosiki = new ExDBFieldString<>("ztykeijyousakisosiki", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyutiwakekbn = new ExDBFieldString<>("ztyutiwakekbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytantoukeiyakukbn = new ExDBFieldString<>("ztytantoukeiyakukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysaisinbsyym = new ExDBFieldString<>("ztysaisinbsyym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymaruteisyuruikigou = new ExDBFieldString<>("ztymaruteisyuruikigou", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Integer> ztyyobin3 = new ExDBFieldNumber<>("ztyyobin3", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykykniyutksytioukbn = new ExDBFieldString<>("ztykykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyteisyuuhyj = new ExDBFieldString<>("ztyteisyuuhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyitijibryourouhyj = new ExDBFieldString<>("ztyitijibryourouhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymrtihukahyj = new ExDBFieldString<>("ztymrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyseizonmrtihukahyj = new ExDBFieldString<>("ztyseizonmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyteigenmrtihukahyj = new ExDBFieldString<>("ztyteigenmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysynymrtihukahyj = new ExDBFieldString<>("ztysynymrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyreguardmrtihukahyj = new ExDBFieldString<>("ztyreguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyreguardmrsyuhukahyj = new ExDBFieldString<>("ztyreguardmrsyuhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyvguardmrtihukahyj = new ExDBFieldString<>("ztyvguardmrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykaigonktkykhukahyj = new ExDBFieldString<>("ztykaigonktkykhukahyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztygoukeisisttkyktkknsnp = new ExDBFieldNumber<>("ztygoukeisisttkyktkknsnp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, BizNumber> ztykensuun3 = new ExDBFieldString<>("ztykensuun3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyhenkougohosyous = new ExDBFieldNumber<>("ztyhenkougohosyous", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyhtns = new ExDBFieldNumber<>("ztyhtns", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztykaiyakusiharaikngk = new ExDBFieldNumber<>("ztykaiyakusiharaikngk", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysikkounyknkaisuu = new ExDBFieldString<>("ztysikkounyknkaisuu", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysyorisosikicd = new ExDBFieldString<>("ztysyorisosikicd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytikusyokansisyakijyhyj = new ExDBFieldString<>("ztytikusyokansisyakijyhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykeizokutyuuihyouji = new ExDBFieldString<>("ztykeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytyohkkeiyakutyuuikbn = new ExDBFieldString<>("ztytyohkkeiyakutyuuikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztydantaisyozokucd = new ExDBFieldString<>("ztydantaisyozokucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysuperknkuseikatupackhyj = new ExDBFieldString<>("ztysuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyjikokykhyj = new ExDBFieldString<>("ztyjikokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykikeiyakutyuuihyouji = new ExDBFieldString<>("ztykikeiyakutyuuihyouji", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztysyuuseis = new ExDBFieldNumber<>("ztysyuuseis", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyclubsumiseikaiinkykkbn = new ExDBFieldString<>("ztyclubsumiseikaiinkykkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztygatkihmkknrkmaekykhyj = new ExDBFieldString<>("ztygatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztygatkisetteikouhokykhyj = new ExDBFieldString<>("ztygatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztybosyuu25keikahyj = new ExDBFieldString<>("ztybosyuu25keikahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytokuteidaisyokudanhyj = new ExDBFieldString<>("ztytokuteidaisyokudanhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhoyuuikantsgkykhyj = new ExDBFieldString<>("ztyhoyuuikantsgkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytokubeturuletikuhyj = new ExDBFieldString<>("ztytokubeturuletikuhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyfieldtantousyaarihyj = new ExDBFieldString<>("ztyfieldtantousyaarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x5 = new ExDBFieldString<>("ztyyobiv1x5", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztycatkihmkknrkmaekykhyj = new ExDBFieldString<>("ztycatkihmkknrkmaekykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztycatkisetteikouhokykhyj = new ExDBFieldString<>("ztycatkisetteikouhokykhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyseppankeijyoukbn = new ExDBFieldString<>("ztyseppankeijyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyfollowtantousyakbn = new ExDBFieldString<>("ztyfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyhosyouminaosikaisuuv2 = new ExDBFieldString<>("ztyhosyouminaosikaisuuv2", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytenkangosyono = new ExDBFieldString<>("ztytenkangosyono", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyqpackhyj = new ExDBFieldString<>("ztyqpackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytenkangoqpackhyj = new ExDBFieldString<>("ztytenkangoqpackhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysyuruihnkutkbttrtkhyj = new ExDBFieldString<>("ztysyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztytnkngsyuhnkutkbttrtkhyj = new ExDBFieldString<>("ztytnkngsyuhnkutkbttrtkhyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykibanhikitugikbn = new ExDBFieldString<>("ztykibanhikitugikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x6 = new ExDBFieldString<>("ztyyobiv1x6", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykaigomarusyuuhukahyj = new ExDBFieldString<>("ztykaigomarusyuuhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyyobiv1x7 = new ExDBFieldString<>("ztyyobiv1x7", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysyoritorikesihyj = new ExDBFieldString<>("ztysyoritorikesihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymrtikousinkatakbn = new ExDBFieldString<>("ztymrtikousinkatakbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztypmenkbnv1 = new ExDBFieldString<>("ztypmenkbnv1", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztysyukeiyakutkknsnp = new ExDBFieldNumber<>("ztysyukeiyakutkknsnp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztydai3bunyanenkansanp = new ExDBFieldNumber<>("ztydai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztynyuuintkykhukahyj = new ExDBFieldString<>("ztynyuuintkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztynyuuintkykhukahyj20ijyou = new ExDBFieldString<>("ztynyuuintkykhukahyj20ijyou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztynyuuintkykhukahyj5ijyou = new ExDBFieldString<>("ztynyuuintkykhukahyj5ijyou", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymarusyotkykhukahyj = new ExDBFieldString<>("ztymarusyotkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymarujyuutkykhukahyj = new ExDBFieldString<>("ztymarujyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykakudaimaruitkykhukahyj = new ExDBFieldString<>("ztykakudaimaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykakunyuutkykhukahyj = new ExDBFieldString<>("ztykakunyuutkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztymaruitkykhukahyj = new ExDBFieldString<>("ztymaruitkykhukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykensuuyuuguukbn = new ExDBFieldString<>("ztykensuuyuuguukbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykaigosynyteikikbn = new ExDBFieldString<>("ztykaigosynyteikikbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykaigosynyteikishrkskbn = new ExDBFieldString<>("ztykaigosynyteikishrkskbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztygyousekibosyujisikakucd = new ExDBFieldString<>("ztygyousekibosyujisikakucd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztygyskboshtnsineiyksnkbn = new ExDBFieldString<>("ztygyskboshtnsineiyksnkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysiktsynymrtihukahyj = new ExDBFieldString<>("ztysiktsynymrtihukahyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysiktsynyteikikbn = new ExDBFieldString<>("ztysiktsynyteikikbn", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztyseikatusyuunyuumrtis = new ExDBFieldNumber<>("ztyseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztylivguardhukahyj = new ExDBFieldString<>("ztylivguardhukahyj", this);

    public final ExDBFieldNumber<ZT_HoyuuJyunzouZougenFTy, Long> ztylivguards = new ExDBFieldNumber<>("ztylivguards", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztybluekzjtkaisiymd = new ExDBFieldString<>("ztybluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztyknkuzusnzyrtstkbn = new ExDBFieldString<>("ztyknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztykzktourokuservicearihyj = new ExDBFieldString<>("ztykzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_HoyuuJyunzouZougenFTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);
}
