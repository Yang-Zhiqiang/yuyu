package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkkouteikanryouKbn;

/**
 * {@link C_SkkouteikanryouKbn 新契約工程完了区分} の Hibernate ユーザー定義型です。<br />
 * 新契約工程完了区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkkouteikanryouKbn extends AbstractUserType<C_SkkouteikanryouKbn> {

    @Override
    protected Class<C_SkkouteikanryouKbn> returnType() {
        return C_SkkouteikanryouKbn.class;
    }

    @Override
    protected C_SkkouteikanryouKbn valueOf(String pValue) {
        return C_SkkouteikanryouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkkouteikanryouKbn pValue) {
        return pValue.getValue();
    }
}
