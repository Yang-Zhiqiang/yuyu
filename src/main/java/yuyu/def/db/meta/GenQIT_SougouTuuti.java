package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_SougouTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkKbn;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 総合通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SougouTuuti extends AbstractExDBTable<IT_SougouTuuti> {

    public GenQIT_SougouTuuti() {
        this("IT_SougouTuuti");
    }

    public GenQIT_SougouTuuti(String pAlias) {
        super("IT_SougouTuuti", IT_SougouTuuti.class, pAlias);
    }

    public String IT_SougouTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SougouTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> tyouhyouprtymd = new ExDBFieldString<>("tyouhyouprtymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnmsyouken = new ExDBFieldString<>("syouhnnmsyouken", this);

    public final ExDBFieldString<IT_SougouTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_SougouTuuti, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_SougouTuuti, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhenkanuktnmkj = new ExDBFieldString<>("sbhenkanuktnmkj", this);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> sibouhenkankinuktseiymd = new ExDBFieldString<>("sibouhenkankinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> stdrskseiymd = new ExDBFieldString<>("stdrskseiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_SougouTuuti, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_SougouTuuti, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn1 = new ExDBFieldString<>("syutkkbn1", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn2 = new ExDBFieldString<>("syutkkbn2", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn3 = new ExDBFieldString<>("syutkkbn3", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn4 = new ExDBFieldString<>("syutkkbn4", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn5 = new ExDBFieldString<>("syutkkbn5", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn6 = new ExDBFieldString<>("syutkkbn6", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn7 = new ExDBFieldString<>("syutkkbn7", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn8 = new ExDBFieldString<>("syutkkbn8", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn9 = new ExDBFieldString<>("syutkkbn9", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyutkKbn> syutkkbn10 = new ExDBFieldString<>("syutkkbn10", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd1 = new ExDBFieldString<>("syouhncd1", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd2 = new ExDBFieldString<>("syouhncd2", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd3 = new ExDBFieldString<>("syouhncd3", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd4 = new ExDBFieldString<>("syouhncd4", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd5 = new ExDBFieldString<>("syouhncd5", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd6 = new ExDBFieldString<>("syouhncd6", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd7 = new ExDBFieldString<>("syouhncd7", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd8 = new ExDBFieldString<>("syouhncd8", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd9 = new ExDBFieldString<>("syouhncd9", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhncd10 = new ExDBFieldString<>("syouhncd10", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno1 = new ExDBFieldNumber<>("syouhnsdno1", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno2 = new ExDBFieldNumber<>("syouhnsdno2", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno3 = new ExDBFieldNumber<>("syouhnsdno3", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno4 = new ExDBFieldNumber<>("syouhnsdno4", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno5 = new ExDBFieldNumber<>("syouhnsdno5", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno6 = new ExDBFieldNumber<>("syouhnsdno6", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno7 = new ExDBFieldNumber<>("syouhnsdno7", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno8 = new ExDBFieldNumber<>("syouhnsdno8", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno9 = new ExDBFieldNumber<>("syouhnsdno9", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> syouhnsdno10 = new ExDBFieldNumber<>("syouhnsdno10", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno1 = new ExDBFieldNumber<>("kyksyouhnrenno1", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno2 = new ExDBFieldNumber<>("kyksyouhnrenno2", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno3 = new ExDBFieldNumber<>("kyksyouhnrenno3", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno4 = new ExDBFieldNumber<>("kyksyouhnrenno4", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno5 = new ExDBFieldNumber<>("kyksyouhnrenno5", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno6 = new ExDBFieldNumber<>("kyksyouhnrenno6", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno7 = new ExDBFieldNumber<>("kyksyouhnrenno7", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno8 = new ExDBFieldNumber<>("kyksyouhnrenno8", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno9 = new ExDBFieldNumber<>("kyksyouhnrenno9", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> kyksyouhnrenno10 = new ExDBFieldNumber<>("kyksyouhnrenno10", this);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn1 = new ExDBFieldString<>("kyhgndkatakbn1", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn2 = new ExDBFieldString<>("kyhgndkatakbn2", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn3 = new ExDBFieldString<>("kyhgndkatakbn3", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn4 = new ExDBFieldString<>("kyhgndkatakbn4", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn5 = new ExDBFieldString<>("kyhgndkatakbn5", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn6 = new ExDBFieldString<>("kyhgndkatakbn6", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn7 = new ExDBFieldString<>("kyhgndkatakbn7", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn8 = new ExDBFieldString<>("kyhgndkatakbn8", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn9 = new ExDBFieldString<>("kyhgndkatakbn9", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KyhgndkataKbn> kyhgndkatakbn10 = new ExDBFieldString<>("kyhgndkatakbn10", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn1 = new ExDBFieldString<>("hknkknsmnkbn1", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn2 = new ExDBFieldString<>("hknkknsmnkbn2", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn3 = new ExDBFieldString<>("hknkknsmnkbn3", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn4 = new ExDBFieldString<>("hknkknsmnkbn4", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn5 = new ExDBFieldString<>("hknkknsmnkbn5", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn6 = new ExDBFieldString<>("hknkknsmnkbn6", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn7 = new ExDBFieldString<>("hknkknsmnkbn7", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn8 = new ExDBFieldString<>("hknkknsmnkbn8", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn9 = new ExDBFieldString<>("hknkknsmnkbn9", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HknkknsmnKbn> hknkknsmnkbn10 = new ExDBFieldString<>("hknkknsmnkbn10", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn1 = new ExDBFieldNumber<>("hknkkn1", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn2 = new ExDBFieldNumber<>("hknkkn2", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn3 = new ExDBFieldNumber<>("hknkkn3", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn4 = new ExDBFieldNumber<>("hknkkn4", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn5 = new ExDBFieldNumber<>("hknkkn5", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn6 = new ExDBFieldNumber<>("hknkkn6", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn7 = new ExDBFieldNumber<>("hknkkn7", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn8 = new ExDBFieldNumber<>("hknkkn8", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn9 = new ExDBFieldNumber<>("hknkkn9", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hknkkn10 = new ExDBFieldNumber<>("hknkkn10", this);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn1 = new ExDBFieldString<>("hrkkknsmnkbn1", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn2 = new ExDBFieldString<>("hrkkknsmnkbn2", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn3 = new ExDBFieldString<>("hrkkknsmnkbn3", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn4 = new ExDBFieldString<>("hrkkknsmnkbn4", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn5 = new ExDBFieldString<>("hrkkknsmnkbn5", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn6 = new ExDBFieldString<>("hrkkknsmnkbn6", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn7 = new ExDBFieldString<>("hrkkknsmnkbn7", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn8 = new ExDBFieldString<>("hrkkknsmnkbn8", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn9 = new ExDBFieldString<>("hrkkknsmnkbn9", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_HrkkknsmnKbn> hrkkknsmnkbn10 = new ExDBFieldString<>("hrkkknsmnkbn10", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn1 = new ExDBFieldNumber<>("hrkkkn1", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn2 = new ExDBFieldNumber<>("hrkkkn2", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn3 = new ExDBFieldNumber<>("hrkkkn3", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn4 = new ExDBFieldNumber<>("hrkkkn4", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn5 = new ExDBFieldNumber<>("hrkkkn5", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn6 = new ExDBFieldNumber<>("hrkkkn6", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn7 = new ExDBFieldNumber<>("hrkkkn7", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn8 = new ExDBFieldNumber<>("hrkkkn8", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn9 = new ExDBFieldNumber<>("hrkkkn9", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> hrkkkn10 = new ExDBFieldNumber<>("hrkkkn10", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm1 = new ExDBFieldString<>("syouhnnm1", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm2 = new ExDBFieldString<>("syouhnnm2", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm3 = new ExDBFieldString<>("syouhnnm3", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm4 = new ExDBFieldString<>("syouhnnm4", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm5 = new ExDBFieldString<>("syouhnnm5", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm6 = new ExDBFieldString<>("syouhnnm6", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm7 = new ExDBFieldString<>("syouhnnm7", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm8 = new ExDBFieldString<>("syouhnnm8", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm9 = new ExDBFieldString<>("syouhnnm9", this);

    public final ExDBFieldString<IT_SougouTuuti, String> syouhnnm10 = new ExDBFieldString<>("syouhnnm10", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons1 = new ExDBFieldBizCurrency<>("kihons1", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons2 = new ExDBFieldBizCurrency<>("kihons2", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons3 = new ExDBFieldBizCurrency<>("kihons3", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons4 = new ExDBFieldBizCurrency<>("kihons4", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons5 = new ExDBFieldBizCurrency<>("kihons5", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons6 = new ExDBFieldBizCurrency<>("kihons6", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons7 = new ExDBFieldBizCurrency<>("kihons7", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons8 = new ExDBFieldBizCurrency<>("kihons8", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons9 = new ExDBFieldBizCurrency<>("kihons9", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> kihons10 = new ExDBFieldBizCurrency<>("kihons10", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p1 = new ExDBFieldBizCurrency<>("p1", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p2 = new ExDBFieldBizCurrency<>("p2", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p3 = new ExDBFieldBizCurrency<>("p3", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p4 = new ExDBFieldBizCurrency<>("p4", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p5 = new ExDBFieldBizCurrency<>("p5", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p6 = new ExDBFieldBizCurrency<>("p6", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p7 = new ExDBFieldBizCurrency<>("p7", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p8 = new ExDBFieldBizCurrency<>("p8", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p9 = new ExDBFieldBizCurrency<>("p9", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> p10 = new ExDBFieldBizCurrency<>("p10", this);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn1 = new ExDBFieldString<>("kihonssyuruikbn1", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn2 = new ExDBFieldString<>("kihonssyuruikbn2", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn3 = new ExDBFieldString<>("kihonssyuruikbn3", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn4 = new ExDBFieldString<>("kihonssyuruikbn4", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn5 = new ExDBFieldString<>("kihonssyuruikbn5", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn6 = new ExDBFieldString<>("kihonssyuruikbn6", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn7 = new ExDBFieldString<>("kihonssyuruikbn7", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn8 = new ExDBFieldString<>("kihonssyuruikbn8", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn9 = new ExDBFieldString<>("kihonssyuruikbn9", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KihonssyuruiKbn> kihonssyuruikbn10 = new ExDBFieldString<>("kihonssyuruikbn10", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn1 = new ExDBFieldString<>("syukyhkinkatakbn1", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn2 = new ExDBFieldString<>("syukyhkinkatakbn2", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn3 = new ExDBFieldString<>("syukyhkinkatakbn3", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn4 = new ExDBFieldString<>("syukyhkinkatakbn4", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn5 = new ExDBFieldString<>("syukyhkinkatakbn5", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn6 = new ExDBFieldString<>("syukyhkinkatakbn6", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn7 = new ExDBFieldString<>("syukyhkinkatakbn7", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn8 = new ExDBFieldString<>("syukyhkinkatakbn8", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn9 = new ExDBFieldString<>("syukyhkinkatakbn9", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SyukyhkinkataKbn> syukyhkinkatakbn10 = new ExDBFieldString<>("syukyhkinkatakbn10", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn1 = new ExDBFieldString<>("rokudaissbtkkyhktkbn1", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn2 = new ExDBFieldString<>("rokudaissbtkkyhktkbn2", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn3 = new ExDBFieldString<>("rokudaissbtkkyhktkbn3", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn4 = new ExDBFieldString<>("rokudaissbtkkyhktkbn4", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn5 = new ExDBFieldString<>("rokudaissbtkkyhktkbn5", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn6 = new ExDBFieldString<>("rokudaissbtkkyhktkbn6", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn7 = new ExDBFieldString<>("rokudaissbtkkyhktkbn7", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn8 = new ExDBFieldString<>("rokudaissbtkkyhktkbn8", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn9 = new ExDBFieldString<>("rokudaissbtkkyhktkbn9", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_6daiLdKbn> rokudaissbtkkyhktkbn10 = new ExDBFieldString<>("rokudaissbtkkyhktkbn10", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk1 = new ExDBFieldBizCurrency<>("khnkyhgk1", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk2 = new ExDBFieldBizCurrency<>("khnkyhgk2", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk3 = new ExDBFieldBizCurrency<>("khnkyhgk3", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk4 = new ExDBFieldBizCurrency<>("khnkyhgk4", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk5 = new ExDBFieldBizCurrency<>("khnkyhgk5", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk6 = new ExDBFieldBizCurrency<>("khnkyhgk6", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk7 = new ExDBFieldBizCurrency<>("khnkyhgk7", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk8 = new ExDBFieldBizCurrency<>("khnkyhgk8", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk9 = new ExDBFieldBizCurrency<>("khnkyhgk9", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> khnkyhgk10 = new ExDBFieldBizCurrency<>("khnkyhgk10", this);

    public final ExDBFieldString<IT_SougouTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_SougouTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_SougouTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_SougouTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_SougouTuuti, String> tsinadr4kj = new ExDBFieldString<>("tsinadr4kj", this);

    public final ExDBFieldString<IT_SougouTuuti, String> aitesyono = new ExDBFieldString<>("aitesyono", this);

    public final ExDBFieldString<IT_SougouTuuti, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_SougouTuuti, String> drtennmkj = new ExDBFieldString<>("drtennmkj", this);

    public final ExDBFieldString<IT_SougouTuuti, C_UmuKbn> rkaiyakuhrumukbn = new ExDBFieldString<>("rkaiyakuhrumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> rkaiyakuhr = new ExDBFieldBizCurrency<>("rkaiyakuhr", this);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> rsbhenkan = new ExDBFieldBizCurrency<>("rsbhenkan", this);

    public final ExDBFieldString<IT_SougouTuuti, String> rhtnpbuinm1 = new ExDBFieldString<>("rhtnpbuinm1", this);

    public final ExDBFieldString<IT_SougouTuuti, C_Htnpkkn> htnpkkn1 = new ExDBFieldString<>("htnpkkn1", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> rhtnpbuinm2 = new ExDBFieldString<>("rhtnpbuinm2", this);

    public final ExDBFieldString<IT_SougouTuuti, C_Htnpkkn> htnpkkn2 = new ExDBFieldString<>("htnpkkn2", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> rhtnpbuinm3 = new ExDBFieldString<>("rhtnpbuinm3", this);

    public final ExDBFieldString<IT_SougouTuuti, C_Htnpkkn> htnpkkn3 = new ExDBFieldString<>("htnpkkn3", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> rhtnpbuinm4 = new ExDBFieldString<>("rhtnpbuinm4", this);

    public final ExDBFieldString<IT_SougouTuuti, C_Htnpkkn> htnpkkn4 = new ExDBFieldString<>("htnpkkn4", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_TokkoudosghtnpKbn> tokkoudosghtnpkbn = new ExDBFieldString<>("tokkoudosghtnpkbn", this, UserType_C_TokkoudosghtnpKbn.class);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> rtratkicd = new ExDBFieldNumber<>("rtratkicd", this);

    public final ExDBFieldString<IT_SougouTuuti, String> rtyouhyoucd = new ExDBFieldString<>("rtyouhyoucd", this);

    public final ExDBFieldString<IT_SougouTuuti, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> gansknnkaisiymd = new ExDBFieldString<>("gansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_SougouTuuti> gannyukyhntgk = new ExDBFieldBizCurrency<>("gannyukyhntgk", this);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn1 = new ExDBFieldString<>("katakbn1", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn2 = new ExDBFieldString<>("katakbn2", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn3 = new ExDBFieldString<>("katakbn3", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn4 = new ExDBFieldString<>("katakbn4", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn5 = new ExDBFieldString<>("katakbn5", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn6 = new ExDBFieldString<>("katakbn6", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn7 = new ExDBFieldString<>("katakbn7", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn8 = new ExDBFieldString<>("katakbn8", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn9 = new ExDBFieldString<>("katakbn9", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, C_KataKbn> katakbn10 = new ExDBFieldString<>("katakbn10", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktnmkj1 = new ExDBFieldString<>("sbhkuktnmkj1", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktnmkj2 = new ExDBFieldString<>("sbhkuktnmkj2", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktnmkj3 = new ExDBFieldString<>("sbhkuktnmkj3", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktnmkj4 = new ExDBFieldString<>("sbhkuktnmkj4", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktnmkj5 = new ExDBFieldString<>("sbhkuktnmkj5", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktseiymd1 = new ExDBFieldString<>("sbhkuktseiymd1", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktseiymd2 = new ExDBFieldString<>("sbhkuktseiymd2", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktseiymd3 = new ExDBFieldString<>("sbhkuktseiymd3", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktseiymd4 = new ExDBFieldString<>("sbhkuktseiymd4", this);

    public final ExDBFieldString<IT_SougouTuuti, String> sbhkuktseiymd5 = new ExDBFieldString<>("sbhkuktseiymd5", this);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> sbhkkukttyoukanin = new ExDBFieldNumber<>("sbhkkukttyoukanin", this);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> sbhktyoukaninbunwari = new ExDBFieldString<>("sbhktyoukaninbunwari", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> bnwari1 = new ExDBFieldString<>("bnwari1", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> bnwari2 = new ExDBFieldString<>("bnwari2", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> bnwari3 = new ExDBFieldString<>("bnwari3", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> bnwari4 = new ExDBFieldString<>("bnwari4", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizNumber> bnwari5 = new ExDBFieldString<>("bnwari5", this, BizNumberType.class);

    public final ExDBFieldString<IT_SougouTuuti, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> mosukeymd = new ExDBFieldString<>("mosukeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, C_SknnkaisikitkKbn> sknnkaisikitkkbn = new ExDBFieldString<>("sknnkaisikitkkbn", this, UserType_C_SknnkaisikitkKbn.class);

    public final ExDBFieldNumber<IT_SougouTuuti, Integer> koujyosyoumeirecnum = new ExDBFieldNumber<>("koujyosyoumeirecnum", this);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> hksknnkaisiymd = new ExDBFieldString<>("hksknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, BizDate> hkgansknnkaisiymd = new ExDBFieldString<>("hkgansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SougouTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SougouTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SougouTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
