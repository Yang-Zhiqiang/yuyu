package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SiharaiTuukaKbn;

/**
 * {@link C_SiharaiTuukaKbn 支払通貨区分} の Hibernate ユーザー定義型です。<br />
 * 支払通貨区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SiharaiTuukaKbn extends AbstractUserType<C_SiharaiTuukaKbn> {

    @Override
    protected Class<C_SiharaiTuukaKbn> returnType() {
        return C_SiharaiTuukaKbn.class;
    }

    @Override
    protected C_SiharaiTuukaKbn valueOf(String pValue) {
        return C_SiharaiTuukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SiharaiTuukaKbn pValue) {
        return pValue.getValue();
    }
}
