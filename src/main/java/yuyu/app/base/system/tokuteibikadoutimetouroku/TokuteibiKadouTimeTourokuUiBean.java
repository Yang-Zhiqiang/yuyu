package yuyu.app.base.system.tokuteibikadoutimetouroku;
import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.base.kadoutime.KadouTime;
import yuyu.common.base.kadoutime.KadouTimeTableData;
import yuyu.common.base.kadoutime.KadouTimeUiBean;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;

/**
 * 特定日稼働時間登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class TokuteibiKadouTimeTourokuUiBean extends GenTokuteibiKadouTimeTourokuUiBean implements KadouTimeUiBean{

    private static final long serialVersionUID = 1L;

    public TokuteibiKadouTimeTourokuUiBean() {
    }

    private List<KadouTimeGroupListDataSourceBean> kadouTimeGroupListBak;

    public List<KadouTimeGroupListDataSourceBean> getKadouTimeGroupListBak() {
        return kadouTimeGroupListBak;
    }

    public void setKadouTimeGroupListBak(
        List<KadouTimeGroupListDataSourceBean> pKadouTimeGroupListBak) {
        this.kadouTimeGroupListBak = pKadouTimeGroupListBak;
    }

    private boolean tokuteibiKadouTimeDataumuFlg;

    public boolean getTokuteibiKadouTimeDataumuFlg() {
        return tokuteibiKadouTimeDataumuFlg;
    }

    public void setTokuteibiKadouTimeDataumuFlg(boolean pTokuteibiKadouTimeDataumuFlg) {
        tokuteibiKadouTimeDataumuFlg = pTokuteibiKadouTimeDataumuFlg;
    }

    private List<AT_KadouTimeGroup> kadouTimeGroups;

    public List<AT_KadouTimeGroup> getKadouTimeGroups() {
        return kadouTimeGroups;
    }

    public void setKadouTimeGroups(List<AT_KadouTimeGroup> pKadouTimeGroups) {
        this.kadouTimeGroups = pKadouTimeGroups;
    }

    @Override
    public void setKadouTime(KadouTime pKadouTime, int pIdx){

        AT_TokuteibiKadouTime ds = getTokuteibiKadouTime();

        switch(pIdx){
            case 1: ds.setKadouTimeFrom1(pKadouTime.getKadouTimeFrom()); ds.setKadouTimeTo1(pKadouTime.getKadouTimeTo()); break;
            case 2: ds.setKadouTimeFrom2(pKadouTime.getKadouTimeFrom()); ds.setKadouTimeTo2(pKadouTime.getKadouTimeTo()); break;
            case 3: ds.setKadouTimeFrom3(pKadouTime.getKadouTimeFrom()); ds.setKadouTimeTo3(pKadouTime.getKadouTimeTo()); break;
            case 4: ds.setKadouTimeFrom4(pKadouTime.getKadouTimeFrom()); ds.setKadouTimeTo4(pKadouTime.getKadouTimeTo()); break;
            case 5: ds.setKadouTimeFrom5(pKadouTime.getKadouTimeFrom()); ds.setKadouTimeTo5(pKadouTime.getKadouTimeTo()); break;
            default :
        }
    }

    @Override
    public KadouTimeTableData getKadouTime() {
        return getTokuteibiKadouTime();
    }

}
