package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsnskhyoujiKbn;

/**
 * {@link C_TsnskhyoujiKbn 通信先表示区分} の Hibernate ユーザー定義型です。<br />
 * 通信先表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsnskhyoujiKbn extends AbstractUserType<C_TsnskhyoujiKbn> {

    @Override
    protected Class<C_TsnskhyoujiKbn> returnType() {
        return C_TsnskhyoujiKbn.class;
    }

    @Override
    protected C_TsnskhyoujiKbn valueOf(String pValue) {
        return C_TsnskhyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsnskhyoujiKbn pValue) {
        return pValue.getValue();
    }
}
