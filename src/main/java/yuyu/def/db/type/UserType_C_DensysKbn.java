package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DensysKbn;

/**
 * {@link C_DensysKbn 伝票用システム区分} の Hibernate ユーザー定義型です。<br />
 * 伝票用システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DensysKbn extends AbstractUserType<C_DensysKbn> {

    @Override
    protected Class<C_DensysKbn> returnType() {
        return C_DensysKbn.class;
    }

    @Override
    protected C_DensysKbn valueOf(String pValue) {
        return C_DensysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DensysKbn pValue) {
        return pValue.getValue();
    }
}
