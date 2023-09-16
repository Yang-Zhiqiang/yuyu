package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 特約付加制限チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkTkykHukaSeigen extends AbstractExDBTable<BM_ChkTkykHukaSeigen> {

    public GenQBM_ChkTkykHukaSeigen() {
        this("BM_ChkTkykHukaSeigen");
    }

    public GenQBM_ChkTkykHukaSeigen(String pAlias) {
        super("BM_ChkTkykHukaSeigen", BM_ChkTkykHukaSeigen.class, pAlias);
    }

    public String BM_ChkTkykHukaSeigen() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkTkykHukaSeigen, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaSeigen, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaSeigen, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaSeigen, Integer> sntkhoukbnfrom = new ExDBFieldNumber<>("sntkhoukbnfrom", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaSeigen, Integer> sntkhoukbnto = new ExDBFieldNumber<>("sntkhoukbnto", this);

    public final ExDBFieldString<BM_ChkTkykHukaSeigen, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkTkykHukaSeigen, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkTkykHukaSeigen, String> tksyouhncd = new ExDBFieldString<>("tksyouhncd", this);
}
