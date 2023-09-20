package yuyu.common.workflow.workflowutility;

/**
 * イメージ登録 の処理結果クラスです。<br />
 */
public class PutImageResultBean extends WorkListResultBean{

    public PutImageResultBean() {
    }

    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        imageId = pImageId;
    }
}
