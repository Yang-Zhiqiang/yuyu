package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全手続履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhTtdkRirekiInfosBySyonoBean implements Serializable {

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private C_SyoriKbn syorikbn;

    @Getter @Setter
    private String syorisosikicd;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private C_UmuKbn henkourrkumu;

    @Getter @Setter
    private C_UmuKbn shrsyousaiumu;

    @Getter @Setter
    private String kouteikanriId;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private String kinouNm;

    @Getter @Setter
    private String userNm;

    @Getter @Setter
    private Long khHenkouRirekisCount;

    @Getter @Setter
    private Long khShrRirekiCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
