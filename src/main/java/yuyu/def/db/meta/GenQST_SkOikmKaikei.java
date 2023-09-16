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
import yuyu.def.db.entity.ST_SkOikmKaikei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
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
 * 新契約追込会計取引データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SkOikmKaikei extends AbstractExDBTable<ST_SkOikmKaikei> {

    public GenQST_SkOikmKaikei() {
        this("ST_SkOikmKaikei");
    }

    public GenQST_SkOikmKaikei(String pAlias) {
        super("ST_SkOikmKaikei", ST_SkOikmKaikei.class, pAlias);
    }

    public String ST_SkOikmKaikei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SkOikmKaikei, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<ST_SkOikmKaikei, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<ST_SkOikmKaikei> dengaikagk = new ExDBFieldBizCurrency<>("dengaikagk", this);

    public final ExDBFieldString<ST_SkOikmKaikei, BizNumber> denkawaserate = new ExDBFieldString<>("denkawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<ST_SkOikmKaikei> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_KessantyouseiKbn> kessantyouseikbn = new ExDBFieldString<>("kessantyouseikbn", this, UserType_C_KessantyouseiKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_DensyoriKbn> densyorikbn = new ExDBFieldString<>("densyorikbn", this, UserType_C_DensyoriKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> aatsukaishasuitososhikicd = new ExDBFieldString<>("aatsukaishasuitososhikicd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, C_HenkinriyuuKbn> hnknriyuukbn = new ExDBFieldString<>("hnknriyuukbn", this, UserType_C_HenkinriyuuKbn.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> fstpryosyuymd = new ExDBFieldString<>("fstpryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<ST_SkOikmKaikei, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<ST_SkOikmKaikei, String> aatsukaishasoshikicd = new ExDBFieldString<>("aatsukaishasoshikicd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> aatkisyadaibosyuucd = new ExDBFieldString<>("aatkisyadaibosyuucd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> aatkisyabosyuucd = new ExDBFieldString<>("aatkisyabosyuucd", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<ST_SkOikmKaikei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
