package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoriJyoutaiKbn;

/**
 * {@link C_SyoriJyoutaiKbn 処理状態区分} の Hibernate ユーザー定義型です。<br />
 * 処理状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoriJyoutaiKbn extends AbstractUserType<C_SyoriJyoutaiKbn> {

    @Override
    protected Class<C_SyoriJyoutaiKbn> returnType() {
        return C_SyoriJyoutaiKbn.class;
    }

    @Override
    protected C_SyoriJyoutaiKbn valueOf(String pValue) {
        return C_SyoriJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoriJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
