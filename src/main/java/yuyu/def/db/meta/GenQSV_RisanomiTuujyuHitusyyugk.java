package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 利差のみ通常配当所要額情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_RisanomiTuujyuHitusyyugk extends AbstractExDBTable<SV_RisanomiTuujyuHitusyyugk> {

    public GenQSV_RisanomiTuujyuHitusyyugk() {
        this("SV_RisanomiTuujyuHitusyyugk");
    }

    public GenQSV_RisanomiTuujyuHitusyyugk(String pAlias) {
        super("SV_RisanomiTuujyuHitusyyugk", SV_RisanomiTuujyuHitusyyugk.class, pAlias);
    }

    public String SV_RisanomiTuujyuHitusyyugk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<SV_RisanomiTuujyuHitusyyugk, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<SV_RisanomiTuujyuHitusyyugk, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_UmuKbn> syuusinhknumu = new ExDBFieldString<>("syuusinhknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldNumber<SV_RisanomiTuujyuHitusyyugk, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldNumber<SV_RisanomiTuujyuHitusyyugk, Integer> mvatekikkn = new ExDBFieldNumber<>("mvatekikkn", this);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_RisanomiTuujyuHitusyyugk> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_RisanomiTuujyuHitusyyugk, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);
}
