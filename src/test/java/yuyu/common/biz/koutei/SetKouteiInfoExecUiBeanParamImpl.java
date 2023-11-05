package yuyu.common.biz.koutei;

/**
 * 工程情報表示設定 （SetKouteiInfoExecUiBeanParam pUiBean）実現クラス<br />
 */
public class SetKouteiInfoExecUiBeanParamImpl implements SetKouteiInfoExecUiBeanParam {

    private String vktifdispjimutetuzukinm;

    private String vktifdisptasknm;

    private BzWorkflowInfo bzworkflowInfo;

    @Override
    public String getVktifdispjimutetuzukinm() {
        return vktifdispjimutetuzukinm;
    }

    @Override
    public void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm) {
        vktifdispjimutetuzukinm = pVktifdispjimutetuzukinm;
    }

    @Override
    public String getVktifdisptasknm() {
        return vktifdisptasknm;
    }

    @Override
    public void setVktifdisptasknm(String pVktifdisptasknm) {
        vktifdisptasknm = pVktifdisptasknm;
    }

    public void setBzworkflowInfo(BzWorkflowInfo bzworkflowInfo) {
        this.bzworkflowInfo = bzworkflowInfo;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzworkflowInfo;
    }

}
