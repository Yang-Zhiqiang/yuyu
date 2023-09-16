package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ALMSoftKbn;

/**
 * {@link C_ALMSoftKbn ＡＬＭ用ソフト名称区分} の Hibernate ユーザー定義型です。<br />
 * ＡＬＭ用ソフト名称区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ALMSoftKbn extends AbstractUserType<C_ALMSoftKbn> {

    @Override
    protected Class<C_ALMSoftKbn> returnType() {
        return C_ALMSoftKbn.class;
    }

    @Override
    protected C_ALMSoftKbn valueOf(String pValue) {
        return C_ALMSoftKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ALMSoftKbn pValue) {
        return pValue.getValue();
    }
}
