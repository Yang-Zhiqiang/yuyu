package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.HT_SkLincSousinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_SousinKbn;

/**
 * 新契約ＬＩＮＣ送信データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincSousinData extends AbstractExDBTable<HT_SkLincSousinData> {

    public GenQHT_SkLincSousinData() {
        this("HT_SkLincSousinData");
    }

    public GenQHT_SkLincSousinData(String pAlias) {
        super("HT_SkLincSousinData", HT_SkLincSousinData.class, pAlias);
    }

    public String HT_SkLincSousinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincSousinData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SkLincSousinData, C_SousinKbn> lincsousinkbn = new ExDBFieldString<>("lincsousinkbn", this, UserType_C_SousinKbn.class);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<HT_SkLincSousinData, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linchhknseiymd = new ExDBFieldString<>("linchhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldString<HT_SkLincSousinData, C_KykKbn> linckeihidjnhyouji = new ExDBFieldString<>("linckeihidjnhyouji", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_SkLincSousinData, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linckykseiymd = new ExDBFieldString<>("linckykseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linctrkmousideymd = new ExDBFieldString<>("linctrkmousideymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linckykytymd = new ExDBFieldString<>("linckykytymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linckykymd = new ExDBFieldString<>("linckykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linchozenytymd = new ExDBFieldString<>("linchozenytymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> linchozenymd = new ExDBFieldString<>("linchozenymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinData> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> lincmousideflgsetymd = new ExDBFieldString<>("lincmousideflgsetymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSousinData, BizDate> lincmousideflgkaijyoymd = new ExDBFieldString<>("lincmousideflgkaijyoymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<HT_SkLincSousinData, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincSousinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
