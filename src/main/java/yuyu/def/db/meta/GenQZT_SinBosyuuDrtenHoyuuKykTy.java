package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店月次契約情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SinBosyuuDrtenHoyuuKykTy extends AbstractExDBTable<ZT_SinBosyuuDrtenHoyuuKykTy> {

    public GenQZT_SinBosyuuDrtenHoyuuKykTy() {
        this("ZT_SinBosyuuDrtenHoyuuKykTy");
    }

    public GenQZT_SinBosyuuDrtenHoyuuKykTy(String pAlias) {
        super("ZT_SinBosyuuDrtenHoyuuKykTy", ZT_SinBosyuuDrtenHoyuuKykTy.class, pAlias);
    }

    public String ZT_SinBosyuuDrtenHoyuuKykTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyaisyoumeidrtengetuji = new ExDBFieldString<>("ztyaisyoumeidrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyharaikatakbndrtengetuji = new ExDBFieldString<>("ztyharaikatakbndrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztysyohnbnrikbndrtengetuji = new ExDBFieldString<>("ztysyohnbnrikbndrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyteikaiyakuhrkngatahyj = new ExDBFieldString<>("ztyteikaiyakuhrkngatahyj", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsyaatkioydrtencd = new ExDBFieldString<>("ztyskeibsyaatkioydrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsybatkioydrtencd = new ExDBFieldString<>("ztyskeibsybatkioydrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsyaatkidrtencd = new ExDBFieldString<>("ztyskeibsyaatkidrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsybatkidrtencd = new ExDBFieldString<>("ztyskeibsybatkidrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsyaatkibosyuucd = new ExDBFieldString<>("ztyskeibsyaatkibosyuucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyskeibsybatkibosyuucd = new ExDBFieldString<>("ztyskeibsybatkibosyuucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhknkknmanryouymd = new ExDBFieldString<>("ztyhknkknmanryouymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztysymtymd = new ExDBFieldString<>("ztysymtymd", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyhrkpdrtengetuji = new ExDBFieldNumber<>("ztyhrkpdrtengetuji", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztynenkansanpheijyun = new ExDBFieldNumber<>("ztynenkansanpheijyun", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyknkyknm18 = new ExDBFieldString<>("ztyknkyknm18", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykyknmdrtengetuji = new ExDBFieldString<>("ztykyknmdrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykyknenkykji = new ExDBFieldString<>("ztykyknenkykji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykyknengenzai = new ExDBFieldString<>("ztykyknengenzai", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhrkpjyuutouym = new ExDBFieldString<>("ztyhrkpjyuutouym", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztykihrkmpjytym = new ExDBFieldString<>("ztykihrkmpjytym", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykihrkmpmf = new ExDBFieldNumber<>("ztykihrkmpmf", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykihrkmpruikei = new ExDBFieldNumber<>("ztykihrkmpruikei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykaiyksymtjiw = new ExDBFieldNumber<>("ztykaiyksymtjiw", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykaiyksymtjikihrkmp = new ExDBFieldNumber<>("ztykaiyksymtjikihrkmp", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykaiyksymtjiunyousoneki = new ExDBFieldNumber<>("ztykaiyksymtjiunyousoneki", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykaiyksymtjiunyousonekirt = new ExDBFieldNumber<>("ztykaiyksymtjiunyousonekirt", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztywkeisanerrkbn = new ExDBFieldString<>("ztywkeisanerrkbn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymnknksjihenreikingk = new ExDBFieldNumber<>("ztymnknksjihenreikingk", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymnknksjikihrkmp = new ExDBFieldNumber<>("ztymnknksjikihrkmp", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymnknksjiunyousoneki = new ExDBFieldNumber<>("ztymnknksjiunyousoneki", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymnknksjiunyousonekirt = new ExDBFieldNumber<>("ztymnknksjiunyousonekirt", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztymnknkskeisanerrkbn = new ExDBFieldString<>("ztymnknkskeisanerrkbn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztynenkansanpanp = new ExDBFieldNumber<>("ztynenkansanpanp", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztynenkansanpkeisanerrkbn = new ExDBFieldString<>("ztynenkansanpkeisanerrkbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztyhrkpgaika = new ExDBFieldString<>("ztyhrkpgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztykaiyksymtjiwgaika = new ExDBFieldString<>("ztykaiyksymtjiwgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztytuuka = new ExDBFieldString<>("ztytuuka", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyitijibrpyendrtengetuji = new ExDBFieldNumber<>("ztyitijibrpyendrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztyitijibrpgaika = new ExDBFieldString<>("ztyitijibrpgaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykiuktrknyen = new ExDBFieldNumber<>("ztykiuktrknyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztykiuktrkngaika = new ExDBFieldString<>("ztykiuktrkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztytmttknyen = new ExDBFieldNumber<>("ztytmttknyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztytmttkngaika = new ExDBFieldString<>("ztytmttkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykaiyakukjetcyen = new ExDBFieldNumber<>("ztykaiyakukjetcyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztykaiyakukjetcgaika = new ExDBFieldString<>("ztykaiyakukjetcgaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztywyendrtengetuji = new ExDBFieldNumber<>("ztywyendrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztykaiyakuhrkngaika = new ExDBFieldString<>("ztykaiyakuhrkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztysonekiyen = new ExDBFieldNumber<>("ztysonekiyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztysonekigaika = new ExDBFieldString<>("ztysonekigaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztysbsetcyen = new ExDBFieldNumber<>("ztysbsetcyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztysbsetcgaika = new ExDBFieldString<>("ztysbsetcgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztysonekicalchunouflg = new ExDBFieldString<>("ztysonekicalchunouflg", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyhhknnmkjdrtengetuji = new ExDBFieldString<>("ztyhhknnmkjdrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztytargettktoutatubi = new ExDBFieldString<>("ztytargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymokuhyouti = new ExDBFieldNumber<>("ztymokuhyouti", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymokuhyoukngk = new ExDBFieldNumber<>("ztymokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykihrpruikeigk = new ExDBFieldNumber<>("ztykihrpruikeigk", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztytousyokykjikawaserate = new ExDBFieldString<>("ztytousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztywkeisanerrorhyj = new ExDBFieldString<>("ztywkeisanerrorhyj", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztygmeigyoubijikawaserate = new ExDBFieldString<>("ztygmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyikueisikin = new ExDBFieldNumber<>("ztyikueisikin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztygakusiiwaikn = new ExDBFieldNumber<>("ztygakusiiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyzoukaseizonssueokikn = new ExDBFieldNumber<>("ztyzoukaseizonssueokikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyknkuiwaikn = new ExDBFieldNumber<>("ztyknkuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykijyuiwaikn = new ExDBFieldNumber<>("ztykijyuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztybeijyuiwaikn = new ExDBFieldNumber<>("ztybeijyuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztysznkyhkn = new ExDBFieldNumber<>("ztysznkyhkn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykyktsnatkitkykkyhkn = new ExDBFieldNumber<>("ztykyktsnatkitkykkyhkn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyzoukayourous = new ExDBFieldNumber<>("ztyzoukayourous", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztytmtthaitoukin = new ExDBFieldNumber<>("ztytmtthaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztytkbthaitoukin = new ExDBFieldNumber<>("ztytkbthaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztysonotahaitoukin = new ExDBFieldNumber<>("ztysonotahaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztygensentyousyuuzeigaku = new ExDBFieldNumber<>("ztygensentyousyuuzeigaku", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyottkekinganrigoukei = new ExDBFieldNumber<>("ztyottkekinganrigoukei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztykstkknganrigoukei = new ExDBFieldNumber<>("ztykstkknganrigoukei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztymikeikamisyuup = new ExDBFieldNumber<>("ztymikeikamisyuup", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztysonotaseisankin = new ExDBFieldNumber<>("ztysonotaseisankin", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztyhuho2sjkkktyouseigkmva = new ExDBFieldString<>("ztyhuho2sjkkktyouseigkmva", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykTy, Long> ztyhuho2yendthnkhr = new ExDBFieldNumber<>("ztyhuho2yendthnkhr", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztyhuho2sjkkktyouseiriritu = new ExDBFieldString<>("ztyhuho2sjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, BizNumber> ztyhuho2kaiyakukoujyoritu = new ExDBFieldString<>("ztyhuho2kaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykTy, String> ztyyobiv66 = new ExDBFieldString<>("ztyyobiv66", this);
}
