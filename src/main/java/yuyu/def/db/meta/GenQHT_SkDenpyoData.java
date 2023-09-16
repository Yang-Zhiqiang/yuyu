package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkDenpyoData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import yuyu.def.db.type.UserType_C_DensyoriKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HenkinriyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KessantyouseiKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 新契約伝票データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkDenpyoData extends AbstractExDBTable<HT_SkDenpyoData> {

    public GenQHT_SkDenpyoData() {
        this("HT_SkDenpyoData");
    }

    public GenQHT_SkDenpyoData(String pAlias) {
        super("HT_SkDenpyoData", HT_SkDenpyoData.class, pAlias);
    }

    public String HT_SkDenpyoData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkDenpyoData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<HT_SkDenpyoData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_SkDenpyoData> dengaikagk = new ExDBFieldBizCurrency<>("dengaikagk", this);

    public final ExDBFieldString<HT_SkDenpyoData, BizNumber> denkawaserate = new ExDBFieldString<>("denkawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<HT_SkDenpyoData> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_KessantyouseiKbn> kessantyouseikbn = new ExDBFieldString<>("kessantyouseikbn", this, UserType_C_KessantyouseiKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_DensyoriKbn> densyorikbn = new ExDBFieldString<>("densyorikbn", this, UserType_C_DensyoriKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> aatsukaishasuitososhikicd = new ExDBFieldString<>("aatsukaishasuitososhikicd", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_HenkinriyuuKbn> hnknriyuukbn = new ExDBFieldString<>("hnknriyuukbn", this, UserType_C_HenkinriyuuKbn.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> fstpryosyuymd = new ExDBFieldString<>("fstpryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<HT_SkDenpyoData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> aatsukaishasoshikicd = new ExDBFieldString<>("aatsukaishasoshikicd", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> aatkisyadaibosyuucd = new ExDBFieldString<>("aatkisyadaibosyuucd", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> aatkisyabosyuucd = new ExDBFieldString<>("aatkisyabosyuucd", this);

    public final ExDBFieldString<HT_SkDenpyoData, Boolean> kakokawaserateshiteiflg = new ExDBFieldString<>("kakokawaserateshiteiflg", this, BooleanType.class);

    public final ExDBFieldString<HT_SkDenpyoData, BizDate> kakokawaserateshiteiymd = new ExDBFieldString<>("kakokawaserateshiteiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkDenpyoData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_SkDenpyoData> keiyakutuukagk = new ExDBFieldBizCurrency<>("keiyakutuukagk", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> dengyoumucd = new ExDBFieldString<>("dengyoumucd", this);

    public final ExDBFieldNumber<HT_SkDenpyoData, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> denkarikanjyono = new ExDBFieldString<>("denkarikanjyono", this);

    public final ExDBFieldString<HT_SkDenpyoData, Boolean> taisyakutyouseiflg = new ExDBFieldString<>("taisyakutyouseiflg", this, BooleanType.class);

    public final ExDBFieldString<HT_SkDenpyoData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkDenpyoData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
