package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MossyoumetuKbn;

/**
 * {@link C_MossyoumetuKbn 申込消滅区分} の Hibernate ユーザー定義型です。<br />
 * 申込消滅区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MossyoumetuKbn extends AbstractUserType<C_MossyoumetuKbn> {

    @Override
    protected Class<C_MossyoumetuKbn> returnType() {
        return C_MossyoumetuKbn.class;
    }

    @Override
    protected C_MossyoumetuKbn valueOf(String pValue) {
        return C_MossyoumetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MossyoumetuKbn pValue) {
        return pValue.getValue();
    }
}
