package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TokkoudosghtnpKbn;

/**
 * {@link C_TokkoudosghtnpKbn 特定高度障害不担保区分} の Hibernate ユーザー定義型です。<br />
 * 特定高度障害不担保区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TokkoudosghtnpKbn extends AbstractUserType<C_TokkoudosghtnpKbn> {

    @Override
    protected Class<C_TokkoudosghtnpKbn> returnType() {
        return C_TokkoudosghtnpKbn.class;
    }

    @Override
    protected C_TokkoudosghtnpKbn valueOf(String pValue) {
        return C_TokkoudosghtnpKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TokkoudosghtnpKbn pValue) {
        return pValue.getValue();
    }
}
