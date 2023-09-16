package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BknsyutkKbn;

/**
 * {@link C_BknsyutkKbn 備金主契約特約区分} の Hibernate ユーザー定義型です。<br />
 * 備金主契約特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BknsyutkKbn extends AbstractUserType<C_BknsyutkKbn> {

    @Override
    protected Class<C_BknsyutkKbn> returnType() {
        return C_BknsyutkKbn.class;
    }

    @Override
    protected C_BknsyutkKbn valueOf(String pValue) {
        return C_BknsyutkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BknsyutkKbn pValue) {
        return pValue.getValue();
    }
}
