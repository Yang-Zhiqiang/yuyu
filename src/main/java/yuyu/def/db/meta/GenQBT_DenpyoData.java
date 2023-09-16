package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import yuyu.def.db.type.UserType_C_DenSyorisyousaiKbn;
import yuyu.def.db.type.UserType_C_DenhnknhouKbn;
import yuyu.def.db.type.UserType_C_DenshrhouKbn;
import yuyu.def.db.type.UserType_C_DensyoriKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HenkinriyuuKbn;
import yuyu.def.db.type.UserType_C_HijynbrsikinidouyouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HuridensksKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KawasetekiyoKbn;
import yuyu.def.db.type.UserType_C_KessantyouseiKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 経理伝票データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_DenpyoData extends AbstractExDBTable<BT_DenpyoData> {

    public GenQBT_DenpyoData() {
        this("BT_DenpyoData");
    }

    public GenQBT_DenpyoData(String pAlias) {
        super("BT_DenpyoData", BT_DenpyoData.class, pAlias);
    }

    public String BT_DenpyoData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_DenpyoData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_DenpyoData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_DenpyoData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_DenpyoData, String> keirisyono = new ExDBFieldString<>("keirisyono", this);

    public final ExDBFieldString<BT_DenpyoData, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<BT_DenpyoData, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_DenpyoData, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<BT_DenpyoData, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_DenpyoData> dengaikagk = new ExDBFieldBizCurrency<>("dengaikagk", this);

    public final ExDBFieldString<BT_DenpyoData, BizNumber> denkawaserate = new ExDBFieldString<>("denkawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BT_DenpyoData> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<BT_DenpyoData, C_HuridensksKbn> huridenskskbn = new ExDBFieldString<>("huridenskskbn", this, UserType_C_HuridensksKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_DenhnknhouKbn> denhnknhoukbn = new ExDBFieldString<>("denhnknhoukbn", this, UserType_C_DenhnknhouKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_DenshrhouKbn> denshrhoukbn = new ExDBFieldString<>("denshrhoukbn", this, UserType_C_DenshrhouKbn.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BT_DenpyoData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<BT_DenpyoData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_DenpyoData, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_DenpyoData, C_KessantyouseiKbn> kessantyouseikbn = new ExDBFieldString<>("kessantyouseikbn", this, UserType_C_KessantyouseiKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<BT_DenpyoData, C_DensyoriKbn> densyorikbn = new ExDBFieldString<>("densyorikbn", this, UserType_C_DensyoriKbn.class);

    public final ExDBFieldString<BT_DenpyoData, String> aatsukaishasuitososhikicd = new ExDBFieldString<>("aatsukaishasuitososhikicd", this);

    public final ExDBFieldString<BT_DenpyoData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_DenpyoData, String> aatsukaishasoshikicd = new ExDBFieldString<>("aatsukaishasoshikicd", this);

    public final ExDBFieldString<BT_DenpyoData, String> aatkisyadaibosyuucd = new ExDBFieldString<>("aatkisyadaibosyuucd", this);

    public final ExDBFieldString<BT_DenpyoData, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<BT_DenpyoData, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_DenpyoData, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<BT_DenpyoData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BT_DenpyoData, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, C_HenkinriyuuKbn> hnknriyuukbn = new ExDBFieldString<>("hnknriyuukbn", this, UserType_C_HenkinriyuuKbn.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> fstpryosyuymd = new ExDBFieldString<>("fstpryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, String> aatkisyabosyuucd = new ExDBFieldString<>("aatkisyabosyuucd", this);

    public final ExDBFieldString<BT_DenpyoData, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BT_DenpyoData, Boolean> kakokawaserateshiteiflg = new ExDBFieldString<>("kakokawaserateshiteiflg", this, BooleanType.class);

    public final ExDBFieldString<BT_DenpyoData, BizDate> kakokawaserateshiteiymd = new ExDBFieldString<>("kakokawaserateshiteiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DenpyoData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_DenpyoData> keiyakutuukagk = new ExDBFieldBizCurrency<>("keiyakutuukagk", this);

    public final ExDBFieldString<BT_DenpyoData, String> dengyoumucd = new ExDBFieldString<>("dengyoumucd", this);

    public final ExDBFieldString<BT_DenpyoData, C_KawasetekiyoKbn> kawasetekiyokbn = new ExDBFieldString<>("kawasetekiyokbn", this, UserType_C_KawasetekiyoKbn.class);

    public final ExDBFieldString<BT_DenpyoData, String> denkarikanjyono = new ExDBFieldString<>("denkarikanjyono", this);

    public final ExDBFieldString<BT_DenpyoData, Boolean> taisyakutyouseiflg = new ExDBFieldString<>("taisyakutyouseiflg", this, BooleanType.class);

    public final ExDBFieldString<BT_DenpyoData, C_HijynbrsikinidouyouKbn> hijynbrsikinidouyoukbn = new ExDBFieldString<>("hijynbrsikinidouyoukbn", this, UserType_C_HijynbrsikinidouyouKbn.class);

    public final ExDBFieldBizCurrency<BT_DenpyoData> hijynbrsikinidougk = new ExDBFieldBizCurrency<>("hijynbrsikinidougk", this);

    public final ExDBFieldString<BT_DenpyoData, C_DenSyorisyousaiKbn> densyorisyousaikbn = new ExDBFieldString<>("densyorisyousaikbn", this, UserType_C_DenSyorisyousaiKbn.class);

    public final ExDBFieldString<BT_DenpyoData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_DenpyoData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
