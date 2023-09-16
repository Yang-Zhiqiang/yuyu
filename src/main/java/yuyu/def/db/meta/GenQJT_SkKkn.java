package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_SensinItijikinShrUmuKbn;
import yuyu.def.classification.C_SyujyutuHousiki;
import yuyu.def.db.entity.JT_SkKkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.db.type.UserType_C_KyuuhuKbn;
import yuyu.def.db.type.UserType_C_SensinItijikinShrUmuKbn;
import yuyu.def.db.type.UserType_C_SyujyutuHousiki;

/**
 * 請求期間テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SkKkn extends AbstractExDBTable<JT_SkKkn> {

    public GenQJT_SkKkn() {
        this("JT_SkKkn");
    }

    public GenQJT_SkKkn(String pAlias) {
        super("JT_SkKkn", JT_SkKkn.class, pAlias);
    }

    public String JT_SkKkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SkKkn, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SkKkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SkKkn, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SkKkn, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldString<JT_SkKkn, C_KyuuhuKbn> kyuuhukbn = new ExDBFieldString<>("kyuuhukbn", this, UserType_C_KyuuhuKbn.class);

    public final ExDBFieldNumber<JT_SkKkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_SkKkn, BizDate> kikanfrom = new ExDBFieldString<>("kikanfrom", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKkn, BizDate> kikanto = new ExDBFieldString<>("kikanto", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKkn, String> syujyututourokuno = new ExDBFieldString<>("syujyututourokuno", this);

    public final ExDBFieldString<JT_SkKkn, String> kjcd1 = new ExDBFieldString<>("kjcd1", this);

    public final ExDBFieldString<JT_SkKkn, String> kjcd2 = new ExDBFieldString<>("kjcd2", this);

    public final ExDBFieldString<JT_SkKkn, String> kjcd3 = new ExDBFieldString<>("kjcd3", this);

    public final ExDBFieldString<JT_SkKkn, String> syujyutunmkn = new ExDBFieldString<>("syujyutunmkn", this);

    public final ExDBFieldString<JT_SkKkn, String> syujyutunmkj = new ExDBFieldString<>("syujyutunmkj", this);

    public final ExDBFieldString<JT_SkKkn, String> jyouken = new ExDBFieldString<>("jyouken", this);

    public final ExDBFieldString<JT_SkKkn, String> syujyutubunruicd = new ExDBFieldString<>("syujyutubunruicd", this);

    public final ExDBFieldString<JT_SkKkn, C_SyujyutuHousiki> syujyutuhousiki = new ExDBFieldString<>("syujyutuhousiki", this, UserType_C_SyujyutuHousiki.class);

    public final ExDBFieldBizCurrency<JT_SkKkn> sensingijuturyou = new ExDBFieldBizCurrency<>("sensingijuturyou", this);

    public final ExDBFieldString<JT_SkKkn, C_SensinItijikinShrUmuKbn> sensinitijikinshrumukbn = new ExDBFieldString<>("sensinitijikinshrumukbn", this, UserType_C_SensinItijikinShrUmuKbn.class);

    public final ExDBFieldString<JT_SkKkn, C_3daiSippeiHknShrRiyuuKbn> sandaisippeihknshrriyuukbn = new ExDBFieldString<>("sandaisippeihknshrriyuukbn", this, UserType_C_3daiSippeiHknShrRiyuuKbn.class);

    public final ExDBFieldString<JT_SkKkn, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SkKkn, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SkKkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SkKkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
