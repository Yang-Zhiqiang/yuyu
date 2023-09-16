package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GkhnkzidourtKbn;

/**
 * {@link C_GkhnkzidourtKbn 外貨本口座移動ルート区分} の Hibernate ユーザー定義型です。<br />
 * 外貨本口座移動ルート区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GkhnkzidourtKbn extends AbstractUserType<C_GkhnkzidourtKbn> {

    @Override
    protected Class<C_GkhnkzidourtKbn> returnType() {
        return C_GkhnkzidourtKbn.class;
    }

    @Override
    protected C_GkhnkzidourtKbn valueOf(String pValue) {
        return C_GkhnkzidourtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GkhnkzidourtKbn pValue) {
        return pValue.getValue();
    }
}
