package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tantositucd;

/**
 * {@link C_Tantositucd 担当室コード} の Hibernate ユーザー定義型です。<br />
 * 担当室コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tantositucd extends AbstractUserType<C_Tantositucd> {

    @Override
    protected Class<C_Tantositucd> returnType() {
        return C_Tantositucd.class;
    }

    @Override
    protected C_Tantositucd valueOf(String pValue) {
        return C_Tantositucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tantositucd pValue) {
        return pValue.getValue();
    }
}
