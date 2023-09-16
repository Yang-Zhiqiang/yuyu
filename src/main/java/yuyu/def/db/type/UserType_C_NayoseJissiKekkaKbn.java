package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;

/**
 * {@link C_NayoseJissiKekkaKbn 名寄せ実施結果区分} の Hibernate ユーザー定義型です。<br />
 * 名寄せ実施結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NayoseJissiKekkaKbn extends AbstractUserType<C_NayoseJissiKekkaKbn> {

    @Override
    protected Class<C_NayoseJissiKekkaKbn> returnType() {
        return C_NayoseJissiKekkaKbn.class;
    }

    @Override
    protected C_NayoseJissiKekkaKbn valueOf(String pValue) {
        return C_NayoseJissiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NayoseJissiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
