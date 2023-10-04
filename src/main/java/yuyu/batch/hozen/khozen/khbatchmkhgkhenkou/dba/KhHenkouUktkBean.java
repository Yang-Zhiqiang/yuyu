package yuyu.batch.hozen.khozen.khbatchmkhgkhenkou.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 契約保全変更受付Bean
 */
@AllArgsConstructor
public class KhHenkouUktkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer hozenhenkouuktkrenno;

    @Getter @Setter
    private BizDate uktkymd;

    @Getter @Setter
    private C_TourokuRouteKbn tourokuroute;

    @Getter @Setter
    private C_UktkSyoriKbn uktksyorikbn;

    @Getter @Setter
    private BizDate kouryokuhasseiymd;

    @Getter @Setter
    private BizDate syoriyoteiymd;

    @Getter @Setter
    private C_UktkJyoutaiKbn uktkjyoutaikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
