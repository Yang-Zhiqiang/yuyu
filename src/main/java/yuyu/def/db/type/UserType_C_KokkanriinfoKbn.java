package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KokkanriinfoKbn;

/**
 * {@link C_KokkanriinfoKbn 顧客管理情報区分} の Hibernate ユーザー定義型です。<br />
 * 顧客管理情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KokkanriinfoKbn extends AbstractUserType<C_KokkanriinfoKbn> {

    @Override
    protected Class<C_KokkanriinfoKbn> returnType() {
        return C_KokkanriinfoKbn.class;
    }

    @Override
    protected C_KokkanriinfoKbn valueOf(String pValue) {
        return C_KokkanriinfoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KokkanriinfoKbn pValue) {
        return pValue.getValue();
    }
}
