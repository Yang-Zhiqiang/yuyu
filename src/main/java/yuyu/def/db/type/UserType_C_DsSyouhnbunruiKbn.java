package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;

/**
 * {@link C_DsSyouhnbunruiKbn ＤＳ商品分類区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ商品分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSyouhnbunruiKbn extends AbstractUserType<C_DsSyouhnbunruiKbn> {

    @Override
    protected Class<C_DsSyouhnbunruiKbn> returnType() {
        return C_DsSyouhnbunruiKbn.class;
    }

    @Override
    protected C_DsSyouhnbunruiKbn valueOf(String pValue) {
        return C_DsSyouhnbunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSyouhnbunruiKbn pValue) {
        return pValue.getValue();
    }
}
