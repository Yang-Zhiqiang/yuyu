package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * （新契約）入金情報BeanBeanクラスです。<br />
 */
@AllArgsConstructor
public class NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate nyksyoriymd;

    @Getter @Setter
    private BizDate ryosyuymdMin;

    @Getter @Setter
    private BizDate ryosyuymdMax;

    @Getter @Setter
    private BizDate tyakkinymdMin;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
