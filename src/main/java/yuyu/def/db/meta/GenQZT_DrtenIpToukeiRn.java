package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenIpToukeiRn extends AbstractExDBTable<ZT_DrtenIpToukeiRn> {

    public GenQZT_DrtenIpToukeiRn() {
        this("ZT_DrtenIpToukeiRn");
    }

    public GenQZT_DrtenIpToukeiRn(String pAlias) {
        super("ZT_DrtenIpToukeiRn", ZT_DrtenIpToukeiRn.class, pAlias);
    }

    public String ZT_DrtenIpToukeiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrneigyouhonbusisyacd = new ExDBFieldString<>("zrneigyouhonbusisyacd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsosikicd = new ExDBFieldString<>("zrnsosikicd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnatukaikojincd = new ExDBFieldString<>("zrnatukaikojincd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmosym = new ExDBFieldString<>("zrnmosym", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmoskbn = new ExDBFieldString<>("zrnmoskbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntansyukukjatukaisyanm = new ExDBFieldString<>("zrntansyukukjatukaisyanm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmossyoumetukbn = new ExDBFieldString<>("zrnmossyoumetukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkurikosiriyuukbn = new ExDBFieldString<>("zrnkurikosiriyuukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnyknzumihyouji = new ExDBFieldString<>("zrnnyknzumihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntoukeihknsyruikbn = new ExDBFieldString<>("zrntoukeihknsyruikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhjykktkbn = new ExDBFieldString<>("zrnhjykktkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkykktaikbn = new ExDBFieldString<>("zrnkykktaikbn", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrnjyunhsys = new ExDBFieldNumber<>("zrnjyunhsys", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Integer> zrnsoukensuu = new ExDBFieldNumber<>("zrnsoukensuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnketjkkbn = new ExDBFieldString<>("zrnketjkkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndakuhiktjyoutaikbn = new ExDBFieldString<>("zrndakuhiktjyoutaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkihonhubi = new ExDBFieldString<>("zrnkihonhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsphubi = new ExDBFieldString<>("zrnsphubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsseigenhubi = new ExDBFieldString<>("zrnsseigenhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnayosehumei = new ExDBFieldString<>("zrnnayosehumei", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntuusangendoover = new ExDBFieldString<>("zrntuusangendoover", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmosketteihoryuu = new ExDBFieldString<>("zrnmosketteihoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkykkakjissityuu = new ExDBFieldString<>("zrnkykkakjissityuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkktketteihoryuu = new ExDBFieldString<>("zrnkktketteihoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhonsyakethoryuu = new ExDBFieldString<>("zrnhonsyakethoryuu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnseiymdhubi = new ExDBFieldString<>("zrnseiymdhubi", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnphusoku = new ExDBFieldString<>("zrnphusoku", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsrhuketyu = new ExDBFieldString<>("zrnsrhuketyu", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnpkakin = new ExDBFieldString<>("zrnpkakin", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsakuseiymd = new ExDBFieldString<>("zrnsakuseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntansyukukjhhknnm = new ExDBFieldString<>("zrntansyukukjhhknnm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhhknsykgycd = new ExDBFieldString<>("zrnhhknsykgycd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsyokaipryosyuymd = new ExDBFieldString<>("zrnsyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkokutiymd = new ExDBFieldString<>("zrnkokutiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmosnyuuryokuymd = new ExDBFieldString<>("zrnmosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnfstpnyknsyoriymd = new ExDBFieldString<>("zrnfstpnyknsyoriymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnfstpnyknnaiyoukbn = new ExDBFieldString<>("zrnfstpnyknnaiyoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsisyaketsyoriymd = new ExDBFieldString<>("zrnsisyaketsyoriymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsyosakuseiymd = new ExDBFieldString<>("zrnsyosakuseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnseisekiym = new ExDBFieldString<>("zrnseisekiym", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrnsyokaiharaikomip = new ExDBFieldNumber<>("zrnsyokaiharaikomip", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntokusyujimutoriatukaikbn = new ExDBFieldString<>("zrntokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnbsydrtenkjnm = new ExDBFieldString<>("zrnbsydrtenkjnm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnatkisyagyskkjsosikicd = new ExDBFieldString<>("zrnatkisyagyskkjsosikicd", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Integer> zrnatkisyadrtenatkiwari = new ExDBFieldNumber<>("zrnatkisyadrtenatkiwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrninfositencd = new ExDBFieldString<>("zrninfositencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkjkyknm10 = new ExDBFieldString<>("zrnkjkyknm10", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkthhbhyouji = new ExDBFieldString<>("zrnkthhbhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsrhhbhyouji = new ExDBFieldString<>("zrnsrhhbhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmossyumtkktymd = new ExDBFieldString<>("zrnmossyumtkktymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndairitenjimusyocd = new ExDBFieldString<>("zrndairitenjimusyocd", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrntsrybnwari = new ExDBFieldNumber<>("zrntsrybnwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndrtenkeijyouym = new ExDBFieldString<>("zrndrtenkeijyouym", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkydatkidairitencd = new ExDBFieldString<>("zrnkydatkidairitencd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndaihyoubosyuunincd = new ExDBFieldString<>("zrndaihyoubosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntansyukukjdhybosyuunm = new ExDBFieldString<>("zrntansyukukjdhybosyuunm", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnknkyknm15 = new ExDBFieldString<>("zrnknkyknm15", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndkhktiymd = new ExDBFieldString<>("zrndkhktiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhonninkknnkbn = new ExDBFieldString<>("zrnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnstkarihyj = new ExDBFieldString<>("zrnnstkarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnstknkkkn = new ExDBFieldString<>("zrnnstknkkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndrtentsryhushrkykhyouji = new ExDBFieldString<>("zrndrtentsryhushrkykhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnyknkanskanouhyouji = new ExDBFieldString<>("zrnnyknkanskanouhyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndshukahyouji = new ExDBFieldString<>("zrndshukahyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndrtenpaperlessmoshyj = new ExDBFieldString<>("zrndrtenpaperlessmoshyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndrtenmostousyaukeymd = new ExDBFieldString<>("zrndrtenmostousyaukeymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkyktuuka = new ExDBFieldString<>("zrnkyktuuka", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhrktuuka = new ExDBFieldString<>("zrnhrktuuka", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrnsykihrkpgaika = new ExDBFieldString<>("zrnsykihrkpgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnyennykntkarihyouji = new ExDBFieldString<>("zrnyennykntkarihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrngaikanykntkarihyouji = new ExDBFieldString<>("zrngaikanykntkarihyouji", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrnkihonsgaika = new ExDBFieldString<>("zrnkihonsgaika", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrntekiyoukawaserate = new ExDBFieldString<>("zrntekiyoukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnmkhyoutiyensysnikoukbn = new ExDBFieldString<>("zrnmkhyoutiyensysnikoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsyksbyensitihsyutkykhyj = new ExDBFieldString<>("zrnsyksbyensitihsyutkykhyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnjyudkaigomehrtkarihyj = new ExDBFieldString<>("zrnjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrnsykihrkpsiteituuka = new ExDBFieldString<>("zrnsykihrkpsiteituuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnteirituhaibunwari = new ExDBFieldString<>("zrnteirituhaibunwari", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsueokikknkbn = new ExDBFieldString<>("zrnsueokikknkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnksyuruikbn1 = new ExDBFieldString<>("zrnnksyuruikbn1", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndairitenkbtinfo1 = new ExDBFieldString<>("zrndairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndairitenkbtinfo2 = new ExDBFieldString<>("zrndairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndairitenkbtinfo3 = new ExDBFieldString<>("zrndairitenkbtinfo3", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnyohurimiryou = new ExDBFieldString<>("zrnyohurimiryou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkznyuuryokuymd = new ExDBFieldString<>("zrnkznyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsetaitemosno = new ExDBFieldString<>("zrnsetaitemosno", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnyakkanjyuryouhoukbn = new ExDBFieldString<>("zrnyakkanjyuryouhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnyakkanbunsyono = new ExDBFieldString<>("zrnyakkanbunsyono", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkzhuritourokuhoukbn = new ExDBFieldString<>("zrnkzhuritourokuhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncreditnyuuryokuymd = new ExDBFieldString<>("zrncreditnyuuryokuymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncreditmiryou = new ExDBFieldString<>("zrncreditmiryou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncredittrkhoukbn = new ExDBFieldString<>("zrncredittrkhoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncardbrandkbn = new ExDBFieldString<>("zrncardbrandkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrncarddatasousinymd = new ExDBFieldString<>("zrncarddatasousinymd", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkzktrkservicekbn = new ExDBFieldString<>("zrnkzktrkservicekbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnteikisiharaiarihyj = new ExDBFieldString<>("zrnteikisiharaiarihyj", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnteikishrkinshrtuukakbn = new ExDBFieldString<>("zrnteikishrkinshrtuukakbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrnteikisiharaikin = new ExDBFieldString<>("zrnteikisiharaikin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkoureikzksetumeihoukbn = new ExDBFieldString<>("zrnkoureikzksetumeihoukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkoureimndnhukusuukaikbn = new ExDBFieldString<>("zrnkoureimndnhukusuukaikbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnkoureitratkisyaigidskkbn = new ExDBFieldString<>("zrnkoureitratkisyaigidskkbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrnnnknsnpssysyup = new ExDBFieldNumber<>("zrnnnknsnpssysyup", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, BizNumber> zrnnnknsnpssykwsrate = new ExDBFieldString<>("zrnnnknsnpssykwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenIpToukeiRn, Long> zrnzennoup = new ExDBFieldNumber<>("zrnzennoup", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnnenkinzeiseitokuyakukbn = new ExDBFieldString<>("zrnnenkinzeiseitokuyakukbn", this);

    public final ExDBFieldString<ZT_DrtenIpToukeiRn, String> zrnyobiv33 = new ExDBFieldString<>("zrnyobiv33", this);
}
