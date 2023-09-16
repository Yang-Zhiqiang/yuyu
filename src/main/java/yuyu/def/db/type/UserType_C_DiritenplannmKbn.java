package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DiritenplannmKbn;

/**
 * {@link C_DiritenplannmKbn 代理店プラン名区分} の Hibernate ユーザー定義型です。<br />
 * 代理店プラン名区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DiritenplannmKbn extends AbstractUserType<C_DiritenplannmKbn> {

    @Override
    protected Class<C_DiritenplannmKbn> returnType() {
        return C_DiritenplannmKbn.class;
    }

    @Override
    protected C_DiritenplannmKbn valueOf(String pValue) {
        return C_DiritenplannmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DiritenplannmKbn pValue) {
        return pValue.getValue();
    }
}
