package yuyu.def.workflow.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;

/**
 * サブシステム、事務手続、タスク情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean implements Serializable,EntityContainer {

    public JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean(){

    }
    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private DM_Jimutetuzuki dM_Jimutetuzuki;

    @Getter @Setter
    private DM_JimutetuzukiTask dM_JimutetuzukiTask;

    @Getter @Setter
    private AS_SubSystem aS_SubSystem;


    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
