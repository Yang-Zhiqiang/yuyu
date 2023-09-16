package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitKsnRn;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitKsnRn extends AbstractExDBTable<ZT_NkHitKsnRn> {

    public GenQZT_NkHitKsnRn() {
        this("ZT_NkHitKsnRn");
    }

    public GenQZT_NkHitKsnRn(String pAlias) {
        super("ZT_NkHitKsnRn", ZT_NkHitKsnRn.class, pAlias);
    }

    public String ZT_NkHitKsnRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnnenkintypekbn = new ExDBFieldString<>("zrnnenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnnenkinitijisiharainendo = new ExDBFieldString<>("zrnnenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnmanryoukbn = new ExDBFieldString<>("zrnmanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnseizonkbn = new ExDBFieldString<>("zrnseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrnyoteiriritun5 = new ExDBFieldNumber<>("zrnyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrn5nngt3nngtoutubkbn = new ExDBFieldString<>("zrn5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv15 = new ExDBFieldString<>("zrnyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrngyousekihyoujisibous = new ExDBFieldNumber<>("zrngyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrntounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("zrntounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnwarihurigakurisoku1 = new ExDBFieldNumber<>("zrnwarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnwarihurigakurisoku2 = new ExDBFieldNumber<>("zrnwarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnyokunendosyoyougakuyou = new ExDBFieldNumber<>("zrnyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("zrnyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("zrnyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnsyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnsyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnrisadtaisyouv = new ExDBFieldNumber<>("zrnrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnnknengk = new ExDBFieldNumber<>("zrnnknengk", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnsyukeiyakunenkinnengaku = new ExDBFieldNumber<>("zrnsyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrnkaimasinenkinnengaku = new ExDBFieldNumber<>("zrnkaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv38 = new ExDBFieldString<>("zrnyobiv38", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnkeisankijyunymd = new ExDBFieldString<>("zrnkeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrntoujigyounendo = new ExDBFieldString<>("zrntoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyokujigyounendo = new ExDBFieldString<>("zrnyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyokuyokujigyounendo = new ExDBFieldString<>("zrnyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrntounendseisikiwariatehyj = new ExDBFieldString<>("zrntounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyknndseisikiwariatehyj = new ExDBFieldString<>("zrnyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnznnndseisikiwratehyj = new ExDBFieldString<>("zrnznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrntounendodhaneizumihyouji = new ExDBFieldString<>("zrntounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Long> zrntounendooutoubijitend = new ExDBFieldNumber<>("zrntounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrntunndoutubikutunndmtrrt = new ExDBFieldNumber<>("zrntunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrntunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("zrntunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrnyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("zrnyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrnznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrnznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrnktyumtikutunndoutubrrt = new ExDBFieldNumber<>("zrnktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrntunndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrntunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKsnRn, Double> zrnktyumtikutunndmtrrt = new ExDBFieldNumber<>("zrnktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitKsnRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);
}
