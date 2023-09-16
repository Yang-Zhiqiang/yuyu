package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GkknHnkuSyrSynypTukiTy extends AbstractExDBTable<ZT_GkknHnkuSyrSynypTukiTy> {

    public GenQZT_GkknHnkuSyrSynypTukiTy() {
        this("ZT_GkknHnkuSyrSynypTukiTy");
    }

    public GenQZT_GkknHnkuSyrSynypTukiTy(String pAlias) {
        super("ZT_GkknHnkuSyrSynypTukiTy", ZT_GkknHnkuSyrSynypTukiTy.class, pAlias);
    }

    public String ZT_GkknHnkuSyrSynypTukiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyrendoukbn = new ExDBFieldString<>("ztyrendoukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyuunoukeirokbn = new ExDBFieldString<>("ztysyuunoukeirokbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuitousisya = new ExDBFieldString<>("ztysuitousisya", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyuukinym = new ExDBFieldString<>("ztysyuukinym", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyjyuutouym = new ExDBFieldString<>("ztyjyuutouym", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyjyuutoukaisuu = new ExDBFieldString<>("ztyjyuutoukaisuu", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyzennoukbn = new ExDBFieldString<>("ztyzennoukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysetkykkbn = new ExDBFieldString<>("ztysetkykkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztybankikkatuhyouji = new ExDBFieldString<>("ztybankikkatuhyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytnknmnosjtikbbnjyutukbn = new ExDBFieldString<>("ztytnknmnosjtikbbnjyutukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysetrenseimrtikatakbn = new ExDBFieldString<>("ztysetrenseimrtikatakbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyukeiyakupwaribikikbnx2 = new ExDBFieldString<>("ztysyukeiyakupwaribikikbnx2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysykyktnknyugukbnx2 = new ExDBFieldString<>("ztysykyktnknyugukbnx2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysetkaigomaruteikatakbn = new ExDBFieldString<>("ztysetkaigomaruteikatakbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysyonendosyokaip = new ExDBFieldNumber<>("ztysyonendosyokaip", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysyonendo2kaimeikoup = new ExDBFieldNumber<>("ztysyonendo2kaimeikoup", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyjinendoikoup = new ExDBFieldNumber<>("ztyjinendoikoup", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhosyouikkatumnoshyouji = new ExDBFieldString<>("ztyhosyouikkatumnoshyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyhngknksaiteihosyukngk = new ExDBFieldNumber<>("ztyhngknksaiteihosyukngk", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyuunoukbn = new ExDBFieldString<>("ztysyuunoukbn", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztytkykkumkhnsyukosuu = new ExDBFieldNumber<>("ztytkykkumkhnsyukosuu", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysiteizukiharaikomip = new ExDBFieldNumber<>("ztysiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysaisyuusiteimhrkp = new ExDBFieldNumber<>("ztysaisyuusiteimhrkp", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztysitihsyuriritu = new ExDBFieldString<>("ztysitihsyuriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztynkgnsritu = new ExDBFieldString<>("ztynkgnsritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysinnyuukinkbn = new ExDBFieldString<>("ztysinnyuukinkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydfnyuukinkbn = new ExDBFieldString<>("ztydfnyuukinkbn", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztytorikuzusip = new ExDBFieldNumber<>("ztytorikuzusip", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysykikykjkykym = new ExDBFieldString<>("ztysykikykjkykym", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztydfkijyunkingaku = new ExDBFieldNumber<>("ztydfkijyunkingaku", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyphireilkeisanyoup = new ExDBFieldNumber<>("ztyphireilkeisanyoup", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztycashlesshyj = new ExDBFieldString<>("ztycashlesshyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyjidoukousinhyouji = new ExDBFieldString<>("ztyjidoukousinhyouji", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin10 = new ExDBFieldString<>("ztysuuriyouyobin10", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin10x3 = new ExDBFieldString<>("ztysuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin10x4 = new ExDBFieldString<>("ztysuuriyouyobin10x4", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x6 = new ExDBFieldString<>("ztyyobiv10x6", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x7 = new ExDBFieldString<>("ztyyobiv10x7", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x8 = new ExDBFieldString<>("ztyyobiv10x8", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x9 = new ExDBFieldString<>("ztyyobiv10x9", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x10 = new ExDBFieldString<>("ztyyobiv10x10", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x11 = new ExDBFieldString<>("ztyyobiv10x11", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysyukeiyakusyuruicdv3 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv3", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztynyknjikawaserate = new ExDBFieldString<>("ztynyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztynyknjikawaseratetkyuymd = new ExDBFieldString<>("ztynyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztysuuriyouyobin10x5 = new ExDBFieldString<>("ztysuuriyouyobin10x5", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv9x2 = new ExDBFieldString<>("ztyyobiv9x2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv10x16 = new ExDBFieldString<>("ztyyobiv10x16", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztynkgns = new ExDBFieldNumber<>("ztynkgns", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztysisuubbntounyuugk = new ExDBFieldNumber<>("ztysisuubbntounyuugk", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, BizNumber> ztysaisinyoteiriritu = new ExDBFieldString<>("ztysaisinyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Integer> ztyyobin5 = new ExDBFieldNumber<>("ztyyobin5", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztyzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("ztyzennoujiikkatubaraijytgk", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_GkknHnkuSyrSynypTukiTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160 = new ExDBFieldString<>("ztytokuyakukoumokuv160", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x2 = new ExDBFieldString<>("ztytokuyakukoumokuv160x2", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x3 = new ExDBFieldString<>("ztytokuyakukoumokuv160x3", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x4 = new ExDBFieldString<>("ztytokuyakukoumokuv160x4", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x5 = new ExDBFieldString<>("ztytokuyakukoumokuv160x5", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x6 = new ExDBFieldString<>("ztytokuyakukoumokuv160x6", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x7 = new ExDBFieldString<>("ztytokuyakukoumokuv160x7", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x8 = new ExDBFieldString<>("ztytokuyakukoumokuv160x8", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x9 = new ExDBFieldString<>("ztytokuyakukoumokuv160x9", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x10 = new ExDBFieldString<>("ztytokuyakukoumokuv160x10", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x11 = new ExDBFieldString<>("ztytokuyakukoumokuv160x11", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x12 = new ExDBFieldString<>("ztytokuyakukoumokuv160x12", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x13 = new ExDBFieldString<>("ztytokuyakukoumokuv160x13", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x14 = new ExDBFieldString<>("ztytokuyakukoumokuv160x14", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x15 = new ExDBFieldString<>("ztytokuyakukoumokuv160x15", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x16 = new ExDBFieldString<>("ztytokuyakukoumokuv160x16", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x17 = new ExDBFieldString<>("ztytokuyakukoumokuv160x17", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x18 = new ExDBFieldString<>("ztytokuyakukoumokuv160x18", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x19 = new ExDBFieldString<>("ztytokuyakukoumokuv160x19", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x20 = new ExDBFieldString<>("ztytokuyakukoumokuv160x20", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x21 = new ExDBFieldString<>("ztytokuyakukoumokuv160x21", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x22 = new ExDBFieldString<>("ztytokuyakukoumokuv160x22", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x23 = new ExDBFieldString<>("ztytokuyakukoumokuv160x23", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x24 = new ExDBFieldString<>("ztytokuyakukoumokuv160x24", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x25 = new ExDBFieldString<>("ztytokuyakukoumokuv160x25", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x26 = new ExDBFieldString<>("ztytokuyakukoumokuv160x26", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x27 = new ExDBFieldString<>("ztytokuyakukoumokuv160x27", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x28 = new ExDBFieldString<>("ztytokuyakukoumokuv160x28", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x29 = new ExDBFieldString<>("ztytokuyakukoumokuv160x29", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x30 = new ExDBFieldString<>("ztytokuyakukoumokuv160x30", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x31 = new ExDBFieldString<>("ztytokuyakukoumokuv160x31", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x32 = new ExDBFieldString<>("ztytokuyakukoumokuv160x32", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x33 = new ExDBFieldString<>("ztytokuyakukoumokuv160x33", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x34 = new ExDBFieldString<>("ztytokuyakukoumokuv160x34", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x35 = new ExDBFieldString<>("ztytokuyakukoumokuv160x35", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x36 = new ExDBFieldString<>("ztytokuyakukoumokuv160x36", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x37 = new ExDBFieldString<>("ztytokuyakukoumokuv160x37", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x38 = new ExDBFieldString<>("ztytokuyakukoumokuv160x38", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x39 = new ExDBFieldString<>("ztytokuyakukoumokuv160x39", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x40 = new ExDBFieldString<>("ztytokuyakukoumokuv160x40", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x41 = new ExDBFieldString<>("ztytokuyakukoumokuv160x41", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x42 = new ExDBFieldString<>("ztytokuyakukoumokuv160x42", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x43 = new ExDBFieldString<>("ztytokuyakukoumokuv160x43", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x44 = new ExDBFieldString<>("ztytokuyakukoumokuv160x44", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x45 = new ExDBFieldString<>("ztytokuyakukoumokuv160x45", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x46 = new ExDBFieldString<>("ztytokuyakukoumokuv160x46", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x47 = new ExDBFieldString<>("ztytokuyakukoumokuv160x47", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x48 = new ExDBFieldString<>("ztytokuyakukoumokuv160x48", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x49 = new ExDBFieldString<>("ztytokuyakukoumokuv160x49", this);

    public final ExDBFieldString<ZT_GkknHnkuSyrSynypTukiTy, String> ztytokuyakukoumokuv160x50 = new ExDBFieldString<>("ztytokuyakukoumokuv160x50", this);
}
