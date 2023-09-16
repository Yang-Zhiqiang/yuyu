package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kaisosikiupdyouflag;

/**
 * {@link C_Kaisosikiupdyouflag 下位組織更新要フラグ} の Hibernate ユーザー定義型です。<br />
 * 下位組織更新要フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kaisosikiupdyouflag extends AbstractUserType<C_Kaisosikiupdyouflag> {

    @Override
    protected Class<C_Kaisosikiupdyouflag> returnType() {
        return C_Kaisosikiupdyouflag.class;
    }

    @Override
    protected C_Kaisosikiupdyouflag valueOf(String pValue) {
        return C_Kaisosikiupdyouflag.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kaisosikiupdyouflag pValue) {
        return pValue.getValue();
    }
}
