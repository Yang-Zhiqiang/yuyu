package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;

/**
 * 新契約ＬＩＮＣ受信情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincJyusinInfo extends AbstractExDBTable<HT_SkLincJyusinInfo> {

    public GenQHT_SkLincJyusinInfo() {
        this("HT_SkLincJyusinInfo");
    }

    public GenQHT_SkLincJyusinInfo(String pAlias) {
        super("HT_SkLincJyusinInfo", HT_SkLincJyusinInfo.class, pAlias);
    }

    public String HT_SkLincJyusinInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincJyusinInfo, C_LincsoujyusinsysKbn> lincsoujyusinsyskbn = new ExDBFieldString<>("lincsoujyusinsyskbn", this, UserType_C_LincsoujyusinsysKbn.class);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckyknaiykekdatarenno = new ExDBFieldString<>("linckyknaiykekdatarenno", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, BizNumber> renno2 = new ExDBFieldString<>("renno2", this, BizNumberType.class);

    public final ExDBFieldString<HT_SkLincJyusinInfo, BizDate> sousinymd = new ExDBFieldString<>("sousinymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincsyorikekkakekkacd = new ExDBFieldNumber<>("lincsyorikekkakekkacd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincsyorikekkakekkajiyu = new ExDBFieldNumber<>("lincsyorikekkakekkajiyu", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincsyorikekkaerrkouban = new ExDBFieldNumber<>("lincsyorikekkaerrkouban", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincnayoserecordsuu = new ExDBFieldNumber<>("lincnayoserecordsuu", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> lincnayoseyomiknnm = new ExDBFieldString<>("lincnayoseyomiknnm", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linchhknseiymd = new ExDBFieldNumber<>("linchhknseiymd", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckeihidjnhyouji = new ExDBFieldNumber<>("linckeihidjnhyouji", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckykseiymd = new ExDBFieldNumber<>("linckykseiymd", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckjhngflg = new ExDBFieldNumber<>("linckjhngflg", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linctrkmousideymd = new ExDBFieldNumber<>("linctrkmousideymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckykytymd = new ExDBFieldNumber<>("linckykytymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linckykymd = new ExDBFieldNumber<>("linckykymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linchozenytymd = new ExDBFieldNumber<>("linchozenytymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linchozenymd = new ExDBFieldNumber<>("linchozenymd", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> lincsousinmotokaisya = new ExDBFieldString<>("lincsousinmotokaisya", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<HT_SkLincJyusinInfo> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linc15sai1000manflg = new ExDBFieldNumber<>("linc15sai1000manflg", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linclincsyoriymd = new ExDBFieldNumber<>("linclincsyoriymd", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckykkanrino = new ExDBFieldString<>("linckykkanrino", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincmousideflgsetymd = new ExDBFieldNumber<>("lincmousideflgsetymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincmousideflgkaijyoymd = new ExDBFieldNumber<>("lincmousideflgkaijyoymd", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<HT_SkLincJyusinInfo, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincJyusinInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
