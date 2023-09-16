package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RrtHndugtHknKsnJigyohiRn extends AbstractExDBTable<ZT_RrtHndugtHknKsnJigyohiRn> {

    public GenQZT_RrtHndugtHknKsnJigyohiRn() {
        this("ZT_RrtHndugtHknKsnJigyohiRn");
    }

    public GenQZT_RrtHndugtHknKsnJigyohiRn(String pAlias) {
        super("ZT_RrtHndugtHknKsnJigyohiRn", ZT_RrtHndugtHknKsnJigyohiRn.class, pAlias);
    }

    public String ZT_RrtHndugtHknKsnJigyohiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuuriyoupjytouym = new ExDBFieldString<>("zrnsuuriyoupjytouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsihankibikinkbn = new ExDBFieldString<>("zrnsihankibikinkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkykymdmaekykhyj = new ExDBFieldString<>("zrnkykymdmaekykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkarikasikbn = new ExDBFieldString<>("zrnkarikasikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkyksyoumetuzumihyouji = new ExDBFieldString<>("zrnkyksyoumetuzumihyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhosyoukinoukbn = new ExDBFieldString<>("zrnhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrndaikbn = new ExDBFieldString<>("zrndaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrntyuukbn = new ExDBFieldString<>("zrntyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsyoukbn = new ExDBFieldString<>("zrnsyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsedaikbn = new ExDBFieldString<>("zrnsedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnalmyousohutomeisyoukbn = new ExDBFieldString<>("zrnalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsnkyksoftmeisyoukbn = new ExDBFieldString<>("zrnsnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsoftmeisyoukbn = new ExDBFieldString<>("zrnsoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnnenkingatakbn = new ExDBFieldString<>("zrnnenkingatakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnsuuriyouyobin8x2 = new ExDBFieldString<>("zrnsuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnpjuutoujikawaserate = new ExDBFieldString<>("zrnpjuutoujikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnpjuutoujikawasekijyunymd = new ExDBFieldString<>("zrnpjuutoujikawasekijyunymd", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrngessitumitatekin = new ExDBFieldNumber<>("zrngessitumitatekin", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnyoteiriritun5 = new ExDBFieldString<>("zrnyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrngaikadatetougetujuutoup = new ExDBFieldNumber<>("zrngaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnkeisanhanteiyoutmttkn = new ExDBFieldNumber<>("zrnkeisanhanteiyoutmttkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnzettaisibouritu = new ExDBFieldString<>("zrnzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnsoutaisibouritu = new ExDBFieldString<>("zrnsoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnsoutaikaiyakuritu = new ExDBFieldString<>("zrnsoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnvhireilritu = new ExDBFieldString<>("zrnvhireilritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnyobin13 = new ExDBFieldNumber<>("zrnyobin13", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnphireilwrbkritu = new ExDBFieldString<>("zrnphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrngetumatutumitatekin = new ExDBFieldNumber<>("zrngetumatutumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrnzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("zrnzennoujiikkatubaraijytgk", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknKsnJigyohiRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnphireialpha = new ExDBFieldString<>("zrnphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnphireibeta = new ExDBFieldString<>("zrnphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnphireiganma = new ExDBFieldString<>("zrnphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknKsnJigyohiRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);
}
