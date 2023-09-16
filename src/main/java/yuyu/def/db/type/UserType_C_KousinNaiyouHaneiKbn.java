package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KousinNaiyouHaneiKbn;

/**
 * {@link C_KousinNaiyouHaneiKbn 更新内容反映区分} の Hibernate ユーザー定義型です。<br />
 * 更新内容反映区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KousinNaiyouHaneiKbn extends AbstractUserType<C_KousinNaiyouHaneiKbn> {

    @Override
    protected Class<C_KousinNaiyouHaneiKbn> returnType() {
        return C_KousinNaiyouHaneiKbn.class;
    }

    @Override
    protected C_KousinNaiyouHaneiKbn valueOf(String pValue) {
        return C_KousinNaiyouHaneiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KousinNaiyouHaneiKbn pValue) {
        return pValue.getValue();
    }
}
