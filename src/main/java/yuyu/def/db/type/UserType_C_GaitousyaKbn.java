package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GaitousyaKbn;

/**
 * {@link C_GaitousyaKbn 該当者区分} の Hibernate ユーザー定義型です。<br />
 * 該当者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GaitousyaKbn extends AbstractUserType<C_GaitousyaKbn> {

    @Override
    protected Class<C_GaitousyaKbn> returnType() {
        return C_GaitousyaKbn.class;
    }

    @Override
    protected C_GaitousyaKbn valueOf(String pValue) {
        return C_GaitousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GaitousyaKbn pValue) {
        return pValue.getValue();
    }
}
