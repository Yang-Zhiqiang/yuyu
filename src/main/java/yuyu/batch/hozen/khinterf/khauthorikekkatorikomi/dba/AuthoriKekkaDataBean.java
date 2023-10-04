package yuyu.batch.hozen.khinterf.khauthorikekkatorikomi.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス オーソリ結果データBeanクラス<br />
 */
@AllArgsConstructor
public class AuthoriKekkaDataBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String ztrkaiintourokukbn;

    @Getter @Setter
    private String ztrcreditkessaiyouno;

    @Getter @Setter
    private String ztrcardno;

    @Getter @Setter
    private String ztrcardyuukoukigen;

    @Getter @Setter
    private String ztrauthorigkjyusin;

    @Getter @Setter
    private String ztrauthorikekkaerrorcd;

    @Getter @Setter
    private String ztrbluegateerrorcd;

    @Getter @Setter
    private String ztrhisimukekaisyacd;

    @Getter @Setter
    private String ztrwentryuserid;

    @Getter @Setter
    private String ztrerrorcomment;

    @Getter @Setter
    private String ztrniniinfo;

    @Getter @Setter
    private String ztrdatasyorijyoukyou;

    @Getter @Setter
    private String ztrdatajyusinymd;

    @Getter @Setter
    private String ztrrenno7;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
