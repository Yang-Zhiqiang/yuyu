package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.dba;

import java.io.Serializable;

import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_TourokustatusKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ダイレクトサービス 取引サービス登録 ＤＳ登録受付管理情報Beanクラス<br/>
 */
@AllArgsConstructor
public class DsTourokuUkKanriInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String mosno;

    @Getter @Setter
    private C_TourokustatusKbn tourokustatus;

    @Getter @Setter
    private BizDate dsjimukaisiymd;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Getter @Setter
    private String kyknmkjkh;

    @Getter @Setter
    private String kyknmkjsk;

    @Getter @Setter
    private String hhknnmkjsk;

    @Getter @Setter
    private C_KykKbn kykkbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}