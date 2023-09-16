package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 継続率連絡データＵＬＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KeizokurituRenrakuULFRn extends AbstractExDBTable<ZT_KeizokurituRenrakuULFRn> {

    public GenQZT_KeizokurituRenrakuULFRn() {
        this("ZT_KeizokurituRenrakuULFRn");
    }

    public GenQZT_KeizokurituRenrakuULFRn(String pAlias) {
        super("ZT_KeizokurituRenrakuULFRn", ZT_KeizokurituRenrakuULFRn.class, pAlias);
    }

    public String ZT_KeizokurituRenrakuULFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnatukaikojincd = new ExDBFieldString<>("zrnatukaikojincd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsyukgu = new ExDBFieldString<>("zrnsyukgu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsyukinkbn = new ExDBFieldString<>("zrnsyukinkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsyuukintantousosikicd = new ExDBFieldString<>("zrnsyuukintantousosikicd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrndnthrkkeirokbn = new ExDBFieldString<>("zrndnthrkkeirokbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkhyuukousyoumetukbn = new ExDBFieldString<>("zrnkhyuukousyoumetukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkeikatukisuu = new ExDBFieldString<>("zrnkeikatukisuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, BizNumber> zrnkeiyakukensuu = new ExDBFieldString<>("zrnkeiyakukensuu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnsyuuseis9keta = new ExDBFieldNumber<>("zrnsyuuseis9keta", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnatukaisosikicd = new ExDBFieldString<>("zrnatukaisosikicd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkyknm = new ExDBFieldString<>("zrnkyknm", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnmarutokuhyj = new ExDBFieldString<>("zrnmarutokuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrntyohktyouseihyj = new ExDBFieldString<>("zrntyohktyouseihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrngyoumujyouhyouji = new ExDBFieldString<>("zrngyoumujyouhyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkydatkihyj = new ExDBFieldString<>("zrnkydatkihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkzktatkibanhktgksnkbn = new ExDBFieldString<>("zrnkzktatkibanhktgksnkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnjidoukousinhyouji = new ExDBFieldString<>("zrnjidoukousinhyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnskeijimrtiarihyj = new ExDBFieldString<>("zrnskeijimrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnskeijikzkmrtiarihyj = new ExDBFieldString<>("zrnskeijikzkmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhukkatukeiiarihyj = new ExDBFieldString<>("zrnhukkatukeiiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrntyouhukutyouseiskeihyj = new ExDBFieldString<>("zrntyouhukutyouseiskeihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnphkbnmnoshyouji = new ExDBFieldString<>("zrnphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkaigomarusyuuarihyj = new ExDBFieldString<>("zrnkaigomarusyuuarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnheiyoubaraikeiyakukbn = new ExDBFieldString<>("zrnheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhngkjidouentyoukbn = new ExDBFieldString<>("zrnhngkjidouentyoukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhngkjidouentyoukikan = new ExDBFieldString<>("zrnhngkjidouentyoukikan", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrndoujihuhomrtisyukigou = new ExDBFieldString<>("zrndoujihuhomrtisyukigou", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnseizonmrtiarihyj = new ExDBFieldString<>("zrnseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnteigenmrtiarihyj = new ExDBFieldString<>("zrnteigenmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, BizNumber> zrnjyunkensuu = new ExDBFieldString<>("zrnjyunkensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnaltourokukeiyakuhyj = new ExDBFieldString<>("zrnaltourokukeiyakuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnjikokykhyj = new ExDBFieldString<>("zrnjikokykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsynymrtiarihyj = new ExDBFieldString<>("zrnsynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkykniyutksytioukbn = new ExDBFieldString<>("zrnkykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnreguardmrtiarihyj = new ExDBFieldString<>("zrnreguardmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnreguardmrsyuarihyj = new ExDBFieldString<>("zrnreguardmrsyuarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnvguardmrtiarihyj = new ExDBFieldString<>("zrnvguardmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkousintkykhyj = new ExDBFieldString<>("zrnkousintkykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkousinkakuninnasihyj = new ExDBFieldString<>("zrnkousinkakuninnasihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnfollowhunouhyj = new ExDBFieldString<>("zrnfollowhunouhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkaigosynymrtiarihyj = new ExDBFieldString<>("zrnkaigosynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkaigoteigenmrtiarihyj = new ExDBFieldString<>("zrnkaigoteigenmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsuperknkuseikatupackhyj = new ExDBFieldString<>("zrnsuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkaigonktkykarihyj = new ExDBFieldString<>("zrnkaigonktkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkaigomrtiarihyj = new ExDBFieldString<>("zrnkaigomrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkeiyakukbn = new ExDBFieldString<>("zrnkeiyakukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkeizokutyuuihyouji = new ExDBFieldString<>("zrnkeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkikeiyakutyuuihyouji = new ExDBFieldString<>("zrnkikeiyakutyuuihyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnmrtikousinkbn = new ExDBFieldString<>("zrnmrtikousinkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnpmenkbnv1 = new ExDBFieldString<>("zrnpmenkbnv1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnyouikunktkykarihyj = new ExDBFieldString<>("zrnyouikunktkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnseikatusyuunyuumrtis = new ExDBFieldNumber<>("zrnseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono1 = new ExDBFieldString<>("zrnhitenkansyono1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono2 = new ExDBFieldString<>("zrnhitenkansyono2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono3 = new ExDBFieldString<>("zrnhitenkansyono3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono4 = new ExDBFieldString<>("zrnhitenkansyono4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono5 = new ExDBFieldString<>("zrnhitenkansyono5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhitenkansyono6 = new ExDBFieldString<>("zrnhitenkansyono6", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrndai3bunyanenkansanp = new ExDBFieldNumber<>("zrndai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkykym = new ExDBFieldString<>("zrnkykym", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsytikbn = new ExDBFieldString<>("zrnsytikbn", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnfundbubunnenkansanp = new ExDBFieldNumber<>("zrnfundbubunnenkansanp", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnkzktatsyuuseis = new ExDBFieldNumber<>("zrnkzktatsyuuseis", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsiktsynymrtiarihyj = new ExDBFieldString<>("zrnsiktsynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnlivguardarihyj = new ExDBFieldString<>("zrnlivguardarihyj", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnlivguards = new ExDBFieldNumber<>("zrnlivguards", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnbluekzjtkaisiymd = new ExDBFieldString<>("zrnbluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnknkuzusnzyrtstkbn = new ExDBFieldString<>("zrnknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrntokuyakuno = new ExDBFieldString<>("zrntokuyakuno", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnvityugusttkyuhyj = new ExDBFieldString<>("zrnvityugusttkyuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkzktourokuservicearihyj = new ExDBFieldString<>("zrnkzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnyendthnkymd8keta = new ExDBFieldString<>("zrnyendthnkymd8keta", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnkhsyoumetujiyuu = new ExDBFieldString<>("zrnkhsyoumetujiyuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, BizNumber> zrnitijibaraipkyktuuka = new ExDBFieldString<>("zrnitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, BizNumber> zrnkawaseraten5 = new ExDBFieldString<>("zrnkawaseraten5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnnnknsnpssysyup = new ExDBFieldNumber<>("zrnnnknsnpssysyup", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnnknsnpssyhrkkskbn = new ExDBFieldString<>("zrnnknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, BizNumber> zrnnnknsnpyennkgotmttrrt = new ExDBFieldString<>("zrnnnknsnpyennkgotmttrrt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFRn, Long> zrnnnknsnpyennkgonksjtmttkn = new ExDBFieldNumber<>("zrnnnknsnpyennkgonksjtmttkn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFRn, String> zrnyobiv33 = new ExDBFieldString<>("zrnyobiv33", this);
}
