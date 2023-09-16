package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HuridenpageKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KeirisysKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;

/**
 * 新契約決算用集計元データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SkKessanSyukei extends AbstractExDBTable<ST_SkKessanSyukei> {

    public GenQST_SkKessanSyukei() {
        this("ST_SkKessanSyukei");
    }

    public GenQST_SkKessanSyukei(String pAlias) {
        super("ST_SkKessanSyukei", ST_SkKessanSyukei.class, pAlias);
    }

    public String ST_SkKessanSyukei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SkKessanSyukei, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<ST_SkKessanSyukei, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<ST_SkKessanSyukei, C_KeirisysKbn> keirisyskbn = new ExDBFieldString<>("keirisyskbn", this, UserType_C_KeirisysKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<ST_SkKessanSyukei, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, String> denkanjokamokucd = new ExDBFieldString<>("denkanjokamokucd", this);

    public final ExDBFieldString<ST_SkKessanSyukei, String> tekiyoucd = new ExDBFieldString<>("tekiyoucd", this);

    public final ExDBFieldString<ST_SkKessanSyukei, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldBizCurrency<ST_SkKessanSyukei> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<ST_SkKessanSyukei, C_HuridenpageKbn> huridenpagekbn = new ExDBFieldString<>("huridenpagekbn", this, UserType_C_HuridenpageKbn.class);

    public final ExDBFieldString<ST_SkKessanSyukei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkKessanSyukei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<ST_SkKessanSyukei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
