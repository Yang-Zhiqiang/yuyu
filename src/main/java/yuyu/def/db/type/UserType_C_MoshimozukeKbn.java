package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MoshimozukeKbn;

/**
 * {@link C_MoshimozukeKbn 申込紐付区分} の Hibernate ユーザー定義型です。<br />
 * 申込紐付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MoshimozukeKbn extends AbstractUserType<C_MoshimozukeKbn> {

    @Override
    protected Class<C_MoshimozukeKbn> returnType() {
        return C_MoshimozukeKbn.class;
    }

    @Override
    protected C_MoshimozukeKbn valueOf(String pValue) {
        return C_MoshimozukeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MoshimozukeKbn pValue) {
        return pValue.getValue();
    }
}
