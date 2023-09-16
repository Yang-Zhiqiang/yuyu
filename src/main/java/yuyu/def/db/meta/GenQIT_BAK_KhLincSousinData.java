package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.IT_BAK_KhLincSousinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_SousinKbn;

/**
 * 契約保全ＬＩＮＣ送信データバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhLincSousinData extends AbstractExDBTable<IT_BAK_KhLincSousinData> {

    public GenQIT_BAK_KhLincSousinData() {
        this("IT_BAK_KhLincSousinData");
    }

    public GenQIT_BAK_KhLincSousinData(String pAlias) {
        super("IT_BAK_KhLincSousinData", IT_BAK_KhLincSousinData.class, pAlias);
    }

    public String IT_BAK_KhLincSousinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, C_SousinKbn> lincsousinkbn = new ExDBFieldString<>("lincsousinkbn", this, UserType_C_SousinKbn.class);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linchhknseiymd = new ExDBFieldString<>("linchhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, C_KykKbn> linckeihidjnhyouji = new ExDBFieldString<>("linckeihidjnhyouji", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linckykseiymd = new ExDBFieldString<>("linckykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linctrkmousideymd = new ExDBFieldString<>("linctrkmousideymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linckykytymd = new ExDBFieldString<>("linckykytymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linckykymd = new ExDBFieldString<>("linckykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linchozenytymd = new ExDBFieldString<>("linchozenytymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> linchozenymd = new ExDBFieldString<>("linchozenymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinData> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> lincmousideflgsetymd = new ExDBFieldString<>("lincmousideflgsetymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, BizDate> lincmousideflgkaijyoymd = new ExDBFieldString<>("lincmousideflgkaijyoymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinData, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
