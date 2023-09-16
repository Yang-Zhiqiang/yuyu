package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 継続率連絡データＵＬＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KeizokurituRenrakuULFTy extends AbstractExDBTable<ZT_KeizokurituRenrakuULFTy> {

    public GenQZT_KeizokurituRenrakuULFTy() {
        this("ZT_KeizokurituRenrakuULFTy");
    }

    public GenQZT_KeizokurituRenrakuULFTy(String pAlias) {
        super("ZT_KeizokurituRenrakuULFTy", ZT_KeizokurituRenrakuULFTy.class, pAlias);
    }

    public String ZT_KeizokurituRenrakuULFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyatukaikojincd = new ExDBFieldString<>("ztyatukaikojincd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysyukgu = new ExDBFieldString<>("ztysyukgu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysyukinkbn = new ExDBFieldString<>("ztysyukinkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysyuukintantousosikicd = new ExDBFieldString<>("ztysyuukintantousosikicd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztydnthrkkeirokbn = new ExDBFieldString<>("ztydnthrkkeirokbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykhyuukousyoumetukbn = new ExDBFieldString<>("ztykhyuukousyoumetukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykeikatukisuu = new ExDBFieldString<>("ztykeikatukisuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, BizNumber> ztykeiyakukensuu = new ExDBFieldString<>("ztykeiyakukensuu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztysyuuseis9keta = new ExDBFieldNumber<>("ztysyuuseis9keta", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyatukaisosikicd = new ExDBFieldString<>("ztyatukaisosikicd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykyknm = new ExDBFieldString<>("ztykyknm", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztymarutokuhyj = new ExDBFieldString<>("ztymarutokuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztytyohktyouseihyj = new ExDBFieldString<>("ztytyohktyouseihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztygyoumujyouhyouji = new ExDBFieldString<>("ztygyoumujyouhyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykydatkihyj = new ExDBFieldString<>("ztykydatkihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykzktatkibanhktgksnkbn = new ExDBFieldString<>("ztykzktatkibanhktgksnkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyjidoukousinhyouji = new ExDBFieldString<>("ztyjidoukousinhyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyskeijimrtiarihyj = new ExDBFieldString<>("ztyskeijimrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyskeijikzkmrtiarihyj = new ExDBFieldString<>("ztyskeijikzkmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhukkatukeiiarihyj = new ExDBFieldString<>("ztyhukkatukeiiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztytyouhukutyouseiskeihyj = new ExDBFieldString<>("ztytyouhukutyouseiskeihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyphkbnmnoshyouji = new ExDBFieldString<>("ztyphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykaigomarusyuuarihyj = new ExDBFieldString<>("ztykaigomarusyuuarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhngkjidouentyoukbn = new ExDBFieldString<>("ztyhngkjidouentyoukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhngkjidouentyoukikan = new ExDBFieldString<>("ztyhngkjidouentyoukikan", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztydoujihuhomrtisyukigou = new ExDBFieldString<>("ztydoujihuhomrtisyukigou", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyseizonmrtiarihyj = new ExDBFieldString<>("ztyseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyteigenmrtiarihyj = new ExDBFieldString<>("ztyteigenmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, BizNumber> ztyjyunkensuu = new ExDBFieldString<>("ztyjyunkensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyaltourokukeiyakuhyj = new ExDBFieldString<>("ztyaltourokukeiyakuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyjikokykhyj = new ExDBFieldString<>("ztyjikokykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysynymrtiarihyj = new ExDBFieldString<>("ztysynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykykniyutksytioukbn = new ExDBFieldString<>("ztykykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyreguardmrtiarihyj = new ExDBFieldString<>("ztyreguardmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyreguardmrsyuarihyj = new ExDBFieldString<>("ztyreguardmrsyuarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyvguardmrtiarihyj = new ExDBFieldString<>("ztyvguardmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykousintkykhyj = new ExDBFieldString<>("ztykousintkykhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykousinkakuninnasihyj = new ExDBFieldString<>("ztykousinkakuninnasihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyfollowhunouhyj = new ExDBFieldString<>("ztyfollowhunouhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykaigosynymrtiarihyj = new ExDBFieldString<>("ztykaigosynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykaigoteigenmrtiarihyj = new ExDBFieldString<>("ztykaigoteigenmrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysuperknkuseikatupackhyj = new ExDBFieldString<>("ztysuperknkuseikatupackhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykaigonktkykarihyj = new ExDBFieldString<>("ztykaigonktkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykaigomrtiarihyj = new ExDBFieldString<>("ztykaigomrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykeiyakukbn = new ExDBFieldString<>("ztykeiyakukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykeizokutyuuihyouji = new ExDBFieldString<>("ztykeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykikeiyakutyuuihyouji = new ExDBFieldString<>("ztykikeiyakutyuuihyouji", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztybosyuunincd = new ExDBFieldString<>("ztybosyuunincd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztymrtikousinkbn = new ExDBFieldString<>("ztymrtikousinkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztypmenkbnv1 = new ExDBFieldString<>("ztypmenkbnv1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyyouikunktkykarihyj = new ExDBFieldString<>("ztyyouikunktkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztyseikatusyuunyuumrtis = new ExDBFieldNumber<>("ztyseikatusyuunyuumrtis", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono1 = new ExDBFieldString<>("ztyhitenkansyono1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono2 = new ExDBFieldString<>("ztyhitenkansyono2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono3 = new ExDBFieldString<>("ztyhitenkansyono3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono4 = new ExDBFieldString<>("ztyhitenkansyono4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono5 = new ExDBFieldString<>("ztyhitenkansyono5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhitenkansyono6 = new ExDBFieldString<>("ztyhitenkansyono6", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztydai3bunyanenkansanp = new ExDBFieldNumber<>("ztydai3bunyanenkansanp", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykykym = new ExDBFieldString<>("ztykykym", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysytikbn = new ExDBFieldString<>("ztysytikbn", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztyfundbubunnenkansanp = new ExDBFieldNumber<>("ztyfundbubunnenkansanp", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztykzktatsyuuseis = new ExDBFieldNumber<>("ztykzktatsyuuseis", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysiktsynymrtiarihyj = new ExDBFieldString<>("ztysiktsynymrtiarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztylivguardarihyj = new ExDBFieldString<>("ztylivguardarihyj", this);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztylivguards = new ExDBFieldNumber<>("ztylivguards", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztybluekzjtkaisiymd = new ExDBFieldString<>("ztybluekzjtkaisiymd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyknkuzusnzyrtstkbn = new ExDBFieldString<>("ztyknkuzusnzyrtstkbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztytokuyakuno = new ExDBFieldString<>("ztytokuyakuno", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyvityugusttkyuhyj = new ExDBFieldString<>("ztyvityugusttkyuhyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykzktourokuservicearihyj = new ExDBFieldString<>("ztykzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyyendthnkymd8keta = new ExDBFieldString<>("ztyyendthnkymd8keta", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztykhsyoumetujiyuu = new ExDBFieldString<>("ztykhsyoumetujiyuu", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, BizNumber> ztyitijibaraipkyktuuka = new ExDBFieldString<>("ztyitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, BizNumber> ztykawaseraten5 = new ExDBFieldString<>("ztykawaseraten5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztynnknsnpssysyup = new ExDBFieldNumber<>("ztynnknsnpssysyup", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztynknsnpssyhrkkskbn = new ExDBFieldString<>("ztynknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, BizNumber> ztynnknsnpyennkgotmttrrt = new ExDBFieldString<>("ztynnknsnpyennkgotmttrrt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KeizokurituRenrakuULFTy, Long> ztynnknsnpyennkgonksjtmttkn = new ExDBFieldNumber<>("ztynnknsnpyennkgonksjtmttkn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_KeizokurituRenrakuULFTy, String> ztyyobiv33 = new ExDBFieldString<>("ztyyobiv33", this);
}
