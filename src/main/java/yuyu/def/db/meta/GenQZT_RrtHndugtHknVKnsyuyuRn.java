package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RrtHndugtHknVKnsyuyuRn extends AbstractExDBTable<ZT_RrtHndugtHknVKnsyuyuRn> {

    public GenQZT_RrtHndugtHknVKnsyuyuRn() {
        this("ZT_RrtHndugtHknVKnsyuyuRn");
    }

    public GenQZT_RrtHndugtHknVKnsyuyuRn(String pAlias) {
        super("ZT_RrtHndugtHknVKnsyuyuRn", ZT_RrtHndugtHknVKnsyuyuRn.class, pAlias);
    }

    public String ZT_RrtHndugtHknVKnsyuyuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsuuriyouyobin4 = new ExDBFieldString<>("zrnsuuriyouyobin4", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsuuriyouyobin6x2 = new ExDBFieldString<>("zrnsuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnjikaipjyuutouym2 = new ExDBFieldString<>("zrnjikaipjyuutouym2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsyokainyknjikawasekjnymd = new ExDBFieldString<>("zrnsyokainyknjikawasekjnymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsuuriyouyobin6x3 = new ExDBFieldString<>("zrnsuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnkimatukawaserate = new ExDBFieldString<>("zrnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5 = new ExDBFieldString<>("zrnyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x2 = new ExDBFieldString<>("zrnyoteiriritun5x2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x3 = new ExDBFieldString<>("zrnyoteiriritun5x3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x4 = new ExDBFieldString<>("zrnyoteiriritun5x4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x5 = new ExDBFieldString<>("zrnyoteiriritun5x5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x6 = new ExDBFieldString<>("zrnyoteiriritun5x6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x7 = new ExDBFieldString<>("zrnyoteiriritun5x7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x8 = new ExDBFieldString<>("zrnyoteiriritun5x8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x9 = new ExDBFieldString<>("zrnyoteiriritun5x9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x10 = new ExDBFieldString<>("zrnyoteiriritun5x10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x11 = new ExDBFieldString<>("zrnyoteiriritun5x11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x12 = new ExDBFieldString<>("zrnyoteiriritun5x12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x13 = new ExDBFieldString<>("zrnyoteiriritun5x13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x14 = new ExDBFieldString<>("zrnyoteiriritun5x14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x15 = new ExDBFieldString<>("zrnyoteiriritun5x15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, BizNumber> zrnyoteiriritun5x16 = new ExDBFieldString<>("zrnyoteiriritun5x16", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekin = new ExDBFieldNumber<>("zrnptumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx2 = new ExDBFieldNumber<>("zrnptumitatekinx2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx3 = new ExDBFieldNumber<>("zrnptumitatekinx3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx4 = new ExDBFieldNumber<>("zrnptumitatekinx4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx5 = new ExDBFieldNumber<>("zrnptumitatekinx5", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx6 = new ExDBFieldNumber<>("zrnptumitatekinx6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx7 = new ExDBFieldNumber<>("zrnptumitatekinx7", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx8 = new ExDBFieldNumber<>("zrnptumitatekinx8", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx9 = new ExDBFieldNumber<>("zrnptumitatekinx9", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx10 = new ExDBFieldNumber<>("zrnptumitatekinx10", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx11 = new ExDBFieldNumber<>("zrnptumitatekinx11", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx12 = new ExDBFieldNumber<>("zrnptumitatekinx12", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx13 = new ExDBFieldNumber<>("zrnptumitatekinx13", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx14 = new ExDBFieldNumber<>("zrnptumitatekinx14", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx15 = new ExDBFieldNumber<>("zrnptumitatekinx15", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnptumitatekinx16 = new ExDBFieldNumber<>("zrnptumitatekinx16", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoup = new ExDBFieldNumber<>("zrngaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx2 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx3 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx4 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx5 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx5", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx6 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx7 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx7", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx8 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx8", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx9 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx9", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx10 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx10", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx11 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx11", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx12 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx12", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx13 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx13", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx14 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx14", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx15 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx15", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrngaikadatejyuutoupx16 = new ExDBFieldNumber<>("zrngaikadatejyuutoupx16", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsykykkitmttvkeisanym1 = new ExDBFieldString<>("zrnsykykkitmttvkeisanym1", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnsykykkitmttv1 = new ExDBFieldNumber<>("zrnsykykkitmttv1", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsykykkitmttvkeisanym2 = new ExDBFieldString<>("zrnsykykkitmttvkeisanym2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnsykykkitmttv2 = new ExDBFieldNumber<>("zrnsykykkitmttv2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuRn, Long> zrnrrthnduhknvkiso = new ExDBFieldNumber<>("zrnrrthnduhknvkiso", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);
}
