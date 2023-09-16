package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitKtyRn;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitKtyRn extends AbstractExDBTable<ZT_NkHitKtyRn> {

    public GenQZT_NkHitKtyRn() {
        this("ZT_NkHitKtyRn");
    }

    public GenQZT_NkHitKtyRn(String pAlias) {
        super("ZT_NkHitKtyRn", ZT_NkHitKtyRn.class, pAlias);
    }

    public String ZT_NkHitKtyRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnnenkintypekbn = new ExDBFieldString<>("zrnnenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnnenkinitijisiharainendo = new ExDBFieldString<>("zrnnenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnmanryoukbn = new ExDBFieldString<>("zrnmanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnseizonkbn = new ExDBFieldString<>("zrnseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrnyoteiriritun5 = new ExDBFieldNumber<>("zrnyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrn5nngt3nngtoutubkbn = new ExDBFieldString<>("zrn5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv15 = new ExDBFieldString<>("zrnyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrngyousekihyoujisibous = new ExDBFieldNumber<>("zrngyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrntounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("zrntounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnwarihurigakurisoku1 = new ExDBFieldNumber<>("zrnwarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnwarihurigakurisoku2 = new ExDBFieldNumber<>("zrnwarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnyokunendosyoyougakuyou = new ExDBFieldNumber<>("zrnyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("zrnyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("zrnyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnsyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnsyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnrisadtaisyouv = new ExDBFieldNumber<>("zrnrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnnknengk = new ExDBFieldNumber<>("zrnnknengk", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnsyukeiyakunenkinnengaku = new ExDBFieldNumber<>("zrnsyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrnkaimasinenkinnengaku = new ExDBFieldNumber<>("zrnkaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv38 = new ExDBFieldString<>("zrnyobiv38", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnkeisankijyunymd = new ExDBFieldString<>("zrnkeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrntoujigyounendo = new ExDBFieldString<>("zrntoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyokujigyounendo = new ExDBFieldString<>("zrnyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyokuyokujigyounendo = new ExDBFieldString<>("zrnyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrntounendseisikiwariatehyj = new ExDBFieldString<>("zrntounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyknndseisikiwariatehyj = new ExDBFieldString<>("zrnyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnznnndseisikiwratehyj = new ExDBFieldString<>("zrnznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrntounendodhaneizumihyouji = new ExDBFieldString<>("zrntounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Long> zrntounendooutoubijitend = new ExDBFieldNumber<>("zrntounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrntunndoutubikutunndmtrrt = new ExDBFieldNumber<>("zrntunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrntunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("zrntunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrnyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("zrnyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrnznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrnznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrnktyumtikutunndoutubrrt = new ExDBFieldNumber<>("zrnktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrntunndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrntunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitKtyRn, Double> zrnktyumtikutunndmtrrt = new ExDBFieldNumber<>("zrnktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitKtyRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);
}
