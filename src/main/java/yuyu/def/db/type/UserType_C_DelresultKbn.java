package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DelresultKbn;

/**
 * {@link C_DelresultKbn 削除結果区分} の Hibernate ユーザー定義型です。<br />
 * 削除結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DelresultKbn extends AbstractUserType<C_DelresultKbn> {

    @Override
    protected Class<C_DelresultKbn> returnType() {
        return C_DelresultKbn.class;
    }

    @Override
    protected C_DelresultKbn valueOf(String pValue) {
        return C_DelresultKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DelresultKbn pValue) {
        return pValue.getValue();
    }
}
