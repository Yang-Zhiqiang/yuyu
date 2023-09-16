package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TjHitsyyugkNplusQuartTy extends AbstractExDBTable<ZT_TjHitsyyugkNplusQuartTy> {

    public GenQZT_TjHitsyyugkNplusQuartTy() {
        this("ZT_TjHitsyyugkNplusQuartTy");
    }

    public GenQZT_TjHitsyyugkNplusQuartTy(String pAlias) {
        super("ZT_TjHitsyyugkNplusQuartTy", ZT_TjHitsyyugkNplusQuartTy.class, pAlias);
    }

    public String ZT_TjHitsyyugkNplusQuartTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyerrkbnv2 = new ExDBFieldString<>("ztyerrkbnv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyratekbn = new ExDBFieldString<>("ztyratekbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykeisandnendo = new ExDBFieldString<>("ztykeisandnendo", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztysyouinkbn = new ExDBFieldString<>("ztysyouinkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztynaizouteikiyoteiriritu = new ExDBFieldString<>("ztynaizouteikiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeigyousekihyoujis = new ExDBFieldNumber<>("ztygoukeigyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytnknitjbrsykykgyuskhyjs = new ExDBFieldNumber<>("ztytnknitjbrsykykgyuskhyjs", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyannaikigetu = new ExDBFieldString<>("ztyannaikigetu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyharaizumiymd = new ExDBFieldString<>("ztyharaizumiymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyharaizumis = new ExDBFieldNumber<>("ztyharaizumis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyentyous = new ExDBFieldNumber<>("ztyentyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyseizons = new ExDBFieldNumber<>("ztyseizons", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztypmens = new ExDBFieldNumber<>("ztypmens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztydgoukei = new ExDBFieldNumber<>("ztydgoukei", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysrankbetuhisad = new ExDBFieldNumber<>("ztysrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjsrankbetuhisad = new ExDBFieldNumber<>("ztysyumtjsrankbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztybairitubetuhisad = new ExDBFieldNumber<>("ztybairitubetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtikbairtbetuhisad = new ExDBFieldNumber<>("ztysyumtjtikbairtbetuhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihongoukeid = new ExDBFieldNumber<>("ztysyukeiyakukihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihonsisad = new ExDBFieldNumber<>("ztysyukeiyakukihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihonrisad = new ExDBFieldNumber<>("ztysyukeiyakukihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihonramudad = new ExDBFieldNumber<>("ztysyukeiyakukihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihonhisad = new ExDBFieldNumber<>("ztysyukeiyakukihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihondtaisyous = new ExDBFieldNumber<>("ztysyukeiyakukihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihondyouv = new ExDBFieldNumber<>("ztysyukeiyakukihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakukihondkikens = new ExDBFieldNumber<>("ztysyukeiyakukihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysykykkhnhisadtisyus = new ExDBFieldNumber<>("ztysykykkhnhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikigoukeid = new ExDBFieldNumber<>("ztysyukeiyakuteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikisisad = new ExDBFieldNumber<>("ztysyukeiyakuteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikirisad = new ExDBFieldNumber<>("ztysyukeiyakuteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikiramudad = new ExDBFieldNumber<>("ztysyukeiyakuteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikihisad = new ExDBFieldNumber<>("ztysyukeiyakuteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikidtaisyous = new ExDBFieldNumber<>("ztysyukeiyakuteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikidyouv = new ExDBFieldNumber<>("ztysyukeiyakuteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyukeiyakuteikidkikens = new ExDBFieldNumber<>("ztysyukeiyakuteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysykyktikhisadtisyus = new ExDBFieldNumber<>("ztysykyktikhisadtisyus", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihongoukeid = new ExDBFieldNumber<>("ztytenkankihongoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihonsisad = new ExDBFieldNumber<>("ztytenkankihonsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihonrisad = new ExDBFieldNumber<>("ztytenkankihonrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihonramudad = new ExDBFieldNumber<>("ztytenkankihonramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihonhisad = new ExDBFieldNumber<>("ztytenkankihonhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihondtaisyous = new ExDBFieldNumber<>("ztytenkankihondtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihondyouv = new ExDBFieldNumber<>("ztytenkankihondyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihondkikens = new ExDBFieldNumber<>("ztytenkankihondkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkankihonhisadtaisyous = new ExDBFieldNumber<>("ztytenkankihonhisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikigoukeid = new ExDBFieldNumber<>("ztytenkanteikigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikisisad = new ExDBFieldNumber<>("ztytenkanteikisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikirisad = new ExDBFieldNumber<>("ztytenkanteikirisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikiramudad = new ExDBFieldNumber<>("ztytenkanteikiramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikihisad = new ExDBFieldNumber<>("ztytenkanteikihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikidtaisyous = new ExDBFieldNumber<>("ztytenkanteikidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikidyouv = new ExDBFieldNumber<>("ztytenkanteikidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikidkikens = new ExDBFieldNumber<>("ztytenkanteikidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanteikihisadtaisyous = new ExDBFieldNumber<>("ztytenkanteikihisadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtyusiyutnkntikgukd = new ExDBFieldNumber<>("ztysyumtjtyusiyutnkntikgukd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtyusiyutnkntiksisd = new ExDBFieldNumber<>("ztysyumtjtyusiyutnkntiksisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtyusiyutnkntikrisd = new ExDBFieldNumber<>("ztysyumtjtyusiyutnkntikrisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtyusiyutnkntikhisd = new ExDBFieldNumber<>("ztysyumtjtyusiyutnkntikhisd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtnkntikdtaisyous = new ExDBFieldNumber<>("ztysyumtjtnkntikdtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtnkntikdyouv = new ExDBFieldNumber<>("ztysyumtjtnkntikdyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztysyumtjtnkntikdkikens = new ExDBFieldNumber<>("ztysyumtjtnkntikdkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendougoukeid = new ExDBFieldNumber<>("ztyhendougoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendousisad = new ExDBFieldNumber<>("ztyhendousisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendouhisad = new ExDBFieldNumber<>("ztyhendouhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendoudtaisyous = new ExDBFieldNumber<>("ztyhendoudtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendoudyouv = new ExDBFieldNumber<>("ztyhendoudyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhendoudkikens = new ExDBFieldNumber<>("ztyhendoudkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraigoukeid = new ExDBFieldNumber<>("ztyitibuitijibaraigoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraisisad = new ExDBFieldNumber<>("ztyitibuitijibaraisisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraihisad = new ExDBFieldNumber<>("ztyitibuitijibaraihisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraidtaisyous = new ExDBFieldNumber<>("ztyitibuitijibaraidtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraidyouv = new ExDBFieldNumber<>("ztyitibuitijibaraidyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibuitijibaraidkikens = new ExDBFieldNumber<>("ztyitibuitijibaraidkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibitjbrhisadtisyus = new ExDBFieldNumber<>("ztyitibitjbrhisadtisyus", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyszoukouryokukaisiymd = new ExDBFieldString<>("ztyszoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyszouhokensyuruikigou = new ExDBFieldString<>("ztyszouhokensyuruikigou", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyszoukikan = new ExDBFieldString<>("ztyszoukikan", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyszouhihokensyaage = new ExDBFieldString<>("ztyszouhihokensyaage", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukagoukeid = new ExDBFieldNumber<>("ztyzoukagoukeid", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukasisad = new ExDBFieldNumber<>("ztyzoukasisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukarisad = new ExDBFieldNumber<>("ztyzoukarisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukaramudad = new ExDBFieldNumber<>("ztyzoukaramudad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukahisad = new ExDBFieldNumber<>("ztyzoukahisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukadtaisyous = new ExDBFieldNumber<>("ztyzoukadtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukadyouv = new ExDBFieldNumber<>("ztyzoukadyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyzoukadkikens = new ExDBFieldNumber<>("ztyzoukadkikens", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusasyuruikgu = new ExDBFieldString<>("ztykakuteikakusasyuruikgu", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykakuteikakusad = new ExDBFieldNumber<>("ztykakuteikakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykakuteikakusas = new ExDBFieldNumber<>("ztykakuteikakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykakuteikakusamanryoujid = new ExDBFieldNumber<>("ztykakuteikakusamanryoujid", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusasyuruikigou = new ExDBFieldString<>("ztynaizoumarusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizoumarusad = new ExDBFieldNumber<>("ztynaizoumarusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizoumarusas = new ExDBFieldNumber<>("ztynaizoumarusas", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusasyuruikigou = new ExDBFieldString<>("ztynaizoukakusasyuruikigou", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizoukakusad = new ExDBFieldNumber<>("ztynaizoukakusad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizoukakusas = new ExDBFieldNumber<>("ztynaizoukakusas", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubund = new ExDBFieldNumber<>("ztytenkanpbubund", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubunsisad = new ExDBFieldNumber<>("ztytenkanpbubunsisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubunrisad = new ExDBFieldNumber<>("ztytenkanpbubunrisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubunhisad = new ExDBFieldNumber<>("ztytenkanpbubunhisad", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubundtaisyous = new ExDBFieldNumber<>("ztytenkanpbubundtaisyous", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubundyouv = new ExDBFieldNumber<>("ztytenkanpbubundyouv", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytenkanpbubundkikens = new ExDBFieldNumber<>("ztytenkanpbubundkikens", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizougatateikimud = new ExDBFieldNumber<>("ztynaizougatateikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztynaizougatanenkansanp = new ExDBFieldNumber<>("ztynaizougatanenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyvhktgbbntnkntikmud = new ExDBFieldNumber<>("ztyvhktgbbntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyhikitugitenkanphireimud = new ExDBFieldNumber<>("ztyhikitugitenkanphireimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyitibitjbrgyuskhyjs = new ExDBFieldNumber<>("ztyitibitjbrgyuskhyjs", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykariwariate4nenmae = new ExDBFieldNumber<>("ztykariwariate4nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykariwariate3nenmae = new ExDBFieldNumber<>("ztykariwariate3nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykariwariate2nenmae = new ExDBFieldNumber<>("ztykariwariate2nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztykariwariate1nenmae = new ExDBFieldNumber<>("ztykariwariate1nenmae", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygukisisntnkntikmud = new ExDBFieldNumber<>("ztygukisisntnkntikmud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeiseisanteikis = new ExDBFieldNumber<>("ztygoukeiseisanteikis", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygukisisntnknnenknsnp = new ExDBFieldNumber<>("ztygukisisntnknnenknsnp", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytnkntikhtnknkykymd = new ExDBFieldString<>("ztytnkntikhtnknkykymd", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztytenkangophireimuritu = new ExDBFieldString<>("ztytenkangophireimuritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeitenkannenkansanp = new ExDBFieldNumber<>("ztygoukeitenkannenkansanp", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztygoukeitenkanteikimud = new ExDBFieldNumber<>("ztygoukeitenkanteikimud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytyoukikeizokutokubetud = new ExDBFieldNumber<>("ztytyoukikeizokutokubetud", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytyouseimaed = new ExDBFieldNumber<>("ztytyouseimaed", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztytuutokuhituusand = new ExDBFieldNumber<>("ztytuutokuhituusand", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyszoukigousedaikbn = new ExDBFieldString<>("ztyszoukigousedaikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztymankihyouji = new ExDBFieldString<>("ztymankihyouji", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykeiyakuoutoubikbn = new ExDBFieldString<>("ztykeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigouyobix1 = new ExDBFieldString<>("ztytenkanteikikigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigouyobix2 = new ExDBFieldString<>("ztytenkanteikikigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigouyobix3 = new ExDBFieldString<>("ztytenkanteikikigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigouyobix4 = new ExDBFieldString<>("ztytenkanteikikigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytenkanteikikigouyobix5 = new ExDBFieldString<>("ztytenkanteikikigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakgusdkbn = new ExDBFieldString<>("ztykakuteikakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakguybx1 = new ExDBFieldString<>("ztykakuteikakusakguybx1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakguybx2 = new ExDBFieldString<>("ztykakuteikakusakguybx2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakguybx3 = new ExDBFieldString<>("ztykakuteikakusakguybx3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakguybx4 = new ExDBFieldString<>("ztykakuteikakusakguybx4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykakuteikakusakguybx5 = new ExDBFieldString<>("ztykakuteikakusakguybx5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakgusdkbn = new ExDBFieldString<>("ztynaizoumarusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakigouyobix1 = new ExDBFieldString<>("ztynaizoumarusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakigouyobix2 = new ExDBFieldString<>("ztynaizoumarusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakigouyobix3 = new ExDBFieldString<>("ztynaizoumarusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakigouyobix4 = new ExDBFieldString<>("ztynaizoumarusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoumarusakigouyobix5 = new ExDBFieldString<>("ztynaizoumarusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakgusdkbn = new ExDBFieldString<>("ztynaizoukakusakgusdkbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakigouyobix1 = new ExDBFieldString<>("ztynaizoukakusakigouyobix1", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakigouyobix2 = new ExDBFieldString<>("ztynaizoukakusakigouyobix2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakigouyobix3 = new ExDBFieldString<>("ztynaizoukakusakigouyobix3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakigouyobix4 = new ExDBFieldString<>("ztynaizoukakusakigouyobix4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztynaizoukakusakigouyobix5 = new ExDBFieldString<>("ztynaizoukakusakigouyobix5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyyobiv92 = new ExDBFieldString<>("ztyyobiv92", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztysuuriyouyobin10 = new ExDBFieldString<>("ztysuuriyouyobin10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyyobiv10x2 = new ExDBFieldString<>("ztyyobiv10x2", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_TjHitsyyugkNplusQuartTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztysisadrate = new ExDBFieldString<>("ztysisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztyrisadrate = new ExDBFieldString<>("ztyrisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztyhisadrate = new ExDBFieldString<>("ztyhisadrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztydyouvrate = new ExDBFieldString<>("ztydyouvrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztykikensrate = new ExDBFieldString<>("ztykikensrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, BizNumber> ztygoukeidrate = new ExDBFieldString<>("ztygoukeidrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180 = new ExDBFieldString<>("ztytokuyakukoumokuv180", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x2 = new ExDBFieldString<>("ztytokuyakukoumokuv180x2", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x3 = new ExDBFieldString<>("ztytokuyakukoumokuv180x3", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x4 = new ExDBFieldString<>("ztytokuyakukoumokuv180x4", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x5 = new ExDBFieldString<>("ztytokuyakukoumokuv180x5", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x6 = new ExDBFieldString<>("ztytokuyakukoumokuv180x6", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x7 = new ExDBFieldString<>("ztytokuyakukoumokuv180x7", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x8 = new ExDBFieldString<>("ztytokuyakukoumokuv180x8", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x9 = new ExDBFieldString<>("ztytokuyakukoumokuv180x9", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x10 = new ExDBFieldString<>("ztytokuyakukoumokuv180x10", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x11 = new ExDBFieldString<>("ztytokuyakukoumokuv180x11", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x12 = new ExDBFieldString<>("ztytokuyakukoumokuv180x12", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x13 = new ExDBFieldString<>("ztytokuyakukoumokuv180x13", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x14 = new ExDBFieldString<>("ztytokuyakukoumokuv180x14", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x15 = new ExDBFieldString<>("ztytokuyakukoumokuv180x15", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x16 = new ExDBFieldString<>("ztytokuyakukoumokuv180x16", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x17 = new ExDBFieldString<>("ztytokuyakukoumokuv180x17", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x18 = new ExDBFieldString<>("ztytokuyakukoumokuv180x18", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x19 = new ExDBFieldString<>("ztytokuyakukoumokuv180x19", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x20 = new ExDBFieldString<>("ztytokuyakukoumokuv180x20", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x21 = new ExDBFieldString<>("ztytokuyakukoumokuv180x21", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x22 = new ExDBFieldString<>("ztytokuyakukoumokuv180x22", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x23 = new ExDBFieldString<>("ztytokuyakukoumokuv180x23", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x24 = new ExDBFieldString<>("ztytokuyakukoumokuv180x24", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x25 = new ExDBFieldString<>("ztytokuyakukoumokuv180x25", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x26 = new ExDBFieldString<>("ztytokuyakukoumokuv180x26", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x27 = new ExDBFieldString<>("ztytokuyakukoumokuv180x27", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x28 = new ExDBFieldString<>("ztytokuyakukoumokuv180x28", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x29 = new ExDBFieldString<>("ztytokuyakukoumokuv180x29", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x30 = new ExDBFieldString<>("ztytokuyakukoumokuv180x30", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x31 = new ExDBFieldString<>("ztytokuyakukoumokuv180x31", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x32 = new ExDBFieldString<>("ztytokuyakukoumokuv180x32", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x33 = new ExDBFieldString<>("ztytokuyakukoumokuv180x33", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x34 = new ExDBFieldString<>("ztytokuyakukoumokuv180x34", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x35 = new ExDBFieldString<>("ztytokuyakukoumokuv180x35", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x36 = new ExDBFieldString<>("ztytokuyakukoumokuv180x36", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x37 = new ExDBFieldString<>("ztytokuyakukoumokuv180x37", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x38 = new ExDBFieldString<>("ztytokuyakukoumokuv180x38", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x39 = new ExDBFieldString<>("ztytokuyakukoumokuv180x39", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x40 = new ExDBFieldString<>("ztytokuyakukoumokuv180x40", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x41 = new ExDBFieldString<>("ztytokuyakukoumokuv180x41", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x42 = new ExDBFieldString<>("ztytokuyakukoumokuv180x42", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x43 = new ExDBFieldString<>("ztytokuyakukoumokuv180x43", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x44 = new ExDBFieldString<>("ztytokuyakukoumokuv180x44", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x45 = new ExDBFieldString<>("ztytokuyakukoumokuv180x45", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x46 = new ExDBFieldString<>("ztytokuyakukoumokuv180x46", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x47 = new ExDBFieldString<>("ztytokuyakukoumokuv180x47", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x48 = new ExDBFieldString<>("ztytokuyakukoumokuv180x48", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x49 = new ExDBFieldString<>("ztytokuyakukoumokuv180x49", this);

    public final ExDBFieldString<ZT_TjHitsyyugkNplusQuartTy, String> ztytokuyakukoumokuv180x50 = new ExDBFieldString<>("ztytokuyakukoumokuv180x50", this);
}
