package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenJT_Sk;
import yuyu.def.siharai.predicate.FilterSkJiyuuBySibouymd;
import yuyu.def.siharai.predicate.FilterSkJiyuuByUketukeno;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 請求テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_Sk} の JavaDoc を参照してください。<br />
 * @see     GenJT_Sk<br />
 * @see     PKJT_Sk<br />
 * @see     QJT_Sk<br />
 * @see     GenQJT_Sk<br />
 */
@Entity
public class JT_Sk extends GenJT_Sk {

    private static final long serialVersionUID = 1L;

    public JT_Sk() {
    }

    public JT_Sk(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_Sk.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_Sk.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

    private List<JT_SkJiyuu> jT_SkJiyuus = Lists.newLinkedList();
    public JT_SkJiyuu createSkJiyuu() {
        JT_SkJiyuu skJiyuu =  new JT_SkJiyuu();
        skJiyuu.setSk(this);
        skJiyuu.setSkno(this.getSkno());
        skJiyuu.setSyono(this.getSyono());
        skJiyuu.setSeikyuurirekino(this.getSeikyuurirekino());
        getSkJiyuus().add(skJiyuu);
        return skJiyuu;
    }
    public void setSkJiyuus(List<JT_SkJiyuu> pJT_SkJiyuus) {
        this.jT_SkJiyuus = pJT_SkJiyuus;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SkJiyuu.SKNO+" ASC ,"+JT_SkJiyuu.SYONO+" ASC ,"+JT_SkJiyuu.SEIKYUURIREKINO+" ASC ,"+JT_SkJiyuu.UKETUKENO+" ASC ")
    public  List<JT_SkJiyuu> getSkJiyuus() {
        return jT_SkJiyuus;
    }

    private List<JT_SkHubiMsg> jT_SkHubiMsgs = Lists.newLinkedList();
    public JT_SkHubiMsg createSkHubiMsg() {
        JT_SkHubiMsg skHubiMsg =  new JT_SkHubiMsg();
        skHubiMsg.setSk(this);
        skHubiMsg.setSkno(this.getSkno());
        skHubiMsg.setSyono(this.getSyono());
        skHubiMsg.setSeikyuurirekino(this.getSeikyuurirekino());
        getSkHubiMsgs().add(skHubiMsg);
        return skHubiMsg;
    }
    public void setSkHubiMsgs(List<JT_SkHubiMsg> pJT_SkHubiMsgs) {
        this.jT_SkHubiMsgs = pJT_SkHubiMsgs;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SkHubiMsg.SKNO+" ASC ,"+JT_SkHubiMsg.SYONO+" ASC ,"+JT_SkHubiMsg.SEIKYUURIREKINO+" ASC ,"+JT_SkHubiMsg.RENNO3KETA+" ASC ")
    public  List<JT_SkHubiMsg> getSkHubiMsgs() {
        return jT_SkHubiMsgs;
    }

    private List<JT_MisyuupMkkpDetail> jT_MisyuupMkkpDetails = Lists.newLinkedList();
    public JT_MisyuupMkkpDetail createMisyuupMkkpDetail() {
        JT_MisyuupMkkpDetail misyuupMkkpDetail =  new JT_MisyuupMkkpDetail();
        misyuupMkkpDetail.setSk(this);
        misyuupMkkpDetail.setSkno(this.getSkno());
        misyuupMkkpDetail.setSyono(this.getSyono());
        misyuupMkkpDetail.setSeikyuurirekino(this.getSeikyuurirekino());
        getMisyuupMkkpDetails().add(misyuupMkkpDetail);
        return misyuupMkkpDetail;
    }
    public void setMisyuupMkkpDetails(List<JT_MisyuupMkkpDetail> pJT_MisyuupMkkpDetails) {
        this.jT_MisyuupMkkpDetails = pJT_MisyuupMkkpDetails;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_MisyuupMkkpDetail.SKNO+" ASC ,"+JT_MisyuupMkkpDetail.SYONO+" ASC ,"+JT_MisyuupMkkpDetail.SEIKYUURIREKINO+" ASC ,"+JT_MisyuupMkkpDetail.DATARENNO+" ASC ")
    public  List<JT_MisyuupMkkpDetail> getMisyuupMkkpDetails() {
        return jT_MisyuupMkkpDetails;
    }

    private List<JT_TuusanToutatu> jT_TuusanToutatus = Lists.newLinkedList();
    public JT_TuusanToutatu createTuusanToutatu() {
        JT_TuusanToutatu tuusanToutatu =  new JT_TuusanToutatu();
        tuusanToutatu.setSk(this);
        tuusanToutatu.setSkno(this.getSkno());
        tuusanToutatu.setSyono(this.getSyono());
        tuusanToutatu.setSeikyuurirekino(this.getSeikyuurirekino());
        getTuusanToutatus().add(tuusanToutatu);
        return tuusanToutatu;
    }
    public void setTuusanToutatus(List<JT_TuusanToutatu> pJT_TuusanToutatus) {
        this.jT_TuusanToutatus = pJT_TuusanToutatus;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_TuusanToutatu.SKNO+" ASC ,"+JT_TuusanToutatu.SYONO+" ASC ,"+JT_TuusanToutatu.SEIKYUURIREKINO+" ASC ,"+JT_TuusanToutatu.KYUUHUCD+" ASC ")
    public  List<JT_TuusanToutatu> getTuusanToutatus() {
        return jT_TuusanToutatus;
    }

    private List<JT_NenkinInfo> jT_NenkinInfos = Lists.newLinkedList();
    public JT_NenkinInfo createNenkinInfo() {
        JT_NenkinInfo nenkinInfo =  new JT_NenkinInfo();
        nenkinInfo.setSk(this);
        nenkinInfo.setSkno(this.getSkno());
        nenkinInfo.setSyono(this.getSyono());
        nenkinInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setNenkinInfo(nenkinInfo);
        return nenkinInfo;
    }
    @Transient
    public  JT_NenkinInfo getNenkinInfo() {
        if(getNenkinInfos().size() == 0) {
            return null;
        }
        return getNenkinInfos().get(0);
    }
    @Transient
    public void setNenkinInfo(JT_NenkinInfo pJT_NenkinInfo) {
        if(this.getNenkinInfos().size() >0){
            this.getNenkinInfos().set(0, pJT_NenkinInfo) ;
        }else{
            this.getNenkinInfos().add(pJT_NenkinInfo) ;
        }
    }
    public void setNenkinInfos(List<JT_NenkinInfo> pJT_NenkinInfos) {
        this.jT_NenkinInfos = pJT_NenkinInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_NenkinInfo.SKNO+" ASC ,"+JT_NenkinInfo.SYONO+" ASC ,"+JT_NenkinInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_NenkinInfo> getNenkinInfos() {
        return jT_NenkinInfos;
    }

    private List<JT_SateiIppanHanteiInfo> jT_SateiIppanHanteiInfos = Lists.newLinkedList();
    public JT_SateiIppanHanteiInfo createSateiIppanHanteiInfo() {
        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo =  new JT_SateiIppanHanteiInfo();
        sateiIppanHanteiInfo.setSk(this);
        sateiIppanHanteiInfo.setSkno(this.getSkno());
        sateiIppanHanteiInfo.setSyono(this.getSyono());
        sateiIppanHanteiInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSateiIppanHanteiInfo(sateiIppanHanteiInfo);
        return sateiIppanHanteiInfo;
    }
    @Transient
    public  JT_SateiIppanHanteiInfo getSateiIppanHanteiInfo() {
        if(getSateiIppanHanteiInfos().size() == 0) {
            return null;
        }
        return getSateiIppanHanteiInfos().get(0);
    }
    @Transient
    public void setSateiIppanHanteiInfo(JT_SateiIppanHanteiInfo pJT_SateiIppanHanteiInfo) {
        if(this.getSateiIppanHanteiInfos().size() >0){
            this.getSateiIppanHanteiInfos().set(0, pJT_SateiIppanHanteiInfo) ;
        }else{
            this.getSateiIppanHanteiInfos().add(pJT_SateiIppanHanteiInfo) ;
        }
    }
    public void setSateiIppanHanteiInfos(List<JT_SateiIppanHanteiInfo> pJT_SateiIppanHanteiInfos) {
        this.jT_SateiIppanHanteiInfos = pJT_SateiIppanHanteiInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiIppanHanteiInfo.SKNO+" ASC ,"+JT_SateiIppanHanteiInfo.SYONO+" ASC ,"+JT_SateiIppanHanteiInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SateiIppanHanteiInfo> getSateiIppanHanteiInfos() {
        return jT_SateiIppanHanteiInfos;
    }

    private List<JT_SateiKokuhanInfo> jT_SateiKokuhanInfos = Lists.newLinkedList();
    public JT_SateiKokuhanInfo createSateiKokuhanInfo() {
        JT_SateiKokuhanInfo sateiKokuhanInfo =  new JT_SateiKokuhanInfo();
        sateiKokuhanInfo.setSk(this);
        sateiKokuhanInfo.setSkno(this.getSkno());
        sateiKokuhanInfo.setSyono(this.getSyono());
        sateiKokuhanInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSateiKokuhanInfo(sateiKokuhanInfo);
        return sateiKokuhanInfo;
    }
    @Transient
    public  JT_SateiKokuhanInfo getSateiKokuhanInfo() {
        if(getSateiKokuhanInfos().size() == 0) {
            return null;
        }
        return getSateiKokuhanInfos().get(0);
    }
    @Transient
    public void setSateiKokuhanInfo(JT_SateiKokuhanInfo pJT_SateiKokuhanInfo) {
        if(this.getSateiKokuhanInfos().size() >0){
            this.getSateiKokuhanInfos().set(0, pJT_SateiKokuhanInfo) ;
        }else{
            this.getSateiKokuhanInfos().add(pJT_SateiKokuhanInfo) ;
        }
    }
    public void setSateiKokuhanInfos(List<JT_SateiKokuhanInfo> pJT_SateiKokuhanInfos) {
        this.jT_SateiKokuhanInfos = pJT_SateiKokuhanInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiKokuhanInfo.SKNO+" ASC ,"+JT_SateiKokuhanInfo.SYONO+" ASC ,"+JT_SateiKokuhanInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SateiKokuhanInfo> getSateiKokuhanInfos() {
        return jT_SateiKokuhanInfos;
    }

    private List<JT_SibouSateiChkInfo> jT_SibouSateiChkInfos = Lists.newLinkedList();
    public JT_SibouSateiChkInfo createSibouSateiChkInfo() {
        JT_SibouSateiChkInfo sibouSateiChkInfo =  new JT_SibouSateiChkInfo();
        sibouSateiChkInfo.setSk(this);
        sibouSateiChkInfo.setSkno(this.getSkno());
        sibouSateiChkInfo.setSyono(this.getSyono());
        sibouSateiChkInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSibouSateiChkInfo(sibouSateiChkInfo);
        return sibouSateiChkInfo;
    }
    @Transient
    public  JT_SibouSateiChkInfo getSibouSateiChkInfo() {
        if(getSibouSateiChkInfos().size() == 0) {
            return null;
        }
        return getSibouSateiChkInfos().get(0);
    }
    @Transient
    public void setSibouSateiChkInfo(JT_SibouSateiChkInfo pJT_SibouSateiChkInfo) {
        if(this.getSibouSateiChkInfos().size() >0){
            this.getSibouSateiChkInfos().set(0, pJT_SibouSateiChkInfo) ;
        }else{
            this.getSibouSateiChkInfos().add(pJT_SibouSateiChkInfo) ;
        }
    }
    public void setSibouSateiChkInfos(List<JT_SibouSateiChkInfo> pJT_SibouSateiChkInfos) {
        this.jT_SibouSateiChkInfos = pJT_SibouSateiChkInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SibouSateiChkInfo.SKNO+" ASC ,"+JT_SibouSateiChkInfo.SYONO+" ASC ,"+JT_SibouSateiChkInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SibouSateiChkInfo> getSibouSateiChkInfos() {
        return jT_SibouSateiChkInfos;
    }

    private List<JT_Toriatukaifuryouinfo> jT_Toriatukaifuryouinfos = Lists.newLinkedList();
    public JT_Toriatukaifuryouinfo createToriatukaifuryouinfo() {
        JT_Toriatukaifuryouinfo toriatukaifuryouinfo =  new JT_Toriatukaifuryouinfo();
        toriatukaifuryouinfo.setSk(this);
        toriatukaifuryouinfo.setSkno(this.getSkno());
        toriatukaifuryouinfo.setSyono(this.getSyono());
        toriatukaifuryouinfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setToriatukaifuryouinfo(toriatukaifuryouinfo);
        return toriatukaifuryouinfo;
    }
    @Transient
    public  JT_Toriatukaifuryouinfo getToriatukaifuryouinfo() {
        if(getToriatukaifuryouinfos().size() == 0) {
            return null;
        }
        return getToriatukaifuryouinfos().get(0);
    }
    @Transient
    public void setToriatukaifuryouinfo(JT_Toriatukaifuryouinfo pJT_Toriatukaifuryouinfo) {
        if(this.getToriatukaifuryouinfos().size() >0){
            this.getToriatukaifuryouinfos().set(0, pJT_Toriatukaifuryouinfo) ;
        }else{
            this.getToriatukaifuryouinfos().add(pJT_Toriatukaifuryouinfo) ;
        }
    }
    public void setToriatukaifuryouinfos(List<JT_Toriatukaifuryouinfo> pJT_Toriatukaifuryouinfos) {
        this.jT_Toriatukaifuryouinfos = pJT_Toriatukaifuryouinfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_Toriatukaifuryouinfo.SKNO+" ASC ,"+JT_Toriatukaifuryouinfo.SYONO+" ASC ,"+JT_Toriatukaifuryouinfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_Toriatukaifuryouinfo> getToriatukaifuryouinfos() {
        return jT_Toriatukaifuryouinfos;
    }

    private List<JT_SateiKaijyoInfo> jT_SateiKaijyoInfos = Lists.newLinkedList();
    public JT_SateiKaijyoInfo createSateiKaijyoInfo() {
        JT_SateiKaijyoInfo sateiKaijyoInfo =  new JT_SateiKaijyoInfo();
        sateiKaijyoInfo.setSk(this);
        sateiKaijyoInfo.setSkno(this.getSkno());
        sateiKaijyoInfo.setSyono(this.getSyono());
        sateiKaijyoInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSateiKaijyoInfo(sateiKaijyoInfo);
        return sateiKaijyoInfo;
    }
    @Transient
    public  JT_SateiKaijyoInfo getSateiKaijyoInfo() {
        if(getSateiKaijyoInfos().size() == 0) {
            return null;
        }
        return getSateiKaijyoInfos().get(0);
    }
    @Transient
    public void setSateiKaijyoInfo(JT_SateiKaijyoInfo pJT_SateiKaijyoInfo) {
        if(this.getSateiKaijyoInfos().size() >0){
            this.getSateiKaijyoInfos().set(0, pJT_SateiKaijyoInfo) ;
        }else{
            this.getSateiKaijyoInfos().add(pJT_SateiKaijyoInfo) ;
        }
    }
    public void setSateiKaijyoInfos(List<JT_SateiKaijyoInfo> pJT_SateiKaijyoInfos) {
        this.jT_SateiKaijyoInfos = pJT_SateiKaijyoInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiKaijyoInfo.SKNO+" ASC ,"+JT_SateiKaijyoInfo.SYONO+" ASC ,"+JT_SateiKaijyoInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SateiKaijyoInfo> getSateiKaijyoInfos() {
        return jT_SateiKaijyoInfos;
    }

    private List<JT_SateiMeigihenkouInfo> jT_SateiMeigihenkouInfos = Lists.newLinkedList();
    public JT_SateiMeigihenkouInfo createSateiMeigihenkouInfo() {
        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo =  new JT_SateiMeigihenkouInfo();
        sateiMeigihenkouInfo.setSk(this);
        sateiMeigihenkouInfo.setSkno(this.getSkno());
        sateiMeigihenkouInfo.setSyono(this.getSyono());
        sateiMeigihenkouInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSateiMeigihenkouInfo(sateiMeigihenkouInfo);
        return sateiMeigihenkouInfo;
    }
    @Transient
    public  JT_SateiMeigihenkouInfo getSateiMeigihenkouInfo() {
        if(getSateiMeigihenkouInfos().size() == 0) {
            return null;
        }
        return getSateiMeigihenkouInfos().get(0);
    }
    @Transient
    public void setSateiMeigihenkouInfo(JT_SateiMeigihenkouInfo pJT_SateiMeigihenkouInfo) {
        if(this.getSateiMeigihenkouInfos().size() >0){
            this.getSateiMeigihenkouInfos().set(0, pJT_SateiMeigihenkouInfo) ;
        }else{
            this.getSateiMeigihenkouInfos().add(pJT_SateiMeigihenkouInfo) ;
        }
    }
    public void setSateiMeigihenkouInfos(List<JT_SateiMeigihenkouInfo> pJT_SateiMeigihenkouInfos) {
        this.jT_SateiMeigihenkouInfos = pJT_SateiMeigihenkouInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiMeigihenkouInfo.SKNO+" ASC ,"+JT_SateiMeigihenkouInfo.SYONO+" ASC ,"+JT_SateiMeigihenkouInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SateiMeigihenkouInfo> getSateiMeigihenkouInfos() {
        return jT_SateiMeigihenkouInfos;
    }

    private List<JT_KoudosgSateiChkInfo> jT_KoudosgSateiChkInfos = Lists.newLinkedList();
    public JT_KoudosgSateiChkInfo createKoudosgSateiChkInfo() {
        JT_KoudosgSateiChkInfo koudosgSateiChkInfo =  new JT_KoudosgSateiChkInfo();
        koudosgSateiChkInfo.setSk(this);
        koudosgSateiChkInfo.setSkno(this.getSkno());
        koudosgSateiChkInfo.setSyono(this.getSyono());
        koudosgSateiChkInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setKoudosgSateiChkInfo(koudosgSateiChkInfo);
        return koudosgSateiChkInfo;
    }
    @Transient
    public  JT_KoudosgSateiChkInfo getKoudosgSateiChkInfo() {
        if(getKoudosgSateiChkInfos().size() == 0) {
            return null;
        }
        return getKoudosgSateiChkInfos().get(0);
    }
    @Transient
    public void setKoudosgSateiChkInfo(JT_KoudosgSateiChkInfo pJT_KoudosgSateiChkInfo) {
        if(this.getKoudosgSateiChkInfos().size() >0){
            this.getKoudosgSateiChkInfos().set(0, pJT_KoudosgSateiChkInfo) ;
        }else{
            this.getKoudosgSateiChkInfos().add(pJT_KoudosgSateiChkInfo) ;
        }
    }
    public void setKoudosgSateiChkInfos(List<JT_KoudosgSateiChkInfo> pJT_KoudosgSateiChkInfos) {
        this.jT_KoudosgSateiChkInfos = pJT_KoudosgSateiChkInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_KoudosgSateiChkInfo.SKNO+" ASC ,"+JT_KoudosgSateiChkInfo.SYONO+" ASC ,"+JT_KoudosgSateiChkInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_KoudosgSateiChkInfo> getKoudosgSateiChkInfos() {
        return jT_KoudosgSateiChkInfos;
    }

    private List<JT_BetukutiSateiInfo> jT_BetukutiSateiInfos = Lists.newLinkedList();
    public JT_BetukutiSateiInfo createBetukutiSateiInfo() {
        JT_BetukutiSateiInfo betukutiSateiInfo =  new JT_BetukutiSateiInfo();
        betukutiSateiInfo.setSk(this);
        betukutiSateiInfo.setSkno(this.getSkno());
        betukutiSateiInfo.setSyono(this.getSyono());
        betukutiSateiInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setBetukutiSateiInfo(betukutiSateiInfo);
        return betukutiSateiInfo;
    }
    @Transient
    public  JT_BetukutiSateiInfo getBetukutiSateiInfo() {
        if(getBetukutiSateiInfos().size() == 0) {
            return null;
        }
        return getBetukutiSateiInfos().get(0);
    }
    @Transient
    public void setBetukutiSateiInfo(JT_BetukutiSateiInfo pJT_BetukutiSateiInfo) {
        if(this.getBetukutiSateiInfos().size() >0){
            this.getBetukutiSateiInfos().set(0, pJT_BetukutiSateiInfo) ;
        }else{
            this.getBetukutiSateiInfos().add(pJT_BetukutiSateiInfo) ;
        }
    }
    public void setBetukutiSateiInfos(List<JT_BetukutiSateiInfo> pJT_BetukutiSateiInfos) {
        this.jT_BetukutiSateiInfos = pJT_BetukutiSateiInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_BetukutiSateiInfo.SKNO+" ASC ,"+JT_BetukutiSateiInfo.SYONO+" ASC ,"+JT_BetukutiSateiInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_BetukutiSateiInfo> getBetukutiSateiInfos() {
        return jT_BetukutiSateiInfos;
    }

    private List<JT_KoudosgKeizenChkInfo> jT_KoudosgKeizenChkInfos = Lists.newLinkedList();
    public JT_KoudosgKeizenChkInfo createKoudosgKeizenChkInfo() {
        JT_KoudosgKeizenChkInfo koudosgKeizenChkInfo =  new JT_KoudosgKeizenChkInfo();
        koudosgKeizenChkInfo.setSk(this);
        koudosgKeizenChkInfo.setSkno(this.getSkno());
        koudosgKeizenChkInfo.setSyono(this.getSyono());
        koudosgKeizenChkInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setKoudosgKeizenChkInfo(koudosgKeizenChkInfo);
        return koudosgKeizenChkInfo;
    }
    @Transient
    public  JT_KoudosgKeizenChkInfo getKoudosgKeizenChkInfo() {
        if(getKoudosgKeizenChkInfos().size() == 0) {
            return null;
        }
        return getKoudosgKeizenChkInfos().get(0);
    }
    @Transient
    public void setKoudosgKeizenChkInfo(JT_KoudosgKeizenChkInfo pJT_KoudosgKeizenChkInfo) {
        if(this.getKoudosgKeizenChkInfos().size() >0){
            this.getKoudosgKeizenChkInfos().set(0, pJT_KoudosgKeizenChkInfo) ;
        }else{
            this.getKoudosgKeizenChkInfos().add(pJT_KoudosgKeizenChkInfo) ;
        }
    }
    public void setKoudosgKeizenChkInfos(List<JT_KoudosgKeizenChkInfo> pJT_KoudosgKeizenChkInfos) {
        this.jT_KoudosgKeizenChkInfos = pJT_KoudosgKeizenChkInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_KoudosgKeizenChkInfo.SKNO+" ASC ,"+JT_KoudosgKeizenChkInfo.SYONO+" ASC ,"+JT_KoudosgKeizenChkInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_KoudosgKeizenChkInfo> getKoudosgKeizenChkInfos() {
        return jT_KoudosgKeizenChkInfos;
    }

    private List<JT_SdsGizouKaizanInfo> jT_SdsGizouKaizanInfos = Lists.newLinkedList();
    public JT_SdsGizouKaizanInfo createSdsGizouKaizanInfo() {
        JT_SdsGizouKaizanInfo sdsGizouKaizanInfo =  new JT_SdsGizouKaizanInfo();
        sdsGizouKaizanInfo.setSk(this);
        sdsGizouKaizanInfo.setSkno(this.getSkno());
        sdsGizouKaizanInfo.setSyono(this.getSyono());
        sdsGizouKaizanInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSdsGizouKaizanInfo(sdsGizouKaizanInfo);
        return sdsGizouKaizanInfo;
    }
    @Transient
    public  JT_SdsGizouKaizanInfo getSdsGizouKaizanInfo() {
        if(getSdsGizouKaizanInfos().size() == 0) {
            return null;
        }
        return getSdsGizouKaizanInfos().get(0);
    }
    @Transient
    public void setSdsGizouKaizanInfo(JT_SdsGizouKaizanInfo pJT_SdsGizouKaizanInfo) {
        if(this.getSdsGizouKaizanInfos().size() >0){
            this.getSdsGizouKaizanInfos().set(0, pJT_SdsGizouKaizanInfo) ;
        }else{
            this.getSdsGizouKaizanInfos().add(pJT_SdsGizouKaizanInfo) ;
        }
    }
    public void setSdsGizouKaizanInfos(List<JT_SdsGizouKaizanInfo> pJT_SdsGizouKaizanInfos) {
        this.jT_SdsGizouKaizanInfos = pJT_SdsGizouKaizanInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SdsGizouKaizanInfo.SKNO+" ASC ,"+JT_SdsGizouKaizanInfo.SYONO+" ASC ,"+JT_SdsGizouKaizanInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SdsGizouKaizanInfo> getSdsGizouKaizanInfos() {
        return jT_SdsGizouKaizanInfos;
    }

    private List<JT_KoudosgJytGtKahi> jT_KoudosgJytGtKahis = Lists.newLinkedList();
    public JT_KoudosgJytGtKahi createKoudosgJytGtKahi() {
        JT_KoudosgJytGtKahi koudosgJytGtKahi =  new JT_KoudosgJytGtKahi();
        koudosgJytGtKahi.setSk(this);
        koudosgJytGtKahi.setSkno(this.getSkno());
        koudosgJytGtKahi.setSyono(this.getSyono());
        koudosgJytGtKahi.setSeikyuurirekino(this.getSeikyuurirekino());
        setKoudosgJytGtKahi(koudosgJytGtKahi);
        return koudosgJytGtKahi;
    }
    @Transient
    public  JT_KoudosgJytGtKahi getKoudosgJytGtKahi() {
        if(getKoudosgJytGtKahis().size() == 0) {
            return null;
        }
        return getKoudosgJytGtKahis().get(0);
    }
    @Transient
    public void setKoudosgJytGtKahi(JT_KoudosgJytGtKahi pJT_KoudosgJytGtKahi) {
        if(this.getKoudosgJytGtKahis().size() >0){
            this.getKoudosgJytGtKahis().set(0, pJT_KoudosgJytGtKahi) ;
        }else{
            this.getKoudosgJytGtKahis().add(pJT_KoudosgJytGtKahi) ;
        }
    }
    public void setKoudosgJytGtKahis(List<JT_KoudosgJytGtKahi> pJT_KoudosgJytGtKahis) {
        this.jT_KoudosgJytGtKahis = pJT_KoudosgJytGtKahis;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_KoudosgJytGtKahi.SKNO+" ASC ,"+JT_KoudosgJytGtKahi.SYONO+" ASC ,"+JT_KoudosgJytGtKahi.SEIKYUURIREKINO+" ASC ")
    public  List<JT_KoudosgJytGtKahi> getKoudosgJytGtKahis() {
        return jT_KoudosgJytGtKahis;
    }

    private List<JT_SateiJyuukasituChkInfo> jT_SateiJyuukasituChkInfos = Lists.newLinkedList();
    public JT_SateiJyuukasituChkInfo createSateiJyuukasituChkInfo() {
        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo =  new JT_SateiJyuukasituChkInfo();
        sateiJyuukasituChkInfo.setSk(this);
        sateiJyuukasituChkInfo.setSkno(this.getSkno());
        sateiJyuukasituChkInfo.setSyono(this.getSyono());
        sateiJyuukasituChkInfo.setSeikyuurirekino(this.getSeikyuurirekino());
        setSateiJyuukasituChkInfo(sateiJyuukasituChkInfo);
        return sateiJyuukasituChkInfo;
    }
    @Transient
    public  JT_SateiJyuukasituChkInfo getSateiJyuukasituChkInfo() {
        if(getSateiJyuukasituChkInfos().size() == 0) {
            return null;
        }
        return getSateiJyuukasituChkInfos().get(0);
    }
    @Transient
    public void setSateiJyuukasituChkInfo(JT_SateiJyuukasituChkInfo pJT_SateiJyuukasituChkInfo) {
        if(this.getSateiJyuukasituChkInfos().size() >0){
            this.getSateiJyuukasituChkInfos().set(0, pJT_SateiJyuukasituChkInfo) ;
        }else{
            this.getSateiJyuukasituChkInfos().add(pJT_SateiJyuukasituChkInfo) ;
        }
    }
    public void setSateiJyuukasituChkInfos(List<JT_SateiJyuukasituChkInfo> pJT_SateiJyuukasituChkInfos) {
        this.jT_SateiJyuukasituChkInfos = pJT_SateiJyuukasituChkInfos;
    }
    @OneToMany (
        mappedBy = "sk",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiJyuukasituChkInfo.SKNO+" ASC ,"+JT_SateiJyuukasituChkInfo.SYONO+" ASC ,"+JT_SateiJyuukasituChkInfo.SEIKYUURIREKINO+" ASC ")
    public  List<JT_SateiJyuukasituChkInfo> getSateiJyuukasituChkInfos() {
        return jT_SateiJyuukasituChkInfos;
    }

    @Transient
    public  List<JT_SkJiyuu> getSkJiyuusBySibouymd(BizDate pHasseiymd) {
        return new ArrayList<JT_SkJiyuu>(Collections2.filter(getSkJiyuus(),
            new FilterSkJiyuuBySibouymd(pHasseiymd)));
    }
    @Transient
    public  JT_SkJiyuu getSkJiyuuByUketukeno(Integer pUketukeno) {
        return Iterables.getFirst(Iterables.filter(getSkJiyuus(),
            new FilterSkJiyuuByUketukeno(pUketukeno)), null);
    }
}

