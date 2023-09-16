package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MpAccountjtKbn;

/**
 * {@link C_MpAccountjtKbn マイページアカウント状態区分} の Hibernate ユーザー定義型です。<br />
 * マイページアカウント状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MpAccountjtKbn extends AbstractUserType<C_MpAccountjtKbn> {

    @Override
    protected Class<C_MpAccountjtKbn> returnType() {
        return C_MpAccountjtKbn.class;
    }

    @Override
    protected C_MpAccountjtKbn valueOf(String pValue) {
        return C_MpAccountjtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MpAccountjtKbn pValue) {
        return pValue.getValue();
    }
}
