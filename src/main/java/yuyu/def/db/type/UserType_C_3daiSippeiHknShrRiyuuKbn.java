package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn;

/**
 * {@link C_3daiSippeiHknShrRiyuuKbn ３大疾病保険金支払理由区分} の Hibernate ユーザー定義型です。<br />
 * ３大疾病保険金支払理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_3daiSippeiHknShrRiyuuKbn extends AbstractUserType<C_3daiSippeiHknShrRiyuuKbn> {

    @Override
    protected Class<C_3daiSippeiHknShrRiyuuKbn> returnType() {
        return C_3daiSippeiHknShrRiyuuKbn.class;
    }

    @Override
    protected C_3daiSippeiHknShrRiyuuKbn valueOf(String pValue) {
        return C_3daiSippeiHknShrRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_3daiSippeiHknShrRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
