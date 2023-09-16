package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.HT_SkLincSousinInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;
import yuyu.def.db.type.UserType_C_SousinKbn;

/**
 * 新契約ＬＩＮＣ送信情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincSousinInfo extends AbstractExDBTable<HT_SkLincSousinInfo> {

    public GenQHT_SkLincSousinInfo() {
        this("HT_SkLincSousinInfo");
    }

    public GenQHT_SkLincSousinInfo(String pAlias) {
        super("HT_SkLincSousinInfo", HT_SkLincSousinInfo.class, pAlias);
    }

    public String HT_SkLincSousinInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincSousinInfo, C_LincsoujyusinsysKbn> lincsoujyusinsyskbn = new ExDBFieldString<>("lincsoujyusinsyskbn", this, UserType_C_LincsoujyusinsysKbn.class);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, C_SousinKbn> lincsousinkbn = new ExDBFieldString<>("lincsousinkbn", this, UserType_C_SousinKbn.class);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linchhknseiymd = new ExDBFieldNumber<>("linchhknseiymd", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linckeihidjnhyouji = new ExDBFieldNumber<>("linckeihidjnhyouji", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linckykseiymd = new ExDBFieldNumber<>("linckykseiymd", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linctrkmousideymd = new ExDBFieldNumber<>("linctrkmousideymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linckykytymd = new ExDBFieldNumber<>("linckykytymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linckykymd = new ExDBFieldNumber<>("linckykymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linchozenytymd = new ExDBFieldNumber<>("linchozenytymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linchozenymd = new ExDBFieldNumber<>("linchozenymd", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<HT_SkLincSousinInfo> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> lincmousideflgsetymd = new ExDBFieldNumber<>("lincmousideflgsetymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> lincmousideflgkaijyoymd = new ExDBFieldNumber<>("lincmousideflgkaijyoymd", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<HT_SkLincSousinInfo, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincSousinInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
