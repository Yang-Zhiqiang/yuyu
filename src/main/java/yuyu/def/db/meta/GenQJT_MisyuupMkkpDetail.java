package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 未収Ｐ未経過Ｐ明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_MisyuupMkkpDetail extends AbstractExDBTable<JT_MisyuupMkkpDetail> {

    public GenQJT_MisyuupMkkpDetail() {
        this("JT_MisyuupMkkpDetail");
    }

    public GenQJT_MisyuupMkkpDetail(String pAlias) {
        super("JT_MisyuupMkkpDetail", JT_MisyuupMkkpDetail.class, pAlias);
    }

    public String JT_MisyuupMkkpDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldBizCurrency<JT_MisyuupMkkpDetail> dtlmisyuup = new ExDBFieldBizCurrency<>("dtlmisyuup", this);

    public final ExDBFieldBizCurrency<JT_MisyuupMkkpDetail> dtlmisyuupgaika = new ExDBFieldBizCurrency<>("dtlmisyuupgaika", this);

    public final ExDBFieldBizCurrency<JT_MisyuupMkkpDetail> dtlmisyuupgaikayenknsnkngk = new ExDBFieldBizCurrency<>("dtlmisyuupgaikayenknsnkngk", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, C_UmuKbn> dtlmisyuupiktnkumu = new ExDBFieldString<>("dtlmisyuupiktnkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, C_Hrkkaisuu> dtlmisyuuphrkkaisuu = new ExDBFieldString<>("dtlmisyuuphrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> dtlmisyuupjtkaisuuy = new ExDBFieldNumber<>("dtlmisyuupjtkaisuuy", this);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> dtlmisyuupjtkaisuum = new ExDBFieldNumber<>("dtlmisyuupjtkaisuum", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, BizDateYM> dtlmisyuupjytym = new ExDBFieldString<>("dtlmisyuupjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<JT_MisyuupMkkpDetail> dtlmikeikap = new ExDBFieldBizCurrency<>("dtlmikeikap", this);

    public final ExDBFieldBizCurrency<JT_MisyuupMkkpDetail> dtlmikeikapgaika = new ExDBFieldBizCurrency<>("dtlmikeikapgaika", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, BizDate> dtlmikeikapnykdenymd = new ExDBFieldString<>("dtlmikeikapnykdenymd", this, BizDateType.class);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, C_Hrkkaisuu> dtlmikeikaphrkkaisuu = new ExDBFieldString<>("dtlmikeikaphrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> dtlmikeikapjtkaisuuy = new ExDBFieldNumber<>("dtlmikeikapjtkaisuuy", this);

    public final ExDBFieldNumber<JT_MisyuupMkkpDetail, Integer> dtlmikeikapjtkaisuum = new ExDBFieldNumber<>("dtlmikeikapjtkaisuum", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, BizDateYM> dtlmikeikapjytym = new ExDBFieldString<>("dtlmikeikapjytym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_MisyuupMkkpDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
