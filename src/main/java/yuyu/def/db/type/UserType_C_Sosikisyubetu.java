package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sosikisyubetu;

/**
 * {@link C_Sosikisyubetu 組織種別} の Hibernate ユーザー定義型です。<br />
 * 組織種別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sosikisyubetu extends AbstractUserType<C_Sosikisyubetu> {

    @Override
    protected Class<C_Sosikisyubetu> returnType() {
        return C_Sosikisyubetu.class;
    }

    @Override
    protected C_Sosikisyubetu valueOf(String pValue) {
        return C_Sosikisyubetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sosikisyubetu pValue) {
        return pValue.getValue();
    }
}
