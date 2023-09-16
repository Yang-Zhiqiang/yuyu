package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBM_Kouin;


/**
 * 行員マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Kouin} の JavaDoc を参照してください。<br />
 * @see     GenBM_Kouin<br />
 * @see     PKBM_Kouin<br />
 * @see     QBM_Kouin<br />
 * @see     GenQBM_Kouin<br />
 */
@Entity
public class BM_Kouin extends GenBM_Kouin {

    private static final long serialVersionUID = 1L;

    public BM_Kouin() {
    }

    public BM_Kouin(String pKinyuucd,String pKouincd) {
        super(pKinyuucd,pKouincd);
    }



    private BM_Bosyuunin bM_Bosyuunin ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_Kouin.BOSYUUCD  , referencedColumnName=BM_Bosyuunin.BOSYUUCD, insertable=false, updatable=false)
    })
    public  BM_Bosyuunin getBosyuunin() {
        return bM_Bosyuunin;
    }

    public void setBosyuunin(BM_Bosyuunin pBM_Bosyuunin) {
        this.bM_Bosyuunin = pBM_Bosyuunin;
    }

}

