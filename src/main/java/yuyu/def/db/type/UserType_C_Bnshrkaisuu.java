package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bnshrkaisuu;

/**
 * {@link C_Bnshrkaisuu 分割支払回数} の Hibernate ユーザー定義型です。<br />
 * 分割支払回数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bnshrkaisuu extends AbstractUserType<C_Bnshrkaisuu> {

    @Override
    protected Class<C_Bnshrkaisuu> returnType() {
        return C_Bnshrkaisuu.class;
    }

    @Override
    protected C_Bnshrkaisuu valueOf(String pValue) {
        return C_Bnshrkaisuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bnshrkaisuu pValue) {
        return pValue.getValue();
    }
}
