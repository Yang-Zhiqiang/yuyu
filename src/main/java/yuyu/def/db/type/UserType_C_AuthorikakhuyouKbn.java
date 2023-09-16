package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AuthorikakhuyouKbn;

/**
 * {@link C_AuthorikakhuyouKbn オーソリ確認不要区分} の Hibernate ユーザー定義型です。<br />
 * オーソリ確認不要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AuthorikakhuyouKbn extends AbstractUserType<C_AuthorikakhuyouKbn> {

    @Override
    protected Class<C_AuthorikakhuyouKbn> returnType() {
        return C_AuthorikakhuyouKbn.class;
    }

    @Override
    protected C_AuthorikakhuyouKbn valueOf(String pValue) {
        return C_AuthorikakhuyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AuthorikakhuyouKbn pValue) {
        return pValue.getValue();
    }
}
