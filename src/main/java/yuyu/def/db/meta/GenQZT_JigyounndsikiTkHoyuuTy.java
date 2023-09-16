package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 事業年度式特約保有Fテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_JigyounndsikiTkHoyuuTy extends AbstractExDBTable<ZT_JigyounndsikiTkHoyuuTy> {

    public GenQZT_JigyounndsikiTkHoyuuTy() {
        this("ZT_JigyounndsikiTkHoyuuTy");
    }

    public GenQZT_JigyounndsikiTkHoyuuTy(String pAlias) {
        super("ZT_JigyounndsikiTkHoyuuTy", ZT_JigyounndsikiTkHoyuuTy.class, pAlias);
    }

    public String ZT_JigyounndsikiTkHoyuuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyyobiv12 = new ExDBFieldString<>("ztyyobiv12", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysuuriyoutokuyakukbn = new ExDBFieldString<>("ztysuuriyoutokuyakukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuyakugatakbn = new ExDBFieldString<>("ztytokuyakugatakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuyakukisi = new ExDBFieldString<>("ztytokuyakukisi", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysisyacd = new ExDBFieldString<>("ztysisyacd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysibucd = new ExDBFieldString<>("ztysibucd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhhknhnsktodouhukencd = new ExDBFieldString<>("ztyhhknhnsktodouhukencd", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Integer> ztytokuyakus = new ExDBFieldNumber<>("ztytokuyakus", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysinkeityuutokbn = new ExDBFieldString<>("ztysinkeityuutokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysyukeiyakusrank = new ExDBFieldString<>("ztysyukeiyakusrank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysyukeiyakuprank = new ExDBFieldString<>("ztysyukeiyakuprank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysyukeiyakukykjigyouy = new ExDBFieldString<>("ztysyukeiyakukykjigyouy", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztymaruteiskeijihukahyj = new ExDBFieldString<>("ztymaruteiskeijihukahyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuyakutokujyoukbn = new ExDBFieldString<>("ztytokuyakutokujyoukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydai2maruhihyj = new ExDBFieldString<>("ztydai2maruhihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuteijyuusitusetkbn = new ExDBFieldString<>("ztytokuteijyuusitusetkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykusnmesyokaipjyuutouym = new ExDBFieldString<>("ztykusnmesyokaipjyuutouym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysaigaitkyksyokusyucd = new ExDBFieldString<>("ztysaigaitkyksyokusyucd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztygassansrank = new ExDBFieldString<>("ztygassansrank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytoliplhyj = new ExDBFieldString<>("ztytoliplhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuyakusedaikbn = new ExDBFieldString<>("ztytokuyakusedaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysiharainissuukbn = new ExDBFieldString<>("ztysiharainissuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykakuseikatakbn = new ExDBFieldString<>("ztykakuseikatakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztybosyuukeirokbn = new ExDBFieldString<>("ztybosyuukeirokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydantaicd = new ExDBFieldString<>("ztydantaicd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztypmenhutanpohyj = new ExDBFieldString<>("ztypmenhutanpohyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytenkanhosyouminaosikbn = new ExDBFieldString<>("ztytenkanhosyouminaosikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhosyouminaosikaisuu = new ExDBFieldString<>("ztyhosyouminaosikaisuu", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyqpackhyj = new ExDBFieldString<>("ztyqpackhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztybunkatukbn = new ExDBFieldString<>("ztybunkatukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhosyoukikankbn = new ExDBFieldString<>("ztyhosyoukikankbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuyakukikan = new ExDBFieldString<>("ztytokuyakukikan", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztymannenreihyj = new ExDBFieldString<>("ztymannenreihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyhokenhoutekiyouhyouji = new ExDBFieldString<>("ztyhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyrendouyousntkjyubbnhyj = new ExDBFieldString<>("ztyrendouyousntkjyubbnhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysuuriyouyobin4 = new ExDBFieldString<>("ztysuuriyouyobin4", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztygaikadatetokuyakus = new ExDBFieldNumber<>("ztygaikadatetokuyakus", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztygaikadatesyukeiyakus = new ExDBFieldNumber<>("ztygaikadatesyukeiyakus", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuTy, String> ztyyobiv10x3 = new ExDBFieldString<>("ztyyobiv10x3", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);
}
