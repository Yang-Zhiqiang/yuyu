package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;

/**
 * 新契約追込保険料伝票データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SkOikmSyukeiPDenpyou extends AbstractExDBTable<ST_SkOikmSyukeiPDenpyou> {

    public GenQST_SkOikmSyukeiPDenpyou() {
        this("ST_SkOikmSyukeiPDenpyou");
    }

    public GenQST_SkOikmSyukeiPDenpyou(String pAlias) {
        super("ST_SkOikmSyukeiPDenpyou", ST_SkOikmSyukeiPDenpyou.class, pAlias);
    }

    public String ST_SkOikmSyukeiPDenpyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<ST_SkOikmSyukeiPDenpyou, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> tekiyoucd = new ExDBFieldString<>("tekiyoucd", this);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldBizCurrency<ST_SkOikmSyukeiPDenpyou> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<ST_SkOikmSyukeiPDenpyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
