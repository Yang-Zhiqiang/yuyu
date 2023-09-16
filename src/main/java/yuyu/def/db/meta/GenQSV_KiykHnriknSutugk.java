package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 解約返戻金相当額情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_KiykHnriknSutugk extends AbstractExDBTable<SV_KiykHnriknSutugk> {

    public GenQSV_KiykHnriknSutugk() {
        this("SV_KiykHnriknSutugk");
    }

    public GenQSV_KiykHnriknSutugk(String pAlias) {
        super("SV_KiykHnriknSutugk", SV_KiykHnriknSutugk.class, pAlias);
    }

    public String SV_KiykHnriknSutugk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_KiykHnriknSutugk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<SV_KiykHnriknSutugk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_KiykHnriknSutugk, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_KiykHnriknSutugk, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);
}
