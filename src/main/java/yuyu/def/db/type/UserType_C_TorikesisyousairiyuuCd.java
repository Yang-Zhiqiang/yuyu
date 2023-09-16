package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;

/**
 * {@link C_TorikesisyousairiyuuCd 取消詳細理由コード} の Hibernate ユーザー定義型です。<br />
 * 取消詳細理由コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TorikesisyousairiyuuCd extends AbstractUserType<C_TorikesisyousairiyuuCd> {

    @Override
    protected Class<C_TorikesisyousairiyuuCd> returnType() {
        return C_TorikesisyousairiyuuCd.class;
    }

    @Override
    protected C_TorikesisyousairiyuuCd valueOf(String pValue) {
        return C_TorikesisyousairiyuuCd.valueOf(pValue);
    }

    @Override
    protected String toString(C_TorikesisyousairiyuuCd pValue) {
        return pValue.getValue();
    }
}
