package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Jyhhknuktumu;

/**
 * {@link C_Jyhhknuktumu 従たる被保険者受取人有無} の Hibernate ユーザー定義型です。<br />
 * 従たる被保険者受取人有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Jyhhknuktumu extends AbstractUserType<C_Jyhhknuktumu> {

    @Override
    protected Class<C_Jyhhknuktumu> returnType() {
        return C_Jyhhknuktumu.class;
    }

    @Override
    protected C_Jyhhknuktumu valueOf(String pValue) {
        return C_Jyhhknuktumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Jyhhknuktumu pValue) {
        return pValue.getValue();
    }
}
