package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;

/**
 * {@link C_IkkatubaraiKaisuuKbn 一括払回数区分} の Hibernate ユーザー定義型です。<br />
 * 一括払回数区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IkkatubaraiKaisuuKbn extends AbstractUserType<C_IkkatubaraiKaisuuKbn> {

    @Override
    protected Class<C_IkkatubaraiKaisuuKbn> returnType() {
        return C_IkkatubaraiKaisuuKbn.class;
    }

    @Override
    protected C_IkkatubaraiKaisuuKbn valueOf(String pValue) {
        return C_IkkatubaraiKaisuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IkkatubaraiKaisuuKbn pValue) {
        return pValue.getValue();
    }
}
