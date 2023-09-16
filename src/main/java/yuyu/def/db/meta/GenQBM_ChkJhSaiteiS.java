package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｓ事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhSaiteiS extends AbstractExDBTable<BM_ChkJhSaiteiS> {

    public GenQBM_ChkJhSaiteiS() {
        this("BM_ChkJhSaiteiS");
    }

    public GenQBM_ChkJhSaiteiS(String pAlias) {
        super("BM_ChkJhSaiteiS", BM_ChkJhSaiteiS.class, pAlias);
    }

    public String BM_ChkJhSaiteiS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhSaiteiS, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> dntsdnumufrom = new ExDBFieldNumber<>("dntsdnumufrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> dntsdnumuto = new ExDBFieldNumber<>("dntsdnumuto", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> hrkkknsmnkbnfrom = new ExDBFieldNumber<>("hrkkknsmnkbnfrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> hrkkknsmnkbnto = new ExDBFieldNumber<>("hrkkknsmnkbnto", this);

    public final ExDBFieldString<BM_ChkJhSaiteiS, BizNumber> hknkknfrom = new ExDBFieldString<>("hknkknfrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhSaiteiS, BizNumber> hknkknto = new ExDBFieldString<>("hknkknto", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> saiteisknwtkumufrom = new ExDBFieldNumber<>("saiteisknwtkumufrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiS, Integer> saiteisknwtkumuto = new ExDBFieldNumber<>("saiteisknwtkumuto", this);

    public final ExDBFieldString<BM_ChkJhSaiteiS, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BM_ChkJhSaiteiS> saiteis = new ExDBFieldBizCurrency<>("saiteis", this);
}
