package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ChkboxHyoujiKbn;

/**
 * {@link C_ChkboxHyoujiKbn チェックボックス表示区分} の Hibernate ユーザー定義型です。<br />
 * チェックボックス表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ChkboxHyoujiKbn extends AbstractUserType<C_ChkboxHyoujiKbn> {

    @Override
    protected Class<C_ChkboxHyoujiKbn> returnType() {
        return C_ChkboxHyoujiKbn.class;
    }

    @Override
    protected C_ChkboxHyoujiKbn valueOf(String pValue) {
        return C_ChkboxHyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ChkboxHyoujiKbn pValue) {
        return pValue.getValue();
    }
}
