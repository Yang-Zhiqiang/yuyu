package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * イメージ一覧取得 の処理結果クラスです。<br />
 */
public class GetImagePropsListResultBean extends WorkListResultBean{

    public GetImagePropsListResultBean() {
    }

    private List<ImagePropsBean> imagePropsBeanList = new ArrayList<ImagePropsBean>();

    public List<ImagePropsBean> getImagePropsBeanList() {
        return imagePropsBeanList;
    }

    public void setImagePropsBeanList(List<ImagePropsBean> pImagePropsBeanList) {
        imagePropsBeanList = pImagePropsBeanList;
    }
}
