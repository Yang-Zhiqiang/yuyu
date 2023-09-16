package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukoujyotaichkKbn;

/**
 * {@link C_YuukoujyotaichkKbn 有効状態チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 有効状態チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukoujyotaichkKbn extends AbstractUserType<C_YuukoujyotaichkKbn> {

    @Override
    protected Class<C_YuukoujyotaichkKbn> returnType() {
        return C_YuukoujyotaichkKbn.class;
    }

    @Override
    protected C_YuukoujyotaichkKbn valueOf(String pValue) {
        return C_YuukoujyotaichkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukoujyotaichkKbn pValue) {
        return pValue.getValue();
    }
}
