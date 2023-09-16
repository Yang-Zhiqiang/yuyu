package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;

/**
 * {@link C_HsigiTkbtTaiouSyuruiKbn 被災害特別対応種類区分} の Hibernate ユーザー定義型です。<br />
 * 被災害特別対応種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HsigiTkbtTaiouSyuruiKbn extends AbstractUserType<C_HsigiTkbtTaiouSyuruiKbn> {

    @Override
    protected Class<C_HsigiTkbtTaiouSyuruiKbn> returnType() {
        return C_HsigiTkbtTaiouSyuruiKbn.class;
    }

    @Override
    protected C_HsigiTkbtTaiouSyuruiKbn valueOf(String pValue) {
        return C_HsigiTkbtTaiouSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HsigiTkbtTaiouSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
