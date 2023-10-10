package yuyu.app.base.system.kinouteigitouroku;

import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 機能定義登録 - ● 機能一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KinouModeInfoListDataSourceBean extends GenKinouModeInfoListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public KinouModeInfoListDataSourceBean() {
    }


    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        this.subSystemId = pSubSystemId;
    }

    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String pCategoryId) {
        this.categoryId = pCategoryId;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        this.kinouId = pKinouId;
    }

    private String kinouModeId;

    public String getKinouModeId() {
        return kinouModeId;
    }

    public void setKinouModeId(String pKinouModeId) {
        this.kinouModeId = pKinouModeId;
    }

    private C_KinouKbn kinouKbn;

    public C_KinouKbn getKinouKbn() {
        return kinouKbn;
    }

    public void setKinouKbn(C_KinouKbn pKinouKbn) {
        this.kinouKbn = pKinouKbn;
    }

    private C_YouhiKbn kidouKengenHanteiYouhiKbn;

    public C_YouhiKbn getKidouKengenHanteiYouhiKbn() {
        return kidouKengenHanteiYouhiKbn;
    }

    public void setKidouKengenHanteiYouhiKbn(C_YouhiKbn pKidouKengenHanteiYouhiKbn) {
        this.kidouKengenHanteiYouhiKbn = pKidouKengenHanteiYouhiKbn;
    }
}
