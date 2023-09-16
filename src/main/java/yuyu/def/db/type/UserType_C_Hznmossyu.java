package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hznmossyu;

/**
 * {@link C_Hznmossyu 保全申込手続き種類} の Hibernate ユーザー定義型です。<br />
 * 保全申込手続き種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hznmossyu extends AbstractUserType<C_Hznmossyu> {

    @Override
    protected Class<C_Hznmossyu> returnType() {
        return C_Hznmossyu.class;
    }

    @Override
    protected C_Hznmossyu valueOf(String pValue) {
        return C_Hznmossyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hznmossyu pValue) {
        return pValue.getValue();
    }
}
