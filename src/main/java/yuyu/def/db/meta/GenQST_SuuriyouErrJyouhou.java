package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 数理用エラー情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SuuriyouErrJyouhou extends AbstractExDBTable<ST_SuuriyouErrJyouhou> {

    public GenQST_SuuriyouErrJyouhou() {
        this("ST_SuuriyouErrJyouhou");
    }

    public GenQST_SuuriyouErrJyouhou(String pAlias) {
        super("ST_SuuriyouErrJyouhou", ST_SuuriyouErrJyouhou.class, pAlias);
    }

    public String ST_SuuriyouErrJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SuuriyouErrJyouhou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_SuuriyouErrJyouhou, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<ST_SuuriyouErrJyouhou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<ST_SuuriyouErrJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<ST_SuuriyouErrJyouhou, String> suuritoukeiyouerrnaiyou = new ExDBFieldString<>("suuritoukeiyouerrnaiyou", this);
}
