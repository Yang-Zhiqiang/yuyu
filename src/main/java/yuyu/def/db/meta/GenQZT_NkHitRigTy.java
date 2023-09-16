package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitRigTy;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitRigTy extends AbstractExDBTable<ZT_NkHitRigTy> {

    public GenQZT_NkHitRigTy() {
        this("ZT_NkHitRigTy");
    }

    public GenQZT_NkHitRigTy(String pAlias) {
        super("ZT_NkHitRigTy", ZT_NkHitRigTy.class, pAlias);
    }

    public String ZT_NkHitRigTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztynenkintypekbn = new ExDBFieldString<>("ztynenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztynenkinitijisiharainendo = new ExDBFieldString<>("ztynenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztymanryoukbn = new ExDBFieldString<>("ztymanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyseizonkbn = new ExDBFieldString<>("ztyseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztyyoteiriritun5 = new ExDBFieldNumber<>("ztyyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> zty5nngt3nngtoutubkbn = new ExDBFieldString<>("zty5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykeiyakuoutoubikbn = new ExDBFieldString<>("ztykeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv15 = new ExDBFieldString<>("ztyyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztygyousekihyoujisibous = new ExDBFieldNumber<>("ztygyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztytounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("ztytounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztywarihurigakurisoku1 = new ExDBFieldNumber<>("ztywarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztywarihurigakurisoku2 = new ExDBFieldNumber<>("ztywarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztyyokunendosyoyougakuyou = new ExDBFieldNumber<>("ztyyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztyyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("ztyyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztyyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("ztyyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztysyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztysyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("ztysyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztyrisadtaisyouv = new ExDBFieldNumber<>("ztyrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztynknengk = new ExDBFieldNumber<>("ztynknengk", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztysyukeiyakunenkinnengaku = new ExDBFieldNumber<>("ztysyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztykaimasinenkinnengaku = new ExDBFieldNumber<>("ztykaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv38 = new ExDBFieldString<>("ztyyobiv38", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztykeisankijyunymd = new ExDBFieldString<>("ztykeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztytoujigyounendo = new ExDBFieldString<>("ztytoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyokujigyounendo = new ExDBFieldString<>("ztyyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyokuyokujigyounendo = new ExDBFieldString<>("ztyyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztytounendseisikiwariatehyj = new ExDBFieldString<>("ztytounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyknndseisikiwariatehyj = new ExDBFieldString<>("ztyyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyznnndseisikiwratehyj = new ExDBFieldString<>("ztyznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztytounendodhaneizumihyouji = new ExDBFieldString<>("ztytounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Long> ztytounendooutoubijitend = new ExDBFieldNumber<>("ztytounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztytunndoutubikutunndmtrrt = new ExDBFieldNumber<>("ztytunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztytunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("ztytunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztyyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("ztyyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztyznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztyznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztyktyumtikutunndoutubrrt = new ExDBFieldNumber<>("ztyktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztytunndoutubikuktyumtrrt = new ExDBFieldNumber<>("ztytunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigTy, Double> ztyktyumtikutunndmtrrt = new ExDBFieldNumber<>("ztyktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitRigTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);
}
