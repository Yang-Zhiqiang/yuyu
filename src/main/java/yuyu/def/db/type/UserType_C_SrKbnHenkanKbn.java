package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SrKbnHenkanKbn;

/**
 * {@link C_SrKbnHenkanKbn 数理区分変換区分} の Hibernate ユーザー定義型です。<br />
 * 数理区分変換区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SrKbnHenkanKbn extends AbstractUserType<C_SrKbnHenkanKbn> {

    @Override
    protected Class<C_SrKbnHenkanKbn> returnType() {
        return C_SrKbnHenkanKbn.class;
    }

    @Override
    protected C_SrKbnHenkanKbn valueOf(String pValue) {
        return C_SrKbnHenkanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SrKbnHenkanKbn pValue) {
        return pValue.getValue();
    }
}
