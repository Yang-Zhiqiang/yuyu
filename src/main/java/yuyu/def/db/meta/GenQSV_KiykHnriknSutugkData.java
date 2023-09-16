package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kaiyakuhrtype;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_KiykHnriknSutugkData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Kaiyakuhrtype;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SyutkKbn;

/**
 * 解約返戻金相当額情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_KiykHnriknSutugkData extends AbstractExDBTable<SV_KiykHnriknSutugkData> {

    public GenQSV_KiykHnriknSutugkData() {
        this("SV_KiykHnriknSutugkData");
    }

    public GenQSV_KiykHnriknSutugkData(String pAlias) {
        super("SV_KiykHnriknSutugkData", SV_KiykHnriknSutugkData.class, pAlias);
    }

    public String SV_KiykHnriknSutugkData() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_KiykHnriknSutugkData, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<SV_KiykHnriknSutugkData, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<SV_KiykHnriknSutugkData, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<SV_KiykHnriknSutugkData, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldNumber<SV_KiykHnriknSutugkData, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldBizCurrency<SV_KiykHnriknSutugkData> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_Kaiyakuhrtype> kaiyakuhrtype = new ExDBFieldString<>("kaiyakuhrtype", this, UserType_C_Kaiyakuhrtype.class);

    public final ExDBFieldString<SV_KiykHnriknSutugkData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);
}
