package yuyu.app.direct.dskokyakukanri.dskokyakutouroku;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;

/**
 * 顧客登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class DsKokyakuTourokuUiBean extends GenDsKokyakuTourokuUiBean {

    private static final long serialVersionUID = 1L;

    public DsKokyakuTourokuUiBean() {
    }

    @Inject
    private MT_DsKokyakuKanri dsKokyakuKanri;

    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return dsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pDsKokyakuKanri) {
        this.dsKokyakuKanri = pDsKokyakuKanri;
    }

    @Inject
    private MT_DsKokyakuKeiyaku dsKokyakuKeiyaku;

    public MT_DsKokyakuKeiyaku getDsKokyakuKeiyaku() {
        return dsKokyakuKeiyaku;
    }

    public void setDsKokyakuKeiyaku(MT_DsKokyakuKeiyaku pDsKokyakuKeiyaku) {
        this.dsKokyakuKeiyaku = pDsKokyakuKeiyaku;
    }

    @Inject
    private MT_DsKokyakuKanri tougousakiDsKokyakuKanri;

    public MT_DsKokyakuKanri getTougousakiDsKokyakuKanri() {
        return tougousakiDsKokyakuKanri;
    }

    public void setTougousakiDsKokyakuKanri(MT_DsKokyakuKanri pTougousakiDsKokyakuKanri) {
        this.tougousakiDsKokyakuKanri = pTougousakiDsKokyakuKanri;
    }
}
