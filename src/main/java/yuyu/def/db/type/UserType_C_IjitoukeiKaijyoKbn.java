package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;

/**
 * {@link C_IjitoukeiKaijyoKbn 医事統計解除区分} の Hibernate ユーザー定義型です。<br />
 * 医事統計解除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IjitoukeiKaijyoKbn extends AbstractUserType<C_IjitoukeiKaijyoKbn> {

    @Override
    protected Class<C_IjitoukeiKaijyoKbn> returnType() {
        return C_IjitoukeiKaijyoKbn.class;
    }

    @Override
    protected C_IjitoukeiKaijyoKbn valueOf(String pValue) {
        return C_IjitoukeiKaijyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IjitoukeiKaijyoKbn pValue) {
        return pValue.getValue();
    }
}
