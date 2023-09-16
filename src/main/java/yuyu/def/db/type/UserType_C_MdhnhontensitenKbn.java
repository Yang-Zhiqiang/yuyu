package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MdhnhontensitenKbn;

/**
 * {@link C_MdhnhontensitenKbn 窓販本店支店区分} の Hibernate ユーザー定義型です。<br />
 * 窓販本店支店区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MdhnhontensitenKbn extends AbstractUserType<C_MdhnhontensitenKbn> {

    @Override
    protected Class<C_MdhnhontensitenKbn> returnType() {
        return C_MdhnhontensitenKbn.class;
    }

    @Override
    protected C_MdhnhontensitenKbn valueOf(String pValue) {
        return C_MdhnhontensitenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MdhnhontensitenKbn pValue) {
        return pValue.getValue();
    }
}
