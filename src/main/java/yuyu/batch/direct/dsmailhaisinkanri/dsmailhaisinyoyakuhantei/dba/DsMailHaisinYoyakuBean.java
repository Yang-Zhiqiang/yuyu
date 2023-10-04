package yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信予約情報Beanクラス<br />
 */
@AllArgsConstructor
public class DsMailHaisinYoyakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dsmailhaisinyoyakuskbtkey;

    @Getter @Setter
    private BizDate dsmailhaisinyoteiymd;

    @Getter @Setter
    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Getter @Setter
    private C_DsHaisinYoyakuStatusKbn dshaisinyoyakustatuskbn;

    @Getter @Setter
    private BizDate dsmailhaisintourokuymd;

    @Getter @Setter
    private BizDate dsmailhaisinsyouninymd;

    @Getter @Setter
    private String dsmailhaisintourokusyaid;

    @Getter @Setter
    private String dsmailhaisinsyouninsyaid;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Getter @Setter
    private String gyoumuKousinTime;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
