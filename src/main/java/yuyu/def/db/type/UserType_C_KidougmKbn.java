package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KidougmKbn;

/**
 * {@link C_KidougmKbn 起動画面区分} の Hibernate ユーザー定義型です。<br />
 * 起動画面区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KidougmKbn extends AbstractUserType<C_KidougmKbn> {

    @Override
    protected Class<C_KidougmKbn> returnType() {
        return C_KidougmKbn.class;
    }

    @Override
    protected C_KidougmKbn valueOf(String pValue) {
        return C_KidougmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KidougmKbn pValue) {
        return pValue.getValue();
    }
}
