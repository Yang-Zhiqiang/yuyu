package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitKsnTy;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitKsnTy extends AbstractExDBTable<ZT_NkHitKsnTy> {

    public GenQZT_NkHitKsnTy() {
        this("ZT_NkHitKsnTy");
    }

    public GenQZT_NkHitKsnTy(String pAlias) {
        super("ZT_NkHitKsnTy", ZT_NkHitKsnTy.class, pAlias);
    }

    public String ZT_NkHitKsnTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztynenkintypekbn = new ExDBFieldString<>("ztynenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztynenkinitijisiharainendo = new ExDBFieldString<>("ztynenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztymanryoukbn = new ExDBFieldString<>("ztymanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyseizonkbn = new ExDBFieldString<>("ztyseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztyyoteiriritun5 = new ExDBFieldNumber<>("ztyyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> zty5nngt3nngtoutubkbn = new ExDBFieldString<>("zty5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykeiyakuoutoubikbn = new ExDBFieldString<>("ztykeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv15 = new ExDBFieldString<>("ztyyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztygyousekihyoujisibous = new ExDBFieldNumber<>("ztygyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztytounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("ztytounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztywarihurigakurisoku1 = new ExDBFieldNumber<>("ztywarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztywarihurigakurisoku2 = new ExDBFieldNumber<>("ztywarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztyyokunendosyoyougakuyou = new ExDBFieldNumber<>("ztyyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztyyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("ztyyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztyyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("ztyyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztysyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztysyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztyrisadtaisyouv = new ExDBFieldNumber<>("ztyrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztynknengk = new ExDBFieldNumber<>("ztynknengk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztysyukeiyakunenkinnengaku = new ExDBFieldNumber<>("ztysyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztykaimasinenkinnengaku = new ExDBFieldNumber<>("ztykaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv38 = new ExDBFieldString<>("ztyyobiv38", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztykeisankijyunymd = new ExDBFieldString<>("ztykeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztytoujigyounendo = new ExDBFieldString<>("ztytoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyokujigyounendo = new ExDBFieldString<>("ztyyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyokuyokujigyounendo = new ExDBFieldString<>("ztyyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztytounendseisikiwariatehyj = new ExDBFieldString<>("ztytounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyknndseisikiwariatehyj = new ExDBFieldString<>("ztyyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyznnndseisikiwratehyj = new ExDBFieldString<>("ztyznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztytounendodhaneizumihyouji = new ExDBFieldString<>("ztytounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Long> ztytounendooutoubijitend = new ExDBFieldNumber<>("ztytounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztytunndoutubikutunndmtrrt = new ExDBFieldNumber<>("ztytunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztytunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("ztytunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztyyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("ztyyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztyznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztyznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztyktyumtikutunndoutubrrt = new ExDBFieldNumber<>("ztyktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztytunndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztytunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnTy, Double> ztyktyumtikutunndmtrrt = new ExDBFieldNumber<>("ztyktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitKsnTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);
}
