package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;

/**
 * {@link C_SyoruiInfoItiranHyoujiHouhouKbn 書類情報一覧表示方法区分} の Hibernate ユーザー定義型です。<br />
 * 書類情報一覧表示方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoruiInfoItiranHyoujiHouhouKbn extends AbstractUserType<C_SyoruiInfoItiranHyoujiHouhouKbn> {

    @Override
    protected Class<C_SyoruiInfoItiranHyoujiHouhouKbn> returnType() {
        return C_SyoruiInfoItiranHyoujiHouhouKbn.class;
    }

    @Override
    protected C_SyoruiInfoItiranHyoujiHouhouKbn valueOf(String pValue) {
        return C_SyoruiInfoItiranHyoujiHouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoruiInfoItiranHyoujiHouhouKbn pValue) {
        return pValue.getValue();
    }
}
