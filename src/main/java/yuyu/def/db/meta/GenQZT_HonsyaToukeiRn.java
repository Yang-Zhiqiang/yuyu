package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;

/**
 * 本社統計Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HonsyaToukeiRn extends AbstractExDBTable<ZT_HonsyaToukeiRn> {

    public GenQZT_HonsyaToukeiRn() {
        this("ZT_HonsyaToukeiRn");
    }

    public GenQZT_HonsyaToukeiRn(String pAlias) {
        super("ZT_HonsyaToukeiRn", ZT_HonsyaToukeiRn.class, pAlias);
    }

    public String ZT_HonsyaToukeiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkijyunym = new ExDBFieldString<>("zrnkijyunym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmosym = new ExDBFieldString<>("zrnmosym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsosikicd = new ExDBFieldString<>("zrnsosikicd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmossyoumetukbn = new ExDBFieldString<>("zrnmossyoumetukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmossyumtkktymd = new ExDBFieldString<>("zrnmossyumtkktymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnrenseihhknkbn = new ExDBFieldString<>("zrnrenseihhknkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndkhktiymd = new ExDBFieldString<>("zrndkhktiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnketkbn = new ExDBFieldString<>("zrnketkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrntoukeihknsyruikbn = new ExDBFieldString<>("zrntoukeihknsyruikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhjykktkbn = new ExDBFieldString<>("zrnhjykktkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrndakuhikts = new ExDBFieldNumber<>("zrndakuhikts", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhkndaisansyakykkbn = new ExDBFieldString<>("zrnhhkndaisansyakykkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndainisentakuinfokakjkkbn = new ExDBFieldString<>("zrndainisentakuinfokakjkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnryousyuuymd = new ExDBFieldString<>("zrnryousyuuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkokutiymd = new ExDBFieldString<>("zrnkokutiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnseikeirenrakuymd = new ExDBFieldString<>("zrnseikeirenrakuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnnyknnyuuryokuymd = new ExDBFieldString<>("zrnnyknnyuuryokuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsisyaketnyuuryokuymd = new ExDBFieldString<>("zrnsisyaketnyuuryokuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkakiraiymd = new ExDBFieldString<>("zrnkykkakiraiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkeiyakukakuninsyuruikbn = new ExDBFieldString<>("zrnkeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsiteidairikbn2 = new ExDBFieldString<>("zrnsiteidairikbn2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkakjkkbn1 = new ExDBFieldString<>("zrnkykkakjkkbn1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkakkanryouymd = new ExDBFieldString<>("zrnkykkakkanryouymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkakketymd = new ExDBFieldString<>("zrnkykkakketymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkakketkekkakbn = new ExDBFieldString<>("zrnkykkakketkekkakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykkaktantoukojincd = new ExDBFieldString<>("zrnkykkaktantoukojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnketsyacd = new ExDBFieldString<>("zrnketsyacd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsyosakuseiymd = new ExDBFieldString<>("zrnsyosakuseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnseisekiym = new ExDBFieldString<>("zrnseisekiym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrnsyokaiharaikomip = new ExDBFieldNumber<>("zrnsyokaiharaikomip", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmossyosakuseiymd = new ExDBFieldString<>("zrnmossyosakuseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketteiriyuucdx1 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketteiriyuucdx2 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketteiriyuucdx3 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketteiriyuucdx4 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhenkouteiseisyorikaisuu = new ExDBFieldString<>("zrnhenkouteiseisyorikaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsyosisyatodokekibouhyj = new ExDBFieldString<>("zrnsyosisyatodokekibouhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhndketkaisuu = new ExDBFieldString<>("zrnhndketkaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd1 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd1 = new ExDBFieldString<>("zrndakuhiketkeiiketmd1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd2 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd2 = new ExDBFieldString<>("zrndakuhiketkeiiketmd2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd3 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd3 = new ExDBFieldString<>("zrndakuhiketkeiiketmd3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd4 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd4 = new ExDBFieldString<>("zrndakuhiketkeiiketmd4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd5 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd5", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd5 = new ExDBFieldString<>("zrndakuhiketkeiiketmd5", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiikekkacd6 = new ExDBFieldString<>("zrndakuhiketkeiikekkacd6", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrndakuhiketkeiiketmd6 = new ExDBFieldString<>("zrndakuhiketkeiiketmd6", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkojincd = new ExDBFieldString<>("zrnkojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsyokaipnyuukinhouhoukbn = new ExDBFieldString<>("zrnsyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsentakuinfoumuhyj = new ExDBFieldString<>("zrnsentakuinfoumuhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhaitousiharaikbn = new ExDBFieldString<>("zrnhaitousiharaikbn", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrnhonsyatkkohojyunhsys = new ExDBFieldNumber<>("zrnhonsyatkkohojyunhsys", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsknnkaisiymd = new ExDBFieldString<>("zrnsknnkaisiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhknsynensyuukbn = new ExDBFieldString<>("zrnhhknsynensyuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrntokusyujimutoriatukaikbn = new ExDBFieldString<>("zrntokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrninputmissteiseikaisuu = new ExDBFieldString<>("zrninputmissteiseikaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhonninkknnkbn = new ExDBFieldString<>("zrnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnnyknzumihyouji = new ExDBFieldString<>("zrnnyknzumihyouji", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhknsykgycd = new ExDBFieldString<>("zrnhhknsykgycd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnnyknjkkbn = new ExDBFieldString<>("zrnnyknjkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnbatukaisyakojincd = new ExDBFieldString<>("zrnbatukaisyakojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsinfstpnyknhouhoukbn = new ExDBFieldString<>("zrnsinfstpnyknhouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmostorikesikbn = new ExDBFieldString<>("zrnmostorikesikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmostrkssyousairiyuukbn = new ExDBFieldString<>("zrnmostrkssyousairiyuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmossakuseino = new ExDBFieldString<>("zrnmossakuseino", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkyknm = new ExDBFieldString<>("zrnkyknm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkyktdkkbn = new ExDBFieldString<>("zrnkyktdkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnmosjihonninkknnkbn = new ExDBFieldString<>("zrnmosjihonninkknnkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsbuktkbn = new ExDBFieldString<>("zrnsbuktkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjsbuktnm = new ExDBFieldString<>("zrnkjsbuktnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsbuktnm = new ExDBFieldString<>("zrnsbuktnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsbuktseiymd = new ExDBFieldString<>("zrnsbuktseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsbukttdkkbn = new ExDBFieldString<>("zrnsbukttdkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjsiteidairininnm = new ExDBFieldString<>("zrnkjsiteidairininnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnsiteidairininnm = new ExDBFieldString<>("zrnsiteidairininnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnfatcakakkekkakbn = new ExDBFieldString<>("zrnfatcakakkekkakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnfatcamosjikakkokusekikbn = new ExDBFieldString<>("zrnfatcamosjikakkokusekikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnfatcatorjikakkokusekikbn = new ExDBFieldString<>("zrnfatcatorjikakkokusekikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzkakiraikbn = new ExDBFieldString<>("zrnkzkakiraikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzkakiraiymd = new ExDBFieldString<>("zrnkzkakiraiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnbankyohurikzhyouji = new ExDBFieldString<>("zrnbankyohurikzhyouji", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzmeigikakuninzumikbn = new ExDBFieldString<>("zrnkzmeigikakuninzumikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnznnkai = new ExDBFieldString<>("zrnznnkai", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzktrkservicekbn = new ExDBFieldString<>("zrnkzktrkservicekbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykdrkbn = new ExDBFieldString<>("zrnkykdrkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjkykdairinm = new ExDBFieldString<>("zrnkjkykdairinm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkykdairinm = new ExDBFieldString<>("zrnkykdairinm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrntrkkzktdk1keta1 = new ExDBFieldString<>("zrntrkkzktdk1keta1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjkzktourokunm1 = new ExDBFieldString<>("zrnkjkzktourokunm1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzktourokunm1 = new ExDBFieldString<>("zrnkzktourokunm1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrntrkkzktdk2keta1 = new ExDBFieldString<>("zrntrkkzktdk2keta1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkjkzktourokunm2 = new ExDBFieldString<>("zrnkjkzktourokunm2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzktourokunm2 = new ExDBFieldString<>("zrnkzktourokunm2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnyakkanjyuryouhoukbn = new ExDBFieldString<>("zrnyakkanjyuryouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnyakkanbunsyono = new ExDBFieldString<>("zrnyakkanbunsyono", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnkzktuutityokusoukbn = new ExDBFieldString<>("zrnkzktuutityokusoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnyobiv250 = new ExDBFieldString<>("zrnyobiv250", this);

    public final ExDBFieldString<ZT_HonsyaToukeiRn, String> zrnyobiv27 = new ExDBFieldString<>("zrnyobiv27", this);
}
