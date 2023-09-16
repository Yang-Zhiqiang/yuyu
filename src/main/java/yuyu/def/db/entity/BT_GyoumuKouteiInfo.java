package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenBT_GyoumuKouteiInfo;

import com.google.common.collect.Lists;


/**
 * 業務用工程情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_GyoumuKouteiInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_GyoumuKouteiInfo<br />
 * @see     PKBT_GyoumuKouteiInfo<br />
 * @see     QBT_GyoumuKouteiInfo<br />
 * @see     GenQBT_GyoumuKouteiInfo<br />
 */
@Entity
public class BT_GyoumuKouteiInfo extends GenBT_GyoumuKouteiInfo {

    private static final long serialVersionUID = 1L;

    public BT_GyoumuKouteiInfo() {
    }

    public BT_GyoumuKouteiInfo(String pKouteikanriid) {
        super(pKouteikanriid);
    }



    private List<BT_HituyouSyoruiKanri> bT_HituyouSyoruiKanris = Lists.newLinkedList();
    public BT_HituyouSyoruiKanri createHituyouSyoruiKanri() {
        BT_HituyouSyoruiKanri hituyouSyoruiKanri =  new BT_HituyouSyoruiKanri();
        hituyouSyoruiKanri.setGyoumuKouteiInfo(this);
        hituyouSyoruiKanri.setKouteikanriid(this.getKouteikanriid());
        getHituyouSyoruiKanris().add(hituyouSyoruiKanri);
        return hituyouSyoruiKanri;
    }
    public void setHituyouSyoruiKanris(List<BT_HituyouSyoruiKanri> pBT_HituyouSyoruiKanris) {
        this.bT_HituyouSyoruiKanris = pBT_HituyouSyoruiKanris;
    }
    @OneToMany (
        mappedBy = "gyoumuKouteiInfo",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(BT_HituyouSyoruiKanri.KOUTEIKANRIID+" ASC ,"+BT_HituyouSyoruiKanri.SYORUICD+" ASC ")
    public  List<BT_HituyouSyoruiKanri> getHituyouSyoruiKanris() {
        return bT_HituyouSyoruiKanris;
    }

}

