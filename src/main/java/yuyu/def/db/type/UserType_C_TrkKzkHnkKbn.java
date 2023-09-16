package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrkKzkHnkKbn;

/**
 * {@link C_TrkKzkHnkKbn 登録家族変更内容区分} の Hibernate ユーザー定義型です。<br />
 * 登録家族変更内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrkKzkHnkKbn extends AbstractUserType<C_TrkKzkHnkKbn> {

    @Override
    protected Class<C_TrkKzkHnkKbn> returnType() {
        return C_TrkKzkHnkKbn.class;
    }

    @Override
    protected C_TrkKzkHnkKbn valueOf(String pValue) {
        return C_TrkKzkHnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrkKzkHnkKbn pValue) {
        return pValue.getValue();
    }
}
