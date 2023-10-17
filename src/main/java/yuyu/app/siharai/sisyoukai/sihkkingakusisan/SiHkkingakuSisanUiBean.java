package yuyu.app.siharai.sisyoukai.sihkkingakusisan;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBUiBeanParam;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金額試算 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiHkkingakuSisanUiBean extends GenSiHkkingakuSisanUiBean implements ViewUketorininSBUiBeanParam{

    private static final long serialVersionUID = 1L;

    public SiHkkingakuSisanUiBean() {
    }

    private boolean sisanKekkaFlag;

    private boolean zeimuKihrkmpDispFlag;

    private boolean knsnkijyunymdDispFlag;

    private boolean itijibrpDispFlag;

    private boolean nyknymdDispFlag;

    private boolean nyknkawaserateDispFlag;

    private boolean sisankekkaHaitoukinDispFlag;

    private boolean sisankekkaSonotahaitoukinDispFlag;

    private boolean sisankekkaMikeikapDispFlag;

    private boolean sisankekkaMisyuupDispFlag;

    private boolean sisankekkaZennouseisankgkDispFlag;

    private boolean sisankekkaAzukarikingkDispFlag;

    private boolean sisankekkaKrkgkDispFlag;

    private boolean sisankekkaGoukeigkDispFlag;

    private boolean sisankekkaGaikaknsnkijyunymdDispFlag;

    @Inject
    private JT_SiKykKihon siKykKihon;

    private JT_SiKykSyouhn siKykSyouhn;

    private List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst;

    private BM_SyouhnZokusei syouhnZokusei;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private List<SiSiDetailParamBean> siSiDetailParamBeanList;

    private boolean jisatuMensekiDispFlag;

    private boolean sisankekkaZeimuInfoDispFlag;

    private boolean sisankekkaSynykngkDispFlag;

    private boolean sisankekkaGaikashrsynykngkDispFlag;

    private boolean sisankekkaKztkgkDispFlag;

    private boolean sisankekkaSikinidougakuDispFlag;

    public boolean isSisanKekkaFlag() {
        return sisanKekkaFlag;
    }

    public void setSisanKekkaFlag(boolean pSisanKekkaFlag) {
        this.sisanKekkaFlag = pSisanKekkaFlag;
    }

    public boolean isZeimuKihrkmpDispFlag() {
        return zeimuKihrkmpDispFlag;
    }

    public void setKnsnkijyunymdDispFlag(boolean pKnsnkijyunymdDispFlag) {
        this.knsnkijyunymdDispFlag = pKnsnkijyunymdDispFlag;
    }

    public boolean isKnsnkijyunymdDispFlag() {
        return knsnkijyunymdDispFlag;
    }

    public void setZeimuKihrkmpDispFlag(boolean pZeimuKihrkmpDispFlag) {
        this.zeimuKihrkmpDispFlag = pZeimuKihrkmpDispFlag;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn pSiKykSyouhn) {
        this.siKykSyouhn = pSiKykSyouhn;
    }

    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseiLst() {
        return siSyouhnZokuseiLst;
    }

    public void setSiSyouhnZokuseiLst(List<JM_SiSyouhnZokusei> pSiSyouhnZokuseiLst) {
        this.siSyouhnZokuseiLst = pSiSyouhnZokuseiLst;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei syouhnZokusei) {
        this.syouhnZokusei = syouhnZokusei;
    }

    public boolean isItijibrpDispFlag() {
        return itijibrpDispFlag;
    }

    public void setItijibrpDispFlag(boolean itijibrpDispFlag) {
        this.itijibrpDispFlag = itijibrpDispFlag;
    }

    public boolean isNyknymdDispFlag() {
        return nyknymdDispFlag;
    }

    public void setNyknymdDispFlag(boolean nyknymdDispFlag) {
        this.nyknymdDispFlag = nyknymdDispFlag;
    }

    public boolean isNyknkawaserateDispFlag() {
        return nyknkawaserateDispFlag;
    }

    public void setNyknkawaserateDispFlag(boolean nyknkawaserateDispFlag) {
        this.nyknkawaserateDispFlag = nyknkawaserateDispFlag;
    }

    public boolean isSisankekkaHaitoukinDispFlag() {
        return sisankekkaHaitoukinDispFlag;
    }

    public void setSisankekkaHaitoukinDispFlag(boolean sisankekkaHaitoukinDispFlag) {
        this.sisankekkaHaitoukinDispFlag = sisankekkaHaitoukinDispFlag;
    }

    public boolean isSisankekkaSonotahaitoukinDispFlag() {
        return sisankekkaSonotahaitoukinDispFlag;
    }

    public void setSisankekkaSonotahaitoukinDispFlag(boolean sisankekkaSonotahaitoukinDispFlag) {
        this.sisankekkaSonotahaitoukinDispFlag = sisankekkaSonotahaitoukinDispFlag;
    }

    public boolean isSisankekkaMikeikapDispFlag() {
        return sisankekkaMikeikapDispFlag;
    }

    public void setSisankekkaMikeikapDispFlag(boolean sisankekkaMikeikapDispFlag) {
        this.sisankekkaMikeikapDispFlag = sisankekkaMikeikapDispFlag;
    }

    public boolean isSisankekkaMisyuupDispFlag() {
        return sisankekkaMisyuupDispFlag;
    }

    public void setSisankekkaMisyuupDispFlag(boolean sisankekkaMisyuupDispFlag) {
        this.sisankekkaMisyuupDispFlag = sisankekkaMisyuupDispFlag;
    }

    public boolean isSisankekkaZennouseisankgkDispFlag() {
        return sisankekkaZennouseisankgkDispFlag;
    }

    public void setSisankekkaZennouseisankgkDispFlag(boolean sisankekkaZennouseisankgkDispFlag) {
        this.sisankekkaZennouseisankgkDispFlag = sisankekkaZennouseisankgkDispFlag;
    }

    public boolean isSisankekkaAzukarikingkDispFlag() {
        return sisankekkaAzukarikingkDispFlag;
    }

    public void setSisankekkaAzukarikingkDispFlag(boolean sisankekkaAzukarikingkDispFlag) {
        this.sisankekkaAzukarikingkDispFlag = sisankekkaAzukarikingkDispFlag;
    }

    public boolean isSisankekkaKrkgkDispFlag() {
        return sisankekkaKrkgkDispFlag;
    }

    public void setSisankekkaKrkgkDispFlag(boolean sisankekkaKrkgkDispFlag) {
        this.sisankekkaKrkgkDispFlag = sisankekkaKrkgkDispFlag;
    }

    public boolean isSisankekkaGoukeigkDispFlag() {
        return sisankekkaGoukeigkDispFlag;
    }

    public void setSisankekkaGoukeigkDispFlag(boolean sisankekkaGoukeigkDispFlag) {
        this.sisankekkaGoukeigkDispFlag = sisankekkaGoukeigkDispFlag;
    }

    public boolean isSisankekkaGaikaknsnkijyunymdDispFlag() {
        return sisankekkaGaikaknsnkijyunymdDispFlag;
    }

    public void setSisankekkaGaikaknsnkijyunymdDispFlag(boolean sisankekkaGaikaknsnkijyunymdDispFlag) {
        this.sisankekkaGaikaknsnkijyunymdDispFlag = sisankekkaGaikaknsnkijyunymdDispFlag;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public void setSiHkkingakuSisanParamBean(SiHkkingakuSisanParamBean siHkkingakuSisanParamBean) {
        this.siHkkingakuSisanParamBean = siHkkingakuSisanParamBean;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBeanList() {
        return siSiDetailParamBeanList;
    }

    public void setSiSiDetailParamBeanList(List<SiSiDetailParamBean> siSiDetailParamBeanList) {
        this.siSiDetailParamBeanList = siSiDetailParamBeanList;
    }

    public boolean isJisatuMensekiDispFlag() {
        return jisatuMensekiDispFlag;
    }

    public void setJisatuMensekiDispFlag(boolean pJisatuMensekiDispFlag) {
        this.jisatuMensekiDispFlag = pJisatuMensekiDispFlag;
    }

    public boolean isSisankekkaZeimuInfoDispFlag() {
        return sisankekkaZeimuInfoDispFlag;
    }

    public void setSisankekkaZeimuInfoDispFlag(boolean sisankekkaZeimuInfoDispFlag) {
        this.sisankekkaZeimuInfoDispFlag = sisankekkaZeimuInfoDispFlag;
    }

    public boolean isSisankekkaSynykngkDispFlag() {
        return sisankekkaSynykngkDispFlag;
    }

    public void setSisankekkaSynykngkDispFlag(boolean sisankekkaSynykngkDispFlag) {
        this.sisankekkaSynykngkDispFlag = sisankekkaSynykngkDispFlag;
    }

    public boolean isSisankekkaGaikashrsynykngkDispFlag() {
        return sisankekkaGaikashrsynykngkDispFlag;
    }

    public void setSisankekkaGaikashrsynykngkDispFlag(boolean sisankekkaGaikashrsynykngkDispFlag) {
        this.sisankekkaGaikashrsynykngkDispFlag = sisankekkaGaikashrsynykngkDispFlag;
    }

    public boolean isSisankekkaKztkgkDispFlag() {
        return sisankekkaKztkgkDispFlag;
    }

    public void setSisankekkaKztkgkDispFlag(boolean sisankekkaKztkgkDispFlag) {
        this.sisankekkaKztkgkDispFlag = sisankekkaKztkgkDispFlag;
    }

    public boolean isSisankekkaSikinidougakuDispFlag() {
        return sisankekkaSikinidougakuDispFlag;
    }

    public void setSisankekkaSikinidougakuDispFlag(boolean sisankekkaSikinidougakuDispFlag) {
        this.sisankekkaSikinidougakuDispFlag = sisankekkaSikinidougakuDispFlag;
    }

    @Override
    public boolean isViewUketorininsbSeigyo() {
        if (getSbuktnin() != null && getSbuktnin() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSbuktninHyojiHantei() {
        if (getSbuktnin() != null && super.getSbuktnin() > 4) {
            return true;
        }
        return false;
    }
}
