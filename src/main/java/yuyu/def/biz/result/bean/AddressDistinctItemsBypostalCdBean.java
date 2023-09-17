package yuyu.def.biz.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 住所（漢字）、漢字市区郡名桁数Beanです。<br />
 */
@AllArgsConstructor
public class AddressDistinctItemsBypostalCdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String adrkj;

    @Getter @Setter
    private Integer kjsikugunnmketasuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
