package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSaiteiS extends AbstractExDBTable<BM_ChkSaiteiS> {

    public GenQBM_ChkSaiteiS() {
        this("BM_ChkSaiteiS");
    }

    public GenQBM_ChkSaiteiS(String pAlias) {
        super("BM_ChkSaiteiS", BM_ChkSaiteiS.class, pAlias);
    }

    public String BM_ChkSaiteiS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSaiteiS, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> dntsdnumufrom = new ExDBFieldNumber<>("dntsdnumufrom", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> dntsdnumuto = new ExDBFieldNumber<>("dntsdnumuto", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> hrkkknsmnkbnfrom = new ExDBFieldNumber<>("hrkkknsmnkbnfrom", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> hrkkknsmnkbnto = new ExDBFieldNumber<>("hrkkknsmnkbnto", this);

    public final ExDBFieldString<BM_ChkSaiteiS, BizNumber> hknkknfrom = new ExDBFieldString<>("hknkknfrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkSaiteiS, BizNumber> hknkknto = new ExDBFieldString<>("hknkknto", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> saiteisknwtkumufrom = new ExDBFieldNumber<>("saiteisknwtkumufrom", this);

    public final ExDBFieldNumber<BM_ChkSaiteiS, Integer> saiteisknwtkumuto = new ExDBFieldNumber<>("saiteisknwtkumuto", this);

    public final ExDBFieldString<BM_ChkSaiteiS, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BM_ChkSaiteiS> saiteis = new ExDBFieldBizCurrency<>("saiteis", this);
}
