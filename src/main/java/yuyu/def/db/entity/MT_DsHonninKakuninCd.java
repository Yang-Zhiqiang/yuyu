package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_DsHonninKakuninCd;

/**
 * ＤＳ本人確認コードテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHonninKakuninCd} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsHonninKakuninCd<br />
 * @see     PKMT_DsHonninKakuninCd<br />
 * @see     QMT_DsHonninKakuninCd<br />
 * @see     GenQMT_DsHonninKakuninCd<br />
 */
@Entity
public class MT_DsHonninKakuninCd extends GenMT_DsHonninKakuninCd {

    private static final long serialVersionUID = 1L;

    public MT_DsHonninKakuninCd() {
    }

    public MT_DsHonninKakuninCd(String pDskokno) {
        super(pDskokno);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHonninKakuninCd.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

