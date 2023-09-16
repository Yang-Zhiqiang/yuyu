package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TantouCdKbn;

/**
 * {@link C_TantouCdKbn 担当コード区分} の Hibernate ユーザー定義型です。<br />
 * 担当コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TantouCdKbn extends AbstractUserType<C_TantouCdKbn> {

    @Override
    protected Class<C_TantouCdKbn> returnType() {
        return C_TantouCdKbn.class;
    }

    @Override
    protected C_TantouCdKbn valueOf(String pValue) {
        return C_TantouCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TantouCdKbn pValue) {
        return pValue.getValue();
    }
}
