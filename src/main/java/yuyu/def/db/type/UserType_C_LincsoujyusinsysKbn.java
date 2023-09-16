package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LincsoujyusinsysKbn;

/**
 * {@link C_LincsoujyusinsysKbn ＬＩＮＣ送受信用システム区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ送受信用システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LincsoujyusinsysKbn extends AbstractUserType<C_LincsoujyusinsysKbn> {

    @Override
    protected Class<C_LincsoujyusinsysKbn> returnType() {
        return C_LincsoujyusinsysKbn.class;
    }

    @Override
    protected C_LincsoujyusinsysKbn valueOf(String pValue) {
        return C_LincsoujyusinsysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LincsoujyusinsysKbn pValue) {
        return pValue.getValue();
    }
}
