package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利率変動型保険事業費Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RrtHndugtHknJigyohiTy extends AbstractExDBTable<ZT_RrtHndugtHknJigyohiTy> {

    public GenQZT_RrtHndugtHknJigyohiTy() {
        this("ZT_RrtHndugtHknJigyohiTy");
    }

    public GenQZT_RrtHndugtHknJigyohiTy(String pAlias) {
        super("ZT_RrtHndugtHknJigyohiTy", ZT_RrtHndugtHknJigyohiTy.class, pAlias);
    }

    public String ZT_RrtHndugtHknJigyohiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuuriyoupjytouym = new ExDBFieldString<>("ztysuuriyoupjytouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykykymdmaekykhyj = new ExDBFieldString<>("ztykykymdmaekykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykarikasikbn = new ExDBFieldString<>("ztykarikasikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykyksyoumetuzumihyouji = new ExDBFieldString<>("ztykyksyoumetuzumihyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztypjuutoujikawaserate = new ExDBFieldString<>("ztypjuutoujikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztypjuutoujikawasekijyunymd = new ExDBFieldString<>("ztypjuutoujikawasekijyunymd", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyyoteiriritun5 = new ExDBFieldString<>("ztyyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyvhireilritu = new ExDBFieldString<>("ztyvhireilritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztyyobin13 = new ExDBFieldNumber<>("ztyyobin13", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztygetumatutumitatekin = new ExDBFieldNumber<>("ztygetumatutumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztyzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("ztyzennoujiikkatubaraijytgk", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknJigyohiTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknJigyohiTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);
}
