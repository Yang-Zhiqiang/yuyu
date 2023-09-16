package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_BosKoumokuCheckError;


/**
 * 募集項目チェックエラーテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosKoumokuCheckError} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosKoumokuCheckError<br />
 * @see     PKHT_BosKoumokuCheckError<br />
 * @see     QHT_BosKoumokuCheckError<br />
 * @see     GenQHT_BosKoumokuCheckError<br />
 */
@Entity
public class HT_BosKoumokuCheckError extends GenHT_BosKoumokuCheckError {

    private static final long serialVersionUID = 1L;

    public HT_BosKoumokuCheckError() {
    }

    public HT_BosKoumokuCheckError(String pMosno,Integer pRenno3keta) {
        super(pMosno,pRenno3keta);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosKoumokuCheckError.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

}
