package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SueokiJyoutaiKbn;

/**
 * {@link C_SueokiJyoutaiKbn 据置状態区分} の Hibernate ユーザー定義型です。<br />
 * 据置状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SueokiJyoutaiKbn extends AbstractUserType<C_SueokiJyoutaiKbn> {

    @Override
    protected Class<C_SueokiJyoutaiKbn> returnType() {
        return C_SueokiJyoutaiKbn.class;
    }

    @Override
    protected C_SueokiJyoutaiKbn valueOf(String pValue) {
        return C_SueokiJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SueokiJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
