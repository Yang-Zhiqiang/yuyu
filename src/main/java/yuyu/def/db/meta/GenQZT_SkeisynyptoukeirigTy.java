package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkeisynyptoukeirigTy extends AbstractExDBTable<ZT_SkeisynyptoukeirigTy> {

    public GenQZT_SkeisynyptoukeirigTy() {
        this("ZT_SkeisynyptoukeirigTy");
    }

    public GenQZT_SkeisynyptoukeirigTy(String pAlias) {
        super("ZT_SkeisynyptoukeirigTy", ZT_SkeisynyptoukeirigTy.class, pAlias);
    }

    public String ZT_SkeisynyptoukeirigTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyrendoukbn = new ExDBFieldString<>("ztyrendoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyuunoukeirokbn = new ExDBFieldString<>("ztysyuunoukeirokbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuitousisya = new ExDBFieldString<>("ztysuitousisya", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyuukinym = new ExDBFieldString<>("ztysyuukinym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyjyuutouym = new ExDBFieldString<>("ztyjyuutouym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyjyuutoukaisuu = new ExDBFieldString<>("ztyjyuutoukaisuu", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyzennoukbn = new ExDBFieldString<>("ztyzennoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysetkykkbn = new ExDBFieldString<>("ztysetkykkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztybankikkatuhyouji = new ExDBFieldString<>("ztybankikkatuhyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytnknmnosjtikbbnjyutukbn = new ExDBFieldString<>("ztytnknmnosjtikbbnjyutukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysetrenseimrtikatakbn = new ExDBFieldString<>("ztysetrenseimrtikatakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyukeiyakupwaribikikbnx2 = new ExDBFieldString<>("ztysyukeiyakupwaribikikbnx2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysykyktnknyugukbnx2 = new ExDBFieldString<>("ztysykyktnknyugukbnx2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysetkaigomaruteikatakbn = new ExDBFieldString<>("ztysetkaigomaruteikatakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysyonendosyokaip = new ExDBFieldNumber<>("ztysyonendosyokaip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysyonendo2kaimeikoup = new ExDBFieldNumber<>("ztysyonendo2kaimeikoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyjinendoikoup = new ExDBFieldNumber<>("ztyjinendoikoup", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhosyouikkatumnoshyouji = new ExDBFieldString<>("ztyhosyouikkatumnoshyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyhngknksaiteihosyukngk = new ExDBFieldNumber<>("ztyhngknksaiteihosyukngk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyuunoukbn = new ExDBFieldString<>("ztysyuunoukbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztytkykkumkhnsyukosuu = new ExDBFieldNumber<>("ztytkykkumkhnsyukosuu", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysiteizukiharaikomip = new ExDBFieldNumber<>("ztysiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysaisyuusiteimhrkp = new ExDBFieldNumber<>("ztysaisyuusiteimhrkp", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztysitihsyuriritu = new ExDBFieldString<>("ztysitihsyuriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztynkgnsritu = new ExDBFieldString<>("ztynkgnsritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysinnyuukinkbn = new ExDBFieldString<>("ztysinnyuukinkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydfnyuukinkbn = new ExDBFieldString<>("ztydfnyuukinkbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztytorikuzusip = new ExDBFieldNumber<>("ztytorikuzusip", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysykikykjkykym = new ExDBFieldString<>("ztysykikykjkykym", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztydfkijyunkingaku = new ExDBFieldNumber<>("ztydfkijyunkingaku", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyphireilkeisanyoup = new ExDBFieldNumber<>("ztyphireilkeisanyoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztycashlesshyj = new ExDBFieldString<>("ztycashlesshyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyjidoukousinhyouji = new ExDBFieldString<>("ztyjidoukousinhyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin10 = new ExDBFieldString<>("ztysuuriyouyobin10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin10x3 = new ExDBFieldString<>("ztysuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin10x4 = new ExDBFieldString<>("ztysuuriyouyobin10x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x6 = new ExDBFieldString<>("ztyyobiv10x6", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x7 = new ExDBFieldString<>("ztyyobiv10x7", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x8 = new ExDBFieldString<>("ztyyobiv10x8", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x9 = new ExDBFieldString<>("ztyyobiv10x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x10 = new ExDBFieldString<>("ztyyobiv10x10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x11 = new ExDBFieldString<>("ztyyobiv10x11", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysyukeiyakusyuruicdv3 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv3", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztynyknjikawaserate = new ExDBFieldString<>("ztynyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztynyknjikawaseratetkyuymd = new ExDBFieldString<>("ztynyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztysuuriyouyobin10x5 = new ExDBFieldString<>("ztysuuriyouyobin10x5", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv9x2 = new ExDBFieldString<>("ztyyobiv9x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv10x16 = new ExDBFieldString<>("ztyyobiv10x16", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztynkgns = new ExDBFieldNumber<>("ztynkgns", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztysisuubbntounyuugk = new ExDBFieldNumber<>("ztysisuubbntounyuugk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, BizNumber> ztysaisinyoteiriritu = new ExDBFieldString<>("ztysaisinyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Integer> ztyyobin5 = new ExDBFieldNumber<>("ztyyobin5", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztyzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("ztyzennoujiikkatubaraijytgk", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160 = new ExDBFieldString<>("ztytokuyakukoumokuv160", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x2 = new ExDBFieldString<>("ztytokuyakukoumokuv160x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x3 = new ExDBFieldString<>("ztytokuyakukoumokuv160x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x4 = new ExDBFieldString<>("ztytokuyakukoumokuv160x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x5 = new ExDBFieldString<>("ztytokuyakukoumokuv160x5", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x6 = new ExDBFieldString<>("ztytokuyakukoumokuv160x6", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x7 = new ExDBFieldString<>("ztytokuyakukoumokuv160x7", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x8 = new ExDBFieldString<>("ztytokuyakukoumokuv160x8", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x9 = new ExDBFieldString<>("ztytokuyakukoumokuv160x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x10 = new ExDBFieldString<>("ztytokuyakukoumokuv160x10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x11 = new ExDBFieldString<>("ztytokuyakukoumokuv160x11", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x12 = new ExDBFieldString<>("ztytokuyakukoumokuv160x12", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x13 = new ExDBFieldString<>("ztytokuyakukoumokuv160x13", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x14 = new ExDBFieldString<>("ztytokuyakukoumokuv160x14", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x15 = new ExDBFieldString<>("ztytokuyakukoumokuv160x15", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x16 = new ExDBFieldString<>("ztytokuyakukoumokuv160x16", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x17 = new ExDBFieldString<>("ztytokuyakukoumokuv160x17", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x18 = new ExDBFieldString<>("ztytokuyakukoumokuv160x18", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x19 = new ExDBFieldString<>("ztytokuyakukoumokuv160x19", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x20 = new ExDBFieldString<>("ztytokuyakukoumokuv160x20", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x21 = new ExDBFieldString<>("ztytokuyakukoumokuv160x21", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x22 = new ExDBFieldString<>("ztytokuyakukoumokuv160x22", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x23 = new ExDBFieldString<>("ztytokuyakukoumokuv160x23", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x24 = new ExDBFieldString<>("ztytokuyakukoumokuv160x24", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x25 = new ExDBFieldString<>("ztytokuyakukoumokuv160x25", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x26 = new ExDBFieldString<>("ztytokuyakukoumokuv160x26", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x27 = new ExDBFieldString<>("ztytokuyakukoumokuv160x27", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x28 = new ExDBFieldString<>("ztytokuyakukoumokuv160x28", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x29 = new ExDBFieldString<>("ztytokuyakukoumokuv160x29", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x30 = new ExDBFieldString<>("ztytokuyakukoumokuv160x30", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x31 = new ExDBFieldString<>("ztytokuyakukoumokuv160x31", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x32 = new ExDBFieldString<>("ztytokuyakukoumokuv160x32", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x33 = new ExDBFieldString<>("ztytokuyakukoumokuv160x33", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x34 = new ExDBFieldString<>("ztytokuyakukoumokuv160x34", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x35 = new ExDBFieldString<>("ztytokuyakukoumokuv160x35", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x36 = new ExDBFieldString<>("ztytokuyakukoumokuv160x36", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x37 = new ExDBFieldString<>("ztytokuyakukoumokuv160x37", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x38 = new ExDBFieldString<>("ztytokuyakukoumokuv160x38", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x39 = new ExDBFieldString<>("ztytokuyakukoumokuv160x39", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x40 = new ExDBFieldString<>("ztytokuyakukoumokuv160x40", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x41 = new ExDBFieldString<>("ztytokuyakukoumokuv160x41", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x42 = new ExDBFieldString<>("ztytokuyakukoumokuv160x42", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x43 = new ExDBFieldString<>("ztytokuyakukoumokuv160x43", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x44 = new ExDBFieldString<>("ztytokuyakukoumokuv160x44", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x45 = new ExDBFieldString<>("ztytokuyakukoumokuv160x45", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x46 = new ExDBFieldString<>("ztytokuyakukoumokuv160x46", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x47 = new ExDBFieldString<>("ztytokuyakukoumokuv160x47", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x48 = new ExDBFieldString<>("ztytokuyakukoumokuv160x48", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x49 = new ExDBFieldString<>("ztytokuyakukoumokuv160x49", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigTy, String> ztytokuyakukoumokuv160x50 = new ExDBFieldString<>("ztytokuyakukoumokuv160x50", this);
}
