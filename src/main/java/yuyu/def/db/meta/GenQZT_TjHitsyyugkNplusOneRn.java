package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 通常配当所要額Ｆ（Ｎ＋１）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TjHitsyyugkNplusOneRn extends AbstractExDBTable<ZT_TjHitsyyugkNplusOneRn> {

    public GenQZT_TjHitsyyugkNplusOneRn() {
        this("ZT_TjHitsyyugkNplusOneRn");
    }

    public GenQZT_TjHitsyyugkNplusOneRn(String pAlias) {
        super("ZT_TjHitsyyugkNplusOneRn", ZT_TjHitsyyugkNplusOneRn.class, pAlias);
    }

    public String ZT_TjHitsyyugkNplusOneRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnerrkbnv2 = new ExDBFieldString<>("zrnerrkbnv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnratekbn = new ExDBFieldString<>("zrnratekbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkeisandnendo = new ExDBFieldString<>("zrnkeisandnendo", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnsyouinkbn = new ExDBFieldString<>("zrnsyouinkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnnaizouteikiyoteiriritu = new ExDBFieldString<>("zrnnaizouteikiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeigyousekihyoujis = new ExDBFieldNumber<>("zrngoukeigyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntnknitjbrsykykgyuskhyjs = new ExDBFieldNumber<>("zrntnknitjbrsykykgyuskhyjs", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnannaikigetu = new ExDBFieldString<>("zrnannaikigetu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnharaizumiymd = new ExDBFieldString<>("zrnharaizumiymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnharaizumis = new ExDBFieldNumber<>("zrnharaizumis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnentyous = new ExDBFieldNumber<>("zrnentyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnseizons = new ExDBFieldNumber<>("zrnseizons", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnpmens = new ExDBFieldNumber<>("zrnpmens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrndgoukei = new ExDBFieldNumber<>("zrndgoukei", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsrankbetuhisad = new ExDBFieldNumber<>("zrnsrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjsrankbetuhisad = new ExDBFieldNumber<>("zrnsyumtjsrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnbairitubetuhisad = new ExDBFieldNumber<>("zrnbairitubetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtikbairtbetuhisad = new ExDBFieldNumber<>("zrnsyumtjtikbairtbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihongoukeid = new ExDBFieldNumber<>("zrnsyukeiyakukihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihonsisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihonrisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihonramudad = new ExDBFieldNumber<>("zrnsyukeiyakukihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihonhisad = new ExDBFieldNumber<>("zrnsyukeiyakukihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihondtaisyous = new ExDBFieldNumber<>("zrnsyukeiyakukihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihondyouv = new ExDBFieldNumber<>("zrnsyukeiyakukihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakukihondkikens = new ExDBFieldNumber<>("zrnsyukeiyakukihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsykykkhnhisadtisyus = new ExDBFieldNumber<>("zrnsykykkhnhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikigoukeid = new ExDBFieldNumber<>("zrnsyukeiyakuteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikisisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikirisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikiramudad = new ExDBFieldNumber<>("zrnsyukeiyakuteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikihisad = new ExDBFieldNumber<>("zrnsyukeiyakuteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikidtaisyous = new ExDBFieldNumber<>("zrnsyukeiyakuteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikidyouv = new ExDBFieldNumber<>("zrnsyukeiyakuteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyukeiyakuteikidkikens = new ExDBFieldNumber<>("zrnsyukeiyakuteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsykyktikhisadtisyus = new ExDBFieldNumber<>("zrnsykyktikhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihongoukeid = new ExDBFieldNumber<>("zrntenkankihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihonsisad = new ExDBFieldNumber<>("zrntenkankihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihonrisad = new ExDBFieldNumber<>("zrntenkankihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihonramudad = new ExDBFieldNumber<>("zrntenkankihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihonhisad = new ExDBFieldNumber<>("zrntenkankihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihondtaisyous = new ExDBFieldNumber<>("zrntenkankihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihondyouv = new ExDBFieldNumber<>("zrntenkankihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihondkikens = new ExDBFieldNumber<>("zrntenkankihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkankihonhisadtaisyous = new ExDBFieldNumber<>("zrntenkankihonhisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikigoukeid = new ExDBFieldNumber<>("zrntenkanteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikisisad = new ExDBFieldNumber<>("zrntenkanteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikirisad = new ExDBFieldNumber<>("zrntenkanteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikiramudad = new ExDBFieldNumber<>("zrntenkanteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikihisad = new ExDBFieldNumber<>("zrntenkanteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikidtaisyous = new ExDBFieldNumber<>("zrntenkanteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikidyouv = new ExDBFieldNumber<>("zrntenkanteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikidkikens = new ExDBFieldNumber<>("zrntenkanteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanteikihisadtaisyous = new ExDBFieldNumber<>("zrntenkanteikihisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtyusiyutnkntikgukd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikgukd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtyusiyutnkntiksisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntiksisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtyusiyutnkntikrisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikrisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtyusiyutnkntikhisd = new ExDBFieldNumber<>("zrnsyumtjtyusiyutnkntikhisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtnkntikdtaisyous = new ExDBFieldNumber<>("zrnsyumtjtnkntikdtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtnkntikdyouv = new ExDBFieldNumber<>("zrnsyumtjtnkntikdyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnsyumtjtnkntikdkikens = new ExDBFieldNumber<>("zrnsyumtjtnkntikdkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendougoukeid = new ExDBFieldNumber<>("zrnhendougoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendousisad = new ExDBFieldNumber<>("zrnhendousisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendouhisad = new ExDBFieldNumber<>("zrnhendouhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendoudtaisyous = new ExDBFieldNumber<>("zrnhendoudtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendoudyouv = new ExDBFieldNumber<>("zrnhendoudyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhendoudkikens = new ExDBFieldNumber<>("zrnhendoudkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraigoukeid = new ExDBFieldNumber<>("zrnitibuitijibaraigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraisisad = new ExDBFieldNumber<>("zrnitibuitijibaraisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraihisad = new ExDBFieldNumber<>("zrnitibuitijibaraihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraidtaisyous = new ExDBFieldNumber<>("zrnitibuitijibaraidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraidyouv = new ExDBFieldNumber<>("zrnitibuitijibaraidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibuitijibaraidkikens = new ExDBFieldNumber<>("zrnitibuitijibaraidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibitjbrhisadtisyus = new ExDBFieldNumber<>("zrnitibitjbrhisadtisyus", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnszoukouryokukaisiymd = new ExDBFieldString<>("zrnszoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnszouhokensyuruikigou = new ExDBFieldString<>("zrnszouhokensyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnszoukikan = new ExDBFieldString<>("zrnszoukikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnszouhihokensyaage = new ExDBFieldString<>("zrnszouhihokensyaage", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukagoukeid = new ExDBFieldNumber<>("zrnzoukagoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukasisad = new ExDBFieldNumber<>("zrnzoukasisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukarisad = new ExDBFieldNumber<>("zrnzoukarisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukaramudad = new ExDBFieldNumber<>("zrnzoukaramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukahisad = new ExDBFieldNumber<>("zrnzoukahisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukadtaisyous = new ExDBFieldNumber<>("zrnzoukadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukadyouv = new ExDBFieldNumber<>("zrnzoukadyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnzoukadkikens = new ExDBFieldNumber<>("zrnzoukadkikens", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusasyuruikgu = new ExDBFieldString<>("zrnkakuteikakusasyuruikgu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkakuteikakusad = new ExDBFieldNumber<>("zrnkakuteikakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkakuteikakusas = new ExDBFieldNumber<>("zrnkakuteikakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkakuteikakusamanryoujid = new ExDBFieldNumber<>("zrnkakuteikakusamanryoujid", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusasyuruikigou = new ExDBFieldString<>("zrnnaizoumarusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizoumarusad = new ExDBFieldNumber<>("zrnnaizoumarusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizoumarusas = new ExDBFieldNumber<>("zrnnaizoumarusas", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusasyuruikigou = new ExDBFieldString<>("zrnnaizoukakusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizoukakusad = new ExDBFieldNumber<>("zrnnaizoukakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizoukakusas = new ExDBFieldNumber<>("zrnnaizoukakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubund = new ExDBFieldNumber<>("zrntenkanpbubund", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubunsisad = new ExDBFieldNumber<>("zrntenkanpbubunsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubunrisad = new ExDBFieldNumber<>("zrntenkanpbubunrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubunhisad = new ExDBFieldNumber<>("zrntenkanpbubunhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubundtaisyous = new ExDBFieldNumber<>("zrntenkanpbubundtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubundyouv = new ExDBFieldNumber<>("zrntenkanpbubundyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntenkanpbubundkikens = new ExDBFieldNumber<>("zrntenkanpbubundkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizougatateikimud = new ExDBFieldNumber<>("zrnnaizougatateikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnnaizougatanenkansanp = new ExDBFieldNumber<>("zrnnaizougatanenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnvhktgbbntnkntikmud = new ExDBFieldNumber<>("zrnvhktgbbntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnhikitugitenkanphireimud = new ExDBFieldNumber<>("zrnhikitugitenkanphireimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnitibitjbrgyuskhyjs = new ExDBFieldNumber<>("zrnitibitjbrgyuskhyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkariwariate4nenmae = new ExDBFieldNumber<>("zrnkariwariate4nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkariwariate3nenmae = new ExDBFieldNumber<>("zrnkariwariate3nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkariwariate2nenmae = new ExDBFieldNumber<>("zrnkariwariate2nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnkariwariate1nenmae = new ExDBFieldNumber<>("zrnkariwariate1nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngukisisntnkntikmud = new ExDBFieldNumber<>("zrngukisisntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeiseisanteikis = new ExDBFieldNumber<>("zrngoukeiseisanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngukisisntnknnenknsnp = new ExDBFieldNumber<>("zrngukisisntnknnenknsnp", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntnkntikhtnknkykymd = new ExDBFieldString<>("zrntnkntikhtnknkykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrntenkangophireimuritu = new ExDBFieldString<>("zrntenkangophireimuritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeitenkannenkansanp = new ExDBFieldNumber<>("zrngoukeitenkannenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrngoukeitenkanteikimud = new ExDBFieldNumber<>("zrngoukeitenkanteikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntyoukikeizokutokubetud = new ExDBFieldNumber<>("zrntyoukikeizokutokubetud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntyouseimaed = new ExDBFieldNumber<>("zrntyouseimaed", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrntuutokuhituusand = new ExDBFieldNumber<>("zrntuutokuhituusand", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnszoukigousedaikbn = new ExDBFieldString<>("zrnszoukigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnmankihyouji = new ExDBFieldString<>("zrnmankihyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigouyobix1 = new ExDBFieldString<>("zrntenkanteikikigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigouyobix2 = new ExDBFieldString<>("zrntenkanteikikigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigouyobix3 = new ExDBFieldString<>("zrntenkanteikikigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigouyobix4 = new ExDBFieldString<>("zrntenkanteikikigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntenkanteikikigouyobix5 = new ExDBFieldString<>("zrntenkanteikikigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakgusdkbn = new ExDBFieldString<>("zrnkakuteikakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakguybx1 = new ExDBFieldString<>("zrnkakuteikakusakguybx1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakguybx2 = new ExDBFieldString<>("zrnkakuteikakusakguybx2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakguybx3 = new ExDBFieldString<>("zrnkakuteikakusakguybx3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakguybx4 = new ExDBFieldString<>("zrnkakuteikakusakguybx4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkakuteikakusakguybx5 = new ExDBFieldString<>("zrnkakuteikakusakguybx5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakgusdkbn = new ExDBFieldString<>("zrnnaizoumarusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakigouyobix1 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakigouyobix2 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakigouyobix3 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakigouyobix4 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoumarusakigouyobix5 = new ExDBFieldString<>("zrnnaizoumarusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakgusdkbn = new ExDBFieldString<>("zrnnaizoukakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakigouyobix1 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakigouyobix2 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakigouyobix3 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakigouyobix4 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnnaizoukakusakigouyobix5 = new ExDBFieldString<>("zrnnaizoukakusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnyobiv92 = new ExDBFieldString<>("zrnyobiv92", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnsuuriyouyobin10 = new ExDBFieldString<>("zrnsuuriyouyobin10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnyobiv10x2 = new ExDBFieldString<>("zrnyobiv10x2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusOneRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnsisadrate = new ExDBFieldString<>("zrnsisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnrisadrate = new ExDBFieldString<>("zrnrisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnhisadrate = new ExDBFieldString<>("zrnhisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrndyouvrate = new ExDBFieldString<>("zrndyouvrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrnkikensrate = new ExDBFieldString<>("zrnkikensrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, BizNumber> zrngoukeidrate = new ExDBFieldString<>("zrngoukeidrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180 = new ExDBFieldString<>("zrntokuyakukoumokuv180", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x2 = new ExDBFieldString<>("zrntokuyakukoumokuv180x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x3 = new ExDBFieldString<>("zrntokuyakukoumokuv180x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x4 = new ExDBFieldString<>("zrntokuyakukoumokuv180x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x5 = new ExDBFieldString<>("zrntokuyakukoumokuv180x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x6 = new ExDBFieldString<>("zrntokuyakukoumokuv180x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x7 = new ExDBFieldString<>("zrntokuyakukoumokuv180x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x8 = new ExDBFieldString<>("zrntokuyakukoumokuv180x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x9 = new ExDBFieldString<>("zrntokuyakukoumokuv180x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x10 = new ExDBFieldString<>("zrntokuyakukoumokuv180x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x11 = new ExDBFieldString<>("zrntokuyakukoumokuv180x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x12 = new ExDBFieldString<>("zrntokuyakukoumokuv180x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x13 = new ExDBFieldString<>("zrntokuyakukoumokuv180x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x14 = new ExDBFieldString<>("zrntokuyakukoumokuv180x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x15 = new ExDBFieldString<>("zrntokuyakukoumokuv180x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x16 = new ExDBFieldString<>("zrntokuyakukoumokuv180x16", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x17 = new ExDBFieldString<>("zrntokuyakukoumokuv180x17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x18 = new ExDBFieldString<>("zrntokuyakukoumokuv180x18", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x19 = new ExDBFieldString<>("zrntokuyakukoumokuv180x19", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x20 = new ExDBFieldString<>("zrntokuyakukoumokuv180x20", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x21 = new ExDBFieldString<>("zrntokuyakukoumokuv180x21", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x22 = new ExDBFieldString<>("zrntokuyakukoumokuv180x22", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x23 = new ExDBFieldString<>("zrntokuyakukoumokuv180x23", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x24 = new ExDBFieldString<>("zrntokuyakukoumokuv180x24", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x25 = new ExDBFieldString<>("zrntokuyakukoumokuv180x25", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x26 = new ExDBFieldString<>("zrntokuyakukoumokuv180x26", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x27 = new ExDBFieldString<>("zrntokuyakukoumokuv180x27", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x28 = new ExDBFieldString<>("zrntokuyakukoumokuv180x28", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x29 = new ExDBFieldString<>("zrntokuyakukoumokuv180x29", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x30 = new ExDBFieldString<>("zrntokuyakukoumokuv180x30", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x31 = new ExDBFieldString<>("zrntokuyakukoumokuv180x31", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x32 = new ExDBFieldString<>("zrntokuyakukoumokuv180x32", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x33 = new ExDBFieldString<>("zrntokuyakukoumokuv180x33", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x34 = new ExDBFieldString<>("zrntokuyakukoumokuv180x34", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x35 = new ExDBFieldString<>("zrntokuyakukoumokuv180x35", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x36 = new ExDBFieldString<>("zrntokuyakukoumokuv180x36", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x37 = new ExDBFieldString<>("zrntokuyakukoumokuv180x37", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x38 = new ExDBFieldString<>("zrntokuyakukoumokuv180x38", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x39 = new ExDBFieldString<>("zrntokuyakukoumokuv180x39", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x40 = new ExDBFieldString<>("zrntokuyakukoumokuv180x40", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x41 = new ExDBFieldString<>("zrntokuyakukoumokuv180x41", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x42 = new ExDBFieldString<>("zrntokuyakukoumokuv180x42", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x43 = new ExDBFieldString<>("zrntokuyakukoumokuv180x43", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x44 = new ExDBFieldString<>("zrntokuyakukoumokuv180x44", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x45 = new ExDBFieldString<>("zrntokuyakukoumokuv180x45", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x46 = new ExDBFieldString<>("zrntokuyakukoumokuv180x46", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x47 = new ExDBFieldString<>("zrntokuyakukoumokuv180x47", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x48 = new ExDBFieldString<>("zrntokuyakukoumokuv180x48", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x49 = new ExDBFieldString<>("zrntokuyakukoumokuv180x49", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusOneRn, String> zrntokuyakukoumokuv180x50 = new ExDBFieldString<>("zrntokuyakukoumokuv180x50", this);
}
