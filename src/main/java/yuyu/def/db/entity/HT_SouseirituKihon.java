package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenHT_SouseirituKihon;

import com.google.common.collect.Lists;


/**
 * 総成立基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SouseirituKihon} の JavaDoc を参照してください。<br />
 * @see     GenHT_SouseirituKihon<br />
 * @see     PKHT_SouseirituKihon<br />
 * @see     QHT_SouseirituKihon<br />
 * @see     GenQHT_SouseirituKihon<br />
 */
@Entity
public class HT_SouseirituKihon extends GenHT_SouseirituKihon {

    private static final long serialVersionUID = 1L;

    public HT_SouseirituKihon() {
    }

    public HT_SouseirituKihon(String pSyono) {
        super(pSyono);
    }



    private List<HT_SouseirituSyouhin> hT_SouseirituSyouhins = Lists.newLinkedList();
    public HT_SouseirituSyouhin createSouseirituSyouhin() {
        HT_SouseirituSyouhin souseirituSyouhin =  new HT_SouseirituSyouhin();
        souseirituSyouhin.setSouseirituKihon(this);
        souseirituSyouhin.setSyono(this.getSyono());
        getSouseirituSyouhins().add(souseirituSyouhin);
        return souseirituSyouhin;
    }
    public void setSouseirituSyouhins(List<HT_SouseirituSyouhin> pHT_SouseirituSyouhins) {
        this.hT_SouseirituSyouhins = pHT_SouseirituSyouhins;
    }
    @OneToMany (
        mappedBy = "souseirituKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_SouseirituSyouhin.SYONO+" ASC ,"+HT_SouseirituSyouhin.SYOUHNCD+" ASC ")
    public  List<HT_SouseirituSyouhin> getSouseirituSyouhins() {
        return hT_SouseirituSyouhins;
    }

    private List<HT_SouseirituDairiten> hT_SouseirituDairitens = Lists.newLinkedList();
    public HT_SouseirituDairiten createSouseirituDairiten() {
        HT_SouseirituDairiten souseirituDairiten =  new HT_SouseirituDairiten();
        souseirituDairiten.setSouseirituKihon(this);
        souseirituDairiten.setSyono(this.getSyono());
        getSouseirituDairitens().add(souseirituDairiten);
        return souseirituDairiten;
    }
    public void setSouseirituDairitens(List<HT_SouseirituDairiten> pHT_SouseirituDairitens) {
        this.hT_SouseirituDairitens = pHT_SouseirituDairitens;
    }
    @OneToMany (
        mappedBy = "souseirituKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_SouseirituDairiten.SYONO+" ASC ,"+HT_SouseirituDairiten.RENNO+" ASC ")
    public  List<HT_SouseirituDairiten> getSouseirituDairitens() {
        return hT_SouseirituDairitens;
    }

}

