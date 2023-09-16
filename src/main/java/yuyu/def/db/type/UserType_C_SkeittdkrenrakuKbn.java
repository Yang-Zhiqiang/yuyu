package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;

/**
 * {@link C_SkeittdkrenrakuKbn 新契約手続連絡区分} の Hibernate ユーザー定義型です。<br />
 * 新契約手続連絡区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkeittdkrenrakuKbn extends AbstractUserType<C_SkeittdkrenrakuKbn> {

    @Override
    protected Class<C_SkeittdkrenrakuKbn> returnType() {
        return C_SkeittdkrenrakuKbn.class;
    }

    @Override
    protected C_SkeittdkrenrakuKbn valueOf(String pValue) {
        return C_SkeittdkrenrakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkeittdkrenrakuKbn pValue) {
        return pValue.getValue();
    }
}
