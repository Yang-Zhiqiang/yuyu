package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SamakatariyuuKbn;

/**
 * {@link C_SamakatariyuuKbn 様方理由区分} の Hibernate ユーザー定義型です。<br />
 * 様方理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SamakatariyuuKbn extends AbstractUserType<C_SamakatariyuuKbn> {

    @Override
    protected Class<C_SamakatariyuuKbn> returnType() {
        return C_SamakatariyuuKbn.class;
    }

    @Override
    protected C_SamakatariyuuKbn valueOf(String pValue) {
        return C_SamakatariyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SamakatariyuuKbn pValue) {
        return pValue.getValue();
    }
}
