package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MisyuptsKbn;

/**
 * {@link C_MisyuptsKbn 未収Ｐ徴収区分} の Hibernate ユーザー定義型です。<br />
 * 未収Ｐ徴収区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MisyuptsKbn extends AbstractUserType<C_MisyuptsKbn> {

    @Override
    protected Class<C_MisyuptsKbn> returnType() {
        return C_MisyuptsKbn.class;
    }

    @Override
    protected C_MisyuptsKbn valueOf(String pValue) {
        return C_MisyuptsKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MisyuptsKbn pValue) {
        return pValue.getValue();
    }
}
