package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Delflag;

/**
 * {@link C_Delflag 削除フラグ} の Hibernate ユーザー定義型です。<br />
 * 削除フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Delflag extends AbstractUserType<C_Delflag> {

    @Override
    protected Class<C_Delflag> returnType() {
        return C_Delflag.class;
    }

    @Override
    protected C_Delflag valueOf(String pValue) {
        return C_Delflag.valueOf(pValue);
    }

    @Override
    protected String toString(C_Delflag pValue) {
        return pValue.getValue();
    }
}
