package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SaigaiHigaitouKbn;
import yuyu.def.db.type.UserType_C_SaisateiKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * 請求情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJV_SeikyuuInfo extends AbstractExDBTable<JV_SeikyuuInfo> {

    public GenQJV_SeikyuuInfo() {
        this("JV_SeikyuuInfo");
    }

    public GenQJV_SeikyuuInfo(String pAlias) {
        super("JV_SeikyuuInfo", JV_SeikyuuInfo.class, pAlias);
    }

    public String JV_SeikyuuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JV_SeikyuuInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_SaisateiKbn> saisateikbn = new ExDBFieldString<>("saisateikbn", this, UserType_C_SaisateiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> siboukaritrkymd = new ExDBFieldString<>("siboukaritrkymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldNumber<JV_SeikyuuInfo, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizNumber> uktbnwari = new ExDBFieldString<>("uktbnwari", this, BizNumberType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuinaiyou1 = new ExDBFieldString<>("ttdktyuuinaiyou1", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuinaiyou2 = new ExDBFieldString<>("ttdktyuuinaiyou2", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuinaiyou3 = new ExDBFieldString<>("ttdktyuuinaiyou3", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_TtdktyuuiKbn> ttdktyuuikbn1 = new ExDBFieldString<>("ttdktyuuikbn1", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuikbnhsknaiyou1 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou1", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> ttdktyuuikbnsetymd1 = new ExDBFieldString<>("ttdktyuuikbnsetymd1", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_TtdktyuuiKbn> ttdktyuuikbn2 = new ExDBFieldString<>("ttdktyuuikbn2", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuikbnhsknaiyou2 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou2", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> ttdktyuuikbnsetymd2 = new ExDBFieldString<>("ttdktyuuikbnsetymd2", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_TtdktyuuiKbn> ttdktyuuikbn3 = new ExDBFieldString<>("ttdktyuuikbn3", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuikbnhsknaiyou3 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou3", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> ttdktyuuikbnsetymd3 = new ExDBFieldString<>("ttdktyuuikbnsetymd3", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_TtdktyuuiKbn> ttdktyuuikbn4 = new ExDBFieldString<>("ttdktyuuikbn4", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuikbnhsknaiyou4 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou4", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> ttdktyuuikbnsetymd4 = new ExDBFieldString<>("ttdktyuuikbnsetymd4", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_TtdktyuuiKbn> ttdktyuuikbn5 = new ExDBFieldString<>("ttdktyuuikbn5", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> ttdktyuuikbnhsknaiyou5 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou5", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> ttdktyuuikbnsetymd5 = new ExDBFieldString<>("ttdktyuuikbnsetymd5", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_SeikyuusyaKbn> seikyuusyakbn = new ExDBFieldString<>("seikyuusyakbn", this, UserType_C_SeikyuusyaKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, String> seikyuusyanmkn = new ExDBFieldString<>("seikyuusyanmkn", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> seikyuusyanmkj = new ExDBFieldString<>("seikyuusyanmkj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_SaigaiHigaitouKbn> saigaihigaitoukbn = new ExDBFieldString<>("saigaihigaitoukbn", this, UserType_C_SaigaiHigaitouKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizNumber> gaikaknsnkwsrate = new ExDBFieldString<>("gaikaknsnkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> gaikaknsnkwsratekjymd = new ExDBFieldString<>("gaikaknsnkwsratekjymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> hokenkngkgoukei = new ExDBFieldBizCurrency<>("hokenkngkgoukei", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> haitoukin = new ExDBFieldBizCurrency<>("haitoukin", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> sonotahaitoukin = new ExDBFieldBizCurrency<>("sonotahaitoukin", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> azukarikingk = new ExDBFieldBizCurrency<>("azukarikingk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenshrgk = new ExDBFieldBizCurrency<>("yenshrgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenhkgkgoukei = new ExDBFieldBizCurrency<>("yenhkgkgoukei", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkahaitoukin = new ExDBFieldBizCurrency<>("yenkahaitoukin", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkasonotahaitoukin = new ExDBFieldBizCurrency<>("yenkasonotahaitoukin", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkamisyuup = new ExDBFieldBizCurrency<>("yenkamisyuup", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkamikeikap = new ExDBFieldBizCurrency<>("yenkamikeikap", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkazennouseisankgk = new ExDBFieldBizCurrency<>("yenkazennouseisankgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkaazukarikingk = new ExDBFieldBizCurrency<>("yenkaazukarikingk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkakrkgk = new ExDBFieldBizCurrency<>("yenkakrkgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenshrtienrsk = new ExDBFieldBizCurrency<>("yenshrtienrsk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> zitkazukarikingkyen = new ExDBFieldBizCurrency<>("zitkazukarikingkyen", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> gaikaknsntkgk = new ExDBFieldBizCurrency<>("gaikaknsntkgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> gaikaknsnkekkakgk = new ExDBFieldBizCurrency<>("gaikaknsnkekkakgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkaknsntkgk = new ExDBFieldBizCurrency<>("yenkaknsntkgk", this);

    public final ExDBFieldBizCurrency<JV_SeikyuuInfo> yenkaknsnkekkakgk = new ExDBFieldBizCurrency<>("yenkaknsnkekkakgk", this);

    public final ExDBFieldString<JV_SeikyuuInfo, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SeikyuuInfo, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);
}
