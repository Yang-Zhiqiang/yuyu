package yuyu.batch.hozen.khozen.khkanyuusyanoinfosakujyo.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * 契約保全 契約保全 契約保全ＬＩＮＣ送信データBeanクラス
 */
@AllArgsConstructor
public class KhLincSousinDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String linchenkoutype;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
