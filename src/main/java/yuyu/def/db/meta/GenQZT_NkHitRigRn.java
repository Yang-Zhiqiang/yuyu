package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkHitRigRn;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkHitRigRn extends AbstractExDBTable<ZT_NkHitRigRn> {

    public GenQZT_NkHitRigRn() {
        this("ZT_NkHitRigRn");
    }

    public GenQZT_NkHitRigRn(String pAlias) {
        super("ZT_NkHitRigRn", ZT_NkHitRigRn.class, pAlias);
    }

    public String ZT_NkHitRigRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnnenkintypekbn = new ExDBFieldString<>("zrnnenkintypekbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnnenkinitijisiharainendo = new ExDBFieldString<>("zrnnenkinitijisiharainendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnmanryoukbn = new ExDBFieldString<>("zrnmanryoukbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnseizonkbn = new ExDBFieldString<>("zrnseizonkbn", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrnyoteiriritun5 = new ExDBFieldNumber<>("zrnyoteiriritun5", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrn5nngt3nngtoutubkbn = new ExDBFieldString<>("zrn5nngt3nngtoutubkbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv15 = new ExDBFieldString<>("zrnyobiv15", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrngyousekihyoujisibous = new ExDBFieldNumber<>("zrngyousekihyoujisibous", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrntounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("zrntounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnwarihurigakurisoku1 = new ExDBFieldNumber<>("zrnwarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnwarihurigakurisoku2 = new ExDBFieldNumber<>("zrnwarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnyokunendosyoyougakuyou = new ExDBFieldNumber<>("zrnyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("zrnyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnyuukoutyuusyoyougakuyou = new ExDBFieldNumber<>("zrnyuukoutyuusyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnsyoumetujisyoyougakuyou1 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou1", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnsyoumetujisyoyougakuyou2 = new ExDBFieldNumber<>("zrnsyoumetujisyoyougakuyou2", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnrisadtaisyouv = new ExDBFieldNumber<>("zrnrisadtaisyouv", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnnknengk = new ExDBFieldNumber<>("zrnnknengk", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnsyukeiyakunenkinnengaku = new ExDBFieldNumber<>("zrnsyukeiyakunenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrnkaimasinenkinnengaku = new ExDBFieldNumber<>("zrnkaimasinenkinnengaku", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv38 = new ExDBFieldString<>("zrnyobiv38", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnkeisankijyunymd = new ExDBFieldString<>("zrnkeisankijyunymd", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrntoujigyounendo = new ExDBFieldString<>("zrntoujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyokujigyounendo = new ExDBFieldString<>("zrnyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyokuyokujigyounendo = new ExDBFieldString<>("zrnyokuyokujigyounendo", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrntounendseisikiwariatehyj = new ExDBFieldString<>("zrntounendseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyknndseisikiwariatehyj = new ExDBFieldString<>("zrnyknndseisikiwariatehyj", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnznnndseisikiwratehyj = new ExDBFieldString<>("zrnznnndseisikiwratehyj", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrntounendodhaneizumihyouji = new ExDBFieldString<>("zrntounendodhaneizumihyouji", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Long> zrntounendooutoubijitend = new ExDBFieldNumber<>("zrntounendooutoubijitend", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrntunndoutubikutunndmtrrt = new ExDBFieldNumber<>("zrntunndoutubikutunndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrntunndmtikuyknndoutubrrt = new ExDBFieldNumber<>("zrntunndmtikuyknndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrnyknndoutubikouyknndmtrrt = new ExDBFieldNumber<>("zrnyknndoutubikouyknndmtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrnznnndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrnznnndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrnktyumtikutunndoutubrrt = new ExDBFieldNumber<>("zrnktyumtikutunndoutubrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrntunndoutubikuktyumtrrt = new ExDBFieldNumber<>("zrntunndoutubikuktyumtrrt", this);

    public final ExDBFieldNumber<ZT_NkHitRigRn, Double> zrnktyumtikutunndmtrrt = new ExDBFieldNumber<>("zrnktyumtikutunndmtrrt", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_NkHitRigRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);
}
