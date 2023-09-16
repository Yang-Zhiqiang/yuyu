package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoureisyaTaiouKbn;

/**
 * {@link C_KoureisyaTaiouKbn 高齢者対応区分} の Hibernate ユーザー定義型です。<br />
 * 高齢者対応区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoureisyaTaiouKbn extends AbstractUserType<C_KoureisyaTaiouKbn> {

    @Override
    protected Class<C_KoureisyaTaiouKbn> returnType() {
        return C_KoureisyaTaiouKbn.class;
    }

    @Override
    protected C_KoureisyaTaiouKbn valueOf(String pValue) {
        return C_KoureisyaTaiouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoureisyaTaiouKbn pValue) {
        return pValue.getValue();
    }
}
