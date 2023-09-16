package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenBT_HituyouSyoruiKanri;


/**
 * 必要書類管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HituyouSyoruiKanri} の JavaDoc を参照してください。<br />
 * @see     GenBT_HituyouSyoruiKanri<br />
 * @see     PKBT_HituyouSyoruiKanri<br />
 * @see     QBT_HituyouSyoruiKanri<br />
 * @see     GenQBT_HituyouSyoruiKanri<br />
 */
@Entity
public class BT_HituyouSyoruiKanri extends GenBT_HituyouSyoruiKanri {

    private static final long serialVersionUID = 1L;

    public BT_HituyouSyoruiKanri() {
    }

    public BT_HituyouSyoruiKanri(String pKouteikanriid,C_SyoruiCdKbn pSyoruiCd) {
        super(pKouteikanriid,pSyoruiCd);
    }



    private BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=BT_HituyouSyoruiKanri.KOUTEIKANRIID  , referencedColumnName=BT_GyoumuKouteiInfo.KOUTEIKANRIID, insertable=false, updatable=false)
    })
    public BT_GyoumuKouteiInfo getGyoumuKouteiInfo() {
        return bT_GyoumuKouteiInfo;
    }

    public void setGyoumuKouteiInfo(BT_GyoumuKouteiInfo pBT_GyoumuKouteiInfo) {
        this.bT_GyoumuKouteiInfo = pBT_GyoumuKouteiInfo;
    }

}

