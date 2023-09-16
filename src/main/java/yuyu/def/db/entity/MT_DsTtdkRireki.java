package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenMT_DsTtdkRireki;

import com.google.common.collect.Lists;

/**
 * ＤＳ手続履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsTtdkRireki} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsTtdkRireki<br />
 * @see     PKMT_DsTtdkRireki<br />
 * @see     QMT_DsTtdkRireki<br />
 * @see     GenQMT_DsTtdkRireki<br />
 */
@Entity
public class MT_DsTtdkRireki extends GenMT_DsTtdkRireki {

    private static final long serialVersionUID = 1L;

    public MT_DsTtdkRireki() {
    }

    public MT_DsTtdkRireki(String pDskokno,String pHenkousikibetukey) {
        super(pDskokno,pHenkousikibetukey);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsTtdkRireki.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

    private List<MT_DsHenkouRireki> mT_DsHenkouRirekis = Lists.newLinkedList();
    public MT_DsHenkouRireki createDsHenkouRireki() {
        MT_DsHenkouRireki dsHenkouRireki =  new MT_DsHenkouRireki();
        dsHenkouRireki.setDsTtdkRireki(this);
        dsHenkouRireki.setDskokno(this.getDskokno());
        dsHenkouRireki.setHenkousikibetukey(this.getHenkousikibetukey());
        getDsHenkouRirekis().add(dsHenkouRireki);
        return dsHenkouRireki;
    }
    public void setDsHenkouRirekis(List<MT_DsHenkouRireki> pMT_DsHenkouRirekis) {
        this.mT_DsHenkouRirekis = pMT_DsHenkouRirekis;
    }
    @OneToMany (
        mappedBy = "dsTtdkRireki",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHenkouRireki.DSKOKNO+" ASC ,"+MT_DsHenkouRireki.HENKOUSIKIBETUKEY+" ASC ,"+MT_DsHenkouRireki.RENNO+" ASC ")
    public  List<MT_DsHenkouRireki> getDsHenkouRirekis() {
        return mT_DsHenkouRirekis;
    }

}

