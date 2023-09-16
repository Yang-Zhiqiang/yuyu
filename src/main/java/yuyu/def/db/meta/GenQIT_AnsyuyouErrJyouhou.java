package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_AnsyuyouErrJyouhou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 案内収納用エラー情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_AnsyuyouErrJyouhou extends AbstractExDBTable<IT_AnsyuyouErrJyouhou> {

    public GenQIT_AnsyuyouErrJyouhou() {
        this("IT_AnsyuyouErrJyouhou");
    }

    public GenQIT_AnsyuyouErrJyouhou(String pAlias) {
        super("IT_AnsyuyouErrJyouhou", IT_AnsyuyouErrJyouhou.class, pAlias);
    }

    public String IT_AnsyuyouErrJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_AnsyuyouErrJyouhou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_AnsyuyouErrJyouhou, String> kakutyoujobcd = new ExDBFieldString<>("kakutyoujobcd", this);

    public final ExDBFieldString<IT_AnsyuyouErrJyouhou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_AnsyuyouErrJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_AnsyuyouErrJyouhou, String> ansyuyouerrnaiyou = new ExDBFieldString<>("ansyuyouerrnaiyou", this);
}
