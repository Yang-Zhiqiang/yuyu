package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KarifileKbn;

/**
 * {@link C_KarifileKbn 仮ファイル区分} の Hibernate ユーザー定義型です。<br />
 * 仮ファイル区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KarifileKbn extends AbstractUserType<C_KarifileKbn> {

    @Override
    protected Class<C_KarifileKbn> returnType() {
        return C_KarifileKbn.class;
    }

    @Override
    protected C_KarifileKbn valueOf(String pValue) {
        return C_KarifileKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KarifileKbn pValue) {
        return pValue.getValue();
    }
}
