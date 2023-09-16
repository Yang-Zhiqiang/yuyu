package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_Simekiribi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 締切日マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Simekiribi extends AbstractExDBTable<BM_Simekiribi> {

    public GenQBM_Simekiribi() {
        this("BM_Simekiribi");
    }

    public GenQBM_Simekiribi(String pAlias) {
        super("BM_Simekiribi", BM_Simekiribi.class, pAlias);
    }

    public String BM_Simekiribi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Simekiribi, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> mossimefromymd = new ExDBFieldString<>("mossimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> mossimetoymd = new ExDBFieldString<>("mossimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> mosnrksimefromymd = new ExDBFieldString<>("mosnrksimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> mosnrksimetoymd = new ExDBFieldString<>("mosnrksimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> kktsimefromymd = new ExDBFieldString<>("kktsimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> kktsimetoymd = new ExDBFieldString<>("kktsimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> hjysimefromymd = new ExDBFieldString<>("hjysimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> hjysimetoymd = new ExDBFieldString<>("hjysimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> nyknsimefromymd = new ExDBFieldString<>("nyknsimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> nyknsimetoymd = new ExDBFieldString<>("nyknsimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> syorisimefromymd = new ExDBFieldString<>("syorisimefromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, BizDate> syorisimetoymd = new ExDBFieldString<>("syorisimetoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Simekiribi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Simekiribi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
