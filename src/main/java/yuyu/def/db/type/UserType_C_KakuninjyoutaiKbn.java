package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KakuninjyoutaiKbn;

/**
 * {@link C_KakuninjyoutaiKbn 確認状態区分} の Hibernate ユーザー定義型です。<br />
 * 確認状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KakuninjyoutaiKbn extends AbstractUserType<C_KakuninjyoutaiKbn> {

    @Override
    protected Class<C_KakuninjyoutaiKbn> returnType() {
        return C_KakuninjyoutaiKbn.class;
    }

    @Override
    protected C_KakuninjyoutaiKbn valueOf(String pValue) {
        return C_KakuninjyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KakuninjyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
