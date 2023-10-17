package yuyu.app.siharai.simouside.sisiboukariuketuketeisei;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.siharai.siview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBUiBeanParam;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 死亡仮受付訂正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSibouKariUketukeTeiseiUiBean extends GenSiSibouKariUketukeTeiseiUiBean
implements  ViewUketorininSBUiBeanParam, ViewBetukykUiBeanParam {

    private static final long serialVersionUID = 2L;

    @Inject
    private JT_SkKihon skKihon;

    private JT_SiKykKihon siKykKihon;

    private JT_SiKykSyouhn siKykSyouhn;

    private JM_SiSyouhnZokusei siSyouhnZokusei;

    public SiSibouKariUketukeTeiseiUiBean(){
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    public JM_SiSyouhnZokusei getSiSyouhnZokusei() {
        return siSyouhnZokusei;
    }

    public void setSiSyouhnZokusei(JM_SiSyouhnZokusei pSiSyouhnZokusei) {
        this.siSyouhnZokusei = pSiSyouhnZokusei;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn pSiKykSyouhn) {
        this.siKykSyouhn = pSiKykSyouhn;
    }

    @Override
    public boolean isViewUketorininsbSeigyo() {

        boolean blUmuFlg = false;

        if (super.getSbuktnin() != null && super.getSbuktnin() > 0 ) {
            blUmuFlg = true;
        }
        return blUmuFlg;
    }

    @Override
    public boolean isSbuktninHyojiHantei() {

        boolean blNinzuuHyoujiFlg = false;

        if (super.getSbuktnin() != null && super.getSbuktnin() >=5 ) {
            blNinzuuHyoujiFlg = true;
        }
        return blNinzuuHyoujiFlg;
    }



}
