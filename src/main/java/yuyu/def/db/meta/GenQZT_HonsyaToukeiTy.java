package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;

/**
 * 本社統計Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HonsyaToukeiTy extends AbstractExDBTable<ZT_HonsyaToukeiTy> {

    public GenQZT_HonsyaToukeiTy() {
        this("ZT_HonsyaToukeiTy");
    }

    public GenQZT_HonsyaToukeiTy(String pAlias) {
        super("ZT_HonsyaToukeiTy", ZT_HonsyaToukeiTy.class, pAlias);
    }

    public String ZT_HonsyaToukeiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykijyunym = new ExDBFieldString<>("ztykijyunym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymosym = new ExDBFieldString<>("ztymosym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysosikicd = new ExDBFieldString<>("ztysosikicd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymossyoumetukbn = new ExDBFieldString<>("ztymossyoumetukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymossyumtkktymd = new ExDBFieldString<>("ztymossyumtkktymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyrenseihhknkbn = new ExDBFieldString<>("ztyrenseihhknkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydkhktiymd = new ExDBFieldString<>("ztydkhktiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyketkbn = new ExDBFieldString<>("ztyketkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztytoukeihknsyruikbn = new ExDBFieldString<>("ztytoukeihknsyruikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhjykktkbn = new ExDBFieldString<>("ztyhjykktkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztydakuhikts = new ExDBFieldNumber<>("ztydakuhikts", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhkndaisansyakykkbn = new ExDBFieldString<>("ztyhhkndaisansyakykkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydainisentakuinfokakjkkbn = new ExDBFieldString<>("ztydainisentakuinfokakjkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyryousyuuymd = new ExDBFieldString<>("ztyryousyuuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykokutiymd = new ExDBFieldString<>("ztykokutiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyseikeirenrakuymd = new ExDBFieldString<>("ztyseikeirenrakuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztynyknnyuuryokuymd = new ExDBFieldString<>("ztynyknnyuuryokuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysisyaketnyuuryokuymd = new ExDBFieldString<>("ztysisyaketnyuuryokuymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkakiraiymd = new ExDBFieldString<>("ztykykkakiraiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykeiyakukakuninsyuruikbn = new ExDBFieldString<>("ztykeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysiteidairikbn2 = new ExDBFieldString<>("ztysiteidairikbn2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkakjkkbn1 = new ExDBFieldString<>("ztykykkakjkkbn1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkakkanryouymd = new ExDBFieldString<>("ztykykkakkanryouymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkakketymd = new ExDBFieldString<>("ztykykkakketymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkakketkekkakbn = new ExDBFieldString<>("ztykykkakketkekkakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykkaktantoukojincd = new ExDBFieldString<>("ztykykkaktantoukojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyketsyacd = new ExDBFieldString<>("ztyketsyacd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysyosakuseiymd = new ExDBFieldString<>("ztysyosakuseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyseisekiym = new ExDBFieldString<>("ztyseisekiym", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztysyokaiharaikomip = new ExDBFieldNumber<>("ztysyokaiharaikomip", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymossyosakuseiymd = new ExDBFieldString<>("ztymossyosakuseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketteiriyuucdx1 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketteiriyuucdx2 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketteiriyuucdx3 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketteiriyuucdx4 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhenkouteiseisyorikaisuu = new ExDBFieldString<>("ztyhenkouteiseisyorikaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysyosisyatodokekibouhyj = new ExDBFieldString<>("ztysyosisyatodokekibouhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhndketkaisuu = new ExDBFieldString<>("ztyhndketkaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd1 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd1 = new ExDBFieldString<>("ztydakuhiketkeiiketmd1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd2 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd2 = new ExDBFieldString<>("ztydakuhiketkeiiketmd2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd3 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd3 = new ExDBFieldString<>("ztydakuhiketkeiiketmd3", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd4 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd4 = new ExDBFieldString<>("ztydakuhiketkeiiketmd4", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd5 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd5", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd5 = new ExDBFieldString<>("ztydakuhiketkeiiketmd5", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiikekkacd6 = new ExDBFieldString<>("ztydakuhiketkeiikekkacd6", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztydakuhiketkeiiketmd6 = new ExDBFieldString<>("ztydakuhiketkeiiketmd6", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykojincd = new ExDBFieldString<>("ztykojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysyokaipnyuukinhouhoukbn = new ExDBFieldString<>("ztysyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysentakuinfoumuhyj = new ExDBFieldString<>("ztysentakuinfoumuhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhaitousiharaikbn = new ExDBFieldString<>("ztyhaitousiharaikbn", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztyhonsyatkkohojyunhsys = new ExDBFieldNumber<>("ztyhonsyatkkohojyunhsys", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysknnkaisiymd = new ExDBFieldString<>("ztysknnkaisiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhknsynensyuukbn = new ExDBFieldString<>("ztyhhknsynensyuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztytokusyujimutoriatukaikbn = new ExDBFieldString<>("ztytokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyinputmissteiseikaisuu = new ExDBFieldString<>("ztyinputmissteiseikaisuu", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhonninkknnkbn = new ExDBFieldString<>("ztyhonninkknnkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztynyknzumihyouji = new ExDBFieldString<>("ztynyknzumihyouji", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhknsykgycd = new ExDBFieldString<>("ztyhhknsykgycd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztynyknjkkbn = new ExDBFieldString<>("ztynyknjkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztybatukaisyakojincd = new ExDBFieldString<>("ztybatukaisyakojincd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysinfstpnyknhouhoukbn = new ExDBFieldString<>("ztysinfstpnyknhouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymostorikesikbn = new ExDBFieldString<>("ztymostorikesikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymostrkssyousairiyuukbn = new ExDBFieldString<>("ztymostrkssyousairiyuukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymossakuseino = new ExDBFieldString<>("ztymossakuseino", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_HonsyaToukeiTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykyknm = new ExDBFieldString<>("ztykyknm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykyktdkkbn = new ExDBFieldString<>("ztykyktdkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztymosjihonninkknnkbn = new ExDBFieldString<>("ztymosjihonninkknnkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysbuktkbn = new ExDBFieldString<>("ztysbuktkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjsbuktnm = new ExDBFieldString<>("ztykjsbuktnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysbuktnm = new ExDBFieldString<>("ztysbuktnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysbuktseiymd = new ExDBFieldString<>("ztysbuktseiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysbukttdkkbn = new ExDBFieldString<>("ztysbukttdkkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjsiteidairininnm = new ExDBFieldString<>("ztykjsiteidairininnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztysiteidairininnm = new ExDBFieldString<>("ztysiteidairininnm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyfatcakakkekkakbn = new ExDBFieldString<>("ztyfatcakakkekkakbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyfatcamosjikakkokusekikbn = new ExDBFieldString<>("ztyfatcamosjikakkokusekikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyfatcatorjikakkokusekikbn = new ExDBFieldString<>("ztyfatcatorjikakkokusekikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzkakiraikbn = new ExDBFieldString<>("ztykzkakiraikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzkakiraiymd = new ExDBFieldString<>("ztykzkakiraiymd", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztybankyohurikzhyouji = new ExDBFieldString<>("ztybankyohurikzhyouji", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzmeigikakuninzumikbn = new ExDBFieldString<>("ztykzmeigikakuninzumikbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyznnkai = new ExDBFieldString<>("ztyznnkai", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzktrkservicekbn = new ExDBFieldString<>("ztykzktrkservicekbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykdrkbn = new ExDBFieldString<>("ztykykdrkbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjkykdairinm = new ExDBFieldString<>("ztykjkykdairinm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykykdairinm = new ExDBFieldString<>("ztykykdairinm", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztytrkkzktdk1keta1 = new ExDBFieldString<>("ztytrkkzktdk1keta1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjkzktourokunm1 = new ExDBFieldString<>("ztykjkzktourokunm1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzktourokunm1 = new ExDBFieldString<>("ztykzktourokunm1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztytrkkzktdk2keta1 = new ExDBFieldString<>("ztytrkkzktdk2keta1", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykjkzktourokunm2 = new ExDBFieldString<>("ztykjkzktourokunm2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzktourokunm2 = new ExDBFieldString<>("ztykzktourokunm2", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyyakkanjyuryouhoukbn = new ExDBFieldString<>("ztyyakkanjyuryouhoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyyakkanbunsyono = new ExDBFieldString<>("ztyyakkanbunsyono", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztykzktuutityokusoukbn = new ExDBFieldString<>("ztykzktuutityokusoukbn", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyyobiv250 = new ExDBFieldString<>("ztyyobiv250", this);

    public final ExDBFieldString<ZT_HonsyaToukeiTy, String> ztyyobiv27 = new ExDBFieldString<>("ztyyobiv27", this);
}
