package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RisaTjHitNplusQuartRn extends AbstractExDBTable<ZT_RisaTjHitNplusQuartRn> {

    public GenQZT_RisaTjHitNplusQuartRn() {
        this("ZT_RisaTjHitNplusQuartRn");
    }

    public GenQZT_RisaTjHitNplusQuartRn(String pAlias) {
        super("ZT_RisaTjHitNplusQuartRn", ZT_RisaTjHitNplusQuartRn.class, pAlias);
    }

    public String ZT_RisaTjHitNplusQuartRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnerrkbnv1 = new ExDBFieldString<>("zrnerrkbnv1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnratekbn = new ExDBFieldString<>("zrnratekbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkeiyakum = new ExDBFieldString<>("zrnkeiyakum", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrn5nenmeoutoubikbn = new ExDBFieldString<>("zrn5nenmeoutoubikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkeiyakuoutoubikbn = new ExDBFieldString<>("zrnkeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnsuuriyouyobin1 = new ExDBFieldString<>("zrnsuuriyouyobin1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Integer> zrnsaisitutokuyakuhukasuu = new ExDBFieldNumber<>("zrnsaisitutokuyakuhukasuu", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("zrntounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnwarihurigakurisoku1 = new ExDBFieldNumber<>("zrnwarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnwarihurigakurisoku2 = new ExDBFieldNumber<>("zrnwarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyokunendosyoyougakuyou = new ExDBFieldNumber<>("zrnyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("zrnyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyuukoutyuusyoyougaku = new ExDBFieldNumber<>("zrnyuukoutyuusyoyougaku", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsyoumetuyousyoyougaku1 = new ExDBFieldNumber<>("zrnsyoumetuyousyoyougaku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsyoumetuyousyoyougaku2 = new ExDBFieldNumber<>("zrnsyoumetuyousyoyougaku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntenkanyousyoyougaku1 = new ExDBFieldNumber<>("zrntenkanyousyoyougaku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntenkanyousyoyougaku2 = new ExDBFieldNumber<>("zrntenkanyousyoyougaku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutuujyoudsyoyougk1 = new ExDBFieldNumber<>("zrntnknyutuujyoudsyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutuujyoudsyoyougk2 = new ExDBFieldNumber<>("zrntnknyutuujyoudsyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyuhrkbbnksyoyougk1 = new ExDBFieldNumber<>("zrntnknyuhrkbbnksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyuhrkbbnksyoyougk2 = new ExDBFieldNumber<>("zrntnknyuhrkbbnksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyuhrkbbnknnknsnp1 = new ExDBFieldNumber<>("zrntnknyuhrkbbnknnknsnp1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyuhrkbbnknnknsnp2 = new ExDBFieldNumber<>("zrntnknyuhrkbbnknnknsnp2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutnknhktgksyoyougk1 = new ExDBFieldNumber<>("zrntnknyutnknhktgksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutnknhktgksyoyougk2 = new ExDBFieldNumber<>("zrntnknyutnknhktgksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutnknhktgknnknsnp1 = new ExDBFieldNumber<>("zrntnknyutnknhktgknnknsnp1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyutnknhktgknnknsnp2 = new ExDBFieldNumber<>("zrntnknyutnknhktgknnknsnp2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusaisituksyoyougk1 = new ExDBFieldNumber<>("zrntnknyusaisituksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusaisituksyoyougk2 = new ExDBFieldNumber<>("zrntnknyusaisituksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusaisitukkyhntgk1 = new ExDBFieldNumber<>("zrntnknyusaisitukkyhntgk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusaisitukkyhntgk2 = new ExDBFieldNumber<>("zrntnknyusaisitukkyhntgk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnhrkbbnkdsyoyougk = new ExDBFieldNumber<>("zrnhrkbbnkdsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnhrkbbnkdtisyunnknsnp = new ExDBFieldNumber<>("zrnhrkbbnkdtisyunnknsnp", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntusangohrkbbnkappad = new ExDBFieldNumber<>("zrntusangohrkbbnkappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknhktgkdsyoyougk = new ExDBFieldNumber<>("zrntnknhktgkdsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknhktgkdtisyunenknsnp = new ExDBFieldNumber<>("zrntnknhktgkdtisyunenknsnp", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntusangotnknhktgkappad = new ExDBFieldNumber<>("zrntusangotnknhktgkappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntuusangohutuusiboukappad = new ExDBFieldNumber<>("zrntuusangohutuusiboukappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsaisitukappadsyoyougaku = new ExDBFieldNumber<>("zrnsaisitukappadsyoyougaku", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntuusangosaisitukappad = new ExDBFieldNumber<>("zrntuusangosaisitukappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsistkappadtisyukyhntgk = new ExDBFieldNumber<>("zrnsistkappadtisyukyhntgk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntuusangogoukeikappad = new ExDBFieldNumber<>("zrntuusangogoukeikappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrndtaisyouv = new ExDBFieldNumber<>("zrndtaisyouv", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusyusistksyoyougk1 = new ExDBFieldNumber<>("zrntnknyusyusistksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusyusistksyoyougk2 = new ExDBFieldNumber<>("zrntnknyusyusistksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusyusistkkyhntgk1 = new ExDBFieldNumber<>("zrntnknyusyusistkkyhntgk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntnknyusyusistkkyhntgk2 = new ExDBFieldNumber<>("zrntnknyusyusistkkyhntgk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsyusistkappadsyoyougk = new ExDBFieldNumber<>("zrnsyusistkappadsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsyusistkdtisyukyhntgk = new ExDBFieldNumber<>("zrnsyusistkdtisyukyhntgk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnyobin11x11 = new ExDBFieldNumber<>("zrnyobin11x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnnksjitirttumitatekin = new ExDBFieldNumber<>("zrnnksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, BizNumber> zrnyoteiririturironbase = new ExDBFieldString<>("zrnyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrngkdtyknndsyoyougakuyou = new ExDBFieldNumber<>("zrngkdtyknndsyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartRn, Long> zrngkdtykyknndsyoyougakuyou = new ExDBFieldNumber<>("zrngkdtykyknndsyoyougakuyou", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, BizNumber> zrndkeisanjikwsrate = new ExDBFieldString<>("zrndkeisanjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrndkeisanjikwsratetkyymd = new ExDBFieldString<>("zrndkeisanjikwsratetkyymd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv6x3 = new ExDBFieldString<>("zrnyobiv6x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120 = new ExDBFieldString<>("zrntokuyakukoumokuv120", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x2 = new ExDBFieldString<>("zrntokuyakukoumokuv120x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x3 = new ExDBFieldString<>("zrntokuyakukoumokuv120x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x4 = new ExDBFieldString<>("zrntokuyakukoumokuv120x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x5 = new ExDBFieldString<>("zrntokuyakukoumokuv120x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x6 = new ExDBFieldString<>("zrntokuyakukoumokuv120x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x7 = new ExDBFieldString<>("zrntokuyakukoumokuv120x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x8 = new ExDBFieldString<>("zrntokuyakukoumokuv120x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x9 = new ExDBFieldString<>("zrntokuyakukoumokuv120x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x10 = new ExDBFieldString<>("zrntokuyakukoumokuv120x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x11 = new ExDBFieldString<>("zrntokuyakukoumokuv120x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x12 = new ExDBFieldString<>("zrntokuyakukoumokuv120x12", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x13 = new ExDBFieldString<>("zrntokuyakukoumokuv120x13", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x14 = new ExDBFieldString<>("zrntokuyakukoumokuv120x14", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x15 = new ExDBFieldString<>("zrntokuyakukoumokuv120x15", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x16 = new ExDBFieldString<>("zrntokuyakukoumokuv120x16", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x17 = new ExDBFieldString<>("zrntokuyakukoumokuv120x17", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x18 = new ExDBFieldString<>("zrntokuyakukoumokuv120x18", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x19 = new ExDBFieldString<>("zrntokuyakukoumokuv120x19", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x20 = new ExDBFieldString<>("zrntokuyakukoumokuv120x20", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x21 = new ExDBFieldString<>("zrntokuyakukoumokuv120x21", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x22 = new ExDBFieldString<>("zrntokuyakukoumokuv120x22", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x23 = new ExDBFieldString<>("zrntokuyakukoumokuv120x23", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x24 = new ExDBFieldString<>("zrntokuyakukoumokuv120x24", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x25 = new ExDBFieldString<>("zrntokuyakukoumokuv120x25", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x26 = new ExDBFieldString<>("zrntokuyakukoumokuv120x26", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x27 = new ExDBFieldString<>("zrntokuyakukoumokuv120x27", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x28 = new ExDBFieldString<>("zrntokuyakukoumokuv120x28", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x29 = new ExDBFieldString<>("zrntokuyakukoumokuv120x29", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x30 = new ExDBFieldString<>("zrntokuyakukoumokuv120x30", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x31 = new ExDBFieldString<>("zrntokuyakukoumokuv120x31", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x32 = new ExDBFieldString<>("zrntokuyakukoumokuv120x32", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x33 = new ExDBFieldString<>("zrntokuyakukoumokuv120x33", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x34 = new ExDBFieldString<>("zrntokuyakukoumokuv120x34", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x35 = new ExDBFieldString<>("zrntokuyakukoumokuv120x35", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x36 = new ExDBFieldString<>("zrntokuyakukoumokuv120x36", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x37 = new ExDBFieldString<>("zrntokuyakukoumokuv120x37", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x38 = new ExDBFieldString<>("zrntokuyakukoumokuv120x38", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x39 = new ExDBFieldString<>("zrntokuyakukoumokuv120x39", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartRn, String> zrntokuyakukoumokuv120x40 = new ExDBFieldString<>("zrntokuyakukoumokuv120x40", this);
}
