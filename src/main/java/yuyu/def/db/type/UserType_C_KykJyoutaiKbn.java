package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykJyoutaiKbn;

/**
 * {@link C_KykJyoutaiKbn 契約状態区分} の Hibernate ユーザー定義型です。<br />
 * 契約状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykJyoutaiKbn extends AbstractUserType<C_KykJyoutaiKbn> {

    @Override
    protected Class<C_KykJyoutaiKbn> returnType() {
        return C_KykJyoutaiKbn.class;
    }

    @Override
    protected C_KykJyoutaiKbn valueOf(String pValue) {
        return C_KykJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
