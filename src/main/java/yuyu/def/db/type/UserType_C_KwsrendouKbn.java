package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KwsrendouKbn;

/**
 * {@link C_KwsrendouKbn 為替レート連動区分} の Hibernate ユーザー定義型です。<br />
 * 為替レート連動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KwsrendouKbn extends AbstractUserType<C_KwsrendouKbn> {

    @Override
    protected Class<C_KwsrendouKbn> returnType() {
        return C_KwsrendouKbn.class;
    }

    @Override
    protected C_KwsrendouKbn valueOf(String pValue) {
        return C_KwsrendouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KwsrendouKbn pValue) {
        return pValue.getValue();
    }
}
