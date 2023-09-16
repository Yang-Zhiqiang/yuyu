package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 事業年度式特約保有Fテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_JigyounndsikiTkHoyuuRn extends AbstractExDBTable<ZT_JigyounndsikiTkHoyuuRn> {

    public GenQZT_JigyounndsikiTkHoyuuRn() {
        this("ZT_JigyounndsikiTkHoyuuRn");
    }

    public GenQZT_JigyounndsikiTkHoyuuRn(String pAlias) {
        super("ZT_JigyounndsikiTkHoyuuRn", ZT_JigyounndsikiTkHoyuuRn.class, pAlias);
    }

    public String ZT_JigyounndsikiTkHoyuuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsuuriyoutokuyakukbn = new ExDBFieldString<>("zrnsuuriyoutokuyakukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuyakugatakbn = new ExDBFieldString<>("zrntokuyakugatakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuyakukisi = new ExDBFieldString<>("zrntokuyakukisi", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsisyacd = new ExDBFieldString<>("zrnsisyacd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsibucd = new ExDBFieldString<>("zrnsibucd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhhknhnsktodouhukencd = new ExDBFieldString<>("zrnhhknhnsktodouhukencd", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Integer> zrntokuyakus = new ExDBFieldNumber<>("zrntokuyakus", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsinkeityuutokbn = new ExDBFieldString<>("zrnsinkeityuutokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsyukeiyakusrank = new ExDBFieldString<>("zrnsyukeiyakusrank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsyukeiyakuprank = new ExDBFieldString<>("zrnsyukeiyakuprank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsyukeiyakukykjigyouy = new ExDBFieldString<>("zrnsyukeiyakukykjigyouy", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnmaruteiskeijihukahyj = new ExDBFieldString<>("zrnmaruteiskeijihukahyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuyakutokujyoukbn = new ExDBFieldString<>("zrntokuyakutokujyoukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndai2maruhihyj = new ExDBFieldString<>("zrndai2maruhihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuteijyuusitusetkbn = new ExDBFieldString<>("zrntokuteijyuusitusetkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkusnmesyokaipjyuutouym = new ExDBFieldString<>("zrnkusnmesyokaipjyuutouym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsaigaitkyksyokusyucd = new ExDBFieldString<>("zrnsaigaitkyksyokusyucd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrngassansrank = new ExDBFieldString<>("zrngassansrank", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntoliplhyj = new ExDBFieldString<>("zrntoliplhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuyakusedaikbn = new ExDBFieldString<>("zrntokuyakusedaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsiharainissuukbn = new ExDBFieldString<>("zrnsiharainissuukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkakuseikatakbn = new ExDBFieldString<>("zrnkakuseikatakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnbosyuukeirokbn = new ExDBFieldString<>("zrnbosyuukeirokbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndantaicd = new ExDBFieldString<>("zrndantaicd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnpmenhutanpohyj = new ExDBFieldString<>("zrnpmenhutanpohyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntenkanhosyouminaosikbn = new ExDBFieldString<>("zrntenkanhosyouminaosikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhosyouminaosikaisuu = new ExDBFieldString<>("zrnhosyouminaosikaisuu", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnqpackhyj = new ExDBFieldString<>("zrnqpackhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnbunkatukbn = new ExDBFieldString<>("zrnbunkatukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhosyoukikankbn = new ExDBFieldString<>("zrnhosyoukikankbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuyakukikan = new ExDBFieldString<>("zrntokuyakukikan", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnmannenreihyj = new ExDBFieldString<>("zrnmannenreihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnhokenhoutekiyouhyouji = new ExDBFieldString<>("zrnhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnrendouyousntkjyubbnhyj = new ExDBFieldString<>("zrnrendouyousntkjyubbnhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsuuriyouyobin4 = new ExDBFieldString<>("zrnsuuriyouyobin4", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrngaikadatetokuyakus = new ExDBFieldNumber<>("zrngaikadatetokuyakus", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrngaikadatesyukeiyakus = new ExDBFieldNumber<>("zrngaikadatesyukeiyakus", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_JigyounndsikiTkHoyuuRn, String> zrnyobiv10x3 = new ExDBFieldString<>("zrnyobiv10x3", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_JigyounndsikiTkHoyuuRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);
}
