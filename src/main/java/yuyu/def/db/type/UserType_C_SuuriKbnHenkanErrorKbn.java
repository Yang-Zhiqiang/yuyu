package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriKbnHenkanErrorKbn;

/**
 * {@link C_SuuriKbnHenkanErrorKbn 数理用区分変換エラー区分} の Hibernate ユーザー定義型です。<br />
 * 数理用区分変換エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriKbnHenkanErrorKbn extends AbstractUserType<C_SuuriKbnHenkanErrorKbn> {

    @Override
    protected Class<C_SuuriKbnHenkanErrorKbn> returnType() {
        return C_SuuriKbnHenkanErrorKbn.class;
    }

    @Override
    protected C_SuuriKbnHenkanErrorKbn valueOf(String pValue) {
        return C_SuuriKbnHenkanErrorKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriKbnHenkanErrorKbn pValue) {
        return pValue.getValue();
    }
}
