package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 通常配当所要額情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_TuujyuHitusyyugk extends AbstractExDBTable<SV_TuujyuHitusyyugk> {

    public GenQSV_TuujyuHitusyyugk() {
        this("SV_TuujyuHitusyyugk");
    }

    public GenQSV_TuujyuHitusyyugk(String pAlias) {
        super("SV_TuujyuHitusyyugk", SV_TuujyuHitusyyugk.class, pAlias);
    }

    public String SV_TuujyuHitusyyugk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_TuujyuHitusyyugk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<SV_TuujyuHitusyyugk, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<SV_TuujyuHitusyyugk, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_UmuKbn> syuusinhknumu = new ExDBFieldString<>("syuusinhknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldNumber<SV_TuujyuHitusyyugk, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldNumber<SV_TuujyuHitusyyugk, Integer> mvatekikkn = new ExDBFieldNumber<>("mvatekikkn", this);

    public final ExDBFieldString<SV_TuujyuHitusyyugk, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_TuujyuHitusyyugk> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);
}
