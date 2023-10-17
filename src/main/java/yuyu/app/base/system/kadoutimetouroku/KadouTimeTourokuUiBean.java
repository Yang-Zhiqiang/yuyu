package yuyu.app.base.system.kadoutimetouroku;
import static yuyu.common.base.kadoutime.KadouTimeConstants.*;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.base.kadoutime.KadouTime;
import yuyu.common.base.kadoutime.KadouTimeUiBean;

/**
 * 稼働時間登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KadouTimeTourokuUiBean extends GenKadouTimeTourokuUiBean implements KadouTimeUiBean{
    private static final long serialVersionUID = 1L;

    public KadouTimeTourokuUiBean() {
    }

    @Override
    public void setKadouTime(KadouTime pKadouTime, int pIdx){
        switch(pIdx){
            case 1: getKadouTime().setKadouTimeFrom1(pKadouTime.getKadouTimeFrom()); getKadouTime().setKadouTimeTo1(pKadouTime.getKadouTimeTo()); break;
            case 2: getKadouTime().setKadouTimeFrom2(pKadouTime.getKadouTimeFrom()); getKadouTime().setKadouTimeTo2(pKadouTime.getKadouTimeTo()); break;
            case 3: getKadouTime().setKadouTimeFrom3(pKadouTime.getKadouTimeFrom()); getKadouTime().setKadouTimeTo3(pKadouTime.getKadouTimeTo()); break;
            case 4: getKadouTime().setKadouTimeFrom4(pKadouTime.getKadouTimeFrom()); getKadouTime().setKadouTimeTo4(pKadouTime.getKadouTimeTo()); break;
            case 5: getKadouTime().setKadouTimeFrom5(pKadouTime.getKadouTimeFrom()); getKadouTime().setKadouTimeTo5(pKadouTime.getKadouTimeTo()); break;
            default :
        }
    }

    void setDsKadouTime(KadouTimeInfoDataSourceBean pKadouTimeInfoDataSourceBean, int pIdx){

        switch(pIdx){
            case 1: getKadouTime().setKadouTimeFrom1(pKadouTimeInfoDataSourceBean.getKadouTimeFrom1()); getKadouTime().setKadouTimeTo1(pKadouTimeInfoDataSourceBean.getKadouTimeTo1()); break;
            case 2: getKadouTime().setKadouTimeFrom2(pKadouTimeInfoDataSourceBean.getKadouTimeFrom2()); getKadouTime().setKadouTimeTo2(pKadouTimeInfoDataSourceBean.getKadouTimeTo2()); break;
            case 3: getKadouTime().setKadouTimeFrom3(pKadouTimeInfoDataSourceBean.getKadouTimeFrom3()); getKadouTime().setKadouTimeTo3(pKadouTimeInfoDataSourceBean.getKadouTimeTo3()); break;
            case 4: getKadouTime().setKadouTimeFrom4(pKadouTimeInfoDataSourceBean.getKadouTimeFrom4()); getKadouTime().setKadouTimeTo4(pKadouTimeInfoDataSourceBean.getKadouTimeTo4()); break;
            case 5: getKadouTime().setKadouTimeFrom5(pKadouTimeInfoDataSourceBean.getKadouTimeFrom5()); getKadouTime().setKadouTimeTo5(pKadouTimeInfoDataSourceBean.getKadouTimeTo5()); break;
            default :
        }
    }

    void setAllBlank(){

        for(int i=1; i<=MAX_KADOUTIME_COUNT; i++){
            setKadouTime(new KadouTime(null,null), i);
        }

    }

}
