package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * {@link C_NkSyoumetuCd 年金消滅コード} の Hibernate ユーザー定義型です。<br />
 * 年金消滅コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkSyoumetuCd extends AbstractUserType<C_NkSyoumetuCd> {

    @Override
    protected Class<C_NkSyoumetuCd> returnType() {
        return C_NkSyoumetuCd.class;
    }

    @Override
    protected C_NkSyoumetuCd valueOf(String pValue) {
        return C_NkSyoumetuCd.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkSyoumetuCd pValue) {
        return pValue.getValue();
    }
}
