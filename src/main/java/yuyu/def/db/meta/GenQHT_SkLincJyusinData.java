package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;

/**
 * 新契約ＬＩＮＣ受信データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincJyusinData extends AbstractExDBTable<HT_SkLincJyusinData> {

    public GenQHT_SkLincJyusinData() {
        this("HT_SkLincJyusinData");
    }

    public GenQHT_SkLincJyusinData(String pAlias) {
        super("HT_SkLincJyusinData", HT_SkLincJyusinData.class, pAlias);
    }

    public String HT_SkLincJyusinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckyknaiykekdatarenno = new ExDBFieldString<>("linckyknaiykekdatarenno", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckyknaiykekdatarennooya = new ExDBFieldString<>("linckyknaiykekdatarennooya", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> lincsousinymd = new ExDBFieldString<>("lincsousinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> lincdatasyubetu = new ExDBFieldString<>("lincdatasyubetu", this);

    public final ExDBFieldString<HT_SkLincJyusinData, C_LincsoujyusinsysKbn> lincsoujyusinsyskbn = new ExDBFieldString<>("lincsoujyusinsyskbn", this, UserType_C_LincsoujyusinsysKbn.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> rendoumosnochknasi = new ExDBFieldString<>("rendoumosnochknasi", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincsyorikekkakekkacd = new ExDBFieldNumber<>("lincsyorikekkakekkacd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincsyorikekkakekkajiyu = new ExDBFieldNumber<>("lincsyorikekkakekkajiyu", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincsyorikekkaerrkouban = new ExDBFieldNumber<>("lincsyorikekkaerrkouban", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincnayoserecordsuu = new ExDBFieldNumber<>("lincnayoserecordsuu", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> lincnayoseyomiknnm = new ExDBFieldString<>("lincnayoseyomiknnm", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linchhknseiymd = new ExDBFieldString<>("linchhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldString<HT_SkLincJyusinData, C_KykKbn> linckeihidjnhyouji = new ExDBFieldString<>("linckeihidjnhyouji", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linckykseiymd = new ExDBFieldString<>("linckykseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> linckjhngflg = new ExDBFieldNumber<>("linckjhngflg", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linctrkmousideymd = new ExDBFieldString<>("linctrkmousideymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linckykytymd = new ExDBFieldString<>("linckykytymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linckykymd = new ExDBFieldString<>("linckykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linchozenytymd = new ExDBFieldString<>("linchozenytymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linchozenymd = new ExDBFieldString<>("linchozenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> lincsousinmotokaisya = new ExDBFieldString<>("lincsousinmotokaisya", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinData> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> linc15sai1000manflg = new ExDBFieldNumber<>("linc15sai1000manflg", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> linclincsyoriymd = new ExDBFieldString<>("linclincsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckykkanrino = new ExDBFieldString<>("linckykkanrino", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> lincmousideflgsetymd = new ExDBFieldString<>("lincmousideflgsetymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinData, BizDate> lincmousideflgkaijyoymd = new ExDBFieldString<>("lincmousideflgkaijyoymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<HT_SkLincJyusinData, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincJyusinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
