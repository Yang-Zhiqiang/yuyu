package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import yuyu.def.db.type.UserType_C_DenSyorisyousaiKbn;
import yuyu.def.db.type.UserType_C_DenhnknhouKbn;
import yuyu.def.db.type.UserType_C_DenshrhouKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HuridensksKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KawasetekiyoKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 契約保全伝票データバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhDenpyoData extends AbstractExDBTable<IT_BAK_KhDenpyoData> {

    public GenQIT_BAK_KhDenpyoData() {
        this("IT_BAK_KhDenpyoData");
    }

    public GenQIT_BAK_KhDenpyoData(String pAlias) {
        super("IT_BAK_KhDenpyoData", IT_BAK_KhDenpyoData.class, pAlias);
    }

    public String IT_BAK_KhDenpyoData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhDenpyoData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhDenpyoData> dengaikagk = new ExDBFieldBizCurrency<>("dengaikagk", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, BizNumber> denkawaserate = new ExDBFieldString<>("denkawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhDenpyoData> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_HuridensksKbn> huridenskskbn = new ExDBFieldString<>("huridenskskbn", this, UserType_C_HuridensksKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_DenhnknhouKbn> denhnknhoukbn = new ExDBFieldString<>("denhnknhoukbn", this, UserType_C_DenhnknhouKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_DenshrhouKbn> denshrhoukbn = new ExDBFieldString<>("denshrhoukbn", this, UserType_C_DenshrhouKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, Boolean> kakokawaserateshiteiflg = new ExDBFieldString<>("kakokawaserateshiteiflg", this, BooleanType.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, BizDate> kakokawaserateshiteiymd = new ExDBFieldString<>("kakokawaserateshiteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhDenpyoData> keiyakutuukagk = new ExDBFieldBizCurrency<>("keiyakutuukagk", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> dengyoumucd = new ExDBFieldString<>("dengyoumucd", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<IT_BAK_KhDenpyoData, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_KawasetekiyoKbn> kawasetekiyokbn = new ExDBFieldString<>("kawasetekiyokbn", this, UserType_C_KawasetekiyoKbn.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, String> denkarikanjyono = new ExDBFieldString<>("denkarikanjyono", this);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, Boolean> taisyakutyouseiflg = new ExDBFieldString<>("taisyakutyouseiflg", this, BooleanType.class);

    public final ExDBFieldString<IT_BAK_KhDenpyoData, C_DenSyorisyousaiKbn> densyorisyousaikbn = new ExDBFieldString<>("densyorisyousaikbn", this, UserType_C_DenSyorisyousaiKbn.class);
}
