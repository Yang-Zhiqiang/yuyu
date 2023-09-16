package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tksytratkikjn;

/**
 * {@link C_Tksytratkikjn 特殊取扱基準区分} の Hibernate ユーザー定義型です。<br />
 * 特殊取扱基準区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tksytratkikjn extends AbstractUserType<C_Tksytratkikjn> {

    @Override
    protected Class<C_Tksytratkikjn> returnType() {
        return C_Tksytratkikjn.class;
    }

    @Override
    protected C_Tksytratkikjn valueOf(String pValue) {
        return C_Tksytratkikjn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tksytratkikjn pValue) {
        return pValue.getValue();
    }
}
