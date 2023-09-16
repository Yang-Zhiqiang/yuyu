package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;

/**
 * 精算Ｄ支払年月日管理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SeisanDShrymd extends AbstractExDBTable<BM_SeisanDShrymd> {

    public GenQBM_SeisanDShrymd() {
        this("BM_SeisanDShrymd");
    }

    public GenQBM_SeisanDShrymd(String pAlias) {
        super("BM_SeisanDShrymd", BM_SeisanDShrymd.class, pAlias);
    }

    public String BM_SeisanDShrymd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SeisanDShrymd, BizDateY> syorinendo = new ExDBFieldString<>("syorinendo", this, BizDateYType.class);

    public final ExDBFieldString<BM_SeisanDShrymd, BizDate> seisandshrymd = new ExDBFieldString<>("seisandshrymd", this, BizDateType.class);
}
