package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsGyoumuCdKbn;

/**
 * {@link C_DsGyoumuCdKbn ＤＳ業務コード区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ業務コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsGyoumuCdKbn extends AbstractUserType<C_DsGyoumuCdKbn> {

    @Override
    protected Class<C_DsGyoumuCdKbn> returnType() {
        return C_DsGyoumuCdKbn.class;
    }

    @Override
    protected C_DsGyoumuCdKbn valueOf(String pValue) {
        return C_DsGyoumuCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsGyoumuCdKbn pValue) {
        return pValue.getValue();
    }
}
