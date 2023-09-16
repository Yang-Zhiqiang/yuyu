package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsetukeiiKbn;

/**
 * {@link C_SinsetukeiiKbn 新設経緯区分} の Hibernate ユーザー定義型です。<br />
 * 新設経緯区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsetukeiiKbn extends AbstractUserType<C_SinsetukeiiKbn> {

    @Override
    protected Class<C_SinsetukeiiKbn> returnType() {
        return C_SinsetukeiiKbn.class;
    }

    @Override
    protected C_SinsetukeiiKbn valueOf(String pValue) {
        return C_SinsetukeiiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsetukeiiKbn pValue) {
        return pValue.getValue();
    }
}
