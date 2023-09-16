package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;

/**
 * {@link C_YendthnkJyoutaiKbn 円建変更状態区分} の Hibernate ユーザー定義型です。<br />
 * 円建変更状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YendthnkJyoutaiKbn extends AbstractUserType<C_YendthnkJyoutaiKbn> {

    @Override
    protected Class<C_YendthnkJyoutaiKbn> returnType() {
        return C_YendthnkJyoutaiKbn.class;
    }

    @Override
    protected C_YendthnkJyoutaiKbn valueOf(String pValue) {
        return C_YendthnkJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YendthnkJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
