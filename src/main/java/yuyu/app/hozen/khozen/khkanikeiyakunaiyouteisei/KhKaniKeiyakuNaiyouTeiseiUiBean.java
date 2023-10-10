package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全簡易契約内容訂正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhKaniKeiyakuNaiyouTeiseiUiBean extends GenKhKaniKeiyakuNaiyouTeiseiUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    private String syouhnCd;

    private Integer syouhnsdNo;

    private Integer kyksyouhnrenno;

    private C_SyutkKbn syutkKbn;

    private C_Segcd seg1cd;

    private C_Segcd seg2cd;

    private IT_KhHenreikin khHenreikin;

    private int syohinHanteiKbn;

    public KhKaniKeiyakuNaiyouTeiseiUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }

    public Integer getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(Integer pSyouhnsdNo) {
        syouhnsdNo = pSyouhnsdNo;
    }

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    public C_SyutkKbn getSyutkKbn() {
        return syutkKbn;
    }

    public void setSyutkKbn(C_SyutkKbn pSyutkKbn) {
        syutkKbn = pSyutkKbn;
    }

    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    public IT_KhHenreikin getKhHenreikin() {
        return khHenreikin;
    }

    public void setKhHenreikin(IT_KhHenreikin pKhHenreikin) {
        khHenreikin = pKhHenreikin;
    }

    public int getSyohinHanteiKbn() {
        return syohinHanteiKbn;
    }

    public void setSyohinHanteiKbn(int pSyohinHanteiKbn) {
        syohinHanteiKbn = pSyohinHanteiKbn;
    }
}
