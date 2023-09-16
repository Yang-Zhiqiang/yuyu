package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenMT_SousaRireki;

import com.google.common.collect.Lists;


/**
 * 操作履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_SousaRireki} の JavaDoc を参照してください。<br />
 * @see     GenMT_SousaRireki<br />
 * @see     PKMT_SousaRireki<br />
 * @see     QMT_SousaRireki<br />
 * @see     GenQMT_SousaRireki<br />
 */
@Entity
public class MT_SousaRireki extends GenMT_SousaRireki {

    private static final long serialVersionUID = 1L;

    public MT_SousaRireki() {
    }

    public MT_SousaRireki(String pTtdksikibetuid) {
        super(pTtdksikibetuid);
    }



    private List<MT_SousaRirekiSyousai> mT_SousaRirekiSyousais = Lists.newLinkedList();
    public MT_SousaRirekiSyousai createSousaRirekiSyousai() {
        MT_SousaRirekiSyousai sousaRirekiSyousai =  new MT_SousaRirekiSyousai();
        sousaRirekiSyousai.setSousaRireki(this);
        sousaRirekiSyousai.setTtdksikibetuid(this.getTtdksikibetuid());
        getSousaRirekiSyousais().add(sousaRirekiSyousai);
        return sousaRirekiSyousai;
    }
    public void setSousaRirekiSyousais(List<MT_SousaRirekiSyousai> pMT_SousaRirekiSyousais) {
        this.mT_SousaRirekiSyousais = pMT_SousaRirekiSyousais;
    }
    @OneToMany (
        mappedBy = "sousaRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_SousaRirekiSyousai.TTDKSIKIBETUID+" ASC ,"+MT_SousaRirekiSyousai.SOUSARIREKIRENNO+" ASC ")
    public  List<MT_SousaRirekiSyousai> getSousaRirekiSyousais() {
        return mT_SousaRirekiSyousais;
    }

    private List<MT_SousaRirekiIvrInfo> mT_SousaRirekiIvrInfos = Lists.newLinkedList();
    public MT_SousaRirekiIvrInfo createSousaRirekiIvrInfo() {
        MT_SousaRirekiIvrInfo sousaRirekiIvrInfo =  new MT_SousaRirekiIvrInfo();
        sousaRirekiIvrInfo.setSousaRireki(this);
        sousaRirekiIvrInfo.setTtdksikibetuid(this.getTtdksikibetuid());
        setSousaRirekiIvrInfo(sousaRirekiIvrInfo);
        return sousaRirekiIvrInfo;
    }
    @Transient
    public  MT_SousaRirekiIvrInfo getSousaRirekiIvrInfo() {
        if(getSousaRirekiIvrInfos().size() == 0) {
            return null;
        }
        return getSousaRirekiIvrInfos().get(0);
    }
    @Transient
    public void setSousaRirekiIvrInfo(MT_SousaRirekiIvrInfo pMT_SousaRirekiIvrInfo) {
        if(this.getSousaRirekiIvrInfos().size() >0){
            this.getSousaRirekiIvrInfos().set(0, pMT_SousaRirekiIvrInfo) ;
        }else{
            this.getSousaRirekiIvrInfos().add(pMT_SousaRirekiIvrInfo) ;
        }
    }
    public void setSousaRirekiIvrInfos(List<MT_SousaRirekiIvrInfo> pMT_SousaRirekiIvrInfos) {
        this.mT_SousaRirekiIvrInfos = pMT_SousaRirekiIvrInfos;
    }
    @OneToMany (
        mappedBy = "sousaRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_SousaRirekiIvrInfo.TTDKSIKIBETUID+" ASC ")
    public  List<MT_SousaRirekiIvrInfo> getSousaRirekiIvrInfos() {
        return mT_SousaRirekiIvrInfos;
    }

}

