package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_HuridenpageKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;

/**
 * 新契約追込調整伝票データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SkOikmTyouseiDenpyou extends AbstractExDBTable<ST_SkOikmTyouseiDenpyou> {

    public GenQST_SkOikmTyouseiDenpyou() {
        this("ST_SkOikmTyouseiDenpyou");
    }

    public GenQST_SkOikmTyouseiDenpyou(String pAlias) {
        super("ST_SkOikmTyouseiDenpyou", ST_SkOikmTyouseiDenpyou.class, pAlias);
    }

    public String ST_SkOikmTyouseiDenpyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> denkanjokamokucd = new ExDBFieldString<>("denkanjokamokucd", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> tekiyoucd = new ExDBFieldString<>("tekiyoucd", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldBizCurrency<ST_SkOikmTyouseiDenpyou> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, C_HuridenpageKbn> huridenpagekbn = new ExDBFieldString<>("huridenpagekbn", this, UserType_C_HuridenpageKbn.class);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<ST_SkOikmTyouseiDenpyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
