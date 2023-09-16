package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitKtyTy;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitKtyTy extends AbstractExDBTable<ZT_NkHitKtyTy> {

    public GenQZT_NkHitKtyTy() {
        this("ZT_NkHitKtyTy");
    }

    public GenQZT_NkHitKtyTy(String pAlias) {
        super("ZT_NkHitKtyTy", ZT_NkHitKtyTy.class, pAlias);
    }

    public String ZT_NkHitKtyTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztynenkintypekbn = new ExDBFieldString<>("ztynenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztynenkinitijisiharainendo = new ExDBFieldString<>("ztynenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztymanryoukbn = new ExDBFieldString<>("ztymanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyseizonkbn = new ExDBFieldString<>("ztyseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztyyoteiriritun5 = new ExDBFieldNumber<>("ztyyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> zty5nngt3nngtoutubkbn = new ExDBFieldString<>("zty5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykeiyakuoutoubikbn = new ExDBFieldString<>("ztykeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv15 = new ExDBFieldString<>("ztyyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztygyousekihyoujisibous = new ExDBFieldNumber<>("ztygyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztytounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("ztytounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztywarihurigakurisoku1 = new ExDBFieldNumber<>("ztywarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztywarihurigakurisoku2 = new ExDBFieldNumber<>("ztywarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztyyokunendosyoyougakuyou = new ExDBFieldNumber<>("ztyyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztyyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("ztyyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztyyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("ztyyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztysyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztysyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztyrisadtaisyouv = new ExDBFieldNumber<>("ztyrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztynknengk = new ExDBFieldNumber<>("ztynknengk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztysyukeiyakunenkinnengaku = new ExDBFieldNumber<>("ztysyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztykaimasinenkinnengaku = new ExDBFieldNumber<>("ztykaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv38 = new ExDBFieldString<>("ztyyobiv38", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztykeisankijyunymd = new ExDBFieldString<>("ztykeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztytoujigyounendo = new ExDBFieldString<>("ztytoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyokujigyounendo = new ExDBFieldString<>("ztyyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyokuyokujigyounendo = new ExDBFieldString<>("ztyyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztytounendseisikiwariatehyj = new ExDBFieldString<>("ztytounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyknndseisikiwariatehyj = new ExDBFieldString<>("ztyyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyznnndseisikiwratehyj = new ExDBFieldString<>("ztyznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztytounendodhaneizumihyouji = new ExDBFieldString<>("ztytounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Long> ztytounendooutoubijitend = new ExDBFieldNumber<>("ztytounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztytunndoutubikutunndmtrrt = new ExDBFieldNumber<>("ztytunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztytunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("ztytunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztyyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("ztyyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztyznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztyznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztyktyumtikutunndoutubrrt = new ExDBFieldNumber<>("ztyktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztytunndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztytunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyTy, Double> ztyktyumtikutunndmtrrt = new ExDBFieldNumber<>("ztyktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitKtyTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);
}
