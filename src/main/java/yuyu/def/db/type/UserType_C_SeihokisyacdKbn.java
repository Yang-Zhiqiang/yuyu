package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeihokisyacdKbn;

/**
 * {@link C_SeihokisyacdKbn 生保会社コード区分} の Hibernate ユーザー定義型です。<br />
 * 生保会社コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeihokisyacdKbn extends AbstractUserType<C_SeihokisyacdKbn> {

    @Override
    protected Class<C_SeihokisyacdKbn> returnType() {
        return C_SeihokisyacdKbn.class;
    }

    @Override
    protected C_SeihokisyacdKbn valueOf(String pValue) {
        return C_SeihokisyacdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeihokisyacdKbn pValue) {
        return pValue.getValue();
    }
}
