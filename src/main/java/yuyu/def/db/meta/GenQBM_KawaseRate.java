package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KawasetekiyoKbn;
import yuyu.def.db.type.UserType_C_KawasetsryKbn;
import yuyu.def.db.type.UserType_C_KwsrendouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 為替レートマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KawaseRate extends AbstractExDBTable<BM_KawaseRate> {

    public GenQBM_KawaseRate() {
        this("BM_KawaseRate");
    }

    public GenQBM_KawaseRate(String pAlias) {
        super("BM_KawaseRate", BM_KawaseRate.class, pAlias);
    }

    public String BM_KawaseRate() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KawaseRate, BizDate> kwsratekjymd = new ExDBFieldString<>("kwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KawaseRate, C_KwsrendouKbn> kwsrendoukbn = new ExDBFieldString<>("kwsrendoukbn", this, UserType_C_KwsrendouKbn.class);

    public final ExDBFieldString<BM_KawaseRate, C_Tuukasyu> mototuuka = new ExDBFieldString<>("mototuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_KawaseRate, C_Tuukasyu> kanzantuuka = new ExDBFieldString<>("kanzantuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_KawaseRate, C_KawasetekiyoKbn> kawasetekiyokbn = new ExDBFieldString<>("kawasetekiyokbn", this, UserType_C_KawasetekiyoKbn.class);

    public final ExDBFieldString<BM_KawaseRate, C_KawasetsryKbn> kawasetsrykbn = new ExDBFieldString<>("kawasetsrykbn", this, UserType_C_KawasetsryKbn.class);

    public final ExDBFieldString<BM_KawaseRate, BizNumber> kawaserate = new ExDBFieldString<>("kawaserate", this, BizNumberType.class);

    public final ExDBFieldString<BM_KawaseRate, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_KawaseRate, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_KawaseRate, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
