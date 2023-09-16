package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 支社統計保管テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SisyaToukeiHokan extends AbstractExDBTable<HT_SisyaToukeiHokan> {

    public GenQHT_SisyaToukeiHokan() {
        this("HT_SisyaToukeiHokan");
    }

    public GenQHT_SisyaToukeiHokan(String pAlias) {
        super("HT_SisyaToukeiHokan", HT_SisyaToukeiHokan.class, pAlias);
    }

    public String HT_SisyaToukeiHokan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosno = new ExDBFieldString<>("sstmosno", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> syrctrltblkostime = new ExDBFieldString<>("syrctrltblkostime", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsyono = new ExDBFieldString<>("sstsyono", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosym = new ExDBFieldString<>("sstmosym", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmoskbn = new ExDBFieldString<>("sstmoskbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenatkikeitaikbn = new ExDBFieldString<>("sstbosyuudrtenatkikeitaikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkydatkikbn = new ExDBFieldString<>("sstkydatkikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstatukaisyadrtenhyouji = new ExDBFieldString<>("sstatukaisyadrtenhyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssteigyouhonbusisyacd = new ExDBFieldString<>("ssteigyouhonbusisyacd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsosikicd = new ExDBFieldString<>("sstsosikicd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstatkisyagyskkjsosikicd = new ExDBFieldString<>("sstatkisyagyskkjsosikicd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcifcd = new ExDBFieldString<>("sstcifcd", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Integer> sstatkisyadrtenatkiwari = new ExDBFieldNumber<>("sstatkisyadrtenatkiwari", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> ssttsrybnwari = new ExDBFieldNumber<>("ssttsrybnwari", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstsinhsys = new ExDBFieldNumber<>("sstsinhsys", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Integer> sstsoukensuu = new ExDBFieldNumber<>("sstsoukensuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkydatkidairitencd = new ExDBFieldString<>("sstkydatkidairitencd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenkobetuinfo1 = new ExDBFieldString<>("sstbosyuudrtenkobetuinfo1", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenkobetuinfo2 = new ExDBFieldString<>("sstbosyuudrtenkobetuinfo2", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenkobetuinfo3 = new ExDBFieldString<>("sstbosyuudrtenkobetuinfo3", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenkobetuinfo4 = new ExDBFieldString<>("sstbosyuudrtenkobetuinfo4", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbosyuudrtenkobetuinfo5 = new ExDBFieldString<>("sstbosyuudrtenkobetuinfo5", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstbankkouincd = new ExDBFieldString<>("sstbankkouincd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdaihyoubosyuunincd = new ExDBFieldString<>("sstdaihyoubosyuunincd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstatukaikojincd = new ExDBFieldString<>("sstatukaikojincd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkanjihihokensyanm = new ExDBFieldString<>("sstkanjihihokensyanm", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttansyukukjhhknnm = new ExDBFieldString<>("ssttansyukukjhhknnm", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthhknsyokugyoucd = new ExDBFieldString<>("ssthhknsyokugyoucd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthhknnen2keta = new ExDBFieldString<>("ssthhknnen2keta", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthhknseikbn = new ExDBFieldString<>("ssthhknseikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthhknseiymd = new ExDBFieldString<>("ssthhknseiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkjkyknm = new ExDBFieldString<>("sstkjkyknm", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkjkyknm10 = new ExDBFieldString<>("sstkjkyknm10", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstknkyknm15 = new ExDBFieldString<>("sstknkyknm15", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstknkyknm18 = new ExDBFieldString<>("sstknkyknm18", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkyksyanen = new ExDBFieldString<>("sstkyksyanen", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkyksyaseikbn = new ExDBFieldString<>("sstkyksyaseikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthjnkykhyj = new ExDBFieldString<>("ssthjnkykhyj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkjhjnnm = new ExDBFieldString<>("sstkjhjnnm", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstseirituyoukihontikucd = new ExDBFieldString<>("sstseirituyoukihontikucd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmossyoumetukbn = new ExDBFieldString<>("sstmossyoumetukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkurikosiriyuukbn = new ExDBFieldString<>("sstkurikosiriyuukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnyknzumihyouji = new ExDBFieldString<>("sstnyknzumihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnyknjkkbn = new ExDBFieldString<>("sstnyknjkkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthoujyoukokutikbn = new ExDBFieldString<>("ssthoujyoukokutikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykkeitaikbn = new ExDBFieldString<>("sstkykkeitaikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstketteijkkbn = new ExDBFieldString<>("sstketteijkkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdakuhiketteijyoutaikbn = new ExDBFieldString<>("sstdakuhiketteijyoutaikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdakuhiketteikekkacd = new ExDBFieldString<>("sstdakuhiketteikekkacd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdakuhiketteiymd = new ExDBFieldString<>("sstdakuhiketteiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttokusyujimutoriatukaikbn = new ExDBFieldString<>("ssttokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttoukeiyousinsakbn = new ExDBFieldString<>("ssttoukeiyousinsakbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthonninkakuninkbn = new ExDBFieldString<>("ssthonninkakuninkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdrtentsryhushrkykhyouji = new ExDBFieldString<>("sstdrtentsryhushrkykhyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnyknkanskanouhyouji = new ExDBFieldString<>("sstnyknkanskanouhyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdshukahyouji = new ExDBFieldString<>("sstdshukahyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsiteidairisktkykarihyouj = new ExDBFieldString<>("sstsiteidairisktkykarihyouj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttokuteikanikokutikbn = new ExDBFieldString<>("ssttokuteikanikokutikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykkakuninsyuruikbn = new ExDBFieldString<>("sstkykkakuninsyuruikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykkakuninjkkbn1 = new ExDBFieldString<>("sstkykkakuninjkkbn1", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosketteikekkakbn = new ExDBFieldString<>("sstmosketteikekkakbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsinsazumihyouji = new ExDBFieldString<>("sstsinsazumihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstannaisakicd = new ExDBFieldString<>("sstannaisakicd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosjkkbn = new ExDBFieldString<>("sstmosjkkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkihonhubi = new ExDBFieldString<>("sstkihonhubi", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsphubi = new ExDBFieldString<>("sstsphubi", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsseigenhubi = new ExDBFieldString<>("sstsseigenhubi", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnayosehumei = new ExDBFieldString<>("sstnayosehumei", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttuusangendoover = new ExDBFieldString<>("ssttuusangendoover", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosketteihoryuu = new ExDBFieldString<>("sstmosketteihoryuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykkakuninjissityuu = new ExDBFieldString<>("sstkykkakuninjissityuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkokutiketteihoryuu = new ExDBFieldString<>("sstkokutiketteihoryuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthonsyaketteihoryuu = new ExDBFieldString<>("ssthonsyaketteihoryuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstseiymdhubi = new ExDBFieldString<>("sstseiymdhubi", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstphusoku = new ExDBFieldString<>("sstphusoku", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstseirituhoryuuuketuketyuu = new ExDBFieldString<>("sstseirituhoryuuuketuketyuu", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstpkakin = new ExDBFieldString<>("sstpkakin", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstketteihoryuuhubihyouji = new ExDBFieldString<>("sstketteihoryuuhubihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstseirituhoryuuhubihyouji = new ExDBFieldString<>("sstseirituhoryuuhubihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstyohurimiryou = new ExDBFieldString<>("sstyohurimiryou", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttoukeiyouhknsyuruikbn = new ExDBFieldString<>("ssttoukeiyouhknsyuruikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthknsyuruinm = new ExDBFieldString<>("ssthknsyuruinm", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthknkkn = new ExDBFieldString<>("ssthknkkn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstphrkkikn = new ExDBFieldString<>("sstphrkkikn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthrkkaisuukbn = new ExDBFieldString<>("ssthrkkaisuukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthrkkeirokbn = new ExDBFieldString<>("ssthrkkeirokbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnkshrtkykarihyouji = new ExDBFieldString<>("sstnkshrtkykarihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnkshrtkyknkkkn = new ExDBFieldString<>("sstnkshrtkyknkkkn", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstjyunhsys = new ExDBFieldNumber<>("sstjyunhsys", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> ssthsys = new ExDBFieldNumber<>("ssthsys", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkyktuuka = new ExDBFieldString<>("sstkyktuuka", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthrktuuka = new ExDBFieldString<>("ssthrktuuka", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssttuukatanikbn = new ExDBFieldString<>("ssttuukatanikbn", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstfstphrkgkyen = new ExDBFieldNumber<>("sstfstphrkgkyen", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstfstphrkgkhrktuukamoji = new ExDBFieldString<>("sstfstphrkgkhrktuukamoji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> sstfstphrkgkgaika = new ExDBFieldString<>("sstfstphrkgkgaika", this, BizNumberType.class);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstfstpsshkhrkgkyen = new ExDBFieldNumber<>("sstfstpsshkhrkgkyen", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstyennykntkykarihyouji = new ExDBFieldString<>("sstyennykntkykarihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstgaikanykntkykarihyouji = new ExDBFieldString<>("sstgaikanykntkykarihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssyenshrtkykarihyouji = new ExDBFieldString<>("ssyenshrtkykarihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> sstkihonsgaika = new ExDBFieldString<>("sstkihonsgaika", this, BizNumberType.class);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> ssttekiyoukawaserate = new ExDBFieldString<>("ssttekiyoukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkawaseratetekiyouymd = new ExDBFieldString<>("sstkawaseratetekiyouymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsakuseiymd = new ExDBFieldString<>("sstsakuseiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosymd = new ExDBFieldString<>("sstmosymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkokutiymd = new ExDBFieldString<>("sstkokutiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosnyuuryokuymd = new ExDBFieldString<>("sstmosnyuuryokuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkouzanyuuryokuymd = new ExDBFieldString<>("sstkouzanyuuryokuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykymd = new ExDBFieldString<>("sstkykymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsekininkaisiymd = new ExDBFieldString<>("sstsekininkaisiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsisyaketteisyoriymd = new ExDBFieldString<>("sstsisyaketteisyoriymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsyoukensakuseiymd = new ExDBFieldString<>("sstsyoukensakuseiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstseisekikijyym = new ExDBFieldString<>("sstseisekikijyym", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmossyoumetukakuteiymd = new ExDBFieldString<>("sstmossyoumetukakuteiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdrtenkeijyouym = new ExDBFieldString<>("sstdrtenkeijyouym", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmostoutyakuymd = new ExDBFieldString<>("sstmostoutyakuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkkttoutyakuymd = new ExDBFieldString<>("sstkkttoutyakuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmossakuseiymd = new ExDBFieldString<>("sstmossakuseiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmosksnym = new ExDBFieldString<>("sstmosksnym", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkariseirituymd = new ExDBFieldString<>("sstkariseirituymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsinsayoteiymd = new ExDBFieldString<>("sstsinsayoteiymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkousinymd = new ExDBFieldString<>("sstkousinymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstryousyuuymd = new ExDBFieldString<>("sstryousyuuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstfstpryousyuuymd = new ExDBFieldString<>("sstfstpryousyuuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstfstpnyknsyoriymd = new ExDBFieldString<>("sstfstpnyknsyoriymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstfstpnyknnaiyoukbn = new ExDBFieldString<>("sstfstpnyknnaiyoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstfstpnyknhouhoukbn2 = new ExDBFieldString<>("sstfstpnyknhouhoukbn2", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdrtenpaperlessmoshyj = new ExDBFieldString<>("sstdrtenpaperlessmoshyj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdrtenmostousyaukeymd = new ExDBFieldString<>("sstdrtenmostousyaukeymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstmkhyoutiyensysnikoukbn = new ExDBFieldString<>("sstmkhyoutiyensysnikoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsyksbyensitihsyutkykhyj = new ExDBFieldString<>("sstsyksbyensitihsyutkykhyj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstjyudkaigomehrtkarihyj = new ExDBFieldString<>("sstjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> sstfstphrkgksiteituuka = new ExDBFieldString<>("sstfstphrkgksiteituuka", this, BizNumberType.class);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstteirituhaibunwari = new ExDBFieldString<>("sstteirituhaibunwari", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsueokikknkbn = new ExDBFieldString<>("sstsueokikknkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnksyuruikbn1 = new ExDBFieldString<>("sstnksyuruikbn1", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsetaitemosno = new ExDBFieldString<>("sstsetaitemosno", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstyakkanjyuryouhoukbn = new ExDBFieldString<>("sstyakkanjyuryouhoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstyakkanbunsyono = new ExDBFieldString<>("sstyakkanbunsyono", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkzhuritourokuhoukbn = new ExDBFieldString<>("sstkzhuritourokuhoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstdai1hknkkn = new ExDBFieldString<>("sstdai1hknkkn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcreditnyuuryokuymd = new ExDBFieldString<>("sstcreditnyuuryokuymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcreditmiryou = new ExDBFieldString<>("sstcreditmiryou", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcredittrkhoukbn = new ExDBFieldString<>("sstcredittrkhoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcardbrandkbn = new ExDBFieldString<>("sstcardbrandkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstcarddatasousinymd = new ExDBFieldString<>("sstcarddatasousinymd", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkzktrkservicekbn = new ExDBFieldString<>("sstkzktrkservicekbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkykdrtkykarihyj = new ExDBFieldString<>("sstkykdrtkykarihyj", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstteikishrtkykarihyouji = new ExDBFieldString<>("sstteikishrtkykarihyouji", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstteikishrkinshrtuukakbn = new ExDBFieldString<>("sstteikishrkinshrtuukakbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> sstteikisiharaikin = new ExDBFieldString<>("sstteikisiharaikin", this, BizNumberType.class);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkoureikzksetumeihoukbn = new ExDBFieldString<>("sstkoureikzksetumeihoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkoureimndnhukusuukaikbn = new ExDBFieldString<>("sstkoureimndnhukusuukaikbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkoureitratkisyaigidskkbn = new ExDBFieldString<>("sstkoureitratkisyaigidskkbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> ssthknsyukigou = new ExDBFieldString<>("ssthknsyukigou", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstsaimnkkykhyj = new ExDBFieldString<>("sstsaimnkkykhyj", this);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstnnknsnpssysyup = new ExDBFieldNumber<>("sstnnknsnpssysyup", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, BizNumber> sstnnknsnpssykwsrate = new ExDBFieldString<>("sstnnknsnpssykwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<HT_SisyaToukeiHokan, Long> sstzennoup = new ExDBFieldNumber<>("sstzennoup", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstkzktuutityokusoukbn = new ExDBFieldString<>("sstkzktuutityokusoukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> sstnenkinzeiseitokuyakukbn = new ExDBFieldString<>("sstnenkinzeiseitokuyakukbn", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SisyaToukeiHokan, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
