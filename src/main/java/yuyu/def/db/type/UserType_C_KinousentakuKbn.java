package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KinousentakuKbn;

/**
 * {@link C_KinousentakuKbn 機能選択区分} の Hibernate ユーザー定義型です。<br />
 * 機能選択区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KinousentakuKbn extends AbstractUserType<C_KinousentakuKbn> {

    @Override
    protected Class<C_KinousentakuKbn> returnType() {
        return C_KinousentakuKbn.class;
    }

    @Override
    protected C_KinousentakuKbn valueOf(String pValue) {
        return C_KinousentakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KinousentakuKbn pValue) {
        return pValue.getValue();
    }
}
