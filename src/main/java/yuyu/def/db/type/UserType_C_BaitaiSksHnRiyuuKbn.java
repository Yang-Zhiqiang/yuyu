package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BaitaiSksHnRiyuuKbn;

/**
 * {@link C_BaitaiSksHnRiyuuKbn 媒体作成不能理由区分} の Hibernate ユーザー定義型です。<br />
 * 媒体作成不能理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BaitaiSksHnRiyuuKbn extends AbstractUserType<C_BaitaiSksHnRiyuuKbn> {

    @Override
    protected Class<C_BaitaiSksHnRiyuuKbn> returnType() {
        return C_BaitaiSksHnRiyuuKbn.class;
    }

    @Override
    protected C_BaitaiSksHnRiyuuKbn valueOf(String pValue) {
        return C_BaitaiSksHnRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BaitaiSksHnRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
