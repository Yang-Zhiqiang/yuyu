package yuyu.app.siharai.sisonota.simakesyorui;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金書類作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiMakeSyoruiUiBean extends GenSiMakeSyoruiUiBean {

    private static final long serialVersionUID = 1L;

    private String kouteiKnrId;

    private String toritugisyaKojinCd;

    private String toritugisyaKojinNm;

    private String toritugisyaSosikiNm;

    private C_Tuukasyu kykTuukasyu;

    private JT_SiKykKihon siKykkihon;

    private JT_SiKykSyouhn siKykSyouhnSyu;

    private BM_SyouhnZokusei syouhnZokusei;

    private String reportKey;

    private String resultSyono;

    private C_SeikyuuSyubetu resultSeikyuusyubetu;

    private String patternsisyoruisakuseikbn;

    public SiMakeSyoruiUiBean() {
    }

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String kouteiKnrId) {
        this.kouteiKnrId = kouteiKnrId;
    }

    public String getToritugisyaKojinCd() {
        return toritugisyaKojinCd;
    }

    public void setToritugisyaKojinCd(String toritugisyaKojinCd) {
        this.toritugisyaKojinCd = toritugisyaKojinCd;
    }

    public String getToritugisyaKojinNm() {
        return toritugisyaKojinNm;
    }

    public void setToritugisyaKojinNm(String toritugisyaKojinNm) {
        this.toritugisyaKojinNm = toritugisyaKojinNm;
    }

    public String getToritugisyaSosikiNm() {
        return toritugisyaSosikiNm;
    }

    public void setToritugisyaSosikiNm(String toritugisyaSosikiNm) {
        this.toritugisyaSosikiNm = toritugisyaSosikiNm;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu kykTuukasyu) {
        this.kykTuukasyu = kykTuukasyu;
    }

    public JT_SiKykKihon getSiKykkihon() {
        return siKykkihon;
    }

    public void setSiKykkihon(JT_SiKykKihon siKykkihon) {
        this.siKykkihon = siKykkihon;
    }

    public JT_SiKykSyouhn getSiKykSyouhnSyu() {
        return siKykSyouhnSyu;
    }

    public void setSiKykSyouhnSyu(JT_SiKykSyouhn siKykSyouhnSyu) {
        this.siKykSyouhnSyu = siKykSyouhnSyu;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei syouhnZokusei) {
        this.syouhnZokusei = syouhnZokusei;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String reportKey) {
        this.reportKey = reportKey;
    }

    public String getResultSyono() {
        return resultSyono;
    }

    public void setResultSyono(String resultSyono) {
        this.resultSyono = resultSyono;
    }

    public C_SeikyuuSyubetu getResultSeikyuusyubetu() {
        return resultSeikyuusyubetu;
    }

    public void setResultSeikyuusyubetu(C_SeikyuuSyubetu resultSeikyuusyubetu) {
        this.resultSeikyuusyubetu = resultSeikyuusyubetu;
    }

    public String getPatternsisyoruisakuseikbn() {
        return patternsisyoruisakuseikbn;
    }

    public void setPatternsisyoruisakuseikbn(String patternsisyoruisakuseikbn) {
        this.patternsisyoruisakuseikbn = patternsisyoruisakuseikbn;
    }
}
