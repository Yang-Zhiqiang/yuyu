package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RrtHndugtHknVKnsyuyuTy extends AbstractExDBTable<ZT_RrtHndugtHknVKnsyuyuTy> {

    public GenQZT_RrtHndugtHknVKnsyuyuTy() {
        this("ZT_RrtHndugtHknVKnsyuyuTy");
    }

    public GenQZT_RrtHndugtHknVKnsyuyuTy(String pAlias) {
        super("ZT_RrtHndugtHknVKnsyuyuTy", ZT_RrtHndugtHknVKnsyuyuTy.class, pAlias);
    }

    public String ZT_RrtHndugtHknVKnsyuyuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysuuriyouyobin4 = new ExDBFieldString<>("ztysuuriyouyobin4", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysuuriyouyobin6x2 = new ExDBFieldString<>("ztysuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysyokainyknjikawasekjnymd = new ExDBFieldString<>("ztysyokainyknjikawasekjnymd", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysuuriyouyobin6x3 = new ExDBFieldString<>("ztysuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztykimatukawaserate = new ExDBFieldString<>("ztykimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5 = new ExDBFieldString<>("ztyyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x2 = new ExDBFieldString<>("ztyyoteiriritun5x2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x3 = new ExDBFieldString<>("ztyyoteiriritun5x3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x4 = new ExDBFieldString<>("ztyyoteiriritun5x4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x5 = new ExDBFieldString<>("ztyyoteiriritun5x5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x6 = new ExDBFieldString<>("ztyyoteiriritun5x6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x7 = new ExDBFieldString<>("ztyyoteiriritun5x7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x8 = new ExDBFieldString<>("ztyyoteiriritun5x8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x9 = new ExDBFieldString<>("ztyyoteiriritun5x9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x10 = new ExDBFieldString<>("ztyyoteiriritun5x10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x11 = new ExDBFieldString<>("ztyyoteiriritun5x11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x12 = new ExDBFieldString<>("ztyyoteiriritun5x12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x13 = new ExDBFieldString<>("ztyyoteiriritun5x13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x14 = new ExDBFieldString<>("ztyyoteiriritun5x14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x15 = new ExDBFieldString<>("ztyyoteiriritun5x15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, BizNumber> ztyyoteiriritun5x16 = new ExDBFieldString<>("ztyyoteiriritun5x16", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekin = new ExDBFieldNumber<>("ztyptumitatekin", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx2 = new ExDBFieldNumber<>("ztyptumitatekinx2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx3 = new ExDBFieldNumber<>("ztyptumitatekinx3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx4 = new ExDBFieldNumber<>("ztyptumitatekinx4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx5 = new ExDBFieldNumber<>("ztyptumitatekinx5", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx6 = new ExDBFieldNumber<>("ztyptumitatekinx6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx7 = new ExDBFieldNumber<>("ztyptumitatekinx7", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx8 = new ExDBFieldNumber<>("ztyptumitatekinx8", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx9 = new ExDBFieldNumber<>("ztyptumitatekinx9", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx10 = new ExDBFieldNumber<>("ztyptumitatekinx10", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx11 = new ExDBFieldNumber<>("ztyptumitatekinx11", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx12 = new ExDBFieldNumber<>("ztyptumitatekinx12", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx13 = new ExDBFieldNumber<>("ztyptumitatekinx13", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx14 = new ExDBFieldNumber<>("ztyptumitatekinx14", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx15 = new ExDBFieldNumber<>("ztyptumitatekinx15", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyptumitatekinx16 = new ExDBFieldNumber<>("ztyptumitatekinx16", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx2 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx3 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx4 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx5 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx5", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx6 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx6", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx7 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx7", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx8 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx8", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx9 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx9", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx10 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx10", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx11 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx11", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx12 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx12", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx13 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx13", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx14 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx14", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx15 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx15", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztygaikadatejyuutoupx16 = new ExDBFieldNumber<>("ztygaikadatejyuutoupx16", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysykykkitmttvkeisanym1 = new ExDBFieldString<>("ztysykykkitmttvkeisanym1", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztysykykkitmttv1 = new ExDBFieldNumber<>("ztysykykkitmttv1", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysykykkitmttvkeisanym2 = new ExDBFieldString<>("ztysykykkitmttvkeisanym2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztysykykkitmttv2 = new ExDBFieldNumber<>("ztysykykkitmttv2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_RrtHndugtHknVKnsyuyuTy, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ZT_RrtHndugtHknVKnsyuyuTy, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);
}
