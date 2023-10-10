package yuyu.app.siharai.sisatei.sisyounintorikesi;

import javax.inject.Inject;

import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean;
import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;
import yuyu.common.siharai.siview.ViewHihokensyaSyouninTorikesiUiBeanParam;
import yuyu.common.siharai.siview.ViewTetudukiInputUiBeanParam;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SkKihon;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 承認取消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSyouninTorikesiUiBean extends GenSiSyouninTorikesiUiBean implements EditRrkTblParam,
SiKekkaInputParam,ViewHihokensyaSyouninTorikesiUiBeanParam,ViewTetudukiInputUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private JT_SkKihon skKihon;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean siTtzkRirekiSyoukaiUiBean;

    private String jimutetuzukiCd;

    private String kouteikanriId;

    private String backNodoId;

    private C_YouhiKbn youhiKbn;

    private String kouteiLockKey;

    private String kinouNm;

    private String nowNodoId;

    public SiSyouninTorikesiUiBean() {
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    public SiTtzkRirekiSyoukaiUiBean getSiTtzkRirekiSyoukaiUiBean() {
        return siTtzkRirekiSyoukaiUiBean;
    }

    public void setSiTtzkRirekiSyoukaiUiBean(SiTtzkRirekiSyoukaiUiBean pSiTtzkRirekiSyoukaiUiBean) {
        this.siTtzkRirekiSyoukaiUiBean = pSiTtzkRirekiSyoukaiUiBean;
    }

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        this.jimutetuzukiCd = pJimutetuzukiCd;
    }

    public String getKouteikanriId() {
        return kouteikanriId;
    }

    public void setKouteikanriId(String pKouteikanriId) {
        this.kouteikanriId = pKouteikanriId;
    }

    public String getBackNodoId() {
        return backNodoId;
    }

    public void setBackNodoId(String pBackNodoId) {
        this.backNodoId = pBackNodoId;
    }

    public C_YouhiKbn getYouhiKbn() {
        return youhiKbn;
    }

    public void setYouhiKbn(C_YouhiKbn pYouhiKbn) {
        this.youhiKbn = pYouhiKbn;
    }

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        this.kouteiLockKey = pKouteiLockKey;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        this.kinouNm = pKinouNm;
    }

    public boolean isSiTtzkRirekiSyoukaiHyojiSeigyo() {
        boolean siTtzkRirekiSyoukaiHyojiSeigyoFlg = false;
        if (C_YouhiKbn.YOU.eq(youhiKbn)) {
            siTtzkRirekiSyoukaiHyojiSeigyoFlg = true;
        }

        return siTtzkRirekiSyoukaiHyojiSeigyoFlg;
    }

    public String getNowNodoId() {
        return nowNodoId;
    }

    public void setNowNodoId(String pNowNodoId) {
        this.nowNodoId = pNowNodoId;
    }


}
