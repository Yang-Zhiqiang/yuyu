package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TjHitsyyugkNplusZeroRn extends AbstractExDBTable<ZT_TjHitsyyugkNplusZeroRn> {

    public GenQZT_TjHitsyyugkNplusZeroRn() {
        this("ZT_TjHitsyyugkNplusZeroRn");
    }

    public GenQZT_TjHitsyyugkNplusZeroRn(String pAlias) {
        super("ZT_TjHitsyyugkNplusZeroRn", ZT_TjHitsyyugkNplusZeroRn.class, pAlias);
    }

    public String ZT_TjHitsyyugkNplusZeroRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnerrkbnv2 = new ExDBFieldString<>("zrnerrkbnv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnratekbn = new ExDBFieldString<>("zrnratekbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkeisandnendo = new ExDBFieldString<>("zrnkeisandnendo", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnsyouinkbn = new ExDBFieldString<>("zrnsyouinkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnnaizouteikiyoteiriritu = new ExDBFieldString<>("zrnnaizouteikiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeigyousekihyoujis = new ExDBFieldNumber<>("zrngoukeigyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntnknitjbrsykykgyuskhyjs = new ExDBFieldNumber<>("zrntnknitjbrsykykgyuskhyjs", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnannaikigetu = new ExDBFieldString<>("zrnannaikigetu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnharaizumiymd = new ExDBFieldString<>("zrnharaizumiymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnharaizumis = new ExDBFieldNumber<>("zrnharaizumis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnentyous = new ExDBFieldNumber<>("zrnentyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnseizons = new ExDBFieldNumber<>("zrnseizons", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnpmens = new ExDBFieldNumber<>("zrnpmens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrndgoukei = new ExDBFieldNumber<>("zrndgoukei", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsrankbetuhisad = new ExDBFieldNumber<>("zrnsrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjsrankbetuhisad = new ExDBFieldNumber<>("zrnsyumtjsrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnbairitubetuhisad = new ExDBFieldNumber<>("zrnbairitubetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtikbairtbetuhisad = new ExDBFieldNumber<>("zrnsyumtjtikbairtbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihongoukeid = new ExDBFieldNumber<>("zrnsyukeiyakukihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihonsisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihonrisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihonramudad = new ExDBFieldNumber<>("zrnsyukeiyakukihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihonhisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihondtaisyous = new ExDBFieldNumber<>("zrnsyukeiyakukihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihondyouv = new ExDBFieldNumber<>("zrnsyukeiyakukihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakukihondkikens = new ExDBFieldNumber<>("zrnsyukeiyakukihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsykykkhnhisadtisyus = new ExDBFieldNumber<>("zrnsykykkhnhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikigoukeid = new ExDBFieldNumber<>("zrnsyukeiyakuteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikisisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikirisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikiramudad = new ExDBFieldNumber<>("zrnsyukeiyakuteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikihisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikidtaisyous = new ExDBFieldNumber<>("zrnsyukeiyakuteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikidyouv = new ExDBFieldNumber<>("zrnsyukeiyakuteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyukeiyakuteikidkikens = new ExDBFieldNumber<>("zrnsyukeiyakuteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsykyktikhisadtisyus = new ExDBFieldNumber<>("zrnsykyktikhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihongoukeid = new ExDBFieldNumber<>("zrntenkankihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihonsisad = new ExDBFieldNumber<>("zrntenkankihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihonrisad = new ExDBFieldNumber<>("zrntenkankihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihonramudad = new ExDBFieldNumber<>("zrntenkankihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihonhisad = new ExDBFieldNumber<>("zrntenkankihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihondtaisyous = new ExDBFieldNumber<>("zrntenkankihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihondyouv = new ExDBFieldNumber<>("zrntenkankihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihondkikens = new ExDBFieldNumber<>("zrntenkankihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkankihonhisadtaisyous = new ExDBFieldNumber<>("zrntenkankihonhisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikigoukeid = new ExDBFieldNumber<>("zrntenkanteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikisisad = new ExDBFieldNumber<>("zrntenkanteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikirisad = new ExDBFieldNumber<>("zrntenkanteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikiramudad = new ExDBFieldNumber<>("zrntenkanteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikihisad = new ExDBFieldNumber<>("zrntenkanteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikidtaisyous = new ExDBFieldNumber<>("zrntenkanteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikidyouv = new ExDBFieldNumber<>("zrntenkanteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikidkikens = new ExDBFieldNumber<>("zrntenkanteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanteikihisadtaisyous = new ExDBFieldNumber<>("zrntenkanteikihisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtyusiyutnkntikgukd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikgukd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtyusiyutnkntiksisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntiksisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtyusiyutnkntikrisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikrisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtyusiyutnkntikhisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikhisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtnkntikdtaisyous = new ExDBFieldNumber<>("zrnsyumtjtnkntikdtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtnkntikdyouv = new ExDBFieldNumber<>("zrnsyumtjtnkntikdyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnsyumtjtnkntikdkikens = new ExDBFieldNumber<>("zrnsyumtjtnkntikdkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendougoukeid = new ExDBFieldNumber<>("zrnhendougoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendousisad = new ExDBFieldNumber<>("zrnhendousisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendouhisad = new ExDBFieldNumber<>("zrnhendouhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendoudtaisyous = new ExDBFieldNumber<>("zrnhendoudtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendoudyouv = new ExDBFieldNumber<>("zrnhendoudyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhendoudkikens = new ExDBFieldNumber<>("zrnhendoudkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraigoukeid = new ExDBFieldNumber<>("zrnitibuitijibaraigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraisisad = new ExDBFieldNumber<>("zrnitibuitijibaraisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraihisad = new ExDBFieldNumber<>("zrnitibuitijibaraihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraidtaisyous = new ExDBFieldNumber<>("zrnitibuitijibaraidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraidyouv = new ExDBFieldNumber<>("zrnitibuitijibaraidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibuitijibaraidkikens = new ExDBFieldNumber<>("zrnitibuitijibaraidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibitjbrhisadtisyus = new ExDBFieldNumber<>("zrnitibitjbrhisadtisyus", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnszoukouryokukaisiymd = new ExDBFieldString<>("zrnszoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnszouhokensyuruikigou = new ExDBFieldString<>("zrnszouhokensyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnszoukikan = new ExDBFieldString<>("zrnszoukikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnszouhihokensyaage = new ExDBFieldString<>("zrnszouhihokensyaage", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukagoukeid = new ExDBFieldNumber<>("zrnzoukagoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukasisad = new ExDBFieldNumber<>("zrnzoukasisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukarisad = new ExDBFieldNumber<>("zrnzoukarisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukaramudad = new ExDBFieldNumber<>("zrnzoukaramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukahisad = new ExDBFieldNumber<>("zrnzoukahisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukadtaisyous = new ExDBFieldNumber<>("zrnzoukadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukadyouv = new ExDBFieldNumber<>("zrnzoukadyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnzoukadkikens = new ExDBFieldNumber<>("zrnzoukadkikens", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusasyuruikgu = new ExDBFieldString<>("zrnkakuteikakusasyuruikgu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkakuteikakusad = new ExDBFieldNumber<>("zrnkakuteikakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkakuteikakusas = new ExDBFieldNumber<>("zrnkakuteikakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkakuteikakusamanryoujid = new ExDBFieldNumber<>("zrnkakuteikakusamanryoujid", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusasyuruikigou = new ExDBFieldString<>("zrnnaizoumarusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizoumarusad = new ExDBFieldNumber<>("zrnnaizoumarusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizoumarusas = new ExDBFieldNumber<>("zrnnaizoumarusas", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusasyuruikigou = new ExDBFieldString<>("zrnnaizoukakusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizoukakusad = new ExDBFieldNumber<>("zrnnaizoukakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizoukakusas = new ExDBFieldNumber<>("zrnnaizoukakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubund = new ExDBFieldNumber<>("zrntenkanpbubund", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubunsisad = new ExDBFieldNumber<>("zrntenkanpbubunsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubunrisad = new ExDBFieldNumber<>("zrntenkanpbubunrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubunhisad = new ExDBFieldNumber<>("zrntenkanpbubunhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubundtaisyous = new ExDBFieldNumber<>("zrntenkanpbubundtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubundyouv = new ExDBFieldNumber<>("zrntenkanpbubundyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntenkanpbubundkikens = new ExDBFieldNumber<>("zrntenkanpbubundkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizougatateikimud = new ExDBFieldNumber<>("zrnnaizougatateikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnnaizougatanenkansanp = new ExDBFieldNumber<>("zrnnaizougatanenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnvhktgbbntnkntikmud = new ExDBFieldNumber<>("zrnvhktgbbntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnhikitugitenkanphireimud = new ExDBFieldNumber<>("zrnhikitugitenkanphireimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnitibitjbrgyuskhyjs = new ExDBFieldNumber<>("zrnitibitjbrgyuskhyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkariwariate4nenmae = new ExDBFieldNumber<>("zrnkariwariate4nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkariwariate3nenmae = new ExDBFieldNumber<>("zrnkariwariate3nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkariwariate2nenmae = new ExDBFieldNumber<>("zrnkariwariate2nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnkariwariate1nenmae = new ExDBFieldNumber<>("zrnkariwariate1nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngukisisntnkntikmud = new ExDBFieldNumber<>("zrngukisisntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeiseisanteikis = new ExDBFieldNumber<>("zrngoukeiseisanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngukisisntnknnenknsnp = new ExDBFieldNumber<>("zrngukisisntnknnenknsnp", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntnkntikhtnknkykymd = new ExDBFieldString<>("zrntnkntikhtnknkykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrntenkangophireimuritu = new ExDBFieldString<>("zrntenkangophireimuritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeitenkannenkansanp = new ExDBFieldNumber<>("zrngoukeitenkannenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrngoukeitenkanteikimud = new ExDBFieldNumber<>("zrngoukeitenkanteikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntyoukikeizokutokubetud = new ExDBFieldNumber<>("zrntyoukikeizokutokubetud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntyouseimaed = new ExDBFieldNumber<>("zrntyouseimaed", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrntuutokuhituusand = new ExDBFieldNumber<>("zrntuutokuhituusand", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnszoukigousedaikbn = new ExDBFieldString<>("zrnszoukigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnmankihyouji = new ExDBFieldString<>("zrnmankihyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigouyobix1 = new ExDBFieldString<>("zrntenkanteikikigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigouyobix2 = new ExDBFieldString<>("zrntenkanteikikigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigouyobix3 = new ExDBFieldString<>("zrntenkanteikikigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigouyobix4 = new ExDBFieldString<>("zrntenkanteikikigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntenkanteikikigouyobix5 = new ExDBFieldString<>("zrntenkanteikikigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakgusdkbn = new ExDBFieldString<>("zrnkakuteikakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakguybx1 = new ExDBFieldString<>("zrnkakuteikakusakguybx1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakguybx2 = new ExDBFieldString<>("zrnkakuteikakusakguybx2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakguybx3 = new ExDBFieldString<>("zrnkakuteikakusakguybx3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakguybx4 = new ExDBFieldString<>("zrnkakuteikakusakguybx4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkakuteikakusakguybx5 = new ExDBFieldString<>("zrnkakuteikakusakguybx5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakgusdkbn = new ExDBFieldString<>("zrnnaizoumarusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakigouyobix1 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakigouyobix2 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakigouyobix3 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakigouyobix4 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoumarusakigouyobix5 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakgusdkbn = new ExDBFieldString<>("zrnnaizoukakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakigouyobix1 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakigouyobix2 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakigouyobix3 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakigouyobix4 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnnaizoukakusakigouyobix5 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnyobiv92 = new ExDBFieldString<>("zrnyobiv92", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnsuuriyouyobin10 = new ExDBFieldString<>("zrnsuuriyouyobin10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnyobiv10x2 = new ExDBFieldString<>("zrnyobiv10x2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusZeroRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnsisadrate = new ExDBFieldString<>("zrnsisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnrisadrate = new ExDBFieldString<>("zrnrisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnhisadrate = new ExDBFieldString<>("zrnhisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrndyouvrate = new ExDBFieldString<>("zrndyouvrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrnkikensrate = new ExDBFieldString<>("zrnkikensrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, BizNumber> zrngoukeidrate = new ExDBFieldString<>("zrngoukeidrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180 = new ExDBFieldString<>("zrntokuyakukoumokuv180", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x2 = new ExDBFieldString<>("zrntokuyakukoumokuv180x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x3 = new ExDBFieldString<>("zrntokuyakukoumokuv180x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x4 = new ExDBFieldString<>("zrntokuyakukoumokuv180x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x5 = new ExDBFieldString<>("zrntokuyakukoumokuv180x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x6 = new ExDBFieldString<>("zrntokuyakukoumokuv180x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x7 = new ExDBFieldString<>("zrntokuyakukoumokuv180x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x8 = new ExDBFieldString<>("zrntokuyakukoumokuv180x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x9 = new ExDBFieldString<>("zrntokuyakukoumokuv180x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x10 = new ExDBFieldString<>("zrntokuyakukoumokuv180x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x11 = new ExDBFieldString<>("zrntokuyakukoumokuv180x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x12 = new ExDBFieldString<>("zrntokuyakukoumokuv180x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x13 = new ExDBFieldString<>("zrntokuyakukoumokuv180x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x14 = new ExDBFieldString<>("zrntokuyakukoumokuv180x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x15 = new ExDBFieldString<>("zrntokuyakukoumokuv180x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x16 = new ExDBFieldString<>("zrntokuyakukoumokuv180x16", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x17 = new ExDBFieldString<>("zrntokuyakukoumokuv180x17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x18 = new ExDBFieldString<>("zrntokuyakukoumokuv180x18", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x19 = new ExDBFieldString<>("zrntokuyakukoumokuv180x19", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x20 = new ExDBFieldString<>("zrntokuyakukoumokuv180x20", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x21 = new ExDBFieldString<>("zrntokuyakukoumokuv180x21", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x22 = new ExDBFieldString<>("zrntokuyakukoumokuv180x22", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x23 = new ExDBFieldString<>("zrntokuyakukoumokuv180x23", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x24 = new ExDBFieldString<>("zrntokuyakukoumokuv180x24", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x25 = new ExDBFieldString<>("zrntokuyakukoumokuv180x25", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x26 = new ExDBFieldString<>("zrntokuyakukoumokuv180x26", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x27 = new ExDBFieldString<>("zrntokuyakukoumokuv180x27", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x28 = new ExDBFieldString<>("zrntokuyakukoumokuv180x28", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x29 = new ExDBFieldString<>("zrntokuyakukoumokuv180x29", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x30 = new ExDBFieldString<>("zrntokuyakukoumokuv180x30", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x31 = new ExDBFieldString<>("zrntokuyakukoumokuv180x31", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x32 = new ExDBFieldString<>("zrntokuyakukoumokuv180x32", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x33 = new ExDBFieldString<>("zrntokuyakukoumokuv180x33", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x34 = new ExDBFieldString<>("zrntokuyakukoumokuv180x34", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x35 = new ExDBFieldString<>("zrntokuyakukoumokuv180x35", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x36 = new ExDBFieldString<>("zrntokuyakukoumokuv180x36", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x37 = new ExDBFieldString<>("zrntokuyakukoumokuv180x37", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x38 = new ExDBFieldString<>("zrntokuyakukoumokuv180x38", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x39 = new ExDBFieldString<>("zrntokuyakukoumokuv180x39", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x40 = new ExDBFieldString<>("zrntokuyakukoumokuv180x40", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x41 = new ExDBFieldString<>("zrntokuyakukoumokuv180x41", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x42 = new ExDBFieldString<>("zrntokuyakukoumokuv180x42", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x43 = new ExDBFieldString<>("zrntokuyakukoumokuv180x43", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x44 = new ExDBFieldString<>("zrntokuyakukoumokuv180x44", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x45 = new ExDBFieldString<>("zrntokuyakukoumokuv180x45", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x46 = new ExDBFieldString<>("zrntokuyakukoumokuv180x46", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x47 = new ExDBFieldString<>("zrntokuyakukoumokuv180x47", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x48 = new ExDBFieldString<>("zrntokuyakukoumokuv180x48", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x49 = new ExDBFieldString<>("zrntokuyakukoumokuv180x49", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusZeroRn, String> zrntokuyakukoumokuv180x50 = new ExDBFieldString<>("zrntokuyakukoumokuv180x50", this);
}
