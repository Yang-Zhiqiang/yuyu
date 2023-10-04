package yuyu.batch.hozen.khozen.khlincjyusininfohanei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全  契約保全 新契約ＬＩＮＣ受信データBeanクラス
 */
@AllArgsConstructor
public class SkLincJyusinDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String linckyknaiykekdatarenno;

    @Getter @Setter
    private Long linckanyuusyano;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
