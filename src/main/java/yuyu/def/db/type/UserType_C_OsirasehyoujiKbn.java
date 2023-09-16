package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OsirasehyoujiKbn;

/**
 * {@link C_OsirasehyoujiKbn お知らせ表示区分} の Hibernate ユーザー定義型です。<br />
 * お知らせ表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OsirasehyoujiKbn extends AbstractUserType<C_OsirasehyoujiKbn> {

    @Override
    protected Class<C_OsirasehyoujiKbn> returnType() {
        return C_OsirasehyoujiKbn.class;
    }

    @Override
    protected C_OsirasehyoujiKbn valueOf(String pValue) {
        return C_OsirasehyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OsirasehyoujiKbn pValue) {
        return pValue.getValue();
    }
}
