package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * イメージ取得 の処理結果クラスです。<br />
 */
public class GetImageInfoListResultBean extends WorkListResultBean{

    public GetImageInfoListResultBean() {
    }

    private List<ImageInfoBean> imageInfoBeanList = new ArrayList<ImageInfoBean>();

    public List<ImageInfoBean> getImageInfoBeanList() {
        return imageInfoBeanList;
    }

    public void setImageInfoBeanList(List<ImageInfoBean> pImageInfoBeanList) {
        imageInfoBeanList = pImageInfoBeanList;
    }
}
