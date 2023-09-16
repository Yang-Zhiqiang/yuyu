package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TekiyouseidoKbn;

/**
 * {@link C_TekiyouseidoKbn 適用制度区分} の Hibernate ユーザー定義型です。<br />
 * 適用制度区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TekiyouseidoKbn extends AbstractUserType<C_TekiyouseidoKbn> {

    @Override
    protected Class<C_TekiyouseidoKbn> returnType() {
        return C_TekiyouseidoKbn.class;
    }

    @Override
    protected C_TekiyouseidoKbn valueOf(String pValue) {
        return C_TekiyouseidoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TekiyouseidoKbn pValue) {
        return pValue.getValue();
    }
}
