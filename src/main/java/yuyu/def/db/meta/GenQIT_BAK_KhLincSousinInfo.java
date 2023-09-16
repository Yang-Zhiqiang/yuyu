package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.IT_BAK_KhLincSousinInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;
import yuyu.def.db.type.UserType_C_SousinKbn;

/**
 * 契約保全ＬＩＮＣ送信情報バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhLincSousinInfo extends AbstractExDBTable<IT_BAK_KhLincSousinInfo> {

    public GenQIT_BAK_KhLincSousinInfo() {
        this("IT_BAK_KhLincSousinInfo");
    }

    public GenQIT_BAK_KhLincSousinInfo(String pAlias) {
        super("IT_BAK_KhLincSousinInfo", IT_BAK_KhLincSousinInfo.class, pAlias);
    }

    public String IT_BAK_KhLincSousinInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, C_LincsoujyusinsysKbn> lincsoujyusinsyskbn = new ExDBFieldString<>("lincsoujyusinsyskbn", this, UserType_C_LincsoujyusinsysKbn.class);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, C_SousinKbn> lincsousinkbn = new ExDBFieldString<>("lincsousinkbn", this, UserType_C_SousinKbn.class);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> lincrecordsyubetu = new ExDBFieldNumber<>("lincrecordsyubetu", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linchenkoutype = new ExDBFieldString<>("linchenkoutype", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linchhknnmkn = new ExDBFieldString<>("linchhknnmkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linchhknnmkj = new ExDBFieldString<>("linchhknnmkj", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linchhknsei = new ExDBFieldNumber<>("linchhknsei", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linchhknseiymd = new ExDBFieldNumber<>("linchhknseiymd", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linchhknadrkn = new ExDBFieldString<>("linchhknadrkn", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linckeihidjnhyouji = new ExDBFieldNumber<>("linckeihidjnhyouji", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linckyknmkn = new ExDBFieldString<>("linckyknmkn", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linckyknmkj = new ExDBFieldString<>("linckyknmkj", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linckyksei = new ExDBFieldNumber<>("linckyksei", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linckykseiymd = new ExDBFieldNumber<>("linckykseiymd", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linckykadrkn = new ExDBFieldString<>("linckykadrkn", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linctrkmousideymd = new ExDBFieldNumber<>("linctrkmousideymd", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linckykytymd = new ExDBFieldNumber<>("linckykytymd", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linckykymd = new ExDBFieldNumber<>("linckykymd", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linchozenytymd = new ExDBFieldNumber<>("linchozenytymd", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> lincsgnyukyhng = new ExDBFieldBizCurrency<>("lincsgnyukyhng", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linchozenymd = new ExDBFieldNumber<>("linchozenymd", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> lincsipnyukyhng = new ExDBFieldBizCurrency<>("lincsipnyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> lincsjnyukyhng = new ExDBFieldBizCurrency<>("lincsjnyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> lincsonotanyukyhng = new ExDBFieldBizCurrency<>("lincsonotanyukyhng", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> linchutuusbs = new ExDBFieldBizCurrency<>("linchutuusbs", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhLincSousinInfo> lincsgsbksns = new ExDBFieldBizCurrency<>("lincsgsbksns", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> linckakusyasiyouran = new ExDBFieldString<>("linckakusyasiyouran", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> lincmousideflg = new ExDBFieldNumber<>("lincmousideflg", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> lincmousideflgsetymd = new ExDBFieldNumber<>("lincmousideflgsetymd", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> lincmousideflgkaijyoymd = new ExDBFieldNumber<>("lincmousideflgkaijyoymd", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> lincjgyhknflg = new ExDBFieldNumber<>("lincjgyhknflg", this);

    public final ExDBFieldNumber<IT_BAK_KhLincSousinInfo, Integer> linctenkanflg = new ExDBFieldNumber<>("linctenkanflg", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhLincSousinInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
