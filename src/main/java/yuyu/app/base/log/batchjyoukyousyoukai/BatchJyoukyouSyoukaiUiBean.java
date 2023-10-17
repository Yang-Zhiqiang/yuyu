package yuyu.app.base.log.batchjyoukyousyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_OutputKbn;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_SubsystemYuukouHanteiKbn;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.E_ViewKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * バッチ状況照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BatchJyoukyouSyoukaiUiBean extends GenBatchJyoukyouSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public BatchJyoukyouSyoukaiUiBean() {
    }

    private E_ViewKbn viewControlFlg;

    public E_ViewKbn getViewControlFlg() {
        return viewControlFlg;
    }

    public void setViewControlFlg(E_ViewKbn pViewControlFlg) {
        viewControlFlg = pViewControlFlg;
    }

    private E_SubsystemYuukouHanteiKbn subsystemYuukouHanteiFlg;

    public E_SubsystemYuukouHanteiKbn getSubsystemYuukouHanteiFlg() {
        return subsystemYuukouHanteiFlg;
    }

    public void setSubsystemYuukouHanteiFlg(E_SubsystemYuukouHanteiKbn pSubsystemYuukouHanteiFlg) {
        subsystemYuukouHanteiFlg = pSubsystemYuukouHanteiFlg;
    }

    private C_UmuKbn jidouKousinUmuFlg;

    public C_UmuKbn getJidouKousinUmuFlg() {
        return jidouKousinUmuFlg;
    }

    public void setJidouKousinUmuFlg(C_UmuKbn pJidouKousinUmuFlg) {
        jidouKousinUmuFlg = pJidouKousinUmuFlg;
    }

    private E_OutputKbn outputFlg;

    public E_OutputKbn getOutputFlg() {
        return outputFlg;
    }

    public void setOutputFlg(E_OutputKbn pOutputFlg) {
        outputFlg = pOutputFlg;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

    private String maxShutokuKensu;

    public String getMaxShutokuKensu() {
        return maxShutokuKensu;
    }

    public void setMaxShutokuKensu(String pMaxShutokuKensu) {
        this.maxShutokuKensu = pMaxShutokuKensu;
    }

    private String batchJobCount;

    public String getBatchJobCount() {
        return batchJobCount;
    }

    public void setBatchJobCount(String pBatchJobCount) {
        this.batchJobCount = pBatchJobCount;
    }

}
