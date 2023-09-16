package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;

/**
 * {@link C_KoureiKzkSetumeiHouKbn 高齢者ご家族等説明方法区分} の Hibernate ユーザー定義型です。<br />
 * 高齢者ご家族等説明方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoureiKzkSetumeiHouKbn extends AbstractUserType<C_KoureiKzkSetumeiHouKbn> {

    @Override
    protected Class<C_KoureiKzkSetumeiHouKbn> returnType() {
        return C_KoureiKzkSetumeiHouKbn.class;
    }

    @Override
    protected C_KoureiKzkSetumeiHouKbn valueOf(String pValue) {
        return C_KoureiKzkSetumeiHouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoureiKzkSetumeiHouKbn pValue) {
        return pValue.getValue();
    }
}
