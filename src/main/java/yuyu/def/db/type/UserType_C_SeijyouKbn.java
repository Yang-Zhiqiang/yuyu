package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeijyouKbn;

/**
 * {@link C_SeijyouKbn 正常区分} の Hibernate ユーザー定義型です。<br />
 * 正常区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeijyouKbn extends AbstractUserType<C_SeijyouKbn> {

    @Override
    protected Class<C_SeijyouKbn> returnType() {
        return C_SeijyouKbn.class;
    }

    @Override
    protected C_SeijyouKbn valueOf(String pValue) {
        return C_SeijyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeijyouKbn pValue) {
        return pValue.getValue();
    }
}
