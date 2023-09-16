package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GaibuRenkeiKakuJkKbn;

/**
 * {@link C_GaibuRenkeiKakuJkKbn 外部連携確認状況区分} の Hibernate ユーザー定義型です。<br />
 * 外部連携確認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GaibuRenkeiKakuJkKbn extends AbstractUserType<C_GaibuRenkeiKakuJkKbn> {

    @Override
    protected Class<C_GaibuRenkeiKakuJkKbn> returnType() {
        return C_GaibuRenkeiKakuJkKbn.class;
    }

    @Override
    protected C_GaibuRenkeiKakuJkKbn valueOf(String pValue) {
        return C_GaibuRenkeiKakuJkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GaibuRenkeiKakuJkKbn pValue) {
        return pValue.getValue();
    }
}
