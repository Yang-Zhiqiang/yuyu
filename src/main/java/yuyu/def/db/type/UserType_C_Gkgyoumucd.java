package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gkgyoumucd;

/**
 * {@link C_Gkgyoumucd 外貨業務コード} の Hibernate ユーザー定義型です。<br />
 * 外貨業務コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gkgyoumucd extends AbstractUserType<C_Gkgyoumucd> {

    @Override
    protected Class<C_Gkgyoumucd> returnType() {
        return C_Gkgyoumucd.class;
    }

    @Override
    protected C_Gkgyoumucd valueOf(String pValue) {
        return C_Gkgyoumucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gkgyoumucd pValue) {
        return pValue.getValue();
    }
}
