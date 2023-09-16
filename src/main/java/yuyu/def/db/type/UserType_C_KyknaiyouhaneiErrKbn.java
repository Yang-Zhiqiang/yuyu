package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;

/**
 * {@link C_KyknaiyouhaneiErrKbn 契約内容反映エラー区分} の Hibernate ユーザー定義型です。<br />
 * 契約内容反映エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyknaiyouhaneiErrKbn extends AbstractUserType<C_KyknaiyouhaneiErrKbn> {

    @Override
    protected Class<C_KyknaiyouhaneiErrKbn> returnType() {
        return C_KyknaiyouhaneiErrKbn.class;
    }

    @Override
    protected C_KyknaiyouhaneiErrKbn valueOf(String pValue) {
        return C_KyknaiyouhaneiErrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyknaiyouhaneiErrKbn pValue) {
        return pValue.getValue();
    }
}
