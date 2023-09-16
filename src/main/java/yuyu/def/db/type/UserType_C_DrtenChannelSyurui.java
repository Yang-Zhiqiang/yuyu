package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtenChannelSyurui;

/**
 * {@link C_DrtenChannelSyurui 代理店チャネル種類} の Hibernate ユーザー定義型です。<br />
 * 代理店チャネル種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtenChannelSyurui extends AbstractUserType<C_DrtenChannelSyurui> {

    @Override
    protected Class<C_DrtenChannelSyurui> returnType() {
        return C_DrtenChannelSyurui.class;
    }

    @Override
    protected C_DrtenChannelSyurui valueOf(String pValue) {
        return C_DrtenChannelSyurui.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtenChannelSyurui pValue) {
        return pValue.getValue();
    }
}
