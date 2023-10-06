package yuyu.batch.biz.sysbatch.bzdeleteprocessandjbpmrecord;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 削除対象工程情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class DelKouteiInfosByKouteiKanryouYmdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String gyoumuKey;

    @Getter @Setter
    private String flowId;

    @Getter @Setter
    private String kouteiKanryouYmd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
