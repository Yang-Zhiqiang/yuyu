package yuyu.app.workflow.processkanri.nenkinworklist;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.common.workflow.worklistbase.WorkListSearchKeyInputBaseBean;

/**
 * 年金支払工程ワークリスト : 検索条件保持用クラスです。<br />
 */
@ConversationScoped
public class NenkinWorkListSearchKeyInputBean extends WorkListSearchKeyInputBaseBean {

    private static final long serialVersionUID = 1L;

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private final LoopChain<UserDefsList> jimutetuzukicdOptionBeanList = new LoopChain<>();
    public UserDefsList getJimutetuzukicdOptionBeanList() {
        return jimutetuzukicdOptionBeanList.get();
    }

    public void setJimutetuzukicdOptionBeanList(UserDefsList pJimutetuzukicdOptionBeanList) {
        jimutetuzukicdOptionBeanList.add(pJimutetuzukicdOptionBeanList);
    }

    public void clearJimutetuzukicdOptionBeanList() {
        jimutetuzukicdOptionBeanList.clear();
    }
}
