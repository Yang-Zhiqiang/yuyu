package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykdrknHtdjytKbn;

/**
 * {@link C_KykdrknHtdjytKbn 契約者代理権発動状態区分} の Hibernate ユーザー定義型です。<br />
 * 契約者代理権発動状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykdrknHtdjytKbn extends AbstractUserType<C_KykdrknHtdjytKbn> {

    @Override
    protected Class<C_KykdrknHtdjytKbn> returnType() {
        return C_KykdrknHtdjytKbn.class;
    }

    @Override
    protected C_KykdrknHtdjytKbn valueOf(String pValue) {
        return C_KykdrknHtdjytKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykdrknHtdjytKbn pValue) {
        return pValue.getValue();
    }
}
