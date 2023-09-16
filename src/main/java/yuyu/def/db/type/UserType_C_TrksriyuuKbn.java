package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrksriyuuKbn;

/**
 * {@link C_TrksriyuuKbn 取消理由区分} の Hibernate ユーザー定義型です。<br />
 * 取消理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrksriyuuKbn extends AbstractUserType<C_TrksriyuuKbn> {

    @Override
    protected Class<C_TrksriyuuKbn> returnType() {
        return C_TrksriyuuKbn.class;
    }

    @Override
    protected C_TrksriyuuKbn valueOf(String pValue) {
        return C_TrksriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrksriyuuKbn pValue) {
        return pValue.getValue();
    }
}
