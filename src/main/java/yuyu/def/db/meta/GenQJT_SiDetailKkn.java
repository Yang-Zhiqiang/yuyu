package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_SensinItijikinShrUmuKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrtaisyouKbn;
import yuyu.def.classification.C_SyujyutuHousiki;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiDetailKkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.db.type.UserType_C_HushrSyousaiKbn;
import yuyu.def.db.type.UserType_C_SensinItijikinShrUmuKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_ShrtaisyouKbn;
import yuyu.def.db.type.UserType_C_SyujyutuHousiki;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払明細期間テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiDetailKkn extends AbstractExDBTable<JT_SiDetailKkn> {

    public GenQJT_SiDetailKkn() {
        this("JT_SiDetailKkn");
    }

    public GenQJT_SiDetailKkn(String pAlias) {
        super("JT_SiDetailKkn", JT_SiDetailKkn.class, pAlias);
    }

    public String JT_SiDetailKkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiDetailKkn, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> renno2keta2 = new ExDBFieldNumber<>("renno2keta2", this);

    public final ExDBFieldString<JT_SiDetailKkn, C_ShrtaisyouKbn> shrtaisyoukbn = new ExDBFieldString<>("shrtaisyoukbn", this, UserType_C_ShrtaisyouKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, BizDate> taisyoukknfrom = new ExDBFieldString<>("taisyoukknfrom", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDetailKkn, BizDate> taisyoukknto = new ExDBFieldString<>("taisyoukknto", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDetailKkn, BizDate> seikyuukknfrom = new ExDBFieldString<>("seikyuukknfrom", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDetailKkn, BizDate> seikyuukknto = new ExDBFieldString<>("seikyuukknto", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDetailKkn, String> syujyututourokuno = new ExDBFieldString<>("syujyututourokuno", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> kjcd1 = new ExDBFieldString<>("kjcd1", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> kjcd2 = new ExDBFieldString<>("kjcd2", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> kjcd3 = new ExDBFieldString<>("kjcd3", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> syujyutunmkn = new ExDBFieldString<>("syujyutunmkn", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> syujyutunmkj = new ExDBFieldString<>("syujyutunmkj", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> jyouken = new ExDBFieldString<>("jyouken", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> syujyutubunruicd = new ExDBFieldString<>("syujyutubunruicd", this);

    public final ExDBFieldString<JT_SiDetailKkn, C_SyujyutuHousiki> syujyutuhousiki = new ExDBFieldString<>("syujyutuhousiki", this, UserType_C_SyujyutuHousiki.class);

    public final ExDBFieldBizCurrency<JT_SiDetailKkn> sensingijuturyou = new ExDBFieldBizCurrency<>("sensingijuturyou", this);

    public final ExDBFieldString<JT_SiDetailKkn, C_SensinItijikinShrUmuKbn> sensinitijikinshrumukbn = new ExDBFieldString<>("sensinitijikinshrumukbn", this, UserType_C_SensinItijikinShrUmuKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, C_3daiSippeiHknShrRiyuuKbn> sandaisippeihknshrriyuukbn = new ExDBFieldString<>("sandaisippeihknshrriyuukbn", this, UserType_C_3daiSippeiHknShrRiyuuKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, C_HushrSyousaiKbn> hushrsyousaikbn = new ExDBFieldString<>("hushrsyousaikbn", this, UserType_C_HushrSyousaiKbn.class);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> hutanpoflg = new ExDBFieldNumber<>("hutanpoflg", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> itinyuuingendotyoukaflg = new ExDBFieldNumber<>("itinyuuingendotyoukaflg", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> tuusangendotyoukaflg = new ExDBFieldNumber<>("tuusangendotyoukaflg", this);

    public final ExDBFieldNumber<JT_SiDetailKkn, Integer> gannyuuinflg = new ExDBFieldNumber<>("gannyuuinflg", this);

    public final ExDBFieldString<JT_SiDetailKkn, C_UmuKbn> nyuuintyuuflg = new ExDBFieldString<>("nyuuintyuuflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, C_UmuKbn> kyhknskgnkkntaisyouumukbn = new ExDBFieldString<>("kyhknskgnkkntaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiDetailKkn, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiDetailKkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
