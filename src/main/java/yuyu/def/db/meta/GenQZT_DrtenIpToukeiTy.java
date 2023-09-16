package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenIpToukeiTy extends AbstractExDBTable<ZT_DrtenIpToukeiTy> {

    public GenQZT_DrtenIpToukeiTy() {
        this("ZT_DrtenIpToukeiTy");
    }

    public GenQZT_DrtenIpToukeiTy(String pAlias) {
        super("ZT_DrtenIpToukeiTy", ZT_DrtenIpToukeiTy.class, pAlias);
    }

    public String ZT_DrtenIpToukeiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyeigyouhonbusisyacd = new ExDBFieldString<>("ztyeigyouhonbusisyacd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysosikicd = new ExDBFieldString<>("ztysosikicd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyatukaikojincd = new ExDBFieldString<>("ztyatukaikojincd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymosym = new ExDBFieldString<>("ztymosym", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymoskbn = new ExDBFieldString<>("ztymoskbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytansyukukjatukaisyanm = new ExDBFieldString<>("ztytansyukukjatukaisyanm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymossyoumetukbn = new ExDBFieldString<>("ztymossyoumetukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykurikosiriyuukbn = new ExDBFieldString<>("ztykurikosiriyuukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynyknzumihyouji = new ExDBFieldString<>("ztynyknzumihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytoukeihknsyruikbn = new ExDBFieldString<>("ztytoukeihknsyruikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhjykktkbn = new ExDBFieldString<>("ztyhjykktkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykykktaikbn = new ExDBFieldString<>("ztykykktaikbn", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztyjyunhsys = new ExDBFieldNumber<>("ztyjyunhsys", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Integer> ztysoukensuu = new ExDBFieldNumber<>("ztysoukensuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyketjkkbn = new ExDBFieldString<>("ztyketjkkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydakuhiktjyoutaikbn = new ExDBFieldString<>("ztydakuhiktjyoutaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykihonhubi = new ExDBFieldString<>("ztykihonhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysphubi = new ExDBFieldString<>("ztysphubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysseigenhubi = new ExDBFieldString<>("ztysseigenhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynayosehumei = new ExDBFieldString<>("ztynayosehumei", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytuusangendoover = new ExDBFieldString<>("ztytuusangendoover", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymosketteihoryuu = new ExDBFieldString<>("ztymosketteihoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykykkakjissityuu = new ExDBFieldString<>("ztykykkakjissityuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykktketteihoryuu = new ExDBFieldString<>("ztykktketteihoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhonsyakethoryuu = new ExDBFieldString<>("ztyhonsyakethoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyseiymdhubi = new ExDBFieldString<>("ztyseiymdhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyphusoku = new ExDBFieldString<>("ztyphusoku", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysrhuketyu = new ExDBFieldString<>("ztysrhuketyu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztypkakin = new ExDBFieldString<>("ztypkakin", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysakuseiymd = new ExDBFieldString<>("ztysakuseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytansyukukjhhknnm = new ExDBFieldString<>("ztytansyukukjhhknnm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhhknsykgycd = new ExDBFieldString<>("ztyhhknsykgycd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysyokaipryosyuymd = new ExDBFieldString<>("ztysyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykokutiymd = new ExDBFieldString<>("ztykokutiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymosnyuuryokuymd = new ExDBFieldString<>("ztymosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyfstpnyknsyoriymd = new ExDBFieldString<>("ztyfstpnyknsyoriymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyfstpnyknnaiyoukbn = new ExDBFieldString<>("ztyfstpnyknnaiyoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysisyaketsyoriymd = new ExDBFieldString<>("ztysisyaketsyoriymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysyosakuseiymd = new ExDBFieldString<>("ztysyosakuseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyseisekiym = new ExDBFieldString<>("ztyseisekiym", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztysyokaiharaikomip = new ExDBFieldNumber<>("ztysyokaiharaikomip", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytokusyujimutoriatukaikbn = new ExDBFieldString<>("ztytokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztybsydrtenkjnm = new ExDBFieldString<>("ztybsydrtenkjnm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyatkisyagyskkjsosikicd = new ExDBFieldString<>("ztyatkisyagyskkjsosikicd", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Integer> ztyatkisyadrtenatkiwari = new ExDBFieldNumber<>("ztyatkisyadrtenatkiwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykinyuukikancd = new ExDBFieldString<>("ztykinyuukikancd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyinfositencd = new ExDBFieldString<>("ztyinfositencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykjkyknm10 = new ExDBFieldString<>("ztykjkyknm10", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykthhbhyouji = new ExDBFieldString<>("ztykthhbhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysrhhbhyouji = new ExDBFieldString<>("ztysrhhbhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymossyumtkktymd = new ExDBFieldString<>("ztymossyumtkktymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydairitenjimusyocd = new ExDBFieldString<>("ztydairitenjimusyocd", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztytsrybnwari = new ExDBFieldNumber<>("ztytsrybnwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydrtenkeijyouym = new ExDBFieldString<>("ztydrtenkeijyouym", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykydatkidairitencd = new ExDBFieldString<>("ztykydatkidairitencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydaihyoubosyuunincd = new ExDBFieldString<>("ztydaihyoubosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytansyukukjdhybosyuunm = new ExDBFieldString<>("ztytansyukukjdhybosyuunm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyknkyknm15 = new ExDBFieldString<>("ztyknkyknm15", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydkhktiymd = new ExDBFieldString<>("ztydkhktiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhonninkknnkbn = new ExDBFieldString<>("ztyhonninkknnkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynstkarihyj = new ExDBFieldString<>("ztynstkarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynstknkkkn = new ExDBFieldString<>("ztynstknkkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydrtentsryhushrkykhyouji = new ExDBFieldString<>("ztydrtentsryhushrkykhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynyknkanskanouhyouji = new ExDBFieldString<>("ztynyknkanskanouhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydshukahyouji = new ExDBFieldString<>("ztydshukahyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydrtenpaperlessmoshyj = new ExDBFieldString<>("ztydrtenpaperlessmoshyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydrtenmostousyaukeymd = new ExDBFieldString<>("ztydrtenmostousyaukeymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykyktuuka = new ExDBFieldString<>("ztykyktuuka", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhrktuuka = new ExDBFieldString<>("ztyhrktuuka", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztysykihrkpgaika = new ExDBFieldString<>("ztysykihrkpgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyyennykntkarihyouji = new ExDBFieldString<>("ztyyennykntkarihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztygaikanykntkarihyouji = new ExDBFieldString<>("ztygaikanykntkarihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztykihonsgaika = new ExDBFieldString<>("ztykihonsgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztytekiyoukawaserate = new ExDBFieldString<>("ztytekiyoukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztymkhyoutiyensysnikoukbn = new ExDBFieldString<>("ztymkhyoutiyensysnikoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysyksbyensitihsyutkykhyj = new ExDBFieldString<>("ztysyksbyensitihsyutkykhyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyjyudkaigomehrtkarihyj = new ExDBFieldString<>("ztyjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztysykihrkpsiteituuka = new ExDBFieldString<>("ztysykihrkpsiteituuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyteirituhaibunwari = new ExDBFieldString<>("ztyteirituhaibunwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysueokikknkbn = new ExDBFieldString<>("ztysueokikknkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynksyuruikbn1 = new ExDBFieldString<>("ztynksyuruikbn1", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydairitenkbtinfo1 = new ExDBFieldString<>("ztydairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydairitenkbtinfo2 = new ExDBFieldString<>("ztydairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydairitenkbtinfo3 = new ExDBFieldString<>("ztydairitenkbtinfo3", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyyohurimiryou = new ExDBFieldString<>("ztyyohurimiryou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykznyuuryokuymd = new ExDBFieldString<>("ztykznyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysetaitemosno = new ExDBFieldString<>("ztysetaitemosno", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyyakkanjyuryouhoukbn = new ExDBFieldString<>("ztyyakkanjyuryouhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyyakkanbunsyono = new ExDBFieldString<>("ztyyakkanbunsyono", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykzhuritourokuhoukbn = new ExDBFieldString<>("ztykzhuritourokuhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztydai1hknkkn = new ExDBFieldString<>("ztydai1hknkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycreditnyuuryokuymd = new ExDBFieldString<>("ztycreditnyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycreditmiryou = new ExDBFieldString<>("ztycreditmiryou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycredittrkhoukbn = new ExDBFieldString<>("ztycredittrkhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycardbrandkbn = new ExDBFieldString<>("ztycardbrandkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztycarddatasousinymd = new ExDBFieldString<>("ztycarddatasousinymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykzktrkservicekbn = new ExDBFieldString<>("ztykzktrkservicekbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyteikisiharaiarihyj = new ExDBFieldString<>("ztyteikisiharaiarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyteikishrkinshrtuukakbn = new ExDBFieldString<>("ztyteikishrkinshrtuukakbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztyteikisiharaikin = new ExDBFieldString<>("ztyteikisiharaikin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykoureikzksetumeihoukbn = new ExDBFieldString<>("ztykoureikzksetumeihoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykoureimndnhukusuukaikbn = new ExDBFieldString<>("ztykoureimndnhukusuukaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztykoureitratkisyaigidskkbn = new ExDBFieldString<>("ztykoureitratkisyaigidskkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztynnknsnpssysyup = new ExDBFieldNumber<>("ztynnknsnpssysyup", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, BizNumber> ztynnknsnpssykwsrate = new ExDBFieldString<>("ztynnknsnpssykwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiTy, Long> ztyzennoup = new ExDBFieldNumber<>("ztyzennoup", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztynenkinzeiseitokuyakukbn = new ExDBFieldString<>("ztynenkinzeiseitokuyakukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiTy, String> ztyyobiv33 = new ExDBFieldString<>("ztyyobiv33", this);
}
