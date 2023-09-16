package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkeisynyptoukeirigRn extends AbstractExDBTable<ZT_SkeisynyptoukeirigRn> {

    public GenQZT_SkeisynyptoukeirigRn() {
        this("ZT_SkeisynyptoukeirigRn");
    }

    public GenQZT_SkeisynyptoukeirigRn(String pAlias) {
        super("ZT_SkeisynyptoukeirigRn", ZT_SkeisynyptoukeirigRn.class, pAlias);
    }

    public String ZT_SkeisynyptoukeirigRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnrendoukbn = new ExDBFieldString<>("zrnrendoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyuunoukeirokbn = new ExDBFieldString<>("zrnsyuunoukeirokbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuitousisya = new ExDBFieldString<>("zrnsuitousisya", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyuukinym = new ExDBFieldString<>("zrnsyuukinym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnjyuutouym = new ExDBFieldString<>("zrnjyuutouym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnjyuutoukaisuu = new ExDBFieldString<>("zrnjyuutoukaisuu", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnzennoukbn = new ExDBFieldString<>("zrnzennoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsetkykkbn = new ExDBFieldString<>("zrnsetkykkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnbankikkatuhyouji = new ExDBFieldString<>("zrnbankikkatuhyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntnknmnosjtikbbnjyutukbn = new ExDBFieldString<>("zrntnknmnosjtikbbnjyutukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsetrenseimrtikatakbn = new ExDBFieldString<>("zrnsetrenseimrtikatakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyukeiyakupwaribikikbnx2 = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbnx2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsykyktnknyugukbnx2 = new ExDBFieldString<>("zrnsykyktnknyugukbnx2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsetkaigomaruteikatakbn = new ExDBFieldString<>("zrnsetkaigomaruteikatakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsyonendosyokaip = new ExDBFieldNumber<>("zrnsyonendosyokaip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsyonendo2kaimeikoup = new ExDBFieldNumber<>("zrnsyonendo2kaimeikoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnjinendoikoup = new ExDBFieldNumber<>("zrnjinendoikoup", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhosyouikkatumnoshyouji = new ExDBFieldString<>("zrnhosyouikkatumnoshyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnhngknksaiteihosyukngk = new ExDBFieldNumber<>("zrnhngknksaiteihosyukngk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyuunoukbn = new ExDBFieldString<>("zrnsyuunoukbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrntkykkumkhnsyukosuu = new ExDBFieldNumber<>("zrntkykkumkhnsyukosuu", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsiteizukiharaikomip = new ExDBFieldNumber<>("zrnsiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsaisyuusiteimhrkp = new ExDBFieldNumber<>("zrnsaisyuusiteimhrkp", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnsitihsyuriritu = new ExDBFieldString<>("zrnsitihsyuriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnnkgnsritu = new ExDBFieldString<>("zrnnkgnsritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsinnyuukinkbn = new ExDBFieldString<>("zrnsinnyuukinkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndfnyuukinkbn = new ExDBFieldString<>("zrndfnyuukinkbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrntorikuzusip = new ExDBFieldNumber<>("zrntorikuzusip", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkbnkeiriyousegmentcd = new ExDBFieldString<>("zrnkbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsykikykjkykym = new ExDBFieldString<>("zrnsykikykjkykym", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrndfkijyunkingaku = new ExDBFieldNumber<>("zrndfkijyunkingaku", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntenkanjiknkuzusnzyrt = new ExDBFieldString<>("zrntenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin7 = new ExDBFieldString<>("zrnsuuriyouyobin7", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnphireilkeisanyoup = new ExDBFieldNumber<>("zrnphireilkeisanyoup", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrncashlesshyj = new ExDBFieldString<>("zrncashlesshyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkyksyaagetyouseihyj = new ExDBFieldString<>("zrnkyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsykykhokenhoutekiyouhyj = new ExDBFieldString<>("zrnsykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("zrnhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnjidoukousinhyouji = new ExDBFieldString<>("zrnjidoukousinhyouji", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin1 = new ExDBFieldString<>("zrnsuuriyouyobin1", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin10 = new ExDBFieldString<>("zrnsuuriyouyobin10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin10x3 = new ExDBFieldString<>("zrnsuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin10x4 = new ExDBFieldString<>("zrnsuuriyouyobin10x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x6 = new ExDBFieldString<>("zrnyobiv10x6", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x7 = new ExDBFieldString<>("zrnyobiv10x7", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x8 = new ExDBFieldString<>("zrnyobiv10x8", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x9 = new ExDBFieldString<>("zrnyobiv10x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x10 = new ExDBFieldString<>("zrnyobiv10x10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x11 = new ExDBFieldString<>("zrnyobiv10x11", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhrimngtkykphrkkirkbn = new ExDBFieldString<>("zrnhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnhrimngtkykpryurtkbn = new ExDBFieldString<>("zrnhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsyukeiyakusyuruicdv3 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv3", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnnyknjikawaserate = new ExDBFieldString<>("zrnnyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnnyknjikawaseratetkyuymd = new ExDBFieldString<>("zrnnyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnsuuriyouyobin10x5 = new ExDBFieldString<>("zrnsuuriyouyobin10x5", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv9x2 = new ExDBFieldString<>("zrnyobiv9x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv10x16 = new ExDBFieldString<>("zrnyobiv10x16", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnnkgns = new ExDBFieldNumber<>("zrnnkgns", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnsisuubbntounyuugk = new ExDBFieldNumber<>("zrnsisuubbntounyuugk", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, BizNumber> zrnsaisinyoteiriritu = new ExDBFieldString<>("zrnsaisinyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Integer> zrnyobin5 = new ExDBFieldNumber<>("zrnyobin5", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrnzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("zrnzennoujiikkatubaraijytgk", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_SkeisynyptoukeirigRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160 = new ExDBFieldString<>("zrntokuyakukoumokuv160", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x2 = new ExDBFieldString<>("zrntokuyakukoumokuv160x2", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x3 = new ExDBFieldString<>("zrntokuyakukoumokuv160x3", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x4 = new ExDBFieldString<>("zrntokuyakukoumokuv160x4", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x5 = new ExDBFieldString<>("zrntokuyakukoumokuv160x5", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x6 = new ExDBFieldString<>("zrntokuyakukoumokuv160x6", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x7 = new ExDBFieldString<>("zrntokuyakukoumokuv160x7", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x8 = new ExDBFieldString<>("zrntokuyakukoumokuv160x8", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x9 = new ExDBFieldString<>("zrntokuyakukoumokuv160x9", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x10 = new ExDBFieldString<>("zrntokuyakukoumokuv160x10", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x11 = new ExDBFieldString<>("zrntokuyakukoumokuv160x11", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x12 = new ExDBFieldString<>("zrntokuyakukoumokuv160x12", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x13 = new ExDBFieldString<>("zrntokuyakukoumokuv160x13", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x14 = new ExDBFieldString<>("zrntokuyakukoumokuv160x14", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x15 = new ExDBFieldString<>("zrntokuyakukoumokuv160x15", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x16 = new ExDBFieldString<>("zrntokuyakukoumokuv160x16", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x17 = new ExDBFieldString<>("zrntokuyakukoumokuv160x17", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x18 = new ExDBFieldString<>("zrntokuyakukoumokuv160x18", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x19 = new ExDBFieldString<>("zrntokuyakukoumokuv160x19", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x20 = new ExDBFieldString<>("zrntokuyakukoumokuv160x20", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x21 = new ExDBFieldString<>("zrntokuyakukoumokuv160x21", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x22 = new ExDBFieldString<>("zrntokuyakukoumokuv160x22", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x23 = new ExDBFieldString<>("zrntokuyakukoumokuv160x23", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x24 = new ExDBFieldString<>("zrntokuyakukoumokuv160x24", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x25 = new ExDBFieldString<>("zrntokuyakukoumokuv160x25", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x26 = new ExDBFieldString<>("zrntokuyakukoumokuv160x26", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x27 = new ExDBFieldString<>("zrntokuyakukoumokuv160x27", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x28 = new ExDBFieldString<>("zrntokuyakukoumokuv160x28", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x29 = new ExDBFieldString<>("zrntokuyakukoumokuv160x29", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x30 = new ExDBFieldString<>("zrntokuyakukoumokuv160x30", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x31 = new ExDBFieldString<>("zrntokuyakukoumokuv160x31", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x32 = new ExDBFieldString<>("zrntokuyakukoumokuv160x32", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x33 = new ExDBFieldString<>("zrntokuyakukoumokuv160x33", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x34 = new ExDBFieldString<>("zrntokuyakukoumokuv160x34", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x35 = new ExDBFieldString<>("zrntokuyakukoumokuv160x35", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x36 = new ExDBFieldString<>("zrntokuyakukoumokuv160x36", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x37 = new ExDBFieldString<>("zrntokuyakukoumokuv160x37", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x38 = new ExDBFieldString<>("zrntokuyakukoumokuv160x38", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x39 = new ExDBFieldString<>("zrntokuyakukoumokuv160x39", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x40 = new ExDBFieldString<>("zrntokuyakukoumokuv160x40", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x41 = new ExDBFieldString<>("zrntokuyakukoumokuv160x41", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x42 = new ExDBFieldString<>("zrntokuyakukoumokuv160x42", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x43 = new ExDBFieldString<>("zrntokuyakukoumokuv160x43", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x44 = new ExDBFieldString<>("zrntokuyakukoumokuv160x44", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x45 = new ExDBFieldString<>("zrntokuyakukoumokuv160x45", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x46 = new ExDBFieldString<>("zrntokuyakukoumokuv160x46", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x47 = new ExDBFieldString<>("zrntokuyakukoumokuv160x47", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x48 = new ExDBFieldString<>("zrntokuyakukoumokuv160x48", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x49 = new ExDBFieldString<>("zrntokuyakukoumokuv160x49", this);

    public final ExDBFieldString<ZT_SkeisynyptoukeirigRn, String> zrntokuyakukoumokuv160x50 = new ExDBFieldString<>("zrntokuyakukoumokuv160x50", this);
}
