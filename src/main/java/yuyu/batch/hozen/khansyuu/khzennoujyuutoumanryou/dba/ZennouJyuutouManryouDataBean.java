package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 前納充当・満了対象データBeanクラス
 */
@AllArgsConstructor
public class ZennouJyuutouManryouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDateYM jikaipym;

    @Getter @Setter
    private String syouhincord;

    @Getter @Setter
    private Integer syouhinsedaino;

    @Getter @Setter
    private BizDate zennoukaisiymd;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private BizDateYM annaisaikaiym;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
