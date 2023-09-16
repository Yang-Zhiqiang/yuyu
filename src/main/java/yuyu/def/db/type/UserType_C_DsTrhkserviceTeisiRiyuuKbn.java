package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;

/**
 * {@link C_DsTrhkserviceTeisiRiyuuKbn ＤＳ取引サービス停止理由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ取引サービス停止理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTrhkserviceTeisiRiyuuKbn extends AbstractUserType<C_DsTrhkserviceTeisiRiyuuKbn> {

    @Override
    protected Class<C_DsTrhkserviceTeisiRiyuuKbn> returnType() {
        return C_DsTrhkserviceTeisiRiyuuKbn.class;
    }

    @Override
    protected C_DsTrhkserviceTeisiRiyuuKbn valueOf(String pValue) {
        return C_DsTrhkserviceTeisiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTrhkserviceTeisiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
