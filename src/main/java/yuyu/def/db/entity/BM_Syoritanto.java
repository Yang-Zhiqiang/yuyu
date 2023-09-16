package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.id.PKBM_Syoritanto;
import yuyu.def.db.mapping.GenBM_Syoritanto;
import yuyu.def.db.meta.GenQBM_Syoritanto;
import yuyu.def.db.meta.QBM_Syoritanto;

/**
 * 処理担当マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Syoritanto} の JavaDoc を参照してください。
 * @see     GenBM_Syoritanto
 * @see     PKBM_Syoritanto
 * @see     QBM_Syoritanto
 * @see     GenQBM_Syoritanto
 */
@Entity
public class BM_Syoritanto extends GenBM_Syoritanto {

    private static final long serialVersionUID = 1L;

    public BM_Syoritanto() {
    }

    public BM_Syoritanto(String pSyoricd) {
        super(pSyoricd);
    }

    private BM_TantouCd bM_TantouCd ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_Syoritanto.TANTOCD  , referencedColumnName=BM_TantouCd.TANTOCD, insertable=false, updatable=false)
    })
    public  BM_TantouCd getTantouCd() {
        return bM_TantouCd;
    }

    public void setTantouCd(BM_TantouCd pBM_TantouCd) {
        this.bM_TantouCd = pBM_TantouCd;
    }

}
