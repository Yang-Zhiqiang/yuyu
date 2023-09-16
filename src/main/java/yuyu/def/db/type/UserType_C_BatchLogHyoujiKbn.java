package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchLogHyoujiKbn;

/**
 * {@link C_BatchLogHyoujiKbn バッチログ表示区分} の Hibernate ユーザー定義型です。<br />
 * バッチログ表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchLogHyoujiKbn extends AbstractUserType<C_BatchLogHyoujiKbn> {

    @Override
    protected Class<C_BatchLogHyoujiKbn> returnType() {
        return C_BatchLogHyoujiKbn.class;
    }

    @Override
    protected C_BatchLogHyoujiKbn valueOf(String pValue) {
        return C_BatchLogHyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchLogHyoujiKbn pValue) {
        return pValue.getValue();
    }
}
