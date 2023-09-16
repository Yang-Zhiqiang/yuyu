package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RisaTjHitNplusQuartTy extends AbstractExDBTable<ZT_RisaTjHitNplusQuartTy> {

    public GenQZT_RisaTjHitNplusQuartTy() {
        this("ZT_RisaTjHitNplusQuartTy");
    }

    public GenQZT_RisaTjHitNplusQuartTy(String pAlias) {
        super("ZT_RisaTjHitNplusQuartTy", ZT_RisaTjHitNplusQuartTy.class, pAlias);
    }

    public String ZT_RisaTjHitNplusQuartTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyerrkbnv1 = new ExDBFieldString<>("ztyerrkbnv1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyratekbn = new ExDBFieldString<>("ztyratekbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykeiyakum = new ExDBFieldString<>("ztykeiyakum", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> zty5nenmeoutoubikbn = new ExDBFieldString<>("zty5nenmeoutoubikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykeiyakuoutoubikbn = new ExDBFieldString<>("ztykeiyakuoutoubikbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Integer> ztysaisitutokuyakuhukasuu = new ExDBFieldNumber<>("ztysaisitutokuyakuhukasuu", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytounendmtwrhrgkruikeigk = new ExDBFieldNumber<>("ztytounendmtwrhrgkruikeigk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztywarihurigakurisoku1 = new ExDBFieldNumber<>("ztywarihurigakurisoku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztywarihurigakurisoku2 = new ExDBFieldNumber<>("ztywarihurigakurisoku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyokunendosyoyougakuyou = new ExDBFieldNumber<>("ztyyokunendosyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyokuyokunendosyoyougkyou = new ExDBFieldNumber<>("ztyyokuyokunendosyoyougkyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyuukoutyuusyoyougaku = new ExDBFieldNumber<>("ztyyuukoutyuusyoyougaku", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysyoumetuyousyoyougaku1 = new ExDBFieldNumber<>("ztysyoumetuyousyoyougaku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysyoumetuyousyoyougaku2 = new ExDBFieldNumber<>("ztysyoumetuyousyoyougaku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytenkanyousyoyougaku1 = new ExDBFieldNumber<>("ztytenkanyousyoyougaku1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytenkanyousyoyougaku2 = new ExDBFieldNumber<>("ztytenkanyousyoyougaku2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutuujyoudsyoyougk1 = new ExDBFieldNumber<>("ztytnknyutuujyoudsyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutuujyoudsyoyougk2 = new ExDBFieldNumber<>("ztytnknyutuujyoudsyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyuhrkbbnksyoyougk1 = new ExDBFieldNumber<>("ztytnknyuhrkbbnksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyuhrkbbnksyoyougk2 = new ExDBFieldNumber<>("ztytnknyuhrkbbnksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyuhrkbbnknnknsnp1 = new ExDBFieldNumber<>("ztytnknyuhrkbbnknnknsnp1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyuhrkbbnknnknsnp2 = new ExDBFieldNumber<>("ztytnknyuhrkbbnknnknsnp2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutnknhktgksyoyougk1 = new ExDBFieldNumber<>("ztytnknyutnknhktgksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutnknhktgksyoyougk2 = new ExDBFieldNumber<>("ztytnknyutnknhktgksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutnknhktgknnknsnp1 = new ExDBFieldNumber<>("ztytnknyutnknhktgknnknsnp1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyutnknhktgknnknsnp2 = new ExDBFieldNumber<>("ztytnknyutnknhktgknnknsnp2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusaisituksyoyougk1 = new ExDBFieldNumber<>("ztytnknyusaisituksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusaisituksyoyougk2 = new ExDBFieldNumber<>("ztytnknyusaisituksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusaisitukkyhntgk1 = new ExDBFieldNumber<>("ztytnknyusaisitukkyhntgk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusaisitukkyhntgk2 = new ExDBFieldNumber<>("ztytnknyusaisitukkyhntgk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyhrkbbnkdsyoyougk = new ExDBFieldNumber<>("ztyhrkbbnkdsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyhrkbbnkdtisyunnknsnp = new ExDBFieldNumber<>("ztyhrkbbnkdtisyunnknsnp", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytusangohrkbbnkappad = new ExDBFieldNumber<>("ztytusangohrkbbnkappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknhktgkdsyoyougk = new ExDBFieldNumber<>("ztytnknhktgkdsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknhktgkdtisyunenknsnp = new ExDBFieldNumber<>("ztytnknhktgkdtisyunenknsnp", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytusangotnknhktgkappad = new ExDBFieldNumber<>("ztytusangotnknhktgkappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytuusangohutuusiboukappad = new ExDBFieldNumber<>("ztytuusangohutuusiboukappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysaisitukappadsyoyougaku = new ExDBFieldNumber<>("ztysaisitukappadsyoyougaku", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytuusangosaisitukappad = new ExDBFieldNumber<>("ztytuusangosaisitukappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysistkappadtisyukyhntgk = new ExDBFieldNumber<>("ztysistkappadtisyukyhntgk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytuusangogoukeikappad = new ExDBFieldNumber<>("ztytuusangogoukeikappad", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztydtaisyouv = new ExDBFieldNumber<>("ztydtaisyouv", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusyusistksyoyougk1 = new ExDBFieldNumber<>("ztytnknyusyusistksyoyougk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusyusistksyoyougk2 = new ExDBFieldNumber<>("ztytnknyusyusistksyoyougk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusyusistkkyhntgk1 = new ExDBFieldNumber<>("ztytnknyusyusistkkyhntgk1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytnknyusyusistkkyhntgk2 = new ExDBFieldNumber<>("ztytnknyusyusistkkyhntgk2", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysyusistkappadsyoyougk = new ExDBFieldNumber<>("ztysyusistkappadsyoyougk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysyusistkdtisyukyhntgk = new ExDBFieldNumber<>("ztysyusistkdtisyukyhntgk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztygkdtyknndsyoyougakuyou = new ExDBFieldNumber<>("ztygkdtyknndsyoyougakuyou", this);

    public final ExDBFieldNumber<ZT_RisaTjHitNplusQuartTy, Long> ztygkdtykyknndsyoyougakuyou = new ExDBFieldNumber<>("ztygkdtykyknndsyoyougakuyou", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, BizNumber> ztydkeisanjikwsrate = new ExDBFieldString<>("ztydkeisanjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztydkeisanjikwsratetkyymd = new ExDBFieldString<>("ztydkeisanjikwsratetkyymd", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv6x3 = new ExDBFieldString<>("ztyyobiv6x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120 = new ExDBFieldString<>("ztytokuyakukoumokuv120", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x2 = new ExDBFieldString<>("ztytokuyakukoumokuv120x2", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x3 = new ExDBFieldString<>("ztytokuyakukoumokuv120x3", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x4 = new ExDBFieldString<>("ztytokuyakukoumokuv120x4", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x5 = new ExDBFieldString<>("ztytokuyakukoumokuv120x5", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x6 = new ExDBFieldString<>("ztytokuyakukoumokuv120x6", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x7 = new ExDBFieldString<>("ztytokuyakukoumokuv120x7", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x8 = new ExDBFieldString<>("ztytokuyakukoumokuv120x8", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x9 = new ExDBFieldString<>("ztytokuyakukoumokuv120x9", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x10 = new ExDBFieldString<>("ztytokuyakukoumokuv120x10", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x11 = new ExDBFieldString<>("ztytokuyakukoumokuv120x11", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x12 = new ExDBFieldString<>("ztytokuyakukoumokuv120x12", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x13 = new ExDBFieldString<>("ztytokuyakukoumokuv120x13", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x14 = new ExDBFieldString<>("ztytokuyakukoumokuv120x14", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x15 = new ExDBFieldString<>("ztytokuyakukoumokuv120x15", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x16 = new ExDBFieldString<>("ztytokuyakukoumokuv120x16", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x17 = new ExDBFieldString<>("ztytokuyakukoumokuv120x17", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x18 = new ExDBFieldString<>("ztytokuyakukoumokuv120x18", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x19 = new ExDBFieldString<>("ztytokuyakukoumokuv120x19", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x20 = new ExDBFieldString<>("ztytokuyakukoumokuv120x20", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x21 = new ExDBFieldString<>("ztytokuyakukoumokuv120x21", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x22 = new ExDBFieldString<>("ztytokuyakukoumokuv120x22", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x23 = new ExDBFieldString<>("ztytokuyakukoumokuv120x23", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x24 = new ExDBFieldString<>("ztytokuyakukoumokuv120x24", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x25 = new ExDBFieldString<>("ztytokuyakukoumokuv120x25", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x26 = new ExDBFieldString<>("ztytokuyakukoumokuv120x26", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x27 = new ExDBFieldString<>("ztytokuyakukoumokuv120x27", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x28 = new ExDBFieldString<>("ztytokuyakukoumokuv120x28", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x29 = new ExDBFieldString<>("ztytokuyakukoumokuv120x29", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x30 = new ExDBFieldString<>("ztytokuyakukoumokuv120x30", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x31 = new ExDBFieldString<>("ztytokuyakukoumokuv120x31", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x32 = new ExDBFieldString<>("ztytokuyakukoumokuv120x32", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x33 = new ExDBFieldString<>("ztytokuyakukoumokuv120x33", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x34 = new ExDBFieldString<>("ztytokuyakukoumokuv120x34", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x35 = new ExDBFieldString<>("ztytokuyakukoumokuv120x35", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x36 = new ExDBFieldString<>("ztytokuyakukoumokuv120x36", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x37 = new ExDBFieldString<>("ztytokuyakukoumokuv120x37", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x38 = new ExDBFieldString<>("ztytokuyakukoumokuv120x38", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x39 = new ExDBFieldString<>("ztytokuyakukoumokuv120x39", this);

    public final ExDBFieldString<ZT_RisaTjHitNplusQuartTy, String> ztytokuyakukoumokuv120x40 = new ExDBFieldString<>("ztytokuyakukoumokuv120x40", this);
}
