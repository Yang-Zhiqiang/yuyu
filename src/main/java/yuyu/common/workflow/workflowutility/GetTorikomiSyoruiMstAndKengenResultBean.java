package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 取込書類マスタ取得(権限情報付加) の処理結果クラスです。<br />
 */
public class GetTorikomiSyoruiMstAndKengenResultBean extends WorkListResultBean{

    public GetTorikomiSyoruiMstAndKengenResultBean() {
    }

    private List<TorikomiSyoruiMstAndKengenBean> torikomiSyoruiMstAndKengenBeanList = new ArrayList<TorikomiSyoruiMstAndKengenBean>();

    public List<TorikomiSyoruiMstAndKengenBean> getTorikomiSyoruiMstAndKengenBeanList() {
        return torikomiSyoruiMstAndKengenBeanList;
    }

    public void setTorikomiSyoruiMstAndKengenBeanList(List<TorikomiSyoruiMstAndKengenBean> pTorikomiSyoruiMstAndKengenBeanList) {
        torikomiSyoruiMstAndKengenBeanList = pTorikomiSyoruiMstAndKengenBeanList;
    }
}
