package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

/**
 * 【書類情報一覧】イメージ表示 の処理結果クラスです。<br />
 */
public class DispImageResultBean extends SyoruiListResultBean{

    public DispImageResultBean() {
    }

    private String[] imageId;

    public void dispImage(String[] pImageId) {
        imageId = pImageId;
    }

}
