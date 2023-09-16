package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店月次契約情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SinBosyuuDrtenHoyuuKykRn extends AbstractExDBTable<ZT_SinBosyuuDrtenHoyuuKykRn> {

    public GenQZT_SinBosyuuDrtenHoyuuKykRn() {
        this("ZT_SinBosyuuDrtenHoyuuKykRn");
    }

    public GenQZT_SinBosyuuDrtenHoyuuKykRn(String pAlias) {
        super("ZT_SinBosyuuDrtenHoyuuKykRn", ZT_SinBosyuuDrtenHoyuuKykRn.class, pAlias);
    }

    public String ZT_SinBosyuuDrtenHoyuuKykRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnaisyoumeidrtengetuji = new ExDBFieldString<>("zrnaisyoumeidrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnharaikatakbndrtengetuji = new ExDBFieldString<>("zrnharaikatakbndrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnsyohnbnrikbndrtengetuji = new ExDBFieldString<>("zrnsyohnbnrikbndrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnteikaiyakuhrkngatahyj = new ExDBFieldString<>("zrnteikaiyakuhrkngatahyj", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsyaatkioydrtencd = new ExDBFieldString<>("zrnskeibsyaatkioydrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsybatkioydrtencd = new ExDBFieldString<>("zrnskeibsybatkioydrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsyaatkidrtencd = new ExDBFieldString<>("zrnskeibsyaatkidrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsybatkidrtencd = new ExDBFieldString<>("zrnskeibsybatkidrtencd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsyaatkibosyuucd = new ExDBFieldString<>("zrnskeibsyaatkibosyuucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnskeibsybatkibosyuucd = new ExDBFieldString<>("zrnskeibsybatkibosyuucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhknkknmanryouymd = new ExDBFieldString<>("zrnhknkknmanryouymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnhrkpdrtengetuji = new ExDBFieldNumber<>("zrnhrkpdrtengetuji", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnnenkansanpheijyun = new ExDBFieldNumber<>("zrnnenkansanpheijyun", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnknkyknm18 = new ExDBFieldString<>("zrnknkyknm18", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkyknmdrtengetuji = new ExDBFieldString<>("zrnkyknmdrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkyknenkykji = new ExDBFieldString<>("zrnkyknenkykji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkyknengenzai = new ExDBFieldString<>("zrnkyknengenzai", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhrkpjyuutouym = new ExDBFieldString<>("zrnhrkpjyuutouym", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnkihrkmpjytym = new ExDBFieldString<>("zrnkihrkmpjytym", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkihrkmpmf = new ExDBFieldNumber<>("zrnkihrkmpmf", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkihrkmpruikei = new ExDBFieldNumber<>("zrnkihrkmpruikei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkaiyksymtjiw = new ExDBFieldNumber<>("zrnkaiyksymtjiw", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkaiyksymtjikihrkmp = new ExDBFieldNumber<>("zrnkaiyksymtjikihrkmp", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkaiyksymtjiunyousoneki = new ExDBFieldNumber<>("zrnkaiyksymtjiunyousoneki", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkaiyksymtjiunyousonekirt = new ExDBFieldNumber<>("zrnkaiyksymtjiunyousonekirt", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnwkeisanerrkbn = new ExDBFieldString<>("zrnwkeisanerrkbn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmnknksjihenreikingk = new ExDBFieldNumber<>("zrnmnknksjihenreikingk", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmnknksjikihrkmp = new ExDBFieldNumber<>("zrnmnknksjikihrkmp", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmnknksjiunyousoneki = new ExDBFieldNumber<>("zrnmnknksjiunyousoneki", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmnknksjiunyousonekirt = new ExDBFieldNumber<>("zrnmnknksjiunyousonekirt", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnmnknkskeisanerrkbn = new ExDBFieldString<>("zrnmnknkskeisanerrkbn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnnenkansanpanp = new ExDBFieldNumber<>("zrnnenkansanpanp", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnnenkansanpkeisanerrkbn = new ExDBFieldString<>("zrnnenkansanpkeisanerrkbn", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnhrkpgaika = new ExDBFieldString<>("zrnhrkpgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnkaiyksymtjiwgaika = new ExDBFieldString<>("zrnkaiyksymtjiwgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrntuuka = new ExDBFieldString<>("zrntuuka", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnitijibrpyendrtengetuji = new ExDBFieldNumber<>("zrnitijibrpyendrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnitijibrpgaika = new ExDBFieldString<>("zrnitijibrpgaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkiuktrknyen = new ExDBFieldNumber<>("zrnkiuktrknyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnkiuktrkngaika = new ExDBFieldString<>("zrnkiuktrkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrntmttknyen = new ExDBFieldNumber<>("zrntmttknyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrntmttkngaika = new ExDBFieldString<>("zrntmttkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkaiyakukjetcyen = new ExDBFieldNumber<>("zrnkaiyakukjetcyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnkaiyakukjetcgaika = new ExDBFieldString<>("zrnkaiyakukjetcgaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnwyendrtengetuji = new ExDBFieldNumber<>("zrnwyendrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnkaiyakuhrkngaika = new ExDBFieldString<>("zrnkaiyakuhrkngaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnsonekiyen = new ExDBFieldNumber<>("zrnsonekiyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnsonekigaika = new ExDBFieldString<>("zrnsonekigaika", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnsbsetcyen = new ExDBFieldNumber<>("zrnsbsetcyen", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnsbsetcgaika = new ExDBFieldString<>("zrnsbsetcgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnsonekicalchunouflg = new ExDBFieldString<>("zrnsonekicalchunouflg", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnhhknnmkjdrtengetuji = new ExDBFieldString<>("zrnhhknnmkjdrtengetuji", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrntargettktoutatubi = new ExDBFieldString<>("zrntargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmokuhyouti = new ExDBFieldNumber<>("zrnmokuhyouti", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmokuhyoukngk = new ExDBFieldNumber<>("zrnmokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkihrpruikeigk = new ExDBFieldNumber<>("zrnkihrpruikeigk", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrntousyokykjikawaserate = new ExDBFieldString<>("zrntousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnwkeisanerrorhyj = new ExDBFieldString<>("zrnwkeisanerrorhyj", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrngmeigyoubijikawaserate = new ExDBFieldString<>("zrngmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnikueisikin = new ExDBFieldNumber<>("zrnikueisikin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrngakusiiwaikn = new ExDBFieldNumber<>("zrngakusiiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnzoukaseizonssueokikn = new ExDBFieldNumber<>("zrnzoukaseizonssueokikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnknkuiwaikn = new ExDBFieldNumber<>("zrnknkuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkijyuiwaikn = new ExDBFieldNumber<>("zrnkijyuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnbeijyuiwaikn = new ExDBFieldNumber<>("zrnbeijyuiwaikn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnsznkyhkn = new ExDBFieldNumber<>("zrnsznkyhkn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkyktsnatkitkykkyhkn = new ExDBFieldNumber<>("zrnkyktsnatkitkykkyhkn", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnzoukayourous = new ExDBFieldNumber<>("zrnzoukayourous", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrntmtthaitoukin = new ExDBFieldNumber<>("zrntmtthaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrntkbthaitoukin = new ExDBFieldNumber<>("zrntkbthaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnsonotahaitoukin = new ExDBFieldNumber<>("zrnsonotahaitoukin", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrngensentyousyuuzeigaku = new ExDBFieldNumber<>("zrngensentyousyuuzeigaku", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnottkekinganrigoukei = new ExDBFieldNumber<>("zrnottkekinganrigoukei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnkstkknganrigoukei = new ExDBFieldNumber<>("zrnkstkknganrigoukei", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnmikeikamisyuup = new ExDBFieldNumber<>("zrnmikeikamisyuup", this);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnsonotaseisankin = new ExDBFieldNumber<>("zrnsonotaseisankin", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnhuho2sjkkktyouseigkmva = new ExDBFieldString<>("zrnhuho2sjkkktyouseigkmva", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SinBosyuuDrtenHoyuuKykRn, Long> zrnhuho2yendthnkhr = new ExDBFieldNumber<>("zrnhuho2yendthnkhr", this);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnhuho2sjkkktyouseiriritu = new ExDBFieldString<>("zrnhuho2sjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, BizNumber> zrnhuho2kaiyakukoujyoritu = new ExDBFieldString<>("zrnhuho2kaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SinBosyuuDrtenHoyuuKykRn, String> zrnyobiv66 = new ExDBFieldString<>("zrnyobiv66", this);
}
