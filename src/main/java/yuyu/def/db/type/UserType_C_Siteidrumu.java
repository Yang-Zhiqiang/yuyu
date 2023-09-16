package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Siteidrumu;

/**
 * {@link C_Siteidrumu 指定代理人指定有無} の Hibernate ユーザー定義型です。<br />
 * 指定代理人指定有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Siteidrumu extends AbstractUserType<C_Siteidrumu> {

    @Override
    protected Class<C_Siteidrumu> returnType() {
        return C_Siteidrumu.class;
    }

    @Override
    protected C_Siteidrumu valueOf(String pValue) {
        return C_Siteidrumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Siteidrumu pValue) {
        return pValue.getValue();
    }
}
